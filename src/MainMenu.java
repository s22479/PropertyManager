import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainMenu {
    static LocalDate currentDate=LocalDate.of(2010,01,01);
    public static void printMainMenu(){
        System.out.println("Hello boss, current date is: "+currentDate.toString());
        System.out.println("Main Menu:");
        System.out.println("To stop time press: 'p'");
        System.out.println("To start time press: 's'");
        System.out.println("1 - Tenants");
        System.out.println("2 - Estates");
        System.out.println("3 - Save Data to File");
        System.out.println("4 - Other Functionality (if needed)");
        System.out.println("5 - Exit");
        System.out.print("Enter your choice: ");
    }
    public static void printMainMen() {
    }
//    private static void handleTenantMenu(HousingEstate housingEstate, Scanner scanner) {
//        // Implement submenu for managing tenants
//        System.out.println("Tenant Menu:");
//        // Add options for managing tenants
//    }
//
//    private static void handleEstatesMenu(HousingEstate housingEstate, Scanner scanner) {
//        // Implement submenu for managing estates
//        System.out.println("Estates Menu:");
//        // Add options for managing estates
//    }
//
//    private static void saveDataToFile(HousingEstate housingEstate) {
//        // Implement logic to save data to a file
//        System.out.println("Saving data to file...");
//        // Add saving data to a file logic here
//        System.out.println("Data saved successfully.");
//    }
}
