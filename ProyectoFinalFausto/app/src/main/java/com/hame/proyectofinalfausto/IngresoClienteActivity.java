package com.hame.proyectofinalfausto;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.R.string.cancel;

/**
 * Guarda la toma de ingreso del clientes
 */
public class IngresoClienteActivity extends AppCompatActivity implements OnMapReadyCallback {

    // UI references.

    private EditText mClienteView;
    private EditText mDirView;
    private EditText mNitView;
    private EditText mTelView;
    private AutoCompleteTextView mEmailView;
    private EditText mContactView;

    private View mProgressView;
    private View mIngCliFormView;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_cliente);

        // Set Ingreso cliente form.
        mClienteView = (AutoCompleteTextView) findViewById(R.id.cliente);
        mDirView = (AutoCompleteTextView) findViewById(R.id.direccion);
        mNitView = (AutoCompleteTextView) findViewById(R.id.nit);
        mTelView = (AutoCompleteTextView) findViewById(R.id.telefono);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email2);
        mContactView = (AutoCompleteTextView) findViewById(R.id.contacto);

        mIngCliFormView = findViewById(R.id.ingCli_form);
        mProgressView = findViewById(R.id.ingCli_progress);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void EnviarFormulario(View view)
    {
        intentoEnviarForm();
    }

    private void intentoEnviarForm() {

        // Reset errors.
        mClienteView.setError(null);
        mDirView.setError(null);
        mNitView.setError(null);
        mTelView.setError(null);
        mEmailView.setError(null);
        mContactView.setError(null);


        // Store values at the time of the login attempt.
        String strCliente = mClienteView.getText().toString();
        String strDireccion = mDirView.getText().toString();
        String strNit = mNitView.getText().toString();
        String strTelefono = mTelView.getText().toString();
        String strEmail = mEmailView.getText().toString();
        String strContacto = mContactView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid client.
        if (TextUtils.isEmpty(strCliente)) {
            mClienteView.setError(getString(R.string.error_field_required_cli));
            focusView = mClienteView;
            cancel = true;
        }

        // Check for a valid address.
        if (TextUtils.isEmpty(strDireccion)) {
            mDirView.setError(getString(R.string.error_field_required_dir));
            focusView = mDirView;
            cancel = true;
        }

        // Check for a valid nit.
        if (TextUtils.isEmpty(strNit)) {
            mNitView.setError(getString(R.string.error_field_required_nit));
            focusView = mNitView;
            cancel = true;
        }

        // Check for a valid phone.
        if (TextUtils.isEmpty(strTelefono)) {
            mTelView.setError(getString(R.string.error_field_required_tel));
            focusView = mTelView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(strEmail)) {
            mEmailView.setError(getString(R.string.error_field_requerid_email));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(strEmail)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        // Check for a valid Contact.
        if (TextUtils.isEmpty(strContacto)) {
            mContactView.setError(getString(R.string.error_field_required_cont));
            focusView = mContactView;
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
            Intent intent = new Intent(this, ImagesRecyclerActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mIngCliFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mIngCliFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mIngCliFormView.setVisibility(show ? View.GONE : View.VISIBLE);
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
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mIngCliFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

