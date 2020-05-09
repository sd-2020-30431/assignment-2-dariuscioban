package communication;

public class UserGoalBuffer {
	
	private int id;
	private int goal;
	
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
