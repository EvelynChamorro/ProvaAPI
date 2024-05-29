package br.org.serratec.CadastroDeMusicas.dto;

import java.time.LocalDate;
import java.util.List;

import br.org.serratec.CadastroDeMusicas.model.Album;
import br.org.serratec.CadastroDeMusicas.model.Artista;

public record AlbumDTO(
    Long id,
    String nome_album,
    LocalDate data_lancamento,
    List<Artista> artistas) {
    
    public Album toEntity() {
        return new Album(this.id, this.nome_album, this.data_lancamento, this.artistas);
    }
    
    public static AlbumDTO toDTO(Long id, String nome_album, LocalDate data_lancamento, List<Artista> artistas) {
        return new AlbumDTO(id, nome_album, data_lancamento, artistas);
    }

}

