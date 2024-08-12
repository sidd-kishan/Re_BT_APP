/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.PointF
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.viewpager.widget.PagerAdapter
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.adapter.PictureSimpleFragmentAdapter$OnCallBackActivity
 *  com.luck.picture.lib.adapter._$$Lambda$PictureSimpleFragmentAdapter$4HVDQawmiVUAtZ4L4JYHeoEXvGA
 *  com.luck.picture.lib.adapter._$$Lambda$PictureSimpleFragmentAdapter$jOAy78BrzyzVndqdSRdbxSRByFk
 *  com.luck.picture.lib.adapter._$$Lambda$PictureSimpleFragmentAdapter$sSulm_6kVTXvp8hx_1AdIXwIEVE
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.photoview.OnViewTapListener
 *  com.luck.picture.lib.photoview.PhotoView
 *  com.luck.picture.lib.tools.JumpUtils
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.widget.longimage.ImageSource
 *  com.luck.picture.lib.widget.longimage.ImageViewState
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 */
package com.luck.picture.lib.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureSimpleFragmentAdapter;
import com.luck.picture.lib.adapter._$;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PictureSimpleFragmentAdapter
extends PagerAdapter {
    private static final int MAX_CACHE_SIZE = 20;
    private final PictureSelectionConfig config;
    private List<LocalMedia> data;
    private SparseArray<View> mCacheView;
    private final OnCallBackActivity onBackPressed;

    public PictureSimpleFragmentAdapter(PictureSelectionConfig pictureSelectionConfig, OnCallBackActivity onCallBackActivity) {
        this.config = pictureSelectionConfig;
        this.onBackPressed = onCallBackActivity;
        this.mCacheView = new SparseArray();
    }

    private void displayLongPic(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(ImageSource.uri((Uri)uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    static /* synthetic */ void lambda$instantiateItem$0(LocalMedia localMedia, String string, ViewGroup viewGroup, View view) {
        if (PictureSelectionConfig.customVideoPlayCallback != null) {
            PictureSelectionConfig.customVideoPlayCallback.startPlayVideo((Object)localMedia);
        } else {
            view = new Intent();
            localMedia = new Bundle();
            localMedia.putBoolean("isExternalPreviewVideo", true);
            localMedia.putString("videoPath", string);
            view.putExtras((Bundle)localMedia);
            JumpUtils.startPictureVideoPlayActivity((Context)viewGroup.getContext(), (Bundle)localMedia, (int)166);
        }
    }

    public void bindData(List<LocalMedia> list) {
        this.data = list;
    }

    public void clear() {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray == null) return;
        sparseArray.clear();
        this.mCacheView = null;
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        viewGroup.removeView((View)object);
        if (this.mCacheView.size() <= 20) return;
        this.mCacheView.remove(n);
    }

    public int getCount() {
        List<LocalMedia> list = this.data;
        int n = list != null ? list.size() : 0;
        return n;
    }

    public List<LocalMedia> getData() {
        List<LocalMedia> list;
        List<LocalMedia> list2 = list = this.data;
        if (list != null) return list2;
        list2 = new ArrayList<LocalMedia>();
        return list2;
    }

    public LocalMedia getItem(int n) {
        LocalMedia localMedia = this.getSize() > 0 && n < this.getSize() ? this.data.get(n) : null;
        return localMedia;
    }

    public int getItemPosition(Object object) {
        return -2;
    }

    public int getSize() {
        List<LocalMedia> list = this.data;
        int n = list == null ? 0 : list.size();
        return n;
    }

    public Object instantiateItem(ViewGroup viewGroup, int n) {
        Object object;
        View view = object = (View)this.mCacheView.get(n);
        if (object == null) {
            view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(R.layout.picture_image_preview, viewGroup, false);
            this.mCacheView.put(n, (Object)view);
        }
        PhotoView photoView = (PhotoView)view.findViewById(R.id.preview_image);
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView)view.findViewById(R.id.longImg);
        ImageView imageView = (ImageView)view.findViewById(R.id.iv_play);
        LocalMedia localMedia = this.getItem(n);
        if (localMedia != null) {
            String string = localMedia.getMimeType();
            object = localMedia.isCut() && !localMedia.isCompressed() ? localMedia.getCutPath() : (!(localMedia.isCompressed() || localMedia.isCut() && localMedia.isCompressed()) ? localMedia.getPath() : localMedia.getCompressPath());
            boolean bl = PictureMimeType.isGif((String)string);
            boolean bl2 = PictureMimeType.isHasVideo((String)string);
            int n2 = 8;
            n = bl2 ? 0 : 8;
            imageView.setVisibility(n);
            imageView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureSimpleFragmentAdapter.jOAy78BrzyzVndqdSRdbxSRByFk(localMedia, (String)object, viewGroup));
            bl2 = MediaUtils.isLongImg((LocalMedia)localMedia);
            n = bl2 && !bl ? 8 : 0;
            photoView.setVisibility(n);
            photoView.setOnViewTapListener((OnViewTapListener)new _$.Lambda.PictureSimpleFragmentAdapter.sSulm_6kVTXvp8hx_1AdIXwIEVE(this));
            n = n2;
            if (bl2) {
                n = n2;
                if (!bl) {
                    n = 0;
                }
            }
            subsamplingScaleImageView.setVisibility(n);
            subsamplingScaleImageView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureSimpleFragmentAdapter.4HVDQawmiVUAtZ4L4JYHeoEXvGA(this));
            if (bl && !localMedia.isCompressed()) {
                if (this.config != null && PictureSelectionConfig.imageEngine != null) {
                    PictureSelectionConfig.imageEngine.loadAsGifImage(view.getContext(), (String)object, (ImageView)photoView);
                }
            } else if (this.config != null && PictureSelectionConfig.imageEngine != null) {
                if (bl2) {
                    object = PictureMimeType.isContent((String)object) ? Uri.parse((String)object) : Uri.fromFile((File)new File((String)object));
                    this.displayLongPic((Uri)object, subsamplingScaleImageView);
                } else {
                    PictureSelectionConfig.imageEngine.loadImage(view.getContext(), (String)object, (ImageView)photoView);
                }
            }
        }
        viewGroup.addView(view, 0);
        return view;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean bl = view == object;
        return bl;
    }

    public /* synthetic */ void lambda$instantiateItem$1$PictureSimpleFragmentAdapter(View view, float f, float f2) {
        view = this.onBackPressed;
        if (view == null) return;
        view.onActivityBackPressed();
    }

    public /* synthetic */ void lambda$instantiateItem$2$PictureSimpleFragmentAdapter(View view) {
        view = this.onBackPressed;
        if (view == null) return;
        view.onActivityBackPressed();
    }

    public void remove(int n) {
        if (this.getSize() <= n) return;
        this.data.remove(n);
    }

    public void removeCacheView(int n) {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray == null) return;
        if (n >= sparseArray.size()) return;
        this.mCacheView.removeAt(n);
    }
}
