/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.WindowManager$LayoutParams
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.luck.picture.lib.PictureSelectorCameraEmptyActivity
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib._$$Lambda$PictureCustomCameraActivity$9Bml8qgkRf9jYn2Ar2EWb6ypSt4
 *  com.luck.picture.lib._$$Lambda$PictureCustomCameraActivity$IsPjvXD_XOh7qOaPNJfnKp6ymRg
 *  com.luck.picture.lib._$$Lambda$PictureCustomCameraActivity$yCub_m_i_gS24q1UnyyJAqXH_RM
 *  com.luck.picture.lib.camera.CustomCameraView
 *  com.luck.picture.lib.camera.listener.CameraListener
 *  com.luck.picture.lib.camera.listener.ClickListener
 *  com.luck.picture.lib.camera.listener.ImageCallbackListener
 *  com.luck.picture.lib.camera.view.CaptureLayout
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 *  com.luck.picture.lib.listener.OnPermissionDialogOptionCallback
 *  com.luck.picture.lib.permissions.PermissionChecker
 */
package com.luck.picture.lib;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.luck.picture.lib.PictureSelectorCameraEmptyActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.camera.listener.CameraListener;
import com.luck.picture.lib.camera.listener.ClickListener;
import com.luck.picture.lib.camera.listener.ImageCallbackListener;
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.listener.OnPermissionDialogOptionCallback;
import com.luck.picture.lib.permissions.PermissionChecker;
import java.io.File;

