package communication;

public class GroceryItemIdBuffer {
	
	private int itemid;
	private Boolean deleteFlag;
	
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
