package com.example.travelapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travelapp.Landmark;
import com.example.travelapp.R;

import java.util.List;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.ViewHolder> {
    private List<Landmark> landmarks;
    ClickInterface clickInterface;

    public LandmarkAdapter(List<Landmark> landmarks, ClickInterface clickInterface) {
        this.landmarks = landmarks;
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_landmark, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Landmark landmark = landmarks.get(position);
        holder.titleButton.setText(landmark.getTitle());
        Glide.with(holder.itemView.getContext())
                .load(landmark.getImageResourceId())
                .centerCrop()
                .into(holder.imageView);
        holder.cl_layout.setOnClickListener(v->{
            clickInterface.onClick(position);
        });
        holder.titleButton.setOnClickListener(v->{
            clickInterface.onClick(position);
        });
        holder.imageView.setOnClickListener(v->{
            clickInterface.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return landmarks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        Button titleButton;
        ConstraintLayout cl_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleButton = itemView.findViewById(R.id.titleButton);
            cl_layout = itemView.findViewById(R.id.cl_layout);
        }
    }
}
