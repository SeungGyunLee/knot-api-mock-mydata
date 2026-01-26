package com.mock.bank.dto; // 프로젝트 구조에 맞게 패키지 유지

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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MockAssetResponse<T> {

    private String rspCode;
    private String rspMsg;
    private String searchTimestamp;
    private String nextPage;      // 페이징 대응을 위해 추가
    private int resultCount;      // 응답 개수 (account_cnt, card_cnt 등 통합)
    private List<T> resultList;

    // ==========================================
    // 1. Bank (은행) - MyDataBank 엔티티와 1:1 매칭
    // ==========================================
    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class BankAccount {
        private String accountNum;
        private boolean isConsent;    // 추가
        private String seqno;         // 추가
        private boolean foreignDeposit; // 추가
        private String prodName;
        private String accountType;   // 1001 등
        private String accountStatus; // 추가
        private String curPre;        // 추가
        private String balanceAmt;
        private String withdrawableAmt; // 추가
        private String offeredRate;   // 추가
        private String lastTranDate;  // 추가
        private boolean isInvest;     // 추가
        private String bankName;
    }

    // ==========================================
    // 2. Card (카드) - MyDataCard 엔티티와 1:1 매칭
    // ==========================================
    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Card {
        private String cardId;
        private String cardNum;
        private String cardName;
        private boolean isConsent;    // 추가
        private String cardType;
        private String cardMember;    // 추가
        private String annualFee;     // 추가
        private String issueDate;     // 추가
        private boolean isTransPayable; // 추가
        private String paymentAmt;
        private String cardCompanyCode;
        private String cardCompanyName;
    }

    // ==========================================
    // 3. Invest (증권) - MyDataInvest 엔티티와 1:1 매칭
    // ==========================================
    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class SecurityAccount {
        private String accountNum;
        private boolean isConsent;    // 추가
        private String accountName;
        private String accountType;   // 추가
        private String accountStatus; // 추가
        private String issueDate;     // 추가
        private boolean isTaxBenefits; // 추가
        private String withdrawableAmt; // 추가
        private String totalEvalAmt;
        private String currencyCode;  // 추가
        private String companyName;
        private List<Product> products;
    }

    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Product {
        private String prodCode;
        private String prodName;
        private String prodType;      // 추가
        private String holdQty;
        private String evalAmt;
        private String purchaseAmt;   // 추가
        private String earningRate;
    }

    // ==========================================
    // 4. Insurance (보험) - MyDataInsurance 엔티티와 1:1 매칭
    // ==========================================
    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Insurance {
        private String insuNum;
        private boolean isConsent;    // 추가
        private String prodName;
        private String insuType;
        private String insuStatus;    // 추가
        private boolean isRenewable;  // 추가
        private String issueDate;     // 추가
        private String expDate;       // 추가
        private String faceAmt;       // 가입금액
        private String paidAmt;       // 납입금액
        private String currencyCode;  // 추가
        private boolean isVariable;   // 추가
        private boolean isUniversal;  // 추가
        private String companyName;
    }
}