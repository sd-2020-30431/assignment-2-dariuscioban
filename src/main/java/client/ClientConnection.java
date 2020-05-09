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
		             System.out.println("UserIdBufferReceived.");
		             
		             loginWindow.loginSuccess(response.getId());
		             System.out.println(response.getId());
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
	
	public void addLoginWindow(LoginWindow lw) {
		loginWindow = lw;
	}
	
	public void addMainWindow(MainWindow mw) {
		mainWindow = mw;
	}
}