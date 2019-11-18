package test.soc365.society365.user.Become_a_member;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import test.soc365.society365.R;

public class list_of_societiesAdapter extends RecyclerView.Adapter<list_of_societiesAdapter.MyViewHolder>
{
    ArrayList text1;
    Context context;

    public list_of_societiesAdapter(Context context,ArrayList text1) {
        this.text1 = text1;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_setting_adapter,parent,false);
        return new list_of_societiesAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        /*ListItem listItem = name.get(position);
        holder.text1.setText(listItem.getText());*/
        holder.image1.setVisibility(View.GONE);
        holder.text1.setText((CharSequence) text1.get(position));
        //  holder.text3.setText((CharSequence) text3.get(position));
        // holder.image2.setImageResource(mResources2[position]);
/*
        Toast.makeText(context,text3.size(),Toast.LENGTH_SHORT).show();

        if(1.equals(text3.size()))
        {
            holder.text3.setVisibility(View.VISIBLE);
           holder.text3.setText((CharSequence) text3.get(position));
        }*/
        holder.fullbody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentcr=new Intent(context, form_of_user.class);
                intentcr.putExtra("ursociety",(CharSequence) text1.get(position));
                context.startActivity(intentcr);

            }
        });
    }

    @Override
    public int getItemCount() {
        return text1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        public TextView text1;
        LinearLayout fullbody;
        public ImageView image1;
        public MyViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            image1=(ImageView) itemView.findViewById(R.id.image1);

            text1=(TextView)itemView.findViewById(R.id.reportname);
            fullbody=(LinearLayout)itemView.findViewById(R.id.fullbody);

        }


        @Override
        public void onClick(View view) {

        }
    }
}
