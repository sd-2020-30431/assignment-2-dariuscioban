package communication;

import java.util.ArrayList;

import model.GroceryItem;

public class GroceryItemListResponse {
	
	private ArrayList<GroceryItemResponse> itemList;
	
	public GroceryItemListResponse(ArrayList<GroceryItem> itemList) {
		this.itemList = new ArrayList<GroceryItemResponse>();
		for(GroceryItem i : itemList) {
			GroceryItemResponse g = new GroceryItemResponse(i.getItemId(), i.getName(), i.getCalories(), i.getQuantity(),
					i.getPurchaseDate().toLocalDate(), i.getExpirationDate().toLocalDate(), i.getConsumptionDate().toLocalDate());
			this.itemList.add(g);
		}
	}
	
	public ArrayList<GroceryItemResponse> getItemList() {
		return itemList;
	}
}
