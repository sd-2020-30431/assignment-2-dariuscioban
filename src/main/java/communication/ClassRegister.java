package communication;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;

public class ClassRegister {
	
	public static void registerClasses(Server server) {
		Kryo kryo = server.getKryo();
		kryo.register(UserIdBuffer.class);
		kryo.register(UserLoginBuffer.class);
		kryo.register(GroceryItemBuffer.class);
		kryo.register(GroceryItemListBuffer.class);
		kryo.register(GroceryItemIdBuffer.class);
		kryo.register(GroceryItemAddBuffer.class);
		
	}
	
	public static void registerClasses(Client client) {
		Kryo kryo = client.getKryo();
		kryo.register(UserIdBuffer.class);
		kryo.register(UserLoginBuffer.class);
		kryo.register(GroceryItemBuffer.class);
		kryo.register(GroceryItemListBuffer.class);
		kryo.register(GroceryItemIdBuffer.class);
		kryo.register(GroceryItemAddBuffer.class);
		
	}
}
