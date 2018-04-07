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
    private final String strip="172.25.32.244";
    private final int port=8000;
    private OutputStream out;
    private InputStream in;
    private BufferedReader read;
    //private Socket server;
    private InputStream input;
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

    public MessageBox Send(){
        MessageBox messageBox=null;
        return messageBox;
    }


    public MessageBox Send(JSONObject jsonObject){
        MessageBox messageBox=null;
        try {
            out=super.getOutputStream();
            out.write(jsonObject.toString().getBytes());
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        return messageBox;
    }

    /**
     * 通过TreeMap构建JSONObject然后发送到服务器
     * @param tree
     * @return
     */
    public MessageBox Send(TreeMap<String,String> tree){
        MessageBox messageBox=null;
        JSONObject send=new JSONObject();
        Iterator<Map.Entry<String,String>> iterator=tree.entrySet().iterator();
        Map.Entry<String,String> entry;
        while(iterator.hasNext()){
            entry=iterator.next();
            try{
                send.put(entry.getKey(),entry.getValue());
            }catch(JSONException e){
                e.printStackTrace();
            }
        }

        try{
            byte[] bytes=send.toString().getBytes();
            out=super.getOutputStream();
            out.write(bytes);

        }catch(IOException e){
            e.printStackTrace();
        }
        return messageBox;
    }
}
