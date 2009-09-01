package net.cijug.demo.soccer.model;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("fieldDao")
public class FieldJdbcDao extends JdbcDaoSupport implements FieldDao {
    public List<Field> findAll() {
        return getJdbcTemplate().query("select * from fields", new ParameterizedRowMapper<Field>() {
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
