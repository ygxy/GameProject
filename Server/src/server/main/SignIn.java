package server.main;

import net.sf.json.JSONObject;
/**
 * this class is used to deal with signIn
 * this class need Connect DataBase and SELECT From db
 *  
 * @author wangj
 *
 */
public class SignIn {
	private JSONObject jsonObject=null;
	private String recv=null;
	
	public SignIn(String recv) {
		this.recv=recv;
	}
	
	public MessageBox getMessage() {
		
		return MessageBox.SI_SUCCESS;
	}
	
}
