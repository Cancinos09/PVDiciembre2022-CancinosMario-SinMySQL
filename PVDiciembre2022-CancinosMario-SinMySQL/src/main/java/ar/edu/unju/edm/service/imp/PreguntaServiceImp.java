package ar.edu.unju.edm.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pregunta;
import ar.edu.unju.edm.service.IPreguntaService;
import ar.edu.unju.edm.util.ListaPreguntas;

@Service
public class PreguntaServiceImp implements IPreguntaService {

	@Autowired
	private ListaPreguntas listaPreguntas;
//	@Autowired 
//	Pregunta pregunta;
	
	
	
	@Override
	public Pregunta getNewPregunta(){
		return new Pregunta();
	}
	@Override
	public ListaPreguntas crearListaPreguntas() {
		return new ListaPreguntas();
	}

	@Override
	public boolean guardarPregunta(Pregunta pregunta) {
		return listaPreguntas.getListaPreguntas().add(pregunta);
	}

	@Override
	public ListaPreguntas listarPreguntas() {
		return listaPreguntas;
	}
	
	@Override
	public Pregunta buscarPregunta(int codPregunta) {
		Optional<Pregunta> pregunta = listaPreguntas.getListaPreguntas().stream().filter(p->p.getCodigo()== codPregunta).findFirst();
		 return pregunta.get();
	}
	
	@Override
	public Pregunta buscarPreguntaPorNivel(int nivel) {
		Optional<Pregunta> pregunta = listaPreguntas.getListaPreguntas().stream().filter(p->p.getNivel() == nivel ).findFirst();
		return pregunta.get();
	}

	@Override
	public void modificarPregunta(Pregunta pregunta) {
		for(Pregunta p:listaPreguntas.getListaPreguntas()) {
			if(p.getCodigo() == pregunta.getCodigo()) {
				p.setEnunciado(pregunta.getEnunciado());
				p.setOpcion1(pregunta.getOpcion1());
				p.setOpcion2(pregunta.getOpcion2());
				p.setOpcion3(pregunta.getOpcion3());
				p.setOpcion4(pregunta.getOpcion4());
				p.setOpcionCorrecta(pregunta.getOpcionCorrecta());
			}
		}
	}

	@Override
	public void eliminarPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
	}

	@Override
	public Pregunta opcionCorrecta(int opcion) {
		Optional<Pregunta> opcionCorrecta = listaPreguntas.getListaPreguntas().stream().filter(pC -> pC.getOpcionCorrecta() == opcion).findFirst();
		return opcionCorrecta.get();
	}

	@Override
	public ListaPreguntas listarPreguntasPorNivel(int nivel) {
//		Creamos un objeto de tipo ListaPreguntas
		ListaPreguntas lP = new ListaPreguntas();
		lP.getListaPreguntas().clear();
//		recorremos la lista de preguntas con un objeto 'p' de tipo Pregunta
		for(Pregunta p: listaPreguntas.getListaPreguntas()) {
//			Si la pregunta 'p' coincide con el nivel
			if(p.getNivel() == nivel) {
//				Que contendra todos los objetos de tipo pregunta que coincidan con el nivel
				lP.getListaPreguntas().add(p);
			}
		}
//		retorna la lista de preguntas que tienen las preguntas del nivel pasado por parametro
		return lP;
	}
	
}
