package db.impl;

import bo.Person;

import java.util.List;

public interface Database {

     void putIntoDB(Person person);

     Person getById(int id);

     List<Person> getAll();

     void update(Person person);

     void delete(int id);

     void closeConnection();

}
