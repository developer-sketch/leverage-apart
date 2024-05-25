package com.sketch.leverageapart.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AnswerDescription {
	@Id private int id;
	private int questionId;
	private int answerId;
	private String description;
}
