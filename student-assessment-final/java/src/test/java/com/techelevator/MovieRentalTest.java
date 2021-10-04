package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class MovieRentalTest {

	@Test
	public void rentals_instantiate_correctly() {
		MovieRental rental = new MovieRental("Deep Blue Sea", "VHS", false);
		
		assertEquals("Deep Blue Sea", rental.getTitle());
		assertEquals("VHS", rental.getFormat());
		assertEquals(false, rental.isPremiumMovie());
		
	}
	
	@Test 
	public void vhs_prices_are_correct() {
		MovieRental rentalNotPremium = new MovieRental("Deep Blue Sea", "VHS", false);
		BigDecimal expectedPriceNotPremium = new BigDecimal(0.99).setScale(2, RoundingMode.HALF_UP);
		assertEquals(expectedPriceNotPremium, rentalNotPremium.getRentalPrice());
		
		MovieRental premium = new MovieRental("Deep Blue Sea", "VHS", true);
		BigDecimal expectedPricePremium = new BigDecimal(1.99).setScale(2, RoundingMode.HALF_UP);
		assertEquals(expectedPricePremium, premium.getRentalPrice());
	}
	
	@Test 
	public void dvd_prices_are_correct() {
		MovieRental rentalNotPremium = new MovieRental("Deep Blue Sea", "DVD", false);
		BigDecimal expectedPriceNotPremium = new BigDecimal(1.99).setScale(2, RoundingMode.HALF_UP);
		assertEquals(expectedPriceNotPremium, rentalNotPremium.getRentalPrice());
		
		MovieRental premium = new MovieRental("Deep Blue Sea", "DVD", true);
		BigDecimal expectedPricePremium = new BigDecimal(2.99).setScale(2, RoundingMode.HALF_UP);
		assertEquals(expectedPricePremium, premium.getRentalPrice());
	}
	
	@Test 
	public void blueray_prices_are_correct() {
		MovieRental rentalNotPremium = new MovieRental("Deep Blue Sea", "Blu-ray", false);
		BigDecimal expectedPriceNotPremium = new BigDecimal(2.99).setScale(2, RoundingMode.HALF_UP);
		assertEquals(expectedPriceNotPremium, rentalNotPremium.getRentalPrice());
		
		MovieRental premium = new MovieRental("Deep Blue Sea", "Blu-ray", true);
		BigDecimal expectedPricePremium = new BigDecimal(3.99).setScale(2, RoundingMode.HALF_UP);
		assertEquals(expectedPricePremium, premium.getRentalPrice());
	}
	
	@Test
	public void latefees_calculated_correctly_not_late() {
		MovieRental rental = new MovieRental("Deep Blue Sea", "Blu-ray", false);
		BigDecimal expectedLateFee = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		BigDecimal actualLateFee = rental.determineLateFee(0);
		assertEquals(expectedLateFee, actualLateFee);
	}
	
	@Test
	public void latefees_calculated_correctly_oneday_late() {
		MovieRental rental = new MovieRental("Deep Blue Sea", "Blu-ray", false);
		BigDecimal expectedLateFee = new BigDecimal(1.99);
		BigDecimal actualLateFee = rental.determineLateFee(1);
		assertEquals(expectedLateFee.setScale(2, RoundingMode.HALF_UP), actualLateFee);
	}
	
	@Test
	public void latefees_calculated_correctly_twoday_late() {
		MovieRental rental = new MovieRental("Deep Blue Sea", "Blu-ray", false);
		BigDecimal expectedLateFee = new BigDecimal(3.99);
		BigDecimal actualLateFee = rental.determineLateFee(2);
		assertEquals(expectedLateFee.setScale(2, RoundingMode.HALF_UP), actualLateFee);
	}
	
	@Test
	public void latefees_calculated_correctly_very_late() {
		MovieRental rental = new MovieRental("Deep Blue Sea", "Blu-ray", false);
		BigDecimal expectedLateFee = new BigDecimal(19.99);
		BigDecimal actualLateFee = rental.determineLateFee(3);
		assertEquals(expectedLateFee.setScale(2, RoundingMode.HALF_UP), actualLateFee);
	}

	
}
