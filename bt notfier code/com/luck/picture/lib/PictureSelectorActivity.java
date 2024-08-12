/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.media.MediaPlayer
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.SimpleItemAnimator
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.PictureCustomCameraActivity
 *  com.luck.picture.lib.PictureMediaScannerConnection
 *  com.luck.picture.lib.PictureSelector
 *  com.luck.picture.lib.PictureSelectorActivity$onAudioOnClick
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.R$attr
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.R$style
 *  com.luck.picture.lib._$$Lambda$PictureSelectorActivity$0RPGos1NllckBEtYh7BYh8pgRww
 *  com.luck.picture.lib._$$Lambda$PictureSelectorActivity$2pjZWI08v8jb9UzHLbIlukH1_mM
 *  com.luck.picture.lib._$$Lambda$PictureSelectorActivity$RqBGbPlFwb5_dWuL4flIQS9MZLA
 *  com.luck.picture.lib._$$Lambda$PictureSelectorActivity$Xf1qq1sm6vTloCyeTVsYF92Z528
 *  com.luck.picture.lib._$$Lambda$PictureSelectorActivity$_IdUEJ4d65K5VsPqQbOWuj3r2Jo
 *  com.luck.picture.lib._$$Lambda$PictureSelectorActivity$m1jFH1RwEpgszVh9qeAwJuTMpok
 *  com.luck.picture.lib._$$Lambda$PictureSelectorActivity$pGXWId0a_641n28B0yLL3o_rbYg
 *  com.luck.picture.lib._$$Lambda$PictureSelectorActivity$pWowqd6EQWtQriS8vGGKGs8K0Sg
 *  com.luck.picture.lib.adapter.PictureImageGridAdapter
 *  com.luck.picture.lib.animators.AlphaInAnimationAdapter
 *  com.luck.picture.lib.animators.SlideInBottomAnimationAdapter
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.decoration.GridSpacingItemDecoration
 *  com.luck.picture.lib.dialog.PhotoItemSelectedDialog
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.entity.LocalMediaFolder
 *  com.luck.picture.lib.listener.OnAlbumItemClickListener
 *  com.luck.picture.lib.listener.OnItemClickListener
 *  com.luck.picture.lib.listener.OnPermissionDialogOptionCallback
 *  com.luck.picture.lib.listener.OnPhotoSelectChangedListener
 *  com.luck.picture.lib.listener.OnQueryDataResultListener
 *  com.luck.picture.lib.listener.OnRecyclerViewPreloadMoreListener
 *  com.luck.picture.lib.manager.UCropManager
 *  com.luck.picture.lib.model.LocalMediaPageLoader
 *  com.luck.picture.lib.observable.ImagesObservable
 *  com.luck.picture.lib.permissions.PermissionChecker
 *  com.luck.picture.lib.thread.PictureThreadUtils
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 *  com.luck.picture.lib.tools.AttrsUtils
 *  com.luck.picture.lib.tools.BitmapUtils
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.DoubleUtils
 *  com.luck.picture.lib.tools.JumpUtils
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.ScreenUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.StringUtils
 *  com.luck.picture.lib.tools.ToastUtils
 *  com.luck.picture.lib.tools.ValueOf
 *  com.luck.picture.lib.widget.FolderPopWindow
 *  com.luck.picture.lib.widget.RecyclerPreloadView
 *  com.yalantis.ucrop.UCrop
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Source
 */
