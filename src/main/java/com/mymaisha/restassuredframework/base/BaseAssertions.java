package com.mymaisha.restassuredframework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.mymaisha.restassuredframework.utils.TestUtils;

import io.restassured.response.Response;

public class BaseAssertions {
private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
	public static void verifyTrue(boolean flag){
		Assert.assertTrue(flag);
	}
	
	public static void verifyFalse(boolean flag){
		Assert.assertFalse(flag);
	}

	public static void verifyStatusCode(Response response, int status){
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}
	
	public static void verifyStatusMessage(Response response, String status){
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}
}
