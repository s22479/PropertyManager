import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    static boolean timeThreadRunning = true;
    private static ScheduledExecutorService timeExecutorService = Executors.newSingleThreadScheduledExecutor();
    private static ScheduledFuture<?> timeThreadFuture;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        loadDateFromFile();
        timeThreadFuture = timeExecutorService.scheduleAtFixedRate(() -> {
            if (timeThreadRunning) {
                MainMenu.currentDate = MainMenu.currentDate.plusDays(1);
                System.out.println("Current Date: " + MainMenu.currentDate);
            }
        }, 0, 5, TimeUnit.SECONDS);
        String choice;
        do {
            MainMenu.printMainMenu();
            choice = scanner.next();

            switch (choice) {
                case "1":
                    //handleTenantMenu(housingEstate, scanner);
                    break;
                case "2":
                    //handleEstatesMenu(housingEstate, scanner);
                    break;
                case "3":
                    //saveDataToFile(housingEstate);
                    break;
                case "4":
                    // Add other functionality if needed
                    break;
                case "5":
                    stopTimeThread(timeExecutorService);
                    saveDateToFile();
                    System.out.println("Exiting the program.");
                    break;
                case "s":
                    toggleTimeThread(timeExecutorService);
                    break;
                case "p":
                    stopTimeThread(timeExecutorService);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (!choice.equals("5"));

        scanner.close();
        timeExecutorService.shutdown();
    }
    private static void loadDateFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("date.txt"))) {
            String dateStr = reader.readLine();
            if (dateStr != null && !dateStr.isEmpty()) {
                MainMenu.currentDate = LocalDate.parse(dateStr);
                System.out.println("Loaded Date from file: " + MainMenu.currentDate);
            }
        } catch (IOException | NullPointerException | java.time.format.DateTimeParseException e) {
            System.out.println("Error loading date from file. Using the current date.");
            MainMenu.currentDate = LocalDate.now();
        }
    }

    private static void saveDateToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("date.txt"))) {
            writer.write(MainMenu.currentDate.toString());
            System.out.println("Saved Date to file: " + MainMenu.currentDate);
        } catch (IOException e) {
            System.out.println("Error saving date to file.");
        }
    }
    private static void stopTimeThread(ScheduledExecutorService timeExecutorService) {
        timeThreadRunning = false;
    }

    private static void toggleTimeThread(ScheduledExecutorService timeExecutorService) {
        timeThreadRunning = !timeThreadRunning;
    }
}