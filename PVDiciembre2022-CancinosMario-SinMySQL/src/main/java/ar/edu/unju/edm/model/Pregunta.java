package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

//import org.springframework.beans.factory.annotation.Autowired;
@Component
public class Pregunta {
	
	@NotNull(message="El campo 'Codigo' no puede estar vacío")
	private int codigo; //clave primaria

	@NotEmpty(message="El enunciado no puede estar en blanco")
	private String enunciado;

	@NotNull(message="Debe seleccionar un nivel")
	private int nivel;
	
	@NotEmpty(message="El campo 'Opcion1' no puede esatr vacio")
	private String opcion1;
	
	@NotEmpty(message="El campo 'Opcion2' no puede estar vacío")
	private String opcion2;
	
	@NotEmpty(message="El campo 'Opcion3' no puede estar vacío")
	private String opcion3;
	
	@NotEmpty(message="El campo 'Opcion4' no puede estar vacío")
	private String opcion4;
	
	@NotNull
	private int opcionCorrecta;
	
	private double puntaje;
	
//	Muchas preguntas pueden ser respondidas por un usuario
//	@Autowired
//	private Usuario usuario;
	
	public Pregunta() {
		// TODO Auto-generated constructor stub
	}

	public Pregunta(int codigo, String enunciado, int nivel, String opcion1, String opcion2, String opcion3,
			String opcion4, int opcionCorrecta, double puntaje) {
		super();
		this.codigo = codigo;
		this.enunciado = enunciado;
		this.nivel = nivel;
		this.opcion1 = opcion1;
		this.opcion2 = opcion2;
		this.opcion3 = opcion3;
		this.opcion4 = opcion4;
		this.opcionCorrecta = opcionCorrecta;
		this.puntaje = puntaje;
	}
	

	

	

	public Pregunta(@NotNull(message = "El campo 'Codigo' no puede estar vacío") int codigo,
			@NotEmpty(message = "El enunciado no puede estar en blanco") String enunciado,
			@NotNull(message = "Debe seleccionar un nivel") int nivel,
			@NotEmpty(message = "El campo 'Opcion1' no puede esatr vacio") String opcion1,
			@NotEmpty(message = "El campo 'Opcion2' no puede estar vacío") String opcion2,
			@NotEmpty(message = "El campo 'Opcion3' no puede estar vacío") String opcion3,
			@NotEmpty(message = "El campo 'Opcion4' no puede estar vacío") String opcion4,
			@NotNull int opcionCorrecta) {
		super();
		this.codigo = codigo;
		this.enunciado = enunciado;
		this.nivel = nivel;
		this.opcion1 = opcion1;
		this.opcion2 = opcion2;
		this.opcion3 = opcion3;
		this.opcion4 = opcion4;
		this.opcionCorrecta = opcionCorrecta;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getOpcion1() {
		return opcion1;
	}

	public void setOpcion1(String opcion1) {
		this.opcion1 = opcion1;
	}

	public String getOpcion2() {
		return opcion2;
	}

	public void setOpcion2(String opcion2) {
		this.opcion2 = opcion2;
	}

	public String getOpcion3() {
		return opcion3;
	}

	public void setOpcion3(String opcion3) {
		this.opcion3 = opcion3;
	}

	public String getOpcion4() {
		return opcion4;
	}

	public void setOpcion4(String opcion4) {
		this.opcion4 = opcion4;
	}

	public int getOpcionCorrecta() {
		return opcionCorrecta;
	}

	public void setOpcionCorrecta(int opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public String toString() {
		return "Pregunta [codigo=" + codigo + ", enunciado=" + enunciado + ", nivel=" + nivel + ", opcion1=" + opcion1
				+ ", opcion2=" + opcion2 + ", opcion3=" + opcion3 + ", opcion4=" + opcion4 + ", opcionCorrecta="
				+ opcionCorrecta + ", puntaje=" + puntaje + "]";
	}

	

	
	
	
}
