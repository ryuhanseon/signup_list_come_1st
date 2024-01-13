package com.example.demo.Question;

import com.example.demo.DataNotFoundException;
import com.example.demo.Question.Question;
import com.example.demo.Question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return questionRepository.findAll();
    }  //전에는 this. 가 붙어있었음
    public Question getArticle(Integer id){
        Optional<Question> article = this.questionRepository.findById(id);
        if (article.isPresent()){
            return article.get();
        }else {
            throw new DataNotFoundException("article not found");
        }
    }
    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }


}
