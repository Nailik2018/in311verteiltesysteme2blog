package ch.hftm;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
public class BlogService {

    @Inject
    BlogRepository blogRepository;

    public List<Blog> getAll() {
        return this.blogRepository.listAll();
    }

    @Transactional
    public Response create(Blog blog) {
        blogRepository.persist(blog);
        return null;
    }
}
