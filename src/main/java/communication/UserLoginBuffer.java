package communication;

public class UserLoginBuffer {
	
	public String username;
	public String password;
	//if true, register request
	//if false, login request
	public Boolean registerFlag;
	
	public UserLoginBuffer() {
		//empty no-arg constructor for kryonet
	}
	
	public UserLoginBuffer(String username, String password, Boolean registerFlag) {
		this.username = username;
		this.password = password;
		this.registerFlag = registerFlag;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Boolean getRegisterFlag() {
		return registerFlag;
	}
}
