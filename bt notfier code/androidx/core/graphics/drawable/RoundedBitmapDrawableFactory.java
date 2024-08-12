/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.core.graphics.drawable.RoundedBitmapDrawable
 *  androidx.core.graphics.drawable.RoundedBitmapDrawable21
 *  androidx.core.graphics.drawable.RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable
 */
package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable21;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    private RoundedBitmapDrawableFactory() {
    }

    public static RoundedBitmapDrawable create(Resources resources, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 21) return new DefaultRoundedBitmapDrawable(resources, bitmap);
        return new RoundedBitmapDrawable21(resources, bitmap);
    }

    public static RoundedBitmapDrawable create(Resources resources, InputStream inputStream) {
        if ((resources = RoundedBitmapDrawableFactory.create(resources, BitmapFactory.decodeStream((InputStream)inputStream))).getBitmap() != null) return resources;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RoundedBitmapDrawable cannot decode ");
        stringBuilder.append(inputStream);
        Log.w((String)TAG, (String)stringBuilder.toString());
        return resources;
    }

    public static RoundedBitmapDrawable create(Resources resources, String string) {
        if ((resources = RoundedBitmapDrawableFactory.create(resources, BitmapFactory.decodeFile((String)string))).getBitmap() != null) return resources;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RoundedBitmapDrawable cannot decode ");
        stringBuilder.append(string);
        Log.w((String)TAG, (String)stringBuilder.toString());
        return resources;
    }
}
