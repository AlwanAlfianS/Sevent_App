package com.sevent.seventapp.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sevent.seventapp.R;
import com.sevent.seventapp.Timeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gizmo on 12/11/2016.
 */
public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder>{
    private ArrayList<Timeline> timelines;
    private ArrayList<Integer> itemValue;
    private Context context;
    public TimelineAdapter(Context context, ArrayList<Timeline> timelines){
        this.context = context;
        this.timelines = timelines;
        itemValue = new ArrayList<Integer>();
    }
    @Override
    public TimelineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_timeline, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TimelineAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(timelines.get(position).getTitle());
        holder.tvLokasi.setText(timelines.get(position).getLokasi());
        holder.tvTanggal.setText(timelines.get(position).getTanggal());

        holder.imageView.setImageResource(timelines.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return timelines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvLokasi,tvTanggal;
        ImageView imageView;
        public ViewHolder(View view) {
            super(view);

            tvTitle = (TextView)view.findViewById(R.id.tvTitle);
            tvLokasi = (TextView)view.findViewById(R.id.tvLokasi);
            tvTanggal = (TextView)view.findViewById(R.id.tvTanggal);
            imageView = (ImageView)view.findViewById(R.id.imageEvent);
        }
    }

}
