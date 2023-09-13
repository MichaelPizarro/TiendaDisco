package com.discos.tienda.controllerApi;

import com.discos.tienda.dto.ArtistaDiscoDTO;
import com.discos.tienda.dto.DiscoDTO;
import com.discos.tienda.service.ArtistaService;
import com.discos.tienda.service.DiscoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiscoControllerApi {

    final DiscoService discoService;
    final ArtistaService artistaService;
    public DiscoControllerApi(DiscoService discoService, ArtistaService artistaService) {
        this.discoService = discoService;
        this.artistaService = artistaService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<DiscoDTO>> listarDiscos(Model model) {
        return new ResponseEntity<>(discoService.obtenerDiscos(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<DiscoDTO> crearDisco(@RequestBody DiscoDTO discoDTO){

        DiscoDTO discoDTO1 = discoService.crearDisco(discoDTO);

        return new ResponseEntity<>(discoDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idDisco}")
    public ResponseEntity<List<DiscoDTO>> eliminarDisco(@PathVariable("idDisco") Integer idDisco) {
        discoService.eliminarDisco(idDisco);
        return new ResponseEntity<>(discoService.obtenerDiscos(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<DiscoDTO> editarDisco(@RequestBody DiscoDTO discoDTO){

        DiscoDTO discoDTO1Editado = discoService.editarDisco(discoDTO);

        return new ResponseEntity<>(discoDTO1Editado, HttpStatus.OK);
    }
    @GetMapping("list/{palabraClave}")
    public ResponseEntity<List<ArtistaDiscoDTO>> obtenerDiscosPorFiltro(@PathVariable("palabraClave") String palabraClave){
        return new ResponseEntity<>(artistaService.obtenerListaPalabra(palabraClave), HttpStatus.OK);
    }
}
