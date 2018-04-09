package server.main;

import net.sf.json.JSONObject;

public class SignUp {
	private JSONObject jsonObject=null;
	private String recv=null;
	
	public SignUp(String recv) {
		this.recv=recv;
	}
	
	public MessageBox getMessage() {
		
		return MessageBox.SU_SUCCESS;
	}
}
