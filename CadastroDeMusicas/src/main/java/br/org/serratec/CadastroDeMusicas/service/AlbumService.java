package br.org.serratec.CadastroDeMusicas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.CadastroDeMusicas.dto.AlbumDTO;
import br.org.serratec.CadastroDeMusicas.model.Album;
import br.org.serratec.CadastroDeMusicas.repository.AlbumRepository;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository repositorio;
    
    public List<AlbumDTO> listarTodos() {
        return repositorio.findAll().stream()
                .map(c -> new AlbumDTO(c.getId(), c.getNome_album(), c.getData_lancamento(), c.getArtistas()))
                .toList();
        
    }
    
    public Optional<AlbumDTO> listarPorId(Long id) {
        Optional<Album> album = repositorio.findById(id);
        if (album.isPresent()) {
            return Optional.of(album.get().toDTO());
        } 
        return Optional.empty();
    }
    
    public AlbumDTO salvarAlbum(AlbumDTO albumDTO) {
        Album albumEntity = repositorio.save(albumDTO.toEntity());
        return albumEntity.toDTO();
    }
    
    public Optional<AlbumDTO> atualizarAlbum(Long id, AlbumDTO albumDTO) {
        Album entAlbum = albumDTO.toEntity();
        if (repositorio.existsById(id)) {
            entAlbum.setId(id);
            repositorio.save(entAlbum);
            return Optional.of(entAlbum.toDTO());
        } 
        return Optional.empty();
    }
    
    public boolean excluirAlbum(Long id) {
        if (!repositorio.existsById(id)) {
            return false;
        }
        
        repositorio.deleteById(id);
        return true;
    }
}
