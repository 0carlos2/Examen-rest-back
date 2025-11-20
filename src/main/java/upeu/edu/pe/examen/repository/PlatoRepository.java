package upeu.edu.pe.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.examen.entity.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
}
