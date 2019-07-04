package com.acai.acaimoney.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.acai.acaimoney.model.Pessoa;
import com.acai.acaimoney.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloId(id);	
		
			BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");		
			return pessoaRepository.save(pessoaSalva);
	}	

	public void atualizarAtivo(Long id, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloId(id);	
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}
	
	public Pessoa buscarPessoaPeloId(Long id) {
		Pessoa pessoaSalva = pessoaRepository.findById(id).
				orElseThrow(() -> new EmptyResultDataAccessException(1));
		return pessoaSalva;
	}
	
	
}
