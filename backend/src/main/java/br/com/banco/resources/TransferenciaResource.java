package br.com.banco.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.services.TransferenciaService;

@RestController
@RequestMapping(value = "/transferencia")

public class TransferenciaResource {
	@Autowired
	private TransferenciaService service;

	@GetMapping()
	public ResponseEntity<Page<TransferenciaDTO>> findAll(Pageable pageable) {

		Page<TransferenciaDTO> list = service.findAllPaged(pageable);

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TransferenciaDTO> findaById(@PathVariable Long id) {
		TransferenciaDTO dto = service.findaById(id);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<TransferenciaDTO> findByName(@RequestParam(name = "nome") String nome) {

		List<TransferenciaDTO> list = service.findByName(nome);
		return list;

	}

	@RequestMapping(value = "/searchDate", method = RequestMethod.GET)
	public List<TransferenciaDTO> findByDate(
			@RequestParam(name = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
			@RequestParam(name = "termino", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate termino) {

		List<TransferenciaDTO> list = service.findByDate(inicio, termino);
		System.out.println(inicio + "" + termino);
		return list;

	}

	@RequestMapping(value = "/searchNameDate", method = RequestMethod.GET)
	public List<TransferenciaDTO> findByNameDate(
			@RequestParam(name = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
			@RequestParam(name = "termino", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate termino,
			@RequestParam(name = "nome", required = false) String name) {

		List<TransferenciaDTO> list = service.findByNameDate(inicio, termino, name);

		return list;

	}

	@PostMapping
	public ResponseEntity<TransferenciaDTO> insert(@RequestBody TransferenciaDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TransferenciaDTO> update(@RequestBody TransferenciaDTO dto, @PathVariable Long id) {
		dto = service.update(dto, id);
		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
