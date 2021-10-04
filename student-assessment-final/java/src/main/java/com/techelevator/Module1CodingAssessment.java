package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {

		// 4
		System.out.println("Part 4");
		MovieRental goodReboot = new MovieRental("Star Trek", "VHS", false);
		System.out.println(goodReboot);

		MovieRental vampirez = new MovieRental("What We Do In the Shadows", "DVD", true);
		System.out.println(vampirez);
		System.out.println("***********************");

		// 8
		System.out.println("Part 8");
		List<MovieRental> rentalsList = new ArrayList<MovieRental>();

		File data = new File("MovieInput.csv");
		try (Scanner scanner = new Scanner(data)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] lineArr = line.split("\\,");

				String title = lineArr[0];
				String format = lineArr[1];
				boolean isPremium = Boolean.parseBoolean(lineArr[2]);

				MovieRental rental = new MovieRental(title, format, isPremium);

				rentalsList.add(rental);

			}
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening file.");
		}

		// 9
		BigDecimal total = BigDecimal.ZERO;
		for (MovieRental rental : rentalsList) {

			total = total.add(rental.getRentalPrice());
		}
		System.out.println("Total: $" + total);

	}

}
