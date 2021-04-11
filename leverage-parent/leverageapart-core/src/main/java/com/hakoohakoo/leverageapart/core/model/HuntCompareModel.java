package com.hakoohakoo.leverageapart.core.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class HuntCompareModel {
	private List<Hunt> hunts;
	private List<Question> questions;
}
