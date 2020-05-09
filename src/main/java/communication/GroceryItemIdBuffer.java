package communication;

public class GroceryItemIdBuffer {
	
	public int itemid;
	public Boolean deleteFlag;
	
	public GroceryItemIdBuffer() {
		//empty no-arg constructor for kryonet
	}
	
	public GroceryItemIdBuffer(int itemid, Boolean deleteFlag) {
		this.itemid = itemid;
		this.deleteFlag = deleteFlag;
	}
	
	public int getItemId() {
		return itemid;
	}
	
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
}
