package com.example.demo.Question;

import com.example.demo.DataNotFoundException;
import com.example.demo.User.User;
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
    public void create(String subject, String content, User user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setAuthor(user);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }




}
