package cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.domain.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
	Optional<Sucursal> findById(Integer id);
    List<Sucursal> findAll();
    @SuppressWarnings("unchecked")
	Sucursal save(Sucursal sucursal);
    void deleteById(Integer id);
}