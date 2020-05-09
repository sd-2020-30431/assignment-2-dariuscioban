package communication;

import java.time.LocalDate;

public class GroceryItemBuffer {
	
	private int itemid;
	private String name;
	private int calories;
	private int quantity;
	private LocalDate purchaseDate;
	private LocalDate expirationDate;
	private LocalDate consumptionDate;
	
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
