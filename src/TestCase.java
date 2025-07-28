public class TestCase {

    /* Create the TestCase class which basically adds TestCases with its variables
    ID, Title, Description & Status */

    private int id;
    private String title;
    private String description;
    private String status;

    //Getter and Setter for GetID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //Getter and Setter for GetTitle
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //Getter and Setter for GetDescription
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //Getter and Setter for GetStatus
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Constructor for the TestCase class, Initializes a TestCase object with the given ID, title, description, and status
    public TestCase(int id, String title, String description, String status) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;

    }

    @Override
    public String toString() {
        return "TestCase [ID = " + id + ", Title = " + title + ", Description = " + description + ", Status = " + status + "]";
    }

}
