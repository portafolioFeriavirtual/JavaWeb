package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Productor;

import com.bolsadeideas.springboot.app.models.service.IProductorService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

@Controller

@SessionAttributes("productor")
public class ProductorController {

	//envio de mensajes flash
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	
	
	@Autowired
	private IProductorService productorService;
	
	
	@RequestMapping(value = "/form_contratoproductor")
	public String crear(Map<String, Object> model) {

		Productor producto = new Productor();
		model.put("producto", producto);
		model.put("titulo", "Formulario de Contrato productor");
		return "contrato_productor/form";
	}
	
	

	     

	 

	
	
	
	@RequestMapping(value = "/listaproductor")
	public String listarproductor(@RequestParam(name = "page", defaultValue = "0") int page, Model model,
			Authentication authentication) {
		
		if (authentication != null) {
			logger.info("Hola usuario autenticado. tu username es: " .concat(authentication.getName()));
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    
		if (auth != null) {
			logger.info("forma estatica --- Hola usuario autenticado con SecurityContextHolder.getContext().getAuthentication();. tu username es: " .concat(auth.getName()));
		}
	
		Pageable pageRequest = PageRequest.of(page, 4);
		
		Page<Productor> productor = productorService.findAll(pageRequest);
		
		PageRender<Productor> pageRender = new PageRender<>("/listaproductor",productor );
		model.addAttribute("titulo", "Listado Contrato Productor");
		model.addAttribute("productor", productor);
		model.addAttribute("page", pageRender);
		return "contrato_productor/listarproductor";
	}
	
	
	@GetMapping(value="/verContratos/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Productor productor =  productorService.findOne(id);
		if (productor == null) {
			flash.addAttribute("error", "El productor no existe en la base de datos");
			return "redirect:/listar";
		}
		
		model.put("productor", productor);
		model.put("titulo", "Contrato productor :" + productor.getNombre_productor());
		
		return "contrato_productor/ver";
	}
	
	
	
}
