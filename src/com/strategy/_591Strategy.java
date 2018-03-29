package com.strategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.pyhon.SpiderModel.FindHouseTemplate;

public class _591Strategy implements FindHouseStrategy {

	public ArrayList<Map<String, String>> exec(FindHouseTemplate spider) {
		
		try {
			String result;
			
			//result = readInfo();
			
			spider.exec();
			
			result=spider.getResult();
			
			
			ArrayList<Map<String,String>> list=new ArrayList<Map<String,String>>();
			
			JSONArray jsonArray = new JSONArray(result);
			
			for(int i=0;i<jsonArray.length();i++) {
				
				JSONObject obj=jsonArray.getJSONObject(i);
				
				Map<String,String> map=new HashMap<String,String>();
				
				map.put("house_id",String.valueOf(obj.getInt("id")));
				map.put("picture_address",obj.getString("filename"));
				map.put("name",obj.getString("address_img_title"));
				map.put("address",
						obj.getString("region_name")+//縣市
						obj.getString("sectionname")+//區
						obj.getString("street_name")+//街
						obj.getString("addr_number_name"));
				map.put("type", obj.getString("kind_name"));
				map.put("floor_info", obj.getString("floorInfo"));
				map.put("price", obj.getString("price"));
				map.put("area", String.valueOf(obj.get("area")));
				map.put("house_holder", obj.getString("linkman"));
				map.put("living", obj.getString("living"));
				map.put("device", obj.getString("condition"));
				map.put("browsenum", String.valueOf(obj.get("browsenum_all")));
				
				list.add(map);
				
				return list;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}

		
		return null;
	}
	
	
	//測試使用_讀檔
	String readInfo() {
		// spider.exec();
		// String result=spider.getResult();

		// test data
		try {
			FileReader f = new FileReader("C://Users//hp//eclipse-workspace//FindHouseWeb//record.txt");
			
			BufferedReader br = new BufferedReader(f);

			String result = "";
			String str=null;
			
			while ((str = br.readLine()) != null) {
			    result+=str;
			}

			f.close();
		
			return result;
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return null;
		
		
	}

}
