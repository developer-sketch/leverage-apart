package com.hakoohakoo.leverageapart.core.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class ChoiceAnswer {
	@Column(name="id")
	@Id private int id;
	@Column(name="name")
	private String name;

	@ManyToOne
	private AnswerType answerType;
	
	@Transient
	private AnswerDescription answerDescription;
}
