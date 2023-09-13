package com.discos.tienda.service;

import com.discos.tienda.dto.DiscoDTO;
import com.discos.tienda.model.Disco;
import com.discos.tienda.repository.IDiscoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DiscoService {

    final IDiscoRepository iDiscoRepository;

    public DiscoService(IDiscoRepository iDiscoRepository) {
        this.iDiscoRepository = iDiscoRepository;
    }

    public List<DiscoDTO> obtenerDiscos() {
        List<Disco> discoList = iDiscoRepository.findAll();
        List<DiscoDTO> discoDTOList = new ArrayList<>();
        for (Disco disco : discoList) {
            discoDTOList.add(new DiscoDTO(disco.getIdDisco(), disco.getTitulo(), disco.getAnioLanzamiento()));
        }

        return discoDTOList;
    }

    public DiscoDTO crearDisco(DiscoDTO discoDTO) {
        Disco disco = new Disco(
                null,
                discoDTO.getTitulo(),
                discoDTO.getAnioLanzamiento(),
                null,
                null
        );
        Disco discoRepository = iDiscoRepository.save(disco);
        return new DiscoDTO(
                discoRepository.getIdDisco(),
                discoRepository.getTitulo(),
                discoRepository.getAnioLanzamiento()
        );
    }

    public void eliminarDisco(Integer idDisco) {
        iDiscoRepository.deleteById(idDisco);
    }

    public DiscoDTO editarDisco(DiscoDTO discoDTO) {
        Disco discoExistente = iDiscoRepository.findById(discoDTO.getIdDisco()).get();
        if (discoExistente != null) {
            discoExistente.setTitulo(discoDTO.getTitulo());
            discoExistente.setAnioLanzamiento(discoDTO.getAnioLanzamiento());

            Disco discoActualizado = iDiscoRepository.save(discoExistente);
            return new DiscoDTO(
                    discoActualizado.getIdDisco(),
                    discoActualizado.getTitulo(),
                    discoActualizado.getAnioLanzamiento()
            );

        } else {
            throw new NoSuchElementException("No se encontró el disco con ID " + discoDTO.getIdDisco());

        }
    }

}
