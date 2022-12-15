package ar.edu.unju.edm.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class Usuario {
	
	@Min(value=1000000, message="El DNI no es válido")
	private int dni; //clave primaria
	
	@NotEmpty(message="El campo 'Apellido' no puede estar vacío")
	@Size(min=3, max=30, message="El apellido debe contener entre 3 y 30 caracteres")
	private String apellido;
	
	@NotEmpty(message="El campo 'Nombre' no puede esatr vacío")
	@Size(min=3, max=30, message="El nombre debe contener entre 3 y 30 caracteres")
	private String nombre;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate FechaNacimiento;
	
	@NotNull(message="El campo 'Contraseña' no debe estar vacío")
	@NotBlank(message="La contraseña no debe poseer espacios en blanco")
	private String password;
	
	@NotEmpty(message="Debe elegir un tipo de usuario")
	private String tipoUsuario; //Docente - Estudiante
	
//	un usuario puede responder una o mas preguntas
	private List<Pregunta> preguntas = new ArrayList<Pregunta>();
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(int dni, String apellido, String nombre, LocalDate fechaNacimiento, String password,
			String tipoUsuario) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		FechaNacimiento = fechaNacimiento;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}
	

	public Usuario(int dni, String apellido, String nombre, LocalDate fechaNacimiento, String password,
			String tipoUsuario, List<Pregunta> preguntas) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		FechaNacimiento = fechaNacimiento;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.preguntas = preguntas;
	}
	

	public Usuario(@Min(value = 1000000, message = "El DNI no es válido") int dni,
			@NotNull(message = "El campo 'Contraseña' no debe estar vacío") @NotBlank(message = "La contraseña no debe poseer espacios en blanco") String password) {
		super();
		this.dni = dni;
		this.password = password;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", FechaNacimiento="
				+ FechaNacimiento + ", password=" + password + ", tipoUsuario=" + tipoUsuario + ", preguntas="
				+ preguntas + "]";
	}

	
	
	
}
