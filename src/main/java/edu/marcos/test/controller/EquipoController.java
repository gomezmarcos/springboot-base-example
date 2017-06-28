package edu.marcos.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.marcos.test.api.EquipoDto;
import edu.marcos.test.entity.Equipo;
import edu.marcos.test.repository.EquipoRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/equipos")
@Api(value="AdministradorDeEquiposAFA", description="Operaciones permitidas sobre equipos de la asociacion")
public class EquipoController {
	@Autowired
	private EquipoRepository equipoRepository;
	
	@RequestMapping("/id/{id}")
	public EquipoDto findById(@PathVariable(value="id") Long id){
		 Equipo equipo = equipoRepository.findOne(id);
		 return EquipoDto.toApi(equipo);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<EquipoDto> findAll(){
		return EquipoDto.toApi(equipoRepository.findAll());
	}
	
	/**
	 * Este metodo fue creado con GET porque no queria usar SoapUI/POST para probar. Vagancia.
	 * @param nombre
	 * @return
	 */
	@RequestMapping(value="/name/{name}", method = RequestMethod.POST)
	public EquipoDto save(@PathVariable(name="name") String nombre){
		Equipo equipo = new Equipo(nombre);
		return EquipoDto.toApi(equipoRepository.save(equipo));
	}
}
