package serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exception.InvalidFieldException;
import model.ClienteEntity;
import repository.ClienteRepository;
import service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private static final long serialVersionUID = 1L;
	
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
	public Boolean deleteById(Long Id) throws InvalidFieldException {
		Boolean retorno = false;
		clienteRepository.deleteById(Id);
		retorno = true;
		return retorno;
	}

	@Override
	@Transactional
	public ClienteEntity updateName(ClienteEntity cliente) throws InvalidFieldException {
		Optional<ClienteEntity> clienteEntity = clienteRepository.findById(cliente.getId());
		if(clienteEntity.isPresent()) {
			clienteEntity.get().setNome(cliente.getNome());
			return clienteRepository.save(clienteEntity);
		}else {
			throw new InvalidFieldException("Não existe cliente com o código digitado!");
		}
	}


	@Override
	@Transactional
	public Optional<ClienteEntity> findById(Long Id) throws InvalidFieldException {
		return clienteRepository.findById(Id);
	}

}
