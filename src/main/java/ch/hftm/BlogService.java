package ch.hftm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.List;

@Dependent
public class BlogService {

    @Inject
    BlogRepository blogRepository;

    @Inject
    @Channel("text-validator-request")
    Emitter<TextValidatorResponseDto> validationRequestEmitter;

    public List<Blog> getAll() {
        return this.blogRepository.listAll();
    }

    public void  create(Blog blog) {
        var savedBlog = save(blog);
        validationRequestEmitter.send(new TextValidatorResponseDto(savedBlog.getContent() + "|" + savedBlog.getTitle(), savedBlog.getId()));
    }

    @Transactional
    public Blog save(Blog blog){
        blogRepository.persist(blog);
        return blog;
    }

    @Incoming("text-validator-response")
    @Transactional
    public void validateText(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TextValidatorResponseDto textValidatorResponseDto = objectMapper.readValue(message, TextValidatorResponseDto.class);
            blogRepository.update("isValid = ?1 where id = ?2", textValidatorResponseDto.getValid(), textValidatorResponseDto.getId());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
//    public void validateText(TextValidatorResponseDto textValidatorResponseDto) {
//        blogRepository.update("valid = ?1 where id = ?2", textValidatorResponseDto.getValid(), textValidatorResponseDto.getId());
//    }
}
