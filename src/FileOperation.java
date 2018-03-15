import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileOperation {
	ArrayList<Map<String,String>> list=new ArrayList<Map<String,String>>();
	ArrayList<Map<String,String>> read(){
		try{
			String path="C://Users//davis//Desktop";
			File file=new File(path,"houseRecord.txt");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);;
			
			
			String str="";
			String s=br.readLine();
			while(s!=null){
				str+=s+"\n";
				s=br.readLine();
			}
			//out.println(str);
			
			String dataArr[]=str.split("\n");
			for(String data:dataArr){
				Map<String,String> map=new HashMap<String,String>();
				String arr[]=data.split(",");
				map.put("imgLink",arr[0]);
				map.put("title",arr[1]);
				map.put("type",arr[2]);
				map.put("price",arr[3]);
				map.put("fullfloor",arr[4]);
				list.add(map);
			}
			return list;
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}	
	}
	
	String test() {
		String result="";
		for(Map<String, String> map:list) {
			result+=map.get("imgLink")+"<br>";
			result+=map.get("title")+"<br>";
		}
		return result;
	}
}
