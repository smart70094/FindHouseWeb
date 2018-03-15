package com.pyhon.SpiderModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.strategy.FindHouseStrategy;
import com.strategy._591Strategy;

public class Main {
	//only test use in this class
	public static void main(String[] args) throws Exception {
		
		FindHouseStrategy strategy=new _591Strategy();
		FindHouseTemplate spider=new _591HouseTemplateImpl();
		ArrayList<Map<String,String>> data;
		data=strategy.exec(spider);
		
		
		
	}
}
