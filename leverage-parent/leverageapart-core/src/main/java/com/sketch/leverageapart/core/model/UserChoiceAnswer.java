package com.sketch.leverageapart.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class UserChoiceAnswer {
	@Id private int id;
	
	@Column(name="hunt_id")
	private int huntId;
	
	@Column(name="question_id")
	private int questionId;
	
	@ManyToOne
	private ChoiceAnswer answer;
	
}
