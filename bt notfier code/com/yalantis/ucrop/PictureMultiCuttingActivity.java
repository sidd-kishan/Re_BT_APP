/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.AnimationUtils
 *  android.view.animation.LayoutAnimationController
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  androidx.core.content.ContextCompat
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.SimpleItemAnimator
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.ScreenUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.yalantis.ucrop.PicturePhotoGalleryAdapter
 *  com.yalantis.ucrop.PicturePhotoGalleryAdapter$OnItemClickListener
 *  com.yalantis.ucrop.UCropActivity
 *  com.yalantis.ucrop.util.FileUtils
 */
package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.yalantis.ucrop.PicturePhotoGalleryAdapter;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class PictureMultiCuttingActivity
extends UCropActivity {
    private static final int MIN_NUM = 1;
    private int cutIndex;
    private boolean isAnimation;
    private boolean isCamera;
    private boolean isWithVideoImage;
    private final ArrayList<LocalMedia> list = new ArrayList();
    private PicturePhotoGalleryAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private int oldCutIndex;
    private String renameCropFilename;

    static /* synthetic */ ArrayList access$000(PictureMultiCuttingActivity pictureMultiCuttingActivity) {
        return pictureMultiCuttingActivity.list;
    }

    static /* synthetic */ int access$100(PictureMultiCuttingActivity pictureMultiCuttingActivity) {
        return pictureMultiCuttingActivity.cutIndex;
    }

    static /* synthetic */ int access$102(PictureMultiCuttingActivity pictureMultiCuttingActivity, int n) {
        pictureMultiCuttingActivity.cutIndex = n;
        return n;
    }

    static /* synthetic */ void access$200(PictureMultiCuttingActivity pictureMultiCuttingActivity) {
        pictureMultiCuttingActivity.resetLastCropStatus();
    }

    static /* synthetic */ int access$302(PictureMultiCuttingActivity pictureMultiCuttingActivity, int n) {
        pictureMultiCuttingActivity.oldCutIndex = n;
        return n;
    }

    private void addPhotoRecyclerView() {
        RecyclerView recyclerView;
        boolean bl = this.getIntent().getBooleanExtra("com.yalantis.ucrop.skip_multiple_crop", true);
        this.mRecyclerView = recyclerView = new RecyclerView((Context)this);
        recyclerView.setId(R.id.id_recycler);
        this.mRecyclerView.setBackgroundColor(ContextCompat.getColor((Context)this, (int)R.color.ucrop_color_widget_background));
        recyclerView = new RelativeLayout.LayoutParams(-1, ScreenUtils.dip2px((Context)this, (float)80.0f));
        this.mRecyclerView.setLayoutParams((ViewGroup.LayoutParams)recyclerView);
        recyclerView = new LinearLayoutManager((Context)this);
        recyclerView.setOrientation(0);
        if (this.isAnimation) {
            LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation((Context)this.getApplicationContext(), (int)R.anim.ucrop_layout_animation_fall_down);
            this.mRecyclerView.setLayoutAnimation(layoutAnimationController);
        }
        this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)recyclerView);
        ((SimpleItemAnimator)Objects.requireNonNull(this.mRecyclerView.getItemAnimator())).setSupportsChangeAnimations(false);
        this.resetCutDataStatus();
        this.list.get(this.cutIndex).setCut(true);
        recyclerView = new PicturePhotoGalleryAdapter(this.list);
        this.mAdapter = recyclerView;
        this.mRecyclerView.setAdapter((RecyclerView.Adapter)recyclerView);
        if (bl) {
            this.mAdapter.setOnItemClickListener((PicturePhotoGalleryAdapter.OnItemClickListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        this.uCropPhotoBox.addView((View)this.mRecyclerView);
        this.changeLayoutParams(this.mShowBottomControls);
        ((RelativeLayout.LayoutParams)((FrameLayout)this.findViewById(R.id.ucrop_frame)).getLayoutParams()).addRule(2, R.id.id_recycler);
        ((RelativeLayout.LayoutParams)this.mRecyclerView.getLayoutParams()).addRule(2, R.id.controls_wrapper);
    }

    private void changeLayoutParams(boolean bl) {
        if (this.mRecyclerView.getLayoutParams() == null) {
            return;
        }
        if (bl) {
            ((RelativeLayout.LayoutParams)this.mRecyclerView.getLayoutParams()).addRule(12, 0);
            ((RelativeLayout.LayoutParams)this.mRecyclerView.getLayoutParams()).addRule(2, R.id.wrapper_controls);
        } else {
            ((RelativeLayout.LayoutParams)this.mRecyclerView.getLayoutParams()).addRule(12);
            ((RelativeLayout.LayoutParams)this.mRecyclerView.getLayoutParams()).addRule(2, 0);
        }
    }

    private void getIndex(int n) {
        int n2 = 0;
        while (n2 < n) {
            LocalMedia localMedia = this.list.get(n2);
            if (localMedia != null && PictureMimeType.isHasImage((String)localMedia.getMimeType())) {
                this.cutIndex = n2;
                return;
            }
            ++n2;
        }
    }

    private void initLoadCutData() {
        ArrayList<LocalMedia> arrayList = this.list;
        if (arrayList != null && arrayList.size() != 0) {
            int n = this.list.size();
            if (!this.isWithVideoImage) return;
            this.getIndex(n);
            return;
        }
        this.onBackPressed();
    }

    private void refreshPhotoRecyclerData() {
        this.resetCutDataStatus();
        this.list.get(this.cutIndex).setCut(true);
        this.mAdapter.notifyItemChanged(this.cutIndex);
        this.uCropPhotoBox.addView((View)this.mRecyclerView);
        this.changeLayoutParams(this.mShowBottomControls);
        ((RelativeLayout.LayoutParams)((FrameLayout)this.findViewById(R.id.ucrop_frame)).getLayoutParams()).addRule(2, R.id.id_recycler);
        ((RelativeLayout.LayoutParams)this.mRecyclerView.getLayoutParams()).addRule(2, R.id.controls_wrapper);
    }

    private void resetCutDataStatus() {
        int n = this.list.size();
        int n2 = 0;
        while (n2 < n) {
            this.list.get(n2).setCut(false);
            ++n2;
        }
    }

    private void resetLastCropStatus() {
        int n = this.list.size();
        if (n <= 1) return;
        int n2 = this.oldCutIndex;
        if (n <= n2) return;
        this.list.get(n2).setCut(false);
        this.mAdapter.notifyItemChanged(this.cutIndex);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.getIntent();
        this.renameCropFilename = object.getStringExtra("com.yalantis.ucrop.RenameCropFileName");
        this.isCamera = object.getBooleanExtra("com.yalantis.ucrop.isCamera", false);
        this.isWithVideoImage = object.getBooleanExtra("com.yalantis.ucrop.isWithVideoImage", false);
        object = this.getIntent().getParcelableArrayListExtra("com.yalantis.ucrop.cuts");
        this.isAnimation = this.getIntent().getBooleanExtra(".isMultipleAnimation", true);
        if (object != null && object.size() != 0) {
            this.list.addAll((Collection<LocalMedia>)object);
            if (this.list.size() <= 1) return;
            this.initLoadCutData();
            this.addPhotoRecyclerView();
            return;
        }
        this.onBackPressed();
    }

    protected void onDestroy() {
        PicturePhotoGalleryAdapter picturePhotoGalleryAdapter = this.mAdapter;
        if (picturePhotoGalleryAdapter != null) {
            picturePhotoGalleryAdapter.setOnItemClickListener(null);
        }
        super.onDestroy();
    }

    protected void resetCutData() {
        this.uCropPhotoBox.removeView((View)this.mRecyclerView);
        if (this.mBlockingView != null) {
            this.uCropPhotoBox.removeView(this.mBlockingView);
        }
        this.setContentView(R.layout.ucrop_activity_photobox);
        this.uCropPhotoBox = (RelativeLayout)this.findViewById(R.id.ucrop_photobox);
        this.addBlockingView();
        Intent intent = this.getIntent();
        Object object = intent.getExtras();
        Bundle bundle = object;
        if (object == null) {
            bundle = new Bundle();
        }
        LocalMedia localMedia = this.list.get(this.cutIndex);
        Object object2 = localMedia.getPath();
        boolean bl = PictureMimeType.isHasHttp((String)object2);
        object = PictureMimeType.isContent((String)object2) ? FileUtils.getPath((Context)this, (Uri)Uri.parse((String)object2)) : object2;
        String string = PictureMimeType.getLastImgType((String)object);
        object = !TextUtils.isEmpty((CharSequence)localMedia.getAndroidQToPath()) ? Uri.fromFile((File)new File(localMedia.getAndroidQToPath())) : (!bl && !PictureMimeType.isContent((String)object2) ? Uri.fromFile((File)new File((String)object2)) : Uri.parse((String)object2));
        bundle.putParcelable("com.yalantis.ucrop.InputUri", (Parcelable)object);
        object2 = Environment.getExternalStorageState().equals("mounted") ? this.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : this.getCacheDir();
        if (TextUtils.isEmpty((CharSequence)this.renameCropFilename)) {
            object = new StringBuilder();
            ((StringBuilder)object).append(DateUtils.getCreateFileName((String)"IMG_CROP_"));
            ((StringBuilder)object).append(string);
            object = ((StringBuilder)object).toString();
        } else {
            object = this.isCamera ? this.renameCropFilename : FileUtils.rename((String)this.renameCropFilename);
        }
        bundle.putParcelable("com.yalantis.ucrop.OutputUri", (Parcelable)Uri.fromFile((File)new File((File)object2, (String)object)));
        intent.putExtras(bundle);
        this.setupViews(intent);
        this.refreshPhotoRecyclerData();
        this.setImageData(intent);
        this.setInitialState();
        double d = this.cutIndex * ScreenUtils.dip2px((Context)this, (float)60.0f);
        double d2 = this.mScreenWidth;
        Double.isNaN(d2);
        if (d > d2 * 0.8) {
            this.mRecyclerView.scrollBy(ScreenUtils.dip2px((Context)this, (float)60.0f), 0);
        } else {
            d2 = this.mScreenWidth;
            Double.isNaN(d2);
            if (!(d < d2 * 0.4)) return;
            this.mRecyclerView.scrollBy(ScreenUtils.dip2px((Context)this, (float)-60.0f), 0);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected void setResultUri(Uri object, float f, int n, int n2, int n3, int n4) {
        try {
            long l;
            if (this.list.size() < this.cutIndex) {
                this.onBackPressed();
                return;
            }
            LocalMedia localMedia = this.list.get(this.cutIndex);
            localMedia.setCutPath(object.getPath());
            localMedia.setCut(true);
            localMedia.setCropResultAspectRatio(f);
            localMedia.setCropOffsetX(n);
            localMedia.setCropOffsetY(n2);
            localMedia.setCropImageWidth(n3);
            localMedia.setCropImageHeight(n4);
            object = SdkVersionUtils.checkedAndroid_Q() ? localMedia.getCutPath() : localMedia.getAndroidQToPath();
            localMedia.setAndroidQToPath((String)object);
            if (!TextUtils.isEmpty((CharSequence)localMedia.getCutPath())) {
                object = new File(localMedia.getCutPath());
                l = ((File)object).length();
            } else {
                l = localMedia.getSize();
            }
            localMedia.setSize(l);
            this.resetLastCropStatus();
            this.cutIndex = n = this.cutIndex + 1;
            if (this.isWithVideoImage && n < this.list.size() && PictureMimeType.isHasVideo((String)this.list.get(this.cutIndex).getMimeType())) {
                while (this.cutIndex < this.list.size() && !PictureMimeType.isHasImage((String)this.list.get(this.cutIndex).getMimeType())) {
                    ++this.cutIndex;
                }
            }
            this.oldCutIndex = this.cutIndex;
            if (this.cutIndex >= this.list.size()) {
            } else {
                this.resetCutData();
                return;
            }
            for (n = 0; n < this.list.size(); ++n) {
                object = this.list.get(n);
                boolean bl = !TextUtils.isEmpty((CharSequence)object.getCutPath());
                object.setCut(bl);
            }
            object = new Intent();
            this.setResult(-1, object.putExtra("com.yalantis.ucrop.OutputUriList", this.list));
            this.onBackPressed();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
