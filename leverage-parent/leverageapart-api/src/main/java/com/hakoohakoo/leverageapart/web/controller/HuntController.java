package com.hakoohakoo.leverageapart.web.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hakoohakoo.leverageapart.core.model.AnswerDescription;
import com.hakoohakoo.leverageapart.core.model.ChoiceAnswer;
import com.hakoohakoo.leverageapart.core.model.Hunt;
import com.hakoohakoo.leverageapart.core.model.HuntCompareModel;
import com.hakoohakoo.leverageapart.core.model.HuntQuestionModel;
import com.hakoohakoo.leverageapart.core.model.NaverSearchResult;
import com.hakoohakoo.leverageapart.core.model.Question;
import com.hakoohakoo.leverageapart.core.model.UserChoiceAnswer;
import com.hakoohakoo.leverageapart.core.model.UserEssayAnswer;
import com.hakoohakoo.leverageapart.core.repository.AnswerDescriptionRepository;
import com.hakoohakoo.leverageapart.core.repository.ChoiceAnswerRepository;
import com.hakoohakoo.leverageapart.core.repository.HuntRepository;
import com.hakoohakoo.leverageapart.core.repository.QuestionRepository;
import com.hakoohakoo.leverageapart.core.repository.UserChoiceAnswerRepository;
import com.hakoohakoo.leverageapart.core.repository.UserEssayAnswerRepository;

@RestController
@RequestMapping("/api/hunt")
public class HuntController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HuntRepository huntRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserChoiceAnswerRepository userChoiceAnswerRepository;
	
	@Autowired
	private UserEssayAnswerRepository userEssayAnswerRepository;
	
	@Autowired
	private AnswerDescriptionRepository answerDescriptionRepository;
	
	@Autowired
	private ChoiceAnswerRepository choiceAnswerRepository;
	
	@GetMapping("/list")
	public List<Hunt> list(@RequestParam("huntDate") int huntDate) {
		return huntRepository.findByHuntDate(huntDate);
	}
	
	@PostMapping
	public void insertHunt(@RequestBody Hunt hunt) {
		huntRepository.save(hunt);
	}
	
	@PostMapping("/userChoiceAnswer")
	public UserChoiceAnswer insertChoiceAnswer(@RequestBody UserChoiceAnswer answer) {
		return userChoiceAnswerRepository.save(answer);
	}
	
	@PostMapping("/userEssayAnswer")
	public UserEssayAnswer insertEssayAnswer(@RequestBody UserEssayAnswer answer) {
		return userEssayAnswerRepository.save(answer);
	}
	
	@GetMapping("/qna")
	public HuntQuestionModel qna(@RequestParam("huntId") int huntId) {
		Optional<Hunt> hunt = huntRepository.findById(huntId);
		List<Question> questions = questionRepository.findByHuntTypeId(hunt.get().getHuntType().getId());
		setAnswers(questions);
		
		return HuntQuestionModel.builder()
			.hunt(hunt.get())
			.questions(questions)
			.userChoiceAnswers(getUserChoiceAnswers(questions, huntId))
			.userEssayAnswers(getUserEssayAnswers(questions, huntId))
			.build();
	}
	
	@GetMapping("/search")
	private NaverSearchResult search(@RequestParam("searchWords") String searchWords) {
		URI url = URI.create("https://new.land.naver.com/api/search?keyword=".concat(searchWords));
		HttpHeaders headers = new HttpHeaders();
		headers.set("Host", "new.land.naver.com");
		headers.set("Referer", "https://new.land.naver.com");
		headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.190 Safari/537.36");
		headers.set("Accept-Encoding", "gzip, deflate, br");
		headers.set("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,da;q=0.6");

		ResponseEntity<NaverSearchResult> result = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(null, headers), NaverSearchResult.class);
		return result.getBody();
	}

	
	@GetMapping("/compareArea")
	public HuntCompareModel compareArea() {
		int huntTypeId = 1;
		List<Hunt> hunts = huntRepository.findByHuntTypeId(huntTypeId);
		List<Question> questions = questionRepository.findByHuntTypeId(huntTypeId);
		hunts.forEach(hunt -> {
			hunt.setUserChoiceAnswers(getUserChoiceAnswers(questions, hunt.getId()));
			hunt.setUserEssayAnswers(getUserEssayAnswers(questions, hunt.getId()));
		});
		
		return HuntCompareModel.builder()
			.hunts(hunts)
			.questions(questions)
			.build();
	}
	
	private Map<Integer, UserChoiceAnswer> getUserChoiceAnswers(List<Question> questions, int huntId) {
		Map<Integer, UserChoiceAnswer> answers = questions.stream()
		.map(question -> userChoiceAnswerRepository.findByHuntIdAndQuestionId(huntId, question.getId()))
		.map(list -> list.toArray())
		.flatMap(list -> Arrays.stream(list))
		.map(answer -> (UserChoiceAnswer) answer)
		.collect(Collectors.toMap(UserChoiceAnswer::getQuestionId, answer -> answer));
		
		return answers;
	}
	
	private Map<Integer, UserEssayAnswer> getUserEssayAnswers(List<Question> questions, int huntId) {
		Map<Integer, UserEssayAnswer> answers = questions.stream()
		.map(question -> userEssayAnswerRepository.findByHuntIdAndQuestionId(huntId, question.getId()))
		.map(list -> list.toArray())
		.flatMap(list -> Arrays.stream(list))
		.map(answer -> (UserEssayAnswer) answer)
		.collect(Collectors.toMap(UserEssayAnswer::getQuestionId, answer -> answer));
		
		return answers;
	}
	
	private void setAnswers(List<Question> questions) {
		questions.stream().forEach(question -> {
			List<ChoiceAnswer> answers = choiceAnswerRepository.findByAnswerTypeId(question.getAnswerType().getId()).stream()
			.map(answer -> {
				AnswerDescription answerDescription = answerDescriptionRepository.findByQuestionIdAndAnswerId(question.getId(), answer.getId());
				ChoiceAnswer answerWihtDescription = new  ChoiceAnswer();
				answerWihtDescription.setAnswerDescription(answerDescription);
				answerWihtDescription.setAnswerType(answer.getAnswerType());
				answerWihtDescription.setId(answer.getId());
				answerWihtDescription.setName(answer.getName());
				
				return answerWihtDescription;
			})
			//.sorted(Comparator.comparing(ChoiceAnswer::getId))
			.collect(Collectors.toList());
			question.getChoiceAnswers().addAll(answers);
		});		
	}
}
