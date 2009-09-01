import static org.junit.Assert.*;
import net.cijug.demo.soccer.cukes.World
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;

this.metaClass.mixin(cuke4duke.GroovyDsl)

Before(['']) {
  delegate.metaClass.world = new World()
}

After(['']) {
  world.destroy()
}

Then(~/the user should have received a \"(.*)\" status code/) {String expected ->
  assertEquals(expected, world.getResponseStatus());
}

Then(~/the returned xml should be/) {String expected ->
  XMLUnit.setIgnoreAttributeOrder(true);
  XMLUnit.setIgnoreWhitespace(true);
  XMLAssert.assertXMLEqual(expected, world.getResponseContent());
}

Then(~/the returned json should be (.*)/) {String expected ->
  assertEquals(expected, world.getResponseContent());
}