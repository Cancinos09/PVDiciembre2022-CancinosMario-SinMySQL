package ar.edu.unju.edm.service.imp;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;
import ar.edu.unju.edm.util.ListaUsuarios;
@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private ListaUsuarios listaUsuarios;
	
	
	@Override
	public Usuario getNewUsuario() {
		return new Usuario();
	}

	@Override
	public Usuario buscarUsuarioPorDni(long dni) {
		
//		creamos un optional del tipo usuario. Le asignamos el objeto de tipo alumno que coincida con el valor del dni
		Optional<Usuario> usuario = listaUsuarios.getListaUsuarios().stream().filter(u -> u.getDni()==dni).findFirst();
		
		return usuario.get();
	}
	
	@Override
	public void reemplazarUsuario(Usuario usuario) {
		for(Usuario u: listaUsuarios.getListaUsuarios()) {
			if(u.getDni() == usuario.getDni()) {
				usuario.setApellido(u.getApellido());
				usuario.setFechaNacimiento(u.getFechaNacimiento());
				usuario.setNombre(u.getNombre());
				usuario.setTipoUsuario(u.getTipoUsuario());
				usuario.setPreguntas(u.getPreguntas());
			}
		}
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
//		devuelve true si se pudo agregar el usuario al array
		return listaUsuarios.getListaUsuarios().add(usuario);
	}

	@Override
	public ListaUsuarios listarUsuarios() {
		return listaUsuarios;
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) {
		boolean modificado=false;
		for(Usuario u:listaUsuarios.getListaUsuarios()) {
			if(u.getDni()==usuario.getDni()) {
				u.setApellido(usuario.getApellido());
				u.setDni(usuario.getDni());
				u.setFechaNacimiento(usuario.getFechaNacimiento());
				u.setNombre(usuario.getNombre());
				u.setPassword(usuario.getPassword());
				modificado=true;
			}
		}
		return modificado;
	}

	@Override
	public void eliminarUsuario(long dni) {
		for(Usuario u:listaUsuarios.getListaUsuarios()) {
			if(u.getDni()==dni) {
				listaUsuarios.getListaUsuarios().remove(u);
			}
		}
	}

	@Override
	public boolean compararUsuarioRepetido(Usuario usuario) {
		boolean repetido=false;
		for(Usuario u:listaUsuarios.getListaUsuarios()) {
			if(u.getDni() == usuario.getDni()) {
				repetido = true;
			}
		}
		return repetido;
	}

	@Override
	public boolean loginUsuario(int dni, String password) {
		boolean logeado=true;
		for(Usuario u: listaUsuarios.getListaUsuarios()) {
			if(u.getDni()==dni && u.getPassword()==password) {
				return logeado;
			}
		}
		return logeado;
	}

	@Override
	public boolean usuarioDocente(String tipoUsuario) {
		boolean docente=false;
//		si el tipo de usuario contiene la palabra "docente" entonces el valor del metodo es verdadero (usuarioDocente = true)
		if(tipoUsuario.equals("docente")) {
			docente = true;
		}
		return docente;
	}

}
