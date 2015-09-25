package com.xlab.wonders.fullway.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xlab.wonders.fullway.dto.Data;
import com.xlab.wonders.fullway.ui.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lixuanwu on 15/9/24.
 */
public class PackageTypeAdapter extends RecyclerView.Adapter<PackageTypeAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;

    private List<Data> mDatas;


    public PackageTypeAdapter(Context context, List<Data> typeDatas) {
        this.layoutInflater = LayoutInflater.from(context);
        this.mDatas = typeDatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.service_package_type, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);


        viewHolder.cImag = (CircleImageView) view.findViewById(R.id.circleImageView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Integer key = mDatas.get(position).getImg();
        holder.cImag.setImageResource(key);
        holder.cImag.setBorderColor(mDatas.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        private CircleImageView cImag;
    }
}
