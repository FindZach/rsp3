package org.rspeer.game.script.di;

import com.google.inject.AbstractModule;
import org.rspeer.commons.Configuration;
import org.rspeer.game.script.ScriptController;
import org.rspeer.game.script.loader.local.LocalScriptLoader;

public class ScriptModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ScriptController.class).asEagerSingleton();
        bind(LocalScriptLoader.class).toInstance(new LocalScriptLoader(Configuration.Paths.SCRIPTS_LOCATION));
    }

}
