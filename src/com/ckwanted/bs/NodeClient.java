package com.ckwanted.bs;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

import com.ckwanted.receta.*;
import com.ckwanted.user.*;

public class NodeClient {
	

	public static void main(String[] args) {
		
		Form form = new Form();
		form.param("username", "test");
		form.param("password", "test");
		
		WebClient clientLogin = WebClient.create("http://daw2-p2.app:8888/serv");
		WebClient client = WebClient.create("http://daw2-p2.app:8888/serv");
		
		clientLogin.path("user/login");
		Usuario cuserlogin = clientLogin.type(MediaType.APPLICATION_FORM_URLENCODED).post(form, Usuario.class);
		
		client.accept("application/xml");
		client.path("node/18");
		
		Receta xresult = client.get(Receta.class);
		System.out.println("Titulo : " + xresult.getTitle());
		System.out.println("Data : " + xresult.getData());
		System.out.println("Nid : " + xresult.getNid());
		System.out.println("Fecha del cambio : " + xresult.getChanged());
		System.out.println("Description : " + xresult.getBody().getUnd().getItem().getValue().toString());

	}

}
