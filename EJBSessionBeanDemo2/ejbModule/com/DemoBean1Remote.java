package com;

import javax.ejb.Remote;

@Remote
public interface DemoBean1Remote {
	public void addItem(String productName,float productPrice);
	public void removeItem(String productName);
	public float getTotalPrice();
}
