package edu.eci.ieti.taskplannerapp.analytics;

import java.util.Map;

public interface AnalyticsAdapter {
    public void report( String name, Map<String, String> data );
}