package server;

import communication.GroceryItemAddBuffer;
import communication.GroceryItemIdBuffer;
import communication.GroceryItemListBuffer;
import communication.UserGoalBuffer;
import communication.UserIdBuffer;
import communication.UserLoginBuffer;
import data.DatabaseConnection;
import services.GroceryItemServices;
import services.UserServices;

public class ServerRequests {
	
	public static ServerRequests instance = new ServerRequests();
	
	private UserServices us;
	private GroceryItemServices gs;
	
	private ServerRequests() {
		us = new UserServices();
		gs = new GroceryItemServices();
	}
	
	public UserIdBuffer processUserRequest(UserLoginBuffer u) {
		int id;
		if(u.getRegisterFlag()) {
			//register user
			id = us.registerUser(u.getUsername(), u.getPassword());
		} else {
			//log user
			id = us.login(u.getUsername(), u.getPassword());
		}
		return new UserIdBuffer(id);
	}
	
	public void processUpdateGoalRequest(UserGoalBuffer u) {
		us.updateGoal(u.getGoal(), u.getId());
	}
	
	public void processAddItemRequest(GroceryItemAddBuffer g) {
		gs.addItem(g.getUserid(), g.getName(), g.getCalories(), g.getQuantity(), g.getPurchaseDate(), g.getExpirationDate());
	}
	
	public GroceryItemListBuffer processItemListRequest(UserIdBuffer u) {
		return new GroceryItemListBuffer(gs.getItemList(u.getId()));
	}
	
	public void processAutomaticDeletetionRequest(UserIdBuffer u) {
		gs.automaticDeletion(u.getId());
	}
	
	public void processItemDeletionRequest(GroceryItemIdBuffer g) {
		if(g.getDeleteFlag())
			gs.deleteItem(g.getItemId());
	}
	
	public void processConsumeItemRequest(GroceryItemIdBuffer g) {
		if(!g.getDeleteFlag())
			gs.markItemAsConsumed(g.getItemId());
	}
}
