package com.mock.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class BankAccountDto {
    @JsonProperty("bank_name") private String bankName; // 추가
    @JsonProperty("account_num") private String accountNum;
    @JsonProperty("is_consent") private boolean isConsent;
    @JsonProperty("seqno") private String seqno;
    @JsonProperty("foreign_deposit") private boolean foreignDeposit;
    @JsonProperty("prod_name") private String prodName;
    @JsonProperty("account_type") private String accountType;
    @JsonProperty("account_status") private String accountStatus;

    @JsonProperty("cur_pre") private String curPre; // [에러 해결] 이 필드가 있어야 합니다!

    @JsonProperty("balance_amt") private String balanceAmt;
    @JsonProperty("withdrawable_amt") private String withdrawableAmt;
    @JsonProperty("offered_rate") private String offeredRate;
    @JsonProperty("last_tran_date") private String lastTranDate;
    @JsonProperty("is_invest") private boolean isInvest;
}