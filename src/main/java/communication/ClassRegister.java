package communication;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class ClassRegister {
	
	public static void registerClasses(EndPoint ep) {
		Kryo kryo = ep.getKryo();
		kryo.register(String.class);
		kryo.register(UserIdBuffer.class);
		kryo.register(UserLoginBuffer.class);
		kryo.register(GroceryItemBuffer.class);
		kryo.register(GroceryItemListBuffer.class);
		kryo.register(GroceryItemIdBuffer.class);
		kryo.register(GroceryItemAddBuffer.class);
		
	}
}
