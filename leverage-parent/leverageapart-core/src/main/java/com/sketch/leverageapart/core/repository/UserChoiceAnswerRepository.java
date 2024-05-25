package com.sketch.leverageapart.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sketch.leverageapart.core.model.UserChoiceAnswer;

public interface UserChoiceAnswerRepository extends JpaRepository<UserChoiceAnswer, Integer>{
	List<UserChoiceAnswer> findByHuntIdAndQuestionId(int huntId, int questionId);
}
