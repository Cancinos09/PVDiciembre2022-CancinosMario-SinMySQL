package ar.edu.unju.edm.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.model.Pregunta;

@Component
public class ListaPreguntas {

	
	private ArrayList<Pregunta> listaPreguntas;
	
	public ListaPreguntas() {
		listaPreguntas = new ArrayList<Pregunta>();
//		nivel1
		
		listaPreguntas.add(new Pregunta(112,"¿Cuántos sentidos tiene el cuerpo humano?",1 ,"4","3","5","6", 3));
		listaPreguntas.add(new Pregunta(113,"¿Cuántos dientes tenemos en promedio?",1 ,"26","36","28","33", 2));
		listaPreguntas.add(new Pregunta(114,"¿Hay dos huellas dactilares iguales?",1 ,"Solo los gemelos","No","Solo los mellizos","Si",2 ));
		listaPreguntas.add(new Pregunta(115,"¿Cuántas células componen nuestro cuerpo?",1 ,"30-40 billones","50-60 billones","50 billones","10 billones", 1));
		listaPreguntas.add(new Pregunta(116," ¿Cuántas articulaciones tiene el cuerpo humano?",1 ,"150","130","200","230", 4));
		
//		nivel2
		listaPreguntas.add(new Pregunta(212, "El periodo en el que aparecieron la agricultura y los asentamientos sedentarios se llama:", 2, "Neolítico", "Edad Media", "Paleolítico", "Revolución industrial",1));
		listaPreguntas.add(new Pregunta(213, "¿Cuándo se inventó la escritura?", 2, "Hace 20 mil años", "En el IV milenio a.C.", "En el año 0", "En el siglo I d.C", 2));
		listaPreguntas.add(new Pregunta(214, "¿Cómo se llamaban los gobernantes del antiguo Egipto?", 2, "Faraones", "Basileos", "Alcaldes", "Profetas", 1));
		listaPreguntas.add(new Pregunta(215, "Según las leyendas de la antiguedad, ¿quiénes fundaron a Roma?", 2, "Aquiles y Odiseo", "Alejandro Magno y Ptolomeo", "Rómulo y Remo", "Dios",3));
		listaPreguntas.add(new Pregunta(216, "¿Cuál de estos emperadores fue alumno del filósofo griego Aristóteles?", 2, "Carlomagno", "Trajano", "Alejandro Magno", "Napoleon Bonaparte",1 ));
		
//		nivel3
		listaPreguntas.add(new Pregunta(312,"¿Cuántos océanos hay en la Tierra?",3,"4","8","5","6",3));
		listaPreguntas.add(new Pregunta(313,"¿Qué país tiene más habitantes?",3,"China","India","Estados Unidos","Rusia",1));
		listaPreguntas.add(new Pregunta(314,"¿Qué país es el más grande del mundo?",3,"Estados Unidos","Rusia","Brasil","China",2));
		listaPreguntas.add(new Pregunta(315," ¿En qué país se hablan más idiomas?",3,"Papúa Nueva Guinea - Australia","Marruecos - Africa","Estados Unidos - Norteamérica","Alemania - Europa",1));
		listaPreguntas.add(new Pregunta(316,"¿Qué país cuenta con un mayor número de volcanes?",3,"Chile","Perú","Estados Unidos","Venezuela",3));
	}


	public ArrayList<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}



	@Override
	public String toString() {
		return "ListaPreguntas [listaPreguntas=" + listaPreguntas + "]";
	}
	
}
