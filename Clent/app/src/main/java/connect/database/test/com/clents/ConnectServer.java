package connect.database.test.com.clents;

import org.json.JSONObject;

import java.io.IOException;
import java.net.Socket;

/**
 * Connect to server
 * Created by wangj on 4/2/2018.
 */

public final class ConnectServer {
    private final String strip="192.168.163.132";
    private final int port=8000;
    private Socket server;

    /**
     *
     * @return Server Socket
     */
    public Socket getSocket(){
        return server;
    }

    public void CloseSocket(){
        try {
            this.server.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public ConnectServer(){
        try{
            server=new Socket(strip,port);
            server.setSoTimeout(5000);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public MessageBox Send(){
        MessageBox messageBox=null;

        return messageBox;
    }

    public MessageBox Send(JSONObject jsonObject){
        MessageBox messageBox=null;

        return messageBox;
    }
}
