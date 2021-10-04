package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

//1
public class MovieRental {
	
	//2
	private String title;
	private String format;
	private boolean isPremiumMovie;
	private BigDecimal rentalPrice;
	


	//3
	public MovieRental(String title, String format, boolean isPremiumMovie) {
		this.title = title;
		this.format = format;
		this.isPremiumMovie = isPremiumMovie;
		this.rentalPrice = this.calculateRentalPrice();
	}


	private BigDecimal calculateRentalPrice() {
		
		BigDecimal price = BigDecimal.ZERO;
		
		if (format.equals("VHS")) {
			price = price.add(new BigDecimal(0.99));
		} else if (format.equals("DVD")) {
			price = price.add(new BigDecimal(1.99));
		} else if (format.equals("Blu-ray")) {
			price = price.add(new BigDecimal(2.99));
		}
		
		if (this.isPremiumMovie) {
			price = price.add(new BigDecimal(1.00));
		}
		
		return price;		
	}
	
	// 5
	public BigDecimal determineLateFee(int daysLate) {
		
		BigDecimal lateFee = BigDecimal.ZERO;
		
		if (daysLate >=3) {
			lateFee = new BigDecimal(19.99);
		} else if (daysLate ==2) {
			lateFee = new BigDecimal(3.99);
		} else if (daysLate ==1) {
			lateFee = new BigDecimal(1.99);
		} 
		
		return lateFee.setScale(2, RoundingMode.HALF_UP);
	}
	
	//6
	@Override
	public String toString() {
		return "MOVIE -" + "{" + this.title 
				+ "} - {" 
				+ this.format 
				+ "} - {$" 
				+ this.rentalPrice.setScale(2, RoundingMode.HALF_UP)
				+ "}"; 
	}
	
	public String getTitle() {
		return title;
	}

	public String getFormat() {
		return format;
	}

	public boolean isPremiumMovie() {
		return isPremiumMovie;
	}
	
	public BigDecimal getRentalPrice() {
		return this.rentalPrice.setScale(2, RoundingMode.HALF_UP);
	}

}
