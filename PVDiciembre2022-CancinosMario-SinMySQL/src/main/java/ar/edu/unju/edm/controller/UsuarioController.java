package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	@GetMapping("/prueba")
	public ModelAndView blabla() {
		ModelAndView mav = new ModelAndView("docente_home");
		return mav;
	}
	
	
	@GetMapping("/login")
	public ModelAndView getLoginPage() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("usuario", usuarioService.getNewUsuario());
		return mav;
	}
	
	@PostMapping("/iniciarSesion")
	public ModelAndView getSesionUsuario(/*@Validated*/ @ModelAttribute("usuario")Usuario usuario /*, BindingResult bR*/) {
//		tenes que recorrer la lista en busca de un usuario que tenga el mismo dni y reemplazar los datos del usuario pasado por parametro
//		por otro usuario que creaste aca

		usuarioService.reemplazarUsuario(usuario);
		LOGGER.info("Creo que tas logeado pibe, verifiquemos datos" + usuario);
		
//		if(bR.hasErrors()) {
//			ModelAndView mav = new ModelAndView("login");
//			mav.addObject("usuario", usuarioService.getNewUsuario());
//			LOGGER.info("Los valores ingresados son incorrectos, redirigiendo a la pagina 'login'" + usuario);
//			return mav;
//		}
//		Si la lista de usuarios contiene al objeto de tipo usuario con el mismo dni y password
		if(usuarioService.loginUsuario(usuario.getDni(), usuario.getPassword())) {
			LOGGER.info("NO SE SI LLEGO HASTA ACA");
//			Preguntamos que tipo de usuario es, creo que habria que implementar algo aquisiño
			if(usuarioService.usuarioDocente(usuario.getTipoUsuario())) {
//				completamos con la pagina que se mostrara al usuario de tipo estudiante
				ModelAndView mav = new ModelAndView ("docente_home");
				return mav;
			}else {
//				completamos con la pagina que se mostrara al usuario de tipo estudiante
				ModelAndView mav = new ModelAndView ("estudiante_home");
				return mav;
			}

		}
//		en caso de que el usuario no coincida con los parametros colocados vamos a retornar la pagina de login otra ve
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("usuario", usuarioService.getNewUsuario());
		return mav;
	}
	@GetMapping("home_docente")
	public String getHomeDocentePage() {
		return "docente_home";
	}
	
	@GetMapping("/nuevo")
	public String getUsuarioNuevoPage(Model model) {
		model.addAttribute("usuario", usuarioService.getNewUsuario());
		
		LOGGER.info("Se asigno un nuevo objeto de tipo usuario a la pagina 'usuario_nuevo'");
		return "usuario_nuevo";	
	}
	
	@PostMapping("/guardado")
	public ModelAndView guardarYmostrarUsuario(@Validated @ModelAttribute("usuario")Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("usuario_nuevo");
			mav.addObject("usuario", usuario);
			LOGGER.info("Se produjo un error al validar datos del usuario, redirigiendo a la pagina 'usuario_nuevo'");
			return mav;
		}
		if(usuarioService.compararUsuarioRepetido(usuario)) {
			ModelAndView mav = new ModelAndView("usuario_editar");
			mav.addObject("usuario", usuario);
			LOGGER.info("Se produjo un error al validar datos del usuario, DNI REPETIDO, redirigiendo a la pagina 'usuario_nuevo'");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("usuario_lista");
		if(usuarioService.guardarUsuario(usuario)) {
			LOGGER.info("Se agrego un objeto de tipo usuario a la lista de usuarios");
		}
		mav.addObject("listaUsuarios", usuarioService.listarUsuarios().getListaUsuarios());
		LOGGER.info("Se mando la lista de usuarios a la pagina 'usuario_lista'");
		if(usuarioService.usuarioDocente(usuario.getTipoUsuario())) {
			return mav;
		} else {
			mav = new ModelAndView("estudiante_home");
		}
		return mav;
		
		
	}
	@GetMapping("/usuario_lista")
	public ModelAndView getListaUsuariosPage() {
		ModelAndView mav = new ModelAndView("usuario_lista");
		mav.addObject("listaUsuarios", usuarioService.listarUsuarios().getListaUsuarios());
		LOGGER.info("Se mando la lista de usuarios a la pagina 'usuarios_lista'");
		return mav;
	}
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarUsuarioPage (@PathVariable("dni")int dni) {
		LOGGER.info("Se invoca la pagina para editar alumno pasando como parametro el dni");
		ModelAndView mav = new ModelAndView("usuario_editar");
		Usuario usuario = usuarioService.buscarUsuarioPorDni(dni);
		mav.addObject("usuario", usuario);
		return mav;
	}
	
	@PostMapping("/editar")
	public ModelAndView getListaUsuariosModificadoPage(@Validated @ModelAttribute("usuario")Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("usuario_nuevo");
			mav.addObject("usuario", usuario);
			LOGGER.info("Se produjo un error al validar datos del usuario, redirigiendo a la pagina 'usuario_editar'");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/usuario/usuario_lista");
		if(usuarioService.modificarUsuario(usuario)) {
			LOGGER.info("Los datos del usuario fueron modificados con exito");
		}
		
		return mav;
		
	}
	@GetMapping("/eliminar/{dni}")
	public ModelAndView eliminarUsuario(@PathVariable("dni")int dni) {
		LOGGER.info("Se obtiene el dni del usuario pasado por parametro");
		ModelAndView mav = new ModelAndView("redirect:/usuario/usuario_lista");
		LOGGER.info("Se busca el numero de dni del usuario en la lista de usuarios");
		usuarioService.eliminarUsuario(dni);
		return mav;
	}

	
//	@GetMapping("/usuarios")
//	public ModelAndView getListaUsuariosPage() {
//		ModelAndView mav = new ModelAndView("usuario_lista");
//		mav.addObject(null, mav)
//	}
	
}
