package controller;


import model.Categories;
import service.CategoriesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
public class CategoriesController {
    private final CategoriesService categoriesService=new CategoriesService();
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categories get(@PathParam("id") int id){
        return categoriesService.get(id);
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categories> getall(){
        return categoriesService.getAll();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        categoriesService.delete(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Categories categories){
        categoriesService.add(categories);
    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Categories categories){
        categoriesService.update(categories);
    }
}
