package res;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/c")
public class CreateUser {

//	@POST
//    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	private Response createUser(User user) throws URISyntaxException {
//		// TODO Auto-generated method stub
//		DaoForUsers dao = new DaoForUsers();
//		String user_D = dao.createUser(null);
//		URI uri = new URI("/createUser/" + user_D);
//		return  Response.created(uri).build();
//	}
	
	 	@POST
	    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	    public Response addUser(
	      User user, @Context UriInfo uriInfo) {
	 
		 
		 DaoForUsers dao = new DaoForUsers();
			dao.createUser(user);
//			String user_D = dao.createUser(new User(
//					"makula",
//					"mtsetfwa",
//					"makulagmail.com",
//					"sporo, fema",
//					"78454433"));
	   
	        return Response.status(Response.Status.CREATED.getStatusCode())
	          .header(
	            "Location", 
	            String.format("%s/%s",uriInfo.getAbsolutePath().toString(), 
	            2)).build();
	    }
}
