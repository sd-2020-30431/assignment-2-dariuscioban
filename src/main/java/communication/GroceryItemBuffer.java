package communication;

import java.time.LocalDate;

public class GroceryItemBuffer {
	
	public int itemid;
	public String name;
	public int calories;
	public int quantity;
	public LocalDate purchaseDate;
	public LocalDate expirationDate;
	public LocalDate consumptionDate;
	
	public GroceryItemBuffer() {
		//empty no-arg constructor for kryonet
	}
	
	public GroceryItemBuffer(int itemid, String name, int calories, int quantity, LocalDate purchaseDate,
			LocalDate expirationDate, LocalDate consumptionDate) {
		this.itemid = itemid;
		this.name = name;
		this.calories = calories;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.expirationDate = expirationDate;
		this.consumptionDate = consumptionDate;
	}

	public int getItemid() {
		return itemid;
	}

	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}

	public int getQuantity() {
		return quantity;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public LocalDate getConsumptionDate() {
		return consumptionDate;
	}
}
