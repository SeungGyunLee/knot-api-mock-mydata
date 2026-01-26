package com.mock.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder @NoArgsConstructor
@AllArgsConstructor
public class InvestAccountDto {
    @JsonProperty("company_name") private String companyName; // 추가
    @JsonProperty("account_num") private String accountNum;
    @JsonProperty("is_consent") private boolean isConsent;
    @JsonProperty("account_name") private String accountName;
    @JsonProperty("account_type") private String accountType;
    @JsonProperty("account_status") private String accountStatus;
    @JsonProperty("issue_date") private String issueDate;
    @JsonProperty("is_tax_benefits") private boolean isTaxBenefits;
    @JsonProperty("withdrawable_amt") private String withdrawableAmt;
    @JsonProperty("eval_amt") private String evalAmt;
    @JsonProperty("currency_code") private String currencyCode;
}