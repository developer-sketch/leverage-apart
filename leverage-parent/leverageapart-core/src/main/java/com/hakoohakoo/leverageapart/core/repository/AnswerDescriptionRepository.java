package com.hakoohakoo.leverageapart.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.core.model.AnswerDescription;


public interface AnswerDescriptionRepository extends JpaRepository<AnswerDescription, Integer> {
	public AnswerDescription findByQuestionIdAndAnswerId(int questionId, int answerId);
}
