package com.sketch.leverageapart.core.repository;

import com.sketch.leverageapart.core.model.AnswerDescription;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnswerDescriptionRepository extends JpaRepository<AnswerDescription, Integer> {
	public AnswerDescription findByQuestionIdAndAnswerId(int questionId, int answerId);
}
