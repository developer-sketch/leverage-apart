package com.sketch.leverageapart.core.repository;

import java.util.List;

import com.sketch.leverageapart.core.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	List<Question> findByHuntTypeId(int huntTypeId);
}
