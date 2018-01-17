package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yashjain on 1/17/18.
 */
@Repository
public class ContactDaoImpl implements ContactDao {

    private DataSource dataSource;
    private JdbcTemplate jdbctemplateObject;

    @Override
    public void insertData(Contact contact) {
        String sql = "INSERT INTO mytable (id,name,contactno) VALUES (?,?,?) ";
        jdbctemplateObject.update(sql, new Object[] {contact.getId(), contact.getName(),contact.getContactno()});
    }

    @Override
    public List<Contact> fetchData() {
        String sql = "SELECT * FROM mytable";
        return jdbctemplateObject.query(sql, new ContactMapper());
    }

    private static final class ContactMapper implements RowMapper<Contact>{
        @Override
        public Contact mapRow(ResultSet rs , int rowNum) throws SQLException{

            Contact contact =  new Contact();
            contact.setId(rs.getInt("ID"));
            contact.setContactno((rs.getString("contactno")));
            contact.setName(rs.getString("name"));
            return contact;
        }
    }

    //    GETTERS AND SETTERS
    public JdbcTemplate getJdbctemplateObject() {
        return jdbctemplateObject;
    }

    public void setJdbctemplateObject(JdbcTemplate jdbctemplateObject) {
        this.jdbctemplateObject = jdbctemplateObject;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        //this.dataSource = dataSource;
        this.jdbctemplateObject = new JdbcTemplate(dataSource);
    }
}
