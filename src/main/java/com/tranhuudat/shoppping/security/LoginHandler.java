package com.tranhuudat.shoppping.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
public class LoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private String targetUrl(Authentication authentication) {
        String url = "";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority());
        }
        if (roles.contains("ADMIN")) {
            url = "/admin/home";
        } else if (roles.contains("USER")) {
            url = "/home";
        }
        return url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        String targetUrl = targetUrl(authentication);
        HttpSession session = request.getSession();
        if (targetUrl == "/admin/home") {
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
        } else {
            if (session != null) {
                String redirectUrl = (String) session.getAttribute("url_prior");
                if (redirectUrl != null && !redirectUrl.contains("/signup")) {
                    session.removeAttribute("url_prior");
                    if (targetUrl == "/home" && redirectUrl.contains("/login")) {
                        getRedirectStrategy().sendRedirect(request, response, targetUrl);
                    } else {
                        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
                    }
                } else {
                    getRedirectStrategy().sendRedirect(request, response, targetUrl);
                }
            } else {
                getRedirectStrategy().sendRedirect(request, response, targetUrl);
            }
        }

    }

    public LoginHandler() {
        super();
        setUseReferer(true);
    }

}
