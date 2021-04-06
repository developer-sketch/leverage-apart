package com.hakoohakoo.leverageapart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.model.UserEssayAnswer;

public interface UserEssayAnswerRepository extends JpaRepository<UserEssayAnswer, Integer>{
	List<UserEssayAnswer> findByHuntIdAndQuestionId(int huntId, int questionId);
}
