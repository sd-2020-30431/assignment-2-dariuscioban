package communication;

public class UserRequest {
	
	private String username;
	private String password;
	//if true, register request
	//if false, login request
	private Boolean registerFlag;
	
	public UserRequest(String username, String password, Boolean registerFlag) {
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
