package com.interview.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interview.entity.ClienteEntity;
import com.interview.exception.InvalidFieldException;
import com.interview.repository.ClienteRepository;
import com.interview.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	
	private static final long serialVersionUID = -7980539778482251245L;
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional
	public List<ClienteEntity> findByNome(String nome) throws InvalidFieldException {
		return clienteRepository.findByNome(nome);
	}


	@Override
	@Transactional
	public ClienteEntity save(ClienteEntity cliente) throws InvalidFieldException {
		return clienteRepository.save(cliente);
	}

	@Override
	public Boolean deleteById(Long clienteId) throws InvalidFieldException {
		Boolean retorno = Boolean.FALSE;
		clienteRepository.deleteById(clienteId);
		retorno = Boolean.TRUE;
		return retorno;
	}

	@Override
	@Transactional
	public ClienteEntity updateName(ClienteEntity cliente) throws InvalidFieldException {
		Optional<ClienteEntity> clienteEntity = clienteRepository.findById(cliente.getId());
		if(clienteEntity.isPresent()) {
			clienteEntity.get().setNome(cliente.getNome());
			return clienteRepository.save(clienteEntity.get());
		}else {
			throw new InvalidFieldException("Não existe cliente com o código digitado!");
		}
	}


	@Override
	@Transactional
	public Optional<ClienteEntity> findById(Long id) throws InvalidFieldException {
		return clienteRepository.findById(id);
	}

}
