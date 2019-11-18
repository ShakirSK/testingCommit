package test.soc365.society365.Onboarding;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import test.soc365.society365.R;
import test.soc365.society365.login.Login;

public class Onboarding_Screen extends AppCompatActivity {
    public static final String PREF_KEY_FIRST_START = "com.heinrichreimersoftware.materialintro.demo.PREF_KEY_FIRST_START";
    public static final int REQUEST_CODE_INTRO = 1;

    TextView new_to_society,signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding__screen);

        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        }


        new_to_society = (TextView)findViewById(R.id.new_to_society);
        signin = (TextView)findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(Onboarding_Screen.this, Login.class);

                intentLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentLogin);
            }
        });

        new_to_society.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainIntroActivity.class);
                startActivityForResult(intent, REQUEST_CODE_INTRO);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_INTRO) {
            if (resultCode == RESULT_OK) {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean(PREF_KEY_FIRST_START, false)
                        .apply();
            } else {
                //User cancelled the intro so we'll finish this activity too.
                finish();
            }
        }
    }
}
