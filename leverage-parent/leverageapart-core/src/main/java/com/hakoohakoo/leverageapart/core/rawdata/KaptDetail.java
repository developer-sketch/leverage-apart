package com.hakoohakoo.leverageapart.core.rawdata;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;

@Data
public class KaptDetail {
	@JsonProperty("CODE_APT")
	private String type; //"아파트"
	@JsonProperty("CODE_GARBAGE")
	private String garbage; //"음식물쓰레기종량제"
	@JsonProperty("CODE_HALL")
	private String stairOrHall; //"계단식"
	@JsonProperty("CODE_HEAT")
	private String heat; //"지역난방"
	@JsonProperty("CODE_NET")
	private String network; //"주차관제·홈네트워크":"무"
	@JsonProperty("CODE_SALE")
	private String sale; // "분양"
	@JsonProperty("CODE_STR")
	private String structure; //"철근콘크리트구조"
	@JsonProperty("CONVENIENT_FACILITY")
	private String facility; //"관공서(수서경찰서) 병원(삼성의료원) 공원(한마음공원)"
	@JsonProperty("EDUCATION_FACILITY")
	private String education; //"초등학교(대진) 중학교(중동중학교) 고등학교(중동고등학교)"
	@JsonProperty("KAPTD_ECNT_TOTAL")
	private int elevatorCount; //승강기대수
	@JsonProperty("KAPTD_PCNT")
	private String upstairPakingCount; //지상주차대수
	@JsonProperty("KAPTD_PCNTU")
	private String downStairsCount;//지하주차대수
	@JsonProperty("KAPTD_SEC_COM")
	private String securitySystem; //(주)에스텍시스템"
	@JsonProperty("KAPTD_WTIMEBUS")
	private String busDistance; //"5분이내"
	@JsonProperty("KAPTD_WTIMESUB")
	private String subwayDistance; //"5~10분이내"
	@JsonProperty("KAPT_ACOMPANY")
	private String aptCompany; //"LG건설"
	@JsonProperty("KAPT_BCOMPANY")
	private String buildCompany; //"화엄건설"
	@JsonProperty("KAPT_CDATE")
	private String createDate; //"2009-05-11"
	@JsonProperty("KAPT_CODE")
	private String code;// "A13593901"
	@JsonProperty("KAPT_DONG_CNT")
	private String dongCount; //"4"
	@JsonProperty("KAPT_MAREA")
	private float supplyArea;//전용면적:32275.48㎡
	@JsonProperty("KAPT_NAME")
	private String name; //"LG개포자이아파트"
	@JsonProperty("KAPT_TAREA")
	private float totalArea; //연면적:60358.78
	@JsonProperty("KAPT_USEDATE")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate useApproveDate; //사용승인일:"2004-06-17"
	@JsonProperty("SUBWAY_LINE")
	private String subwayLine;//"3호선"
	@JsonProperty("SUBWAY_STATION")
	private String subwayStation;//"대청"
	@JsonProperty("WELFARE_FACILITY")
	private String facities;//"관리사무소, 노인정, 어린이놀이터, 휴게시설, 자전거보관소"
}
