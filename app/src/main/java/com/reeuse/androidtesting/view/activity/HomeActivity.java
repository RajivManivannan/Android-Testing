package com.reeuse.androidtesting.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.reeuse.androidtesting.R;

public class HomeActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
