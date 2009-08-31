package net.cijug.demo.soccer.controller;

import net.cijug.demo.soccer.model.Field;
import net.cijug.demo.soccer.model.FieldDao;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import com.sun.jersey.spi.inject.Inject;

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
