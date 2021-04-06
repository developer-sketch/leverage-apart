package com.hakoohakoo.leverageapart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.model.ChoiceAnswer;


public interface ChoiceAnswerRepository extends JpaRepository<ChoiceAnswer, String>{
	List<ChoiceAnswer> findByAnswerTypeId(int answerTypeId);
}
