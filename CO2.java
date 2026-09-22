package Project1;
import java.util.Scanner;

 public class CO2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int LEVELS = 3, SPOTS_PER_LEVEL = 10;
        boolean[][] parkingLot = new boolean[LEVELS][SPOTS_PER_LEVEL];

        while (true) {
            System.out.println("\n--- Parking Lot Menu ---");
            System.out.println("1. Park a Car");
            System.out.println("2. Remove a Car");
            System.out.println("3. Display Parking Status");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter level: ");
                int l = sc.nextInt();
                System.out.print("Enter spot: ");
                int s = sc.nextInt();
                if (!parkingLot[l][s]) {
                    parkingLot[l][s] = true;
                    System.out.println("Car parked successfully!");
                } else {
                    System.out.println("Spot already occupied!");
                }
            } else if (choice == 2) {
                System.out.print("Enter level: ");
                int l = sc.nextInt();
                System.out.print("Enter spot: ");
                int s = sc.nextInt();
                if (parkingLot[l][s]) {
                    parkingLot[l][s] = false;
                    System.out.println("Car removed successfully!");
                } else {
                    System.out.println("Spot already empty!");
                }
            } else if (choice == 3) {
                for (int i = 0; i < LEVELS; i++) {
                    System.out.print("Level " + i + ": ");
                    for (int j = 0; j < SPOTS_PER_LEVEL; j++) {
                        System.out.print(parkingLot[i][j] ? "[X]" : "[ ]");
                    }
                    System.out.println();
                }
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
