package com.emrekose.gununozeti.di.app;

import com.emrekose.gununozeti.di.main.MainActivityModule;
import com.emrekose.gununozeti.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by emrekose on 15.08.2017.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}
