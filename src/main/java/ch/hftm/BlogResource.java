package ch.hftm;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.util.List;

@Path("/blog")
public class BlogResource {

    @Inject
    BlogService blogService;

    @Inject
    @Channel("text-validator-request")
//    Emitter<Blog> validationRequestEmitter;
    Emitter<String> validationRequestEmitter;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Blog> getAll() {
        return this.blogService.getAll();
    }

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response create(Blog blog) {
//        return this.blogService.create(blog);
//    }

    @POST
    @Path("/validate")
    public Response validateBlog(Blog blog) {
        this.blogService.create(blog);
        String blogContent = blog.getContent();
        validationRequestEmitter.send(blogContent);
        return Response.accepted().build();
    }

//    @POST
//    @Path("/validate")
//    @Outgoing("text-validator-request")
//    public Response validateBlog(Blog blog) {
//        this.blogService.create(blog);
//        validationRequestEmitter.send(blog);
//        return Response.accepted().build();
//    }
}

