package coms.example.allinonelowfiproject.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import coms.example.allinonelowfiproject.R;
import coms.example.allinonelowfiproject.objects.DashItem;

/**
 * Created by 규열 on 2018-02-03.
*/

public class DashboardRecyclerViewAdapter extends RecyclerView.Adapter<DashboardRecyclerViewAdapter.MyViewHolder>{

    Context context;
    ArrayList<DashItem> list;

    public DashboardRecyclerViewAdapter(Context context, ArrayList<DashItem> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.main_memo.setText(list.get(position).getMainMemo());
        holder.semi_memo.setText(list.get(position).getSemiMemo());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_dash_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView main_memo;
        TextView semi_memo;

        public MyViewHolder(View itemView) {
            super(itemView);
            main_memo = itemView.findViewById(R.id.main_dashboard_content_mainmemo);
            semi_memo = itemView.findViewById(R.id.main_dashboard_content_semimemo);
        }
    }

}