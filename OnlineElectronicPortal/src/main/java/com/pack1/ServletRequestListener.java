package com.pack1;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

//@WebListener
public class ServletRequestListener implements javax.servlet.ServletRequestListener,ServletRequestAttributeListener{

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ServletRequest object initialized");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ServletRequest object destroyed");
	}
	
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("Attribute added to the servlet request ===> "+srae.getName());
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("Attribute removed from the servlet request ===> "+srae.getName());
	}
}
