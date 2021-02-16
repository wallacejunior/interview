package service;

import java.io.Serializable;
import java.util.List;

import exception.InvalidFieldException;
import model.CidadeEntity;

public interface CidadeService extends Serializable {

	public List <CidadeEntity> findByNome(String nome) throws InvalidFieldException;
	public List <CidadeEntity> findByEstado(String estado) throws InvalidFieldException;
	public CidadeEntity save(CidadeEntity cidade) throws InvalidFieldException;
	
}
