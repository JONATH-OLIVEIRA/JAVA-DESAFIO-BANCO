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

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.services.exceptions.DatabaseException;
import br.com.banco.services.exceptions.ResourceNotFoundException;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository repository;

	@Transactional(readOnly = true)
	public TransferenciaDTO findaById(Long id) {
		Optional<Transferencia> obj = repository.findById(id);
		Transferencia entity = obj.orElseThrow(() -> new ResourceNotFoundException("Nao Encontrado"));
		return new TransferenciaDTO(entity, entity.getContas());
	}

	@Transactional(readOnly = true)
	public TransferenciaDTO insert(TransferenciaDTO dto) {
		Transferencia entity = new Transferencia();
		entity.setNome_operador_transacao(dto.getNome_operador_transacao());
		entity.setData_transferencia(dto.getData_transferencia());
		entity.setTipo(dto.getTipo());
		entity.setValor(dto.getValor());
		entity = repository.save(entity);
		return new TransferenciaDTO(entity);
	}

	@Transactional
	public TransferenciaDTO update(TransferenciaDTO dto, Long id) {
		try {
			Transferencia entity = repository.getById(id);
			entity.setNome_operador_transacao(dto.getNome_operador_transacao());
			entity.setData_transferencia(dto.getData_transferencia());
			entity.setTipo(dto.getTipo());
			entity.setValor(dto.getValor());
			entity = repository.save(entity);

			return new TransferenciaDTO(entity);
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
	public Page<TransferenciaDTO> findAllPaged(Pageable pageRequest) {
		Page<Transferencia> list = repository.findAll(pageRequest);

		return list.map(x -> new TransferenciaDTO(x));
	}

}
