package client;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import communication.ClassRegister;
import communication.UserIdBuffer;
import communication.UserLoginBuffer;

public class ClientConnection {
	
	private Client client;
	
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
		             System.out.println("UserIdBufferReceived.");
		          }
		       }
		    });
	}
	
	public void sendMsgTest() {
		UserLoginBuffer u = new UserLoginBuffer("test_with_server", "pass123", true);
		client.sendTCP(u);
	}
	
	public static void main( String[] args ) throws Exception
    {
    	ClientConnection cn = new ClientConnection();
    	cn.sendMsgTest();
    }
}
