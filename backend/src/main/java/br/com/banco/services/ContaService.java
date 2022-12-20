package br.com.banco.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.banco.dto.ContaDTO;
import br.com.banco.entities.Conta;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.services.exceptions.DatabaseException;
import br.com.banco.services.exceptions.ResourceNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	@Transactional(readOnly = true)
	public ContaDTO findaById(Long id) {
		Optional<Conta> obj = repository.findById(id);
		Conta entity = obj.orElseThrow(() -> new ResourceNotFoundException("Nao Encontrado"));
		return new ContaDTO(entity);
	}

	@Transactional(readOnly = true)
	public ContaDTO insert(ContaDTO dto) {
		Conta entity = new Conta();
		entity.setNome_responsavel(dto.getNome_responsavel());
		entity = repository.save(entity);
		return new ContaDTO(entity);
	}

	@Transactional
	public ContaDTO update(ContaDTO dto, Long id) {
		try {
			Conta entity = repository.getById(id);
			entity.setNome_responsavel(dto.getNome_responsavel());

			entity = repository.save(entity);

			return new ContaDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id nao encontrado" + " " + id);
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id nao encontrado" + " " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violacao de Integridade");
		}

	}

	@Transactional(readOnly = true)
	public Page<ContaDTO> findAllPaged(Pageable pageRequest) {
		Page<Conta> list = repository.findAll(pageRequest);

		return list.map(x -> new ContaDTO(x));
	}

}
