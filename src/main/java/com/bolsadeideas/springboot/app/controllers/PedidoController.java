package com.bolsadeideas.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Estado;
import com.bolsadeideas.springboot.app.models.entity.ItemPedido;
import com.bolsadeideas.springboot.app.models.entity.Pedido;
import com.bolsadeideas.springboot.app.models.entity.Producto;
import com.bolsadeideas.springboot.app.models.entity.Subasta;
import com.bolsadeideas.springboot.app.models.service.IClienteService;
import com.bolsadeideas.springboot.app.models.service.ISubastaService;


@Controller
@RequestMapping("/pedido")
@SessionAttributes("pedido")
public class PedidoController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private ISubastaService subastaService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,RedirectAttributes flash ) {

		Cliente cliente = clienteService.findOne(clienteId);
	
		if (cliente == null) {
			  flash.addAttribute("error", "usuario no encontrado en la base de datos");
			  return "redirect:/listar";
		}
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		
		model.put("pedido", pedido);
		model.put("titulo", "Crear Aporte");
		
		return "pedido/form";
	}
	

     @GetMapping(value = "/cargar-productos/{term}", produces = {"application/json"})
     public @ResponseBody List<Producto> cargarProductos(@PathVariable String term){
    	  return clienteService.finByNombre(term);
     }
   
     @PostMapping("/form")
     public String guardar(Pedido pedido , @RequestParam(name = "item_id[]", required = false) Long [] itemId,
    		 @RequestParam(name = "cantidad[]", required = false) Integer[] cantidad,
    		 RedirectAttributes flash , SessionStatus status) {
              int estado = 1;
          for (int i = 0; i < itemId.length; i++) {
			
        	Producto producto = clienteService.findProductoById(itemId[i]);
			ItemPedido linea = new ItemPedido();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			pedido.addItemPedido(linea);
		
			Long idUsuario = pedido.cliente.getId();
			
			Subasta suBd = subastaService.findByIdCliente(idUsuario);
			
			if (suBd == null) {
				Subasta su = new Subasta();
				su.setIdCliente(idUsuario);
				su.setMonto_transporte(100);
				su.setNombre_transportista("hola");
				
				subastaService.save(su);

			    
			}
			
			// crear la subasta
			
			
			
			log.info("ID: " + itemId[i].toString() + " , cantidad : " + cantidad[i].toString());
		}
       clienteService.savePedido(pedido);
       status.setComplete();
       flash.addAttribute("success", "Pedido Creado con exito");   
    	 return "redirect:/ver/" + pedido.getCliente().getId();
     }

}

