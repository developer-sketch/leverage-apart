package com.hakoohakoo.leverageapart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.model.AnswerDescription;


public interface AnswerDescriptionRepository extends JpaRepository<AnswerDescription, Integer> {
	public AnswerDescription findByQuestionIdAndAnswerId(int questionId, int answerId);
}
