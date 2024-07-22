package vn.t3h.class2109.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Lấy danh sách các quyền của người dùng
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // In ra các quyền để kiểm tra
        authorities.forEach(authority -> System.out.println("Role: " + authority.getAuthority()));

        // Kiểm tra quyền và chuyển hướng tương ứng
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            response.sendRedirect("/backend/home");
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            response.sendRedirect("/backend/product/list");
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            response.sendRedirect("/home");
        } else {
            response.sendRedirect("/");
        }
    }
}
