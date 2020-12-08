package com.hzm.springcloudzuulhystrixdemo.Fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author
 * @createTime 2020/12/8 20:40
 * 对服务feign-service-pro 进行服务降级
 */
@Component
public class FeignServiceProFallBack implements FallbackProvider {
    /**
     * 给那个服务降级
     * @return
     *        *代表给所有服务降级
     */
    @Override
    public String getRoute() {
        return "feign-service-pro";
    }

    /**
     * /**
     * * 当服务无法执行时，该方法返回托底信息
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        /**
         * ClientHttpResponse 的 fallback 的状态码 返回
         HttpStatus
         */
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            /**
             * ClientHttpResponse 的 fallback 的状态码 返回 int
             * **
             **/
            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }


            /**
             * ClientHttpResponse 的 fallback 的状态码 返回 String
             */
            @Override
            public String getStatusText() throws IOException {

                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 设置响应体
             */
            @Override
            public InputStream getBody() throws IOException {
                String content = "来自zuul的服务降级使用方法!";
                return new
                        ByteArrayInputStream(content.getBytes());
            }

            /**
             * 设置响应的头信息
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders header = new HttpHeaders();
                MediaType mt = new
                        MediaType("application","json", Charset.forName("utf-8"));
                header.setContentType(mt);
                return header;
            }
        };
    }
}
