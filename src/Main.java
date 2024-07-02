
import java.util.Scanner;

public class Main {
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            //Minimum element index in the unsorted part
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the current value
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a series of numbers separated by spaces
        System.out.print("Enter a series of numbers separated by spaces: ");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] numbers = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            numbers[i] = Integer.parseInt(inputArray[i]);
        }

        // Ask the user to choose the sorting algorithm
        System.out.print("Choose the sorting algorithm (1 for bubble sort, 2 for selection sort): ");
        int choice = scanner.nextInt();

        int[] sortedArray;

        switch (choice) {
            case 1:
                sortedArray = bubbleSort(numbers);
                break;
            case 2:
                sortedArray = selectionSort(numbers);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        // Display the sorted array
        System.out.print("Sorted array: ");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}
