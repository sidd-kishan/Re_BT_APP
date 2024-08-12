/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.appcompat.app.AppCompatDelegate
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.BlendModeColorFilterCompat
 *  androidx.core.graphics.BlendModeCompat
 *  androidx.transition.AutoTransition
 *  androidx.transition.Transition
 *  androidx.transition.TransitionManager
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$dimen
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$menu
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.immersive.ImmersiveManage
 *  com.luck.picture.lib.tools.ScreenUtils
 *  com.yalantis.ucrop.PictureMultiCuttingActivity
 *  com.yalantis.ucrop.callback.BitmapCropCallback
 *  com.yalantis.ucrop.model.AspectRatio
 *  com.yalantis.ucrop.util.FileUtils
 *  com.yalantis.ucrop.util.SelectedStateListDrawable
 *  com.yalantis.ucrop.view.GestureCropImageView
 *  com.yalantis.ucrop.view.OverlayView
 *  com.yalantis.ucrop.view.TransformImageView$TransformImageListener
 *  com.yalantis.ucrop.view.UCropView
 *  com.yalantis.ucrop.view.widget.AspectRatioTextView
 *  com.yalantis.ucrop.view.widget.HorizontalProgressWheelView
 *  com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$ScrollingListener
 */
package com.yalantis.ucrop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.tools.ScreenUtils;
import com.yalantis.ucrop.PictureMultiCuttingActivity;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UCropActivity
extends AppCompatActivity {
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50L;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final String TAG = "UCropActivity";
    private boolean isDragFrame;
    private boolean isOpenWhiteStatusBar;
    private boolean isRotateEnabled;
    private boolean isScaleEnabled;
    private int mActiveControlsWidgetColor;
    private int mActiveWidgetColor;
    private int[] mAllowedGestures;
    private List<AspectRatioTextView> mAspectRatioTextViews;
    protected View mBlockingView;
    private Bitmap.CompressFormat mCompressFormat;
    private int mCompressQuality = 90;
    private Transition mControlsTransition;
    private List<ViewGroup> mCropAspectRatioViews = new ArrayList<ViewGroup>();
    private GestureCropImageView mGestureCropImageView;
    private TransformImageView.TransformImageListener mImageListener;
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    protected int mScreenWidth;
    protected boolean mShowBottomControls;
    private boolean mShowLoader = true;
    private final View.OnClickListener mStateClickListener;
    private int mStatusBarColor;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarWidgetColor;
    private UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;
    protected RelativeLayout uCropPhotoBox;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled((boolean)true);
    }

    public UCropActivity() {
        this.mAspectRatioTextViews = new ArrayList<AspectRatioTextView>();
        this.mCompressFormat = DEFAULT_COMPRESS_FORMAT;
        this.mAllowedGestures = new int[]{1, 2, 3};
        this.mImageListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mStateClickListener = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ void access$000(UCropActivity uCropActivity, float f) {
        uCropActivity.setAngleText(f);
    }

    static /* synthetic */ void access$100(UCropActivity uCropActivity, float f) {
        uCropActivity.setScaleText(f);
    }

    static /* synthetic */ UCropView access$200(UCropActivity uCropActivity) {
        return uCropActivity.mUCropView;
    }

    static /* synthetic */ boolean access$300(UCropActivity uCropActivity) {
        return uCropActivity.isOnTouch();
    }

    static /* synthetic */ boolean access$402(UCropActivity uCropActivity, boolean bl) {
        uCropActivity.mShowLoader = bl;
        return bl;
    }

    static /* synthetic */ GestureCropImageView access$500(UCropActivity uCropActivity) {
        return uCropActivity.mGestureCropImageView;
    }

    static /* synthetic */ List access$600(UCropActivity uCropActivity) {
        return uCropActivity.mCropAspectRatioViews;
    }

    static /* synthetic */ void access$700(UCropActivity uCropActivity) {
        uCropActivity.resetRotation();
    }

    static /* synthetic */ void access$800(UCropActivity uCropActivity, int n) {
        uCropActivity.rotateByAngle(n);
    }

    static /* synthetic */ void access$900(UCropActivity uCropActivity, int n) {
        uCropActivity.setWidgetState(n);
    }

    private void changeSelectedTab(int n) {
        TransitionManager.beginDelayedTransition((ViewGroup)((ViewGroup)this.findViewById(R.id.ucrop_photobox)), (Transition)this.mControlsTransition);
        View view = this.mWrapperStateScale.findViewById(R.id.text_view_scale);
        int n2 = R.id.state_scale;
        int n3 = 0;
        n2 = n == n2 ? 0 : 8;
        view.setVisibility(n2);
        view = this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop);
        n2 = n == R.id.state_aspect_ratio ? 0 : 8;
        view.setVisibility(n2);
        view = this.mWrapperStateRotate.findViewById(R.id.text_view_rotate);
        n = n == R.id.state_rotate ? n3 : 8;
        view.setVisibility(n);
    }

    private void getCustomOptionsData(Intent intent) {
        int n;
        this.isOpenWhiteStatusBar = intent.getBooleanExtra("com.yalantis.ucrop.openWhiteStatusBar", false);
        this.mStatusBarColor = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_statusbar));
        this.mToolbarColor = n = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_toolbar));
        if (n == 0) {
            this.mToolbarColor = ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_toolbar);
        }
        if (this.mStatusBarColor != 0) return;
        this.mStatusBarColor = ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_statusbar);
    }

    private void initiateRootViews() {
        UCropView uCropView;
        this.uCropPhotoBox = (RelativeLayout)this.findViewById(R.id.ucrop_photobox);
        this.mUCropView = uCropView = (UCropView)this.findViewById(R.id.ucrop);
        this.mGestureCropImageView = uCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView)this.findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        this.findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
    }

    private boolean isOnTouch() {
        Uri uri = (Uri)this.getIntent().getParcelableExtra("com.yalantis.ucrop.InputUri");
        if (uri != null) return this.isOnTouch(uri);
        return true;
    }

    private boolean isOnTouch(Uri uri) {
        String string;
        if (uri == null) {
            return true;
        }
        if (PictureMimeType.isHasHttp((String)uri.toString())) {
            return PictureMimeType.isGifForSuffix((String)PictureMimeType.getLastImgType((String)uri.toString())) ^ true;
        }
        String string2 = string = PictureMimeType.getMimeTypeFromMediaContentUri((Context)this, (Uri)uri);
        if (!string.endsWith("image/*")) return PictureMimeType.isGif((String)string2) ^ true;
        string2 = PictureMimeType.getImageMimeType((String)FileUtils.getPath((Context)this, (Uri)uri));
        return PictureMimeType.isGif((String)string2) ^ true;
    }

    private void processOptions(Intent intent) {
        Object object = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        object = !TextUtils.isEmpty((CharSequence)object) ? Bitmap.CompressFormat.valueOf((String)object) : null;
        String string = object;
        if (object == null) {
            string = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = string;
        this.mCompressQuality = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        this.mOverlayView.setDimmedBorderColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerBorderColor", this.getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.isDragFrame = intent.getBooleanExtra("com.yalantis.ucrop.DragCropFrame", true);
        this.mOverlayView.setDimmedStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CircleStrokeWidth", 1));
        this.isScaleEnabled = intent.getBooleanExtra("com.yalantis.ucrop.scale", true);
        this.isRotateEnabled = intent.getBooleanExtra("com.yalantis.ucrop.rotate", true);
        object = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (object != null && ((Object)object).length == 3) {
            this.mAllowedGestures = (int[])object;
        }
        this.mGestureCropImageView.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration((long)intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.mOverlayView.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.mOverlayView.setDragFrame(this.isDragFrame);
        this.mOverlayView.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", this.getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.mOverlayView.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.mOverlayView.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", this.getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.mOverlayView.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.mOverlayView.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.mOverlayView.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", this.getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float f2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int n = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        object = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (f > 0.0f && f2 > 0.0f) {
            object = this.mWrapperStateAspectRatio;
            if (object != null) {
                object.setVisibility(8);
            }
            this.mGestureCropImageView.setTargetAspectRatio(f / f2);
        } else if (object != null && n < ((ArrayList)object).size()) {
            this.mGestureCropImageView.setTargetAspectRatio(((AspectRatio)((ArrayList)object).get(n)).getAspectRatioX() / ((AspectRatio)((ArrayList)object).get(n)).getAspectRatioY());
        } else {
            this.mGestureCropImageView.setTargetAspectRatio(0.0f);
        }
        int n2 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        n = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (n2 <= 0) return;
        if (n <= 0) return;
        this.mGestureCropImageView.setMaxResultImageSizeX(n2);
        this.mGestureCropImageView.setMaxResultImageSizeY(n);
    }

    private void resetRotation() {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void rotateByAngle(int n) {
        this.mGestureCropImageView.postRotate((float)n);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void setAllowedGestures(int n) {
        boolean bl;
        GestureCropImageView gestureCropImageView;
        block4: {
            block2: {
                block3: {
                    int[] nArray;
                    if (!this.isOnTouch()) return;
                    gestureCropImageView = this.mGestureCropImageView;
                    bl = this.isScaleEnabled;
                    boolean bl2 = false;
                    bl = bl && this.mShowBottomControls ? (nArray = this.mAllowedGestures)[n] == 3 || nArray[n] == 1 : this.isScaleEnabled;
                    gestureCropImageView.setScaleEnabled(bl);
                    gestureCropImageView = this.mGestureCropImageView;
                    if (!this.isRotateEnabled || !this.mShowBottomControls) break block2;
                    nArray = this.mAllowedGestures;
                    if (nArray[n] == 3) break block3;
                    bl = bl2;
                    if (nArray[n] != 2) break block4;
                }
                bl = true;
                break block4;
            }
            bl = this.isRotateEnabled;
        }
        gestureCropImageView.setRotateEnabled(bl);
    }

    private void setAngleText(float f) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView == null) return;
        textView.setText((CharSequence)String.format(Locale.getDefault(), "%.1f\u00b0", Float.valueOf(f)));
    }

    private void setNavBar() {
        if (Build.VERSION.SDK_INT < 21) return;
        int n = this.getIntent().getIntExtra("com.yalantis.ucrop.navBarColor", 0);
        if (n == 0) return;
        this.getWindow().setNavigationBarColor(n);
    }

    private void setScaleText(float f) {
        TextView textView = this.mTextViewScalePercent;
        if (textView == null) return;
        textView.setText((CharSequence)String.format(Locale.getDefault(), "%d%%", (int)(f * 100.0f)));
    }

    private void setStatusBarColor(int n) {
        if (Build.VERSION.SDK_INT < 21) return;
        Window window = this.getWindow();
        if (window == null) return;
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(n);
    }

    private void setWidgetState(int n) {
        if (!this.mShowBottomControls) {
            return;
        }
        ViewGroup viewGroup = this.mWrapperStateAspectRatio;
        boolean bl = n == R.id.state_aspect_ratio;
        viewGroup.setSelected(bl);
        viewGroup = this.mWrapperStateRotate;
        bl = n == R.id.state_rotate;
        viewGroup.setSelected(bl);
        viewGroup = this.mWrapperStateScale;
        bl = n == R.id.state_scale;
        viewGroup.setSelected(bl);
        viewGroup = this.mLayoutAspectRatio;
        int n2 = R.id.state_aspect_ratio;
        int n3 = 8;
        n2 = n == n2 ? 0 : 8;
        viewGroup.setVisibility(n2);
        viewGroup = this.mLayoutRotate;
        n2 = n == R.id.state_rotate ? 0 : 8;
        viewGroup.setVisibility(n2);
        viewGroup = this.mLayoutScale;
        n2 = n3;
        if (n == R.id.state_scale) {
            n2 = 0;
        }
        viewGroup.setVisibility(n2);
        this.changeSelectedTab(n);
        if (n == R.id.state_scale) {
            this.setAllowedGestures(0);
        } else if (n == R.id.state_rotate) {
            this.setAllowedGestures(1);
        } else {
            this.setAllowedGestures(2);
        }
    }

    private void setupAppBar() {
        this.setStatusBarColor(this.mStatusBarColor);
        Toolbar toolbar = (Toolbar)this.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.mToolbarColor);
        toolbar.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView)toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText((CharSequence)this.mToolbarTitle);
        textView = AppCompatResources.getDrawable((Context)this, (int)this.mToolbarCancelDrawable).mutate();
        textView.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)this.mToolbarWidgetColor, (BlendModeCompat)BlendModeCompat.SRC_ATOP));
        toolbar.setNavigationIcon((Drawable)textView);
        this.setSupportActionBar(toolbar);
        toolbar = this.getSupportActionBar();
        if (toolbar == null) return;
        toolbar.setDisplayShowTitleEnabled(false);
    }

    private void setupAspectRatioWidget(Intent object) {
        ArrayList arrayList;
        int n;
        block7: {
            block6: {
                n = object.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
                arrayList = object.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
                if (arrayList == null) break block6;
                object = arrayList;
                if (!arrayList.isEmpty()) break block7;
            }
            n = 2;
            object = new ArrayList();
            ((ArrayList)object).add(new AspectRatio(null, 1.0f, 1.0f));
            ((ArrayList)object).add(new AspectRatio(null, 3.0f, 4.0f));
            ((ArrayList)object).add(new AspectRatio(this.getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            ((ArrayList)object).add(new AspectRatio(null, 3.0f, 2.0f));
            ((ArrayList)object).add(new AspectRatio(null, 16.0f, 9.0f));
        }
        arrayList = (LinearLayout)this.findViewById(R.id.layout_aspect_ratio);
        int n2 = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        if (this.getCurrentActivity() instanceof PictureMultiCuttingActivity) {
            this.mAspectRatioTextViews = new ArrayList<AspectRatioTextView>();
            this.mCropAspectRatioViews = new ArrayList<ViewGroup>();
        }
        Iterator iterator = ((ArrayList)object).iterator();
        while (iterator.hasNext()) {
            object = (AspectRatio)iterator.next();
            FrameLayout frameLayout = (FrameLayout)this.getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, null);
            frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView)frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio((AspectRatio)object);
            this.mAspectRatioTextViews.add(aspectRatioTextView);
            arrayList.addView((View)frameLayout);
            this.mCropAspectRatioViews.add((ViewGroup)frameLayout);
        }
        this.mCropAspectRatioViews.get(n).setSelected(true);
        object = this.mCropAspectRatioViews.iterator();
        n = n2;
        while (object.hasNext()) {
            arrayList = (ViewGroup)object.next();
            arrayList.setTag(++n);
            arrayList.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    private void setupRotateWidget() {
        this.mTextViewRotateAngle = (TextView)this.findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView)this.findViewById(R.id.rotate_scroll_wheel)).setScrollingListener((HorizontalProgressWheelView.ScrollingListener)new /* Unavailable Anonymous Inner Class!! */);
        ((HorizontalProgressWheelView)this.findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
        this.findViewById(R.id.wrapper_reset_rotate).setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void setupScaleWidget() {
        this.mTextViewScalePercent = (TextView)this.findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView)this.findViewById(R.id.scale_scroll_wheel)).setScrollingListener((HorizontalProgressWheelView.ScrollingListener)new /* Unavailable Anonymous Inner Class!! */);
        ((HorizontalProgressWheelView)this.findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
    }

    private void setupStatesWrapper() {
        ImageView imageView = (ImageView)this.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView)this.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView)this.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable((Drawable)new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable((Drawable)new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable((Drawable)new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    protected void addBlockingView() {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View((Context)this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.mBlockingView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout)this.findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    protected void closeActivity() {
        this.finish();
        this.exitAnimation();
    }

    protected void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.mShowLoader = true;
        this.supportInvalidateOptionsMenu();
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, (BitmapCropCallback)new /* Unavailable Anonymous Inner Class!! */);
    }

    protected void exitAnimation() {
        int n = this.getIntent().getIntExtra("com.yalantis.ucrop.WindowAnimation", 0);
        int n2 = R.anim.ucrop_anim_fade_in;
        if (n == 0) {
            n = R.anim.ucrop_close;
        }
        this.overridePendingTransition(n2, n);
    }

    protected Activity getCurrentActivity() {
        return this;
    }

    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23((AppCompatActivity)this, (int)this.mStatusBarColor, (int)this.mToolbarColor, (boolean)this.isOpenWhiteStatusBar);
    }

    public boolean isImmersive() {
        return true;
    }

    public void onBackPressed() {
        this.closeActivity();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = this.getIntent();
        this.setNewRequestedOrientation((Intent)bundle);
        this.getCustomOptionsData((Intent)bundle);
        if (this.isImmersive()) {
            this.immersive();
        }
        this.setContentView(R.layout.ucrop_activity_photobox);
        this.mScreenWidth = ScreenUtils.getScreenWidth((Context)this);
        this.setupViews((Intent)bundle);
        this.setNavBar();
        this.setImageData((Intent)bundle);
        this.setInitialState();
        this.addBlockingView();
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        this.getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu2);
        MenuItem menuItem = menu2.findItem(R.id.menu_loader);
        Drawable drawable = menuItem.getIcon();
        if (drawable != null) {
            try {
                drawable.mutate();
                drawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)this.mToolbarWidgetColor, (BlendModeCompat)BlendModeCompat.SRC_ATOP));
                menuItem.setIcon(drawable);
            }
            catch (IllegalStateException illegalStateException) {
                Log.i((String)TAG, (String)String.format("%s - %s", illegalStateException.getMessage(), "\u5fc5\u9808\u6307\u5b9a\u8f38\u5165\u4ee5\u53ca\u8f38\u51fa\u7684 Uri"));
            }
            ((Animatable)menuItem.getIcon()).start();
        }
        menuItem = menu2.findItem(R.id.menu_crop);
        menu2 = ContextCompat.getDrawable((Context)this, (int)this.mToolbarCropDrawable);
        if (menu2 == null) return true;
        menu2.mutate();
        menu2.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)this.mToolbarWidgetColor, (BlendModeCompat)BlendModeCompat.SRC_ATOP));
        menuItem.setIcon((Drawable)menu2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            this.cropAndSaveImage();
            return true;
        }
        if (menuItem.getItemId() != 16908332) return super.onOptionsItemSelected(menuItem);
        this.onBackPressed();
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu2) {
        menu2.findItem(R.id.menu_crop).setVisible(this.mShowLoader ^ true);
        menu2.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu2);
    }

    protected void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        if (gestureCropImageView == null) return;
        gestureCropImageView.cancelAllAnimations();
    }

    protected void setImageData(Intent intent) {
        Uri uri = (Uri)intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri)intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        this.processOptions(intent);
        if (uri != null && uri2 != null) {
            try {
                boolean bl = this.isOnTouch(uri);
                intent = this.mGestureCropImageView;
                boolean bl2 = bl ? this.isRotateEnabled : bl;
                intent.setRotateEnabled(bl2);
                intent = this.mGestureCropImageView;
                bl2 = bl;
                if (bl) {
                    bl2 = this.isScaleEnabled;
                }
                intent.setScaleEnabled(bl2);
                this.mGestureCropImageView.setImageUri(uri, uri2);
            }
            catch (Exception exception) {
                this.setResultError(exception);
                this.onBackPressed();
            }
        } else {
            this.setResultError(new NullPointerException("\u5728\u4f60\u7684 App \u5167\u590d\u5199\u989c\u8272\u8d44\u6e90 (ucrop_color_toolbar_widget) \u4f7f 5.0 \u4ee5\u524d\u88dd\u7f6e\u6b63\u5e38\u8fd0\u4f5c"));
            this.onBackPressed();
        }
    }

    protected void setInitialState() {
        if (this.mShowBottomControls) {
            if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
                this.setWidgetState(R.id.state_aspect_ratio);
            } else {
                this.setWidgetState(R.id.state_scale);
            }
        } else {
            this.setAllowedGestures(0);
        }
    }

    protected void setNewRequestedOrientation(Intent intent) {
        int n = intent.getIntExtra("com.yalantis.ucrop.activityOrientation", -1);
        if (this.getRequestedOrientation() == n) return;
        this.setRequestedOrientation(n);
    }

    protected void setResultError(Throwable throwable) {
        this.setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", (Serializable)throwable));
    }

    protected void setResultUri(Uri uri, float f, int n, int n2, int n3, int n4) {
        this.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", (Parcelable)uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f).putExtra("com.yalantis.ucrop.ImageWidth", n3).putExtra("com.yalantis.ucrop.ImageHeight", n4).putExtra("com.yalantis.ucrop.OffsetX", n).putExtra("com.yalantis.ucrop.OffsetY", n2));
    }

    protected void setupViews(Intent intent) {
        String string2;
        this.mStatusBarColor = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_toolbar));
        this.mActiveWidgetColor = intent.getIntExtra("com.yalantis.ucrop.UcropColorWidgetActive", ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_widget_background));
        this.mActiveControlsWidgetColor = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_active_controls_color));
        this.mToolbarWidgetColor = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R.drawable.ucrop_ic_done);
        this.mToolbarTitle = string2 = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        if (string2 == null) {
            string2 = this.getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = string2;
        this.mLogoColor = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_default_logo));
        this.mShowBottomControls = intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false) ^ true;
        this.mRootViewBackgroundColor = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_crop_background));
        this.setupAppBar();
        this.initiateRootViews();
        if (!this.mShowBottomControls) return;
        string2 = (ViewGroup)((ViewGroup)this.findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
        string2.setVisibility(0);
        string2.setBackgroundColor(this.mRootViewBackgroundColor);
        LayoutInflater.from((Context)this).inflate(R.layout.ucrop_controls, (ViewGroup)string2, true);
        string2 = new AutoTransition();
        this.mControlsTransition = string2;
        string2.setDuration(50L);
        string2 = (ViewGroup)this.findViewById(R.id.state_aspect_ratio);
        this.mWrapperStateAspectRatio = string2;
        string2.setOnClickListener(this.mStateClickListener);
        string2 = (ViewGroup)this.findViewById(R.id.state_rotate);
        this.mWrapperStateRotate = string2;
        string2.setOnClickListener(this.mStateClickListener);
        string2 = (ViewGroup)this.findViewById(R.id.state_scale);
        this.mWrapperStateScale = string2;
        string2.setOnClickListener(this.mStateClickListener);
        this.mLayoutAspectRatio = (ViewGroup)this.findViewById(R.id.layout_aspect_ratio);
        this.mLayoutRotate = (ViewGroup)this.findViewById(R.id.layout_rotate_wheel);
        this.mLayoutScale = (ViewGroup)this.findViewById(R.id.layout_scale_wheel);
        this.setupAspectRatioWidget(intent);
        this.setupRotateWidget();
        this.setupScaleWidget();
        this.setupStatesWrapper();
    }
}
