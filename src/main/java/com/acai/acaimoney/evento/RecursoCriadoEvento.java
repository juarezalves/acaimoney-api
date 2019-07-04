package com.acai.acaimoney.evento;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvento extends ApplicationEvent{

	
	private static final long serialVersionUID = 1L;

	private HttpServletResponse response;
	private Long id;
	
	public RecursoCriadoEvento(Object source, HttpServletResponse response, Long id) {
		super(source);		
		this.response = response;
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getId() {
		return id;
	}
	
	

}
