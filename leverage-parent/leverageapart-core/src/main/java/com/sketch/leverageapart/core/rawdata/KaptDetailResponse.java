package com.sketch.leverageapart.core.rawdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KaptDetailResponse {
	@JsonProperty("resultMap_kapt")
	private KaptDetail detail;
}
