package db;

import db.impl.Database;
import db.impl.MySQLDB;

public class DBFactory {

    public static MySQLDB getDB(DBTypes type) {
        switch (type) {
//            case MONGO_DB: {
//                return MongoDB.getDatabase();
//            }

//            case MYSQL_DB: {
//                return MySQLDB.getDatabase();
//            }

            default:
                throw new RuntimeException("Unknown database type");
        }
    }
}

