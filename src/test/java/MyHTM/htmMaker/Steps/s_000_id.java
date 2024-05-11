package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.Model.Util.Util.ID;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class s_000_id {

    ID[] ids;
    int size;

    @Given("I have a list of {int} IDs")
    public void iHaveAListOfIDs(int size) {
        this.size = size;
        this.ids = new ID[size];
        for(int i = 0; i < size; i++) {
            ids[i] = new ID();
            System.out.println(ids[i].getId());
        }
    }

    @When("I check the uniqueness of the IDs all should be unique")
    public void iCheckTheUniquenessOfTheIDs() {
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; size < 3; j++) {
                assertNotEquals(ids[i].getId(), ids[j].getId());
            }
        }
    }

}
