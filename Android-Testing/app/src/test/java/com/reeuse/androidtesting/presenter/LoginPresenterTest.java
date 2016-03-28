package com.reeuse.androidtesting.presenter;

import com.reeuse.androidtesting.R;
import com.reeuse.androidtesting.view.activities.LoginActivity;
import com.reeuse.androidtesting.view.activities.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginView loginView;
    private LoginPresenter loginPresenter;

    @Before
    public void setUp() throws Exception {
        loginPresenter = new LoginPresenter(loginView);
    }

    @Test
   public void shouldShowErrorUsernameIsEmpty()throws Exception {
       when(loginView.getUserName()).thenReturn("");// username is empty
        loginPresenter.onSubmitClicked();// submit button clicked
        verify(loginView).setUsernameError(R.string.error_field_required); // verify the username field empty error
   }


    @Test
    public void shouldShowErrorPasswordIsEmpty()throws Exception {
        when(loginView.getUserName()).thenReturn("android"); // username is given
        when(loginView.getPassword()).thenReturn(""); // password empty
        loginPresenter.onSubmitClicked(); // submit button clicked
        verify(loginView).setPasswordError(R.string.error_field_required);// verify password field empty error.
    }


}