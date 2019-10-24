package com.bolsadeideas.springboot.app.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;


@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	
	
	
	
	//Envio de mensajes flash despues de hacer session 

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		
		SessionFlashMapManager flashMapManager = new SessionFlashMapManager();
		
		FlashMap flashMap = new FlashMap();
		
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
	
		flashMap.put("success", "inicio con exito");
		
//		flashMap.put("success","Hola" +authentication.getName()+ ",Ha iniciado sesion con exito!");
//		
//		if (authentication != null) {
//			logger.info("El usuario'" +authentication.getName()+ "'Ha iniciado sesión con exito'" );
//		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
	
}
