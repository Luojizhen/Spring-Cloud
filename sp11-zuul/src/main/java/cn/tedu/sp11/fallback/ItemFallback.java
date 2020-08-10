package cn.tedu.sp11.fallback;

import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ljz
 * @Date   2020-08-05
 */
@Slf4j
@Component
public class ItemFallback implements FallbackProvider {

    /**
     * 当前字符串, 对哪个服务有效
     * 如果返回"item-service" 那么当前降级类只对商品服务有效
     * 如果返回 "*" , 那么对所有服务有效
     * @return
     */
    @Override
    public String getRoute() {
        //当执行item-service失败，
        //应用当前这个降级类
        return "item-service";
    }

    /**
     * 响应结果
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {

            //返回status对象 , {200,"ok"}
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            //返回状态码 200
            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            //返回一个文本 "ok"
            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                String s = JsonResult.err().msg("获取商品列表失败!").toString();
                return new ByteArrayInputStream(s.getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                //Content-Type : application/json
                HttpHeaders h = new HttpHeaders();
                h.setContentType(MediaType.APPLICATION_JSON);
                return h;
            }
        };
    }
}
