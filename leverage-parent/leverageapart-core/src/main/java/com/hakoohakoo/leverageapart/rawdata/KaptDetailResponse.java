package com.hakoohakoo.leverageapart.rawdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KaptDetailResponse {
	@JsonProperty("resultMap_kapt")
	private KaptDetail detail;
}
