package net.cijug.demo.soccer.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Test;
import org.junit.Before;
import net.cijug.demo.soccer.model.FieldDao;
import net.cijug.demo.soccer.model.Field;

import java.util.ArrayList;
import java.util.List;

public class FieldsResourceTest {
    @Mock
    private FieldDao dao;
    private FieldsResource resource;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        resource = new FieldsResource();
        resource.dao = dao;
    }

    @Test
    public void testGet() {
        List<Field> fields = new ArrayList<Field>();
        when(dao.findAll()).thenReturn(fields);
        assertSame(resource.get(), fields);
    }
}
