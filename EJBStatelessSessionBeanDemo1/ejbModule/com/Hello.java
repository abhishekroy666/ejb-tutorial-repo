package com;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Hello
 */
@Stateless(mappedName = "abc")
@LocalBean
public class Hello implements HelloRemote {

    /**
     * Default constructor. 
     */
    public Hello() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("I am here");
		return "Welcome to EJB Session Bean "+name;
	}
	
}
