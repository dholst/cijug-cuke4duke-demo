package net.cijug.demo.soccer.view;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import net.cijug.demo.soccer.model.Field;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Provider
public class JaxbContextResolver implements ContextResolver<JAXBContext> {
    private final JAXBContext context;
    private final Set<Class> types;

    public JaxbContextResolver() throws Exception {
        Class[] cTypes = {Field.class};
        this.types = new HashSet(Arrays.asList(cTypes));
        this.context = new JSONJAXBContext(JSONConfiguration.natural().build(), cTypes);
    }

    public JAXBContext getContext(Class<?> objectType) {
        return (types.contains(objectType)) ? context : null;
    }
}
