package com;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
	public String sayHello(String name);
}
