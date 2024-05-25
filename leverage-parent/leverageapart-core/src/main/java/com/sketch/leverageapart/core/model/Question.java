package com.sketch.leverageapart.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Question {
	@Id private int id;
	private String text;
	
	@ManyToOne
	private HuntType huntType;

	@ManyToOne
	private AnswerType answerType;
	
	@ManyToOne
	private QuestionCategory category;
	
	@Transient
	private List<ChoiceAnswer> choiceAnswers = new ArrayList<ChoiceAnswer>();
}