package com.luck.picture.lib;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.PictureCustomCameraActivity;
import com.luck.picture.lib.PictureMediaScannerConnection;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.animators.AlphaInAnimationAdapter;
import com.luck.picture.lib.animators.SlideInBottomAnimationAdapter;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.dialog.PhotoItemSelectedDialog;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnAlbumItemClickListener;
import com.luck.picture.lib.listener.OnItemClickListener;
import com.luck.picture.lib.listener.OnPermissionDialogOptionCallback;
import com.luck.picture.lib.listener.OnPhotoSelectChangedListener;
import com.luck.picture.lib.listener.OnQueryDataResultListener;
import com.luck.picture.lib.listener.OnRecyclerViewPreloadMoreListener;
import com.luck.picture.lib.manager.UCropManager;
import com.luck.picture.lib.model.LocalMediaPageLoader;
import com.luck.picture.lib.observable.ImagesObservable;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.BitmapUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.DoubleUtils;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.widget.FolderPopWindow;
import com.luck.picture.lib.widget.RecyclerPreloadView;
import com.yalantis.ucrop.UCrop;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class PictureSelectorActivity
extends PictureBaseActivity
implements View.OnClickListener,
OnAlbumItemClickListener,
OnPhotoSelectChangedListener<LocalMedia>,
OnItemClickListener,
OnRecyclerViewPreloadMoreListener {
    private static final String TAG = PictureSelectorActivity.class.getSimpleName();
    private int allFolderSize;
    protected Animation animation = null;
    protected PictureCustomDialog audioDialog;
    protected FolderPopWindow folderWindow;
    private long intervalClickTime = 0L;
    protected boolean isEnterSetting;
    protected boolean isPlayAudio = false;
    protected boolean isStartAnimation = false;
    protected PictureImageGridAdapter mAdapter;
    protected RelativeLayout mBottomLayout;
    protected CheckBox mCbOriginal;
    protected ImageView mIvArrow;
    protected ImageView mIvPictureLeftBack;
    private int mOpenCameraCount;
    protected RecyclerPreloadView mRecyclerView;
    public Runnable mRunnable = new /* Unavailable Anonymous Inner Class!! */;
    protected View mTitleBar;
    protected TextView mTvEmpty;
    protected TextView mTvMusicStatus;
    protected TextView mTvMusicTime;
    protected TextView mTvMusicTotal;
    protected TextView mTvPictureImgNum;
    protected TextView mTvPictureOk;
    protected TextView mTvPicturePreview;
    protected TextView mTvPictureRight;
    protected TextView mTvPictureTitle;
    protected TextView mTvPlayPause;
    protected TextView mTvQuit;
    protected TextView mTvStop;
    protected MediaPlayer mediaPlayer;
    protected SeekBar musicSeekBar;
    protected int oldCurrentListSize;
    protected View viewClickMask;

    static /* synthetic */ void access$000(PictureSelectorActivity pictureSelectorActivity, List list) {
        pictureSelectorActivity.initStandardModel(list);
    }

    static /* synthetic */ void access$100(PictureSelectorActivity pictureSelectorActivity, String string) {
        pictureSelectorActivity.initPlayer(string);
    }

    static /* synthetic */ void access$200(PictureSelectorActivity pictureSelectorActivity) {
        pictureSelectorActivity.playAudio();
    }

    private void bothMimeTypeWith(boolean bl, List<LocalMedia> list) {
        block14: {
            int n;
            int n2;
            int n3;
            block16: {
                int n4;
                LocalMedia localMedia;
                block15: {
                    block12: {
                        block13: {
                            n3 = list.size();
                            n2 = 0;
                            localMedia = n3 > 0 ? list.get(0) : null;
                            if (localMedia == null) {
                                return;
                            }
                            if (!this.config.enableCrop) break block12;
                            if (this.config.selectionMode != 1 || !bl) break block13;
                            this.config.originalPath = localMedia.getPath();
                            UCropManager.ofCrop((Activity)this, (String)this.config.originalPath, (String)localMedia.getMimeType());
                            break block14;
                        }
                        n4 = list.size();
                        n3 = 0;
                        break block15;
                    }
                    if (this.config.isCompress) break block16;
                    this.onResult(list);
                    break block14;
                }
                for (n = 0; n < n4; ++n) {
                    localMedia = list.get(n);
                    n2 = n3;
                    if (localMedia != null) {
                        if (TextUtils.isEmpty((CharSequence)localMedia.getPath())) {
                            n2 = n3;
                        } else {
                            n2 = n3;
                            if (PictureMimeType.isHasImage((String)localMedia.getMimeType())) {
                                n2 = n3 + 1;
                            }
                        }
                    }
                    n3 = n2;
                }
                if (n3 <= 0) {
                    this.onResult(list);
                } else {
                    UCropManager.ofCrop((Activity)this, (ArrayList)((ArrayList)list));
                }
                break block14;
            }
            int n5 = list.size();
            n3 = 0;
            while (true) {
                n = n2;
                if (n3 >= n5) break;
                if (PictureMimeType.isHasImage((String)list.get(n3).getMimeType())) {
                    n = 1;
                    break;
                }
                ++n3;
            }
            if (n <= 0) {
                this.onResult(list);
            } else {
                this.compressImage(list);
            }
        }
    }

    private boolean checkVideoLegitimacy(LocalMedia localMedia) {
        boolean bl;
        boolean bl2 = PictureMimeType.isHasVideo((String)localMedia.getMimeType());
        boolean bl3 = bl = true;
        if (!bl2) return bl3;
        if (this.config.videoMinSecond > 0 && this.config.videoMaxSecond > 0) {
            if (localMedia.getDuration() >= (long)this.config.videoMinSecond) {
                bl3 = bl;
                if (localMedia.getDuration() <= (long)this.config.videoMaxSecond) return bl3;
            }
            this.showPromptDialog(this.getString(R.string.picture_choose_limit_seconds, new Object[]{this.config.videoMinSecond / 1000, this.config.videoMaxSecond / 1000}));
        } else if (this.config.videoMinSecond > 0) {
            bl3 = bl;
            if (localMedia.getDuration() >= (long)this.config.videoMinSecond) return bl3;
            this.showPromptDialog(this.getString(R.string.picture_choose_min_seconds, new Object[]{this.config.videoMinSecond / 1000}));
        } else {
            bl3 = bl;
            if (this.config.videoMaxSecond <= 0) return bl3;
            bl3 = bl;
            if (localMedia.getDuration() <= (long)this.config.videoMaxSecond) return bl3;
            this.showPromptDialog(this.getString(R.string.picture_choose_max_seconds, new Object[]{this.config.videoMaxSecond / 1000}));
        }
        bl3 = false;
        return bl3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void dispatchHandleCamera(Intent var1_1) {
        block37: {
            block38: {
                block36: {
                    var9_3 = null;
                    var7_4 = null;
                    if (var1_1 /* !! */  != null) {
                        try {
                            var6_5 = (PictureSelectionConfig)var1_1 /* !! */ .getParcelableExtra("PictureSelectorConfig");
                            break block36;
                        }
                        catch (Exception var1_2) {
                            break block37;
                        }
                    }
                    var6_5 = null;
                }
                if (var6_5 != null) {
                    this.config = var6_5;
                }
                if (this.config.chooseMode != PictureMimeType.ofAudio()) ** GOTO lbl56
                this.config.cameraMimeType = PictureMimeType.ofAudio();
                this.config.cameraPath = this.getAudioPath(var1_1 /* !! */ );
                if (TextUtils.isEmpty((CharSequence)this.config.cameraPath)) {
                    return;
                }
                var3_9 = SdkVersionUtils.checkedAndroid_R();
                if (!var3_9) ** GOTO lbl56
                var8_10 = MediaUtils.createAudioUri((Context)this.getContext(), (String)this.config.suffixType);
                if (var8_10 == null) ** GOTO lbl42
                var7_4 = var6_5 = Okio.buffer((Source)Okio.source((InputStream)Objects.requireNonNull(this.getContentResolver().openInputStream(Uri.parse((String)this.config.cameraPath)))));
lbl-1000:
                // 2 sources

                {
                    block39: {
                        while (true) {
                            PictureFileUtils.close((Closeable)var6_5);
                            ** GOTO lbl56
                            break;
                        }
                        catch (Throwable var6_6) {
                            var1_1 /* !! */  = var7_4;
                            ** GOTO lbl52
                        }
                        catch (Exception var8_12) {
                            var6_5 = null;
                            break block38;
                        }
                        try {
                            PictureFileUtils.bufferCopy((BufferedSource)var6_5, (OutputStream)this.getContentResolver().openOutputStream((Uri)var8_10));
                            var7_4 = var6_5;
                            this.config.cameraPath = var8_10.toString();
                            break block39;
                        }
                        catch (Exception var8_11) {
                            break block38;
                        }
lbl42:
                        // 1 sources

                        var6_5 = null;
                    }
                    if (var6_5 == null || !var6_5.isOpen()) ** GOTO lbl56
                    ** GOTO lbl-1000
                }
            }
            var7_4 = var6_5;
            {
                var8_10.printStackTrace();
            }
            {
                block40: {
                    if (var6_5 != null && var6_5.isOpen()) {
                        ** continue;
                    }
                    break block40;
lbl52:
                    // 1 sources

                    if (var1_1 /* !! */  == null) throw var6_8;
                    if (var1_1 /* !! */ .isOpen() == false) throw var6_8;
                    PictureFileUtils.close((Closeable)var1_1 /* !! */ );
                    throw var6_8;
                }
                if (TextUtils.isEmpty((CharSequence)this.config.cameraPath)) {
                    return;
                }
                var8_10 = new LocalMedia();
                if (PictureMimeType.isContent((String)this.config.cameraPath)) {
                    var6_5 = PictureFileUtils.getPath((Context)this.getContext(), (Uri)Uri.parse((String)this.config.cameraPath));
                    var10_13 = new File((String)var6_5);
                    var7_4 = PictureMimeType.getMimeType((int)this.config.cameraMimeType);
                    var8_10.setSize(var10_13.length());
                    var8_10.setFileName(var10_13.getName());
                    if (PictureMimeType.isHasImage((String)var7_4)) {
                        var10_13 = MediaUtils.getImageSize((Context)this.getContext(), (String)this.config.cameraPath);
                        var8_10.setWidth(var10_13.getWidth());
                        var8_10.setHeight(var10_13.getHeight());
                    } else if (PictureMimeType.isHasVideo((String)var7_4)) {
                        var10_13 = MediaUtils.getVideoSize((Context)this.getContext(), (String)this.config.cameraPath);
                        var8_10.setWidth(var10_13.getWidth());
                        var8_10.setHeight(var10_13.getHeight());
                        var8_10.setDuration(var10_13.getDuration());
                    } else if (PictureMimeType.isHasAudio((String)var7_4)) {
                        var8_10.setDuration(MediaUtils.getAudioSize((Context)this.getContext(), (String)this.config.cameraPath).getDuration());
                    }
                    var2_14 = this.config.cameraPath.lastIndexOf("/") + 1;
                    var4_15 = var2_14 > 0 ? ValueOf.toLong((Object)this.config.cameraPath.substring(var2_14)) : -1L;
                    var8_10.setId(var4_15);
                    var8_10.setRealPath((String)var6_5);
                    var6_5 = var9_3;
                    if (var1_1 /* !! */  != null) {
                        var6_5 = var1_1 /* !! */ .getStringExtra("mediaPath");
                    }
                    var8_10.setAndroidQToPath((String)var6_5);
                    var1_1 /* !! */  = var7_4;
                } else {
                    var6_5 = new File(this.config.cameraPath);
                    var1_1 /* !! */  = PictureMimeType.getMimeType((int)this.config.cameraMimeType);
                    var8_10.setSize(var6_5.length());
                    var8_10.setFileName(var6_5.getName());
                    if (PictureMimeType.isHasImage((String)var1_1 /* !! */ )) {
                        BitmapUtils.rotateImage((Context)this.getContext(), (boolean)this.config.isCameraRotateImage, (String)this.config.cameraPath);
                        var6_5 = MediaUtils.getImageSize((Context)this.getContext(), (String)this.config.cameraPath);
                        var8_10.setWidth(var6_5.getWidth());
                        var8_10.setHeight(var6_5.getHeight());
                    } else if (PictureMimeType.isHasVideo((String)var1_1 /* !! */ )) {
                        var6_5 = MediaUtils.getVideoSize((Context)this.getContext(), (String)this.config.cameraPath);
                        var8_10.setWidth(var6_5.getWidth());
                        var8_10.setHeight(var6_5.getHeight());
                        var8_10.setDuration(var6_5.getDuration());
                    } else if (PictureMimeType.isHasAudio((String)var1_1 /* !! */ )) {
                        var8_10.setDuration(MediaUtils.getAudioSize((Context)this.getContext(), (String)this.config.cameraPath).getDuration());
                    }
                    var8_10.setId(System.currentTimeMillis());
                    var8_10.setRealPath(this.config.cameraPath);
                }
                var8_10.setPath(this.config.cameraPath);
                var8_10.setMimeType((String)var1_1 /* !! */ );
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isHasVideo((String)var8_10.getMimeType())) {
                    var8_10.setParentFolderName(Environment.DIRECTORY_MOVIES);
                } else {
                    var8_10.setParentFolderName("Camera");
                }
                var8_10.setChooseModel(this.config.chooseMode);
                var8_10.setBucketId(MediaUtils.getCameraFirstBucketId((Context)this.getContext()));
                var8_10.setDateAddedTime(DateUtils.getCurrentTimeMillis());
                this.notifyAdapterData(var8_10);
                var3_9 = SdkVersionUtils.checkedAndroid_Q();
                if (var3_9) {
                    if (PictureMimeType.isHasVideo((String)var8_10.getMimeType()) == false) return;
                    if (PictureMimeType.isContent((String)this.config.cameraPath) == false) return;
                    if (this.config.isFallbackVersion3) {
                        new PictureMediaScannerConnection(this.getContext(), var8_10.getRealPath());
                        return;
                    }
                    var1_1 /* !! */  = new File(var8_10.getRealPath());
                    var6_5 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile((File)var1_1 /* !! */ ));
                    this.sendBroadcast((Intent)var6_5);
                    return;
                }
                if (this.config.isFallbackVersion3) {
                    new PictureMediaScannerConnection(this.getContext(), this.config.cameraPath);
                } else {
                    var6_5 = new File(this.config.cameraPath);
                    var1_1 /* !! */  = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile((File)var6_5));
                    this.sendBroadcast(var1_1 /* !! */ );
                }
                if (PictureMimeType.isHasImage((String)var8_10.getMimeType()) == false) return;
                var2_14 = MediaUtils.getDCIMLastImageId((Context)this.getContext());
                if (var2_14 == -1) return;
                MediaUtils.removeMedia((Context)this.getContext(), (int)var2_14);
                return;
            }
        }
        var1_2.printStackTrace();
    }

    private void dispatchHandleMultiple(LocalMedia localMedia) {
        List list = this.mAdapter.getSelectedData();
        int n = list.size();
        String string2 = n > 0 ? ((LocalMedia)list.get(0)).getMimeType() : "";
        boolean bl = PictureMimeType.isMimeTypeSame((String)string2, (String)localMedia.getMimeType());
        if (this.config.isWithVideoImage) {
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                int n3 = n2;
                if (PictureMimeType.isHasVideo((String)((LocalMedia)list.get(i)).getMimeType())) {
                    n3 = n2 + 1;
                }
                n2 = n3;
            }
            if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                if (this.config.maxVideoSelectNum <= 0) {
                    this.showPromptDialog(this.getString(R.string.picture_rule));
                } else if (n2 >= this.config.maxVideoSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_message_max_num, new Object[]{this.config.maxVideoSelectNum}));
                } else {
                    list.add(localMedia);
                    this.mAdapter.bindSelectData(list);
                }
            } else if (list.size() < this.config.maxSelectNum) {
                list.add(localMedia);
                this.mAdapter.bindSelectData(list);
            } else {
                this.showPromptDialog(StringUtils.getMsg((Context)this.getContext(), (String)localMedia.getMimeType(), (int)this.config.maxSelectNum));
            }
        } else if (PictureMimeType.isHasVideo((String)string2) && this.config.maxVideoSelectNum > 0) {
            if (n < this.config.maxVideoSelectNum) {
                if (!bl) {
                    if (n != 0) return;
                }
                if (list.size() >= this.config.maxVideoSelectNum) return;
                list.add(localMedia);
                this.mAdapter.bindSelectData(list);
            } else {
                this.showPromptDialog(StringUtils.getMsg((Context)this.getContext(), (String)string2, (int)this.config.maxVideoSelectNum));
            }
        } else if (n < this.config.maxSelectNum) {
            if (!bl) {
                if (n != 0) return;
            }
            list.add(localMedia);
            this.mAdapter.bindSelectData(list);
        } else {
            this.showPromptDialog(StringUtils.getMsg((Context)this.getContext(), (String)string2, (int)this.config.maxSelectNum));
        }
    }

    private void dispatchHandleSingle(LocalMedia localMedia) {
        if (this.config.isSingleDirectReturn) {
            List list = this.mAdapter.getSelectedData();
            list.add(localMedia);
            this.mAdapter.bindSelectData(list);
            this.singleDirectReturnCameraHandleResult(localMedia.getMimeType());
        } else {
            List list = this.mAdapter.getSelectedData();
            String string2 = list.size() > 0 ? ((LocalMedia)list.get(0)).getMimeType() : "";
            if (!PictureMimeType.isMimeTypeSame((String)string2, (String)localMedia.getMimeType())) {
                if (list.size() != 0) return;
            }
            this.singleRadioMediaImage();
            list.add(localMedia);
            this.mAdapter.bindSelectData(list);
        }
    }

    private int getPageLimit() {
        if (ValueOf.toInt((Object)this.mTvPictureTitle.getTag(R.id.view_tag)) != -1) return this.config.pageSize;
        int n = this.mOpenCameraCount > 0 ? this.config.pageSize - this.mOpenCameraCount : this.config.pageSize;
        this.mOpenCameraCount = 0;
        return n;
    }

    private void hideDataNull() {
        if (this.mTvEmpty.getVisibility() != 0) return;
        this.mTvEmpty.setVisibility(8);
    }

    private void initPageModel(List<LocalMediaFolder> textView) {
        if (textView != null) {
            this.folderWindow.bindFolder(textView);
            this.mPage = 1;
            LocalMediaFolder localMediaFolder = this.folderWindow.getFolder(0);
            textView = this.mTvPictureTitle;
            int n = R.id.view_count_tag;
            int n2 = localMediaFolder != null ? localMediaFolder.getImageNum() : 0;
            textView.setTag(n, (Object)n2);
            this.mTvPictureTitle.setTag(R.id.view_index_tag, (Object)0);
            long l = localMediaFolder != null ? localMediaFolder.getBucketId() : -1L;
            this.mRecyclerView.setEnabledLoadMore(true);
            LocalMediaPageLoader.getInstance((Context)this.getContext()).loadPageMediaData(l, this.mPage, (OnQueryDataResultListener)new _$.Lambda.PictureSelectorActivity.m1jFH1RwEpgszVh9qeAwJuTMpok(this));
        } else {
            this.showDataNull(this.getString(R.string.picture_data_exception), R.drawable.picture_icon_data_error);
            this.dismissDialog();
        }
    }

    private void initPlayer(String string2) {
        this.mediaPlayer = new MediaPlayer();
        try {
            if (PictureMimeType.isContent((String)string2)) {
                this.mediaPlayer.setDataSource(this.getContext(), Uri.parse((String)string2));
            } else {
                this.mediaPlayer.setDataSource(string2);
            }
            this.mediaPlayer.prepare();
            this.mediaPlayer.setLooping(true);
            this.playAudio();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void initStandardModel(List<LocalMediaFolder> localMediaFolder) {
        if (localMediaFolder != null) {
            if (localMediaFolder.size() > 0) {
                this.folderWindow.bindFolder(localMediaFolder);
                localMediaFolder = localMediaFolder.get(0);
                localMediaFolder.setChecked(true);
                this.mTvPictureTitle.setTag(R.id.view_count_tag, (Object)localMediaFolder.getImageNum());
                List list = localMediaFolder.getData();
                PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
                if (pictureImageGridAdapter != null) {
                    int n;
                    int n2 = pictureImageGridAdapter.getSize();
                    int n3 = list.size();
                    this.oldCurrentListSize = n = this.oldCurrentListSize + n2;
                    if (n3 >= n2) {
                        if (n2 > 0 && n2 < n3 && n != n3) {
                            this.mAdapter.getData().addAll(list);
                            pictureImageGridAdapter = (LocalMedia)this.mAdapter.getData().get(0);
                            localMediaFolder.setFirstImagePath(pictureImageGridAdapter.getPath());
                            localMediaFolder.getData().add(0, pictureImageGridAdapter);
                            localMediaFolder.setCheckedNum(1);
                            localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                            this.updateMediaFolder(this.folderWindow.getFolderData(), (LocalMedia)pictureImageGridAdapter);
                        } else {
                            this.mAdapter.bindData(list);
                        }
                    }
                    if (this.mAdapter.isDataEmpty()) {
                        this.showDataNull(this.getString(R.string.picture_empty), R.drawable.picture_icon_no_data);
                    } else {
                        this.hideDataNull();
                    }
                }
            } else {
                this.showDataNull(this.getString(R.string.picture_empty), R.drawable.picture_icon_no_data);
            }
        } else {
            this.showDataNull(this.getString(R.string.picture_data_exception), R.drawable.picture_icon_data_error);
        }
        this.dismissDialog();
    }

    private boolean isAddSameImp(int n) {
        boolean bl = false;
        if (n == 0) {
            return false;
        }
        int n2 = this.allFolderSize;
        boolean bl2 = bl;
        if (n2 <= 0) return bl2;
        bl2 = bl;
        if (n2 >= n) return bl2;
        bl2 = true;
        return bl2;
    }

    private boolean isCurrentCacheFolderData(int n) {
        this.mTvPictureTitle.setTag(R.id.view_index_tag, (Object)n);
        LocalMediaFolder localMediaFolder = this.folderWindow.getFolder(n);
        if (localMediaFolder == null) return false;
        if (localMediaFolder.getData() == null) return false;
        if (localMediaFolder.getData().size() <= 0) return false;
        this.mAdapter.bindData(localMediaFolder.getData());
        this.mPage = localMediaFolder.getCurrentDataPage();
        this.isHasMore = localMediaFolder.isHasMore();
        this.mRecyclerView.smoothScrollToPosition(0);
        return true;
    }

    private boolean isLocalMediaSame(LocalMedia localMedia) {
        LocalMedia localMedia2 = this.mAdapter.getItem(0);
        if (localMedia2 == null) return false;
        if (localMedia == null) {
            return false;
        }
        if (localMedia2.getPath().equals(localMedia.getPath())) {
            return true;
        }
        if (!PictureMimeType.isContent((String)localMedia.getPath())) return false;
        if (!PictureMimeType.isContent((String)localMedia2.getPath())) return false;
        if (TextUtils.isEmpty((CharSequence)localMedia.getPath())) return false;
        if (TextUtils.isEmpty((CharSequence)localMedia2.getPath())) return false;
        return localMedia.getPath().substring(localMedia.getPath().lastIndexOf("/") + 1).equals(localMedia2.getPath().substring(localMedia2.getPath().lastIndexOf("/") + 1));
    }

    private void isNumComplete(boolean bl) {
        if (!bl) return;
        this.initCompleteText(0);
    }

    private void loadAllMediaData() {
        if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.READ_EXTERNAL_STORAGE") && PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.WRITE_EXTERNAL_STORAGE")) {
            this.readLocalMedia();
        } else {
            PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, (int)1);
        }
    }

    private void loadMoreData() {
        if (this.mAdapter == null) return;
        if (!this.isHasMore) return;
        ++this.mPage;
        long l = ValueOf.toLong((Object)this.mTvPictureTitle.getTag(R.id.view_tag));
        LocalMediaPageLoader.getInstance((Context)this.getContext()).loadPageMediaData(l, this.mPage, this.getPageLimit(), (OnQueryDataResultListener)new _$.Lambda.PictureSelectorActivity.pGXWId0a_641n28B0yLL3o_rbYg(this, l));
    }

    private void manualSaveFolder(LocalMedia localMedia) {
        try {
            LocalMediaFolder localMediaFolder;
            boolean bl = this.folderWindow.isEmpty();
            int n = this.folderWindow.getFolder(0) != null ? this.folderWindow.getFolder(0).getImageNum() : 0;
            if (bl) {
                this.createNewFolder(this.folderWindow.getFolderData());
                LocalMediaFolder localMediaFolder2 = this.folderWindow.getFolderData().size() > 0 ? (LocalMediaFolder)this.folderWindow.getFolderData().get(0) : null;
                localMediaFolder = localMediaFolder2;
                if (localMediaFolder2 == null) {
                    localMediaFolder = new LocalMediaFolder();
                    this.folderWindow.getFolderData().add(0, localMediaFolder);
                }
            } else {
                localMediaFolder = (LocalMediaFolder)this.folderWindow.getFolderData().get(0);
            }
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder.setData(this.mAdapter.getData());
            localMediaFolder.setBucketId(-1L);
            int n2 = this.isAddSameImp(n) ? localMediaFolder.getImageNum() : localMediaFolder.getImageNum() + 1;
            localMediaFolder.setImageNum(n2);
            localMediaFolder = this.getImageFolder(localMedia.getPath(), localMedia.getRealPath(), localMedia.getMimeType(), this.folderWindow.getFolderData());
            if (localMediaFolder != null) {
                n2 = this.isAddSameImp(n) ? localMediaFolder.getImageNum() : localMediaFolder.getImageNum() + 1;
                localMediaFolder.setImageNum(n2);
                if (!this.isAddSameImp(n)) {
                    localMediaFolder.getData().add(0, localMedia);
                }
                localMediaFolder.setBucketId(localMedia.getBucketId());
                localMediaFolder.setFirstImagePath(this.config.cameraPath);
                localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            }
            this.folderWindow.bindFolder(this.folderWindow.getFolderData());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void manualSaveFolderForPageModel(LocalMedia localMedia) {
        if (localMedia == null) {
            return;
        }
        int n = this.folderWindow.getFolderData().size();
        boolean bl = false;
        Object object = n > 0 ? (LocalMediaFolder)this.folderWindow.getFolderData().get(0) : new LocalMediaFolder();
        if (object == null) return;
        int n2 = object.getImageNum();
        object.setFirstImagePath(localMedia.getPath());
        object.setFirstMimeType(localMedia.getMimeType());
        int n3 = this.isAddSameImp(n2) ? object.getImageNum() : object.getImageNum() + 1;
        object.setImageNum(n3);
        if (n == 0) {
            n3 = this.config.chooseMode == PictureMimeType.ofAudio() ? R.string.picture_all_audio : R.string.picture_camera_roll;
            object.setName(this.getString(n3));
            object.setOfAllType(this.config.chooseMode);
            object.setCameraFolder(true);
            object.setChecked(true);
            object.setBucketId(-1L);
            this.folderWindow.getFolderData().add(0, object);
            object = new LocalMediaFolder();
            object.setName(localMedia.getParentFolderName());
            n3 = this.isAddSameImp(n2) ? object.getImageNum() : object.getImageNum() + 1;
            object.setImageNum(n3);
            object.setFirstImagePath(localMedia.getPath());
            object.setFirstMimeType(localMedia.getMimeType());
            object.setBucketId(localMedia.getBucketId());
            this.folderWindow.getFolderData().add(this.folderWindow.getFolderData().size(), object);
        } else {
            boolean bl2;
            object = SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isHasVideo((String)localMedia.getMimeType()) ? Environment.DIRECTORY_MOVIES : "Camera";
            n3 = 0;
            while (true) {
                bl2 = bl;
                if (n3 >= n) break;
                LocalMediaFolder localMediaFolder = (LocalMediaFolder)this.folderWindow.getFolderData().get(n3);
                if (!TextUtils.isEmpty((CharSequence)localMediaFolder.getName()) && localMediaFolder.getName().startsWith((String)object)) {
                    localMedia.setBucketId(localMediaFolder.getBucketId());
                    localMediaFolder.setFirstImagePath(this.config.cameraPath);
                    localMediaFolder.setFirstMimeType(localMedia.getMimeType());
                    n3 = this.isAddSameImp(n2) ? localMediaFolder.getImageNum() : localMediaFolder.getImageNum() + 1;
                    localMediaFolder.setImageNum(n3);
                    if (localMediaFolder.getData() != null && localMediaFolder.getData().size() > 0) {
                        localMediaFolder.getData().add(0, localMedia);
                    }
                    bl2 = true;
                    break;
                }
                ++n3;
            }
            if (!bl2) {
                object = new LocalMediaFolder();
                object.setName(localMedia.getParentFolderName());
                n3 = this.isAddSameImp(n2) ? object.getImageNum() : object.getImageNum() + 1;
                object.setImageNum(n3);
                object.setFirstImagePath(localMedia.getPath());
                object.setFirstMimeType(localMedia.getMimeType());
                object.setBucketId(localMedia.getBucketId());
                this.folderWindow.getFolderData().add(object);
                this.sortFolder(this.folderWindow.getFolderData());
            }
        }
        localMedia = this.folderWindow;
        localMedia.bindFolder(localMedia.getFolderData());
    }

    private void notifyAdapterData(LocalMedia localMedia) {
        if (this.mAdapter == null) return;
        int n = this.folderWindow.getFolder(0) != null ? this.folderWindow.getFolder(0).getImageNum() : 0;
        if (!this.isAddSameImp(n)) {
            this.mAdapter.getData().add(0, localMedia);
            ++this.mOpenCameraCount;
        }
        if (this.checkVideoLegitimacy(localMedia)) {
            if (this.config.selectionMode == 1) {
                this.dispatchHandleSingle(localMedia);
            } else {
                this.dispatchHandleMultiple(localMedia);
            }
        }
        this.mAdapter.notifyItemInserted(this.config.isCamera ? 1 : 0);
        this.mAdapter.notifyItemRangeChanged(this.config.isCamera ? 1 : 0, this.mAdapter.getSize());
        if (this.config.isPageStrategy) {
            this.manualSaveFolderForPageModel(localMedia);
        } else {
            this.manualSaveFolder(localMedia);
        }
        localMedia = this.mTvEmpty;
        n = this.mAdapter.getSize() <= 0 && !this.config.isSingleDirectReturn ? 0 : 8;
        localMedia.setVisibility(n);
        if (this.folderWindow.getFolder(0) != null) {
            this.mTvPictureTitle.setTag(R.id.view_count_tag, (Object)this.folderWindow.getFolder(0).getImageNum());
        }
        this.allFolderSize = 0;
    }

    private void onComplete() {
        List list = this.mAdapter.getSelectedData();
        int n = list.size();
        Object object = list.size() > 0 ? (LocalMedia)list.get(0) : null;
        object = object != null ? object.getMimeType() : "";
        boolean bl = PictureMimeType.isHasImage((String)object);
        if (!this.config.isWithVideoImage) {
            if (this.config.selectionMode == 2) {
                if (PictureMimeType.isHasImage((String)object) && this.config.minSelectNum > 0 && n < this.config.minSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_img_num, new Object[]{this.config.minSelectNum}));
                    return;
                }
                if (PictureMimeType.isHasVideo((String)object) && this.config.minVideoSelectNum > 0 && n < this.config.minVideoSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_video_num, new Object[]{this.config.minVideoSelectNum}));
                    return;
                }
            }
        } else {
            int n2 = 0;
            int n3 = 0;
            for (int i = 0; i < n; ++i) {
                if (PictureMimeType.isHasVideo((String)((LocalMedia)list.get(i)).getMimeType())) {
                    ++n3;
                    continue;
                }
                ++n2;
            }
            if (this.config.selectionMode == 2) {
                if (this.config.minSelectNum > 0 && n2 < this.config.minSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_img_num, new Object[]{this.config.minSelectNum}));
                    return;
                }
                if (this.config.minVideoSelectNum > 0 && n3 < this.config.minVideoSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_video_num, new Object[]{this.config.minVideoSelectNum}));
                    return;
                }
            }
        }
        if (this.config.returnEmpty && n == 0) {
            if (this.config.selectionMode == 2) {
                if (this.config.minSelectNum > 0 && n < this.config.minSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_img_num, new Object[]{this.config.minSelectNum}));
                    return;
                }
                if (this.config.minVideoSelectNum > 0 && n < this.config.minVideoSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_video_num, new Object[]{this.config.minVideoSelectNum}));
                    return;
                }
            }
            if (PictureSelectionConfig.listener != null) {
                PictureSelectionConfig.listener.onResult(list);
            } else {
                this.setResult(-1, PictureSelector.putIntentResult((List)list));
            }
            this.exit();
            return;
        }
        if (this.config.chooseMode == PictureMimeType.ofAll() && this.config.isWithVideoImage) {
            this.bothMimeTypeWith(bl, list);
        } else {
            this.separateMimeTypeWith(bl, list);
        }
    }

    private void onPreview() {
        int n;
        List list = this.mAdapter.getSelectedData();
        ArrayList<LocalMedia> arrayList = new ArrayList<LocalMedia>();
        int n2 = list.size();
        for (n = 0; n < n2; ++n) {
            arrayList.add((LocalMedia)list.get(n));
        }
        if (PictureSelectionConfig.onCustomImagePreviewCallback != null) {
            PictureSelectionConfig.onCustomImagePreviewCallback.onCustomPreviewCallback(this.getContext(), list, 0);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("previewSelectList", arrayList);
        bundle.putParcelableArrayList("selectList", (ArrayList)list);
        bundle.putBoolean("bottom_preview", true);
        bundle.putBoolean("isOriginal", this.config.isCheckOriginalImage);
        bundle.putBoolean("isShowCamera", this.mAdapter.isShowCamera());
        bundle.putString("currentDirectory", this.mTvPictureTitle.getText().toString());
        list = this.getContext();
        boolean bl = this.config.isWeChatStyle;
        n = this.config.selectionMode == 1 ? 69 : 609;
        JumpUtils.startPicturePreviewActivity((Context)list, (boolean)bl, (Bundle)bundle, (int)n);
        this.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation, R.anim.picture_anim_fade_in);
    }

    private void playAudio() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            this.musicSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            this.musicSeekBar.setMax(this.mediaPlayer.getDuration());
        }
        if (this.mTvPlayPause.getText().toString().equals(this.getString(R.string.picture_play_audio))) {
            this.mTvPlayPause.setText((CharSequence)this.getString(R.string.picture_pause_audio));
            this.mTvMusicStatus.setText((CharSequence)this.getString(R.string.picture_play_audio));
        } else {
            this.mTvPlayPause.setText((CharSequence)this.getString(R.string.picture_play_audio));
            this.mTvMusicStatus.setText((CharSequence)this.getString(R.string.picture_pause_audio));
        }
        this.playOrPause();
        if (this.isPlayAudio) return;
        this.mHandler.post(this.mRunnable);
        this.isPlayAudio = true;
    }

    private void previewCallback(Intent object) {
        ArrayList arrayList;
        block10: {
            int n;
            int n2;
            block9: {
                block8: {
                    if (object == null) {
                        return;
                    }
                    if (this.config.isOriginalControl) {
                        this.config.isCheckOriginalImage = object.getBooleanExtra("isOriginal", this.config.isCheckOriginalImage);
                        this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
                    }
                    arrayList = object.getParcelableArrayListExtra("selectList");
                    if (this.mAdapter == null) return;
                    if (arrayList == null) return;
                    n2 = 0;
                    if (!object.getBooleanExtra("isCompleteOrSelected", false)) break block8;
                    this.onChangeData(arrayList);
                    if (this.config.isWithVideoImage) break block9;
                    object = arrayList.size() > 0 ? ((LocalMedia)arrayList.get(0)).getMimeType() : "";
                    if (this.config.isCompress && PictureMimeType.isHasImage((String)object)) {
                        this.compressImage(arrayList);
                    } else {
                        this.onResult(arrayList);
                    }
                    break block10;
                }
                this.isStartAnimation = true;
                break block10;
            }
            int n3 = arrayList.size();
            int n4 = 0;
            while (true) {
                n = n2;
                if (n4 >= n3) break;
                if (PictureMimeType.isHasImage((String)((LocalMedia)arrayList.get(n4)).getMimeType())) {
                    n = 1;
                    break;
                }
                ++n4;
            }
            if (n > 0 && this.config.isCompress) {
                this.compressImage(arrayList);
            } else {
                this.onResult(arrayList);
            }
        }
        this.mAdapter.bindSelectData((List)arrayList);
        this.mAdapter.notifyDataSetChanged();
    }

    private void separateMimeTypeWith(boolean bl, List<LocalMedia> list) {
        LocalMedia localMedia = list.size() > 0 ? list.get(0) : null;
        if (localMedia == null) {
            return;
        }
        if (this.config.enableCrop && bl) {
            if (this.config.selectionMode == 1) {
                this.config.originalPath = localMedia.getPath();
                UCropManager.ofCrop((Activity)this, (String)this.config.originalPath, (String)localMedia.getMimeType());
            } else {
                UCropManager.ofCrop((Activity)this, (ArrayList)((ArrayList)list));
            }
        } else if (this.config.isCompress && bl) {
            this.compressImage(list);
        } else {
            this.onResult(list);
        }
    }

    private void setLastCacheFolderData() {
        int n = ValueOf.toInt((Object)this.mTvPictureTitle.getTag(R.id.view_index_tag));
        LocalMediaFolder localMediaFolder = this.folderWindow.getFolder(n);
        localMediaFolder.setData(this.mAdapter.getData());
        localMediaFolder.setCurrentDataPage(this.mPage);
        localMediaFolder.setHasMore(this.isHasMore);
    }

    private void showDataNull(String string2, int n) {
        if (this.mTvEmpty.getVisibility() != 8) {
            if (this.mTvEmpty.getVisibility() != 4) return;
        }
        this.mTvEmpty.setCompoundDrawablesRelativeWithIntrinsicBounds(0, n, 0, 0);
        this.mTvEmpty.setText((CharSequence)string2);
        this.mTvEmpty.setVisibility(0);
    }

    private void singleCropHandleResult(Intent object) {
        if (object == null) {
            return;
        }
        Uri uri = UCrop.getOutput((Intent)object);
        if (uri == null) {
            return;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = uri.getPath();
        if (this.mAdapter == null) return;
        ArrayList arrayList2 = object.getParcelableArrayListExtra("selectList");
        if (arrayList2 != null) {
            this.mAdapter.bindSelectData((List)arrayList2);
            this.mAdapter.notifyDataSetChanged();
        }
        object = this.mAdapter.getSelectedData();
        uri = null;
        object = object != null && object.size() > 0 ? (LocalMedia)object.get(0) : null;
        long l = 0L;
        if (object != null) {
            this.config.originalPath = object.getPath();
            object.setCutPath(string2);
            object.setChooseModel(this.config.chooseMode);
            boolean bl = TextUtils.isEmpty((CharSequence)string2) ^ true;
            if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent((String)object.getPath())) {
                if (bl) {
                    object.setSize(new File(string2).length());
                } else {
                    if (!TextUtils.isEmpty((CharSequence)object.getRealPath())) {
                        l = new File(object.getRealPath()).length();
                    }
                    object.setSize(l);
                }
                object.setAndroidQToPath(string2);
            } else {
                if (bl) {
                    l = new File(string2).length();
                }
                object.setSize(l);
            }
            object.setCut(bl);
            arrayList.add(object);
            this.handlerResult(arrayList);
        } else {
            object = uri;
            if (arrayList2 != null) {
                object = uri;
                if (arrayList2.size() > 0) {
                    object = (LocalMedia)arrayList2.get(0);
                }
            }
            if (object == null) return;
            this.config.originalPath = object.getPath();
            object.setCutPath(string2);
            object.setChooseModel(this.config.chooseMode);
            boolean bl = TextUtils.isEmpty((CharSequence)string2) ^ true;
            if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent((String)object.getPath())) {
                if (bl) {
                    object.setSize(new File(string2).length());
                } else {
                    if (!TextUtils.isEmpty((CharSequence)object.getRealPath())) {
                        l = new File(object.getRealPath()).length();
                    }
                    object.setSize(l);
                }
                object.setAndroidQToPath(string2);
            } else {
                if (bl) {
                    l = new File(string2).length();
                }
                object.setSize(l);
            }
            object.setCut(bl);
            arrayList.add(object);
            this.handlerResult(arrayList);
        }
    }

    private void singleDirectReturnCameraHandleResult(String string2) {
        boolean bl = PictureMimeType.isHasImage((String)string2);
        if (this.config.enableCrop && bl) {
            this.config.originalPath = this.config.cameraPath;
            UCropManager.ofCrop((Activity)this, (String)this.config.originalPath, (String)string2);
        } else if (this.config.isCompress && bl) {
            this.compressImage(this.mAdapter.getSelectedData());
        } else {
            this.onResult(this.mAdapter.getSelectedData());
        }
    }

    private void singleRadioMediaImage() {
        List list = this.mAdapter.getSelectedData();
        if (list == null) return;
        if (list.size() <= 0) return;
        int n = ((LocalMedia)list.get(0)).getPosition();
        list.clear();
        this.mAdapter.notifyItemChanged(n);
    }

    private void startCustomCamera() {
        if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.RECORD_AUDIO")) {
            this.startActivityForResult(new Intent((Context)this, PictureCustomCameraActivity.class), 909);
            this.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
        } else {
            PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.RECORD_AUDIO"}, (int)4);
        }
    }

    private void startPlayAudioDialog(String string2) {
        PictureCustomDialog pictureCustomDialog;
        if (this.isFinishing()) {
            return;
        }
        this.audioDialog = pictureCustomDialog = new PictureCustomDialog(this.getContext(), R.layout.picture_audio_dialog);
        pictureCustomDialog.getWindow().setWindowAnimations(R.style.Picture_Theme_Dialog_AudioStyle);
        this.mTvMusicStatus = (TextView)this.audioDialog.findViewById(R.id.tv_musicStatus);
        this.mTvMusicTime = (TextView)this.audioDialog.findViewById(R.id.tv_musicTime);
        this.musicSeekBar = (SeekBar)this.audioDialog.findViewById(R.id.musicSeekBar);
        this.mTvMusicTotal = (TextView)this.audioDialog.findViewById(R.id.tv_musicTotal);
        this.mTvPlayPause = (TextView)this.audioDialog.findViewById(R.id.tv_PlayPause);
        this.mTvStop = (TextView)this.audioDialog.findViewById(R.id.tv_Stop);
        this.mTvQuit = (TextView)this.audioDialog.findViewById(R.id.tv_Quit);
        this.mHandler.postDelayed((Runnable)new /* Unavailable Anonymous Inner Class!! */, 30L);
        this.mTvPlayPause.setOnClickListener((View.OnClickListener)new onAudioOnClick(this, string2));
        this.mTvStop.setOnClickListener((View.OnClickListener)new onAudioOnClick(this, string2));
        this.mTvQuit.setOnClickListener((View.OnClickListener)new onAudioOnClick(this, string2));
        this.musicSeekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        this.audioDialog.setOnDismissListener((DialogInterface.OnDismissListener)new _$.Lambda.PictureSelectorActivity.0RPGos1NllckBEtYh7BYh8pgRww(this, string2));
        this.mHandler.post(this.mRunnable);
        this.audioDialog.show();
    }

    private void synchronousCover() {
        if (this.config.chooseMode != PictureMimeType.ofAll()) return;
        PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void updateMediaFolder(List<LocalMediaFolder> list, LocalMedia localMedia) {
        File file = new File(localMedia.getRealPath()).getParentFile();
        if (file == null) {
            return;
        }
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            LocalMediaFolder localMediaFolder = list.get(n2);
            String string2 = localMediaFolder.getName();
            if (!TextUtils.isEmpty((CharSequence)string2) && string2.equals(file.getName())) {
                localMediaFolder.setFirstImagePath(this.config.cameraPath);
                localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                localMediaFolder.setCheckedNum(1);
                localMediaFolder.getData().add(0, localMedia);
                return;
            }
            ++n2;
        }
    }

    protected void changeImageNumber(List<LocalMedia> list) {
        boolean bl = list.size() != 0;
        if (bl) {
            this.mTvPictureOk.setEnabled(true);
            this.mTvPictureOk.setSelected(true);
            this.mTvPicturePreview.setEnabled(true);
            this.mTvPicturePreview.setSelected(true);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText != 0) {
                    if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                        this.mTvPicturePreview.setText((CharSequence)String.format(this.getString(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText), list.size()));
                    } else {
                        this.mTvPicturePreview.setText(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText);
                    }
                } else {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview_num, new Object[]{list.size()}));
                }
            } else if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                    this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureCompleteTextColor);
                }
                if (PictureSelectionConfig.style.picturePreviewTextColor != 0) {
                    this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.picturePreviewTextColor);
                }
                if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.picturePreviewText)) {
                    this.mTvPicturePreview.setText((CharSequence)PictureSelectionConfig.style.picturePreviewText);
                } else {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview_num, new Object[]{list.size()}));
                }
            }
            if (this.numComplete) {
                this.initCompleteText(list.size());
            } else {
                if (!this.isStartAnimation) {
                    this.mTvPictureImgNum.startAnimation(this.animation);
                }
                this.mTvPictureImgNum.setVisibility(0);
                this.mTvPictureImgNum.setText((CharSequence)ValueOf.toString((Object)list.size()));
                if (PictureSelectionConfig.uiStyle != null) {
                    if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                        this.mTvPictureOk.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText));
                    }
                } else if (PictureSelectionConfig.style != null) {
                    if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                        this.mTvPictureOk.setText((CharSequence)PictureSelectionConfig.style.pictureCompleteText);
                    }
                } else {
                    this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_completed));
                }
                this.isStartAnimation = false;
            }
        } else {
            this.mTvPictureOk.setEnabled(this.config.returnEmpty);
            this.mTvPictureOk.setSelected(false);
            this.mTvPicturePreview.setEnabled(false);
            this.mTvPicturePreview.setSelected(false);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText != 0) {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText));
                } else {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview));
                }
            } else if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                    this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
                }
                if (PictureSelectionConfig.style.pictureUnPreviewTextColor != 0) {
                    this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.pictureUnPreviewTextColor);
                }
                if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnPreviewText)) {
                    this.mTvPicturePreview.setText((CharSequence)PictureSelectionConfig.style.pictureUnPreviewText);
                } else {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview));
                }
            }
            if (this.numComplete) {
                this.initCompleteText(list.size());
            } else {
                this.mTvPictureImgNum.setVisibility(4);
                if (PictureSelectionConfig.uiStyle != null) {
                    if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText == 0) return;
                    this.mTvPictureOk.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText));
                } else if (PictureSelectionConfig.style != null) {
                    if (TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText)) return;
                    this.mTvPictureOk.setText((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText);
                } else {
                    this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_please_select));
                }
            }
        }
    }

    public int getResourceId() {
        return R.layout.picture_selector;
    }

    protected void initCompleteText(int n) {
        int n2 = this.config.selectionMode;
        Object object = 1;
        if (n2 == 1) {
            if (n <= 0) {
                if (PictureSelectionConfig.uiStyle != null) {
                    if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                        TextView textView = this.mTvPictureOk;
                        object = PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0 ? String.format(this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText), n, object) : this.getString(R.string.picture_please_select);
                        textView.setText((CharSequence)object);
                    } else {
                        object = this.mTvPictureOk;
                        n = PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0 ? PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText : R.string.picture_please_select;
                        object.setText((CharSequence)this.getString(n));
                    }
                } else {
                    if (PictureSelectionConfig.style == null) return;
                    if (PictureSelectionConfig.style.isCompleteReplaceNum && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText)) {
                        this.mTvPictureOk.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureUnCompleteText, n, object));
                    } else {
                        TextView textView = this.mTvPictureOk;
                        object = !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_done);
                        textView.setText((CharSequence)object);
                    }
                }
            } else if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                    TextView textView = this.mTvPictureOk;
                    object = PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0 ? String.format(this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), n, object) : this.getString(R.string.picture_done);
                    textView.setText((CharSequence)object);
                } else {
                    object = this.mTvPictureOk;
                    n = PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0 ? PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText : R.string.picture_done;
                    object.setText((CharSequence)this.getString(n));
                }
            } else {
                if (PictureSelectionConfig.style == null) return;
                if (PictureSelectionConfig.style.isCompleteReplaceNum && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureOk.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, n, object));
                } else {
                    TextView textView = this.mTvPictureOk;
                    object = !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText) ? PictureSelectionConfig.style.pictureCompleteText : this.getString(R.string.picture_done);
                    textView.setText((CharSequence)object);
                }
            }
        } else if (n <= 0) {
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                    TextView textView = this.mTvPictureOk;
                    object = PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0 ? String.format(this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText), n, this.config.maxSelectNum) : this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum});
                    textView.setText((CharSequence)object);
                } else {
                    TextView textView = this.mTvPictureOk;
                    object = PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0 ? this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText) : this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum});
                    textView.setText((CharSequence)object);
                }
            } else {
                if (PictureSelectionConfig.style == null) return;
                if (PictureSelectionConfig.style.isCompleteReplaceNum) {
                    TextView textView = this.mTvPictureOk;
                    object = !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? String.format(PictureSelectionConfig.style.pictureUnCompleteText, n, this.config.maxSelectNum) : this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum});
                    textView.setText((CharSequence)object);
                } else {
                    TextView textView = this.mTvPictureOk;
                    object = !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum});
                    textView.setText((CharSequence)object);
                }
            }
        } else if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    this.mTvPictureOk.setText((CharSequence)String.format(this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), n, this.config.maxSelectNum));
                } else {
                    this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum}));
                }
            } else if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                this.mTvPictureOk.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText));
            } else {
                this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum}));
            }
        } else {
            if (PictureSelectionConfig.style == null) return;
            if (PictureSelectionConfig.style.isCompleteReplaceNum) {
                if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureOk.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, n, this.config.maxSelectNum));
                } else {
                    this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum}));
                }
            } else if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                this.mTvPictureOk.setText((CharSequence)PictureSelectionConfig.style.pictureCompleteText);
            } else {
                this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum}));
            }
        }
    }

    public void initPictureSelectorStyle() {
        if (PictureSelectionConfig.uiStyle != null) {
            Drawable drawable2;
            if (PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable != 0) {
                drawable2 = ContextCompat.getDrawable((Context)this, (int)PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable);
                this.mIvArrow.setImageDrawable(drawable2);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextColor != 0) {
                this.mTvPictureTitle.setTextColor(PictureSelectionConfig.uiStyle.picture_top_titleTextColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextSize != 0) {
                this.mTvPictureTitle.setTextSize((float)PictureSelectionConfig.uiStyle.picture_top_titleTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor.length > 0 && (drawable2 = AttrsUtils.getColorStateList((int[])PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor)) != null) {
                this.mTvPictureRight.setTextColor((ColorStateList)drawable2);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float)PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_leftBack != 0) {
                this.mIvPictureLeftBack.setImageResource(PictureSelectionConfig.uiStyle.picture_top_leftBack);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor.length > 0 && (drawable2 = AttrsUtils.getColorStateList((int[])PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor)) != null) {
                this.mTvPicturePreview.setTextColor((ColorStateList)drawable2);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_previewTextSize != 0) {
                this.mTvPicturePreview.setTextSize((float)PictureSelectionConfig.uiStyle.picture_bottom_previewTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground != 0) {
                this.mTvPictureImgNum.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextSize != 0) {
                this.mTvPictureImgNum.setTextSize((float)PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextColor != 0) {
                this.mTvPictureImgNum.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor.length > 0 && (drawable2 = AttrsUtils.getColorStateList((int[])PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor)) != null) {
                this.mTvPictureOk.setTextColor((ColorStateList)drawable2);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeTextSize != 0) {
                this.mTvPictureOk.setTextSize((float)PictureSelectionConfig.uiStyle.picture_bottom_completeTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor != 0) {
                this.mBottomLayout.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_container_backgroundColor != 0) {
                this.container.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_container_backgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText != 0) {
                this.mTvPictureRight.setText(PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                this.mTvPictureOk.setText(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText != 0) {
                this.mTvPicturePreview.setText(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleArrowLeftPadding != 0) {
                ((RelativeLayout.LayoutParams)this.mIvArrow.getLayoutParams()).leftMargin = PictureSelectionConfig.uiStyle.picture_top_titleArrowLeftPadding;
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_top_titleBarHeight;
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barHeight > 0) {
                this.mBottomLayout.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_bottom_barHeight;
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_checkbox));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_white));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize != 0) {
                    this.mCbOriginal.setTextSize((float)PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText != 0) {
                    this.mCbOriginal.setText(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_white));
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureTitleDownResId != 0) {
                Drawable drawable3 = ContextCompat.getDrawable((Context)this, (int)PictureSelectionConfig.style.pictureTitleDownResId);
                this.mIvArrow.setImageDrawable(drawable3);
            }
            if (PictureSelectionConfig.style.pictureTitleTextColor != 0) {
                this.mTvPictureTitle.setTextColor(PictureSelectionConfig.style.pictureTitleTextColor);
            }
            if (PictureSelectionConfig.style.pictureTitleTextSize != 0) {
                this.mTvPictureTitle.setTextSize((float)PictureSelectionConfig.style.pictureTitleTextSize);
            }
            if (PictureSelectionConfig.style.pictureRightDefaultTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureRightDefaultTextColor);
            } else if (PictureSelectionConfig.style.pictureCancelTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureCancelTextColor);
            }
            if (PictureSelectionConfig.style.pictureRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float)PictureSelectionConfig.style.pictureRightTextSize);
            }
            if (PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
                this.mIvPictureLeftBack.setImageResource(PictureSelectionConfig.style.pictureLeftBackIcon);
            }
            if (PictureSelectionConfig.style.pictureUnPreviewTextColor != 0) {
                this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.pictureUnPreviewTextColor);
            }
            if (PictureSelectionConfig.style.picturePreviewTextSize != 0) {
                this.mTvPicturePreview.setTextSize((float)PictureSelectionConfig.style.picturePreviewTextSize);
            }
            if (PictureSelectionConfig.style.pictureCheckNumBgStyle != 0) {
                this.mTvPictureImgNum.setBackgroundResource(PictureSelectionConfig.style.pictureCheckNumBgStyle);
            }
            if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
            }
            if (PictureSelectionConfig.style.pictureCompleteTextSize != 0) {
                this.mTvPictureOk.setTextSize((float)PictureSelectionConfig.style.pictureCompleteTextSize);
            }
            if (PictureSelectionConfig.style.pictureBottomBgColor != 0) {
                this.mBottomLayout.setBackgroundColor(PictureSelectionConfig.style.pictureBottomBgColor);
            }
            if (PictureSelectionConfig.style.pictureContainerBackgroundColor != 0) {
                this.container.setBackgroundColor(PictureSelectionConfig.style.pictureContainerBackgroundColor);
            }
            if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureRightDefaultText)) {
                this.mTvPictureRight.setText((CharSequence)PictureSelectionConfig.style.pictureRightDefaultText);
            }
            if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureOk.setText((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText);
            }
            if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnPreviewText)) {
                this.mTvPicturePreview.setText((CharSequence)PictureSelectionConfig.style.pictureUnPreviewText);
            }
            if (PictureSelectionConfig.style.pictureTitleRightArrowLeftPadding != 0) {
                ((RelativeLayout.LayoutParams)this.mIvArrow.getLayoutParams()).leftMargin = PictureSelectionConfig.style.pictureTitleRightArrowLeftPadding;
            }
            if (PictureSelectionConfig.style.pictureTitleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.style.pictureTitleBarHeight;
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.style.pictureOriginalControlStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.style.pictureOriginalControlStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_checkbox));
                }
                if (PictureSelectionConfig.style.pictureOriginalFontColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.style.pictureOriginalFontColor);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_white));
                }
                if (PictureSelectionConfig.style.pictureOriginalTextSize != 0) {
                    this.mCbOriginal.setTextSize((float)PictureSelectionConfig.style.pictureOriginalTextSize);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_white));
            }
        } else {
            int n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_title_textColor);
            if (n != 0) {
                this.mTvPictureTitle.setTextColor(n);
            }
            if ((n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_right_textColor)) != 0) {
                this.mTvPictureRight.setTextColor(n);
            }
            if ((n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_container_backgroundColor)) != 0) {
                this.container.setBackgroundColor(n);
            }
            Drawable drawable4 = AttrsUtils.getTypeValueDrawable((Context)this.getContext(), (int)R.attr.picture_leftBack_icon, (int)R.drawable.picture_icon_back);
            this.mIvPictureLeftBack.setImageDrawable(drawable4);
            if (this.config.downResId != 0) {
                drawable4 = ContextCompat.getDrawable((Context)this, (int)this.config.downResId);
                this.mIvArrow.setImageDrawable(drawable4);
            } else {
                drawable4 = AttrsUtils.getTypeValueDrawable((Context)this.getContext(), (int)R.attr.picture_arrow_down_icon, (int)R.drawable.picture_icon_arrow_down);
                this.mIvArrow.setImageDrawable(drawable4);
            }
            n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_bottom_bg);
            if (n != 0) {
                this.mBottomLayout.setBackgroundColor(n);
            }
            if ((drawable4 = AttrsUtils.getTypeValueColorStateList((Context)this.getContext(), (int)R.attr.picture_complete_textColor)) != null) {
                this.mTvPictureOk.setTextColor((ColorStateList)drawable4);
            }
            if ((drawable4 = AttrsUtils.getTypeValueColorStateList((Context)this.getContext(), (int)R.attr.picture_preview_textColor)) != null) {
                this.mTvPicturePreview.setTextColor((ColorStateList)drawable4);
            }
            if ((n = AttrsUtils.getTypeValueSizeForInt((Context)this.getContext(), (int)R.attr.picture_titleRightArrow_LeftPadding)) != 0) {
                ((RelativeLayout.LayoutParams)this.mIvArrow.getLayoutParams()).leftMargin = n;
            }
            drawable4 = AttrsUtils.getTypeValueDrawable((Context)this.getContext(), (int)R.attr.picture_num_style, (int)R.drawable.picture_num_oval);
            this.mTvPictureImgNum.setBackground(drawable4);
            n = AttrsUtils.getTypeValueSizeForInt((Context)this.getContext(), (int)R.attr.picture_titleBar_height);
            if (n > 0) {
                this.mTitleBar.getLayoutParams().height = n;
            }
            if (this.config.isOriginalControl) {
                drawable4 = AttrsUtils.getTypeValueDrawable((Context)this.getContext(), (int)R.attr.picture_original_check_style, (int)R.drawable.picture_original_wechat_checkbox);
                this.mCbOriginal.setButtonDrawable(drawable4);
                n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_original_text_color);
                if (n != 0) {
                    this.mCbOriginal.setTextColor(n);
                }
            }
        }
        this.mTitleBar.setBackgroundColor(this.colorPrimary);
        this.mAdapter.bindSelectData(this.selectionMedias);
    }

    protected void initWidgets() {
        super.initWidgets();
        this.container = this.findViewById(R.id.container);
        this.mTitleBar = this.findViewById(R.id.titleBar);
        this.mIvPictureLeftBack = (ImageView)this.findViewById(R.id.pictureLeftBack);
        this.mTvPictureTitle = (TextView)this.findViewById(R.id.picture_title);
        this.mTvPictureRight = (TextView)this.findViewById(R.id.picture_right);
        this.mTvPictureOk = (TextView)this.findViewById(R.id.picture_tv_ok);
        this.mCbOriginal = (CheckBox)this.findViewById(R.id.cb_original);
        this.mIvArrow = (ImageView)this.findViewById(R.id.ivArrow);
        this.viewClickMask = this.findViewById(R.id.viewClickMask);
        this.mTvPicturePreview = (TextView)this.findViewById(R.id.picture_id_preview);
        this.mTvPictureImgNum = (TextView)this.findViewById(R.id.tv_media_num);
        this.mRecyclerView = (RecyclerPreloadView)this.findViewById(R.id.picture_recycler);
        this.mBottomLayout = (RelativeLayout)this.findViewById(R.id.select_bar_layout);
        this.mTvEmpty = (TextView)this.findViewById(R.id.tv_empty);
        this.isNumComplete(this.numComplete);
        if (!this.numComplete) {
            this.animation = AnimationUtils.loadAnimation((Context)this, (int)R.anim.picture_anim_modal_in);
        }
        this.mTvPicturePreview.setOnClickListener((View.OnClickListener)this);
        if (this.config.isAutomaticTitleRecyclerTop) {
            this.mTitleBar.setOnClickListener((View.OnClickListener)this);
        }
        Object object = this.mTvPicturePreview;
        int n = this.config.chooseMode;
        int n2 = PictureMimeType.ofAudio();
        int n3 = 8;
        n2 = n != n2 && this.config.enablePreview ? 0 : 8;
        object.setVisibility(n2);
        object = this.mBottomLayout;
        n2 = this.config.selectionMode == 1 && this.config.isSingleDirectReturn ? n3 : 0;
        object.setVisibility(n2);
        this.mIvPictureLeftBack.setOnClickListener((View.OnClickListener)this);
        this.mTvPictureRight.setOnClickListener((View.OnClickListener)this);
        this.mTvPictureOk.setOnClickListener((View.OnClickListener)this);
        this.viewClickMask.setOnClickListener((View.OnClickListener)this);
        this.mTvPictureImgNum.setOnClickListener((View.OnClickListener)this);
        this.mTvPictureTitle.setOnClickListener((View.OnClickListener)this);
        this.mIvArrow.setOnClickListener((View.OnClickListener)this);
        n2 = this.config.chooseMode == PictureMimeType.ofAudio() ? R.string.picture_all_audio : R.string.picture_camera_roll;
        object = this.getString(n2);
        this.mTvPictureTitle.setText((CharSequence)object);
        this.mTvPictureTitle.setTag(R.id.view_tag, (Object)-1);
        object = new FolderPopWindow((Context)this);
        this.folderWindow = object;
        object.setArrowImageView(this.mIvArrow);
        this.folderWindow.setOnAlbumItemClickListener((OnAlbumItemClickListener)this);
        object = this.mRecyclerView;
        n2 = this.config.imageSpanCount;
        n3 = 4;
        n2 = n2 <= 0 ? 4 : this.config.imageSpanCount;
        object.addItemDecoration((RecyclerView.ItemDecoration)new GridSpacingItemDecoration(n2, ScreenUtils.dip2px((Context)this, (float)2.0f), false));
        RecyclerPreloadView recyclerPreloadView = this.mRecyclerView;
        object = this.getContext();
        n2 = this.config.imageSpanCount <= 0 ? n3 : this.config.imageSpanCount;
        recyclerPreloadView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager((Context)object, n2));
        if (!this.config.isPageStrategy) {
            this.mRecyclerView.setHasFixedSize(true);
        } else {
            this.mRecyclerView.setReachBottomRow(2);
            this.mRecyclerView.setOnRecyclerViewPreloadListener((OnRecyclerViewPreloadMoreListener)this);
        }
        object = this.mRecyclerView.getItemAnimator();
        if (object != null) {
            ((SimpleItemAnimator)object).setSupportsChangeAnimations(false);
            this.mRecyclerView.setItemAnimator(null);
        }
        this.loadAllMediaData();
        recyclerPreloadView = this.mTvEmpty;
        object = this.config.chooseMode == PictureMimeType.ofAudio() ? this.getString(R.string.picture_audio_empty) : this.getString(R.string.picture_empty);
        recyclerPreloadView.setText((CharSequence)object);
        StringUtils.tempTextFont((TextView)this.mTvEmpty, (int)this.config.chooseMode);
        object = new PictureImageGridAdapter(this.getContext(), this.config);
        this.mAdapter = object;
        object.setOnPhotoSelectChangedListener((OnPhotoSelectChangedListener)this);
        n2 = this.config.animationMode;
        if (n2 != 1) {
            if (n2 != 2) {
                this.mRecyclerView.setAdapter((RecyclerView.Adapter)this.mAdapter);
            } else {
                this.mRecyclerView.setAdapter((RecyclerView.Adapter)new SlideInBottomAnimationAdapter((RecyclerView.Adapter)this.mAdapter));
            }
        } else {
            this.mRecyclerView.setAdapter((RecyclerView.Adapter)new AlphaInAnimationAdapter((RecyclerView.Adapter)this.mAdapter));
        }
        if (!this.config.isOriginalControl) return;
        this.mCbOriginal.setVisibility(0);
        this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
        this.mCbOriginal.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new _$.Lambda.PictureSelectorActivity._IdUEJ4d65K5VsPqQbOWuj3r2Jo(this));
    }

    public /* synthetic */ void lambda$initPageModel$3$PictureSelectorActivity(List list, int n, boolean bl) {
        if (this.isFinishing()) return;
        this.dismissDialog();
        if (this.mAdapter == null) return;
        this.isHasMore = true;
        if (bl && list.size() == 0) {
            this.onRecyclerViewPreloadMore();
            return;
        }
        int n2 = this.mAdapter.getSize();
        int n3 = list.size();
        this.oldCurrentListSize = n = this.oldCurrentListSize + n2;
        if (n3 >= n2) {
            if (n2 > 0 && n2 < n3 && n != n3) {
                if (this.isLocalMediaSame((LocalMedia)list.get(0))) {
                    this.mAdapter.bindData(list);
                } else {
                    this.mAdapter.getData().addAll(list);
                }
            } else {
                this.mAdapter.bindData(list);
            }
        }
        if (this.mAdapter.isDataEmpty()) {
            this.showDataNull(this.getString(R.string.picture_empty), R.drawable.picture_icon_no_data);
        } else {
            this.hideDataNull();
        }
    }

    public /* synthetic */ void lambda$initWidgets$0$PictureSelectorActivity(CompoundButton compoundButton, boolean bl) {
        this.config.isCheckOriginalImage = bl;
    }

    public /* synthetic */ void lambda$loadMoreData$1$PictureSelectorActivity(long l, List list, int n, boolean bl) {
        if (this.isFinishing()) return;
        this.isHasMore = bl;
        if (bl) {
            this.hideDataNull();
            n = list.size();
            if (n > 0) {
                int n2 = this.mAdapter.getSize();
                this.mAdapter.getData().addAll(list);
                int n3 = this.mAdapter.getItemCount();
                this.mAdapter.notifyItemRangeChanged(n2, n3);
            } else {
                this.onRecyclerViewPreloadMore();
            }
            if (n >= 10) return;
            list = this.mRecyclerView;
            list.onScrolled(list.getScrollX(), this.mRecyclerView.getScrollY());
        } else {
            if (!this.mAdapter.isDataEmpty()) return;
            n = l == -1L ? R.string.picture_empty : R.string.picture_data_null;
            this.showDataNull(this.getString(n), R.drawable.picture_icon_no_data);
        }
    }

    public /* synthetic */ void lambda$onItemClick$5$PictureSelectorActivity(List list, int n, boolean bl) {
        this.isHasMore = bl;
        if (this.isFinishing()) return;
        if (list.size() == 0) {
            this.mAdapter.clear();
        }
        this.mAdapter.bindData(list);
        this.mRecyclerView.onScrolled(0, 0);
        this.mRecyclerView.smoothScrollToPosition(0);
        this.dismissDialog();
    }

    public /* synthetic */ void lambda$readLocalMedia$2$PictureSelectorActivity(List list, int n, boolean bl) {
        if (this.isFinishing()) return;
        this.isHasMore = true;
        this.initPageModel(list);
        if (!this.config.isSyncCover) return;
        this.synchronousCover();
    }

    public /* synthetic */ void lambda$showPermissionsDialog$6$PictureSelectorActivity(PictureCustomDialog pictureCustomDialog, boolean bl, View view) {
        if (!this.isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        if (bl) return;
        if (PictureSelectionConfig.listener != null) {
            PictureSelectionConfig.listener.onCancel();
        }
        this.exit();
    }

    public /* synthetic */ void lambda$showPermissionsDialog$7$PictureSelectorActivity(PictureCustomDialog pictureCustomDialog, View view) {
        if (!this.isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        PermissionChecker.launchAppDetailsSettings((Context)this.getContext());
        this.isEnterSetting = true;
    }

    public /* synthetic */ void lambda$startPlayAudioDialog$4$PictureSelectorActivity(String string2, DialogInterface dialogInterface) {
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mHandler.postDelayed((Runnable)new /* Unavailable Anonymous Inner Class!! */, 30L);
        try {
            if (this.audioDialog == null) return;
            if (!this.audioDialog.isShowing()) return;
            this.audioDialog.dismiss();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected void multiCropHandleResult(Intent object) {
        if (object == null) {
            return;
        }
        if ((object = UCrop.getMultipleOutput((Intent)object)) == null) return;
        if (object.size() <= 0) return;
        this.mAdapter.bindSelectData((List)object);
        this.mAdapter.notifyDataSetChanged();
        this.handlerResult((List)object);
    }

    protected void onActivityResult(int n, int n2, Intent object) {
        super.onActivityResult(n, n2, (Intent)object);
        if (n2 == -1) {
            if (n != 69) {
                if (n != 166) {
                    if (n != 609) {
                        if (n != 909) return;
                        this.dispatchHandleCamera((Intent)object);
                    } else {
                        this.multiCropHandleResult((Intent)object);
                    }
                } else {
                    if (object == null) return;
                    if ((object = object.getParcelableArrayListExtra("selectList")) == null) return;
                    if (object.size() <= 0) return;
                    this.onResult((List)object);
                }
            } else {
                this.singleCropHandleResult((Intent)object);
            }
        } else if (n2 == 0) {
            this.previewCallback((Intent)object);
            if (n != 909) return;
            MediaUtils.deleteCamera((Context)this, (String)this.config.cameraPath);
        } else {
            if (n2 != 96) return;
            if (object == null) return;
            if ((object = (Throwable)object.getSerializableExtra("com.yalantis.ucrop.Error")) == null) return;
            ToastUtils.s((Context)this.getContext(), (String)((Throwable)object).getMessage());
        }
    }

    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            this.finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        if (PictureSelectionConfig.listener != null) {
            PictureSelectionConfig.listener.onCancel();
        }
        this.exit();
    }

    public void onChange(List<LocalMedia> list) {
        this.changeImageNumber(list);
    }

    protected void onChangeData(List<LocalMedia> list) {
    }

    public void onClick(View object) {
        int n = object.getId();
        if (n != R.id.pictureLeftBack && n != R.id.picture_right) {
            if (n != R.id.picture_title && n != R.id.ivArrow && n != R.id.viewClickMask) {
                if (n == R.id.picture_id_preview) {
                    this.onPreview();
                    return;
                }
                if (n != R.id.picture_tv_ok && n != R.id.tv_media_num) {
                    if (n != R.id.titleBar) return;
                    if (!this.config.isAutomaticTitleRecyclerTop) return;
                    if (SystemClock.uptimeMillis() - this.intervalClickTime < (long)500) {
                        if (this.mAdapter.getItemCount() <= 0) return;
                        this.mRecyclerView.scrollToPosition(0);
                    } else {
                        this.intervalClickTime = SystemClock.uptimeMillis();
                    }
                    return;
                }
                this.onComplete();
                return;
            }
            if (this.folderWindow.isShowing()) {
                this.folderWindow.dismiss();
            } else {
                if (this.folderWindow.isEmpty()) return;
                this.folderWindow.showAsDropDown(this.mTitleBar);
                if (this.config.isSingleDirectReturn) return;
                object = this.mAdapter.getSelectedData();
                this.folderWindow.updateFolderCheckStatus((List)object);
            }
            return;
        }
        object = this.folderWindow;
        if (object != null && object.isShowing()) {
            this.folderWindow.dismiss();
        } else {
            this.onBackPressed();
        }
    }

    protected void onCreate(Bundle object) {
        super.onCreate(object);
        if (object == null) return;
        this.allFolderSize = object.getInt("all_folder_size");
        this.oldCurrentListSize = object.getInt("oldCurrentListSize", 0);
        if ((object = PictureSelector.obtainSelectorList((Bundle)object)) == null) {
            object = this.selectionMedias;
        }
        this.selectionMedias = object;
        object = this.mAdapter;
        if (object == null) return;
        this.isStartAnimation = true;
        object.bindSelectData(this.selectionMedias);
    }

    protected void onDestroy() {
        super.onDestroy();
        Animation animation = this.animation;
        if (animation != null) {
            animation.cancel();
            this.animation = null;
        }
        if (this.mediaPlayer == null) return;
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mediaPlayer.release();
        this.mediaPlayer = null;
    }

    public void onItemClick(int n, boolean bl, long l, String string2, List<LocalMedia> list) {
        bl = this.config.isCamera && bl;
        this.mAdapter.setShowCamera(bl);
        this.mTvPictureTitle.setText((CharSequence)string2);
        long l2 = ValueOf.toLong((Object)this.mTvPictureTitle.getTag(R.id.view_tag));
        string2 = this.mTvPictureTitle;
        int n2 = R.id.view_count_tag;
        int n3 = this.folderWindow.getFolder(n) != null ? this.folderWindow.getFolder(n).getImageNum() : 0;
        string2.setTag(n2, (Object)n3);
        if (this.config.isPageStrategy) {
            if (l2 != l) {
                this.setLastCacheFolderData();
                if (!this.isCurrentCacheFolderData(n)) {
                    this.mPage = 1;
                    this.showPleaseDialog();
                    LocalMediaPageLoader.getInstance((Context)this.getContext()).loadPageMediaData(l, this.mPage, (OnQueryDataResultListener)new _$.Lambda.PictureSelectorActivity.2pjZWI08v8jb9UzHLbIlukH1_mM(this));
                }
            }
        } else {
            this.mAdapter.bindData(list);
            this.mRecyclerView.smoothScrollToPosition(0);
        }
        this.mTvPictureTitle.setTag(R.id.view_tag, (Object)l);
        this.folderWindow.dismiss();
    }

    public void onItemClick(View view, int n) {
        if (n != 0) {
            if (n != 1) return;
            if (PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
                PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(this.getContext(), this.config, 1);
                this.config.cameraMimeType = PictureMimeType.ofVideo();
            } else {
                this.startOpenCameraVideo();
            }
        } else if (PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
            PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(this.getContext(), this.config, 1);
            this.config.cameraMimeType = PictureMimeType.ofImage();
        } else {
            this.startOpenCamera();
        }
    }

    public void onPictureClick(LocalMedia localMedia, int n) {
        if (this.config.selectionMode == 1 && this.config.isSingleDirectReturn) {
            ArrayList<LocalMedia> arrayList = new ArrayList<LocalMedia>();
            arrayList.add(localMedia);
            if (this.config.enableCrop && PictureMimeType.isHasImage((String)localMedia.getMimeType())) {
                this.mAdapter.bindSelectData(arrayList);
                UCropManager.ofCrop((Activity)this, (String)localMedia.getPath(), (String)localMedia.getMimeType());
            } else {
                this.handlerResult(arrayList);
            }
        } else {
            this.startPreview(this.mAdapter.getData(), n);
        }
    }

    public void onRecyclerViewPreloadMore() {
        this.loadMoreData();
    }

    public void onRequestPermissionsResult(int n, String[] object, int[] nArray) {
        super.onRequestPermissionsResult(n, object, nArray);
        if (n != 1) {
            if (n != 2) {
                if (n != 4) {
                    if (n != 5) return;
                    if (nArray.length > 0 && nArray[0] == 0) {
                        this.startCamera();
                    } else {
                        object = this.getString(R.string.picture_jurisdiction);
                        this.showPermissionsDialog(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, (String)object);
                    }
                } else if (nArray.length > 0 && nArray[0] == 0) {
                    this.startCustomCamera();
                } else {
                    object = this.getString(R.string.picture_audio);
                    this.showPermissionsDialog(false, new String[]{"android.permission.RECORD_AUDIO"}, (String)object);
                }
            } else if (nArray.length > 0 && nArray[0] == 0) {
                this.onTakePhoto();
            } else {
                object = this.getString(R.string.picture_camera);
                this.showPermissionsDialog(true, new String[]{"android.permission.CAMERA"}, (String)object);
            }
        } else if (nArray.length > 0 && nArray[0] == 0) {
            this.readLocalMedia();
        } else {
            object = this.getString(R.string.picture_jurisdiction);
            this.showPermissionsDialog(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, (String)object);
        }
    }

    protected void onResume() {
        Object object;
        super.onResume();
        if (this.isEnterSetting) {
            if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.READ_EXTERNAL_STORAGE") && PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (this.mAdapter.isDataEmpty()) {
                    this.readLocalMedia();
                }
            } else {
                object = this.getString(R.string.picture_jurisdiction);
                this.showPermissionsDialog(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, (String)object);
            }
            this.isEnterSetting = false;
        }
        if (!this.config.isOriginalControl) return;
        object = this.mCbOriginal;
        if (object == null) return;
        object.setChecked(this.config.isCheckOriginalImage);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
        if (pictureImageGridAdapter == null) return;
        bundle.putInt("oldCurrentListSize", pictureImageGridAdapter.getSize());
        if (this.folderWindow.getFolderData().size() > 0) {
            bundle.putInt("all_folder_size", this.folderWindow.getFolder(0).getImageNum());
        }
        if (this.mAdapter.getSelectedData() == null) return;
        PictureSelector.saveSelectorList((Bundle)bundle, (List)this.mAdapter.getSelectedData());
    }

    public void onTakePhoto() {
        if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.CAMERA")) {
            if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.READ_EXTERNAL_STORAGE") && PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.WRITE_EXTERNAL_STORAGE")) {
                this.startCamera();
            } else {
                PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, (int)5);
            }
        } else {
            PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.CAMERA"}, (int)2);
        }
    }

    public void playOrPause() {
        try {
            if (this.mediaPlayer == null) return;
            if (this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.pause();
            } else {
                this.mediaPlayer.start();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected void readLocalMedia() {
        this.showPleaseDialog();
        if (this.config.isPageStrategy) {
            LocalMediaPageLoader.getInstance((Context)this.getContext()).loadAllMedia((OnQueryDataResultListener)new _$.Lambda.PictureSelectorActivity.RqBGbPlFwb5_dWuL4flIQS9MZLA(this));
        } else {
            PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    protected void showPermissionsDialog(boolean bl, String[] button, String string2) {
        if (this.isFinishing()) {
            return;
        }
        if (PictureSelectionConfig.onPermissionsObtainCallback != null) {
            PictureSelectionConfig.onPermissionsObtainCallback.onPermissionsIntercept(this.getContext(), bl, (String[])button, string2, (OnPermissionDialogOptionCallback)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(this.getContext(), R.layout.picture_wind_base_dialog);
        pictureCustomDialog.setCancelable(false);
        pictureCustomDialog.setCanceledOnTouchOutside(false);
        Button button2 = (Button)pictureCustomDialog.findViewById(R.id.btn_cancel);
        button = (Button)pictureCustomDialog.findViewById(R.id.btn_commit);
        button.setText((CharSequence)this.getString(R.string.picture_go_setting));
        TextView textView = (TextView)pictureCustomDialog.findViewById(R.id.tvTitle);
        TextView textView2 = (TextView)pictureCustomDialog.findViewById(R.id.tv_content);
        textView.setText((CharSequence)this.getString(R.string.picture_prompt));
        textView2.setText((CharSequence)string2);
        button2.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureSelectorActivity.Xf1qq1sm6vTloCyeTVsYF92Z528(this, pictureCustomDialog, bl));
        button.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureSelectorActivity.pWowqd6EQWtQriS8vGGKGs8K0Sg(this, pictureCustomDialog));
        pictureCustomDialog.show();
    }

    public void startCamera() {
        if (DoubleUtils.isFastDoubleClick()) return;
        if (PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
            if (this.config.chooseMode == 0) {
                PhotoItemSelectedDialog photoItemSelectedDialog = PhotoItemSelectedDialog.newInstance();
                photoItemSelectedDialog.setOnItemClickListener((OnItemClickListener)this);
                photoItemSelectedDialog.show(this.getSupportFragmentManager(), "PhotoItemSelectedDialog");
            } else {
                PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(this.getContext(), this.config, this.config.chooseMode);
                this.config.cameraMimeType = this.config.chooseMode;
            }
            return;
        }
        if (this.config.chooseMode != PictureMimeType.ofAudio() && this.config.isUseCustomCamera) {
            this.startCustomCamera();
            return;
        }
        int n = this.config.chooseMode;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) return;
                    this.startOpenCameraAudio();
                } else {
                    this.startOpenCameraVideo();
                }
            } else {
                this.startOpenCamera();
            }
        } else {
            PhotoItemSelectedDialog photoItemSelectedDialog = PhotoItemSelectedDialog.newInstance();
            photoItemSelectedDialog.setOnItemClickListener((OnItemClickListener)this);
            photoItemSelectedDialog.show(this.getSupportFragmentManager(), "PhotoItemSelectedDialog");
        }
    }

    public void startPreview(List<LocalMedia> context, int n) {
        LocalMedia localMedia = context.get(n);
        String string2 = localMedia.getMimeType();
        Bundle bundle = new Bundle();
        List<LocalMedia> list = new ArrayList<LocalMedia>();
        if (PictureMimeType.isHasVideo((String)string2)) {
            if (this.config.selectionMode == 1 && !this.config.enPreviewVideo) {
                list.add(localMedia);
                this.onResult(list);
            } else if (PictureSelectionConfig.customVideoPlayCallback != null) {
                PictureSelectionConfig.customVideoPlayCallback.startPlayVideo((Object)localMedia);
            } else {
                bundle.putParcelable("mediaKey", (Parcelable)localMedia);
                JumpUtils.startPictureVideoPlayActivity((Context)this.getContext(), (Bundle)bundle, (int)166);
            }
        } else if (PictureMimeType.isHasAudio((String)string2)) {
            if (this.config.selectionMode == 1) {
                list.add(localMedia);
                this.onResult(list);
            } else {
                this.startPlayAudioDialog(localMedia.getPath());
            }
        } else {
            if (PictureSelectionConfig.onCustomImagePreviewCallback != null) {
                PictureSelectionConfig.onCustomImagePreviewCallback.onCustomPreviewCallback(this.getContext(), context, n);
                return;
            }
            list = this.mAdapter.getSelectedData();
            ImagesObservable.getInstance().savePreviewMediaData(new ArrayList<LocalMedia>((Collection<LocalMedia>)context));
            bundle.putParcelableArrayList("selectList", (ArrayList)list);
            bundle.putInt("position", n);
            bundle.putBoolean("isOriginal", this.config.isCheckOriginalImage);
            bundle.putBoolean("isShowCamera", this.mAdapter.isShowCamera());
            bundle.putLong("bucket_id", ValueOf.toLong((Object)this.mTvPictureTitle.getTag(R.id.view_tag)));
            bundle.putInt("page", this.mPage);
            bundle.putParcelable("PictureSelectorConfig", (Parcelable)this.config);
            bundle.putInt("count", ValueOf.toInt((Object)this.mTvPictureTitle.getTag(R.id.view_count_tag)));
            bundle.putString("currentDirectory", this.mTvPictureTitle.getText().toString());
            context = this.getContext();
            boolean bl = this.config.isWeChatStyle;
            n = this.config.selectionMode == 1 ? 69 : 609;
            JumpUtils.startPicturePreviewActivity((Context)context, (boolean)bl, (Bundle)bundle, (int)n);
            this.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation, R.anim.picture_anim_fade_in);
        }
    }

    public void stop(String string2) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) return;
        try {
            mediaPlayer.stop();
            this.mediaPlayer.reset();
            if (PictureMimeType.isContent((String)string2)) {
                this.mediaPlayer.setDataSource(this.getContext(), Uri.parse((String)string2));
            } else {
                this.mediaPlayer.setDataSource(string2);
            }
            this.mediaPlayer.prepare();
            this.mediaPlayer.seekTo(0);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
