/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.fragment.app.Fragment
 *  com.luck.picture.lib.PictureCustomCameraActivity
 *  com.luck.picture.lib.PictureSelector
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.PictureSelectorCameraEmptyActivity
 *  com.luck.picture.lib.PictureSelectorWeChatStyleActivity
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.engine.CacheResourcesEngine
 *  com.luck.picture.lib.engine.CompressEngine
 *  com.luck.picture.lib.engine.ImageEngine
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.listener.OnCustomCameraInterfaceListener
 *  com.luck.picture.lib.listener.OnCustomImagePreviewCallback
 *  com.luck.picture.lib.listener.OnPermissionsObtainCallback
 *  com.luck.picture.lib.listener.OnResultCallbackListener
 *  com.luck.picture.lib.listener.OnVideoSelectedPlayCallback
 *  com.luck.picture.lib.style.PictureCropParameterStyle
 *  com.luck.picture.lib.style.PictureParameterStyle
 *  com.luck.picture.lib.style.PictureSelectorUIStyle
 *  com.luck.picture.lib.style.PictureWindowAnimationStyle
 *  com.luck.picture.lib.tools.DoubleUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.yalantis.ucrop.UCrop$Options
 */
package com.luck.picture.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.PictureCustomCameraActivity;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.PictureSelectorCameraEmptyActivity;
import com.luck.picture.lib.PictureSelectorWeChatStyleActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.CacheResourcesEngine;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnCustomCameraInterfaceListener;
import com.luck.picture.lib.listener.OnCustomImagePreviewCallback;
import com.luck.picture.lib.listener.OnPermissionsObtainCallback;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.listener.OnVideoSelectedPlayCallback;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureSelectorUIStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.tools.DoubleUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.yalantis.ucrop.UCrop;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PictureSelectionModel {
    private final PictureSelectionConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionModel(PictureSelector pictureSelector, int n) {
        this.selector = pictureSelector;
        pictureSelector = PictureSelectionConfig.getCleanInstance();
        this.selectionConfig = pictureSelector;
        pictureSelector.chooseMode = n;
    }

    public PictureSelectionModel(PictureSelector pictureSelector, int n, boolean bl) {
        this.selector = pictureSelector;
        pictureSelector = PictureSelectionConfig.getCleanInstance();
        this.selectionConfig = pictureSelector;
        pictureSelector.camera = bl;
        this.selectionConfig.chooseMode = n;
    }

    public PictureSelectionModel basicUCropConfig(UCrop.Options options) {
        this.selectionConfig.uCropOptions = options;
        return this;
    }

    public PictureSelectionModel bindCustomCameraInterfaceListener(OnCustomCameraInterfaceListener onCustomCameraInterfaceListener) {
        PictureSelectionConfig.onCustomCameraInterfaceListener = (OnCustomCameraInterfaceListener)new WeakReference<OnCustomCameraInterfaceListener>(onCustomCameraInterfaceListener).get();
        return this;
    }

    public PictureSelectionModel bindCustomPermissionsObtainListener(OnPermissionsObtainCallback onPermissionsObtainCallback) {
        PictureSelectionConfig.onPermissionsObtainCallback = (OnPermissionsObtainCallback)new WeakReference<OnPermissionsObtainCallback>(onPermissionsObtainCallback).get();
        return this;
    }

    public PictureSelectionModel bindCustomPlayVideoCallback(OnVideoSelectedPlayCallback onVideoSelectedPlayCallback) {
        PictureSelectionConfig.customVideoPlayCallback = (OnVideoSelectedPlayCallback)new WeakReference<OnVideoSelectedPlayCallback>(onVideoSelectedPlayCallback).get();
        return this;
    }

    public PictureSelectionModel bindCustomPreviewCallback(OnCustomImagePreviewCallback onCustomImagePreviewCallback) {
        PictureSelectionConfig.onCustomImagePreviewCallback = (OnCustomImagePreviewCallback)new WeakReference<OnCustomImagePreviewCallback>(onCustomImagePreviewCallback).get();
        return this;
    }

    @Deprecated
    public PictureSelectionModel bindPictureSelectorInterfaceListener(OnCustomCameraInterfaceListener onCustomCameraInterfaceListener) {
        PictureSelectionConfig.onCustomCameraInterfaceListener = (OnCustomCameraInterfaceListener)new WeakReference<OnCustomCameraInterfaceListener>(onCustomCameraInterfaceListener).get();
        return this;
    }

    public PictureSelectionModel cameraFileName(String string) {
        this.selectionConfig.cameraFileName = string;
        return this;
    }

    public PictureSelectionModel circleDimmedLayer(boolean bl) {
        this.selectionConfig.circleDimmedLayer = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel closeAndroidQChangeVideoWH(boolean bl) {
        this.selectionConfig.isAndroidQChangeVideoWH = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel closeAndroidQChangeWH(boolean bl) {
        this.selectionConfig.isAndroidQChangeWH = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel compress(boolean bl) {
        this.selectionConfig.isCompress = bl;
        return this;
    }

    public PictureSelectionModel compressEngine(CompressEngine compressEngine) {
        if (PictureSelectionConfig.compressEngine == compressEngine) return this;
        PictureSelectionConfig.compressEngine = compressEngine;
        return this;
    }

    public PictureSelectionModel compressFocusAlpha(boolean bl) {
        this.selectionConfig.focusAlpha = bl;
        return this;
    }

    public PictureSelectionModel compressQuality(int n) {
        this.selectionConfig.compressQuality = n;
        return this;
    }

    public PictureSelectionModel compressSavePath(String string) {
        this.selectionConfig.compressSavePath = string;
        return this;
    }

    @Deprecated
    public PictureSelectionModel cropCompressQuality(int n) {
        this.selectionConfig.cropCompressQuality = n;
        return this;
    }

    public PictureSelectionModel cropImageWideHigh(int n, int n2) {
        this.selectionConfig.cropWidth = n;
        this.selectionConfig.cropHeight = n2;
        return this;
    }

    @Deprecated
    public PictureSelectionModel cropWH(int n, int n2) {
        this.selectionConfig.cropWidth = n;
        this.selectionConfig.cropHeight = n2;
        return this;
    }

    public PictureSelectionModel cutOutQuality(int n) {
        this.selectionConfig.cropCompressQuality = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel enableCrop(boolean bl) {
        this.selectionConfig.enableCrop = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel enablePreviewAudio(boolean bl) {
        this.selectionConfig.enablePreviewAudio = bl;
        return this;
    }

    public void externalPictureVideo(String string) {
        PictureSelector pictureSelector = this.selector;
        if (pictureSelector == null) throw new NullPointerException("This PictureSelector is Null");
        pictureSelector.externalPictureVideo(string);
    }

    public PictureSelectionModel filterMaxFileSize(long l) {
        this.selectionConfig.filterMaxFileSize = l >= 0x100000L ? l : l * 1024L;
        return this;
    }

    public PictureSelectionModel filterMinFileSize(long l) {
        this.selectionConfig.filterMinFileSize = l >= 0x100000L ? l : l * 1024L;
        return this;
    }

    public void forResult(int n) {
        if (DoubleUtils.isFastDoubleClick()) return;
        Activity activity = this.selector.getActivity();
        if (activity == null) return;
        Object object = this.selectionConfig;
        if (object == null) return;
        if (object.camera && this.selectionConfig.isUseCustomCamera) {
            object = new Intent((Context)activity, PictureCustomCameraActivity.class);
        } else {
            object = this.selectionConfig.camera ? PictureSelectorCameraEmptyActivity.class : (this.selectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class);
            object = new Intent((Context)activity, (Class)object);
        }
        this.selectionConfig.isCallbackMode = false;
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult((Intent)object, n);
        } else {
            activity.startActivityForResult((Intent)object, n);
        }
        activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
    }

    @Deprecated
    public void forResult(int n, int n2, int n3) {
        if (DoubleUtils.isFastDoubleClick()) return;
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            return;
        }
        Object object = this.selectionConfig;
        object = object != null && object.camera ? PictureSelectorCameraEmptyActivity.class : (this.selectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class);
        Intent intent = new Intent((Context)activity, (Class)object);
        this.selectionConfig.isCallbackMode = false;
        object = this.selector.getFragment();
        if (object != null) {
            object.startActivityForResult(intent, n);
        } else {
            activity.startActivityForResult(intent, n);
        }
        activity.overridePendingTransition(n2, n3);
    }

    public void forResult(int n, OnResultCallbackListener object) {
        if (DoubleUtils.isFastDoubleClick()) return;
        Activity activity = this.selector.getActivity();
        if (activity == null) return;
        if (this.selectionConfig == null) return;
        PictureSelectionConfig.listener = (OnResultCallbackListener)new WeakReference<OnResultCallbackListener>((OnResultCallbackListener)object).get();
        this.selectionConfig.isCallbackMode = true;
        if (this.selectionConfig.camera && this.selectionConfig.isUseCustomCamera) {
            object = new Intent((Context)activity, PictureCustomCameraActivity.class);
        } else {
            object = this.selectionConfig.camera ? PictureSelectorCameraEmptyActivity.class : (this.selectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class);
            object = new Intent((Context)activity, (Class)object);
        }
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult((Intent)object, n);
        } else {
            activity.startActivityForResult((Intent)object, n);
        }
        activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
    }

    public void forResult(OnResultCallbackListener object) {
        if (DoubleUtils.isFastDoubleClick()) return;
        Activity activity = this.selector.getActivity();
        if (activity == null) return;
        if (this.selectionConfig == null) return;
        PictureSelectionConfig.listener = (OnResultCallbackListener)new WeakReference<OnResultCallbackListener>((OnResultCallbackListener)object).get();
        this.selectionConfig.isCallbackMode = true;
        if (this.selectionConfig.camera && this.selectionConfig.isUseCustomCamera) {
            object = new Intent((Context)activity, PictureCustomCameraActivity.class);
        } else {
            object = this.selectionConfig.camera ? PictureSelectorCameraEmptyActivity.class : (this.selectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class);
            object = new Intent((Context)activity, (Class)object);
        }
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivity((Intent)object);
        } else {
            activity.startActivity((Intent)object);
        }
        activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
    }

    public PictureSelectionModel freeStyleCropEnabled(boolean bl) {
        this.selectionConfig.freeStyleCropEnabled = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel glideOverride(int n, int n2) {
        this.selectionConfig.overrideWidth = n;
        this.selectionConfig.overrideHeight = n2;
        return this;
    }

    public PictureSelectionModel hideBottomControls(boolean bl) {
        this.selectionConfig.hideBottomControls = bl;
        return this;
    }

    public PictureSelectionModel imageEngine(ImageEngine imageEngine) {
        if (PictureSelectionConfig.imageEngine == imageEngine) return this;
        PictureSelectionConfig.imageEngine = imageEngine;
        return this;
    }

    public PictureSelectionModel imageFormat(String string) {
        String string2;
        block7: {
            block6: {
                if (SdkVersionUtils.checkedAndroid_Q()) break block6;
                string2 = string;
                if (!SdkVersionUtils.checkedAndroid_R()) break block7;
            }
            string2 = string;
            if (TextUtils.equals((CharSequence)string, (CharSequence)".png")) {
                string2 = "image/png";
            }
            string = string2;
            if (TextUtils.equals((CharSequence)string2, (CharSequence)".jpeg")) {
                string = "image/jpeg";
            }
            string2 = string;
            if (TextUtils.equals((CharSequence)string, (CharSequence)".mp4")) {
                string2 = "video/mp4";
            }
        }
        this.selectionConfig.suffixType = string2;
        return this;
    }

    public PictureSelectionModel imageSpanCount(int n) {
        this.selectionConfig.imageSpanCount = n;
        return this;
    }

    public PictureSelectionModel isAndroidQTransform(boolean bl) {
        this.selectionConfig.isAndroidQTransform = bl;
        return this;
    }

    public PictureSelectionModel isAutoRotating(boolean bl) {
        this.selectionConfig.isAutoRotating = bl;
        return this;
    }

    public PictureSelectionModel isAutomaticTitleRecyclerTop(boolean bl) {
        this.selectionConfig.isAutomaticTitleRecyclerTop = bl;
        return this;
    }

    public PictureSelectionModel isBmp(boolean bl) {
        this.selectionConfig.isBmp = bl;
        return this;
    }

    public PictureSelectionModel isCamera(boolean bl) {
        this.selectionConfig.isCamera = bl;
        return this;
    }

    public PictureSelectionModel isCameraAroundState(boolean bl) {
        this.selectionConfig.isCameraAroundState = bl;
        return this;
    }

    public PictureSelectionModel isCameraRotateImage(boolean bl) {
        this.selectionConfig.isCameraRotateImage = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isChangeStatusBarFontColor(boolean bl) {
        this.selectionConfig.isChangeStatusBarFontColor = bl;
        return this;
    }

    public PictureSelectionModel isCompress(boolean bl) {
        this.selectionConfig.isCompress = bl;
        return this;
    }

    public PictureSelectionModel isDragFrame(boolean bl) {
        this.selectionConfig.isDragFrame = bl;
        return this;
    }

    public PictureSelectionModel isEnableCrop(boolean bl) {
        this.selectionConfig.enableCrop = bl;
        return this;
    }

    public PictureSelectionModel isEnablePreviewAudio(boolean bl) {
        this.selectionConfig.enablePreviewAudio = bl;
        return this;
    }

    public PictureSelectionModel isFallbackVersion(boolean bl) {
        this.selectionConfig.isFallbackVersion = bl;
        return this;
    }

    public PictureSelectionModel isFallbackVersion2(boolean bl) {
        this.selectionConfig.isFallbackVersion2 = bl;
        return this;
    }

    public PictureSelectionModel isFallbackVersion3(boolean bl) {
        this.selectionConfig.isFallbackVersion3 = bl;
        return this;
    }

    public PictureSelectionModel isGif(boolean bl) {
        this.selectionConfig.isGif = bl;
        return this;
    }

    public PictureSelectionModel isMaxSelectEnabledMask(boolean bl) {
        this.selectionConfig.isMaxSelectEnabledMask = bl;
        return this;
    }

    public PictureSelectionModel isMultipleRecyclerAnimation(boolean bl) {
        this.selectionConfig.isMultipleRecyclerAnimation = bl;
        return this;
    }

    public PictureSelectionModel isMultipleSkipCrop(boolean bl) {
        this.selectionConfig.isMultipleSkipCrop = bl;
        return this;
    }

    public PictureSelectionModel isNotPreviewDownload(boolean bl) {
        this.selectionConfig.isNotPreviewDownload = bl;
        return this;
    }

    public PictureSelectionModel isOpenClickSound(boolean bl) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        bl = !pictureSelectionConfig.camera && bl;
        pictureSelectionConfig.openClickSound = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isOpenStyleCheckNumMode(boolean bl) {
        this.selectionConfig.isOpenStyleCheckNumMode = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isOpenStyleNumComplete(boolean bl) {
        this.selectionConfig.isOpenStyleNumComplete = bl;
        return this;
    }

    public PictureSelectionModel isOriginalImageControl(boolean bl) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        bl = !pictureSelectionConfig.camera && this.selectionConfig.chooseMode != PictureMimeType.ofVideo() && this.selectionConfig.chooseMode != PictureMimeType.ofAudio() && bl;
        pictureSelectionConfig.isOriginalControl = bl;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean bl) {
        this.selectionConfig.isPageStrategy = bl;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean bl, int n) {
        this.selectionConfig.isPageStrategy = bl;
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        int n2 = n;
        if (n < 10) {
            n2 = 60;
        }
        pictureSelectionConfig.pageSize = n2;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean bl, int n, boolean bl2) {
        this.selectionConfig.isPageStrategy = bl;
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        int n2 = n;
        if (n < 10) {
            n2 = 60;
        }
        pictureSelectionConfig.pageSize = n2;
        this.selectionConfig.isFilterInvalidFile = bl2;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean bl, boolean bl2) {
        this.selectionConfig.isPageStrategy = bl;
        this.selectionConfig.isFilterInvalidFile = bl2;
        return this;
    }

    public PictureSelectionModel isPreviewEggs(boolean bl) {
        this.selectionConfig.previewEggs = bl;
        return this;
    }

    public PictureSelectionModel isPreviewImage(boolean bl) {
        this.selectionConfig.enablePreview = bl;
        return this;
    }

    public PictureSelectionModel isPreviewVideo(boolean bl) {
        this.selectionConfig.enPreviewVideo = bl;
        return this;
    }

    public PictureSelectionModel isQuickCapture(boolean bl) {
        this.selectionConfig.isQuickCapture = bl;
        return this;
    }

    public PictureSelectionModel isReturnEmpty(boolean bl) {
        this.selectionConfig.returnEmpty = bl;
        return this;
    }

    public PictureSelectionModel isSingleDirectReturn(boolean bl) {
        boolean bl2;
        block5: {
            boolean bl3;
            block4: {
                PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
                int n = pictureSelectionConfig.selectionMode;
                bl3 = false;
                bl2 = n == 1 && bl;
                pictureSelectionConfig.isSingleDirectReturn = bl2;
                pictureSelectionConfig = this.selectionConfig;
                if (pictureSelectionConfig.selectionMode != 1) break block4;
                bl2 = bl3;
                if (bl) break block5;
            }
            bl2 = bl3;
            if (this.selectionConfig.isOriginalControl) {
                bl2 = true;
            }
        }
        pictureSelectionConfig.isOriginalControl = bl2;
        return this;
    }

    public PictureSelectionModel isSyncCover(boolean bl) {
        this.selectionConfig.isSyncCover = bl;
        return this;
    }

    public PictureSelectionModel isUseCustomCamera(boolean bl) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        bl = Build.VERSION.SDK_INT > 19 && bl;
        pictureSelectionConfig.isUseCustomCamera = bl;
        return this;
    }

    public PictureSelectionModel isWeChatStyle(boolean bl) {
        this.selectionConfig.isWeChatStyle = bl;
        return this;
    }

    public PictureSelectionModel isWebp(boolean bl) {
        this.selectionConfig.isWebp = bl;
        return this;
    }

    public PictureSelectionModel isWithVideoImage(boolean bl) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        int n = pictureSelectionConfig.selectionMode;
        boolean bl2 = true;
        bl = n != 1 && this.selectionConfig.chooseMode == PictureMimeType.ofAll() && bl ? bl2 : false;
        pictureSelectionConfig.isWithVideoImage = bl;
        return this;
    }

    public PictureSelectionModel isZoomAnim(boolean bl) {
        this.selectionConfig.zoomAnim = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel loadCacheResourcesCallback(CacheResourcesEngine cacheResourcesEngine) {
        if (!SdkVersionUtils.checkedAndroid_Q()) return this;
        if (PictureSelectionConfig.cacheResourcesEngine == cacheResourcesEngine) return this;
        PictureSelectionConfig.cacheResourcesEngine = (CacheResourcesEngine)new WeakReference<CacheResourcesEngine>(cacheResourcesEngine).get();
        return this;
    }

    @Deprecated
    public PictureSelectionModel loadImageEngine(ImageEngine imageEngine) {
        if (PictureSelectionConfig.imageEngine == imageEngine) return this;
        PictureSelectionConfig.imageEngine = imageEngine;
        return this;
    }

    public PictureSelectionModel maxSelectNum(int n) {
        this.selectionConfig.maxSelectNum = n;
        return this;
    }

    public PictureSelectionModel maxVideoSelectNum(int n) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (pictureSelectionConfig.chooseMode == PictureMimeType.ofVideo()) {
            n = 0;
        }
        pictureSelectionConfig.maxVideoSelectNum = n;
        return this;
    }

    public PictureSelectionModel minSelectNum(int n) {
        this.selectionConfig.minSelectNum = n;
        return this;
    }

    public PictureSelectionModel minVideoSelectNum(int n) {
        this.selectionConfig.minVideoSelectNum = n;
        return this;
    }

    public PictureSelectionModel minimumCompressSize(int n) {
        this.selectionConfig.minimumCompressSize = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel openClickSound(boolean bl) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        bl = !pictureSelectionConfig.camera && bl;
        pictureSelectionConfig.openClickSound = bl;
        return this;
    }

    @Deprecated
    public void openExternalPreview(int n, String string, List<LocalMedia> list) {
        PictureSelector pictureSelector = this.selector;
        if (pictureSelector == null) throw new NullPointerException("This PictureSelector is Null");
        pictureSelector.externalPicturePreview(n, string, list, PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation);
    }

    public void openExternalPreview(int n, List<LocalMedia> list) {
        PictureSelector pictureSelector = this.selector;
        if (pictureSelector == null) throw new NullPointerException("This PictureSelector is Null");
        pictureSelector.externalPicturePreview(n, list, PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation);
    }

    @Deprecated
    public PictureSelectionModel previewEggs(boolean bl) {
        this.selectionConfig.previewEggs = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel previewImage(boolean bl) {
        this.selectionConfig.enablePreview = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel previewVideo(boolean bl) {
        this.selectionConfig.enPreviewVideo = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel queryFileSize(float f) {
        this.selectionConfig.filterFileSize = f;
        return this;
    }

    @Deprecated
    public PictureSelectionModel queryMaxFileSize(float f) {
        this.selectionConfig.filterFileSize = f;
        return this;
    }

    public PictureSelectionModel queryMimeTypeConditions(String ... stringArray) {
        this.selectionConfig.queryMimeTypeHashSet = stringArray != null && stringArray.length > 0 ? new HashSet<String>(Arrays.asList(stringArray)) : null;
        return this;
    }

    @Deprecated
    public PictureSelectionModel querySpecifiedFormatSuffix(String string) {
        this.selectionConfig.specifiedFormat = string;
        return this;
    }

    public PictureSelectionModel recordVideoMinSecond(int n) {
        this.selectionConfig.recordVideoMinSecond = n;
        return this;
    }

    public PictureSelectionModel recordVideoSecond(int n) {
        this.selectionConfig.recordVideoSecond = n;
        return this;
    }

    public PictureSelectionModel renameCompressFile(String string) {
        this.selectionConfig.renameCompressFileName = string;
        return this;
    }

    public PictureSelectionModel renameCropFileName(String string) {
        this.selectionConfig.renameCropFileName = string;
        return this;
    }

    public PictureSelectionModel rotateEnabled(boolean bl) {
        this.selectionConfig.rotateEnabled = bl;
        return this;
    }

    public PictureSelectionModel scaleEnabled(boolean bl) {
        this.selectionConfig.scaleEnabled = bl;
        return this;
    }

    public PictureSelectionModel selectionData(List<LocalMedia> list) {
        this.selectionConfig.selectionMedias = this.selectionConfig.selectionMode == 1 && this.selectionConfig.isSingleDirectReturn ? null : list;
        return this;
    }

    @Deprecated
    public PictureSelectionModel selectionMedia(List<LocalMedia> list) {
        this.selectionConfig.selectionMedias = this.selectionConfig.selectionMode == 1 && this.selectionConfig.isSingleDirectReturn ? null : list;
        return this;
    }

    public PictureSelectionModel selectionMode(int n) {
        this.selectionConfig.selectionMode = n;
        return this;
    }

    public PictureSelectionModel setButtonFeatures(int n) {
        this.selectionConfig.buttonFeatures = n;
        return this;
    }

    public PictureSelectionModel setCaptureLoadingColor(int n) {
        this.selectionConfig.captureLoadingColor = n;
        return this;
    }

    public PictureSelectionModel setCircleDimmedBorderColor(int n) {
        this.selectionConfig.circleDimmedBorderColor = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCircleDimmedColor(int n) {
        this.selectionConfig.circleDimmedColor = n;
        return this;
    }

    public PictureSelectionModel setCircleStrokeWidth(int n) {
        this.selectionConfig.circleStrokeWidth = n;
        return this;
    }

    public PictureSelectionModel setCropDimmedColor(int n) {
        this.selectionConfig.circleDimmedColor = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropStatusBarColorPrimaryDark(int n) {
        this.selectionConfig.cropStatusBarColorPrimaryDark = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropTitleBarBackgroundColor(int n) {
        this.selectionConfig.cropTitleBarBackgroundColor = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropTitleColor(int n) {
        this.selectionConfig.cropTitleColor = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setDownArrowDrawable(int n) {
        this.selectionConfig.downResId = n;
        return this;
    }

    public PictureSelectionModel setLanguage(int n) {
        this.selectionConfig.language = n;
        return this;
    }

    public PictureSelectionModel setOutputCameraPath(String string) {
        this.selectionConfig.outPutCameraPath = string;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setPictureCropStyle(PictureCropParameterStyle pictureCropParameterStyle) {
        PictureSelectionConfig.cropStyle = pictureCropParameterStyle != null ? pictureCropParameterStyle : PictureCropParameterStyle.ofDefaultCropStyle();
        return this;
    }

    @Deprecated
    public PictureSelectionModel setPictureStyle(PictureParameterStyle pictureParameterStyle) {
        if (pictureParameterStyle != null) {
            PictureSelectionConfig.style = pictureParameterStyle;
            if (this.selectionConfig.isWeChatStyle) return this;
            this.selectionConfig.isWeChatStyle = pictureParameterStyle.isNewSelectStyle;
        } else {
            PictureSelectionConfig.style = PictureParameterStyle.ofDefaultStyle();
        }
        return this;
    }

    public PictureSelectionModel setPictureUIStyle(PictureSelectorUIStyle pictureSelectorUIStyle) {
        if (pictureSelectorUIStyle == null) return this;
        PictureSelectionConfig.uiStyle = pictureSelectorUIStyle;
        if (this.selectionConfig.isWeChatStyle) return this;
        this.selectionConfig.isWeChatStyle = PictureSelectionConfig.uiStyle.isNewSelectStyle;
        return this;
    }

    public PictureSelectionModel setPictureWindowAnimationStyle(PictureWindowAnimationStyle pictureWindowAnimationStyle) {
        PictureSelectionConfig.windowAnimationStyle = pictureWindowAnimationStyle != null ? pictureWindowAnimationStyle : PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();
        return this;
    }

    public PictureSelectionModel setRecyclerAnimationMode(int n) {
        this.selectionConfig.animationMode = n;
        return this;
    }

    public PictureSelectionModel setRequestedOrientation(int n) {
        this.selectionConfig.requestedOrientation = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setStatusBarColorPrimaryDark(int n) {
        this.selectionConfig.pictureStatusBarColor = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setTitleBarBackgroundColor(int n) {
        this.selectionConfig.titleBarBackgroundColor = n;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setUpArrowDrawable(int n) {
        this.selectionConfig.upResId = n;
        return this;
    }

    public PictureSelectionModel showCropFrame(boolean bl) {
        this.selectionConfig.showCropFrame = bl;
        return this;
    }

    public PictureSelectionModel showCropGrid(boolean bl) {
        this.selectionConfig.showCropGrid = bl;
        return this;
    }

    @Deprecated
    public PictureSelectionModel sizeMultiplier(float f) {
        this.selectionConfig.sizeMultiplier = f;
        return this;
    }

    public PictureSelectionModel synOrAsy(boolean bl) {
        this.selectionConfig.synOrAsy = bl;
        return this;
    }

    public PictureSelectionModel theme(int n) {
        this.selectionConfig.themeStyleId = n;
        return this;
    }

    public PictureSelectionModel videoMaxSecond(int n) {
        this.selectionConfig.videoMaxSecond = n * 1000;
        return this;
    }

    public PictureSelectionModel videoMinSecond(int n) {
        this.selectionConfig.videoMinSecond = n * 1000;
        return this;
    }

    public PictureSelectionModel videoQuality(int n) {
        this.selectionConfig.videoQuality = n;
        return this;
    }

    public PictureSelectionModel withAspectRatio(int n, int n2) {
        this.selectionConfig.aspect_ratio_x = n;
        this.selectionConfig.aspect_ratio_y = n2;
        return this;
    }
}
