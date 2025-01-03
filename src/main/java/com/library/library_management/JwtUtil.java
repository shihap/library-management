package com.library.library_management;

import io.jsonwebtoken.Jwts; // مكتبة لإنشاء وتحليل الـ JWT
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

// this file is jwt model

public class JwtUtil {
    private final String SECRET_KEY = "MyBigSuperSecretKeyForTestForMeTheKingOfShadows"; // مفتاح سري لتوقيع الـ JWT

    // إنشاء JWT جديد
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // تحديد اسم المستخدم داخل الـ JWT
                .setIssuedAt(new Date()) // تاريخ إنشاء الـ JWT
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // تاريخ انتهاء (ساعة واحدة)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // توقيع الـ JWT باستخدام المفتاح السري
                .compact(); // إنشاء الرمز النهائي
    }

    // التحقق من صحة الـ JWT
    public boolean validateToken(String token, String username) {
        String extractedUsername = Jwts.parser() // تحليل الـ JWT
                .setSigningKey(SECRET_KEY) // استخدام المفتاح السري للتحقق من التوقيع
                .parseClaimsJws(token) // تحليل البيانات المشفرة
                .getBody()
                .getSubject(); // استخراج اسم المستخدم

        return extractedUsername.equals(username); // مقارنة اسم المستخدم للتأكد من صحة الـ JWT
    }
}
