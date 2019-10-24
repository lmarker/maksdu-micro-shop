package com.maksdu.good.tool;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class APIHttpUtil {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
	
}
