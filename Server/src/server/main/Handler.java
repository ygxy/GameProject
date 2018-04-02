package server.main;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.SQLNonTransientConnectionException;
/**
 * 
 * @author wangj
 *
 */
public class Handler implements Runnable  {
	private static final String CHARCODE="utf-8";
	private Socket socket;
	private SignIn signIn;
	public Handler(Socket socket) {
		System.out.println("This is in New Handler");
		this.socket=socket;
		this.run();
	}
	
	public void run() {
		BufferedReader bufferedReader=null;
		InputStream inputStream=null;
		InputStreamReader inputStreamReader=null;
		
		//String data=null;
		byte[] buffer=new byte[4096];
		int len=0;
		try {
			System.out.println("Wait For Recv Message!...");
			inputStream=socket.getInputStream();
			
			/*												*/
			/* thare are some mistake in hare				*/
			/* Sometimes it can't receive Bytes from clent	*/
			/*												*/
			
			//inputStreamReader=new InputStreamReader(inputStream);
			//bufferedReader=new BufferedReader(inputStreamReader);
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			
			System.out.println("Recv Success..");
			while((len=inputStream.read(buffer))!=-1) {
				os.write(buffer);
			}
			
			signIn=new SignIn(buffer.toString());
			signIn.getMessage();
			
			/* Test term, please delete after completion. */
			System.out.println(os.toString());
			
			
		} catch (IOException e) {
			System.out.println("Get Message Failed");
			e.printStackTrace();
		}
	}

}
