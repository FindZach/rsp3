package org.rspeer.di;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.rspeer.environment.BotContext;
import org.rspeer.environment.preferences.BotPreferences;
import org.rspeer.environment.preferences.JsonBotPreferencesLoader;
import org.rspeer.event.EventDispatcher;
import org.rspeer.game.loader.di.GameLoaderModule;
import org.rspeer.game.script.ScriptController;
import org.rspeer.game.script.di.ScriptModule;
import org.rspeer.ui.BotFrame;
import org.rspeer.ui.component.menu.BotMenuBar;
import org.rspeer.ui.di.UIModule;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ScriptModule());
        install(new UIModule());
        install(new GameLoaderModule());
    }
}
