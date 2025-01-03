package com.library.library_management;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

// this file is how the jwt token is integrated with the rest of the apis (uses jwt validation)

@Component // تعريف الكلاس كـ Spring Component ليتم إضافته ضمن الـ Context
public class JwtFilter extends OncePerRequestFilter { // فلتر يُنفذ لكل طلب
    private final JwtUtil jwtUtil = new JwtUtil(); // استدعاء كلاس الـ JWT Utility

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
                
        String authorizationHeader = request.getHeader("Authorization"); // قراءة الـ Header الخاص بالـ Authorization

        // التحقق من أن الـ Header يحتوي على Bearer Token
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // استخراج الرمز بعد "Bearer "
            String username = jwtUtil.validateToken(token, "user") ? "user" : null; // التحقق من صحة الرمز

            if (username != null) {
                // لو الرمز صحيح، يكمل الفلتر
                // إضافة الـ user إلى SecurityContext
                UsernamePasswordAuthenticationToken authentication = 
                    new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authentication); // تعيين المستخدم في الـ Security Context
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // إذا كان الرمز غير صحيح
                return; // إنهاء الطلب
            }
        }

        chain.doFilter(request, response); // متابعة السلسلة (تنفيذ الطلب)
    }

}