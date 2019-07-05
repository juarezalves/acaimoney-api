package com.acai.acaimoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acai.acaimoney.model.Lancamento;
import com.acai.acaimoney.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{

}
