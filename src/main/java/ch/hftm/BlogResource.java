package ch.hftm;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/blog")
public class BlogResource {

    @Inject
    BlogService blogService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Blog> getAll() {
        return this.blogService.getAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Blog blog) {
        return this.blogService.create(blog);
    }
}
