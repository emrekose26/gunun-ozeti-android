package com.emrekose.gununozeti.di.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by emrekose on 15.08.2017.
 */

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideAppContext(Application application) {
        return application.getApplicationContext();
    }
}
