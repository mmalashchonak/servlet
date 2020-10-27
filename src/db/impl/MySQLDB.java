package db.impl;

import bo.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

public class MySQLDB {

    public static Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = getConnection("jdbc:mysql://localhost:3306/weather_db?serverTimezone=Europe/Minsk", "root", "1234");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF Not EXISTS Person " +
                    "(id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "NAME CHAR(20) NOT NULL, " +
                    "PASSWORD CHAR(30) NOT NULL, " +
                    "PRIMARY KEY (id))");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public static void putIntoDB(Person person) {
        try (Connection connection = MySQLDB.getConnect()) {
            String sql = "insert into Person (NAME, PASSWORD) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.executeUpdate();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Person getById(int id) {
        Person person = null;
        try (Connection connection = MySQLDB.getConnect()) {
            String sql = "select * from Person where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person = new Person(resultSet.getString("NAME"), resultSet.getString("PASSWORD"), resultSet.getInt(("id")));
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    public static List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = MySQLDB.getConnect()) {
            String sql = "select * from Person";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                persons.add(new Person(resultSet.getString("NAME"), resultSet.getString("PASSWORD"), resultSet.getInt("id")));
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return persons;
    }


    public static void update(Person person) {
        try (Connection connection = MySQLDB.getConnect()) {
            String sql = "UPDATE Person SET NAME=?, PASSWORD=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.setInt(3, person.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Person was updated successfully!");
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete(int id) {
        try (Connection connection = MySQLDB.getConnect()) {
            String sql = "DELETE FROM Person WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Person was deleted successfully!");
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();

        }
    }
}
