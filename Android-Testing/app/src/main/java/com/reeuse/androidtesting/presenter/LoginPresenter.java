package com.reeuse.androidtesting.presenter;

import android.os.Handler;
import android.text.TextUtils;

import com.reeuse.androidtesting.R;
import com.reeuse.androidtesting.view.activities.LoginView;


/**
 * Created by Rajiv M.
 */
public class LoginPresenter {

    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }


    public void onSubmitClicked() {
        String userName = loginView.getUserName();
        if (userName.isEmpty()) {
            loginView.setUsernameError(R.string.error_field_required);
            return;
        }
        String password = loginView.getPassword();
        if (password.isEmpty()) {
            loginView.setPasswordError(R.string.error_field_required);
            return;
        }
        loginView.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.hideProgress();
                loginView.navigateToHome();
            }
        }, 3000); // delay 3 seconds

    }


    public void onDestroy() {
        loginView = null;
    }
}




