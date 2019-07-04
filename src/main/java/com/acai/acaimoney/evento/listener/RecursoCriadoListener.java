package com.acai.acaimoney.evento.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acai.acaimoney.evento.RecursoCriadoEvento;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvento>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvento recursoCriadoEvento) {
		HttpServletResponse response = recursoCriadoEvento.getResponse();
		Long id = recursoCriadoEvento.getId();
		
		adicionarHeaderLocation(response, id);	
		
		
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
				buildAndExpand(id).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
