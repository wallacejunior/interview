package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.CidadeEntity;

public interface CidadeRepository extends JpaRepository <CidadeEntity,Long> {

	List <CidadeEntity> findByNome(String nome);
	List <CidadeEntity> findByEstado(String estado);
}
