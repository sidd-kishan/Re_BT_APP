/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.luck.picture.lib.R$attr
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.style.PictureSelectorUIStyle
 *  com.luck.picture.lib.tools.AttrsUtils
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.DoubleUtils
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.StringUtils
 *  com.luck.picture.lib.tools.ToastUtils
 *  com.yalantis.ucrop.UCrop
 *  com.yalantis.ucrop.UCrop$Options
 */
package com.luck.picture.lib.manager;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureSelectorUIStyle;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.DoubleUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;

public class UCropManager {
    public static UCrop.Options basicOptions(Context context) {
        int n;
        int n2;
        int n3;
        boolean bl;
        PictureSelectionConfig pictureSelectionConfig = PictureSelectionConfig.getInstance();
        PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
        int n4 = 0;
        if (pictureSelectorUIStyle != null) {
            int n5 = PictureSelectionConfig.uiStyle.picture_navBarColor;
            boolean bl2 = PictureSelectionConfig.uiStyle.picture_statusBarChangeTextColor;
            int n6 = PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor != 0 ? PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor : 0;
            int n7 = PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor != 0 ? PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor : 0;
            bl = bl2;
            n3 = n6;
            n2 = n7;
            n = n5;
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextColor != 0) {
                n4 = PictureSelectionConfig.uiStyle.picture_top_titleTextColor;
                bl = bl2;
                n3 = n6;
                n2 = n7;
                n = n5;
            }
        } else if (PictureSelectionConfig.cropStyle != null) {
            int n8 = PictureSelectionConfig.cropStyle.cropNavBarColor;
            boolean bl3 = PictureSelectionConfig.cropStyle.isChangeStatusBarFontColor;
            int n9 = PictureSelectionConfig.cropStyle.cropTitleBarBackgroundColor != 0 ? PictureSelectionConfig.cropStyle.cropTitleBarBackgroundColor : 0;
            int n10 = PictureSelectionConfig.cropStyle.cropStatusBarColorPrimaryDark != 0 ? PictureSelectionConfig.cropStyle.cropStatusBarColorPrimaryDark : 0;
            bl = bl3;
            n3 = n9;
            n2 = n10;
            n = n8;
            if (PictureSelectionConfig.cropStyle.cropTitleColor != 0) {
                n4 = PictureSelectionConfig.cropStyle.cropTitleColor;
                bl = bl3;
                n3 = n9;
                n2 = n10;
                n = n8;
            }
        } else {
            boolean bl4;
            bl = bl4 = pictureSelectionConfig.isChangeStatusBarFontColor;
            if (!bl4) {
                bl = AttrsUtils.getTypeValueBoolean((Context)context, (int)R.attr.picture_statusFontColor);
            }
            n3 = pictureSelectionConfig.cropTitleBarBackgroundColor != 0 ? pictureSelectionConfig.cropTitleBarBackgroundColor : AttrsUtils.getTypeValueColor((Context)context, (int)R.attr.picture_crop_toolbar_bg);
            n2 = pictureSelectionConfig.cropStatusBarColorPrimaryDark != 0 ? pictureSelectionConfig.cropStatusBarColorPrimaryDark : AttrsUtils.getTypeValueColor((Context)context, (int)R.attr.picture_crop_status_color);
            n4 = pictureSelectionConfig.cropTitleColor != 0 ? pictureSelectionConfig.cropTitleColor : AttrsUtils.getTypeValueColor((Context)context, (int)R.attr.picture_crop_title_color);
            n = 0;
        }
        context = pictureSelectionConfig.uCropOptions == null ? new UCrop.Options() : pictureSelectionConfig.uCropOptions;
        context.isOpenWhiteStatusBar(bl);
        context.setToolbarColor(n3);
        context.setStatusBarColor(n2);
        context.setToolbarWidgetColor(n4);
        context.setCircleDimmedLayer(pictureSelectionConfig.circleDimmedLayer);
        context.setDimmedLayerColor(pictureSelectionConfig.circleDimmedColor);
        context.setDimmedLayerBorderColor(pictureSelectionConfig.circleDimmedBorderColor);
        context.setCircleStrokeWidth(pictureSelectionConfig.circleStrokeWidth);
        context.setShowCropFrame(pictureSelectionConfig.showCropFrame);
        context.setDragFrameEnabled(pictureSelectionConfig.isDragFrame);
        context.setShowCropGrid(pictureSelectionConfig.showCropGrid);
        context.setScaleEnabled(pictureSelectionConfig.scaleEnabled);
        context.setRotateEnabled(pictureSelectionConfig.rotateEnabled);
        context.isMultipleSkipCrop(pictureSelectionConfig.isMultipleSkipCrop);
        context.setHideBottomControls(pictureSelectionConfig.hideBottomControls);
        context.setCompressionQuality(pictureSelectionConfig.cropCompressQuality);
        context.setRenameCropFileName(pictureSelectionConfig.renameCropFileName);
        context.setRequestedOrientation(pictureSelectionConfig.requestedOrientation);
        context.isCamera(pictureSelectionConfig.camera);
        context.setNavBarColor(n);
        context.isWithVideoImage(pictureSelectionConfig.isWithVideoImage);
        context.setFreeStyleCropEnabled(pictureSelectionConfig.freeStyleCropEnabled);
        context.setCropExitAnimation(PictureSelectionConfig.windowAnimationStyle.activityCropExitAnimation);
        context.withAspectRatio((float)pictureSelectionConfig.aspect_ratio_x, (float)pictureSelectionConfig.aspect_ratio_y);
        context.isMultipleRecyclerAnimation(pictureSelectionConfig.isMultipleRecyclerAnimation);
        if (pictureSelectionConfig.cropWidth <= 0) return context;
        if (pictureSelectionConfig.cropHeight <= 0) return context;
        context.withMaxResultSize(pictureSelectionConfig.cropWidth, pictureSelectionConfig.cropHeight);
        return context;
    }

    public static void ofCrop(Activity activity, String string2, String object) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            ToastUtils.s((Context)activity.getApplicationContext(), (String)activity.getString(R.string.picture_not_crop_data));
            return;
        }
        Object object2 = PictureSelectionConfig.getInstance();
        boolean bl = PictureMimeType.isHasHttp((String)string2);
        object = ((String)object).replace("image/", ".");
        String string3 = PictureFileUtils.getDiskCacheDir((Context)activity.getApplicationContext());
        if (TextUtils.isEmpty((CharSequence)((PictureSelectionConfig)object2).renameCropFileName)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(DateUtils.getCreateFileName((String)"IMG_CROP_"));
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
        } else {
            object = ((PictureSelectionConfig)object2).renameCropFileName;
        }
        object = new File(string3, (String)object);
        string2 = !bl && !SdkVersionUtils.checkedAndroid_Q() ? Uri.fromFile((File)new File(string2)) : Uri.parse((String)string2);
        string3 = UCropManager.basicOptions((Context)activity);
        UCrop.of((Uri)string2, (Uri)Uri.fromFile((File)object)).withOptions((UCrop.Options)string3).startAnimationActivity(activity, PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
    }

    public static void ofCrop(Activity activity, ArrayList<LocalMedia> uri) {
        Object object;
        int n;
        int n2;
        UCrop.Options options;
        Object object2;
        block6: {
            int n3;
            int n4;
            block7: {
                block5: {
                    if (DoubleUtils.isFastDoubleClick()) {
                        return;
                    }
                    if (uri == null || uri.size() == 0) break block5;
                    object2 = PictureSelectionConfig.getInstance();
                    options = UCropManager.basicOptions((Context)activity);
                    options.setCutListData(uri);
                    n2 = uri.size();
                    n4 = ((PictureSelectionConfig)object2).chooseMode;
                    int n5 = PictureMimeType.ofAll();
                    n = n3 = 0;
                    if (n4 != n5) break block6;
                    n = n3;
                    if (!((PictureSelectionConfig)object2).isWithVideoImage) break block6;
                    object = n2 > 0 ? uri.get(0).getMimeType() : "";
                    n = n3;
                    if (!PictureMimeType.isHasVideo((String)object)) break block6;
                    break block7;
                }
                ToastUtils.s((Context)activity.getApplicationContext(), (String)activity.getString(R.string.picture_not_crop_data));
                return;
            }
            n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                object = (LocalMedia)uri.get(n4);
                if (object != null && PictureMimeType.isHasImage((String)object.getMimeType())) {
                    n = n4;
                    break;
                }
                ++n4;
            }
        }
        if (n >= n2) return;
        object = uri.get(n);
        boolean bl = PictureMimeType.isHasHttp((String)object.getPath());
        uri = TextUtils.isEmpty((CharSequence)object.getAndroidQToPath()) ? (!bl && !SdkVersionUtils.checkedAndroid_Q() ? Uri.fromFile((File)new File(object.getPath())) : Uri.parse((String)object.getPath())) : Uri.fromFile((File)new File(object.getAndroidQToPath()));
        object = object.getMimeType().replace("image/", ".");
        String string2 = PictureFileUtils.getDiskCacheDir((Context)activity);
        if (TextUtils.isEmpty((CharSequence)((PictureSelectionConfig)object2).renameCropFileName)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(DateUtils.getCreateFileName((String)"IMG_CROP_"));
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
        } else {
            object = !((PictureSelectionConfig)object2).camera && n2 != 1 ? StringUtils.rename((String)((PictureSelectionConfig)object2).renameCropFileName) : ((PictureSelectionConfig)object2).renameCropFileName;
        }
        UCrop.of((Uri)uri, (Uri)Uri.fromFile((File)new File(string2, (String)object))).withOptions(options).startAnimationMultipleCropActivity(activity, PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
    }
}
