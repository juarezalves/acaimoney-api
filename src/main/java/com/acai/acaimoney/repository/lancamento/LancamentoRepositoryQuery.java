package com.acai.acaimoney.repository.lancamento;

import java.util.List;

import com.acai.acaimoney.model.Lancamento;
import com.acai.acaimoney.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
	
	

}
