package com.csci3130.project.team1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageHelper {
    public static Bitmap fetchBitmapFrom(String urlString) throws IOException {
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        is.close();
        return bitmap;
    }
}
