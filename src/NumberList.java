package Exam;

import java.util.Scanner;

public class NumberList {
    private static final int MAX_SIZE = 100;
    private static int[] numbers = new int[MAX_SIZE];
    private static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Options:");
            System.out.println("1. Input integer numbers");
            System.out.println("2. List all numbers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    inputNumbers(scanner);
                    break;
                case 2:
                    listAllNumbers();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
        scanner.close();
    }

    private static void inputNumbers(Scanner scanner) {
        System.out.print("Enter how many numbers you want to input: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (currentIndex + count <= MAX_SIZE) {
            System.out.println("Enter " + count + " integer numbers:");
            for (int i = 0; i < count; i++) {
                System.out.print("Number " + (i + 1) + ": ");
                numbers[currentIndex++] = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            }
            System.out.println("Numbers added successfully.");
        } else {
            System.out.println("Not enough space to add " + count + " numbers.");
        }
    }

    private static void listAllNumbers() {
        if (currentIndex == 0) {
            System.out.println("No numbers to display.");
            return;
        }
        System.out.println("List of numbers:");
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(numbers[i]);
        }
    }
}