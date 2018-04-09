package connect.database.test.com.clents;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Connect to server
 * Created by wangj on 4/2/2018.
 */

public final class ConnectServer extends Socket{
    private final String strip="127.0.0.1";
    private final int port=8000;
    private OutputStream out;
    private InputStream in;
    private BufferedReader read;
    //private Socket server;
    /**
     *
     * @return Server Socket
     */

    public void CloseSocket(){
        try {
            super.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public ConnectServer(){
        try{
            super.connect(new InetSocketAddress(strip,port));

            super.setSoTimeout(5000);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 发送消息方法
     * @param data : Expected Send Message
     * @return
     * @throws JSONException
     * @throws IOException
     */
    public MessageBox Send(JSONObject data) throws JSONException,IOException{
        MessageBox message=null;
        byte[] buffer=new byte[1024];
        out=super.getOutputStream();
        out.write(data.toString().getBytes());
        out.close();
        in=super.getInputStream();
        in.read(buffer);
        message=MessageBox.valueOf(buffer.toString());
        return message;
    }
}
