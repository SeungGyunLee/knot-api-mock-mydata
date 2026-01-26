package com.mock.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter @Builder
public class InvestAcctResponse {
    @JsonProperty("rsp_code") private String rspCode;
    @JsonProperty("rsp_msg") private String rspMsg;
    @JsonProperty("search_timestamp") private String searchTimestamp;
    @JsonProperty("next_page") private String nextPage;
    @JsonProperty("account_cnt") private int accountCnt;
    @JsonProperty("account_list") private List<InvestAccountDto> accountList;
}