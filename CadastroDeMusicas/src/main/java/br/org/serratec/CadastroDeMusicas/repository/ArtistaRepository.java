package br.org.serratec.CadastroDeMusicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.CadastroDeMusicas.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
	