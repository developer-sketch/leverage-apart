package com.hakoohakoo.leverageapart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class AnswerType {
	@Id private int id;
	private String description;
	
	@Column(name="is_choice")
	@JsonProperty("isChoice")
	private boolean isChoice;
}
