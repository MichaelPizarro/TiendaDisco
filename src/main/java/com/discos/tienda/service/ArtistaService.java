package com.discos.tienda.service;

import com.discos.tienda.repository.IArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    final IArtistaRepository iArtistaRepository;

    public ArtistaService(IArtistaRepository iArtistaRepository) {
        this.iArtistaRepository = iArtistaRepository;
    }


    public List<com.discos.tienda.dto.ArtistaDiscoDTO> obtenerListaPalabra(String palabraClave){
            if(palabraClave != null){
                return iArtistaRepository.findAllArtistsByPalabraClave(palabraClave);

            }

            return iArtistaRepository.findAllArtistas();

    }

    public List<String> obtenerGenerosDeArtistas() {
        return iArtistaRepository.findAllGeneros();
    }
}
