package com.mock.bank.controller;

import com.mock.bank.dto.MockAssetResponse;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/mock/data")
public class MockDataApiController {

    // ==========================================
    // 1. Bank (은행) 조회 API
    // GET /v1/mock/data/bank/accounts
    // ==========================================
    @GetMapping("/bank/accounts")
    public MockAssetResponse<MockAssetResponse.BankAccount> getBankAccounts(@RequestHeader("Authorization") String token) {

        // 1. 은행 데이터 생성
        List<MockAssetResponse.BankAccount> list = new ArrayList<>();
        list.add(MockAssetResponse.BankAccount.builder()
                .accountNum("1234-56-7890")
                .prodName("직장인우대통장")
                .accountType("1001")
                .balanceAmt("5400000")
                .currencyCode("KRW")
                .bankCode("004")
                .bankName("KB국민은행")
                .build());

        // 2. 응답 리턴
        return MockAssetResponse.<MockAssetResponse.BankAccount>builder()
                .rspCode("00000")
                .rspMsg("성공")
                .resultCount(list.size())
                .resultList(list)
                .build();
    }

    // ==========================================
    // 2. Card (카드) 조회 API
    // GET /v1/mock/data/card/cards
    // ==========================================
    @GetMapping("/card/cards")
    public MockAssetResponse<MockAssetResponse.Card> getCards(@RequestHeader("Authorization") String token) {

        List<MockAssetResponse.Card> list = new ArrayList<>();
        list.add(MockAssetResponse.Card.builder()
                .cardId("c12345")
                .cardNum("1234-****-****-5678")
                .cardName("ZERO Edition2")
                .cardType("01")
                .paymentAmt("450000")
                .cardCompanyCode("C01")
                .cardCompanyName("현대카드")
                .build());

        return MockAssetResponse.<MockAssetResponse.Card>builder()
                .rspCode("00000")
                .rspMsg("성공")
                .resultCount(list.size())
                .resultList(list)
                .build();
    }

    // ==========================================
    // 3. Invest (증권) 조회 API
    // GET /v1/mock/data/invest/accounts
    // ==========================================
    @GetMapping("/invest/accounts")
    public MockAssetResponse<MockAssetResponse.SecurityAccount> getInvestAccounts(@RequestHeader("Authorization") String token) {

        // 종목 리스트 (삼성전자)
        List<MockAssetResponse.Product> products = new ArrayList<>();
        products.add(MockAssetResponse.Product.builder()
                .prodCode("005930")
                .prodName("삼성전자")
                .holdQty("100")
                .evalAmt("7500000")
                .earningRate("10.5")
                .build());

        // 증권 계좌 리스트
        List<MockAssetResponse.SecurityAccount> list = new ArrayList<>();
        list.add(MockAssetResponse.SecurityAccount.builder()
                .accountNum("5555-8888-12")
                .prodName("영웅문 종합위탁")
                .totalEvalAmt("15600000")
                .depositAmt("4600000")
                .companyCode("S01")
                .companyName("키움증권")
                .products(products) // 종목 포함
                .build());

        return MockAssetResponse.<MockAssetResponse.SecurityAccount>builder()
                .rspCode("00000")
                .rspMsg("성공")
                .resultCount(list.size())
                .resultList(list)
                .build();
    }

    // ==========================================
    // 4. Insurance (보험) 조회 API
    // GET /v1/mock/data/insu/contracts
    // ==========================================
    @GetMapping("/insu/contracts")
    public MockAssetResponse<MockAssetResponse.Insurance> getInsuContracts(@RequestHeader("Authorization") String token) {

        List<MockAssetResponse.Insurance> list = new ArrayList<>();
        list.add(MockAssetResponse.Insurance.builder()
                .insuNum("100-200-300")
                .prodName("삼성화재 실손보험")
                .insuType("03")
                .insuStatus("01")
                .faceAmt("50000000")
                .paidAmt("12000")
                .expDate("2030-12-31")
                .companyCode("I01")
                .companyName("삼성화재")
                .build());

        return MockAssetResponse.<MockAssetResponse.Insurance>builder()
                .rspCode("00000")
                .rspMsg("성공")
                .resultCount(list.size())
                .resultList(list)
                .build();
    }
}