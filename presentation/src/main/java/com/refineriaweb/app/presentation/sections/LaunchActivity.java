package com.refineriaweb.app.presentation.sections;

import com.refineriaweb.app.presentation.foundation.BaseCompatActivity;

import org.androidannotations.annotations.EActivity;

@EActivity
public class LaunchActivity extends BaseCompatActivity {
    @Override protected void init() {
        super.init();
        wireframe.usersScreen();
    }
}
