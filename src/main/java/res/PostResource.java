package res;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;


@Path("/post")
@Api("/Post Service")
@SwaggerDefinition(tags = {@Tag(name = "Post Service", description = "REST End point for post ")})
@ApiOperation(
	    value = "Short description of resources",
	    notes = "Detailed textual description of the resource...")
public class PostResource {


	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> AllUsers(
			@QueryParam("page") @DefaultValue("1") int page,
			@QueryParam("size") @DefaultValue("10") int size
			
			
			) {
		// TODO Auto-generated method stub
		DaoForPost dao =  new DaoForPost();
		return dao.getDBPost(page, size);
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Post AllUsers(@PathParam("id") String id) {
		// TODO Auto-generated method stub
		DaoForPost dao =  new DaoForPost();
		return dao.getPost(id);
	}
	
	
	 @DELETE
	  @Path("/delete/{id}")
	  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	  public Post getUser(@PathParam("id") String id) {
		 DaoForPost dao =  new DaoForPost();
	      return dao.deletePost(id);
	  }
	 
	 
	 @PUT
	    @Path("/update/{id}")
	    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    public Post updateUser(@PathParam("id") String id, Post post ) {
		 DaoForPost dao =  new DaoForPost();
	    	return dao.updatePost(id, post);
	    }
	 
	 
	 @POST
	 	@Path("/create")
	    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    public Response addUser(
	      Post post, @Context UriInfo uriInfo) {
	 
		 
		 DaoForPost dao =  new DaoForPost();
			dao.createPost(post);
   
	        return Response.status(Response.Status.CREATED.getStatusCode())
	          .header(
	            "Location", 
	            String.format("%s/%s",uriInfo.getAbsolutePath().toString(), 
	            2)).build();
	    }
	
	
}
