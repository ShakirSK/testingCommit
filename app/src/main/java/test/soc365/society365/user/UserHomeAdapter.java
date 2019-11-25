package test.soc365.society365.user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import test.soc365.society365.R;
import test.soc365.society365.user.audit_report.UserAuditReport;
import test.soc365.society365.user.billpayment.BillPayment;
import test.soc365.society365.user.bulletine_board.UserBoard;
import test.soc365.society365.user.list_request_society.Request_Society;
import test.soc365.society365.user.mom.UserMom;
import test.soc365.society365.user.society_activity.UserActivity;

public class UserHomeAdapter extends RecyclerView.Adapter<UserHomeAdapter.MyViewHolder>
{
    ArrayList text1;
    Context context;
    private int[] mResources1;

    String timeperiod1,timeperiod2;
    int year1,year2;
    String day1,day2;
    String month1,month2;
    String societyid,usrid,utype,uemail,mno;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public UserHomeAdapter(Context context, ArrayList text1, int[] resources1) {
        this.text1 = text1;
        this.context = context;
        this.mResources1 = resources1;

    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_firstfragment,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        sharedPreferences = context.getSharedPreferences("test.soc365.society365", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        usrid = sharedPreferences.getString("USERID","0" );
        societyid = sharedPreferences.getString("SOCIETYID","0" );
        utype = sharedPreferences.getString("USERTYPE","0" );
        uemail= sharedPreferences.getString("email","0");
        mno= sharedPreferences.getString("mobile","0");
        /*ListItem listItem = name.get(position);
        holder.text1.setText(listItem.getText());*/
        holder.amount.setVisibility(View.GONE);
       // holder.amount.setText((CharSequence) text1.get(position));
        holder.reportname.setText((CharSequence) text1.get(position));
        holder.image1.setImageResource(mResources1[position]);
       /* if(position<=2)
        {
            holder.reportname.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.reportname.setVisibility(View.GONE);
        }*/
/*
        if(position==3 || position==4 || position==5 ||position==6 )
        {*/


        // holder.image2.setImageResource(mResources2[position]);
/*
        Toast.makeText(context,text3.size(),Toast.LENGTH_SHORT).show();

        if(1.equals(text3.size()))
        {
            holder.text3.setVisibility(View.VISIBLE);
           holder.text3.setText((CharSequence) text3.get(position));
        }*/

        day1 = "01";
        day2 = "31";
        month1 = "04";
        month2 = "03";
        year1 =2018;
        year2 =2019;

        timeperiod1=year1+"-"+month1+"-"+day1;

        timeperiod2=year2+"-"+month2+"-"+day2;
        holder.setItemClickListener(new ItemClickListener() {

            @Override
            public void onItemClick(View v, int pos) {

                //INTENT OBJ
     /*           if(position==1)
                {
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.add(R.id.container,YOUR_FRAGMENT_NAME,YOUR_FRAGMENT_STRING_TAG);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }else*/


    if(position==0)
                {
                    BillPayment billPayment = new BillPayment();
                    Bundle args = new Bundle();
                    args.putString("userid",usrid);
                    args.putString("societyid", societyid);
                    args.putString("usertype", utype);
                    args.putString("usermobile", mno);
                    args.putString("useremailid", uemail);
                    billPayment.setArguments(args);
                    android.support.v4.app.FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flContent,billPayment);

                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.commit();
                }
    else if(position==1)
    {
        Request_Society request_society=new Request_Society();
        Bundle args = new Bundle();
        args.putString("userid",usrid);
        args.putString("societyid", societyid);
        args.putString("usertype", utype);
        request_society.setArguments(args);
        android.support.v4.app.FragmentManager fragmentManager =((AppCompatActivity)context).getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent
                ,request_society);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
    else if(position==2)
    {
        UserAuditReport userAuditReport=new UserAuditReport();
        Bundle args = new Bundle();
        args.putString("userid",usrid);
        args.putString("societyid", societyid);
        args.putString("usertype", utype);
        userAuditReport.setArguments(args);
        android.support.v4.app.FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent
                ,userAuditReport);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
    else if(position==3)
    {
        UserBoard userBoard=new UserBoard();
        Bundle args = new Bundle();
        args.putString("userid",usrid);
        args.putString("societyid", societyid);
        args.putString("usertype", utype);
        userBoard.setArguments(args);
        android.support.v4.app.FragmentManager fragmentManager =((AppCompatActivity)context).getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent
                ,userBoard);
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
    else if(position==4)
    {
        UserActivity activity=new UserActivity();
        Bundle args = new Bundle();
        args.putString("userid",usrid);
        args.putString("societyid", societyid);
        args.putString("usertype", utype);
        activity.setArguments(args);
        android.support.v4.app.FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent
                ,activity);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
    else if(position==5)
    {
        UserMom userMom=new UserMom();
        Bundle args = new Bundle();
        args.putString("userid",usrid);
        args.putString("societyid", societyid);
        args.putString("usertype", utype);
        userMom.setArguments(args);
        android.support.v4.app.FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent
                ,userMom);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

            }
        });
    }

    @Override
    public int getItemCount() {
        return text1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        public TextView amount,reportname;
        private ItemClickListener itemClickListener;
        public ImageView image1,image2;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            image1=(ImageView) itemView.findViewById(R.id.image1);
            //  image2=(ImageView) itemView.findViewById(R.id.image2);

            amount=(TextView)itemView.findViewById(R.id.amount);
            reportname =(TextView)itemView.findViewById(R.id.reportname);


        }
        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v,getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic)
        {
            this.itemClickListener=ic;

        }


    }
}
