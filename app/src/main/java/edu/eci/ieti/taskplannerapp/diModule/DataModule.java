package edu.eci.ieti.taskplannerapp.diModule;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

import edu.eci.ieti.taskplannerapp.analytics.AnalyticsAdapter;
import edu.eci.ieti.taskplannerapp.analytics.FlurryAnalytics;
import edu.eci.ieti.taskplannerapp.persistence.AppDatabase;
import edu.eci.ieti.taskplannerapp.persistence.dao.UserDao;

@Module
@InstallIn( SingletonComponent.class )
public class DataModule {

    @Provides
    @Singleton
    public AnalyticsAdapter provideAnalyticsAdapter() {
        return new FlurryAnalytics();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }

    @Provides
    @Singleton
    public AppDatabase provideAppDataBase(@ApplicationContext Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "database-name").build();
    }

    @Provides
    @Singleton
    public UserDao provideUserDao(AppDatabase appDatabase){
        return appDatabase.userDao();
    }
}