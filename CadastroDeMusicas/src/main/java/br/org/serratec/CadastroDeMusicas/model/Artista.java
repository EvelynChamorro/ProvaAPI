package br.org.serratec.CadastroDeMusicas.model;

import java.time.LocalDate;
import java.util.List;

import br.org.serratec.CadastroDeMusicas.dto.ArtistaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int idade;
	private LocalDate data_nascimento;
	
	@ManyToMany
	@JoinTable(name = "artista_album",
	joinColumns = @JoinColumn(name = "artista_fk"),
	inverseJoinColumns = @JoinColumn(name = "album_fk"))
	private List<Album> albuns;
	
	public Artista() {}
	
	public Artista(Long id, String nome, int idade, LocalDate data_nascimento, List<Album> albuns) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.data_nascimento = data_nascimento;
		this.albuns = albuns;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
		
	 public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public ArtistaDTO toDTO() {
	        return new ArtistaDTO(id, nome, idade, data_nascimento, albuns);
	    }

	

}
