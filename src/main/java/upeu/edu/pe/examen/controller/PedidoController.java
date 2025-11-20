package upeu.edu.pe.examen.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.examen.dto.PedidoDTO;
import upeu.edu.pe.examen.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO.Response>> listar() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @PostMapping
    public ResponseEntity<PedidoDTO.Response> guardar(@Valid @RequestBody PedidoDTO.Request request) {
        return new ResponseEntity<>(pedidoService.guardarPedido(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO.Response> actualizar(@PathVariable Long id, @Valid @RequestBody PedidoDTO.Request request) {
        return ResponseEntity.ok(pedidoService.actualizarPedido(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }
}