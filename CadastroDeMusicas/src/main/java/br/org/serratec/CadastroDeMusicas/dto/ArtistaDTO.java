package br.org.serratec.CadastroDeMusicas.dto;

import java.time.LocalDate;
import java.util.List;

import br.org.serratec.CadastroDeMusicas.model.Album;
import br.org.serratec.CadastroDeMusicas.model.Artista;

public record ArtistaDTO(	
	Long id,
	String nome,
	int idade,
	LocalDate data_nascimento,
	List<Album> albuns
	) {
	
	public Artista toEntity() {
        return new Artista (this.id, this.nome, this.idade, this.data_nascimento, this.albuns);
    }
	
    public static ArtistaDTO toDTO(Long id, String nome, int idade, LocalDate data_nascimento, List<Album> albuns) {
        return new ArtistaDTO(id, nome, idade, data_nascimento, albuns);
    }

}
