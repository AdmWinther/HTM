package MyHTM.htmMaker.Steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class s_000_id {

    String[] ids;
    int size;

    @Given("I have a list of {int} IDs")
    public void iHaveAListOfIDs(int size) {
        this.size = size;
        this.ids = new String[size];
        for(int i = 0; i < size; i++) {
            ids[i] = UUID.randomUUID().toString();;
            System.out.println(ids[i]);
        }
    }

    @When("I check the uniqueness of the IDs all should be unique")
    public void iCheckTheUniquenessOfTheIDs() {
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; size < 3; j++) {
                assertNotEquals(ids[i], ids[j]);
            }
        }
    }

}
