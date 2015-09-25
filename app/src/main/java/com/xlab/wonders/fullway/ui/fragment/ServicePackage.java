package com.xlab.wonders.fullway.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.xlab.wonders.fullway.dto.Data;
import com.xlab.wonders.fullway.ui.R;
import com.xlab.wonders.fullway.widget.GalleryAdapter;
import com.xlab.wonders.fullway.widget.MyRecyclerView;
import com.xlab.wonders.fullway.widget.PackageTypeAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lixuanwu on 15/9/22.
 */
public class ServicePackage extends Fragment {

    private MyRecyclerView myRecyclerView;


    private RecyclerView recyclerView;

    private List<Data> typeDatas;

    private ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initData();

        View view = inflater.inflate(R.layout.service_package, container, false);


        imageView = (ImageView) view.findViewById(R.id.detail_image);

        myRecyclerView = (MyRecyclerView) view.findViewById(R.id.defineRecyclerView);

        recyclerView = (RecyclerView) view.findViewById(R.id.typeRecyclerView);


        //设置布局管理
        final LinearLayoutManager manager = new LinearLayoutManager(getActivity());

        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        myRecyclerView.setLayoutManager(manager);


        final LinearLayoutManager manager1 = new LinearLayoutManager(getActivity());

        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(manager1);

        //设置适配器
        GalleryAdapter adapter = new GalleryAdapter(getActivity(), typeDatas);

//        PackageTypeAdapter packageTypeAdapter = new PackageTypeAdapter(getActivity(), typeDatas);

        recyclerView.setAdapter(adapter);

        //设置点击的监听
        adapter.setOnItemClickLitener(new GalleryAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View v, int position, String doctorName) {

                imageView.setImageResource(typeDatas.get(position).getImg());
                Toast.makeText(getActivity(), "我是:" + doctorName + ",约么？", Toast.LENGTH_SHORT).show();
            }
        });

        myRecyclerView.setAdapter(adapter);
//        //设置滚动的监听
//        myRecyclerView.setmOnItemScrollChangeListener(new MyRecyclerView.onItemScrollChangeListener() {
//            @Override
//            public void onChange(View v, int position) {
//                imageView.setImageResource(mDatas.get(position));
//            }
//        });
        return view;
    }

    public void initData() {

        typeDatas = new ArrayList<>();
        List<Integer> mDatas = new ArrayList<>(Arrays.asList(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e));
        for (Integer m : mDatas) {
            Data data = new Data();
            data.setColor(Color.RED);
            data.setImg(m);
            data.setType(1);
            typeDatas.add(data);
        }

        List<Integer> mData = new ArrayList<>(Arrays.asList(R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e));
        for (Integer m : mData) {
            Data data = new Data();
            data.setColor(Color.RED);
            data.setImg(m);
            data.setType(2);
            typeDatas.add(data);
        }
    }

}
