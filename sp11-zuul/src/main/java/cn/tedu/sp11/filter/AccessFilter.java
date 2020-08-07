package cn.tedu.sp11.filter;

import cn.tedu.web.util.JsonResult;
import com.netflix.discovery.util.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ljz
 * @Date   2020-08-05
 */
public class AccessFilter extends ZuulFilter {

    /**
     * 过滤器的类型: 前置.后置,路由 ,错误.
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     *过滤器添加的顺序号
     * 返回6,加到第6个位置
     * @return
     */
    @Override
    public int filterOrder() {
        return 6;
    }

    /**
     *针对当前请求进行判断，判断当前请求是否要执行这个过滤器的过滤代码
     *如果访问 item-service 要检查权限
     *如果访问其他服务则不检查权限，直接访问
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //获得当前请求的服务id
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        String item = "item-service";
        if(serviceId.equals(item)) {
            //执行权限过滤
            return true;
        }
        //跳过过滤代码不执行
        return false;
    }

    /**
     *过滤代码, 对用户权限进行检查
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // http://localhost:3001/item-service/245t243t2?token=k4jh3424g2
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        String token = req.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            // 没有token,组织继续调用
            ctx.setSendZuulResponse(false);
            // 发送提示, 提示用户没有登录
            ctx.setResponseStatusCode(JsonResult.NOT_LOGIN);
            ctx.setResponseBody(JsonResult.err().code(JsonResult.NOT_LOGIN).msg("not login!").toString());
        }
        // zuul过度设计, 返回值在现在的版本中没有使用
        return null;
    }

}
