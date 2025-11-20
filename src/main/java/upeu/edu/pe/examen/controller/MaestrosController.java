package upeu.edu.pe.examen.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upeu.edu.pe.examen.entity.Cliente;
import upeu.edu.pe.examen.entity.Plato;
import upeu.edu.pe.examen.service.MaestrosService;

import java.util.List;

@RestController
@RequestMapping("/api/maestros")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MaestrosController {

    private final MaestrosService maestrosService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(maestrosService.listarClientes());
    }

    @GetMapping("/platos")
    public ResponseEntity<List<Plato>> listarPlatos() {
        return ResponseEntity.ok(maestrosService.listarPlatos());
    }
}
