package com.hame.proyectofinalfausto;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Sincronizar la información ingresada de cliente desde WebService
 */
public class SincronizacionActivity extends AppCompatActivity {

    // UI references.
    private AutoCompleteTextView mEquipoView;
    private EditText mWSView;
    private View mProgressView;
    private View mSincFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincronizar);

        // Set up the login form.
        mEquipoView = (AutoCompleteTextView) findViewById(R.id.idenEquipo);

        mWSView = (EditText) findViewById(R.id.direccionWS);
        mWSView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.idenEquipo || id == EditorInfo.IME_NULL) {
                    intentoSincroniza();

                    return true;
                }
                return false;
            }
        });

        Button mUsrSignInButton = (Button) findViewById(R.id.sincroniza);
        mUsrSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                intentoSincroniza();
            }
        });
        mSincFormView = findViewById(R.id.sincroniza_form);
        mProgressView = findViewById(R.id.sincroniza_progress);
    }

    private void intentoSincroniza() {

        // Reset errors.
        mEquipoView.setError(null);
        mWSView.setError(null);

        // Store values at the time of the login attempt.
        String strEquipo = mEquipoView.getText().toString();
        String strWS = mWSView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid user.
        if (TextUtils.isEmpty(strEquipo)) {
            mEquipoView.setError(getString(R.string.error_field_required_Equipo));
            focusView = mEquipoView;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(strWS)) {
            mWSView.setError(getString(R.string.error_field_required_WS));
            focusView = mWSView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            //PantallaSincWS();

        }
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mSincFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mSincFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mSincFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mSincFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
    public void PantallaSincWS(){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        finish();
    }
}

