package myphoto.xlab.wonders.com.myphoto;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.xlab.wonders.fullway.modol.CourseModel;
import com.xlab.wonders.fullway.network.entity.CourseResult;
import com.xlab.wonders.fullway.network.entity.Picture;
import com.xlab.wonders.fullway.ui.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends PhotoPickerFragment implements PhotoPickerFragment.OnPhotoPickFinished, CourseModel.OnCallback<CourseResult> {


    private MyRecyclerView recyclerView;
    private GalleryAdapter mAdapter;
    private List<String> mDatas = new ArrayList<>();
    private ImageView mImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        super.setOnPhotoPickFinishedListener(this);
//        getPicture(0);
        setContentView(R.layout.activity_main);

        CourseModel model = new CourseModel();

        model.setOnCallback(this);

        model.get();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initDatas() {
//        mDatas = new ArrayList<>(Arrays.asList(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
//                R.drawable.f));


    }

    @Override
    public void onPhotoPickFinished(Bitmap mBitmap, File file) {
        Toast.makeText(this, file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(CourseResult courseResult) {


        Toast.makeText(this, courseResult.toString(), Toast.LENGTH_SHORT).show();
        for (CourseResult.Course course : courseResult.getRet_values()) {
            for (Picture pic  : course.getPictures()) {
                mDatas.add(pic.getUrl());
            }
        }
        recyclerView = (MyRecyclerView) findViewById(R.id.myRecyclerView);
        mImg = (ImageView) findViewById(R.id.image_content);

        //设置布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);

        //设置适配器
        mAdapter = new GalleryAdapter(this, mDatas);
//        mAdapter.setmOnItemClickLitener(new GalleryAdapter.OnItemClickLitener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
//            }
//        });
        mAdapter.setmOnItemClickLitener(new GalleryAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                mImg.setImageURI(Uri.parse(mDatas.get(position)));
            }
        });
        recyclerView.setAdapter(mAdapter);
        recyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                mImg.setImageURI(Uri.parse(mDatas.get(position)));
            }
        });
    }

    @Override
    public void onFail(CourseResult o) {

    }
}
