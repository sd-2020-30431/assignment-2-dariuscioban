package server;

import java.io.IOException;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import communication.ClassRegister;
import communication.GroceryItemAddBuffer;
import communication.GroceryItemIdBuffer;
import communication.GroceryItemListBuffer;
import communication.UserGoalBuffer;
import communication.UserIdBuffer;
import communication.UserLoginBuffer;

public class ServerConnection {
	
	private Server server;
	
	public ServerConnection() {
		server = new Server();
		ClassRegister.registerClasses(server);
		server.start();
		try {
			server.bind(54555, 54777);
			addListeners();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Connection unsuccessful.");
		}
	}
	
	private void addListeners() {
		server.addListener(new Listener() {
		       public void received (Connection connection, Object object) {
		          if (object instanceof UserLoginBuffer) {
		        	  UserLoginBuffer request = (UserLoginBuffer)object;
		        	  System.out.println("UserLoginBuffer received.");
		        	  
		        	  UserIdBuffer response = ServerRequests.instance.processUserRequest(request);
		        	  connection.sendTCP(response);
		          }
		          
		          if (object instanceof UserIdBuffer) {
		        	  UserIdBuffer request = (UserIdBuffer)object;
		        	  System.out.println("UserIdBuffer received.");
		        	  
		        	  ServerRequests.instance.processAutomaticDeletetionRequest(request);
		        	  GroceryItemListBuffer response = ServerRequests.instance.processItemListRequest(request);
		        	  connection.sendTCP(response);
		          }
		          
		          if(object instanceof UserGoalBuffer) {
		        	  UserGoalBuffer request = (UserGoalBuffer)object;
		        	  System.out.println("UserGoalBuffer received.");
		        	  
		        	  ServerRequests.instance.processUpdateGoalRequest(request);
		        	  //no response
		          }
		          
		          if(object instanceof GroceryItemIdBuffer) {
		        	  GroceryItemIdBuffer request = (GroceryItemIdBuffer)object;
		        	  System.out.println("GroceryItemIdBuffer received.");
		        	  
		        	  //only one will happen based on the flag
		        	  ServerRequests.instance.processItemDeletionRequest(request);
		        	  ServerRequests.instance.processConsumeItemRequest(request);
		        	  //no response
		          }
		          
		          if(object instanceof GroceryItemAddBuffer) {
		        	  GroceryItemAddBuffer request = (GroceryItemAddBuffer)object;
		        	  System.out.println("GroceryIteAddBuffer received.");
		        	  
		        	  ServerRequests.instance.processAddItemRequest(request);
		        	  //no response
		          }
		       }
		    });
	}
}
