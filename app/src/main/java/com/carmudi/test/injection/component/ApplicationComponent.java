package com.carmudi.test.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.carmudi.test.data.DataManager;
import com.carmudi.test.data.remote.MvpStarterService;
import com.carmudi.test.injection.ApplicationContext;
import com.carmudi.test.injection.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    MvpStarterService mvpBoilerplateService();
}
