package com.carmudi.test.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.carmudi.test.data.remote.MvpStarterService;
import com.carmudi.test.data.remote.MvpStarterServiceFactory;
import com.carmudi.test.injection.ApplicationContext;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    static MvpStarterService provideMvpStarterService() {
        return MvpStarterServiceFactory.makeStarterService();
    }
}
