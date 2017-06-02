package com.carmudi.test.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import com.carmudi.test.common.injection.module.ApplicationTestModule;
import com.carmudi.test.injection.component.ApplicationComponent;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}