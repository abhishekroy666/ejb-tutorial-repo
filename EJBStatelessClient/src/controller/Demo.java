package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HelloRemote;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		try{
			Hashtable<Object,String> ht = new Hashtable<Object,String>();
			ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
			ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
			
			Context ctx = new InitialContext(ht);
			HelloRemote helloRemote = (HelloRemote)ctx.lookup("abc#com.HelloRemote");
			pw.println(helloRemote.sayHello(request.getParameter("n1")));
		}catch(Exception e){
			
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
