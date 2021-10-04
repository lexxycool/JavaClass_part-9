package com.techelevator;

public class MovieRental {

    private String title;
    private String format;
    private boolean isPremiumMovie;
    double rentalPrice;

    public MovieRental(String title, String format, boolean isPremiumMovie) {

        System.out.println("creating a rental....");
        this.title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
//        this.rentalPrice = rentalPrice;

        if (format.equals("VHS")) {
            this.rentalPrice = 0.99;
        } else if (format.equals("DVD")) {
            this.rentalPrice = 1.99;
        } else if (format.equals("Blu-Ray")) {
            this.rentalPrice = 2.99;
        }

        if (isPremiumMovie) {
            this.rentalPrice = this.rentalPrice + 1.0;
        }

        System.out.println("Finished setting up the object.");
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

    public double getRentalPrice() {
        return rentalPrice;
    }
}
