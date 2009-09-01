package net.cijug.demo.soccer.controller;

import com.sun.jersey.spi.inject.Inject;
import net.cijug.demo.soccer.model.Field;
import net.cijug.demo.soccer.model.FieldDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("fields")
public class FieldsResource {
    @Inject
    FieldDao dao;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Field> get() {
        return dao.findAll();
    }
}
