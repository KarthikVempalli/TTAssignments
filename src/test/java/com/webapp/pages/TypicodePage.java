package com.webapp.pages;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.webapp.commonDef.CommonDef;

import automation.core.utils.data.ProjectConfig;

public class TypicodePage {

	// User will hit jsonplaceholder typicode URI and use Post method. Data will be provided using Map Object
	public static boolean createUserId_PostMethod(LinkedHashMap<String, String> data) {
		boolean post = false;
		try {
			Map <String,Object> map = new HashMap<String,Object>();
			map.put("UserId", data.get("UserId"));
			map.put("id", data.get("id"));
			map.put("title", data.get("title"));
			map.put("body", data.get("body"));
			JSONObject jo = new JSONObject(map);
			int Response= given().body(jo.toJSONString()).when().post(ProjectConfig.getPropertyValue("Jsonplaceholder_URI")).then().statusCode(201).and()
					.extract().statusCode();
			System.out.println("Body : "+jo.toJSONString());
			System.out.println("Response :"+Response);
			CommonDef.logs("Response :"+Response);
			post = true;
		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
		}
		return post;
	}
}
