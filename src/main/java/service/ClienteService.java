package service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import exception.InvalidFieldException;
import model.ClienteEntity;

public interface ClienteService extends Serializable {

	public List <ClienteEntity> findByNome (String nome) throws InvalidFieldException;
	public Optional<ClienteEntity> findById (Long Id) throws InvalidFieldException;
	public ClienteEntity save(ClienteEntity cliente) throws InvalidFieldException;
	public Boolean deleteById (Long Id) throws InvalidFieldException;
	public ClienteEntity updateName (ClienteEntity cliente) throws InvalidFieldException;
}
