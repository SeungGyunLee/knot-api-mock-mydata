package com.mock.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/v1/auth")
public class MockAuthApiController {

    // 1. 기관 로그인 (CI 발급)
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {
        // [Java 8 호환] HashMap 사용
        Map<String, String> response = new HashMap<>();
        response.put("rsp_code", "00000");
        response.put("rsp_msg", "성공");
        response.put("tx_id", "tx_" + UUID.randomUUID().toString().substring(0, 10));
        response.put("user_search_id", "user_ci_12345_xyz"); // [중요] WAS가 사용할 식별자

        return ResponseEntity.ok(response);
    }

    // 2. 전송요구권 약관 동의 (토큰 발급)
    @PostMapping("/consent")
    public ResponseEntity<Map<String, Object>> consent(@RequestBody Map<String, Object> body) {
        // [Java 8 호환] HashMap 사용
        Map<String, Object> response = new HashMap<>();
        response.put("rsp_code", "00000");
        response.put("rsp_msg", "성공");
        response.put("access_token", "mock_token_final_9999"); // WAS가 사용할 토큰
        response.put("token_type", "Bearer");
        response.put("expires_in", 31536000);
        response.put("scope", "bank card invest insu");
        response.put("user_search_id", "user_ci_12345_xyz");

        return ResponseEntity.ok(response);
    }
}