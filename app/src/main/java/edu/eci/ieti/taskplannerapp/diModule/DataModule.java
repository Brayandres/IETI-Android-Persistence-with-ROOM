package edu.eci.ieti.taskplannerapp.diModule;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

import edu.eci.ieti.taskplannerapp.analytics.AnalyticsAdapter;
import edu.eci.ieti.taskplannerapp.analytics.FlurryAnalytics;

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
}