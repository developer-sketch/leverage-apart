package com.hakoohakoo.leverageapart.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserEssayAnswer {
	@Id private int id;
	
	@Column(name="hunt_id")
	private int huntId;
	
	@Column(name="question_id")
	private int questionId;

	@Column(name="answer_type_id")
	private int answerTypeId;
	
	private String content;
}
