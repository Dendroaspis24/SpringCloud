package com.dhh.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.Request;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 自定义一个过滤器，不含token信息的请求不允许往下走
 * @Author: dinghaohui
 * @param
 * @Date: 2020/1/6 17:58
 * @Version: 1.0
 */
//继承zuulfifter类
public class TokenFilter extends ZuulFilter {
    /**
     * 过滤器的类型，决定过滤器在周期的哪个阶段执行
     * 这里定义为pre,代表会在请求被路由之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * fifter执行顺序，数字越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。
     * 实际运用中我们可以利用该函数来指定过滤器的有效范围。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest reqeust = ctx.getRequest();

        String token = reqeust.getParameter("token");
        if(StringUtils.isBlank(token)){
            ctx.setSendZuulResponse(false);//令 Zuul 过滤该请求,不对其进行路由
            ctx.setResponseStatusCode(401);//设置错误码
            ctx.setResponseBody("token is empty!");
            ctx.setResponseBody("12421421");
        }
        return null;
    }
}
