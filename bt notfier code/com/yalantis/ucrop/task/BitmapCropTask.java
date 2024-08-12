/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 *  androidx.exifinterface.media.ExifInterface
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.yalantis.ucrop.callback.BitmapCropCallback
 *  com.yalantis.ucrop.model.CropParameters
 *  com.yalantis.ucrop.model.ImageState
 *  com.yalantis.ucrop.util.BitmapLoadUtils
 *  com.yalantis.ucrop.util.FileUtils
 *  com.yalantis.ucrop.util.ImageHeaderParser
 */
package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class BitmapCropTask
extends AsyncTask<Void, Void, Throwable> {
    private static final String TAG = "BitmapCropTask";
    private int cropOffsetX;
    private int cropOffsetY;
    private final Bitmap.CompressFormat mCompressFormat;
    private final int mCompressQuality;
    private final WeakReference<Context> mContextWeakReference;
    private final BitmapCropCallback mCropCallback;
    private final RectF mCropRect;
    private int mCroppedImageHeight;
    private int mCroppedImageWidth;
    private float mCurrentAngle;
    private final RectF mCurrentImageRect;
    private float mCurrentScale;
    private final String mImageInputPath;
    private final String mImageOutputPath;
    private final int mMaxResultImageSizeX;
    private final int mMaxResultImageSizeY;
    private Bitmap mViewBitmap;

    public BitmapCropTask(Context context, Bitmap bitmap, ImageState imageState, CropParameters cropParameters, BitmapCropCallback bitmapCropCallback) {
        this.mContextWeakReference = new WeakReference<Context>(context);
        this.mViewBitmap = bitmap;
        this.mCropRect = imageState.getCropRect();
        this.mCurrentImageRect = imageState.getCurrentImageRect();
        this.mCurrentScale = imageState.getCurrentScale();
        this.mCurrentAngle = imageState.getCurrentAngle();
        this.mMaxResultImageSizeX = cropParameters.getMaxResultImageSizeX();
        this.mMaxResultImageSizeY = cropParameters.getMaxResultImageSizeY();
        this.mCompressFormat = cropParameters.getCompressFormat();
        this.mCompressQuality = cropParameters.getCompressQuality();
        this.mImageInputPath = cropParameters.getImageInputPath();
        this.mImageOutputPath = cropParameters.getImageOutputPath();
        this.mCropCallback = bitmapCropCallback;
    }

    private boolean crop() throws IOException {
        int n;
        Bitmap bitmap;
        Object object;
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            float f = this.mCropRect.width() / this.mCurrentScale;
            float f2 = this.mCropRect.height() / this.mCurrentScale;
            if (f > (float)this.mMaxResultImageSizeX || f2 > (float)this.mMaxResultImageSizeY) {
                f = Math.min((float)this.mMaxResultImageSizeX / f, (float)this.mMaxResultImageSizeY / f2);
                object = this.mViewBitmap;
                bitmap = this.mViewBitmap;
                if (bitmap != (object = Bitmap.createScaledBitmap((Bitmap)object, (int)Math.round((float)object.getWidth() * f), (int)Math.round((float)this.mViewBitmap.getHeight() * f), (boolean)false))) {
                    bitmap.recycle();
                }
                this.mViewBitmap = object;
                this.mCurrentScale /= f;
            }
        }
        if (this.mCurrentAngle != 0.0f) {
            object = new Matrix();
            object.setRotate(this.mCurrentAngle, (float)(this.mViewBitmap.getWidth() / 2), (float)(this.mViewBitmap.getHeight() / 2));
            bitmap = this.mViewBitmap;
            bitmap = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)this.mViewBitmap.getHeight(), (Matrix)object, (boolean)true);
            object = this.mViewBitmap;
            if (object != bitmap) {
                object.recycle();
            }
            this.mViewBitmap = bitmap;
        }
        this.cropOffsetX = Math.round((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale);
        this.cropOffsetY = Math.round((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale);
        this.mCroppedImageWidth = Math.round(this.mCropRect.width() / this.mCurrentScale);
        this.mCroppedImageHeight = n = Math.round(this.mCropRect.height() / this.mCurrentScale);
        boolean bl = this.shouldCrop(this.mCroppedImageWidth, n);
        object = new StringBuilder();
        ((StringBuilder)object).append("Should crop: ");
        ((StringBuilder)object).append(bl);
        Log.i((String)TAG, (String)((StringBuilder)object).toString());
        if (bl) {
            object = null;
            if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent((String)this.mImageInputPath)) {
                object = this.getContext().getContentResolver().openFileDescriptor(Uri.parse((String)this.mImageInputPath), "r");
                bitmap = new ExifInterface((InputStream)new FileInputStream(object.getFileDescriptor()));
            } else {
                bitmap = new ExifInterface(this.mImageInputPath);
            }
            this.saveImage(Bitmap.createBitmap((Bitmap)this.mViewBitmap, (int)this.cropOffsetX, (int)this.cropOffsetY, (int)this.mCroppedImageWidth, (int)this.mCroppedImageHeight));
            if (this.mCompressFormat.equals((Object)Bitmap.CompressFormat.JPEG)) {
                ImageHeaderParser.copyExif((ExifInterface)bitmap, (int)this.mCroppedImageWidth, (int)this.mCroppedImageHeight, (String)this.mImageOutputPath);
            }
            if (object == null) return true;
            BitmapLoadUtils.close((Closeable)object);
            return true;
        }
        if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent((String)this.mImageInputPath)) {
            object = this.getContext().getContentResolver().openFileDescriptor(Uri.parse((String)this.mImageInputPath), "r");
            FileUtils.copyFile((FileInputStream)new FileInputStream(object.getFileDescriptor()), (String)this.mImageOutputPath);
            BitmapLoadUtils.close((Closeable)object);
        } else {
            FileUtils.copyFile((String)this.mImageInputPath, (String)this.mImageOutputPath);
        }
        return false;
    }

    private Context getContext() {
        return (Context)this.mContextWeakReference.get();
    }

    private void saveImage(Bitmap bitmap) throws FileNotFoundException {
        OutputStream outputStream;
        Context context = this.getContext();
        if (context == null) {
            return;
        }
        OutputStream outputStream2 = outputStream = null;
        try {
            context = context.getContentResolver();
            outputStream2 = outputStream;
            outputStream2 = outputStream;
            File file = new File(this.mImageOutputPath);
            outputStream2 = outputStream;
            outputStream2 = outputStream = context.openOutputStream(Uri.fromFile((File)file));
            bitmap.compress(this.mCompressFormat, this.mCompressQuality, outputStream);
            outputStream2 = outputStream;
            bitmap.recycle();
        }
        catch (Throwable throwable) {
            BitmapLoadUtils.close(outputStream2);
            throw throwable;
        }
        BitmapLoadUtils.close((Closeable)outputStream);
    }

    private boolean shouldCrop(int n, int n2) {
        boolean bl;
        n = Math.round((float)Math.max(n, n2) / 1000.0f);
        boolean bl2 = true;
        if (this.mMaxResultImageSizeX > 0) {
            bl = bl2;
            if (this.mMaxResultImageSizeY > 0) return bl;
        }
        float f = Math.abs(this.mCropRect.left - this.mCurrentImageRect.left);
        float f2 = n + 1;
        bl = bl2;
        if (f > f2) return bl;
        bl = bl2;
        if (Math.abs(this.mCropRect.top - this.mCurrentImageRect.top) > f2) return bl;
        bl = bl2;
        if (Math.abs(this.mCropRect.bottom - this.mCurrentImageRect.bottom) > f2) return bl;
        bl = bl2;
        if (Math.abs(this.mCropRect.right - this.mCurrentImageRect.right) > f2) return bl;
        bl = this.mCurrentAngle != 0.0f ? bl2 : false;
        return bl;
    }

    protected Throwable doInBackground(Void ... bitmap) {
        bitmap = this.mViewBitmap;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.mCurrentImageRect.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            this.crop();
            this.mViewBitmap = null;
            return null;
        }
        catch (Throwable throwable) {
            return throwable;
        }
    }

    protected void onPostExecute(Throwable throwable) {
        BitmapCropCallback bitmapCropCallback = this.mCropCallback;
        if (bitmapCropCallback == null) return;
        if (throwable == null) {
            throwable = Uri.fromFile((File)new File(this.mImageOutputPath));
            this.mCropCallback.onBitmapCropped((Uri)throwable, this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight);
        } else {
            bitmapCropCallback.onCropFailure(throwable);
        }
    }
}
