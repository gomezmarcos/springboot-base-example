package edu.marcos.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.marcos.test.entity.Equipo;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Long>{
	@Override
	Iterable<Equipo> findAll();
	
	@SuppressWarnings("unchecked")
	@Override
	Equipo save(Equipo equipo);
}