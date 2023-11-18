import java.util.*;

public class TenantManager {
    private Map<Integer,Person>tenantExtent=new HashMap<>();

    public void handleTenatntMenu(Scanner scanner){
        String tenantChoice;
        do {
            printTenantMenu();
            tenantChoice = scanner.next();

            switch (tenantChoice) {
                case "1":
                    viewTenantInformation();
                    break;
                case "2":
                    addNewTenant(scanner);
                    break;
                case "3":
                    removeTenant(scanner);
                    break;
                case "4":
                    // Add other tenant-related functionality if needed
                    break;
                case "/detail":
                    viewTenantDetails(scanner);
                    break;
                case "5":
                    System.out.println("Returning to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid command.");
            }
        } while (!tenantChoice.equals("5"));
    }

    private void printTenantMenu() {
        System.out.println("Tenant Menu:");
        System.out.println("1 - View Tenant Information");
        System.out.println("2 - Add New Tenant");
        System.out.println("3 - Remove Tenant");
        System.out.println("4 - Other Tenant Functionality (if needed)");
        System.out.println("/detail - View Tenant Details by ID");
        System.out.println("5 - Return to Main Menu");
        System.out.print("Enter your choice: ");
    }
    private void viewTenantInformation() {
        List<Person> tenants = (List<Person>) getAllTenants();
        System.out.println("List of Tenants:");
        for (Person tenant : tenants) {
            tenant.toString();
        }
    }
    private void viewTenantDetails(Scanner scanner) {
        System.out.print("Enter the ID number of the tenant to view details: ");
        viewTenantInformation();
        int idNumber = scanner.nextInt();
        Person tenant = tenantExtent.get(idNumber);
        if (tenant != null) {
            System.out.println("Tenant Details:");
            System.out.println(tenant);
        } else {
            System.out.println("Tenant not found.");
        }
    }
    public void addTenant(Person tenant) {
        tenantExtent.put(tenant.getIdNumber(), tenant);
    }

    public Person getTenantById(int idNumber) {
        return tenantExtent.get(idNumber);
    }

    public Collection<Person> getAllTenants() {
        return tenantExtent.values();
    }

    public boolean removeTenant(int idNumber) {
        return tenantExtent.remove(idNumber) != null;
    }
    private void addNewTenant(Scanner scanner) {
        System.out.print("Enter the name of the new tenant: ");
        String name = scanner.next();
        System.out.print("Enter the surname of the new tenant: ");
        String surname = scanner.next();
        System.out.print("Enter the ID number of the new tenant: ");
        int idNumber = scanner.nextInt();
        System.out.print("Enter the address of the new tenant: ");
        String address = scanner.next();

        Person newTenant = new Person(name, surname, idNumber, address);
        addTenant(newTenant);
        System.out.println("New tenant added successfully.");
    }

    private void removeTenant(Scanner scanner) {
        System.out.print("Enter the ID number of the tenant to remove: ");
        viewTenantInformation();
        int idNumber = scanner.nextInt();
        if (tenantExtent.remove(idNumber,tenantExtent.get(idNumber))) {
            System.out.println("Tenant removed successfully.");
        } else {
            System.out.println("Tenant not found.");
        }
    }
}
