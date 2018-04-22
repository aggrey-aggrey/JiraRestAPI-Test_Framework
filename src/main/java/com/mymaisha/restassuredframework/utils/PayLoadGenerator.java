package com.mymaisha.restassuredframework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayLoadGenerator {
	private static Logger log = LogManager.getLogger(PayLoadGenerator.class.getName());
	public static String generatePayLoadString(String filename){
		log.info("Inside PayloadConverter function");
		String filePath = System.getProperty("user.dir")+"\\resources\\"+filename;
		try {
			System.out.println(Files.readAllBytes(Paths.get(filePath)));
			return new String(Files.readAllBytes(Paths.get(filePath)));
			
			
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

}
