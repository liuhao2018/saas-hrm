package com.saas.hrm.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DownloadUtils {
    public void download(ByteArrayOutputStream byteArrayOutputStream, HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition","attachment;filename=employee.xlsx");
        response.setContentLength(byteArrayOutputStream.size());
        response.addHeader("Content-Length", "" + byteArrayOutputStream.size());
        ServletOutputStream outputstream = response.getOutputStream();
        byteArrayOutputStream.writeTo(outputstream);
        byteArrayOutputStream.close();
        outputstream.flush();
    }
}
