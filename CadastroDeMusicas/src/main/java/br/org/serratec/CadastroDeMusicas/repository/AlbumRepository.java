package br.org.serratec.CadastroDeMusicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.CadastroDeMusicas.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
