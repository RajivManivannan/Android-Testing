package com.reeuse.androidtesting.view;

/**
 * Created by Rajiv M.
 */
public interface LoginView {

    String getPassword();

    void showProgress();

    void hideProgress();

    void setUsernameError(int resId);

    void setPasswordError(int resId);

    String getUserName();

    void showMessage(String message);

    void navigateToHome();
}
