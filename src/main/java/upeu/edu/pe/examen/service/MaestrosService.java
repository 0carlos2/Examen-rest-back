package upeu.edu.pe.examen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upeu.edu.pe.examen.entity.Cliente;
import upeu.edu.pe.examen.entity.Plato;
import upeu.edu.pe.examen.repository.ClienteRepository;
import upeu.edu.pe.examen.repository.PlatoRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MaestrosService {

    private final ClienteRepository clienteRepository;
    private final PlatoRepository platoRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public List<Plato> listarPlatos() {
        return platoRepository.findAll();
    }
}