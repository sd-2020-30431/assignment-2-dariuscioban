package communication;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;

public class ClassRegister {
	
	public static void registerClasses(Server server) {
		Kryo kryo = server.getKryo();
		kryo.register(UserResponse.class);
		kryo.register(UserRequest.class);
		kryo.register(GroceryItemResponse.class);
		kryo.register(GroceryItemListResponse.class);
		kryo.register(GroceryItemConsumeRequest.class);
		kryo.register(GroceryItemAddRequest.class);
		
	}
	
	public static void registerClasses(Client client) {
		Kryo kryo = client.getKryo();
		kryo.register(UserResponse.class);
		kryo.register(UserRequest.class);
		kryo.register(GroceryItemResponse.class);
		kryo.register(GroceryItemListResponse.class);
		kryo.register(GroceryItemConsumeRequest.class);
		kryo.register(GroceryItemAddRequest.class);
		
	}
}
