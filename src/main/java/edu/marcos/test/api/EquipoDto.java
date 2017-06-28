package edu.marcos.test.api;

import java.util.ArrayList;
import java.util.List;

import edu.marcos.test.entity.Equipo;

public class EquipoDto {
	private Long id;
	private String nombre;
	
	private EquipoDto(){};

	public static EquipoDto toApi(Equipo equipo){
		EquipoDto api = new EquipoDto();
		api.id = equipo.getId();
		api.nombre = equipo.getName();
		return api;
	}
	
	public static Iterable<EquipoDto> toApi(Iterable<Equipo> equipos){
		List<EquipoDto> apis = new ArrayList<EquipoDto>();
		for (Equipo equipo : equipos)
			apis.add(toApi(equipo));
		return apis;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Este metodo fue creado para demostrar que el JSON se arma con el resultado de los GETTERS de la clase
	 * @return
	 */
	public String getTitulos(){
		return "3";
	}

}
