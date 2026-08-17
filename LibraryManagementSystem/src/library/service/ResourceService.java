package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class ResourceService {

    // Display details of all resources
    public void displayAllDetails(LibraryResource[] resources) {

        for (LibraryResource resource : resources) {

            if (resource == null) {
                continue;
            }

            if (resource instanceof Printable) {
                Printable printable = (Printable) resource;
                printable.printDetails();
            }
        }
    }

    // Calculate total fine
    public double calculateTotalFine(
            LibraryResource[] resources,
            int[] overdueDaysArray) {

        double totalFine = 0.0;

        for (int i = 0; i < resources.length; i++) {

            LibraryResource resource = resources[i];

            if (resource == null) {
                continue;
            }

            int overdueDays = overdueDaysArray[i];

            // Validate overdue days
            if (!InputValidator.validateFineDays(overdueDays)) {

                System.out.println(
                        "Invalid overdue days for Resource ID "
                        + resource.getResourceId()
                        + " - Skipped.");

                continue;
            }

            // Calculate fine only for overdue resources
            if (overdueDays > 0) {

                double fine = resource.calculateFine(overdueDays);

                System.out.printf(
                        "Resource ID %d (%s) - %d day(s) overdue - Fine: Rs. %.2f%n",
                        resource.getResourceId(),
                        resource.getTitle(),
                        overdueDays,
                        fine
                );

                totalFine += fine;
            }
        }

        return totalFine;
    }
}
