package coms.example.allinonelowfiproject.dairy;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import coms.example.allinonelowfiproject.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<MainData> arrayList;
    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        holder.tv_content.setText(arrayList.get(position).getTv_content());
        holder.iv_photo.setImageResource(arrayList.get(position).getIv_photo());
        holder.iv_photo.setVisibility(holder.iv_photo.VISIBLE);
        holder.day.setText(arrayList.get(position).getDay());
    }

    @Override
    public int getItemCount() {
        return (null!= arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_content;
        protected ImageView iv_photo;
        protected TextView day;

        public CustomViewHolder(View view) {
            super(view);
            this.iv_profile = (ImageView) view.findViewById(R.id.iv_profile);
            this.tv_content = (TextView) view.findViewById(R.id.tv_content);
            this.iv_photo = (ImageView) view.findViewById(R.id.iv_photo);
            this.day = (TextView) view.findViewById(R.id.day);
        }
    }
}
