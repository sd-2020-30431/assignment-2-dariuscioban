package communication;

import java.time.LocalDate;

public class GroceryItemAddRequest {
	
	private int userid;
	private String name;
	private int calories;
	private int quantity;
	private LocalDate purchaseDate;
	private LocalDate expirationDate;
	
	public GroceryItemAddRequest(int userid, String name, int calories, int quantity, LocalDate purchaseDate, LocalDate expirationDate) {
		this.userid = userid;
		this.name = name;
		this.calories = calories;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.expirationDate = expirationDate;
	}

	public int getUserid() {
		return userid;
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
	
	
}
