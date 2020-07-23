package org.rspeer.network.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import dev.yasper.rump.Rump;
import dev.yasper.rump.client.DefaultRestClient;
import dev.yasper.rump.config.RequestConfig;
import org.rspeer.commons.Configuration;
import org.rspeer.network.service.UserService;

public class NetworkModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class)
                .annotatedWith(Names.named("APIBase"))
                .toInstance(Configuration.getApiBase());

        bind(UserService.class)
                .asEagerSingleton();
    }

    @Provides
    @Singleton
    DefaultRestClient getRestClient() {
        RequestConfig config = new RequestConfig()
                .setBaseURL(Configuration.getApiBase())
                .setTimeout(9500);

        return Rump.createDefault(config);
    }

}
