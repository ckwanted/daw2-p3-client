package com.ckwanted.bs;

import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.client.WebClient;
import com.ckwanted.receta.*;
import com.ckwanted.ss.*;
import com.ckwanted.user.*;

public class NodeClient {
	
	public static WebClient client, clientLogin;
	public static Usuario usuario;
	public static Receta result;
	
	public static Eliminar eliminar;
	
	public static String eliminarReturn;
	
	public static void recuperarInformacionDrupal() {

		Form form = new Form();
		form.param("username", "test");
		form.param("password", "test");
		
		clientLogin = WebClient.create("http://daw2-p2.app:8888/serv");
		client = WebClient.create("http://daw2-p2.app:8888/serv");
		
		clientLogin.path("user/login");
		usuario = clientLogin.type(MediaType.APPLICATION_FORM_URLENCODED).post(form, Usuario.class);
		
		client.accept("application/xml");
		client.path("node/18");
		
		result = client.get(Receta.class);
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("***** Recuperando datos del nodo 18 *****");
		System.out.println("** Recuperando datos del nodo 18");
		System.out.println("** Titulo : " + result.getTitle());
		System.out.println("** Data : " + result.getData());
		System.out.println("** Nid : " + result.getNid());
		System.out.println("** Fecha del cambio : " + result.getChanged());
		System.out.println("** Description : " + result.getBody().getUnd().getItem().getValue().toString());
		System.out.println("--------------------------------------------------------------------------------\n");
		
	}
	
	public static void tratamientoSOAP(SimpleService port) {
		System.out.println("Invocando la operación de eliminar...");
		
		eliminar = new Eliminar();
        eliminar.setIn(result.getBody().getUnd().getItem().getValue().toString());
        eliminarReturn = port.eliminar(eliminar.getIn());
        System.out.println("eliminar return = " + eliminarReturn);
		
		System.out.println("--------------------------------------------------------------------------------\n");
	}
	
	public static void guardarEnDrupal() {
		Form form = new Form();
		form.param("type", "receta");
		form.param("body[und][0][value]", eliminarReturn);
		
		WebClient client3 = WebClient.create("http://daw2-p2.app:8888/serv");
		client3.accept("application/xml");
		client3.path("node/18");
		
		System.out.println("user" + usuario.getSessid());
		
		Cookie cookie = new Cookie(usuario.getSessionName(), usuario.getSessid());
		client3.cookie(cookie);
		client3.header("X-CSRF-Token", usuario.getToken()); 
		
		String rsp = client3.type(MediaType.APPLICATION_FORM_URLENCODED).put(form,String.class);
		
		System.out.println("Respuesta: " + rsp);

	}
	
}
