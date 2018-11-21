package com.example.fox.mrtestproject.view.screeens;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fox.mrtestproject.R;
import com.example.fox.mrtestproject.entity.User;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    public MainAdapter(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    private List<User> userList;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_main, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        final User item = userList.get(position);
        holder.usernameTextView.setText(item.getName());
        holder.classRoomTextView.setText(item.getClassRoom());
        holder.timeTextView.setText(String.valueOf(item.getTime()));
        holder.pointTextView.setText(String.valueOf(item.getPoints()));

    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTextView;
        TextView classRoomTextView;
        TextView timeTextView;
        TextView pointTextView;

        MainViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.username_textview_main);
            classRoomTextView = itemView.findViewById(R.id.classRoom_textview_main);
            timeTextView = itemView.findViewById(R.id.time_textview_main);
            pointTextView = itemView.findViewById(R.id.point_textview_main);

        }
    }
}
