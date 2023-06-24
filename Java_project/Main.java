package Java_project;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addNewToy(1, "Teddy Bear", 5, 30);
        toyStore.addNewToy(2, "Doll", 3, 20);
        toyStore.addNewToy(3, "Toy Car", 10, 50);

        toyStore.changeToyWeight(1, 40);

        toyStore.playToyLottery();
        toyStore.playToyLottery();

        Toy prizeToy = toyStore.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Congratulations! You won a " + prizeToy.getName());
        } else {
            System.out.println("No prize toys available.");
        }
    }
}
