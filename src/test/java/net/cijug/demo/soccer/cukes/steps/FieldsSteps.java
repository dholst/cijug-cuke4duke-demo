package net.cijug.demo.soccer.cukes.steps;

import cuke4duke.Given;
import cuke4duke.Table;
import cuke4duke.When;
import cuke4duke.spring.StepDefinitions;
import net.cijug.demo.soccer.cukes.World;
import org.springframework.beans.factory.annotation.Autowired;

@StepDefinitions
public class FieldsSteps {
    @Autowired
    private World world;

    @Given("^the following fields are in the database$")
    public void theFollowingFieldsAreInTheDatabase(Table table) {
        world.clearTable("fields");
        world.populateTable("fields", table.hashes());
    }

    @When("^an api user requests a field list in \"(.*)\" format$")
    public void anApiUserRequestsAFieldList(String format) throws Exception {
        world.get("fields", format);
    }
}
