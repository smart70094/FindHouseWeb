package com.pyhon.SpiderModel;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.json.JSONObject;
import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public abstract class FindHouseTemplate {
	PythonInterpreter interpreter = new PythonInterpreter();
	String filePath="";
	String result="";
	HashMap<String,String> paramsMap=new HashMap<String,String>(); 
	String method="";
	public final void exec() {
		try {
			setFilePath();
			setMethod();
			setParams();
			//writeParams();
			connectSiderWithPython();
			run();
		} catch (IOException e) {
			System.out.println("Python Problem:"+e.toString());
		}
		
	}
	protected abstract void setFilePath();
	
	//設定Python裡面執行的方法
	private void setMethod() {
		method="findHouse";
	}
	
	//設定參數給Python
	private void setParams() {
		String city="花蓮縣";
		String district="花蓮市";
		String price_floor="3000";
		String price_ceil="1000000";
		String type="套房";
		
		paramsMap.put("city",city);
		paramsMap.put("district",district);
		paramsMap.put("price_floor",price_floor);
		paramsMap.put("price_ceil",price_ceil);
		paramsMap.put("type",type);
	}
	
	//測試用_將條件寫到txt
	private void writeParams() throws IOException {
		//convert map to json
		JSONObject jsonObj = new JSONObject(paramsMap);
		String jsonResult=jsonObj.toString();
		
		//Condition write to txt
		FileWriter fw=new FileWriter("params.txt");
		fw.write(jsonResult);
		fw.close();
	}
	
	//連接python
	private void connectSiderWithPython() throws IOException {
        InputStream is = new FileInputStream(filePath); 
        //載入python第三方資源
        interpreter.exec("import sys");
        interpreter.exec("sys.path.append('C://Python27//Lib')");
        interpreter.exec("sys.path.append('C://Python27//Lib//site-packages')");
        //執行
        interpreter.execfile(is);
        is.close();   
	}
	//執行python method
	private void run() {
		PyFunction func = (PyFunction) interpreter.get(method,PyFunction.class);
        PyObject pyobj = func.__call__();
        result=pyobj.toString();
        System.out.println(result);
	}
	public String getResult() {
		return result;
	}
}
