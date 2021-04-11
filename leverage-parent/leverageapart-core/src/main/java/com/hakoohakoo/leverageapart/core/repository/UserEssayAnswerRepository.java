package com.hakoohakoo.leverageapart.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.core.model.UserEssayAnswer;

public interface UserEssayAnswerRepository extends JpaRepository<UserEssayAnswer, Integer>{
	List<UserEssayAnswer> findByHuntIdAndQuestionId(int huntId, int questionId);
}
