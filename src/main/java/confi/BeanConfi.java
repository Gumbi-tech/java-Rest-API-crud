package confi;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import io.swagger.jaxrs.config.BeanConfig;

/**
 * Servlet implementation class BeanConfi
 */
@WebServlet("/bean")
public class BeanConfi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeanConfi() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   @Override
public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	super.init(config);
	
	BeanConfig benConfig = new BeanConfig();
	benConfig.setBasePath("/ekuseni/rest/");
	benConfig.setHost("localhost:8089");
	benConfig.setTitle("ma docs ami lankha");
	benConfig.setResourcePackage("res");
	benConfig.setPrettyPrint(true);
	benConfig.setScan(true);
	benConfig.setSchemes(new String[] {"http"});
	benConfig.setVersion("1.0");
}

}
