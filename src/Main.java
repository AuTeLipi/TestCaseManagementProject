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
            System.out.println("5. Exit");
            System.out.print("Choose your option: ");

            int choice;

            // Read and validate user input for menu choice
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (1–5).");
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
                        System.out.println("Enter Test Case ID to execute: ");
                        int exeid = Integer.parseInt(scanner.nextLine());

                        if (exeid <= 0) {
                            System.out.println("Invalid ID input, must be a positive number.");
                            break;
                        }

                        // Get the execution result from user
                        System.out.println("Enter execution result (Passed/Failed): ");
                        String exeresult = scanner.nextLine();

                        // Validates result and update test case
                        if (exeresult.equalsIgnoreCase("Passed") || exeresult.equalsIgnoreCase("Failed")) {
                            if (tcm.executeTestCase(exeid, exeresult)) {
                                System.out.println("Test case executed and status updated.");
                            } else {
                                System.out.println("Test case not found.");
                            }
                        } else {
                            System.out.println("Invalid result. Use 'Passed' or 'Failed'.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number for ID.");
                    } catch (Exception e) {
                        System.out.println("An error occurred while executing the test case: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Delete a test case by ID
                    try {
                        System.out.print("Enter Test Case ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        // Validate ID input
                        if (deleteId <= 0) {
                            System.out.println("Invalid ID. Must be a positive number.");
                            break;
                        }

                        // Deleting the test case
                        if (tcm.deleteTestCase(deleteId)) {
                            System.out.println("Test case deleted.");
                        } else {
                            System.out.println("Test case not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number for ID." );
                    } catch (Exception e) {
                        System.out.println("An error occurred while deleting the test case: " + e.getMessage());
                    }
                    break;

                case 5:
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
