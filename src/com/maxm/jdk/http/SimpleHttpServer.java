package com.maxm.jdk.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;


public class SimpleHttpServer {
	
	public static void main(String[] args) throws IOException {
		InetSocketAddress addr = new InetSocketAddress(8080);
		HttpServer httpServer = HttpServer.create(addr, 0);
		
		SimpleHttpHandler handler = new SimpleHttpHandler();
		httpServer.createContext("/", handler);
		Executor executor = Executors.newCachedThreadPool();
		httpServer.setExecutor(executor);
		
		httpServer.start();
		
		System.out.println("server start listening 8080 ");
	}
	
}
