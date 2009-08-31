package net.cijug.demo.soccer.cukes.steps;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class World {
    private DataSourceTransactionManager transactionManager;
    private TransactionStatus transactionStatus;
    private JdbcTemplate jdbcTemplate;

    public void clearTable(String table) {
        getJdbcTemplate().execute("delete from " + table);
    }

    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate((DataSource) ApplicationContextFactory.getApplicationContext().getBean("dataSource"));
            startTransaction();
        }

        return jdbcTemplate;
    }

    private void startTransaction() {
        transactionManager = (DataSourceTransactionManager) ApplicationContextFactory.getApplicationContext().getBean("transactionManager");
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
        transactionStatus = transactionManager.getTransaction(def);
    }

    public void destroy() {
        if (transactionManager != null) {
            transactionManager.commit(transactionStatus);
        }
    }

    public void populateTable(String table, List<Map<String, String>> rows) {
        for (Map<String, String> row : rows) {
            String sql = buildSqlStatementFrom(table, row);
            getJdbcTemplate().update(sql, buildSqlParametersFrom(row));
        }
    }

    private Object[] buildSqlParametersFrom(Map<String, String> row) {
        List<Object> values = new ArrayList<Object>();

        for(Map.Entry<String, String> entry : row.entrySet()){
            values.add(entry.getValue());
        }

        return values.toArray();
    }

    private String buildSqlStatementFrom(String table, Map<String, String> row) {
        String separator = "";
        StringBuffer sb = new StringBuffer("insert into ");
        sb.append(table);
        sb.append("(");

        for(Map.Entry<String, String> entry : row.entrySet()){
            sb.append(separator).append(entry.getKey());
            separator = ",";
        }

        sb.append(") values(");
        separator = "";

        for(int i = 0; i < row.size(); i++){
            sb.append(separator).append("?");
            separator = ",";
        }

        sb.append(")");

        return sb.toString();
    }
}
