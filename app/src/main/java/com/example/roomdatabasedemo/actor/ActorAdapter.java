package com.example.roomdatabasedemo.actor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.roomdatabasedemo.Product;
import com.example.roomdatabasedemo.R;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    private Context context;
    private List<Actor>actorList;

    public ActorAdapter(List<Actor> actorList, Context context) {
        this.actorList = actorList;
        this.context = context;
    }


    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actor_card,parent,false);
        return new ActorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int i) {
        Actor currentActor=actorList.get(i);
        holder.id_tv.setText(currentActor.getId());
        holder.name_tv.setText(currentActor.getName());
        holder.age_tv.setText(currentActor.getAge());
        Glide.with(context).load(currentActor.getImage()).into(holder.actor_image_view);
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public void getAllActors(List<Actor> actorList){
        this.actorList=actorList;
        //notifyDataSetChanged();
    }

    public void setAllActors(List<Actor> allActors) {
        this.actorList = allActors;
        notifyDataSetChanged();
    }
    public class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView id_tv,name_tv,age_tv;
        ImageView actor_image_view;
        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            id_tv=itemView.findViewById(R.id.actor_card_id);
            name_tv=itemView.findViewById(R.id.actor_card_name);
            age_tv=itemView.findViewById(R.id.actor_card_age);

            actor_image_view=itemView.findViewById(R.id.actor_card_image);
        }
    }
}
