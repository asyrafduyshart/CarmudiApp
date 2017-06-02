package com.carmudi.test.injection.component;

import dagger.Subcomponent;
import com.carmudi.test.injection.PerActivity;
import com.carmudi.test.injection.module.ActivityModule;
import com.carmudi.test.ui.base.BaseActivity;
import com.carmudi.test.ui.detail.DetailActivity;
import com.carmudi.test.ui.main.MainActivity;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);
}
