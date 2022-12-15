package ar.edu.unju.edm.service;

//import java.util.ArrayList;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.util.ListaUsuarios;

public interface IUsuarioService {
// queda un poco en duda sobre si los metodos son voids o booleanos 
	
//	metodo para obtener un solo usuario retornando el objeto de tipo usuario
	public Usuario getNewUsuario();
	
//	metodo buscar un usuario con numero de dni, similar al anterior con la diferencia de los parametros
	public Usuario buscarUsuarioPorDni(long dni);
	
//	metodo que sobreescribe los datos del usuario que solo tiene 2 parametros completados
	public void reemplazarUsuario(Usuario usuario);

//	metodo booleano que devuelve true si se guardo el usuario
	public boolean guardarUsuario(Usuario usuario);
	
//	metodo que retorna un objeto de tipo ListaUsuarios
	public ListaUsuarios listarUsuarios();

//	metodo que modifica los valores del objeto usuario pasado por parametro
	public boolean modificarUsuario(Usuario usuario);
	
//	metodo que elimina el usuario
	public void eliminarUsuario(long dni);
	
	public boolean compararUsuarioRepetido (Usuario usuario);
	
//	metodo que compara dni y password con la lista de usuarios
	public boolean loginUsuario(int dni, String password);
	
//	metodo que compara el tipo de usuario, si es docente o estudiante
	public boolean usuarioDocente(String tipoUsuario);
	
}
