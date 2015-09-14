package myphoto.xlab.wonders.com.myphoto;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lixuanwu on 15/9/14.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;

    private List<Integer> mDatas;

    GalleryAdapter(Context context, List<Integer> mDatas) {

        this.layoutInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        ImageView mImg;
        TextView mTxt;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = layoutInflater.inflate(R.layout.myphoto_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view.findViewById(R.id.imageView);

        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mImg.setImageResource(mDatas.get(position));

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


}
