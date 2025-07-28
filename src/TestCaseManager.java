import java.util.ArrayList;
import java.util.List;

public class TestCaseManager {

    /* Manages List of Testcases:
      Basically, does 4 Functionalities:
      - Add, View, Execute and Delete TestCases
     */

    private List <TestCase> testCases = new ArrayList<>();
    private List<TestCase> deletedTestCases = new ArrayList<>();
    private int nextid = 1;

    // Add TestCase using title, description as inputs

    public void addTestCase(String title, String description){

        TestCase tc = new TestCase(nextid++, title, description,"Not Executed");
        testCases.add(tc);
        System.out.println("Test case added successfully with status 'Not Executed'.");

    }

    // View All Testcases

    public void viewAllTestCases() {

            if (testCases.isEmpty()) {
                System.out.println("No test cases found.");
            } else {
                for (TestCase testcase : testCases) {
                    System.out.println(testcase);
                }

        }
    }

    // Execute TestCase using id and Status as inputs

    public boolean executeTestCase(int id, String result) {
        for (TestCase testCase : testCases) {
            if (testCase.getId() == id) {
                if (!result.isEmpty()) {
                    testCase.setStatus(result);
                }
                return true;
            }
        }
        return false;
    }

    // Delete TestCase using id as input

    public boolean deleteTestCase(int id) {
        for (TestCase testCase : testCases) {
            if (testCase.getId() == id) {
                deletedTestCases.add(testCase);
                testCases.remove(testCase);
                return true;
            }
        }
        return false;
    }

    // Show Deleted TestCases

    public void showDeletedTestCases() {
        if (deletedTestCases.isEmpty()) {
            System.out.println("No deleted test cases available.");
        } else {
            System.out.println("\n🗂️ Deleted Test Case History:");
            for (TestCase testCase : deletedTestCases) {
                System.out.println(testCase);
            }
        }
    }

    // Restore choosen deleted Testcase

    public boolean restoreTestCaseById(int id) {
        for (TestCase testCase : deletedTestCases) {
            if (testCase.getId() == id) {
                testCases.add(testCase);
                deletedTestCases.remove(testCase);
                return true;
            }
        }
        return false;
    }

    public void restoreDeletedTestCases() {
        if (deletedTestCases.isEmpty()) {
            System.out.println("No deleted test cases to restore.");
        } else {
            testCases.addAll(deletedTestCases);
            deletedTestCases.clear();
            System.out.println("All deleted test cases restored.");
        }
    }

}