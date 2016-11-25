package com.nantian.impl;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import android.os.Handler;
import android.os.Looper;

public class SocketCenter {
	private static SocketCenter instance ;
	private WebSocketServerImpl wsserver = null;
	private final ExecutorService executorService = Executors.newSingleThreadExecutor();
	
	private SocketCenter(){
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				initWebSocket();
			}
		});
	
	}
	
	public static SocketCenter getInstance(){
		if (instance == null){
			instance = new SocketCenter();
		}
		return instance;
	}
	
	private void initWebSocket(){
		wsserver = new WebSocketServerImpl("localhost", 1337);
		wsserver.addOrigins("file://");
		wsserver.addProtocol("my-protocol-v1");
		wsserver.addProtocol("my-protocol-v2");
		wsserver.run();
		
		
		
	}
}
