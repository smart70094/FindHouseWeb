package com.strategy;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import com.pyhon.SpiderModel.FindHouseTemplate;

public interface FindHouseStrategy {
	public abstract ArrayList<Map<String,String>> exec(FindHouseTemplate spider);
}
