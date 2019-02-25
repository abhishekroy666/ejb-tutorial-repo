package com;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class DemoBean1
 */
@Stateful(mappedName = "xyz")
@LocalBean
public class DemoBean1 implements DemoBean1Remote {

    /**
     * Default constructor. 
     */
	private Hashtable<String,Float> ht=new Hashtable<String, Float>();
    public DemoBean1() {
        // TODO Auto-generated constructor stub
    }
    
    public void addItem(String productName,float productPrice){
    	ht.put(productName,productPrice);
    	System.out.println("Item Added");
    }
	public void removeItem(String productName){
		ht.remove(productName);
		System.out.println("Item Removed");
    }
	public float getTotalPrice(){
		float totalPrice = 0;
		Set<?> s = ht.keySet();
		Iterator<?> itr = s.iterator();
		while(itr.hasNext()){
			totalPrice += (Float)ht.get(itr.next());
		}
		return totalPrice;
	}

}
