package com.hakoohakoo.leverageapart.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.core.model.ChoiceAnswer;


public interface ChoiceAnswerRepository extends JpaRepository<ChoiceAnswer, String>{
	List<ChoiceAnswer> findByAnswerTypeId(int answerTypeId);
}
