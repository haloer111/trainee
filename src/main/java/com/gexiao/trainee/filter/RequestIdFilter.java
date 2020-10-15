package com.gexiao.trainee.filter;

import com.gexiao.trainee.context.RequestIdContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * RequestId的拦截器
 * 作用：获取header中的requestId，存放到{@link com.gexiao.trainee.context.RequestIdContext} 和 {@link org.slf4j.MDC} 中
 */
@Slf4j
@Component
public class RequestIdFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestId = ((HttpServletRequest) servletRequest).getHeader(RequestIdContext.REQUEST_ID_KEY);

        requestId = Optional.ofNullable(requestId).orElse(RequestIdContext.init());
        MDC.put(RequestIdContext.REQUEST_ID_MDC_KEY, requestId);

        log.info("RequestIdFilter获取到的requestId = {}", requestId);

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.clear();
        }
    }
}
