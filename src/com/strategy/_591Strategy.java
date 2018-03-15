package com.strategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONObject;

import com.pyhon.SpiderModel.FindHouseTemplate;

public class _591Strategy implements FindHouseStrategy {

	public ArrayList<Map<String, String>> exec(FindHouseTemplate spider) throws Exception {
		String result=readInfo();
		JSONObject jsonObj = new JSONObject(result);
		
		System.out.println(jsonObj.get("address_img_title"));
		
		

		return null;
	}

	String readInfo() throws Exception {
		// spider.exec();
		// String result=spider.getResult();

		// test data
		FileReader f = new FileReader("record.txt");
		BufferedReader br = new BufferedReader(f);

		String result = "";
		while (br.ready()) {
			result += br.readLine();
		}

		f.close();
		return result;
	}

}