public class PictureCustomCameraActivity
extends PictureSelectorCameraEmptyActivity {
    private static final String TAG = PictureCustomCameraActivity.class.getSimpleName();
    protected boolean isEnterSetting;
    private CustomCameraView mCameraView;

    static /* synthetic */ String access$000() {
        return TAG;
    }

    private void createCameraView() {
        CustomCameraView customCameraView;
        if (this.mCameraView != null) return;
        this.mCameraView = customCameraView = new CustomCameraView(this.getContext());
        this.setContentView((View)customCameraView);
        this.initView();
    }

    protected void initView() {
        CaptureLayout captureLayout;
        this.mCameraView.initCamera(this.config);
        if (this.config.recordVideoSecond > 0) {
            this.mCameraView.setRecordVideoMaxTime(this.config.recordVideoSecond);
        }
        if (this.config.recordVideoMinSecond > 0) {
            this.mCameraView.setRecordVideoMinTime(this.config.recordVideoMinSecond);
        }
        if (this.config.captureLoadingColor != 0) {
            this.mCameraView.setCaptureLoadingColor(this.config.captureLoadingColor);
        }
        if ((captureLayout = this.mCameraView.getCaptureLayout()) != null) {
            captureLayout.setButtonFeatures(this.config.buttonFeatures);
        }
        this.mCameraView.setImageCallbackListener((ImageCallbackListener)new _$.Lambda.PictureCustomCameraActivity.IsPjvXD_XOh7qOaPNJfnKp6ymRg(this));
        this.mCameraView.setCameraListener((CameraListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mCameraView.setOnClickListener((ClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean isImmersive() {
        return false;
    }

    public /* synthetic */ void lambda$initView$0$PictureCustomCameraActivity(File file, ImageView imageView) {
        if (this.config == null) return;
        if (PictureSelectionConfig.imageEngine == null) return;
        if (file == null) return;
        PictureSelectionConfig.imageEngine.loadImage(this.getContext(), file.getAbsolutePath(), imageView);
    }

    public /* synthetic */ void lambda$showPermissionsDialog$1$PictureCustomCameraActivity(PictureCustomDialog pictureCustomDialog, View view) {
        if (!this.isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        if (PictureSelectionConfig.listener != null) {
            PictureSelectionConfig.listener.onCancel();
        }
        this.exit();
    }

    public /* synthetic */ void lambda$showPermissionsDialog$2$PictureCustomCameraActivity(PictureCustomDialog pictureCustomDialog, View view) {
        if (!this.isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        PermissionChecker.launchAppDetailsSettings((Context)this.getContext());
        this.isEnterSetting = true;
    }

    public void onBackPressed() {
        if (this.config != null && this.config.camera && PictureSelectionConfig.listener != null) {
            PictureSelectionConfig.listener.onCancel();
        }
        this.exit();
    }

    protected void onCreate(Bundle bundle) {
        this.getWindow().setFlags(1024, 1024);
        this.getWindow().setFlags(0x4000000, 0x4000000);
        this.getWindow().setFlags(0x8000000, 0x8000000);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams layoutParams = this.getWindow().getAttributes();
            layoutParams.layoutInDisplayCutoutMode = 1;
            this.getWindow().setAttributes(layoutParams);
        }
        this.getWindow().addFlags(128);
        super.onCreate(bundle);
        boolean bl = PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.READ_EXTERNAL_STORAGE") && PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.WRITE_EXTERNAL_STORAGE");
        if (!bl) {
            PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, (int)1);
            return;
        }
        if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.CAMERA")) {
            if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.RECORD_AUDIO")) {
                this.createCameraView();
            } else {
                PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.RECORD_AUDIO"}, (int)4);
            }
        } else {
            PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.CAMERA"}, (int)2);
        }
    }

    protected void onDestroy() {
        CustomCameraView customCameraView = this.mCameraView;
        if (customCameraView != null) {
            customCameraView.unbindCameraController();
        }
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int n, String[] object, int[] nArray) {
        if (n != 1) {
            if (n != 2) {
                if (n != 4) return;
                if (nArray.length > 0 && nArray[0] == 0) {
                    this.createCameraView();
                } else {
                    object = this.getString(R.string.picture_audio);
                    this.showPermissionsDialog(false, new String[]{"android.permission.RECORD_AUDIO"}, (String)object);
                }
            } else if (nArray.length > 0 && nArray[0] == 0) {
                if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.RECORD_AUDIO")) {
                    this.createCameraView();
                } else {
                    PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.RECORD_AUDIO"}, (int)4);
                }
            } else {
                object = this.getString(R.string.picture_camera);
                this.showPermissionsDialog(true, new String[]{"android.permission.CAMERA"}, (String)object);
            }
        } else if (nArray.length > 0 && nArray[0] == 0) {
            PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.CAMERA"}, (int)2);
        } else {
            object = this.getString(R.string.picture_jurisdiction);
            this.showPermissionsDialog(true, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, (String)object);
        }
    }

    protected void onResume() {
        super.onResume();
        if (!this.isEnterSetting) return;
        boolean bl = PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.READ_EXTERNAL_STORAGE") && PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.WRITE_EXTERNAL_STORAGE");
        if (bl) {
            if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.CAMERA")) {
                if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.RECORD_AUDIO")) {
                    this.createCameraView();
                } else {
                    String string2 = this.getString(R.string.picture_audio);
                    this.showPermissionsDialog(false, new String[]{"android.permission.RECORD_AUDIO"}, string2);
                }
            } else {
                String string3 = this.getString(R.string.picture_camera);
                this.showPermissionsDialog(false, new String[]{"android.permission.CAMERA"}, string3);
            }
        } else {
            String string4 = this.getString(R.string.picture_jurisdiction);
            this.showPermissionsDialog(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, string4);
        }
        this.isEnterSetting = false;
    }

    protected void showPermissionsDialog(boolean bl, String[] textView, String string2) {
        if (this.isFinishing()) {
            return;
        }
        if (PictureSelectionConfig.onPermissionsObtainCallback != null) {
            PictureSelectionConfig.onPermissionsObtainCallback.onPermissionsIntercept(this.getContext(), bl, (String[])textView, string2, (OnPermissionDialogOptionCallback)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(this.getContext(), R.layout.picture_wind_base_dialog);
        pictureCustomDialog.setCancelable(false);
        pictureCustomDialog.setCanceledOnTouchOutside(false);
        Button button = (Button)pictureCustomDialog.findViewById(R.id.btn_cancel);
        Button button2 = (Button)pictureCustomDialog.findViewById(R.id.btn_commit);
        button2.setText((CharSequence)this.getString(R.string.picture_go_setting));
        TextView textView2 = (TextView)pictureCustomDialog.findViewById(R.id.tvTitle);
        textView = (TextView)pictureCustomDialog.findViewById(R.id.tv_content);
        textView2.setText((CharSequence)this.getString(R.string.picture_prompt));
        textView.setText((CharSequence)string2);
        button.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureCustomCameraActivity.yCub_m_i_gS24q1UnyyJAqXH_RM(this, pictureCustomDialog));
        button2.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureCustomCameraActivity.9Bml8qgkRf9jYn2Ar2EWb6ypSt4(this, pictureCustomDialog));
        pictureCustomDialog.show();
    }
}
