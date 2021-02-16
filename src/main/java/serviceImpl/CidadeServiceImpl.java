package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.CidadeEntity;
import repository.CidadeRepository;
import service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{

	
	private static final long serialVersionUID = 1L;
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
