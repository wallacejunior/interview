package com.interview.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.interview.entity.CidadeEntity;
import com.interview.exception.InvalidFieldException;

public interface CidadeService extends Serializable {

	public List <CidadeEntity> findByNome(String nome) throws InvalidFieldException;
	public List <CidadeEntity> findByEstado(String estado) throws InvalidFieldException;
	public CidadeEntity save(CidadeEntity cidade) throws InvalidFieldException;
	
}
