/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.viewpager.widget.PagerAdapter
 *  com.luck.picture.lib.PictureExternalPreviewActivity
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib._$$Lambda$PictureExternalPreviewActivity$SimpleFragmentAdapter$MkgowPnHjx5ddrfk7AJgghO8nPg
 *  com.luck.picture.lib._$$Lambda$PictureExternalPreviewActivity$SimpleFragmentAdapter$QMCBWC0MjLmlbl_DaCykGwK77ig
 *  com.luck.picture.lib._$$Lambda$PictureExternalPreviewActivity$SimpleFragmentAdapter$Vh8dP81InQbUnCEQTLMc1EPqBeg
 *  com.luck.picture.lib._$$Lambda$PictureExternalPreviewActivity$SimpleFragmentAdapter$gbfEqjnU6VMmqfOcy1gUV8H5Krk
 *  com.luck.picture.lib._$$Lambda$PictureExternalPreviewActivity$SimpleFragmentAdapter$hQuFHKZ29WMgEDMtIIQdIxQX2to
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.listener.OnImageCompleteCallback
 *  com.luck.picture.lib.permissions.PermissionChecker
 *  com.luck.picture.lib.photoview.OnViewTapListener
 *  com.luck.picture.lib.photoview.PhotoView
 *  com.luck.picture.lib.tools.JumpUtils
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 */
package com.luck.picture.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.File;

/*
 * Exception performing whole class analysis ignored.
 */
