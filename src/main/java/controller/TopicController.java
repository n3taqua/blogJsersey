package controller;

import model.Topic;
import service.TopicService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/topics")
public class TopicController {

    private final TopicService topicService=new TopicService();
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Topic get(@PathParam("id") int id){
        return topicService.get(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Topic> getall(){
        return topicService.getAll();
    }

    @GET
    @Path("/categories/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Topic> getallbycategoreis(@PathParam("id") int id){
        return topicService.getAllByCategories(id);
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        topicService.delete(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Topic Topic){
        topicService.add(Topic);
    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Topic Topic){
        topicService.update(Topic);
    }
}
