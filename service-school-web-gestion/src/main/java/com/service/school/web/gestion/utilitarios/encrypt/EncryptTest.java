package com.service.school.web.gestion.utilitarios.encrypt;

public class EncryptTest {
	
	public static void main(String[] args) {
		try {
			Encrypt.init();
			System.out.println("+Encrypt:");	
			System.out.println(Encrypt.encrypt("1"));
			System.out.println("-Decrypt:");
			System.out.println(Encrypt.decrypt("KN67p6T1PAg="));
		} catch (EncryptException e) {
			e.printStackTrace();
		}
	}

}
