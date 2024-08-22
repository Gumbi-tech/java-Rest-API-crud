package res;




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
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Path("/users")
@Api("/Users Service")
@SwaggerDefinition(tags = {@Tag(name = "Users Service", description = "REST End point for users ")})
public class GetUser {
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Object AllUsers(
			@QueryParam("page") @DefaultValue("1") int page,
			@QueryParam("size") @DefaultValue("10") int size
			) {
		// TODO Auto-generated method stub
		DaoForUsers dao = new DaoForUsers();
		
		if (dao.getDBusers(page, size) != null) {
			return dao.getDBusers(page, size);
		}else {
			
			return "500, failed to get All the users" ;
		}
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object AllUsers(@PathParam("id") String id) {
		// TODO Auto-generated method stub
		DaoForUsers dao = new DaoForUsers();
		
		 if (dao.getUser(id) != null) {
			 return dao.getUser(id);
		}else {
			
			return "500, there request resource was not found" ;
		}
		
		
	}
	
	
    @DELETE
    @Path("/delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Object getUser(@PathParam("id") String id) {
    	DaoForUsers dao = new DaoForUsers();
        
        
        if (dao.deleteUser(id) != null) {
        	return dao.deleteUser(id);
		}else {
			
			return "500, server failed to delete user";
		}
        
        
        
    }

    @PUT
    @Path("/update/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Object  updateUser(@PathParam("id") String id, User user) {
    	DaoForUsers dao = new DaoForUsers();
    	 if (dao.updateUser(id, user) != null) {
			 return dao.updateUser(id, user);
		}else {
			
			return "500, server failed to update" ;
		}
    }
	

    
	@POST
	@Path("/create")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addUser(
      User user, @Context UriInfo uriInfo) {
 
	 
	 DaoForUsers dao = new DaoForUsers();
		dao.createUser(user);

   
        return Response.status(Response.Status.CREATED.getStatusCode())
          .header(
            "Location", 
            String.format("%s/%s",uriInfo.getAbsolutePath().toString(), 
            2)).build();
    }
    
    
    
    

}
