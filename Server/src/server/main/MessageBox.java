package server.main;
/**
 * This is used to transitional information,
 * For example, If the login succeeds, it will return MessageBox.SI_SUCCESS
 * If it will expends, PLEASE in accordance with format like "{origin}_{infor}" 
 * such as "SI_SUCCESS" means "signin_success"(Please use capital letters.)
 * 
 * @author wangj
 *
 */
public enum MessageBox {
	/* -*- SignIn -*- */
	SI_SUCCESS("SignIn Success"),
	SI_FAIL("SignIn Fail"),
	SI_MISS("Sign Miss"),
	SI_NOTFIND("SignIn NotFind"),
	SI_PASSWDER("SignIn PasswdErr"),
	SI_ANOTHERPLACE("SignIn AnotherPlace"),
	/* -*- SignUp -* -*/
	SU_SUCCESS("SignUp Succcess"),
	SU_FAIL("SignUp Fail"),
	SU_NOTMATCH("SignUp NotMatch"),
	/* -*- System Error -*- */
	SYS_NETERR("System NetErr"),
	SYS_MAINTAIN("System Maintain");
	
	MessageBox(String message){
		
	}
}