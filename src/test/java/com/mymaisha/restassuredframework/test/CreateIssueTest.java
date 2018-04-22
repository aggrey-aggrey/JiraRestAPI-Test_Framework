package com.mymaisha.restassuredframework.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mymaisha.restassuredframework.base.RestCalls;
import com.mymaisha.restassuredframework.utils.ApplicationURL;
import com.mymaisha.restassuredframework.utils.PayLoadGenerator;
import com.mymaisha.restassuredframework.utils.TestUtils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIssueTest {
	private static Logger log = LogManager.getLogger(CreateIssueTest.class.getName());
	
	public static String createJiraIssue () {
		Response response;
		String sessionID =LoginTest.doLogin();
		log.info("Starting Test Case : Create Issue ");
		String createIssuePayload = PayLoadGenerator.generatePayLoadString("CreateIssue.Json");
		
		String endPointURI = ApplicationURL.getEndPoint("/rest/api/3/issue");
		response = RestCalls.POSTRequest(endPointURI, createIssuePayload, sessionID);
		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);
		String issueID = jsonRes.getString("");
		log.info("Jira Issue ID : " + issueID );
		return issueID;
	}

}
