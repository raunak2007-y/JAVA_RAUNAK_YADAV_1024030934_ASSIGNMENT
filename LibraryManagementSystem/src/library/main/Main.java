package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.ResourceService;

public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      SMART UNIVERSITY LIBRARY");
        System.out.println("======================================");

        // Create at least five resources
        LibraryResource[] resources = new LibraryResource[5];

        resources[0] = new Book(
                101,
                "Data Structures",
                "Mark Allen"
        );

        resources[1] = new Book(
                102,
                "Operating Systems",
                "Abraham Silberschatz"
        );

        resources[2] = new DigitalResource(
                103,
                "Java Programming Course",
                "James Gosling"
        );

        resources[3] = new Book(
                104,
                "Database Management",
                "Raghu Ramakrishnan"
        );

        resources[4] = new DigitalResource(
                105,
                "Machine Learning Guide",
                "Andrew Ng"
        );

        // Overdue days corresponding to each resource
        int[] overdueDays = {
                3,
                0,
                5,
                2,
                7
        };

        ResourceService service = new ResourceService();

        // Display complete details
        System.out.println("\nCOMPLETE RESOURCE DETAILS");

        service.displayAllDetails(resources);

        // Display overdue fine
        System.out.println("\nOVERDUE FINE DETAILS");

        double totalFine =
                service.calculateTotalFine(resources, overdueDays);

        System.out.println("----------------------------------");
        System.out.printf("TOTAL FINE: Rs. %.2f%n", totalFine);
        System.out.println("----------------------------------");

        // Display total resources
        LibraryResource.displayTotalResources();
    }
}
