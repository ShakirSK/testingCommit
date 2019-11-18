package test.soc365.society365.Onboarding;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

import test.soc365.society365.R;

public class MainIntroActivity extends IntroActivity {

    //public static final String EXTRA_SCROLLABLE = "com.heinrichreimersoftware.materialintro.demo.EXTRA_SCROLLABLE";

    protected void onCreate(Bundle savedInstanceState) {
        setFullscreen(true);
        super.onCreate(savedInstanceState);

        //boolean scrollable = intent.getBooleanExtra(EXTRA_SCROLLABLE, false);

        setButtonBackVisible(true);

        setButtonNextVisible(true);



        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_metaphor)
                .backgroundDark(R.color.color_dark_material_metaphor)
                .fragment(R.layout.firstintro)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .fragment(R.layout.secondintro)
                .build());

       /* setButtonCtaVisible(true);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);*/


        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_shadow)
                .backgroundDark(R.color.color_dark_material_shadow)
                .fragment(R.layout.thirdintro)
                //   .scrollable(scrollable)
//                .buttonCtaLabel("Get Started")
//                .buttonCtaClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent i = new Intent(getApplicationContext(),Dashboard.class);
//                        startActivity(i);
//                        finish();
//                    }
//                })


                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .fragment(R.layout.fourintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_shadow)
                .backgroundDark(R.color.color_dark_material_shadow)
                .fragment(R.layout.fiveintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .fragment(R.layout.sixintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_shadow)
                .backgroundDark(R.color.color_dark_material_shadow)
                .fragment(R.layout.sevenintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .fragment(R.layout.eightintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_shadow)
                .backgroundDark(R.color.color_dark_material_shadow)
                .fragment(R.layout.nineintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .fragment(R.layout.tenintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_shadow)
                .backgroundDark(R.color.color_dark_material_shadow)
                .fragment(R.layout.elevenintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .fragment(R.layout.twelveintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_shadow)
                .backgroundDark(R.color.color_dark_material_shadow)
                .fragment(R.layout.thirteenintro)

                .build());
        addSlide(new FragmentSlide.Builder()

                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .fragment(R.layout.fourteenintro)

                .build());

    }
}