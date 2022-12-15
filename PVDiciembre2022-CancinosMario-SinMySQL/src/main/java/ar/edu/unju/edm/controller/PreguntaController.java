package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Pregunta;
import ar.edu.unju.edm.service.IPreguntaService;
@Controller
@RequestMapping("/pregunta")
public class PreguntaController {
	
	@Autowired
	IPreguntaService preguntaService;
	private static final Log LOGGER = LogFactory.getLog(PreguntaController.class);
	
	@GetMapping("/nivel")
	public ModelAndView getElegirNivelPreguntaPage() {
//		Se mando la lista de preguntas
		ModelAndView mav = new ModelAndView("estudiante_home");
		mav.addObject("listaPreguntas", preguntaService.listarPreguntas().getListaPreguntas());
		return mav;
	}
	
	@GetMapping("/nivel/{n}")
	public ModelAndView getPreguntaNivel(@PathVariable("n")int nivel) {
		LOGGER.info("Creamos una nueva vista que redirigira a la pagina 'pregunta_evaluacion' que contendra el objeto de tipo pregunta del nivel pasado por parametro");
		ModelAndView mav = new ModelAndView("pregunta_evaluacion");
		LOGGER.info("Buscamos y agregamos la pregunta que coincide con el nivel pasado por parámetro");
		mav.addObject("listaPreguntas", preguntaService.listarPreguntasPorNivel(nivel).getListaPreguntas());
		return mav;
	}

	@GetMapping("/todas")
	public ModelAndView getListarTodasLasPreguntasPage () {
		ModelAndView mav = new ModelAndView ("pregunta_listaPreguntas");
		mav.addObject("listaPreguntas", preguntaService.listarPreguntas().getListaPreguntas());
		return mav;
	}
	
//	metodo para modificar pregunta
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarPreguntaPage (@PathVariable("codigo")int codigo) {
//		cuando hayamos recuperado el codigo creamos un Model que nos redirigira a la pagina para editar la pregunta
		ModelAndView mav = new ModelAndView("pregunta_editar");
		Pregunta pregunta = preguntaService.buscarPregunta(codigo);
		mav.addObject("pregunta", pregunta);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView getListaConPreguntaModificadaPage(@Validated @ModelAttribute("pregunta")Pregunta pregunta, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("Ocurrio un error en la validacion de datos");
			ModelAndView mav = new ModelAndView("pregunta_editar");
			mav.addObject("pregunta", pregunta);
			return mav;
		}
		ModelAndView mav = new ModelAndView("pregunta_listaPreguntas");
		preguntaService.modificarPregunta(pregunta);
		mav.addObject("listaPreguntas", preguntaService.listarPreguntas().getListaPreguntas());
		return mav;
	}
	
	
	
}
