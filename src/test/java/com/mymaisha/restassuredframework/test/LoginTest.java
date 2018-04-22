package com.mymaisha.restassuredframework.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mymaisha.restassuredframework.base.RestCalls;
import com.mymaisha.restassuredframework.utils.ApplicationURL;
import com.mymaisha.restassuredframework.utils.PayLoadGenerator;
import com.mymaisha.restassuredframework.utils.TestUtils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginTest {

	private static Logger log = LogManager.getLogger(LoginTest.class.getName());
		
		public static String doLogin(){
			Response response;
			log.info("Starting Test Case : doLogin");
			String loginPayload = PayLoadGenerator.generatePayLoadString("JiraLogin.json");
			
			String endPointURI = ApplicationURL.getEndPoint("/rest/auth/1/session");
			response = RestCalls.POSTRequest(endPointURI, loginPayload);
			log.info(response.getBody().asString());
			String strResponse = TestUtils.getResposeString(response);
			JsonPath jsonRes = TestUtils.jsonParser(strResponse);
			String sessionID = jsonRes.getString("session.value");
			log.info("JIRA JSession ID : " + sessionID);
			return sessionID;
		}

	}


