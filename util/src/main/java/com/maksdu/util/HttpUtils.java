package com.maksdu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	private static String ID_URL;
	
	static {
		Properties prop = new Properties();
		//System.out.println(HttpUtils.class.getClassLoader().getResource("url.properties").getPath());
		try {
			prop.load(new FileInputStream(new File(HttpUtils.class.getClassLoader().getResource("url.properties").getPath())));
			init(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public static void init(Properties prop) {
		String conf = prop.getProperty("url.idUrl");
		if(conf!=null) {
			ID_URL = conf;
		} else {
			ID_URL = "http://localhost:9999/testuid";
		}
	}
	
	public static String API(String requestUri, Map<String, Object> params) {

		String content = "";
		//请求结果  
		CloseableHttpResponse response = null;  
		//实例化httpclient  
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(requestUri.toString()); 
		//执行get请求
		try {
			response = httpclient.execute(httpget);
			if(response.getStatusLine().getStatusCode()==200) {
				content = EntityUtils.toString(response.getEntity(),"utf-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	
	public static String getUidAPI() {
		return API(ID_URL, null);
	}
	
}
