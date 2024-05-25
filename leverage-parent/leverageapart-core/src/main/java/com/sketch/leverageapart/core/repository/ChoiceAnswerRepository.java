package com.sketch.leverageapart.core.repository;

import java.util.List;

import com.sketch.leverageapart.core.model.ChoiceAnswer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChoiceAnswerRepository extends JpaRepository<ChoiceAnswer, String>{
	List<ChoiceAnswer> findByAnswerTypeId(int answerTypeId);
}
