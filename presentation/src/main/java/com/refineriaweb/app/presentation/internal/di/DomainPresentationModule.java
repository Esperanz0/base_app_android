package com.refineriaweb.app.presentation.internal.di;


import com.refineriaweb.app.R;
import com.refineriaweb.app.presentation.foundation.BaseApp;
import com.refineriaweb.app.presentation.foundation.BaseToolbarActivity;
import com.refineriaweb.app.presentation.sections.user_demo.user.HostUserActivity_;
import com.refineriaweb.app.presentation.sections.user_demo.users.HostUsersActivity_;

import javax.inject.Singleton;

import app.refineriaweb.com.domain.foundation.schedulers.ObserveOn;
import app.refineriaweb.com.domain.internal.di.DomainModule;
import app.refineriaweb.com.domain.sections.Wireframe;
import dagger.Module;
import dagger.Provides;
import rx.android.schedulers.AndroidSchedulers;

@Module(includes = {DomainModule.class, ApplicationModule.class})
public class DomainPresentationModule {

    @Singleton @Provides ObserveOn provideObserveOn() {
        return (() -> AndroidSchedulers.mainThread());
    }

    @Singleton @Provides Wireframe provideAndroidWireframe(BaseApp baseApp) {
        return new Wireframe() {
            @Override public void userScreen() {
                String title = baseApp.getString(R.string.user);
                HostUserActivity_.intent(baseApp.getLiveActivity())
                        .extra(BaseToolbarActivity.Behaviour.TITLE_KEY, title)
                        .start();
            }

            @Override public void usersScreen() {
                String title = baseApp.getString(R.string.users);
                HostUsersActivity_.intent(baseApp.getLiveActivity())
                        .extra(BaseToolbarActivity.Behaviour.TITLE_KEY, title)
                        .extra(BaseToolbarActivity.Behaviour.SHOW_BACK_KEY, false)
                        .start();
            }
        };
    }
}
