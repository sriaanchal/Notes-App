import java.io.*;
import java.util.Scanner;

public class NotesApp {

    // File path to store notes
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Task heading with your name
        System.out.println("Task 4: Notes App by Aanchal Srivastav");
        System.out.println("=== Java File I/O – Notes App ===");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting Notes App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);

        scanner.close();
    }

    // Function to add a new note using FileWriter
    private static void addNote(Scanner scanner) {
        try {
            System.out.print("Enter your note: ");
            String note = scanner.nextLine();

            // Append note to file
            FileWriter writer = new FileWriter(FILE_NAME, true); // true to append
            writer.write(note + System.lineSeparator());
            writer.close();

            System.out.println("Note saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    // Function to view all saved notes using BufferedReader
    private static void viewNotes() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No notes found.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("\nYour Notes:");
            System.out.println("-----------");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
}
