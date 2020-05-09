package client;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import communication.ClassRegister;
import communication.GroceryItemAddBuffer;
import communication.GroceryItemIdBuffer;
import communication.GroceryItemListBuffer;
import communication.UserGoalBuffer;
import communication.UserIdBuffer;
import communication.UserLoginBuffer;

public class ClientConnection {
	
	private Client client;
	
	private LoginWindow loginWindow;
	private MainWindow mainWindow;
	
	public ClientConnection() {
		client = new Client();
		ClassRegister.registerClasses(client);
		client.start();
		try {
			client.connect(5000, "192.168.100.8", 54555, 54777);
			addListeners();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Connection unsuccessful.");
		}
	}
	
	private void addListeners() {
		client.addListener(new Listener() {
		       public void received (Connection connection, Object object) {
		          if (object instanceof UserIdBuffer) {
		             UserIdBuffer response = (UserIdBuffer)object;
		             System.out.println("UserIdBuffer received.");
		             
		             loginWindow.loginSuccess(response.getId());
		          }
		          if (object instanceof GroceryItemListBuffer) {
		        	  GroceryItemListBuffer response = (GroceryItemListBuffer)object;
		        	  System.out.println("GroceryItemListBuffer received.");
		        	  
		        	  mainWindow.updateItemList(response.getItemList());
		          }
		       }
		    });
	}
	
	public void sendLoginRequest(String username, String password) {
		UserLoginBuffer request = new UserLoginBuffer(username, password, false);
		client.sendTCP(request);
	}
	
	public void sendRegisterRequest(String username, String password) {
		UserLoginBuffer request = new UserLoginBuffer(username, password, true);
		client.sendTCP(request);
	}
	
	public void sendRetrieveItemList(int userId) {
		UserIdBuffer request = new UserIdBuffer(userId);
		client.sendTCP(request);
	}
	
	public void sendGoalRequest(int goal, int userId) {
		UserGoalBuffer request = new UserGoalBuffer(userId, goal);
		client.sendTCP(request);
	}
	
	public void sendConsumeRequest(int itemid) {
		GroceryItemIdBuffer request = new GroceryItemIdBuffer(itemid, false);
		client.sendTCP(request);
	}
	
	public void sendDeleteRequest(int itemid) {
		GroceryItemIdBuffer request = new GroceryItemIdBuffer(itemid, true);
		client.sendTCP(request);
	}
	
	public void sendAddRequest(int userId, String name, int calories, int quantity, String purchaseDate, String expirationDate) {
		GroceryItemAddBuffer request = new GroceryItemAddBuffer(userId, name, calories, quantity, purchaseDate, expirationDate);
		client.sendTCP(request);
	}
	
	public void addLoginWindow(LoginWindow lw) {
		loginWindow = lw;
	}
	
	public void addMainWindow(MainWindow mw) {
		mainWindow = mw;
	}
}