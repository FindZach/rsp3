package org.rspeer.game.loader.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.rspeer.game.loader.GameLoader;
import org.rspeer.game.loader.config.GameConfig;

import java.io.IOException;

public class GameLoaderModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GameLoader.class).asEagerSingleton();
    }

    @Provides
    @Singleton
    GameConfig provideGameConfig() {
        try {
            return GameConfig.fetch();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
