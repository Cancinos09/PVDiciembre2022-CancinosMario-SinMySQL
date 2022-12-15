package ar.edu.unju.edm.service;


import ar.edu.unju.edm.model.Pregunta;
import ar.edu.unju.edm.util.ListaPreguntas;

public interface IPreguntaService {

	public Pregunta getNewPregunta();
	
//	public ListaPreguntas getNewListaPreguntas();
	
	public boolean guardarPregunta(Pregunta pregunta);
	
	public ListaPreguntas crearListaPreguntas();
	
	public ListaPreguntas listarPreguntas();
	
	public Pregunta buscarPregunta(int codPregunta);
	
	public Pregunta buscarPreguntaPorNivel(int nivel);
	
	public void modificarPregunta(Pregunta pregunta);
	
//	en duda sobre si se puede eliminar una pregunta, creo que es mejor dejarla asi y cambiar el contenido solamente
	public void eliminarPregunta (Pregunta pregunta);
	
	public Pregunta opcionCorrecta (int opcion);
	
	public ListaPreguntas listarPreguntasPorNivel(int nivel);
	
}
