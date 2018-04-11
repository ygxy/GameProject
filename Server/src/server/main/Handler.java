package server.main;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLNonTransientConnectionException;
/**
 * 接受信息 线程
 * @author wangj
 *
 */
public class Handler implements Runnable  {
	private static final String CHARCODE="utf-8";
	private Socket socket;
	private SignIn signIn;
	private DataInputStream in;
	private DataOutputStream out;
	public Handler(Socket socket) {
		System.out.println("This is in New Handler");
		this.socket=socket;
		this.run();
	}
	
	public void run() {
		MessageBox messageBox;
		//String data=null;
		byte[] buffer=new byte[4096];
		String data;
		int len=0;
		try {
			System.out.println("Wait For Recv Message!...");
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			/*												*/
			/* thare are some mistake in hare				*/
			/* Sometimes it can't receive Bytes from clent	*/
			/*												*/
			/*
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			
			System.out.println("Recv Success..");
			while((len=inputStream.read(buffer))!=-1) {
				os.write(buffer);
			}
			*/
			
			data=in.readUTF();
			signIn=new SignIn(data);
			messageBox=signIn.getMessage();
			out.writeUTF(messageBox.toString());
			//outputStream.write(messageBox.toString().getBytes());
			/* Test term, please delete after completion. */
			System.out.println();
			
			
		} catch (IOException e) {
			System.out.println("Get Message Failed");
			e.printStackTrace();
		}
	}

}
