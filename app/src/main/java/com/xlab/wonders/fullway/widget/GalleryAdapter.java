package com.xlab.wonders.fullway.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xlab.wonders.fullway.dto.Data;
import com.xlab.wonders.fullway.ui.R;

import java.util.List;

/**
 * Created by lixuanwu on 15/9/23.
 */
public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;

    private List<Data> mDatas;


    public interface OnItemClickLitener {
        void onItemClick(View v, int position, String name);
    }

    /**
     * itemClick的监听
     */
    private OnItemClickLitener onItemClickLitener;


    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        this.onItemClickLitener = onItemClickLitener;
    }

    public GalleryAdapter(Context context, List<Data> mDatas) {

        this.layoutInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.service_package_doctor, parent, false);
        RecyclerView.ViewHolder viewHold = new ViewHold(view);

        return viewHold;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final ViewHold viewHold = (ViewHold) holder;
        if (mDatas.get(position).getType() == 1) {
            viewHold.img.setImageResource(mDatas.get(position).getImg());
        }
        if (onItemClickLitener != null) {
            viewHold.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickLitener.onItemClick(holder.itemView, position, viewHold.txt.getText().toString());
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {

        return mDatas.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        public ViewHold(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.doctorImg);
            txt = (TextView) itemView.findViewById(R.id.doctorName);
        }
    }

    public class ViewHold1 extends RecyclerView.ViewHolder {
        ImageView img;

        public ViewHold1(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.circleImageView);
        }
    }

}
