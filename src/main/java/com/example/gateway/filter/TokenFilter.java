package com.example.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        //SpringCloud网关修改请求头使微服务获取客户端真实ip
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String remoteAddr = request.getRemoteAddr();
        ctx.getZuulRequestHeaders().put("HTTP_X_FORWARDED_FOR", remoteAddr);

        System.out.println("China");
        RequestContext currentContext = RequestContext.getCurrentContext();
        String token = currentContext.getRequest().getHeader("TOKEN");
        if (StringUtils.isEmpty(token)) {
            System.out.println("token is null");
        }


        return "x";
    }
}
