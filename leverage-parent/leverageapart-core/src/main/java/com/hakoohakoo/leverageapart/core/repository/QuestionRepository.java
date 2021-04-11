package com.hakoohakoo.leverageapart.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.core.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	List<Question> findByHuntTypeId(int huntTypeId);
}
