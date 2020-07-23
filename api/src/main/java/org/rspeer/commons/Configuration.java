package org.rspeer.commons;

import java.nio.file.Path;

/**
 * Bot configuration data and paths
 */
public class Configuration {

    public static final String APPLICATION_NAME = "rspeer3";

    public static String getApplicationTitle() {
        return APPLICATION_NAME.substring(0, 3).toUpperCase() + APPLICATION_NAME.substring(3);
    }

    private static final String API_BASE_ENV = "api";
    private static final String DEFAULT_API_BASE = "https://www.rspeer.org/api/v3/";

    public static String getApiBase() {
        String base = System.getenv(API_BASE_ENV);
        if (base == null || base.isEmpty()) {
            base = DEFAULT_API_BASE;
        }

        return base;
    }

    public static class Paths {

        public static final Path HOME = java.nio.file.Paths.get(System.getProperty("user.home"), APPLICATION_NAME);
        public static final Path MODSCRIPT_LOCATION = java.nio.file.Paths.get("modscript");
        public static final Path GAMEPACK_LOCATION = HOME.resolve("gamepack.jar");
        public static final Path SCRIPTS_LOCATION = HOME.resolve("scripts");
        public static final Path DATA_LOCATION = HOME.resolve("data");
        public static final Path PREFERENCES_LOCATION = HOME.resolve("preferences.json");
    }
}
