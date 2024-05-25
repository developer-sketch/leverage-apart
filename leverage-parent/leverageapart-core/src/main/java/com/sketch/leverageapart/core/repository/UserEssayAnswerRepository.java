package com.sketch.leverageapart.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sketch.leverageapart.core.model.UserEssayAnswer;

public interface UserEssayAnswerRepository extends JpaRepository<UserEssayAnswer, Integer>{
	List<UserEssayAnswer> findByHuntIdAndQuestionId(int huntId, int questionId);
}
