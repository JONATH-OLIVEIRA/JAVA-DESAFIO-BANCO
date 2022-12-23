package br.com.banco.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.entities.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

	@Query(value = "select u from Transferencia u where upper(trim(u.nome_operador_transacao)) like %?1% ")
	List<TransferenciaDTO> buscarPorNome (String nome_operador_transacao );

	@Query (value = "select u from Transferencia u where u.data_transferencia between :inicio and :termino ")
	List<TransferenciaDTO> findByDate (LocalDate inicio, LocalDate termino );
	
	@Query (value = "select u from Transferencia u where u.data_transferencia between :inicio and :termino and u.nome_operador_transacao like %:nome% ")
	List<TransferenciaDTO> findByNameDate (LocalDate inicio, LocalDate termino, String nome );
}
