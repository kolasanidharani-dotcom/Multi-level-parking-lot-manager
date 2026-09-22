package Project1;
import java.util.Scanner;
public class CO3 {
    static final int LEVELS = 3, SPOTS_PER_LEVEL = 10;
    static boolean[][] parkingLot = new boolean[LEVELS][SPOTS_PER_LEVEL];

    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        while (true) {
            System.out.println("\n--- Parking Lot Menu ---");
            System.out.println("1. Park a Car");
            System.out.println("2. Remove a Car");
            System.out.println("3. Display Parking Status");
            System.out.println("4. Find First Empty Spot (Recursion)");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> parkCar(sc);
                case 2 -> removeCar(sc);
                case 3 -> displayParking();
                case 4 -> {
                    int spot = findEmptySpot(0,0);
                    if (spot != -1) System.out.println("First empty spot at index: " + spot);
                    else System.out.println("No empty spots!");
                }
                case 5 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void parkCar(java.util.Scanner sc) {
        System.out.print("Enter level: ");
        int l = sc.nextInt();
        System.out.print("Enter spot: ");
        int s = sc.nextInt();
        if (!parkingLot[l][s]) {
            parkingLot[l][s] = true;
            System.out.println("Car parked!");
        } else System.out.println("Spot occupied!");
    }

    static void removeCar(java.util.Scanner sc) {
        System.out.print("Enter level: ");
        int l = sc.nextInt();
        System.out.print("Enter spot: ");
        int s = sc.nextInt();
        if (parkingLot[l][s]) {
            parkingLot[l][s] = false;
            System.out.println("Car removed!");
        } else System.out.println("Spot empty!");
    }

    static void displayParking() {
        for (int i = 0; i < LEVELS; i++) {
            System.out.print("Level " + i + ": ");
            for (int j = 0; j < SPOTS_PER_LEVEL; j++) {
                System.out.print(parkingLot[i][j] ? "[X]" : "[ ]");
            }
            System.out.println();
        }
    }

    // Recursive search for first empty spot
    static int findEmptySpot(int level, int spot) {
        if (level >= LEVELS) return -1; // base case: no levels left
        if (spot >= SPOTS_PER_LEVEL) return findEmptySpot(level+1, 0); // move to next level
        if (!parkingLot[level][spot]) return (level * SPOTS_PER_LEVEL) + spot; // found empty
        return findEmptySpot(level, spot+1); // recursive case
    }
}
