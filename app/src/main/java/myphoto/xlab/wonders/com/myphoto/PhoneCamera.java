package myphoto.xlab.wonders.com.myphoto;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by lixuanwu on 15/9/15.
 */
public class PhoneCamera extends Fragment {

    private static final int REQUEST_CODE_PICK_IMAGE = 0;
    private static final int REQUEST_CODE_CAPTURE_CAMEIA = 1;
    private final String IMAGE_TYPE = "image/*";

    private final int IMAGE_CODE = 0;

    private void getImageFromAlbum(){
        Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);

        getAlbum.setType(IMAGE_TYPE);

        startActivityForResult(getAlbum, IMAGE_CODE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_IMAGE) {
            Uri uri = data.getData();
            //to do find the path of pic

        } else if (requestCode == REQUEST_CODE_CAPTURE_CAMEIA ) {
            Uri uri = data.getData();
            //to do find the path of pic
        } }
}
