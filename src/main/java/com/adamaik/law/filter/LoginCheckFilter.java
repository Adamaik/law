package com.adamaik.law.filter;

import com.adamaik.law.pojo.Result;
import com.adamaik.law.utils.JwtUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Adamaik
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取请求url
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;
        String url = httpServletRequest.getRequestURL().toString();
        log.info("请求的url：{}",url);
        //判断是否包含login请求
        if(url.contains("login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String jwt = httpServletRequest.getHeader("token");
        //利用工具类快速判断jwt是否为空或空字符串
        if((!StringUtils.hasLength(jwt))||"null".equals(jwt)){
            log.info("用户未登录");
            returnNotLogin(httpServletResponse);
            return;
        }
        try{
            JwtUtils.parseJWT(jwt);
        }catch(Exception e){
            log.info("解析令牌失败，返回未登录信息");
            returnNotLogin(httpServletResponse);
            return;
        }
        //放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }
    public void returnNotLogin(HttpServletResponse httpServletResponse) throws IOException {
        Result error = Result.error("NOT_LOGIN");
        //此处不是Controller中，需要手动将对象转换为字符串-----？阿里巴巴fastJSON
        String notLogin= JSONObject.toJSONString(error);
        httpServletResponse.getWriter().write(notLogin);
    }
}
