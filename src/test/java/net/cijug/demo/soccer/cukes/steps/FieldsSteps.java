package net.cijug.demo.soccer.cukes.steps;

import cuke4duke.*;

public class FieldsSteps {
    private World world;

    public FieldsSteps(World world) {
        this.world = world;
    }

    @Given("^the following fields are in the database$")
    public void theFollowingFieldsAreInTheDatabase(Table table) {
        world.clearTable("fields");
        world.populateTable("fields", table.hashes());
    }

    @When("^an api user requests a field list in \"(.*)\" format$")
    public void anApiUserRequestsAFieldList(String format) {
    }
}
