package com.xlab.wonders.fullway.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xlab.wonders.fullway.ui.R;

/**
 * Created by lixuanwu on 15/9/22.
 */
public class FirstPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.first_page, container, false);
    }
}
