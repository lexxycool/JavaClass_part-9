public class Program {

    public static void main(String[] args) {
        System.out.println("Hello");

        String pixelBreed = "Collie";
        String pixelSize = "Large";
        String pixelColor = "Sable";

        Dog bensDog = new Dog("Collie");
        //bensDog.breed="Collie";
        bensDog.setBreed("Lab");
        //bensDog.size = "Large";
        bensDog.setSize("Large");
        bensDog.setColor("Sable");

        System.out.println(bensDog.toString());
    }

}
