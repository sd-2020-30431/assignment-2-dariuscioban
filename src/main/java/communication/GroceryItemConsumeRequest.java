package communication;

public class GroceryItemConsumeRequest {
	
	int itemid;
	
	public GroceryItemConsumeRequest(int itemid) {
		this.itemid = itemid;
	}
	
	public int getItemId() {
		return itemid;
	}
}
