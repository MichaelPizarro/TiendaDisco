package com.discos.tienda.controller;


import com.discos.tienda.service.ArtistaService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArtistaController {

    final ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }
    @GetMapping("/")
    public String mostrarInicio(Model model, @Param("palabraClave") String palabraClave){

        List<com.discos.tienda.dto.ArtistaDiscoDTO> listaArtistasDiscosDTO;

        listaArtistasDiscosDTO = artistaService.obtenerListaPalabra(palabraClave);
        List<String> generos = artistaService.obtenerGenerosDeArtistas();

        model.addAttribute("listaArtistasDiscosDTO", listaArtistasDiscosDTO);
        model.addAttribute("listCategories", generos);

        return "index";
    }
}
