package org.rspeer.game.loader;

import com.google.inject.Inject;
import jag.game.RSClient;
import org.rspeer.commons.Configuration;
import org.rspeer.game.loader.applet.GameApplet;
import org.rspeer.game.loader.config.GameConfig;
import org.rspeer.game.loader.gamepack.GamePack;
import org.rspeer.injector.Injector;
import org.rspeer.injector.script.Modscript;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * Utility class providing functions to load and inject the game
 */
public class GameLoader {

    private final GamePack gamePack;
    private final GameApplet gameApplet;

    @Inject
    public GameLoader(GamePack gamePack, GameApplet gameApplet) {
        this.gamePack = gamePack;
        this.gameApplet = gameApplet;
    }

    public RSClient load(boolean local, Consumer<RSClient> later) throws IOException {
        RSClient result = null;
        if (local) {
            result = fromLocalModscript();
        }

        later.accept(result);
        return result;
    }

    private RSClient fromLocalModscript() throws IOException {
        gamePack.downloadIfOutdated();

        Injector injector = new Injector(Modscript.load(Configuration.Paths.MODSCRIPT_LOCATION));
        ClassLoader classLoader = gamePack.getInjectedLoader(injector);
        return (RSClient) gameApplet.start(classLoader);
    }
}
