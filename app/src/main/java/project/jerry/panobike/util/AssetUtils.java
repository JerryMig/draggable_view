package project.jerry.panobike.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Migme_Jerry on 2017/5/3.
 */

public class AssetUtils {

    @Nullable
    public static Bitmap getBitmap(Context context, String imagePath) {
        AssetManager assetManager = context.getAssets();

        Log.d("test", "addMissileToBoard: image path :" + imagePath);
        try {
            InputStream is = assetManager.open(imagePath);
            return BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int getMissileCount(Context context, String folderName) {
        AssetManager assetManager = context.getAssets();
        String[] files = new String[0];
        try {
            files = assetManager.list(folderName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files.length;
    }

}
