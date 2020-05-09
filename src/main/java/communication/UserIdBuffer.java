package communication;

public class UserIdBuffer {
	
	public int id;
	
	public UserIdBuffer() {
		//empty no-arg constructor for kryonet
	}
	
	public UserIdBuffer(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
