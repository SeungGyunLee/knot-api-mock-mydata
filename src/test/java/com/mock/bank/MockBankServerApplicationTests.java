package com.mock.bank; // 메인 클래스와 패키지명이 반드시 같아야 함

import org.junit.jupiter.api.Test; // org.junit.Test (JUnit 4)가 아님을 확인!
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MockBankServerApplicationTests {

    @Test
    void contextLoads() {
        // 이 메서드가 비어있어도, @SpringBootTest가 전체 빈(Bean) 로드에 성공하면 통과됩니다.
        // 이것이 스프링 부트의 가장 정석적인 통합 테스트 시작점입니다.
    }
}