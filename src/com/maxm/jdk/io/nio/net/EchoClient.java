package com.maxm.jdk.io.nio.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.maxm.jdk.util.PrintUtil;

// Blocking client
public class EchoClient {
	int port;

	public EchoClient(int port) {
		super();
		this.port = port;
	}

	private void sendQ(String msg) {
		BufferedWriter bw = null;
		BufferedReader br = null;
		Socket s = new Socket();

		try {
			s.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
			// req
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),
					EchoProtocal.UTF8));
			bw.write(msg);
			bw.flush();
			// resp
			PrintUtil.print("server resp:");
			while (true) {
				br = new BufferedReader(new InputStreamReader(
						s.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					PrintUtil.println(line);
				}
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
				s.close();
			} catch (IOException e) {
				br = null;
				bw = null;
				s = null;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) {
			new EchoClient(12345).sendQ("hi server");
		}
	}
}
