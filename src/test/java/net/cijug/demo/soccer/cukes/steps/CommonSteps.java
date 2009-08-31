package net.cijug.demo.soccer.cukes.steps;

import cuke4duke.Then;
import cuke4duke.After;

public class CommonSteps {
    private World world;

    public CommonSteps(World world) {
        this.world = world;
    }

    @After("")
    public void tearDown(Object scenario) {
        world.destroy();
    }

    @Then("^the user should have received a \"(.*)\" status code$")
    public void theUserShouldHaveReceivedAStatusCode(String expected) {
    }

    @Then("^the returned xml should be$")
    public void theReturnedXmlShouldBe(String xml) {
    }
}
