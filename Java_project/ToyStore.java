package Java_project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addNewToy(int id, String name, int quantity, double weight) {
        Toy newToy = new Toy(id, name, quantity, weight);
        toys.add(newToy);
    }

    public void changeToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void playToyLottery() {
        Random random = new Random();
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomNumber = random.nextDouble() * totalWeight;
        double currentWeightSum = 0;

        for (Toy toy : toys) {
            currentWeightSum += toy.getWeight();
            if (currentWeightSum >= randomNumber) {
                prizeToys.add(toy);
                toy.setQuantity(toy.getQuantity() - 1);
                break;
            }
        }
    }

    public Toy getPrizeToy() {
        if (prizeToys.isEmpty()) {
            return null;
        }

        Toy prizeToy = prizeToys.get(0);
        prizeToys.remove(0);
        writeToFile(prizeToy);
        return prizeToy;
    }

    private void writeToFile(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write(toy.getId() + "," + toy.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}