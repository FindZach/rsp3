package org.rspeer.game.script.loader;

import com.google.inject.Inject;
import org.rspeer.game.script.loader.local.LocalScriptLoader;

import java.util.function.Supplier;

public class ScriptLoaderProvider implements Supplier<ScriptProvider> {

    private final LocalScriptLoader localScriptLoader;

    @Inject
    public ScriptLoaderProvider(LocalScriptLoader localScriptLoader) {
        this.localScriptLoader = localScriptLoader;
    }

    @Override
    public ScriptProvider get() {
        return localScriptLoader;
    }
}
