package com.interview.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.entity.CidadeEntity;
import com.interview.repository.CidadeRepository;
import com.interview.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{

	
	private static final long serialVersionUID = -5317586129875906091L;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Override
	public List<CidadeEntity> findByNome(String nome) {
		return cidadeRepository.findByNome(nome);
		
	}

	@Override
	public List<CidadeEntity> findByEstado(String estado) {
		return cidadeRepository.findByEstado(estado);
	}

	@Override
	public CidadeEntity save(CidadeEntity cidade) {
		cidadeRepository.save(cidade);
		return null;
	}

}
