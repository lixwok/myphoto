package com.xlab.wonders.fullway.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xlab.wonders.fullway.ui.fragment.FirstPage;
import com.xlab.wonders.fullway.ui.fragment.PersonalCenter;
import com.xlab.wonders.fullway.ui.fragment.ServicePackage;

/**
 * Created by lixuanwu on 15/9/22.
 */
public class MainActivity extends FragmentActivity {

    private static FragmentManager frm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frm = getSupportFragmentManager();


        initFirstPageFragment();
        //处理底部的点击事件
        dealBottomButtonsClickEvent();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    /**
     * 初始化首页的Fragment
     */
    public void initFirstPageFragment() {
        FragmentTransaction fragmentTransaction = frm.beginTransaction();
        FirstPage firstPage = new FirstPage();

        fragmentTransaction.add(R.id.fragmentRoot, firstPage, "firstPage");
        fragmentTransaction.addToBackStack("firstPage");
        fragmentTransaction.commit();
    }

    public void dealBottomButtonsClickEvent() {

        findViewById(R.id.firstPage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frm.findFragmentByTag("firstPage") != null && frm.findFragmentByTag("firstPage").isVisible()) {
                    return;
                }
                popAllFragmentsExceptTheBottomOne("firstPage");
            }

        });

        findViewById(R.id.service_package).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popAllFragmentsExceptTheBottomOne("servicePackage");
                FragmentTransaction ft = frm.beginTransaction();
                ft.hide(frm.findFragmentByTag("firstPage"));
                ServicePackage servicePackage = new ServicePackage();
                ft.add(R.id.fragmentRoot, servicePackage, "servicePackage");
                ft.addToBackStack("servicePackage");
                ft.commit();
                findViewById(R.id.bottomList).setVisibility(View.INVISIBLE);

            }
        });
        findViewById(R.id.personal_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popAllFragmentsExceptTheBottomOne("personal_center");
                FragmentTransaction ft = frm.beginTransaction();
                ft.hide(frm.findFragmentByTag("firstPage"));
                PersonalCenter personalCenter = new PersonalCenter();
                ft.add(R.id.fragmentRoot, personalCenter, "personalCenter");
                ft.addToBackStack("personalCenter");
                ft.commit();
            }
        });

    }

    /**
     * 从back stack弹出所有的fragment，保留首页的那个
     */
    public void popAllFragmentsExceptTheBottomOne(String p) {
        for (int i = 0, count = frm.getBackStackEntryCount() - 1; i < count; i++) {
            Log.d("tag", count + p);
            frm.popBackStack();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            findViewById(R.id.bottomList).setVisibility(View.VISIBLE);
            popAllFragmentsExceptTheBottomOne("back");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
