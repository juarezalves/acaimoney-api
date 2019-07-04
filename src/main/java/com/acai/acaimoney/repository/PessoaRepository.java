package com.acai.acaimoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acai.acaimoney.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{	
	

}
