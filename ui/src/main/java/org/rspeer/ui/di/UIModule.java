package org.rspeer.ui.di;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.rspeer.environment.BotContext;
import org.rspeer.environment.preferences.BotPreferences;
import org.rspeer.environment.preferences.JsonBotPreferencesLoader;
import org.rspeer.event.EventDispatcher;
import org.rspeer.ui.BotFrame;
import org.rspeer.ui.component.menu.BotMenuBar;
import org.rspeer.ui.component.menu.BotToolBar;

public class UIModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EventDispatcher.class).annotatedWith(Names.named("BotDispatcher"))
                .toInstance(EventDispatcher.Factory.getDefault("bot"));
        bind(BotToolBar.class).asEagerSingleton();
        bind(BotContext.class).asEagerSingleton();

        bind(BotPreferences.class).toInstance(new JsonBotPreferencesLoader().load());
        bind(BotFrame.class).asEagerSingleton();
        bind(BotMenuBar.class).asEagerSingleton();
    }

}
