package com.mock.bank.dto; // Main 서버에서는 org.example.dto.mock 등으로 수정

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // JSON(snake) <-> Java(camel) 자동 변환
public class MockAssetResponse<T> {

    private String rspCode;         // 응답 코드 (예: "00000")
    private String rspMsg;          // 응답 메시지 (예: "성공")
    private String searchTimestamp; // 조회 시간
    private int resultCount;        // 결과 개수

    //  은행, 카드, 증권, 보험 리스트를 다 받을 수 있음
    private List<T> resultList;


    // ==========================================
    // 1. Bank (은행) 내부 클래스
    // ==========================================
    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class BankAccount {
        private String accountNum;
        private String prodName;
        private String accountType;
        private String balanceAmt;   // 잔액
        private String currencyCode;
        private String bankCode;
        private String bankName;
        private String issueDate;
        private String maturityDate;
    }

    // ==========================================
    // 2. Card (카드) 내부 클래스
    // ==========================================
    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Card {
        private String cardId;
        private String cardNum;
        private String cardName;
        private String cardType;
        private String paymentAmt;   // 결제 예정 금액
        private String cardCompanyCode;
        private String cardCompanyName;
        private String paymentDate;
        private String usedAmt;
        private String linkedBankCode;
    }

    // ==========================================
    // 3. Invest (증권/투자) 내부 클래스
    // ==========================================
    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class SecurityAccount {
        private String accountNum;
        private String prodName;
        private String totalEvalAmt; // 총 평가 금액
        private String depositAmt;
        private String companyCode;
        private String companyName;

        // 계좌 안에 종목들이 들어있음
        private List<Product> products;
    }

    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Product {
        private String prodCode;
        private String prodName;
        private String holdQty;      // 보유 수량
        private String evalAmt;      // 평가 금액
        private String earningRate;  // 수익률
    }

    // ==========================================
    // 4. Insurance (보험) 내부 클래스
    // ==========================================
    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Insurance {
        private String insuNum;
        private String prodName;
        private String insuType;
        private String insuStatus;
        private String faceAmt;
        private String paidAmt;      // 납입 금액
        private String expDate;
        private String companyCode;
        private String companyName;
    }
}