package com.dao;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Stegnography {
	public static String encryption(String text, String key) {
		String stegno = "";
		try {
			// Create key and cipher
			SecretKeySpec stegno1 = new SecretKeySpec(key.getBytes(), "STEGNO");
			
			Cipher cipher = Cipher.getInstance("STEGNO");
			// encrypt the text
			cipher.init(Cipher.ENCRYPT_MODE, stegno1);
			byte[] encrypted = cipher.doFinal(text.getBytes());
			System.err.println(new String(encrypted));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stegno;
	}

	public static String decryption(String text, String key){
		String ekey = "";
		try {
			// Create key and cipher
			Key stegnoKey = new SecretKeySpec(key.getBytes(), "STEGNO");
			Cipher cipher = Cipher.getInstance("STEGNO");
			// encrypt the text
			cipher.init(Cipher.ENCRYPT_MODE, stegnoKey);
			byte[] encrypted = cipher.doFinal(text.getBytes());
			System.err.println(new String(encrypted));
			ekey = new String(encrypted);
			// decrypt the text
			cipher.init(Cipher.DECRYPT_MODE, stegnoKey);
			String decrypted = new String(cipher.doFinal(encrypted));
			System.err.println(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ekey;
	}
}
