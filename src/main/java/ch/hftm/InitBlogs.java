package ch.hftm;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InitBlogs {
    @Inject
    BlogService blogService;

    @Transactional
    public void init(@Observes StartupEvent event) {
        // Initialize Data (only if there is no Data around)
        createBlogs();
    }

    public void createBlogs(){
        Blog blog1 = new Blog();
        blog1.setContent("Honey Hunting");
        blog1.setTitle("Banlgadesch Honey Hunting unterwegs in den Mangroven");
        Blog blog2 = new Blog();
        blog2.setTitle("Tenerifa Spanien");
        blog2.setContent("Lost places, Vulkan und Meer");
        blog2.setIsValidated(true);
        Blog blog3 = new Blog();
        blog3.setTitle("Gleitschirmferien in Bosnien und Herzegowina");
        blog3.setContent("Gleitschirmfliegen in Bosnien und Herzegowina");
        blogService.create(blog1);
        blogService.create(blog2);
        blogService.create(blog3);
    }
}
