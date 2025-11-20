package upeu.edu.pe.examen.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upeu.edu.pe.examen.dto.PedidoDTO;
import upeu.edu.pe.examen.entity.Cliente;
import upeu.edu.pe.examen.entity.Pedido;
import upeu.edu.pe.examen.entity.Plato;
import upeu.edu.pe.examen.repository.ClienteRepository;
import upeu.edu.pe.examen.repository.PedidoRepository;
import upeu.edu.pe.examen.repository.PlatoRepository;
import upeu.edu.pe.examen.service.PedidoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PlatoRepository platoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PedidoDTO.Response> listarPedidos() {
        return pedidoRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO.Response guardarPedido(PedidoDTO.Request request) {
        Pedido pedido = new Pedido();

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + request.getClienteId()));

        Plato plato = platoRepository.findById(request.getPlatoId())
                .orElseThrow(() -> new EntityNotFoundException("Plato no encontrado con ID: " + request.getPlatoId()));

        pedido.setNumeroMesa(request.getNumeroMesa());
        pedido.setCliente(cliente);
        pedido.setPlato(plato);

        Pedido guardado = pedidoRepository.save(pedido);
        return mapToResponse(guardado);
    }

    @Override
    public PedidoDTO.Response actualizarPedido(Long id, PedidoDTO.Request request) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado con ID: " + id));

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + request.getClienteId()));

        Plato plato = platoRepository.findById(request.getPlatoId())
                .orElseThrow(() -> new EntityNotFoundException("Plato no encontrado con ID: " + request.getPlatoId()));

        pedido.setNumeroMesa(request.getNumeroMesa());
        pedido.setCliente(cliente);
        pedido.setPlato(plato);

        Pedido actualizado = pedidoRepository.save(pedido);
        return mapToResponse(actualizado);
    }

    @Override
    public void eliminarPedido(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("Pedido no encontrado con ID: " + id);
        }
        pedidoRepository.deleteById(id);
    }

    private PedidoDTO.Response mapToResponse(Pedido pedido) {
        PedidoDTO.Response response = new PedidoDTO.Response();
        response.setId(pedido.getId());
        response.setNumeroMesa(pedido.getNumeroMesa());
        response.setNombreCliente(pedido.getCliente().getNombre());
        response.setClienteId(pedido.getCliente().getId());
        response.setNombrePlato(pedido.getPlato().getNombre());
        response.setPrecioPlato(pedido.getPlato().getPrecio());
        response.setPlatoId(pedido.getPlato().getId());
        return response;
    }
}
