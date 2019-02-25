package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    DemoBean1Remote db;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try{
		Hashtable<Object,String> ht = new Hashtable<Object,String>();
		ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
		Context ctx = new InitialContext(ht);
		 db = (DemoBean1Remote)ctx.lookup("xyz#com.DemoBean1Remote");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		try{
			
			
			
			
			
			if(request.getParameter("choice").equals("add")){
				db.addItem(request.getParameter("prodname"),Float.parseFloat(request.getParameter("prodprice")) );
				pw.println("Item Added");
			}
			if(request.getParameter("choice").equals("remove")){
				db.removeItem(request.getParameter("prodname"));
				pw.println("Item removed");
			}
			if(request.getParameter("choice").equals("totalprice")){
				pw.println("Total price : "+db.getTotalPrice());
			}
			
		}catch(Exception e){
			pw.println(e);
		}	
		RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
