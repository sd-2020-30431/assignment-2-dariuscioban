package communication;

public class UserGoalBuffer {
	
	public int id;
	public int goal;
	
	public UserGoalBuffer() {
		//empty no-arg consructor for kryonet
	}
	
	public UserGoalBuffer(int id, int goal) {
		this.id = id;
		this.goal = goal;
	}
	
	public int getId() {
		return id;
	}
	
	public int getGoal() {
		return goal;
	}
}
