package server.main;

import java.net.ServerSocket;
import java.net.Socket;
/**
 * encoding in utf-8
 * this maybe show messy code in Chinese Code
 * If USE simplified Chinese please change encodig to gb2312
 * @author wangj
 *
 */
public class Main {
	private static final int port=8000; 
	public static void main(String[] args) {
		try {
			/**
			 * It including getIP Bind IP and Port Listen Socket
			 */
			ServerSocket serverSocket=new ServerSocket(port);
			System.out.println("Created New ServerSocket Success");
			while(true) {
				System.out.println("Wait For Connect...");
				Socket clent=serverSocket.accept();
				System.out.println("Connect Success..");
				new Handler(clent);				
			}
		}catch (Exception e) {
			System.out.println("Server Start Error!");
			e.printStackTrace();
		}
	}
}
