import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creating an instance of the TestCaseManager
        TestCaseManager tcm = new TestCaseManager();
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        // Infinite loop to display menu and handle user operations
        while (true) {
            // Display the main menu
            System.out.println("\n== Test Case Management System ==");
            System.out.println("1. Add TestCase");
            System.out.println("2. View All TestCases");
            System.out.println("3. Execute TestCase");
            System.out.println("4. Delete TestCase");
            System.out.println("5. Restore Deleted TestCase");
            System.out.println("6. Exit");
            System.out.print("Choose your option: ");

            int choice;

            // Read and validate user input for menu choice
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, Please enter a valid number (1–6).");
                continue;
            }

            switch (choice) {

                case 1:
                    // Add a new test case
                    System.out.println("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Description: ");
                    String desc = scanner.nextLine();
                    tcm.addTestCase(title, desc);
                    break;

                case 2:
                    // View all test cases
                    tcm.viewAllTestCases();
                    break;

                case 3:
                    // Execute a specific test case by ID
                    try {
                        System.out.print("Enter Test Case ID to execute: ");
                        int exeid = Integer.parseInt(scanner.nextLine());

                        // Short validation: check if the ID exists
                        if (!tcm.executeTestCase(exeid, "")) {
                            System.out.println("Test case not found.");
                            break;
                        }

                        System.out.print("Enter execution result (Passed/Failed): ");
                        String exeresult = scanner.nextLine();

                        if (exeresult.equalsIgnoreCase("Passed") || exeresult.equalsIgnoreCase("Failed")) {
                            tcm.executeTestCase(exeid, exeresult);
                            System.out.println("Test case executed and status updated.");
                        } else {
                            System.out.println("Invalid result, Use 'Passed' or 'Failed'.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, Enter a number.");
                    }
                    break;

                case 4:
                    // Delete a test case by ID
                    try {
                        System.out.print("Enter Test Case ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        // Validate ID input
                        if (deleteId <= 0) {
                            System.out.println("Invalid ID, must be a positive number.");
                            break;
                        }

                        // Deleting the test case
                        if (tcm.deleteTestCase(deleteId)) {
                            System.out.println("Test case deleted.");
                        } else {
                            System.out.println("Test case not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, Please enter a valid number for ID." );
                    } catch (Exception e) {
                        System.out.println("An error occurred while deleting the test case: " + e.getMessage());
                    }
                    break;

                case 5:
                    // Shows Deleted Testcase History and We can choose which Testcase to restore
                    tcm.showDeletedTestCases();
                    System.out.print("Enter ID of the test case to restore individual Testcase, -1 to restore all, or 0 to cancel: ");
                    try {
                        int restoreId = Integer.parseInt(scanner.nextLine());

                        if (restoreId == 0) {
                            System.out.println("Restore cancelled.");
                        } else if (restoreId == -1) {
                            tcm.restoreDeletedTestCases();
                        } else if (tcm.restoreTestCaseById(restoreId)) {
                            System.out.println("Test case restored.");
                        } else {
                            System.out.println("Test case not found in deleted history.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, must be a number.");
                    }
                    break;


                case 6:
                    // Exit the application
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    // Handle invalid menu option
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
