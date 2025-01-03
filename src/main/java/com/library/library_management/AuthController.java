package com.library.library_management;

import org.springframework.web.bind.annotation.*;

// this file is for create the token (uses jwt generation)

@RestController // تعريف كلاس كـ REST Controller
@RequestMapping("/auth") // جميع المسارات تبدأ بـ "/auth"
public class AuthController {
    private final JwtUtil jwtUtil = new JwtUtil(); // استدعاء كلاس الـ JWT Utility

    @PostMapping("/login") // Endpoint لتسجيل الدخول
    public String login(@RequestParam String username, @RequestParam String password) {
        // التحقق من اسم المستخدم وكلمة المرور
        if ("user".equals(username) && "password".equals(password)) {
            return jwtUtil.generateToken(username); // إنشاء JWT إذا كانت البيانات صحيحة
        } else {
            return "Invalid username or password!"; // رسالة خطأ إذا كانت البيانات غير صحيحة
        }
    }
}
