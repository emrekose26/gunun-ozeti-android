package com.emrekose.gununozeti.di.app;

import android.app.Application;

import com.emrekose.gununozeti.SummaryApp;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by emrekose on 15.08.2017.
 */

@Component(modules = {AndroidInjectionModule.class, AppModule.class, NetworkModule.class, ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(SummaryApp app);

}
