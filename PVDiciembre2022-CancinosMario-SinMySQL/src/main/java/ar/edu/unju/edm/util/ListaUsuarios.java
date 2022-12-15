package ar.edu.unju.edm.util;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.model.Usuario;

@Component
public class ListaUsuarios {

	
	private ArrayList<Usuario> listaUsuarios;
	
	public ListaUsuarios() {
		listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario(43939792, "Cancinos", "Mario", LocalDate.of(2002, 03, 9),"root","docente"));
		listaUsuarios.add(new Usuario(42730256, "Peña", "Lara", LocalDate.of(2000, 07,28),"laris", "estudiante"));
	}
	

	public ListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		super();
		this.listaUsuarios = listaUsuarios;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	@Override
	public String toString() {
		return "ListaUsuarios [listaUsuarios=" + listaUsuarios + "]";
	}
	
}
