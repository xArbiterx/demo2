package com.example.demo2.config.auth;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

    /**
     * 拒绝连接给的信息
     * @return 在 isAccessAllowed 后再次判定返回是否接入
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        //返回给前端的json
        JsonObject jsonObject = new JsonObject();
        //用来打印返回给前端的json的写入器
        PrintWriter out = null;
        //转http形态获取某些参数
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        try {
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
            if(req.getAuthType() == null){
                //没有登陆的
                res.setStatus(HttpStatus.UNAUTHORIZED.value());
                jsonObject.addProperty("message", "UNAUTHORIZED");
            } else {
                //没有权限的
                res.setStatus(HttpStatus.FORBIDDEN.value());
                jsonObject.addProperty("message", "FORBIDDEN");
            }

            //从response获得写入器
            out = response.getWriter();
            out.println(jsonObject);
        } catch (Exception e) {
            //鉴权中出了问题（比如writer没拿到）
            log.error("auth err", e);
        } finally {
            //如果用了写入器就把它关了
            if (null != out) {
                out.flush();
                out.close();
            }
        }
        return false;
    }

    /**
     * 权限判断 给true无脑PASS 要加验证
     * @param mappedValue 权限
     * @return 是否直接通过鉴权
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = this.getSubject(request, response);
        return !subject.isAuthenticated() || subject.getPrincipal() != null || super.isPermissive(mappedValue);
    }

}
