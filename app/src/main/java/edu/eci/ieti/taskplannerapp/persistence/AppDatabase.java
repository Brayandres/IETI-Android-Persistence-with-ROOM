package edu.eci.ieti.taskplannerapp.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import edu.eci.ieti.taskplannerapp.persistence.dao.UserDao;
import edu.eci.ieti.taskplannerapp.persistence.entity.User;

@Database(entities = {User.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}