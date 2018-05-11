package com.reeuse.androidtesting.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.reeuse.androidtesting.app.AppPreference;


/**
 * Created by Rajiv M.
 */
public class BaseActivity extends AppCompatActivity {

    protected AppPreference appPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appPreference = new AppPreference(this);
    }


}
