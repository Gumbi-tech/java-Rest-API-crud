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
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;





@Path("/co")
@Api("/Comments Service")
@SwaggerDefinition(tags = {@Tag(name = "Comments Service", description = "REST End point for  comments")})
public class Comments {

	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Object AllCommments(
			@QueryParam("page") @DefaultValue("1") int page,
			@QueryParam("size") @DefaultValue("10") int size
			) {
		// TODO Auto-generated method stub
		DaoForComments dao = new DaoForComments();
		
		 if (dao.getDBCommentsBeans(page, size) != null) {
			 return dao.getDBCommentsBeans(page, size);
		}else {
			
			return "500, server failed to get All the comments" ;
		}
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getComment(@PathParam("id") String id) {
		// TODO Auto-generated method stub
		DaoForComments dao = new DaoForComments();
		
		 if (dao.getComment(id) != null) {
			 return dao.getComment(id);
		}else {
			
			return "500, server failed to get All the comments" ;
		}
		
	}
	
	
	 @DELETE
	  @Path("/delete/{id}")
	  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	  public Object deleteComment(@PathParam("id") String id) {
		 DaoForComments dao = new DaoForComments();
	    
	      if (dao.deleteComment(id) != null) {
	    	  return dao.deleteComment(id);
			}else {
				
				return "500, server failed to delete" ;
			}
	  }
	 
	 
	 @PUT
	    @Path("/update/{id}")
	    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    public CommentsBean updateComment(@PathParam("id") String id, CommentsBean comment ) {
		 DaoForComments dao = new DaoForComments();
	    	return dao.updateComment(id, comment);
	    }
	 
	 
	 @POST
	 	@Path("/create")
	    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    public Response addComment(
	      CommentsBean comment, @Context UriInfo uriInfo) {
	 
		 
		 DaoForComments dao = new DaoForComments();
			dao.createCommet(comment);
   
	        return Response.status(Response.Status.CREATED.getStatusCode())
	          .header(
	            "Location", 
	            String.format("%s/%s",uriInfo.getAbsolutePath().toString(), 
	            2)).build();
	    }
}
