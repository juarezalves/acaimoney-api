package com.acai.acaimoney.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acai.acaimoney.model.Lancamento;
import com.acai.acaimoney.model.Pessoa;
import com.acai.acaimoney.repository.LancamentoRepository;
import com.acai.acaimoney.repository.PessoaRepository;
import com.acai.acaimoney.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(@Valid Lancamento lancamento) {
		Optional pessoa = pessoaRepository.findById(lancamento.getPessoa().getId());
		if(!pessoa.isPresent() || ((Pessoa) pessoa.get()).isInativo() ) {
			throw new PessoaInexistenteOuInativaException();
		}
		return lancamentoRepository.save(lancamento);
	}

}
