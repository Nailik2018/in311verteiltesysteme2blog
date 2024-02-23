package ch.hftm;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BlogService {

    public List<Blog> getAll() {
        List<Blog> blogs = new ArrayList<>();
        Blog blog1 = new Blog("Hallo Welt", "Dies ist ein Test");
        Blog blog2 = new Blog("Hallo Welt 2", "Dies ist ein Test 2");
        blogs.add(blog1);
        blogs.add(blog2);
        return blogs;
    }
}
