package connect.database.test.com.clents;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * Created by wangj on 4/2/2018.
 */

public final class ConnectServer {
    private String strip="192.168.163.132";
    private int port=8000;
    private Socket clent;

    public Socket getSocket(){
        return clent;
    }

    public ConnectServer(){
        try{
            clent=new Socket(strip,port);
            clent.setSoTimeout(5000);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
