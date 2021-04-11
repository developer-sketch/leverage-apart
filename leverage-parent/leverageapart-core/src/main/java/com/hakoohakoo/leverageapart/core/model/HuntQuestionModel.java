package com.hakoohakoo.leverageapart.core.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HuntQuestionModel {
	private Hunt hunt;
	private List<Question> questions;
	private Map<Integer, UserChoiceAnswer> userChoiceAnswers;
	private Map<Integer, UserEssayAnswer> userEssayAnswers;
}
