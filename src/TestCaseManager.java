import java.util.ArrayList;
import java.util.List;

public class TestCaseManager {

    /* Manages list of Testcases

    4 Functionalities:
    - Add, View, Execute and Delete TestCaseS

     */

    private List <TestCase> testCases = new ArrayList<>();
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

        for (TestCase testcase : testCases) {
            if (testcase.getId() == id) {
                testcase.setStatus(result);
                return true;
            }
        }
        return false;
    }

    // Delete TestCase using id as input

    public boolean deleteTestCase(int id) {

        return testCases.removeIf(testCase -> testCase.getId() == id);

    }



}
