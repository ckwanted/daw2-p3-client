package com.ckwanted.bs;

import org.apache.cxf.tools.wsdlto.WSDLToJava;

public class CodeGenerator {

	public static void main(String[] args) {
		
		WSDLToJava.main(new String[] {
			"-client",
			"-d", "src",
			"src/main/resources/SimpleService.wsdl"
		});
		
		System.out.println("Archivos generados correctamente ...");

	}

}
