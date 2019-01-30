package com.saas.hrm.interceptor;

import com.alibaba.fastjson.JSON;
import com.saas.hrm.response.Result;
import com.saas.hrm.response.ResultEnum;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 16:06
 * @Description:
 */
@Component
public class JWTInterceptor extends HandlerInterceptorAdapter {

    @Value("${jwt.sign.key}")
    private String key;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","application/json");
        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            response.getWriter().write(JSON.toJSONString(new Result<>(ResultEnum.TOKEN_ERROR.getCode(),
                    ResultEnum.TOKEN_ERROR.getMessage(),null)));
            return false;
        }
        if (!token.startsWith("Bearer ")) {
            response.getWriter().write(JSON.toJSONString(new Result<>(ResultEnum.TOKEN_ERROR.getCode(),
                    ResultEnum.TOKEN_ERROR.getMessage(),null)));
            return false;
        }
        token = token.split(" ")[1];
        Jws<Claims> jws;
        try {
            jws = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        } catch (JwtException e) {
            response.getWriter().write(JSON.toJSONString(new Result<>(ResultEnum.TOKEN_ERROR.getCode(),
                    ResultEnum.TOKEN_ERROR.getMessage(),null)));
            return false;
        }
        List<String> apiList = (List<String>) jws.getBody().get("api");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String name = handlerMethod.getMethodAnnotation(RequestMapping.class).name();
        if (!apiList.contains(name)) {
            response.getWriter().write(JSON.toJSONString(new Result<>(ResultEnum.PERMISSION_ERROR.getCode(),
                    ResultEnum.PERMISSION_ERROR.getMessage(),null)));
            return false;
        }
        return true;
    }
}
