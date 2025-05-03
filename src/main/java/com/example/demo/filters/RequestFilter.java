package com.example.demo.filters;

import com.example.demo.commons.http.REQUEST_CUSTOM_FIELDS;
import com.example.demo.commons.logging.MDC_CUSTOM_FIELDS;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String traceId = UUID.randomUUID().toString();
        MDC.put(MDC_CUSTOM_FIELDS.TRACE_ID.getValue(), traceId);
        try {
            request.setAttribute(REQUEST_CUSTOM_FIELDS.TRACE_ID.getValue(), traceId);
            request.setAttribute(REQUEST_CUSTOM_FIELDS.REQUEST_TIMESTAMP.getValue(), System.nanoTime());
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(MDC_CUSTOM_FIELDS.TRACE_ID.getValue());
        }
    }
}
