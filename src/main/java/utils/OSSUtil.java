package utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @Auther: liuhao
 * @Date: 2019/2/20 13:44
 * @Description:
 */
public class OSSUtil {

    private static String accessKey = "z0k-_cFcsHvazaUd5RGNBoBE4En_b4ysAttB3F7d";
    private static String secretKey = "FREtJktSMIp1UEbnNaMC3m_6kFR4dgBhCM-X8zoq";
    private static String bucket = "saas-hrm";

    public static String upload(byte[] uploadBytes,String key) {
        Configuration cfg = new Configuration(Zone.zone1());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(uploadBytes, key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet.key;
        }catch (QiniuException e) {
            e.printStackTrace();
            return null;
        }
    }

}
