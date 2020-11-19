package controller;

import model.User;
import service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
public class UserController {
    private final UserService userService=new UserService();
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User get(@PathParam("id") int id){
        return userService.get(id);
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getall(){
        return userService.getAll();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        userService.delete(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(User User){
        userService.add(User);
    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(User User){
        userService.update(User);
    }
}