public class PictureExternalPreviewActivity.SimpleFragmentAdapter
extends PagerAdapter {
    private static final int MAX_CACHE_SIZE = 20;
    private SparseArray<View> mCacheView;
    final PictureExternalPreviewActivity this$0;

    public PictureExternalPreviewActivity.SimpleFragmentAdapter(PictureExternalPreviewActivity pictureExternalPreviewActivity) {
        this.this$0 = pictureExternalPreviewActivity;
        this.mCacheView = new SparseArray();
    }

    static /* synthetic */ void access$900(PictureExternalPreviewActivity.SimpleFragmentAdapter simpleFragmentAdapter) {
        simpleFragmentAdapter.clear();
    }

    private void clear() {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray == null) return;
        sparseArray.clear();
        this.mCacheView = null;
    }

    static /* synthetic */ void lambda$instantiateItem$4(LocalMedia localMedia, String string, ViewGroup viewGroup, View view) {
        if (PictureSelectionConfig.customVideoPlayCallback != null) {
            PictureSelectionConfig.customVideoPlayCallback.startPlayVideo((Object)localMedia);
        } else {
            view = new Intent();
            localMedia = new Bundle();
            localMedia.putString("videoPath", string);
            view.putExtras((Bundle)localMedia);
            JumpUtils.startPictureVideoPlayActivity((Context)viewGroup.getContext(), (Bundle)localMedia, (int)166);
        }
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        viewGroup.removeView((View)object);
        if (this.mCacheView.size() <= 20) return;
        this.mCacheView.remove(n);
    }

    public int getCount() {
        return PictureExternalPreviewActivity.access$000((PictureExternalPreviewActivity)this.this$0).size();
    }

    public int getItemPosition(Object object) {
        return -2;
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
        LocalMedia localMedia = (LocalMedia)PictureExternalPreviewActivity.access$000((PictureExternalPreviewActivity)this.this$0).get(n);
        if (localMedia != null) {
            object = localMedia.isCut() && !localMedia.isCompressed() ? localMedia.getCutPath() : (!(localMedia.isCompressed() || localMedia.isCut() && localMedia.isCompressed()) ? (!TextUtils.isEmpty((CharSequence)localMedia.getAndroidQToPath()) ? localMedia.getAndroidQToPath() : localMedia.getPath()) : localMedia.getCompressPath());
            boolean bl = PictureMimeType.isHasHttp((String)object);
            String string = bl && TextUtils.isEmpty((CharSequence)localMedia.getMimeType()) ? PictureMimeType.getImageMimeType((String)localMedia.getPath()) : localMedia.getMimeType();
            boolean bl2 = PictureMimeType.isHasVideo((String)string);
            int n2 = 8;
            n = bl2 ? 0 : 8;
            imageView.setVisibility(n);
            boolean bl3 = PictureMimeType.isGif((String)string);
            boolean bl4 = MediaUtils.isLongImg((LocalMedia)localMedia);
            n = bl4 && !bl3 ? 8 : 0;
            photoView.setVisibility(n);
            n = n2;
            if (bl4) {
                n = n2;
                if (!bl3) {
                    n = 0;
                }
            }
            subsamplingScaleImageView.setVisibility(n);
            if (bl3 && !localMedia.isCompressed()) {
                if (PictureSelectionConfig.imageEngine != null) {
                    PictureSelectionConfig.imageEngine.loadAsGifImage(this.this$0.getContext(), (String)object, (ImageView)photoView);
                }
            } else if (PictureSelectionConfig.imageEngine != null) {
                if (bl) {
                    PictureSelectionConfig.imageEngine.loadImage(view.getContext(), (String)object, (ImageView)photoView, subsamplingScaleImageView, (OnImageCompleteCallback)new /* Unavailable Anonymous Inner Class!! */);
                } else if (bl4) {
                    PictureExternalPreviewActivity pictureExternalPreviewActivity = this.this$0;
                    string = PictureMimeType.isContent((String)object) ? Uri.parse((String)object) : Uri.fromFile((File)new File((String)object));
                    PictureExternalPreviewActivity.access$300((PictureExternalPreviewActivity)pictureExternalPreviewActivity, (Uri)string, (SubsamplingScaleImageView)subsamplingScaleImageView);
                } else {
                    PictureSelectionConfig.imageEngine.loadImage(view.getContext(), (String)object, (ImageView)photoView);
                }
            }
            photoView.setOnViewTapListener((OnViewTapListener)new _$.Lambda.PictureExternalPreviewActivity.SimpleFragmentAdapter.MkgowPnHjx5ddrfk7AJgghO8nPg(this));
            subsamplingScaleImageView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureExternalPreviewActivity.SimpleFragmentAdapter.gbfEqjnU6VMmqfOcy1gUV8H5Krk(this));
            if (!bl2) {
                subsamplingScaleImageView.setOnLongClickListener((View.OnLongClickListener)new _$.Lambda.PictureExternalPreviewActivity.SimpleFragmentAdapter.QMCBWC0MjLmlbl_DaCykGwK77ig(this, (String)object, localMedia));
            }
            if (!bl2) {
                photoView.setOnLongClickListener((View.OnLongClickListener)new _$.Lambda.PictureExternalPreviewActivity.SimpleFragmentAdapter.Vh8dP81InQbUnCEQTLMc1EPqBeg(this, (String)object, localMedia));
            }
            imageView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureExternalPreviewActivity.SimpleFragmentAdapter.hQuFHKZ29WMgEDMtIIQdIxQX2to(localMedia, (String)object, viewGroup));
        }
        viewGroup.addView(view, 0);
        return view;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean bl = view == object;
        return bl;
    }

    public /* synthetic */ void lambda$instantiateItem$0$PictureExternalPreviewActivity$SimpleFragmentAdapter(View view, float f, float f2) {
        this.this$0.finish();
        PictureExternalPreviewActivity.access$700((PictureExternalPreviewActivity)this.this$0);
    }

    public /* synthetic */ void lambda$instantiateItem$1$PictureExternalPreviewActivity$SimpleFragmentAdapter(View view) {
        this.this$0.finish();
        PictureExternalPreviewActivity.access$700((PictureExternalPreviewActivity)this.this$0);
    }

    public /* synthetic */ boolean lambda$instantiateItem$2$PictureExternalPreviewActivity$SimpleFragmentAdapter(String string, LocalMedia object, View view) {
        if (!this.this$0.config.isNotPreviewDownload) return true;
        if (PermissionChecker.checkSelfPermission((Context)this.this$0.getContext(), (String)"android.permission.WRITE_EXTERNAL_STORAGE")) {
            PictureExternalPreviewActivity.access$402((PictureExternalPreviewActivity)this.this$0, (String)string);
            string = PictureMimeType.isHasHttp((String)string) && TextUtils.isEmpty((CharSequence)object.getMimeType()) ? PictureMimeType.getImageMimeType((String)object.getPath()) : object.getMimeType();
            view = this.this$0;
            object = string;
            if (PictureMimeType.isJPG((String)string)) {
                object = "image/jpeg";
            }
            PictureExternalPreviewActivity.access$502((PictureExternalPreviewActivity)view, (String)object);
            PictureExternalPreviewActivity.access$600((PictureExternalPreviewActivity)this.this$0);
        } else {
            PermissionChecker.requestPermissions((Activity)this.this$0, (String[])new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (int)1);
        }
        return true;
    }

    public /* synthetic */ boolean lambda$instantiateItem$3$PictureExternalPreviewActivity$SimpleFragmentAdapter(String string, LocalMedia object, View view) {
        if (!this.this$0.config.isNotPreviewDownload) return true;
        if (PermissionChecker.checkSelfPermission((Context)this.this$0.getContext(), (String)"android.permission.WRITE_EXTERNAL_STORAGE")) {
            PictureExternalPreviewActivity.access$402((PictureExternalPreviewActivity)this.this$0, (String)string);
            string = PictureMimeType.isHasHttp((String)string) && TextUtils.isEmpty((CharSequence)object.getMimeType()) ? PictureMimeType.getImageMimeType((String)object.getPath()) : object.getMimeType();
            view = this.this$0;
            object = string;
            if (PictureMimeType.isJPG((String)string)) {
                object = "image/jpeg";
            }
            PictureExternalPreviewActivity.access$502((PictureExternalPreviewActivity)view, (String)object);
            PictureExternalPreviewActivity.access$600((PictureExternalPreviewActivity)this.this$0);
        } else {
            PermissionChecker.requestPermissions((Activity)this.this$0, (String[])new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (int)1);
        }
        return true;
    }

    public void removeCacheView(int n) {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray == null) return;
        if (n >= sparseArray.size()) return;
        this.mCacheView.removeAt(n);
    }
}
