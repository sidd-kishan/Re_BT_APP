/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Environment
 *  android.text.TextUtils
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.core.content.ContextCompat
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.PictureMediaScannerConnection
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.immersive.ImmersiveManage
 *  com.luck.picture.lib.manager.UCropManager
 *  com.luck.picture.lib.permissions.PermissionChecker
 *  com.luck.picture.lib.tools.BitmapUtils
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.ToastUtils
 *  com.luck.picture.lib.tools.ValueOf
 *  com.yalantis.ucrop.UCrop
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Source
 */
package com.luck.picture.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.PictureMediaScannerConnection;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.manager.UCropManager;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.tools.BitmapUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.yalantis.ucrop.UCrop;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Objects;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class PictureSelectorCameraEmptyActivity
extends PictureBaseActivity {
    private void dispatchCameraHandleResult(LocalMedia localMedia) {
        boolean bl = PictureMimeType.isHasImage((String)localMedia.getMimeType());
        if (this.config.enableCrop && bl) {
            this.config.originalPath = this.config.cameraPath;
            UCropManager.ofCrop((Activity)this, (String)this.config.cameraPath, (String)localMedia.getMimeType());
        } else if (this.config.isCompress && bl) {
            ArrayList<LocalMedia> arrayList = new ArrayList<LocalMedia>();
            arrayList.add(localMedia);
            this.compressImage(arrayList);
        } else {
            ArrayList<LocalMedia> arrayList = new ArrayList<LocalMedia>();
            arrayList.add(localMedia);
            this.onResult(arrayList);
        }
    }

    private void onTakePhoto() {
        if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.CAMERA")) {
            boolean bl;
            boolean bl2 = bl = true;
            if (this.config != null) {
                bl2 = bl;
                if (this.config.isUseCustomCamera) {
                    bl2 = PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.RECORD_AUDIO");
                }
            }
            if (bl2) {
                this.startCamera();
            } else {
                PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.RECORD_AUDIO"}, (int)4);
            }
        } else {
            PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.CAMERA"}, (int)2);
        }
    }

    private void setActivitySize() {
        Window window = this.getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.height = 1;
        layoutParams.width = 1;
        window.setAttributes(layoutParams);
    }

    private void startCamera() {
        int n = this.config.chooseMode;
        if (n != 0 && n != 1) {
            if (n != 2) {
                if (n != 3) return;
                this.startOpenCameraAudio();
            } else {
                this.startOpenCameraVideo();
            }
        } else {
            this.startOpenCamera();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected void dispatchHandleCamera(Intent var1_1) {
        block38: {
            block39: {
                try {
                    var2_6 = this.config.chooseMode;
                    var3_7 = PictureMimeType.ofAudio();
                    var10_8 = null;
                    var8_9 = null;
                    if (var2_6 == var3_7) {
                        this.config.cameraMimeType = PictureMimeType.ofAudio();
                        this.config.cameraPath = this.getAudioPath(var1_1 /* !! */ );
                        if (TextUtils.isEmpty((CharSequence)this.config.cameraPath)) {
                            return;
                        }
                        var4_10 = SdkVersionUtils.checkedAndroid_R();
                        if (var4_10) {
                        }
                    }
                    ** GOTO lbl54
                }
                catch (Exception var1_5) {
                    var1_5.printStackTrace();
                    break block38;
                }
                var9_11 = MediaUtils.createAudioUri((Context)this.getContext(), (String)this.config.suffixType);
                if (var9_11 == null) ** GOTO lbl40
                var8_9 = var7_14 = Okio.buffer((Source)Okio.source((InputStream)Objects.requireNonNull(this.getContentResolver().openInputStream(Uri.parse((String)this.config.cameraPath)))));
lbl-1000:
                // 2 sources

                {
                    block40: {
                        while (true) {
                            PictureFileUtils.close((Closeable)var7_14);
                            ** GOTO lbl54
                            break;
                        }
                        catch (Throwable var1_2) {
                            ** GOTO lbl50
                        }
                        catch (Exception var9_13) {
                            var7_14 = null;
                            break block39;
                        }
                        try {
                            PictureFileUtils.bufferCopy((BufferedSource)var7_14, (OutputStream)this.getContentResolver().openOutputStream((Uri)var9_11));
                            var8_9 = var7_14;
                            this.config.cameraPath = var9_11.toString();
                            break block40;
                        }
                        catch (Exception var9_12) {
                            break block39;
                        }
lbl40:
                        // 1 sources

                        var7_14 = null;
                    }
                    if (var7_14 == null || !var7_14.isOpen()) ** GOTO lbl54
                    ** GOTO lbl-1000
                }
            }
            var8_9 = var7_14;
            {
                var9_11.printStackTrace();
            }
            {
                block41: {
                    if (var7_14 != null && var7_14.isOpen()) {
                        ** continue;
                    }
                    break block41;
lbl50:
                    // 1 sources

                    if (var8_9 == null) throw var1_4;
                    if (var8_9.isOpen() == false) throw var1_4;
                    PictureFileUtils.close((Closeable)var8_9);
                    throw var1_4;
                }
                if (TextUtils.isEmpty((CharSequence)this.config.cameraPath)) {
                    return;
                }
                var9_11 = new LocalMedia();
                if (PictureMimeType.isContent((String)this.config.cameraPath)) {
                    var7_14 = PictureFileUtils.getPath((Context)this.getContext(), (Uri)Uri.parse((String)this.config.cameraPath));
                    var11_15 = new File((String)var7_14);
                    var8_9 = PictureMimeType.getMimeType((int)this.config.cameraMimeType);
                    var9_11.setSize(var11_15.length());
                    if (PictureMimeType.isHasImage((String)var8_9)) {
                        var11_15 = MediaUtils.getImageSize((Context)this.getContext(), (String)this.config.cameraPath);
                        var9_11.setWidth(var11_15.getWidth());
                        var9_11.setHeight(var11_15.getHeight());
                    } else if (PictureMimeType.isHasVideo((String)var8_9)) {
                        var11_15 = MediaUtils.getVideoSize((Context)this.getContext(), (String)this.config.cameraPath);
                        var9_11.setWidth(var11_15.getWidth());
                        var9_11.setHeight(var11_15.getHeight());
                        var9_11.setDuration(var11_15.getDuration());
                    } else if (PictureMimeType.isHasAudio((String)var8_9)) {
                        var9_11.setDuration(MediaUtils.getAudioSize((Context)this.getContext(), (String)this.config.cameraPath).getDuration());
                    }
                    var2_6 = this.config.cameraPath.lastIndexOf("/") + 1;
                    var5_16 = var2_6 > 0 ? ValueOf.toLong((Object)this.config.cameraPath.substring(var2_6)) : -1L;
                    var9_11.setId(var5_16);
                    var9_11.setRealPath((String)var7_14);
                    var7_14 = var10_8;
                    if (var1_1 /* !! */  != null) {
                        var7_14 = var1_1 /* !! */ .getStringExtra("mediaPath");
                    }
                    var9_11.setAndroidQToPath((String)var7_14);
                    var1_1 /* !! */  = var8_9;
                } else {
                    var7_14 = new File(this.config.cameraPath);
                    var1_1 /* !! */  = PictureMimeType.getMimeType((int)this.config.cameraMimeType);
                    var9_11.setSize(var7_14.length());
                    if (PictureMimeType.isHasImage((String)var1_1 /* !! */ )) {
                        BitmapUtils.rotateImage((Context)this.getContext(), (boolean)this.config.isCameraRotateImage, (String)this.config.cameraPath);
                        var7_14 = MediaUtils.getImageSize((Context)this.getContext(), (String)this.config.cameraPath);
                        var9_11.setWidth(var7_14.getWidth());
                        var9_11.setHeight(var7_14.getHeight());
                    } else if (PictureMimeType.isHasVideo((String)var1_1 /* !! */ )) {
                        var7_14 = MediaUtils.getVideoSize((Context)this.getContext(), (String)this.config.cameraPath);
                        var9_11.setWidth(var7_14.getWidth());
                        var9_11.setHeight(var7_14.getHeight());
                        var9_11.setDuration(var7_14.getDuration());
                    } else if (PictureMimeType.isHasAudio((String)var1_1 /* !! */ )) {
                        var9_11.setDuration(MediaUtils.getAudioSize((Context)this.getContext(), (String)this.config.cameraPath).getDuration());
                    }
                    var9_11.setId(System.currentTimeMillis());
                    var9_11.setRealPath(this.config.cameraPath);
                }
                var9_11.setPath(this.config.cameraPath);
                var9_11.setMimeType((String)var1_1 /* !! */ );
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isHasVideo((String)var9_11.getMimeType())) {
                    var9_11.setParentFolderName(Environment.DIRECTORY_MOVIES);
                } else {
                    var9_11.setParentFolderName("Camera");
                }
                var9_11.setChooseModel(this.config.chooseMode);
                var9_11.setBucketId(MediaUtils.getCameraFirstBucketId((Context)this.getContext()));
                var9_11.setDateAddedTime(DateUtils.getCurrentTimeMillis());
                this.dispatchCameraHandleResult(var9_11);
                var4_10 = SdkVersionUtils.checkedAndroid_Q();
                if (var4_10) {
                    if (PictureMimeType.isHasVideo((String)var9_11.getMimeType()) == false) return;
                    if (PictureMimeType.isContent((String)this.config.cameraPath) == false) return;
                    if (this.config.isFallbackVersion3) {
                        new PictureMediaScannerConnection(this.getContext(), var9_11.getRealPath());
                    } else {
                        var7_14 = new File(var9_11.getRealPath());
                        var1_1 /* !! */  = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile((File)var7_14));
                        this.sendBroadcast(var1_1 /* !! */ );
                    }
                } else {
                    if (this.config.isFallbackVersion3) {
                        new PictureMediaScannerConnection(this.getContext(), this.config.cameraPath);
                    } else {
                        var7_14 = new File(this.config.cameraPath);
                        var1_1 /* !! */  = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile((File)var7_14));
                        this.sendBroadcast(var1_1 /* !! */ );
                    }
                    if (PictureMimeType.isHasImage((String)var9_11.getMimeType()) == false) return;
                    var2_6 = MediaUtils.getDCIMLastImageId((Context)this.getContext());
                    if (var2_6 == -1) return;
                    MediaUtils.removeMedia((Context)this.getContext(), (int)var2_6);
                }
            }
        }
    }

    public int getResourceId() {
        return R.layout.picture_empty;
    }

    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23((AppCompatActivity)this, (int)ContextCompat.getColor((Context)this, (int)R.color.picture_color_transparent), (int)ContextCompat.getColor((Context)this, (int)R.color.picture_color_transparent), (boolean)this.openWhiteStatusBar);
    }

    protected void onActivityResult(int n, int n2, Intent object) {
        super.onActivityResult(n, n2, (Intent)object);
        if (n2 == -1) {
            if (n != 69) {
                if (n != 909) return;
                this.dispatchHandleCamera((Intent)object);
            } else {
                this.singleCropHandleResult((Intent)object);
            }
        } else if (n2 == 0) {
            if (PictureSelectionConfig.listener != null) {
                PictureSelectionConfig.listener.onCancel();
            }
            if (n == 909) {
                MediaUtils.deleteCamera((Context)this, (String)this.config.cameraPath);
            }
            this.exit();
        } else {
            if (n2 != 96) return;
            if (object == null) {
                return;
            }
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
        this.exit();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.config == null) {
            this.exit();
            return;
        }
        if (this.config.isUseCustomCamera) return;
        this.setActivitySize();
        if (bundle != null) return;
        if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.READ_EXTERNAL_STORAGE") && PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
                if (this.config.chooseMode == 2) {
                    PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(this.getContext(), this.config, 2);
                } else {
                    PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(this.getContext(), this.config, 1);
                }
            } else {
                this.onTakePhoto();
            }
        } else {
            PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, (int)1);
        }
    }

    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        super.onRequestPermissionsResult(n, stringArray, nArray);
        if (n != 1) {
            if (n != 2) {
                if (n != 4) return;
                if (nArray.length > 0 && nArray[0] == 0) {
                    this.onTakePhoto();
                } else {
                    this.exit();
                    ToastUtils.s((Context)this.getContext(), (String)this.getString(R.string.picture_audio));
                }
            } else if (nArray.length > 0 && nArray[0] == 0) {
                this.onTakePhoto();
            } else {
                this.exit();
                ToastUtils.s((Context)this.getContext(), (String)this.getString(R.string.picture_camera));
            }
        } else if (nArray.length > 0 && nArray[0] == 0) {
            PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.CAMERA"}, (int)2);
        } else {
            ToastUtils.s((Context)this.getContext(), (String)this.getString(R.string.picture_jurisdiction));
            this.exit();
        }
    }

    protected void singleCropHandleResult(Intent object) {
        if (object == null) {
            return;
        }
        ArrayList<LocalMedia> arrayList = new ArrayList<LocalMedia>();
        if ((object = UCrop.getOutput((Intent)object)) == null) {
            return;
        }
        String string2 = object.getPath();
        boolean bl = TextUtils.isEmpty((CharSequence)string2);
        LocalMedia localMedia = new LocalMedia(this.config.cameraPath, 0L, false, this.config.isCamera ? 1 : 0, 0, this.config.chooseMode);
        if (SdkVersionUtils.checkedAndroid_Q()) {
            int n = this.config.cameraPath.lastIndexOf("/") + 1;
            long l = n > 0 ? ValueOf.toLong((Object)this.config.cameraPath.substring(n)) : -1L;
            localMedia.setId(l);
            localMedia.setAndroidQToPath(string2);
            if (bl) {
                if (PictureMimeType.isContent((String)this.config.cameraPath)) {
                    object = PictureFileUtils.getPath((Context)this, (Uri)Uri.parse((String)this.config.cameraPath));
                    l = !TextUtils.isEmpty((CharSequence)object) ? new File((String)object).length() : 0L;
                    localMedia.setSize(l);
                } else {
                    localMedia.setSize(new File(this.config.cameraPath).length());
                }
            } else {
                localMedia.setSize(new File(string2).length());
            }
        } else {
            localMedia.setId(System.currentTimeMillis());
            object = bl ? localMedia.getPath() : string2;
            localMedia.setSize(new File((String)object).length());
        }
        localMedia.setCut(bl ^ true);
        localMedia.setCutPath(string2);
        localMedia.setMimeType(PictureMimeType.getImageMimeType((String)string2));
        if (PictureMimeType.isContent((String)localMedia.getPath())) {
            localMedia.setRealPath(PictureFileUtils.getPath((Context)this.getContext(), (Uri)Uri.parse((String)localMedia.getPath())));
            if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                object = MediaUtils.getVideoSize((Context)this.getContext(), (String)localMedia.getPath());
                localMedia.setWidth(object.getWidth());
                localMedia.setHeight(object.getHeight());
            } else if (PictureMimeType.isHasImage((String)localMedia.getMimeType())) {
                object = MediaUtils.getImageSize((Context)this.getContext(), (String)localMedia.getPath());
                localMedia.setWidth(object.getWidth());
                localMedia.setHeight(object.getHeight());
            }
        } else {
            localMedia.setRealPath(localMedia.getPath());
            if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                object = MediaUtils.getVideoSize((Context)this.getContext(), (String)localMedia.getPath());
                localMedia.setWidth(object.getWidth());
                localMedia.setHeight(object.getHeight());
            } else if (PictureMimeType.isHasImage((String)localMedia.getMimeType())) {
                object = MediaUtils.getImageSize((Context)this.getContext(), (String)localMedia.getPath());
                localMedia.setWidth(object.getWidth());
                localMedia.setHeight(object.getHeight());
            }
        }
        arrayList.add(localMedia);
        this.handlerResult(arrayList);
    }
}
