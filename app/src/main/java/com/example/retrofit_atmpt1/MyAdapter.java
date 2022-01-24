package com.example.retrofit_atmpt1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Character> charactersList;

    public MyAdapter(Context mContext, List<Character> charactersList) {
        this.mContext = mContext;
        this.charactersList = charactersList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v ;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.character_item , parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        holder.name.setText(charactersList.get(position).getName());
        holder.realname.setText(charactersList.get(position).getRealname());
        holder.team.setText(charactersList.get(position).getTeam());
        holder.description.setText(charactersList.get(position).getBio());

        //glide for img

        Glide.with(mContext)
                .load(charactersList.get(position).getImageurl())
                .into(holder.img);







    }

    @Override
    public int getItemCount() {
        return charactersList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView name ;
        TextView realname ;
        TextView team ;
        TextView description ;
        ImageView img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView_Name);
            realname = itemView.findViewById(R.id.textView_realname);
            team = itemView.findViewById(R.id.textView_team);
            description = itemView.findViewById(R.id.textView_description);
            img = itemView.findViewById(R.id.imageView);

        }
    }

}
