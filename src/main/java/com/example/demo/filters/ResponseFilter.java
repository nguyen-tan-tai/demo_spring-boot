package com.example.demo.filters;

import com.example.demo.commons.http.REQUEST_CUSTOM_FIELDS;
import com.example.demo.commons.http.RESPONSE_CUSTOM_HEADER_FIELDS;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class ResponseFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        response.setHeader(RESPONSE_CUSTOM_HEADER_FIELDS.TRACE_ID.getValue(), (String) request.getAttribute(REQUEST_CUSTOM_FIELDS.TRACE_ID.getValue()));
        long requestTime = (long) request.getAttribute(REQUEST_CUSTOM_FIELDS.REQUEST_TIMESTAMP.getValue());
        response.setHeader(RESPONSE_CUSTOM_HEADER_FIELDS.PROCESS_TIME.getValue(), Long.toString(System.nanoTime() - requestTime));
        filterChain.doFilter(request, response);
    }
}
