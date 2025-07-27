import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TestCaseManager tcm = new TestCaseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n== Test Case Management System ==");
            System.out.println("1. Add TestCase");
            System.out.println("2. View All TestCases");
            System.out.println("3. Execute TestCase");
            System.out.println("4. Delete TestCase");
            System.out.println("5. Exit");
            System.out.print("Choose your option: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (1–5).");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.println("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Description: ");
                    String desc = scanner.nextLine();
                    tcm.addTestCase(title, desc);
                    break;

                case 2:
                    tcm.viewAllTestCases();
                    break;

                case 3:
                    try {
                        System.out.println("Enter Test Case ID to execute: ");
                        int exeid = Integer.parseInt(scanner.nextLine());

                        if (exeid <= 0) {
                            System.out.println("Invalid ID input, must be a positive number.");
                            break;
                        }

                        System.out.println("Enter execution result (Passed/Failed): ");
                        String exeresult = scanner.nextLine();

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
                    try {
                        System.out.print("Enter Test Case ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        if (deleteId <= 0) {
                            System.out.println("Invalid ID. Must be a positive number.");
                            break;
                        }

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
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
