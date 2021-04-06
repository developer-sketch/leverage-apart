package com.hakoohakoo.leverageapart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	List<Question> findByHuntTypeId(int huntTypeId);
}
