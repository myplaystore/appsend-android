package com.tomclaw.appsend.main.profile.list;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.tomclaw.appsend.R;
import com.tomclaw.appsend.core.StoreServiceHolder;
import com.tomclaw.appsend.main.store.UploadsFragment;
import com.tomclaw.appsend.util.ThemeHelper;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Igor on 22.10.2017.
 */
@SuppressLint("Registered")
@EActivity(R.layout.user_files_activity)
public class FilesActivity extends AppCompatActivity {

    @Bean
    StoreServiceHolder serviceHolder;

    @ViewById
    Toolbar toolbar;

    @FragmentById
    UploadsFragment uploadsFragment;

    @Extra
    Long userId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ThemeHelper.updateTheme(this);
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void init() {
        ThemeHelper.updateStatusBar(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }

        uploadsFragment.setUserId(userId);
    }

    @OptionsItem(android.R.id.home)
    boolean actionHome() {
        onBackPressed();
        return true;
    }
}
