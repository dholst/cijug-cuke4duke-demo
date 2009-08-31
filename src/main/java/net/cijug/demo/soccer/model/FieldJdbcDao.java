package net.cijug.demo.soccer.model;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("fieldDao")
public class FieldJdbcDao extends JdbcDaoSupport implements FieldDao {
    public List<Field> findAll() {
        return getJdbcTemplate().query("select * from fields", new ParameterizedRowMapper<Field>(){
            @Override
            public Field mapRow(ResultSet resultSet, int i) throws SQLException {
                Field field = new Field();
                field.id = resultSet.getLong("id");
                field.name = resultSet.getString("name");
                return field;
            }
        });
    }
}
