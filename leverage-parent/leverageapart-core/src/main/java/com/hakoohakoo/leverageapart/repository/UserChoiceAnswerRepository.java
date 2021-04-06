package com.hakoohakoo.leverageapart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.model.UserChoiceAnswer;

public interface UserChoiceAnswerRepository extends JpaRepository<UserChoiceAnswer, Integer>{
	List<UserChoiceAnswer> findByHuntIdAndQuestionId(int huntId, int questionId);
}
