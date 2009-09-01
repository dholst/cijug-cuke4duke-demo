package net.cijug.demo.soccer.controller;

import net.cijug.demo.soccer.model.Field;
import net.cijug.demo.soccer.model.FieldDao;
import static org.junit.Assert.assertSame;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class FieldsResourceTest {
    @Mock
    private FieldDao dao;
    private FieldsResource resource;

    @Before
    public void setUp() {
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
