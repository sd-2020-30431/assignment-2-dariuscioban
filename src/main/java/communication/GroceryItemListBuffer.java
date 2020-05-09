package communication;

import java.util.ArrayList;

import model.GroceryItem;

public class GroceryItemListBuffer {
	
	public ArrayList<GroceryItemBuffer> itemList;
	
	public GroceryItemListBuffer() {
		//empty no-arg constructor for kryonet
	}
	
	public GroceryItemListBuffer(ArrayList<GroceryItem> itemList) {
		this.itemList = new ArrayList<GroceryItemBuffer>();
		for(GroceryItem i : itemList) {
			GroceryItemBuffer g = new GroceryItemBuffer(i.getItemId(), i.getName(), i.getCalories(), i.getQuantity(),
					i.getPurchaseDate().toLocalDate(), i.getExpirationDate().toLocalDate(), i.getConsumptionDate().toLocalDate());
			this.itemList.add(g);
		}
	}
	
	public ArrayList<GroceryItemBuffer> getItemList() {
		return itemList;
	}
}
