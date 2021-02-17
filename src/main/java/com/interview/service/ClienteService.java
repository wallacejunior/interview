package com.interview.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.interview.entity.ClienteEntity;
import com.interview.exception.InvalidFieldException;


public interface ClienteService extends Serializable {

	public List <ClienteEntity> findByNome (String nome) throws InvalidFieldException;
	public Optional<ClienteEntity> findById (Long id) throws InvalidFieldException;
	public ClienteEntity save(ClienteEntity cliente) throws InvalidFieldException;
	public Boolean deleteById (Long ClientId) throws InvalidFieldException;
	public ClienteEntity updateName (ClienteEntity cliente) throws InvalidFieldException;
}
