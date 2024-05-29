package br.org.serratec.CadastroDeMusicas.model;

import java.time.LocalDate;
import java.util.List;

import br.org.serratec.CadastroDeMusicas.dto.AlbumDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String nome_album;
	private LocalDate data_lancamento;	
	
	@ManyToMany (mappedBy = "albuns")
	private List<Artista> artistas;
	
	public Album() {}
	
	public Album(Long id, String nome_album, LocalDate data_lancamento, List<Artista> artistas) {
		super();
		this.id = id;
		this.nome_album = nome_album;
		this.data_lancamento = data_lancamento;
		this.artistas = artistas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_album() {
		return nome_album;
	}
	public void setNome_album(String nome_album) {
		this.nome_album = nome_album;
	}
	public LocalDate getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(LocalDate data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	
	 public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	public AlbumDTO toDTO() {
	        return new AlbumDTO(id, nome_album, data_lancamento, artistas);
	    }
	
}
