package com.maxm.jdk.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class SimpleHttpHandler implements HttpHandler{

	@SuppressWarnings("static-access")
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String requestMethod = exchange.getRequestMethod();
		if(requestMethod.equalsIgnoreCase("GET")){
			Headers responseHeaders = exchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "text/plain");
			exchange.sendResponseHeaders(200, 0);
			
			URI requestURI = exchange.getRequestURI();
			String query = requestURI.getQuery();
			if(query.equalsIgnoreCase("null")){
				return;
			}
			
			System.out.println("query: "+query);
			String[] split = query.split("&");
			
			// ×ª·¢ÇëÇó
			String path = requestURI.getPath();
			String action = path.substring(path.lastIndexOf("/")+1);
			try {
				Class<?> servletClass = Class.forName(action);
				Hello hello = (Hello)servletClass.newInstance();
				hello.main(new String[]{});
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
			HashMap<String, String> hashMap = new HashMap<String, String>();
			for(String s:split){
				String[] pair = s.split("=");
				hashMap.put(pair[0], pair[1]);
			}
			
			String name = hashMap.get("name");
			String sex = hashMap.get("sex");
			System.out.println("name:" + name + ", sex:" + sex);
			
			
			OutputStream responseBody = exchange.getResponseBody();
			
			Headers requestHeaders = exchange.getRequestHeaders();
			Set<String> keySet = requestHeaders.keySet();
			Iterator<String> iterator = keySet.iterator();
			while(iterator.hasNext()){
				String param = iterator.next();
				List<String> list = requestHeaders.get(param);
				String str = param+"="+list.toString()+"\n";
				responseBody.write(str.getBytes("utf-8"));
			}
			responseBody.write("hello servlet".getBytes("utf-8"));
			responseBody.close();
		}
	}

}
