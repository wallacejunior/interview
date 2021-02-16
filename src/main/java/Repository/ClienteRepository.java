package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	List <ClienteEntity> findByNome(String nome);

	ClienteEntity save(Optional<ClienteEntity> clienteEntity);
	
}
