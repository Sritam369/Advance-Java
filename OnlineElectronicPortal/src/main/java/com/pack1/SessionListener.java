package com.pack1;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener{

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("HttpSession created");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("HttpSession destroyed");
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		System.out.println("Attribute added to the session : "+hsbe.getName());
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe) {
		System.out.println("Attribute removed from the session : "+hsbe.getName());
	}
}
