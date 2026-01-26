package com.mock.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter @Builder
public class BankIrpResponse {
    @JsonProperty("rsp_code") private String rspCode;
    @JsonProperty("rsp_msg") private String rspMsg;
    @JsonProperty("search_timestamp") private String searchTimestamp;
    @JsonProperty("next_page") private String nextPage;
    @JsonProperty("irp_cnt") private int irpCnt;
    @JsonProperty("irp_list") private List<BankIrpDto> irpList;
}