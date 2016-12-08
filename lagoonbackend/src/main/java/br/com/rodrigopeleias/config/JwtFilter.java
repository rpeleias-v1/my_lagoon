package br.com.rodrigopeleias.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter {

    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        final HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        final String authHeader = httpServletRequest.getHeader("authorization");

        if("OPTIONS".equals(httpServletRequest.getMethod())) {
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        } else {

            if (authHeader == null || authHeader.startsWith("Bearer ")) {
                throw new ServletException("Missing or invalid authorization header");
            }

            final String token = authHeader.substring(7);

            try {
                final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
                request.setAttribute("claims", claims);
            } catch (final SignatureException e) {
                throw new ServletException("Invalid token");
            }
        }
    }
}
