package com.mock.bank.controller;

import com.mock.bank.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MockDataApiController {

    // 1. [은행] 개인수신계좌 목록 조회
    @GetMapping("/bank/accounts")
    public ResponseEntity<BankAcctResponse> getBankAccounts(
            @RequestHeader("x-api-tran-id") String tranId,
            @RequestHeader("x-user-search-id") String userSearchId,
            @RequestHeader("Authorization") String token
    ) {
        BankAccountDto account = BankAccountDto.builder()
                .bankName("우리은행") // 추가: MyDataSyncService가 이 값을 가져갑니다.
                .accountNum("1002-123-423123")
                .isConsent(true)
                .seqno("")
                .foreignDeposit(false)
                .prodName("우리 SUPER주거래 통장")
                .accountType("1001")
                .accountStatus("01")
                .curPre("KRW")
                .balanceAmt("1500000")
                .withdrawableAmt("1500000")
                .offeredRate("0.10")
                .lastTranDate("20260125")
                .isInvest(false)
                .build();

        return ResponseEntity.ok(BankAcctResponse.builder()
                .rspCode("00000").rspMsg("성공")
                .searchTimestamp("20260126123000").nextPage("")
                .accountCnt(1).accountList(Collections.singletonList(account))
                .build());
    }

    // 2. [은행] 개인형 IRP 목록 조회
    @GetMapping("/bank/irps")
    public ResponseEntity<BankIrpResponse> getBankIrps(
            @RequestHeader("x-api-tran-id") String tranId
    ) {
        BankIrpDto irp = BankIrpDto.builder()
                .bankName("우리은행") // 추가
                .prodName("개인형IRP")
                .accountNum("428-833-7777")
                .isConsent(true)
                .seqno("1")
                .irpType("01")
                .evalAmt("12000000")
                .invPrincipal("10000000")
                .fundNum("0")
                .openDate("20220101")
                .expDate("20320101")
                .isIsa(false)
                .build();

        return ResponseEntity.ok(BankIrpResponse.builder()
                .rspCode("00000").rspMsg("성공")
                .searchTimestamp("20260126123000").nextPage("")
                .irpCnt(1).irpList(Collections.singletonList(irp))
                .build());
    }

    // 3. [카드] 카드 목록 조회
    @GetMapping("/card/cards")
    public ResponseEntity<CardResponse> getCards(
            @RequestHeader("x-api-tran-id") String tranId
    ) {
        CardDto card = CardDto.builder()
                .cardId("card_001")
                .cardNum("2342-****-****-5621")
                .cardName("현대카드 ZERO")
                .isConsent(true)
                .cardType("01")
                .cardMember("01")
                .annualFee("10000")
                .issueDate("20230501")
                .isTransPayable(true)
                .paymentAmt("450000")
                .cardCompanyCode("C01")
                .cardCompanyName("현대카드") // 이미 잘 들어가 있으므로 그대로 유지
                .build();

        return ResponseEntity.ok(CardResponse.builder()
                .rspCode("00000").rspMsg("성공")
                .searchTimestamp("20260126123000").nextPage("")
                .resultCount(1).resultList(Collections.singletonList(card))
                .build());
    }

    // 4. [금투] 계좌 목록 조회
    @GetMapping("/invest/accounts")
    public ResponseEntity<InvestAcctResponse> getInvestAccounts(
            @RequestHeader("x-api-tran-id") String tranId
    ) {
        InvestAccountDto account = InvestAccountDto.builder()
                .companyName("키움증권") // 추가: "정보없음" 해결
                .accountNum("555-88-231256")
                .isConsent(true)
                .accountName("키움 종합매매")
                .accountType("101")
                .accountStatus("01")
                .issueDate("20240101")
                .isTaxBenefits(false)
                .withdrawableAmt("500000")
                .evalAmt("15600000")
                .currencyCode("KRW")
                .build();

        return ResponseEntity.ok(InvestAcctResponse.builder()
                .rspCode("00000").rspMsg("성공")
                .searchTimestamp("20260126123000").nextPage("")
                .accountCnt(1).accountList(Collections.singletonList(account))
                .build());
    }

    // 5. [금투] 개인형 IRP 목록 조회 (키움증권으로 통일)
    @GetMapping("/invest/irps")
    public ResponseEntity<InvestIrpResponse> getInvestIrps(
            @RequestHeader("x-api-tran-id") String tranId
    ) {
        InvestIrpDto irp = InvestIrpDto.builder()
                .companyName("키움증권")
                .accountNum("929-17-223112")
                .isConsent(true)
                .prodName("키움 중개형 ISA")
                .irpType("201")
                .evalAmt("25000000")
                .invPrincipal("20000000")
                .openDate("20200501")
                .expDate("20300501")
                .currencyCode("KRW")
                .build();

        return ResponseEntity.ok(InvestIrpResponse.builder()
                .rspCode("00000").rspMsg("성공")
                .searchTimestamp("20260126123000").nextPage("")
                .irpCnt(1).irpList(Collections.singletonList(irp))
                .build());
    }

    // 6. [보험] 보험 목록 조회
    @GetMapping("/insu/contracts")
    public ResponseEntity<InsuResponse> getInsuContracts(
            @RequestHeader("x-api-tran-id") String tranId
    ) {
        InsuDto insu = InsuDto.builder()
                .companyName("삼성화재") // 추가: "정보없음" 해결
                .insuNum("100-200-30000")
                .isConsent(true)
                .prodName("삼성화재 실손보험")
                .insuType("03")
                .insuStatus("01")
                .isRenewable(true)
                .issueDate("20200101")
                .expDate("20801231")
                .faceAmt("50000000")
                .currencyCode("KRW")
                .isVariable(false)
                .isUniversal(false)
                .build();

        return ResponseEntity.ok(InsuResponse.builder()
                .rspCode("00000").rspMsg("성공")
                .searchTimestamp("20260126123000").nextPage("")
                .insuCnt(1).insuList(Collections.singletonList(insu))
                .build());
    }
}