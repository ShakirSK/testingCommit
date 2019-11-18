package test.soc365.society365.user.Become_a_member;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import test.soc365.society365.R;
import test.soc365.society365.login.Login;

public class form_of_user extends AppCompatActivity {
    String ur_society;
    EditText input_ursociety;
    LinearLayout activity_item_details,submit;
    ProgressDialog progressDialog;
    TextInputLayout Textinput_Name,Textinput_emailid,Textinput_mobilenumber,Textinput_street,Textinput_landmark,city,state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_of_user);

        input_ursociety = (EditText)findViewById(R.id.input_ursociety);
        submit = (LinearLayout)findViewById(R.id.submit);
        activity_item_details = (LinearLayout)findViewById(R.id.activity_item_details);

        Textinput_Name =(TextInputLayout)findViewById(R.id.Textinput_Name);
        Textinput_emailid =(TextInputLayout)findViewById(R.id.Textinput_emailid);
        Textinput_mobilenumber =(TextInputLayout)findViewById(R.id.Textinput_mobilenumber);
        Textinput_street =(TextInputLayout)findViewById(R.id.Textinput_street);
        Textinput_landmark =(TextInputLayout)findViewById(R.id.Textinput_landmark);
        city =(TextInputLayout)findViewById(R.id.TextCity);
        state =(TextInputLayout)findViewById(R.id.TextState);


        Toolbar toolbar = findViewById(R.id.tool);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("User Form");
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        }
        Intent intent = getIntent();
        ur_society = intent.getStringExtra("ursociety");
        input_ursociety.setText(ur_society);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id ==  android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void submitdata(View v)
    {
        String Textinput_Name1 = Textinput_Name.getEditText().getText().toString();
        String Textinput_emailid1 = Textinput_emailid.getEditText().getText().toString();
        String Textinput_mobilenumber1 = Textinput_mobilenumber.getEditText().getText().toString();
        String city1 = city.getEditText().getText().toString();
        String state1 = state.getEditText().getText().toString();

        if (TextUtils.isEmpty(Textinput_Name1)) {
            //Textinput_Name.setError("Please Enter Pincode");
            Textinput_Name.requestFocus();
            return;
        }else if (TextUtils.isEmpty(Textinput_emailid1)) {
            // Textinput_emailid.setError("Please Enter StreetName");
            Textinput_emailid.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(Textinput_mobilenumber1)) {
            //Textinput_mobilenumber.setError("Please Enter Landmark");
            Textinput_mobilenumber.requestFocus();
            return;
        }else if (TextUtils.isEmpty(city1)) {
            // city.setError("Please Enter City");
            city.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(state1)) {
            //state.setError("Please Enter State");
            state.requestFocus();
            return;
        }
        progressDialog = new ProgressDialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        progressDialog = ProgressDialog.show(this, null, null);
        progressDialog.setIndeterminate(true);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.setContentView(R.layout.my_progress);
        Snackbar snackbar = Snackbar
                .make(activity_item_details, "Successfully submited your user form , we will get back to you soon", Snackbar.LENGTH_LONG);
        snackbar.show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                Intent intent1 = new Intent(getApplicationContext(), Login.class);
                startActivity(intent1);
                finish();
            }
        }, 3000);
    }

}
