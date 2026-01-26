package com.mock.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter @Builder
public class CardResponse {
    @JsonProperty("rsp_code") private String rspCode;
    @JsonProperty("rsp_msg") private String rspMsg;
    @JsonProperty("search_timestamp") private String searchTimestamp;
    @JsonProperty("next_page") private String nextPage;

    // 명세서 규격 및 컨트롤러와 일치시키기 위해 수정
    @JsonProperty("result_count") private int resultCount; // card_cnt -> result_count
    @JsonProperty("result_list") private List<CardDto> resultList; // card_list -> result_list
}