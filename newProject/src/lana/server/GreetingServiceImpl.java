package lana.server;

import lana.client.GreetingService;
import lana.shared.FieldVerifier;

//import lana.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		input = escapeHtml(input);
		int a = Integer.parseInt(String.valueOf(input.substring(0, input.indexOf("&"))));
		String last = input.substring(input.indexOf("&")+1 , input.length());
		int b =Integer.parseInt(String.valueOf(last.substring(0, last.indexOf("&"))));
		int c  = Integer.parseInt(String.valueOf(input.substring(last.indexOf("&")+1, last.length())));
	
		if (!FieldVerifier.isValid(a)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"a musn't be 0");
		}
		
		///////////////////////////////////////

		//String serverInfo = getServletContext().getServerInfo();
	//	String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		
	//	userAgent = escapeHtml(userAgent);

		 
		
		 int delta;
	double x1=0.0,x2=0.0;
	        delta = (b*b)-(4*a*c);
	     
	               if (delta>0){

	        x1 = ((-b) + (Math.sqrt(delta)))/(2*a);
	        x2 = ((-b) - (Math.sqrt(delta)))/(2*a);
	        return "delta > 0 and the equation has two solutions x1=  " + x1 +" and x2= " + x2 +"<br><br>";
	           }

	 else if(delta ==0)
	        {
	 x1  = -b / (2*a);
	  return "delta = 0 and the equation has one solutions x1 = x2 =  " + x1 +"<br><br>";
	 }
	 else{
		return "delta < 0 and the equation has no solution <br><br>";
	 }
	 
	 //              return "Hello" + input + "<br/>";
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
