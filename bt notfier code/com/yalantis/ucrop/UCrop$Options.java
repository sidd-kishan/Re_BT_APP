/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$CompressFormat
 *  android.os.Bundle
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.yalantis.ucrop.model.AspectRatio
 */
package com.yalantis.ucrop;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.luck.picture.lib.entity.LocalMedia;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public static class UCrop.Options {
    public static final String EXTRA_ACTIVITY_ORIENTATION = "com.yalantis.ucrop.activityOrientation";
    public static final String EXTRA_ALLOWED_GESTURES = "com.yalantis.ucrop.AllowedGestures";
    public static final String EXTRA_ASPECT_RATIO_OPTIONS = "com.yalantis.ucrop.AspectRatioOptions";
    public static final String EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
    public static final String EXTRA_CAMERA = "com.yalantis.ucrop.isCamera";
    public static final String EXTRA_CIRCLE_DIMMED_LAYER = "com.yalantis.ucrop.CircleDimmedLayer";
    public static final String EXTRA_CIRCLE_STROKE_WIDTH_LAYER = "com.yalantis.ucrop.CircleStrokeWidth";
    public static final String EXTRA_COMPRESSION_FORMAT_NAME = "com.yalantis.ucrop.CompressionFormatName";
    public static final String EXTRA_COMPRESSION_QUALITY = "com.yalantis.ucrop.CompressionQuality";
    public static final String EXTRA_CROP_FRAME_COLOR = "com.yalantis.ucrop.CropFrameColor";
    public static final String EXTRA_CROP_FRAME_STROKE_WIDTH = "com.yalantis.ucrop.CropFrameStrokeWidth";
    public static final String EXTRA_CROP_GRID_COLOR = "com.yalantis.ucrop.CropGridColor";
    public static final String EXTRA_CROP_GRID_COLUMN_COUNT = "com.yalantis.ucrop.CropGridColumnCount";
    public static final String EXTRA_CROP_GRID_ROW_COUNT = "com.yalantis.ucrop.CropGridRowCount";
    public static final String EXTRA_CROP_GRID_STROKE_WIDTH = "com.yalantis.ucrop.CropGridStrokeWidth";
    public static final String EXTRA_CUT_CROP = "com.yalantis.ucrop.cuts";
    public static final String EXTRA_DIMMED_LAYER_BORDER_COLOR = "com.yalantis.ucrop.DimmedLayerBorderColor";
    public static final String EXTRA_DIMMED_LAYER_COLOR = "com.yalantis.ucrop.DimmedLayerColor";
    public static final String EXTRA_DRAG_CROP_FRAME = "com.yalantis.ucrop.DragCropFrame";
    public static final String EXTRA_FREE_STYLE_CROP = "com.yalantis.ucrop.FreeStyleCrop";
    public static final String EXTRA_HIDE_BOTTOM_CONTROLS = "com.yalantis.ucrop.HideBottomControls";
    public static final String EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";
    public static final String EXTRA_MAX_BITMAP_SIZE = "com.yalantis.ucrop.MaxBitmapSize";
    public static final String EXTRA_MAX_SCALE_MULTIPLIER = "com.yalantis.ucrop.MaxScaleMultiplier";
    public static final String EXTRA_MULTIPLE_RECYCLERANIMATION = ".isMultipleAnimation";
    public static final String EXTRA_NAV_BAR_COLOR = "com.yalantis.ucrop.navBarColor";
    public static final String EXTRA_OUTPUT_URI_LIST = "com.yalantis.ucrop.OutputUriList";
    public static final String EXTRA_RENAME_CROP_FILENAME = "com.yalantis.ucrop.RenameCropFileName";
    public static final String EXTRA_ROTATE = "com.yalantis.ucrop.rotate";
    public static final String EXTRA_SCALE = "com.yalantis.ucrop.scale";
    public static final String EXTRA_SHOW_CROP_FRAME = "com.yalantis.ucrop.ShowCropFrame";
    public static final String EXTRA_SHOW_CROP_GRID = "com.yalantis.ucrop.ShowCropGrid";
    public static final String EXTRA_SKIP_MULTIPLE_CROP = "com.yalantis.ucrop.skip_multiple_crop";
    public static final String EXTRA_STATUS_BAR_COLOR = "com.yalantis.ucrop.StatusBarColor";
    public static final String EXTRA_TOOL_BAR_COLOR = "com.yalantis.ucrop.ToolbarColor";
    public static final String EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE = "com.yalantis.ucrop.UcropColorControlsWidgetActive";
    public static final String EXTRA_UCROP_COLOR_WIDGET_ACTIVE = "com.yalantis.ucrop.UcropColorWidgetActive";
    public static final String EXTRA_UCROP_LOGO_COLOR = "com.yalantis.ucrop.UcropLogoColor";
    public static final String EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR = "com.yalantis.ucrop.UcropRootViewBackgroundColor";
    public static final String EXTRA_UCROP_TITLE_TEXT_TOOLBAR = "com.yalantis.ucrop.UcropToolbarTitleText";
    public static final String EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCancelDrawable";
    public static final String EXTRA_UCROP_WIDGET_COLOR_TOOLBAR = "com.yalantis.ucrop.UcropToolbarWidgetColor";
    public static final String EXTRA_UCROP_WIDGET_CROP_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCropDrawable";
    public static final String EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR = "com.yalantis.ucrop.openWhiteStatusBar";
    public static final String EXTRA_WINDOW_EXIT_ANIMATION = "com.yalantis.ucrop.WindowAnimation";
    public static final String EXTRA_WITH_VIDEO_IMAGE = "com.yalantis.ucrop.isWithVideoImage";
    private final Bundle mOptionBundle = new Bundle();

    public Bundle getOptionBundle() {
        return this.mOptionBundle;
    }

    public void isCamera(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_CAMERA, bl);
    }

    public void isMultipleRecyclerAnimation(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_MULTIPLE_RECYCLERANIMATION, bl);
    }

    public void isMultipleSkipCrop(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_SKIP_MULTIPLE_CROP, bl);
    }

    public void isOpenWhiteStatusBar(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR, bl);
    }

    public void isWithVideoImage(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_WITH_VIDEO_IMAGE, bl);
    }

    public void setActiveControlsWidgetColor(int n) {
        this.mOptionBundle.putInt(EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, n);
    }

    public void setActiveWidgetColor(int n) {
        this.mOptionBundle.putInt(EXTRA_UCROP_COLOR_WIDGET_ACTIVE, n);
    }

    public void setAllowedGestures(int n, int n2, int n3) {
        this.mOptionBundle.putIntArray(EXTRA_ALLOWED_GESTURES, new int[]{n, n2, n3});
    }

    public void setAspectRatioOptions(int n, AspectRatio ... aspectRatioArray) {
        if (n > aspectRatioArray.length) throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", n, aspectRatioArray.length));
        this.mOptionBundle.putInt(EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, n);
        this.mOptionBundle.putParcelableArrayList(EXTRA_ASPECT_RATIO_OPTIONS, new ArrayList<AspectRatio>(Arrays.asList(aspectRatioArray)));
    }

    public void setCircleDimmedLayer(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_CIRCLE_DIMMED_LAYER, bl);
    }

    public void setCircleStrokeWidth(int n) {
        if (n <= 0) return;
        this.mOptionBundle.putInt(EXTRA_CIRCLE_STROKE_WIDTH_LAYER, n);
    }

    public void setCompressionFormat(Bitmap.CompressFormat compressFormat) {
        this.mOptionBundle.putString(EXTRA_COMPRESSION_FORMAT_NAME, compressFormat.name());
    }

    public void setCompressionQuality(int n) {
        this.mOptionBundle.putInt(EXTRA_COMPRESSION_QUALITY, n);
    }

    public void setCropExitAnimation(int n) {
        this.mOptionBundle.putInt(EXTRA_WINDOW_EXIT_ANIMATION, n);
    }

    public void setCropFrameColor(int n) {
        this.mOptionBundle.putInt(EXTRA_CROP_FRAME_COLOR, n);
    }

    public void setCropFrameStrokeWidth(int n) {
        this.mOptionBundle.putInt(EXTRA_CROP_FRAME_STROKE_WIDTH, n);
    }

    public void setCropGridColor(int n) {
        this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLOR, n);
    }

    public void setCropGridColumnCount(int n) {
        this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLUMN_COUNT, n);
    }

    public void setCropGridRowCount(int n) {
        this.mOptionBundle.putInt(EXTRA_CROP_GRID_ROW_COUNT, n);
    }

    public void setCropGridStrokeWidth(int n) {
        this.mOptionBundle.putInt(EXTRA_CROP_GRID_STROKE_WIDTH, n);
    }

    public void setCutListData(ArrayList<LocalMedia> arrayList) {
        this.mOptionBundle.putParcelableArrayList(EXTRA_CUT_CROP, arrayList);
    }

    public void setDimmedLayerBorderColor(int n) {
        if (n == 0) return;
        this.mOptionBundle.putInt(EXTRA_DIMMED_LAYER_BORDER_COLOR, n);
    }

    public void setDimmedLayerColor(int n) {
        this.mOptionBundle.putInt(EXTRA_DIMMED_LAYER_COLOR, n);
    }

    public void setDragFrameEnabled(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_DRAG_CROP_FRAME, bl);
    }

    public void setFreeStyleCropEnabled(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_FREE_STYLE_CROP, bl);
    }

    public void setHideBottomControls(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_HIDE_BOTTOM_CONTROLS, bl);
    }

    public void setImageToCropBoundsAnimDuration(int n) {
        this.mOptionBundle.putInt(EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, n);
    }

    public void setLogoColor(int n) {
        this.mOptionBundle.putInt(EXTRA_UCROP_LOGO_COLOR, n);
    }

    public void setMaxBitmapSize(int n) {
        this.mOptionBundle.putInt(EXTRA_MAX_BITMAP_SIZE, n);
    }

    public void setMaxScaleMultiplier(float f) {
        this.mOptionBundle.putFloat(EXTRA_MAX_SCALE_MULTIPLIER, f);
    }

    public void setNavBarColor(int n) {
        if (n == 0) return;
        this.mOptionBundle.putInt(EXTRA_NAV_BAR_COLOR, n);
    }

    public void setRenameCropFileName(String string) {
        this.mOptionBundle.putString(EXTRA_RENAME_CROP_FILENAME, string);
    }

    public void setRequestedOrientation(int n) {
        this.mOptionBundle.putInt(EXTRA_ACTIVITY_ORIENTATION, n);
    }

    public void setRootViewBackgroundColor(int n) {
        this.mOptionBundle.putInt(EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, n);
    }

    public void setRotateEnabled(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_ROTATE, bl);
    }

    public void setScaleEnabled(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_SCALE, bl);
    }

    public void setShowCropFrame(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_FRAME, bl);
    }

    public void setShowCropGrid(boolean bl) {
        this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_GRID, bl);
    }

    public void setStatusBarColor(int n) {
        this.mOptionBundle.putInt(EXTRA_STATUS_BAR_COLOR, n);
    }

    public void setToolbarCancelDrawable(int n) {
        this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, n);
    }

    public void setToolbarColor(int n) {
        this.mOptionBundle.putInt(EXTRA_TOOL_BAR_COLOR, n);
    }

    public void setToolbarCropDrawable(int n) {
        this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CROP_DRAWABLE, n);
    }

    public void setToolbarTitle(String string) {
        this.mOptionBundle.putString(EXTRA_UCROP_TITLE_TEXT_TOOLBAR, string);
    }

    public void setToolbarWidgetColor(int n) {
        this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, n);
    }

    public void useSourceImageAspectRatio() {
        this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioX", 0.0f);
        this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioY", 0.0f);
    }

    public void withAspectRatio(float f, float f2) {
        this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioX", f);
        this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioY", f2);
    }

    public void withMaxResultSize(int n, int n2) {
        this.mOptionBundle.putInt("com.yalantis.ucrop.MaxSizeX", n);
        this.mOptionBundle.putInt("com.yalantis.ucrop.MaxSizeY", n2);
    }
}
