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
		GroceryItemBuffer g;
		for(GroceryItem i : itemList) {
			if(i.getConsumptionDate() != null)
				g = new GroceryItemBuffer(i.getItemId(), i.getName(), i.getCalories(), i.getQuantity(),
						i.getPurchaseDate().toLocalDate().toString(), 
						i.getExpirationDate().toLocalDate().toString(), i.getConsumptionDate().toLocalDate().toString());
			else
				g = new GroceryItemBuffer(i.getItemId(), i.getName(), i.getCalories(), i.getQuantity(),
						i.getPurchaseDate().toLocalDate().toString(), i.getExpirationDate().toLocalDate().toString(), null);
			this.itemList.add(g);
		}
	}
	
	public ArrayList<GroceryItemBuffer> getItemList() {
		return itemList;
	}
}
