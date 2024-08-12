/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.luck.picture.lib.R$style
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig$InstanceHolder
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
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.yalantis.ucrop.UCrop$Options
 */
package com.luck.picture.lib.config;

import android.os.Parcel;
import android.os.Parcelable;
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
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.yalantis.ucrop.UCrop;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public final class PictureSelectionConfig
implements Parcelable {
    public static final Parcelable.Creator<PictureSelectionConfig> CREATOR;
    public static CacheResourcesEngine cacheResourcesEngine;
    public static CompressEngine compressEngine;
    public static PictureCropParameterStyle cropStyle;
    public static OnVideoSelectedPlayCallback<LocalMedia> customVideoPlayCallback;
    public static ImageEngine imageEngine;
    public static OnResultCallbackListener<LocalMedia> listener;
    public static OnCustomCameraInterfaceListener onCustomCameraInterfaceListener;
    public static OnCustomImagePreviewCallback<LocalMedia> onCustomImagePreviewCallback;
    public static OnPermissionsObtainCallback onPermissionsObtainCallback;
    @Deprecated
    public static PictureParameterStyle style;
    public static PictureSelectorUIStyle uiStyle;
    public static PictureWindowAnimationStyle windowAnimationStyle;
    public int animationMode;
    public int aspect_ratio_x;
    public int aspect_ratio_y;
    public int buttonFeatures;
    public boolean camera;
    public String cameraFileName;
    public int cameraMimeType;
    public String cameraPath;
    public int captureLoadingColor;
    public boolean checkNumMode;
    public int chooseMode = PictureMimeType.ofImage();
    public int circleDimmedBorderColor;
    public int circleDimmedColor;
    public boolean circleDimmedLayer;
    public int circleStrokeWidth;
    public int compressQuality;
    public String compressSavePath;
    public int cropCompressQuality;
    public int cropHeight;
    @Deprecated
    public int cropStatusBarColorPrimaryDark;
    @Deprecated
    public int cropTitleBarBackgroundColor;
    @Deprecated
    public int cropTitleColor;
    public int cropWidth;
    @Deprecated
    public int downResId;
    public boolean enPreviewVideo;
    public boolean enableCrop;
    public boolean enablePreview;
    public boolean enablePreviewAudio;
    @Deprecated
    public float filterFileSize;
    public long filterMaxFileSize;
    public long filterMinFileSize;
    public boolean focusAlpha;
    public boolean freeStyleCropEnabled;
    public boolean hideBottomControls;
    public int imageSpanCount;
    @Deprecated
    public boolean isAndroidQChangeVideoWH;
    @Deprecated
    public boolean isAndroidQChangeWH;
    public boolean isAndroidQTransform;
    public boolean isAutoRotating;
    public boolean isAutomaticTitleRecyclerTop;
    public boolean isBmp;
    public boolean isCallbackMode;
    public boolean isCamera;
    public boolean isCameraAroundState;
    public boolean isCameraRotateImage;
    @Deprecated
    public boolean isChangeStatusBarFontColor;
    public boolean isCheckOriginalImage;
    public boolean isCompress;
    public boolean isDragFrame;
    public boolean isFallbackVersion;
    public boolean isFallbackVersion2;
    public boolean isFallbackVersion3;
    public boolean isFilterInvalidFile;
    public boolean isGif;
    public boolean isMaxSelectEnabledMask;
    public boolean isMultipleRecyclerAnimation;
    public boolean isMultipleSkipCrop;
    public boolean isNotPreviewDownload;
    @Deprecated
    public boolean isOpenStyleCheckNumMode;
    @Deprecated
    public boolean isOpenStyleNumComplete;
    public boolean isOriginalControl;
    public boolean isPageStrategy;
    public boolean isQuickCapture;
    public boolean isSingleDirectReturn;
    public boolean isSyncCover;
    public boolean isUseCustomCamera;
    public boolean isWeChatStyle;
    public boolean isWebp;
    public boolean isWithVideoImage;
    public int language;
    public int maxSelectNum;
    public int maxVideoSelectNum;
    public int minSelectNum;
    public int minVideoSelectNum;
    public int minimumCompressSize;
    public boolean openClickSound;
    public String originalPath;
    public String outPutCameraPath;
    @Deprecated
    public int overrideHeight;
    @Deprecated
    public int overrideWidth;
    public int pageSize;
    @Deprecated
    public int pictureStatusBarColor;
    public boolean previewEggs;
    public HashSet<String> queryMimeTypeHashSet;
    public int recordVideoMinSecond;
    public int recordVideoSecond;
    public String renameCompressFileName;
    public String renameCropFileName;
    public int requestedOrientation;
    public boolean returnEmpty;
    public boolean rotateEnabled;
    public boolean scaleEnabled;
    public List<LocalMedia> selectionMedias;
    public int selectionMode;
    public boolean showCropFrame;
    public boolean showCropGrid;
    @Deprecated
    public float sizeMultiplier;
    @Deprecated
    public String specifiedFormat;
    public String suffixType;
    public boolean synOrAsy;
    public int themeStyleId;
    @Deprecated
    public int titleBarBackgroundColor;
    public UCrop.Options uCropOptions;
    @Deprecated
    public int upResId;
    public int videoMaxSecond;
    public int videoMinSecond;
    public int videoQuality;
    public boolean zoomAnim;

    static {
        windowAnimationStyle = PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();
        CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    }

    public PictureSelectionConfig() {
        this.camera = false;
        this.requestedOrientation = -1;
        this.buttonFeatures = 259;
        this.themeStyleId = R.style.picture_default_style;
        this.selectionMode = 2;
        this.maxSelectNum = 9;
        this.minSelectNum = 0;
        this.maxVideoSelectNum = 1;
        this.minVideoSelectNum = 0;
        this.videoQuality = 1;
        this.cropCompressQuality = 90;
        this.recordVideoSecond = 60;
        this.minimumCompressSize = 100;
        this.imageSpanCount = 4;
        this.compressQuality = 80;
        this.filterMinFileSize = 1024L;
        this.isCamera = true;
        this.cameraMimeType = -1;
        this.pageSize = 60;
        this.isPageStrategy = true;
        this.animationMode = -1;
        this.isAutomaticTitleRecyclerTop = true;
        this.isQuickCapture = true;
        this.isCameraRotateImage = true;
        this.isAutoRotating = true;
        this.isSyncCover = false;
    }

    protected PictureSelectionConfig(Parcel parcel) {
        boolean bl = false;
        this.camera = false;
        this.requestedOrientation = -1;
        this.buttonFeatures = 259;
        this.themeStyleId = R.style.picture_default_style;
        this.selectionMode = 2;
        this.maxSelectNum = 9;
        this.minSelectNum = 0;
        this.maxVideoSelectNum = 1;
        this.minVideoSelectNum = 0;
        this.videoQuality = 1;
        this.cropCompressQuality = 90;
        this.recordVideoSecond = 60;
        this.minimumCompressSize = 100;
        this.imageSpanCount = 4;
        this.compressQuality = 80;
        this.filterMinFileSize = 1024L;
        this.isCamera = true;
        this.cameraMimeType = -1;
        this.pageSize = 60;
        this.isPageStrategy = true;
        this.animationMode = -1;
        this.isAutomaticTitleRecyclerTop = true;
        this.isQuickCapture = true;
        this.isCameraRotateImage = true;
        this.isAutoRotating = true;
        this.isSyncCover = false;
        this.chooseMode = parcel.readInt();
        boolean bl2 = parcel.readByte() != 0;
        this.camera = bl2;
        bl2 = parcel.readByte() != 0;
        this.isSingleDirectReturn = bl2;
        this.compressSavePath = parcel.readString();
        this.suffixType = parcel.readString();
        bl2 = parcel.readByte() != 0;
        this.focusAlpha = bl2;
        this.renameCompressFileName = parcel.readString();
        this.renameCropFileName = parcel.readString();
        this.specifiedFormat = parcel.readString();
        this.requestedOrientation = parcel.readInt();
        this.buttonFeatures = parcel.readInt();
        this.captureLoadingColor = parcel.readInt();
        bl2 = parcel.readByte() != 0;
        this.isCameraAroundState = bl2;
        bl2 = parcel.readByte() != 0;
        this.isAndroidQTransform = bl2;
        this.themeStyleId = parcel.readInt();
        this.selectionMode = parcel.readInt();
        this.maxSelectNum = parcel.readInt();
        this.minSelectNum = parcel.readInt();
        this.maxVideoSelectNum = parcel.readInt();
        this.minVideoSelectNum = parcel.readInt();
        this.videoQuality = parcel.readInt();
        this.cropCompressQuality = parcel.readInt();
        this.videoMaxSecond = parcel.readInt();
        this.videoMinSecond = parcel.readInt();
        this.recordVideoSecond = parcel.readInt();
        this.recordVideoMinSecond = parcel.readInt();
        this.minimumCompressSize = parcel.readInt();
        this.imageSpanCount = parcel.readInt();
        this.aspect_ratio_x = parcel.readInt();
        this.aspect_ratio_y = parcel.readInt();
        this.cropWidth = parcel.readInt();
        this.cropHeight = parcel.readInt();
        this.compressQuality = parcel.readInt();
        this.filterFileSize = parcel.readFloat();
        this.filterMaxFileSize = parcel.readLong();
        this.filterMinFileSize = parcel.readLong();
        this.language = parcel.readInt();
        bl2 = parcel.readByte() != 0;
        this.isMultipleRecyclerAnimation = bl2;
        bl2 = parcel.readByte() != 0;
        this.isMultipleSkipCrop = bl2;
        bl2 = parcel.readByte() != 0;
        this.isWeChatStyle = bl2;
        bl2 = parcel.readByte() != 0;
        this.isUseCustomCamera = bl2;
        bl2 = parcel.readByte() != 0;
        this.zoomAnim = bl2;
        bl2 = parcel.readByte() != 0;
        this.isCompress = bl2;
        bl2 = parcel.readByte() != 0;
        this.isOriginalControl = bl2;
        bl2 = parcel.readByte() != 0;
        this.isCamera = bl2;
        bl2 = parcel.readByte() != 0;
        this.isGif = bl2;
        bl2 = parcel.readByte() != 0;
        this.isWebp = bl2;
        bl2 = parcel.readByte() != 0;
        this.isBmp = bl2;
        bl2 = parcel.readByte() != 0;
        this.enablePreview = bl2;
        bl2 = parcel.readByte() != 0;
        this.enPreviewVideo = bl2;
        bl2 = parcel.readByte() != 0;
        this.enablePreviewAudio = bl2;
        bl2 = parcel.readByte() != 0;
        this.checkNumMode = bl2;
        bl2 = parcel.readByte() != 0;
        this.openClickSound = bl2;
        bl2 = parcel.readByte() != 0;
        this.enableCrop = bl2;
        bl2 = parcel.readByte() != 0;
        this.freeStyleCropEnabled = bl2;
        bl2 = parcel.readByte() != 0;
        this.circleDimmedLayer = bl2;
        this.circleDimmedColor = parcel.readInt();
        this.circleDimmedBorderColor = parcel.readInt();
        this.circleStrokeWidth = parcel.readInt();
        bl2 = parcel.readByte() != 0;
        this.showCropFrame = bl2;
        bl2 = parcel.readByte() != 0;
        this.showCropGrid = bl2;
        bl2 = parcel.readByte() != 0;
        this.hideBottomControls = bl2;
        bl2 = parcel.readByte() != 0;
        this.rotateEnabled = bl2;
        bl2 = parcel.readByte() != 0;
        this.scaleEnabled = bl2;
        bl2 = parcel.readByte() != 0;
        this.previewEggs = bl2;
        bl2 = parcel.readByte() != 0;
        this.synOrAsy = bl2;
        bl2 = parcel.readByte() != 0;
        this.returnEmpty = bl2;
        bl2 = parcel.readByte() != 0;
        this.isDragFrame = bl2;
        bl2 = parcel.readByte() != 0;
        this.isNotPreviewDownload = bl2;
        bl2 = parcel.readByte() != 0;
        this.isWithVideoImage = bl2;
        this.selectionMedias = parcel.createTypedArrayList(LocalMedia.CREATOR);
        this.cameraFileName = parcel.readString();
        bl2 = parcel.readByte() != 0;
        this.isCheckOriginalImage = bl2;
        this.overrideWidth = parcel.readInt();
        this.overrideHeight = parcel.readInt();
        this.sizeMultiplier = parcel.readFloat();
        bl2 = parcel.readByte() != 0;
        this.isChangeStatusBarFontColor = bl2;
        bl2 = parcel.readByte() != 0;
        this.isOpenStyleNumComplete = bl2;
        bl2 = parcel.readByte() != 0;
        this.isOpenStyleCheckNumMode = bl2;
        this.titleBarBackgroundColor = parcel.readInt();
        this.pictureStatusBarColor = parcel.readInt();
        this.cropTitleBarBackgroundColor = parcel.readInt();
        this.cropStatusBarColorPrimaryDark = parcel.readInt();
        this.cropTitleColor = parcel.readInt();
        this.upResId = parcel.readInt();
        this.downResId = parcel.readInt();
        this.outPutCameraPath = parcel.readString();
        this.originalPath = parcel.readString();
        this.cameraPath = parcel.readString();
        this.cameraMimeType = parcel.readInt();
        this.pageSize = parcel.readInt();
        bl2 = parcel.readByte() != 0;
        this.isPageStrategy = bl2;
        bl2 = parcel.readByte() != 0;
        this.isFilterInvalidFile = bl2;
        bl2 = parcel.readByte() != 0;
        this.isMaxSelectEnabledMask = bl2;
        this.animationMode = parcel.readInt();
        bl2 = parcel.readByte() != 0;
        this.isAutomaticTitleRecyclerTop = bl2;
        bl2 = parcel.readByte() != 0;
        this.isCallbackMode = bl2;
        bl2 = parcel.readByte() != 0;
        this.isAndroidQChangeWH = bl2;
        bl2 = parcel.readByte() != 0;
        this.isAndroidQChangeVideoWH = bl2;
        bl2 = parcel.readByte() != 0;
        this.isQuickCapture = bl2;
        bl2 = parcel.readByte() != 0;
        this.isCameraRotateImage = bl2;
        bl2 = parcel.readByte() != 0;
        this.isAutoRotating = bl2;
        bl2 = parcel.readByte() != 0;
        this.isSyncCover = bl2;
        bl2 = parcel.readByte() != 0;
        this.isFallbackVersion = bl2;
        bl2 = parcel.readByte() != 0;
        this.isFallbackVersion2 = bl2;
        bl2 = bl;
        if (parcel.readByte() != 0) {
            bl2 = true;
        }
        this.isFallbackVersion3 = bl2;
    }

    public static void destroy() {
        listener = null;
        customVideoPlayCallback = null;
        onCustomImagePreviewCallback = null;
        onCustomCameraInterfaceListener = null;
        onPermissionsObtainCallback = null;
        cacheResourcesEngine = null;
        imageEngine = null;
        compressEngine = null;
    }

    public static PictureSelectionConfig getCleanInstance() {
        PictureSelectionConfig pictureSelectionConfig = PictureSelectionConfig.getInstance();
        pictureSelectionConfig.initDefaultValue();
        return pictureSelectionConfig;
    }

    public static PictureSelectionConfig getInstance() {
        return InstanceHolder.access$000();
    }

    public int describeContents() {
        return 0;
    }

    protected void initDefaultValue() {
        this.chooseMode = PictureMimeType.ofImage();
        this.camera = false;
        this.themeStyleId = R.style.picture_default_style;
        this.selectionMode = 2;
        uiStyle = null;
        style = null;
        cropStyle = null;
        this.maxSelectNum = 9;
        this.minSelectNum = 0;
        this.maxVideoSelectNum = 1;
        this.minVideoSelectNum = 0;
        this.videoQuality = 1;
        this.language = -1;
        this.cropCompressQuality = 90;
        this.videoMaxSecond = 0;
        this.videoMinSecond = 0;
        this.filterFileSize = 0.0f;
        this.filterMaxFileSize = 0L;
        this.filterMinFileSize = 1024L;
        this.recordVideoSecond = 60;
        this.recordVideoMinSecond = 0;
        this.compressQuality = 80;
        this.imageSpanCount = 4;
        this.isCompress = false;
        this.isOriginalControl = false;
        this.aspect_ratio_x = 0;
        this.aspect_ratio_y = 0;
        this.cropWidth = 0;
        this.cropHeight = 0;
        this.isCameraAroundState = false;
        this.isWithVideoImage = false;
        this.isAndroidQTransform = false;
        this.isCamera = true;
        this.isGif = false;
        this.isWebp = true;
        this.isBmp = true;
        this.focusAlpha = false;
        this.isCheckOriginalImage = false;
        this.isSingleDirectReturn = false;
        this.enablePreview = true;
        this.enPreviewVideo = true;
        this.enablePreviewAudio = true;
        this.checkNumMode = false;
        this.isNotPreviewDownload = false;
        this.openClickSound = false;
        this.isFallbackVersion = false;
        this.isFallbackVersion2 = true;
        this.isFallbackVersion3 = true;
        this.enableCrop = false;
        this.isWeChatStyle = false;
        this.isUseCustomCamera = false;
        this.isMultipleSkipCrop = true;
        this.isMultipleRecyclerAnimation = true;
        this.freeStyleCropEnabled = false;
        this.circleDimmedLayer = false;
        this.showCropFrame = true;
        this.showCropGrid = true;
        this.hideBottomControls = true;
        this.rotateEnabled = true;
        this.scaleEnabled = true;
        this.previewEggs = false;
        this.returnEmpty = false;
        this.synOrAsy = true;
        this.zoomAnim = true;
        this.circleDimmedColor = 0;
        this.circleDimmedBorderColor = 0;
        this.circleStrokeWidth = 1;
        this.isDragFrame = true;
        this.compressSavePath = "";
        this.suffixType = "";
        this.cameraFileName = "";
        this.specifiedFormat = "";
        this.renameCompressFileName = "";
        this.renameCropFileName = "";
        this.queryMimeTypeHashSet = null;
        this.selectionMedias = new ArrayList<LocalMedia>();
        this.uCropOptions = null;
        this.titleBarBackgroundColor = 0;
        this.pictureStatusBarColor = 0;
        this.cropTitleBarBackgroundColor = 0;
        this.cropStatusBarColorPrimaryDark = 0;
        this.cropTitleColor = 0;
        this.upResId = 0;
        this.downResId = 0;
        this.isChangeStatusBarFontColor = false;
        this.isOpenStyleNumComplete = false;
        this.isOpenStyleCheckNumMode = false;
        this.outPutCameraPath = "";
        this.sizeMultiplier = 0.5f;
        this.overrideWidth = 0;
        this.overrideHeight = 0;
        this.originalPath = "";
        this.cameraPath = "";
        this.cameraMimeType = -1;
        this.pageSize = 60;
        this.isPageStrategy = true;
        this.isFilterInvalidFile = false;
        this.isMaxSelectEnabledMask = false;
        this.animationMode = -1;
        this.isAutomaticTitleRecyclerTop = true;
        this.isCallbackMode = false;
        this.isAndroidQChangeWH = true;
        this.isAndroidQChangeVideoWH = false;
        this.isQuickCapture = true;
        this.isCameraRotateImage = true;
        this.isAutoRotating = true;
        this.isSyncCover = SdkVersionUtils.checkedAndroid_Q() ^ true;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.chooseMode);
        parcel.writeByte((byte)(this.camera ? 1 : 0));
        parcel.writeByte((byte)(this.isSingleDirectReturn ? 1 : 0));
        parcel.writeString(this.compressSavePath);
        parcel.writeString(this.suffixType);
        parcel.writeByte((byte)(this.focusAlpha ? 1 : 0));
        parcel.writeString(this.renameCompressFileName);
        parcel.writeString(this.renameCropFileName);
        parcel.writeString(this.specifiedFormat);
        parcel.writeInt(this.requestedOrientation);
        parcel.writeInt(this.buttonFeatures);
        parcel.writeInt(this.captureLoadingColor);
        parcel.writeByte((byte)(this.isCameraAroundState ? 1 : 0));
        parcel.writeByte((byte)(this.isAndroidQTransform ? 1 : 0));
        parcel.writeInt(this.themeStyleId);
        parcel.writeInt(this.selectionMode);
        parcel.writeInt(this.maxSelectNum);
        parcel.writeInt(this.minSelectNum);
        parcel.writeInt(this.maxVideoSelectNum);
        parcel.writeInt(this.minVideoSelectNum);
        parcel.writeInt(this.videoQuality);
        parcel.writeInt(this.cropCompressQuality);
        parcel.writeInt(this.videoMaxSecond);
        parcel.writeInt(this.videoMinSecond);
        parcel.writeInt(this.recordVideoSecond);
        parcel.writeInt(this.recordVideoMinSecond);
        parcel.writeInt(this.minimumCompressSize);
        parcel.writeInt(this.imageSpanCount);
        parcel.writeInt(this.aspect_ratio_x);
        parcel.writeInt(this.aspect_ratio_y);
        parcel.writeInt(this.cropWidth);
        parcel.writeInt(this.cropHeight);
        parcel.writeInt(this.compressQuality);
        parcel.writeFloat(this.filterFileSize);
        parcel.writeLong(this.filterMaxFileSize);
        parcel.writeLong(this.filterMinFileSize);
        parcel.writeInt(this.language);
        parcel.writeByte((byte)(this.isMultipleRecyclerAnimation ? 1 : 0));
        parcel.writeByte((byte)(this.isMultipleSkipCrop ? 1 : 0));
        parcel.writeByte((byte)(this.isWeChatStyle ? 1 : 0));
        parcel.writeByte((byte)(this.isUseCustomCamera ? 1 : 0));
        parcel.writeByte((byte)(this.zoomAnim ? 1 : 0));
        parcel.writeByte((byte)(this.isCompress ? 1 : 0));
        parcel.writeByte((byte)(this.isOriginalControl ? 1 : 0));
        parcel.writeByte((byte)(this.isCamera ? 1 : 0));
        parcel.writeByte((byte)(this.isGif ? 1 : 0));
        parcel.writeByte((byte)(this.isWebp ? 1 : 0));
        parcel.writeByte((byte)(this.isBmp ? 1 : 0));
        parcel.writeByte((byte)(this.enablePreview ? 1 : 0));
        parcel.writeByte((byte)(this.enPreviewVideo ? 1 : 0));
        parcel.writeByte((byte)(this.enablePreviewAudio ? 1 : 0));
        parcel.writeByte((byte)(this.checkNumMode ? 1 : 0));
        parcel.writeByte((byte)(this.openClickSound ? 1 : 0));
        parcel.writeByte((byte)(this.enableCrop ? 1 : 0));
        parcel.writeByte((byte)(this.freeStyleCropEnabled ? 1 : 0));
        parcel.writeByte((byte)(this.circleDimmedLayer ? 1 : 0));
        parcel.writeInt(this.circleDimmedColor);
        parcel.writeInt(this.circleDimmedBorderColor);
        parcel.writeInt(this.circleStrokeWidth);
        parcel.writeByte((byte)(this.showCropFrame ? 1 : 0));
        parcel.writeByte((byte)(this.showCropGrid ? 1 : 0));
        parcel.writeByte((byte)(this.hideBottomControls ? 1 : 0));
        parcel.writeByte((byte)(this.rotateEnabled ? 1 : 0));
        parcel.writeByte((byte)(this.scaleEnabled ? 1 : 0));
        parcel.writeByte((byte)(this.previewEggs ? 1 : 0));
        parcel.writeByte((byte)(this.synOrAsy ? 1 : 0));
        parcel.writeByte((byte)(this.returnEmpty ? 1 : 0));
        parcel.writeByte((byte)(this.isDragFrame ? 1 : 0));
        parcel.writeByte((byte)(this.isNotPreviewDownload ? 1 : 0));
        parcel.writeByte((byte)(this.isWithVideoImage ? 1 : 0));
        parcel.writeTypedList(this.selectionMedias);
        parcel.writeString(this.cameraFileName);
        parcel.writeByte((byte)(this.isCheckOriginalImage ? 1 : 0));
        parcel.writeInt(this.overrideWidth);
        parcel.writeInt(this.overrideHeight);
        parcel.writeFloat(this.sizeMultiplier);
        parcel.writeByte((byte)(this.isChangeStatusBarFontColor ? 1 : 0));
        parcel.writeByte((byte)(this.isOpenStyleNumComplete ? 1 : 0));
        parcel.writeByte((byte)(this.isOpenStyleCheckNumMode ? 1 : 0));
        parcel.writeInt(this.titleBarBackgroundColor);
        parcel.writeInt(this.pictureStatusBarColor);
        parcel.writeInt(this.cropTitleBarBackgroundColor);
        parcel.writeInt(this.cropStatusBarColorPrimaryDark);
        parcel.writeInt(this.cropTitleColor);
        parcel.writeInt(this.upResId);
        parcel.writeInt(this.downResId);
        parcel.writeString(this.outPutCameraPath);
        parcel.writeString(this.originalPath);
        parcel.writeString(this.cameraPath);
        parcel.writeInt(this.cameraMimeType);
        parcel.writeInt(this.pageSize);
        parcel.writeByte((byte)(this.isPageStrategy ? 1 : 0));
        parcel.writeByte((byte)(this.isFilterInvalidFile ? 1 : 0));
        parcel.writeByte((byte)(this.isMaxSelectEnabledMask ? 1 : 0));
        parcel.writeInt(this.animationMode);
        parcel.writeByte((byte)(this.isAutomaticTitleRecyclerTop ? 1 : 0));
        parcel.writeByte((byte)(this.isCallbackMode ? 1 : 0));
        parcel.writeByte((byte)(this.isAndroidQChangeWH ? 1 : 0));
        parcel.writeByte((byte)(this.isAndroidQChangeVideoWH ? 1 : 0));
        parcel.writeByte((byte)(this.isQuickCapture ? 1 : 0));
        parcel.writeByte((byte)(this.isCameraRotateImage ? 1 : 0));
        parcel.writeByte((byte)(this.isAutoRotating ? 1 : 0));
        parcel.writeByte((byte)(this.isSyncCover ? 1 : 0));
        parcel.writeByte((byte)(this.isFallbackVersion ? 1 : 0));
        parcel.writeByte((byte)(this.isFallbackVersion2 ? 1 : 0));
        parcel.writeByte((byte)(this.isFallbackVersion3 ? 1 : 0));
    }
}
