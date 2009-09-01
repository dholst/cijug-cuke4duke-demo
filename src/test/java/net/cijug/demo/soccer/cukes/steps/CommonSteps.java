package net.cijug.demo.soccer.cukes.steps;

import cuke4duke.After;
import cuke4duke.Then;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import static org.junit.Assert.assertEquals;
import org.xml.sax.SAXException;

import java.io.IOException;

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
        assertEquals(expected, world.getResponseStatus());
    }

    @Then("^the returned xml should be$")
    public void theReturnedXmlShouldBe(String xml) throws Exception {
        XMLUnit.setIgnoreAttributeOrder(true);
        XMLUnit.setIgnoreWhitespace(true);
        XMLAssert.assertXMLEqual(xml, world.getResponseContent());
    }

    @Then("^the returned json should be (.*)$")
    public void theReturnedJsonShouldBe(String json) throws Exception {
        assertEquals(json, world.getResponseContent());
    }
}
