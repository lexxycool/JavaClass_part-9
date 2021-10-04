public class Dog {
    private String breed;
    private String size;
    private String color;

    public Dog(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return this.breed + " - " + this.size;
    }

    //getters & setters
    public String getBreed() {
        return this.breed;
    }
    public void setBreed(String newBreed) {
        this.breed = newBreed;
    }
    public String getSize() {
        return this.size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

}
