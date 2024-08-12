/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.fragment.app.Fragment
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.yalantis.ucrop.PictureMultiCuttingActivity
 *  com.yalantis.ucrop.UCrop$Options
 *  com.yalantis.ucrop.UCropActivity
 */
package com.yalantis.ucrop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.entity.LocalMedia;
import com.yalantis.ucrop.PictureMultiCuttingActivity;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;
import java.util.ArrayList;

public class UCrop {
    public static final String EXTRA_ASPECT_RATIO_X = "com.yalantis.ucrop.AspectRatioX";
    public static final String EXTRA_ASPECT_RATIO_Y = "com.yalantis.ucrop.AspectRatioY";
    public static final String EXTRA_ERROR = "com.yalantis.ucrop.Error";
    public static final String EXTRA_INPUT_URI = "com.yalantis.ucrop.InputUri";
    public static final String EXTRA_MAX_SIZE_X = "com.yalantis.ucrop.MaxSizeX";
    public static final String EXTRA_MAX_SIZE_Y = "com.yalantis.ucrop.MaxSizeY";
    public static final String EXTRA_OUTPUT_CROP_ASPECT_RATIO = "com.yalantis.ucrop.CropAspectRatio";
    public static final String EXTRA_OUTPUT_IMAGE_HEIGHT = "com.yalantis.ucrop.ImageHeight";
    public static final String EXTRA_OUTPUT_IMAGE_WIDTH = "com.yalantis.ucrop.ImageWidth";
    public static final String EXTRA_OUTPUT_OFFSET_X = "com.yalantis.ucrop.OffsetX";
    public static final String EXTRA_OUTPUT_OFFSET_Y = "com.yalantis.ucrop.OffsetY";
    public static final String EXTRA_OUTPUT_URI = "com.yalantis.ucrop.OutputUri";
    private static final String EXTRA_PREFIX = "com.yalantis.ucrop";
    public static final int MIN_SIZE = 10;
    public static final int REQUEST_CROP = 69;
    public static final int REQUEST_MULTI_CROP = 609;
    public static final int RESULT_ERROR = 96;
    private final Intent mCropIntent = new Intent();
    private final Bundle mCropOptionsBundle;

    private UCrop(Uri uri, Uri uri2) {
        Bundle bundle;
        this.mCropOptionsBundle = bundle = new Bundle();
        bundle.putParcelable(EXTRA_INPUT_URI, (Parcelable)uri);
        this.mCropOptionsBundle.putParcelable(EXTRA_OUTPUT_URI, (Parcelable)uri2);
    }

    public static Throwable getError(Intent intent) {
        return (Throwable)intent.getSerializableExtra(EXTRA_ERROR);
    }

    public static ArrayList<LocalMedia> getMultipleOutput(Intent intent) {
        return intent.getParcelableArrayListExtra("com.yalantis.ucrop.OutputUriList");
    }

    public static Uri getOutput(Intent intent) {
        return (Uri)intent.getParcelableExtra(EXTRA_OUTPUT_URI);
    }

    public static float getOutputCropAspectRatio(Intent intent) {
        return intent.getFloatExtra(EXTRA_OUTPUT_CROP_ASPECT_RATIO, 0.0f);
    }

    public static int getOutputImageHeight(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_HEIGHT, -1);
    }

    public static int getOutputImageWidth(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_WIDTH, -1);
    }

    public static UCrop of(Uri uri, Uri uri2) {
        return new UCrop(uri, uri2);
    }

    public Intent getIntent(Context context) {
        this.mCropIntent.setClass(context, UCropActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public Intent getMultipleIntent(Context context) {
        this.mCropIntent.setClass(context, PictureMultiCuttingActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public void start(Activity activity, int n) {
        activity.startActivityForResult(this.getIntent((Context)activity), n);
    }

    public void start(Activity activity, int n, int n2) {
        activity.startActivityForResult(this.getIntent((Context)activity), n);
        activity.overridePendingTransition(n2, R.anim.ucrop_anim_fade_in);
    }

    public void start(Context context, Fragment fragment) {
        this.start(context, fragment, 69);
    }

    public void start(Context context, Fragment fragment, int n) {
        fragment.startActivityForResult(this.getIntent(context), n);
    }

    public void start(AppCompatActivity appCompatActivity) {
        this.start(appCompatActivity, 69);
    }

    public void start(AppCompatActivity appCompatActivity, int n) {
        appCompatActivity.startActivityForResult(this.getIntent((Context)appCompatActivity), n);
    }

    public void startAnimationActivity(Activity activity, int n) {
        if (n != 0) {
            this.start(activity, 69, n);
        } else {
            this.start(activity, 69);
        }
    }

    public void startAnimationMultipleCropActivity(Activity activity, int n) {
        if (n != 0) {
            this.startMultiple(activity, 609, n);
        } else {
            this.startMultiple(activity, 609);
        }
    }

    public void startMultiple(Activity activity) {
        this.start(activity, 609);
    }

    public void startMultiple(Activity activity, int n) {
        activity.startActivityForResult(this.getMultipleIntent((Context)activity), n);
    }

    public void startMultiple(Activity activity, int n, int n2) {
        activity.startActivityForResult(this.getMultipleIntent((Context)activity), n);
        activity.overridePendingTransition(n2, R.anim.ucrop_anim_fade_in);
    }

    public UCrop useSourceImageAspectRatio() {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, 0.0f);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, 0.0f);
        return this;
    }

    public UCrop withAspectRatio(float f, float f2) {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, f);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, f2);
        return this;
    }

    public UCrop withMaxResultSize(int n, int n2) {
        int n3 = n;
        if (n < 10) {
            n3 = 10;
        }
        n = n2;
        if (n2 < 10) {
            n = 10;
        }
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_X, n3);
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_Y, n);
        return this;
    }

    public UCrop withOptions(Options options) {
        this.mCropOptionsBundle.putAll(options.getOptionBundle());
        return this;
    }
}
