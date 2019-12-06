package com.bolsadeideas.springboot.app.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.app.models.entity.Productor;
import com.bolsadeideas.springboot.app.models.service.IProductorService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

@Controller
public class ProductorController {

	//envio de mensajes flash
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	
	
	@Autowired
	private IProductorService productorService;
	
	
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
}
