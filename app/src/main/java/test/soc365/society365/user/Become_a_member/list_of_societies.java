package test.soc365.society365.user.Become_a_member;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

import test.soc365.society365.R;

public class list_of_societies extends AppCompatActivity {
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_societies);


        Toolbar toolbar = findViewById(R.id.tool);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Choose Your Society");
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclevieww);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());


        ArrayList text1 = new ArrayList<>(Arrays.asList("Amrut Vishwa Co. Op. Hsg. Soc. Ltd",
                "Arihant Aksh Co. Op. Hsg. Soc. Ltd",
                "Ayodhya  CHSL",
                "Balaji Garden B",
                "Bhagirathi Complex BN A and B CHS Ltd",
                "Bhagirathi Complex B. N. C and E.C.H.S. Ltd.",
                "Ekdant Pooja Co. Op. Hsg. Soc. Ltd",
                "Gaurish Co. Op. Hsg. Soc. Ltd",
                "Gayatri Home Co. Op. Hsg. Soc. Ltd",
                "Gayatri Sankul Co. Op. Hsg. Soc. Ltd",
                "Gopal Heights Co. Op. Hsg. Soc. Ltd",
                "Govind Vihar Wing  A,B,C Co-Op. Hsg. Soc. Ltd.",
                "Guruchintan Co. Op. Hsg. Soc. Ltd",
                "Hari Chhaya Co. Op. Hsg. Soc. Ltd",
                "Indrayani Park A and B Wing CHSL",
                "Jahangir Co. Op. Hsg. Soc. Ltd",
                "Kanishk Sankool",
                "Madhav Shristi Shiv Parvati Co. Op. Hsg. Soc. Ltd",
                "Madhukrishna Co. Op. Hsg. Soc. Ltd",
                "Mahalaxmi Villa Co. Op. Hsg. Soc. Ltd",
                "Mangeshi Sahara Radha Kunj Co. Op. Hsg. Soc. Ltd",
                "Mangeshi Sahara Yashoda Kunj Co. Op. Hsg. Soc. Ltd",
                "Mangeshi Srushti C and D CHS Ltd.",
                "Mangala Garden Co. Op. Hsg. Soc. Ltd",
                "New Satyam Co. Op. Hsg. Soc. Ltd"));



        list_of_societiesAdapter adapter = new list_of_societiesAdapter(getApplicationContext(), text1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);

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

}
