package com.reeuse.androidtesting.view.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.reeuse.androidtesting.R;
import com.reeuse.androidtesting.presenter.LoginPresenter;
import com.reeuse.androidtesting.view.LoginView;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginView {

  private TextInputLayout usernameTil;
  private TextInputLayout passwordTil;
  private EditText usernameEt;
  private EditText passwordEt;
  private View progressView;
  private View loginFormView;

  private LoginPresenter loginPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    if (appPreference.isLoggedIn()) {
      startActivity(new Intent(this, HomeActivity.class));
      finish();
    }

    usernameEt = findViewById(R.id.login_username_et);
    passwordEt = findViewById(R.id.login_password_et);
    usernameTil = findViewById(R.id.login_username_til);
    passwordTil = findViewById(R.id.login_password_til);

    findViewById(R.id.login_sign_in_btn).setOnClickListener(
        v -> loginPresenter.onSubmitClicked());

    loginFormView = findViewById(R.id.login_form);
    progressView = findViewById(R.id.login_progress);

    loginPresenter = new LoginPresenter(this);
  }

  @Override
  protected void onDestroy() {
    loginPresenter.onDestroy();
    super.onDestroy();
  }

  @Override
  public String getPassword() {
    return passwordEt.getText().toString().trim();
  }

  @Override
  public void showProgress() {
    showProgress(true);
  }

  @Override
  public void hideProgress() {
    showProgress(false);
  }

  @Override
  public void setUsernameError(int resId) {
    usernameTil.setError(getString(resId));
  }

  @Override
  public void setPasswordError(int resId) {
    passwordTil.setError(getString(resId));
  }

  @Override
  public String getUserName() {
    return usernameEt.getText().toString().trim();
  }

  @Override
  public void showMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
  }

  @Override
  public void navigateToHome() {
    appPreference.setLoggedIn(true);
    startActivity(new Intent(this, HomeActivity.class));
    finish();
  }

  /**
   * Shows the progress UI and hides the login form.
   */
  private void showProgress(final boolean show) {
    // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
    // for very easy animations. If available, use these APIs to fade-in
    // the progress spinner.
    if (Build.VERSION.SDK_INT >= 18) {
      int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

      loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
      loginFormView.animate().setDuration(shortAnimTime).alpha(
          show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
          loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
      });

      progressView.setVisibility(show ? View.VISIBLE : View.GONE);
      progressView.animate().setDuration(shortAnimTime).alpha(
          show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
          progressView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
      });
    } else {
      // The ViewPropertyAnimator APIs are not available, so simply show
      // and hide the relevant UI components.
      progressView.setVisibility(show ? View.VISIBLE : View.GONE);
      loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
    }
  }
}
