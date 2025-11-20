package upeu.edu.pe.examen.service;


import upeu.edu.pe.examen.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {

    List<PedidoDTO.Response> listarPedidos();
    PedidoDTO.Response guardarPedido(PedidoDTO.Request request);
    PedidoDTO.Response actualizarPedido(Long id, PedidoDTO.Request request);
    void eliminarPedido(Long id);
}
