package test.soc365.society365.user.Past_Payment_History;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dmax.dialog.SpotsDialog;
import test.soc365.society365.InernetConnection.Connectivity;
import test.soc365.society365.R;
import test.soc365.society365.SingleTonRequest.MySingleton;
import test.soc365.society365.staticurl.StaticUrl;

public class user_payment_history_activity extends AppCompatActivity {

    ArrayList<Payment_History_Model> historyarray=new ArrayList<Payment_History_Model>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String targeturl;
    SpotsDialog dialog;
    String userid,societyid,usertype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpaymenthistory);
        //activity_user_payment_history_activity
        dialog=new SpotsDialog(getApplicationContext(),R.style.Custom);
        recyclerView= findViewById(R.id.recycleview);

        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Payment_History_Adapter(this,historyarray);
        recyclerView.setAdapter(adapter);

//        Bundle arg=getArguments();
//        //String uid,sid,utype;
//        userid=arg.getString("userid");
//        societyid=arg.getString("societyid");
//        usertype=arg.getString("usertype");

        Intent intent=getIntent();
        userid=intent.getStringExtra("userid");
        societyid=intent.getStringExtra("societyid");
        usertype=intent.getStringExtra("usertype");

        historyview();

    }

    public void historyview()
    {
        targeturl= StaticUrl.pastpayment+userid;

        Log.d("TargetUrl",targeturl);
        if(Connectivity.isConnected(getApplicationContext()))
        {
            final StringRequest request=new StringRequest(Request.Method.GET, targeturl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {
                    Log.d("Responce:",response);
                    dialog.dismiss();
                    try
                    {
                        JSONArray jsonArray=new JSONArray(response);
                        JSONObject jsonObject=jsonArray.getJSONObject(0);

                        if(jsonObject.getString("status").equals("1"))
                        {
                            JSONArray jsonArray1=jsonObject.getJSONArray("paymenthistory");
                            for(int i=0;i<jsonArray1.length();i++)
                            {
                                JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                                Payment_History_Model historyModel = new Payment_History_Model();
                                historyModel.setPaymentid(jsonObject1.getString("payment_id"));
                                historyModel.setUserid(jsonObject1.getString("user_id"));
                                historyModel.setBankacc(jsonObject1.getString("bank_account"));
                                historyModel.setBillamt(jsonObject1.getString("bill_amount"));
                                historyModel.setDepoistedate(jsonObject1.getString("payment_deposit_date"));
                                historyModel.setDepositeamt(jsonObject1.getString("payment_deposit_amount"));
                                historyModel.setPaidamt(jsonObject1.getString("paid_amount"));
                                historyModel.setPaymentmode(jsonObject1.getString("payment_mode"));
                                historyModel.setPaymentrecieved(jsonObject1.getString("payment_received_date"));
                                historyModel.setRefno(jsonObject1.getString("refrence_no"));
                                historyModel.setStatus2(jsonObject1.getString("status"));
                                historyarray.add(historyModel);
                            }
                            adapter.notifyDataSetChanged();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"No Record found...",Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Check Internet connection",Toast.LENGTH_SHORT).show();
        }
    }

}
