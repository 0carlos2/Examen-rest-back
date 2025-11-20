package upeu.edu.pe.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.examen.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
