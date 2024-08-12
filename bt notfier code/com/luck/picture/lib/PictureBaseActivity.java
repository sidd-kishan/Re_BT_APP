/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  androidx.appcompat.app.AppCompatActivity
 *  com.luck.picture.lib.PictureContextWrapper
 *  com.luck.picture.lib.PictureCustomCameraActivity
 *  com.luck.picture.lib.PictureSelector
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.PictureSelectorCameraEmptyActivity
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.R$attr
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.R$style
 *  com.luck.picture.lib._$$Lambda$PictureBaseActivity$_bvsXD9WQydPpsTHM1mfy4FuA4g
 *  com.luck.picture.lib._$$Lambda$PictureBaseActivity$_cfblVyTo016LVC9z1wi55KosoU
 *  com.luck.picture.lib.app.PictureAppMaster
 *  com.luck.picture.lib.compress.Luban
 *  com.luck.picture.lib.compress.OnCompressListener
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 *  com.luck.picture.lib.dialog.PictureLoadingDialog
 *  com.luck.picture.lib.engine.PictureSelectorEngine
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.entity.LocalMediaFolder
 *  com.luck.picture.lib.immersive.ImmersiveManage
 *  com.luck.picture.lib.immersive.NavBarUtils
 *  com.luck.picture.lib.language.PictureLanguageUtils
 *  com.luck.picture.lib.listener.OnCallbackListener
 *  com.luck.picture.lib.model.LocalMediaPageLoader
 *  com.luck.picture.lib.permissions.PermissionChecker
 *  com.luck.picture.lib.thread.PictureThreadUtils
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 *  com.luck.picture.lib.tools.AttrsUtils
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.StringUtils
 *  com.luck.picture.lib.tools.ToastUtils
 *  com.luck.picture.lib.tools.VoiceUtils
 */
package com.luck.picture.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.luck.picture.lib.PictureContextWrapper;
import com.luck.picture.lib.PictureCustomCameraActivity;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.PictureSelectorCameraEmptyActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.compress.OnCompressListener;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.dialog.PictureLoadingDialog;
import com.luck.picture.lib.engine.PictureSelectorEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.immersive.NavBarUtils;
import com.luck.picture.lib.language.PictureLanguageUtils;
import com.luck.picture.lib.listener.OnCallbackListener;
import com.luck.picture.lib.model.LocalMediaPageLoader;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.VoiceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

public abstract class PictureBaseActivity
extends AppCompatActivity {
    protected int colorPrimary;
    protected int colorPrimaryDark;
    protected PictureSelectionConfig config;
    protected View container;
    protected boolean isHasMore = true;
    protected boolean isOnSaveInstanceState;
    protected Handler mHandler;
    protected PictureLoadingDialog mLoadingDialog;
    protected int mPage = 1;
    protected boolean numComplete;
    protected boolean openWhiteStatusBar;
    protected List<LocalMedia> selectionMedias = new ArrayList<LocalMedia>();

    public PictureBaseActivity() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ void access$000(PictureBaseActivity pictureBaseActivity, List list, List list2) {
        pictureBaseActivity.handleCompressCallBack(list, list2);
    }

    private void compressToLuban(List<LocalMedia> list) {
        if (this.config.synOrAsy) {
            PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            Luban.with((Context)this).loadMediaData(list).ignoreBy(this.config.minimumCompressSize).isCamera(this.config.camera).setCompressQuality(this.config.compressQuality).setTargetDir(this.config.compressSavePath).isAutoRotating(this.config.isAutoRotating).setFocusAlpha(this.config.focusAlpha).setNewCompressFileName(this.config.renameCompressFileName).setCompressListener((OnCompressListener)new /* Unavailable Anonymous Inner Class!! */).launch();
        }
    }

    private void handleCompressCallBack(List<LocalMedia> list, List<File> list2) {
        block4: {
            int n;
            boolean bl;
            block5: {
                block3: {
                    if (list == null || list2 == null) break block3;
                    bl = SdkVersionUtils.checkedAndroid_Q();
                    n = list.size();
                    if (list2.size() != n) break block4;
                    break block5;
                }
                this.exit();
                return;
            }
            for (int i = 0; i < n; ++i) {
                Object object = list2.get(i);
                if (object == null) continue;
                object = ((File)object).getAbsolutePath();
                LocalMedia localMedia = list.get(i);
                boolean bl2 = PictureMimeType.isHasHttp((String)object);
                boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                boolean bl4 = true;
                boolean bl5 = !bl3 && bl2;
                bl3 = PictureMimeType.isHasVideo((String)localMedia.getMimeType());
                if (bl3 || bl5) {
                    bl4 = false;
                }
                localMedia.setCompressed(bl4);
                if (bl3 || bl5) {
                    object = null;
                }
                localMedia.setCompressPath((String)object);
                if (!bl) continue;
                localMedia.setAndroidQToPath(localMedia.getCompressPath());
            }
        }
        this.onResult(list);
    }

    private void initConfig() {
        if (this.config.selectionMedias != null) {
            this.selectionMedias.clear();
            this.selectionMedias.addAll(this.config.selectionMedias);
        }
        if (PictureSelectionConfig.uiStyle != null) {
            this.openWhiteStatusBar = PictureSelectionConfig.uiStyle.picture_statusBarChangeTextColor;
            if (PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor != 0) {
                this.colorPrimary = PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor;
            }
            if (PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor != 0) {
                this.colorPrimaryDark = PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor;
            }
            this.numComplete = PictureSelectionConfig.uiStyle.picture_switchSelectTotalStyle;
            this.config.checkNumMode = PictureSelectionConfig.uiStyle.picture_switchSelectNumberStyle;
        } else if (PictureSelectionConfig.style != null) {
            this.openWhiteStatusBar = PictureSelectionConfig.style.isChangeStatusBarFontColor;
            if (PictureSelectionConfig.style.pictureTitleBarBackgroundColor != 0) {
                this.colorPrimary = PictureSelectionConfig.style.pictureTitleBarBackgroundColor;
            }
            if (PictureSelectionConfig.style.pictureStatusBarColor != 0) {
                this.colorPrimaryDark = PictureSelectionConfig.style.pictureStatusBarColor;
            }
            this.numComplete = PictureSelectionConfig.style.isOpenCompletedNumStyle;
            this.config.checkNumMode = PictureSelectionConfig.style.isOpenCheckNumStyle;
        } else {
            boolean bl;
            this.openWhiteStatusBar = bl = this.config.isChangeStatusBarFontColor;
            if (!bl) {
                this.openWhiteStatusBar = AttrsUtils.getTypeValueBoolean((Context)this, (int)R.attr.picture_statusFontColor);
            }
            this.numComplete = bl = this.config.isOpenStyleNumComplete;
            if (!bl) {
                this.numComplete = AttrsUtils.getTypeValueBoolean((Context)this, (int)R.attr.picture_style_numComplete);
            }
            PictureSelectionConfig pictureSelectionConfig = this.config;
            pictureSelectionConfig.checkNumMode = pictureSelectionConfig.isOpenStyleCheckNumMode;
            if (!this.config.checkNumMode) {
                this.config.checkNumMode = AttrsUtils.getTypeValueBoolean((Context)this, (int)R.attr.picture_style_checkNumMode);
            }
            this.colorPrimary = this.config.titleBarBackgroundColor != 0 ? this.config.titleBarBackgroundColor : AttrsUtils.getTypeValueColor((Context)this, (int)R.attr.colorPrimary);
            this.colorPrimaryDark = this.config.pictureStatusBarColor != 0 ? this.config.pictureStatusBarColor : AttrsUtils.getTypeValueColor((Context)this, (int)R.attr.colorPrimaryDark);
        }
        if (!this.config.openClickSound) return;
        VoiceUtils.getInstance().init(this.getContext());
    }

    static /* synthetic */ int lambda$sortFolder$1(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null) return 0;
        if (localMediaFolder2.getData() == null) {
            return 0;
        }
        int n = localMediaFolder.getImageNum();
        return Integer.compare(localMediaFolder2.getImageNum(), n);
    }

    private void newCreateEngine() {
        if (PictureSelectionConfig.imageEngine != null) return;
        PictureSelectorEngine pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine();
        if (pictureSelectorEngine == null) return;
        PictureSelectionConfig.imageEngine = pictureSelectorEngine.createEngine();
    }

    private void newCreateResultCallbackListener() {
        if (!this.config.isCallbackMode) return;
        if (PictureSelectionConfig.listener != null) return;
        PictureSelectorEngine pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine();
        if (pictureSelectorEngine == null) return;
        PictureSelectionConfig.listener = pictureSelectorEngine.getResultCallbackListener();
    }

    private void normalResult(List<LocalMedia> list) {
        int n;
        int n2 = list.size();
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            LocalMedia localMedia = list.get(n);
            if (localMedia == null || TextUtils.isEmpty((CharSequence)localMedia.getPath())) continue;
            if (localMedia.isCut() && localMedia.isCompressed()) {
                localMedia.setAndroidQToPath(localMedia.getCompressPath());
            }
            if (!this.config.isCheckOriginalImage) continue;
            localMedia.setOriginal(true);
            localMedia.setOriginalPath(localMedia.getAndroidQToPath());
        }
        if (this.config.camera && this.config.selectionMode == 2) {
            n = n3;
            if (list.size() > 0) {
                n = list.size() - 1;
            }
            list.addAll(n, this.selectionMedias);
        }
        if (PictureSelectionConfig.listener != null) {
            PictureSelectionConfig.listener.onResult(list);
        } else {
            this.setResult(-1, PictureSelector.putIntentResult(list));
        }
        this.exit();
    }

    private void onResultToAndroidAsy(List<LocalMedia> list) {
        boolean bl;
        int n = list.size();
        boolean bl2 = false;
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) break;
            LocalMedia localMedia = list.get(n2);
            if (localMedia != null && !TextUtils.isEmpty((CharSequence)localMedia.getPath()) && (this.config.isCheckOriginalImage || !localMedia.isCut() && !localMedia.isCompressed() && TextUtils.isEmpty((CharSequence)localMedia.getAndroidQToPath()))) {
                bl = true;
                break;
            }
            ++n2;
        }
        if (bl) {
            this.startThreadCopySandbox(list);
        } else {
            this.normalResult(list);
        }
    }

    private void releaseResultListener() {
        if (this.config == null) return;
        PictureSelectionConfig.destroy();
        LocalMediaPageLoader.setInstanceNull();
        PictureThreadUtils.cancel((ExecutorService)PictureThreadUtils.getSinglePool());
    }

    private void startThreadCopySandbox(List<LocalMedia> list) {
        this.showPleaseDialog();
        PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
    }

    protected void attachBaseContext(Context context) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig == null) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext((Context)PictureContextWrapper.wrap((Context)context, (int)pictureSelectionConfig.language));
        }
    }

    protected void compressImage(List<LocalMedia> list) {
        if (PictureSelectionConfig.compressEngine != null) {
            PictureSelectionConfig.compressEngine.onCompress(this.getContext(), list, (OnCallbackListener)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            this.showPleaseDialog();
            this.compressToLuban(list);
        }
    }

    protected void createNewFolder(List<LocalMediaFolder> list) {
        if (list.size() != 0) return;
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        int n = this.config.chooseMode == PictureMimeType.ofAudio() ? R.string.picture_all_audio : R.string.picture_camera_roll;
        localMediaFolder.setName(this.getString(n));
        localMediaFolder.setFirstImagePath("");
        localMediaFolder.setCameraFolder(true);
        localMediaFolder.setBucketId(-1L);
        localMediaFolder.setChecked(true);
        list.add(localMediaFolder);
    }

    protected void dismissDialog() {
        if (this.isFinishing()) return;
        try {
            if (this.mLoadingDialog == null) return;
            if (!this.mLoadingDialog.isShowing()) return;
            this.mLoadingDialog.dismiss();
        }
        catch (Exception exception) {
            this.mLoadingDialog = null;
            exception.printStackTrace();
        }
    }

    protected void exit() {
        this.finish();
        if (this.config.camera) {
            this.overridePendingTransition(0, R.anim.picture_anim_fade_out);
            if (!(this.getContext() instanceof PictureSelectorCameraEmptyActivity)) {
                if (!(this.getContext() instanceof PictureCustomCameraActivity)) return;
            }
            this.releaseResultListener();
        } else {
            this.overridePendingTransition(0, PictureSelectionConfig.windowAnimationStyle.activityExitAnimation);
            if (!(this.getContext() instanceof PictureSelectorActivity)) return;
            this.releaseResultListener();
            if (!this.config.openClickSound) return;
            VoiceUtils.getInstance().releaseSoundPool();
        }
    }

    protected String getAudioPath(Intent object) {
        try {
            object = object.getData();
            if (object == null) {
                return "";
            }
            if (PictureMimeType.isContent((String)object.toString())) {
                return object.toString();
            }
            object = object.getPath();
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    protected Context getContext() {
        return this;
    }

    protected LocalMediaFolder getImageFolder(String string2, String object, String string3, List<LocalMediaFolder> list) {
        LocalMediaFolder localMediaFolder2;
        if (!PictureMimeType.isContent((String)string2)) {
            object = string2;
        }
        object = new File((String)object).getParentFile();
        for (LocalMediaFolder localMediaFolder2 : list) {
            if (object == null || !localMediaFolder2.getName().equals(((File)object).getName())) continue;
            return localMediaFolder2;
        }
        localMediaFolder2 = new LocalMediaFolder();
        object = object != null ? ((File)object).getName() : "";
        localMediaFolder2.setName((String)object);
        localMediaFolder2.setFirstImagePath(string2);
        localMediaFolder2.setFirstMimeType(string3);
        list.add(localMediaFolder2);
        return localMediaFolder2;
    }

    public abstract int getResourceId();

    protected void handlerResult(List<LocalMedia> list) {
        if (this.config.isCompress) {
            this.compressImage(list);
        } else {
            this.onResult(list);
        }
    }

    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23((AppCompatActivity)this, (int)this.colorPrimaryDark, (int)this.colorPrimary, (boolean)this.openWhiteStatusBar);
    }

    protected void initCompleteText(int n) {
    }

    protected void initCompleteText(List<LocalMedia> list) {
    }

    protected void initPictureSelectorStyle() {
    }

    protected void initWidgets() {
    }

    public boolean isImmersive() {
        return true;
    }

    public boolean isRequestedOrientation() {
        return true;
    }

    public /* synthetic */ void lambda$showPromptDialog$0$PictureBaseActivity(PictureCustomDialog pictureCustomDialog, View view) {
        if (this.isFinishing()) return;
        pictureCustomDialog.dismiss();
    }

    protected void onCreate(Bundle bundle) {
        this.config = PictureSelectionConfig.getInstance();
        PictureLanguageUtils.setAppLanguage((Context)this.getContext(), (int)this.config.language);
        int n = this.config.themeStyleId == 0 ? R.style.picture_default_style : this.config.themeStyleId;
        this.setTheme(n);
        super.onCreate(bundle);
        this.newCreateEngine();
        this.newCreateResultCallbackListener();
        if (this.isRequestedOrientation()) {
            this.setNewRequestedOrientation();
        }
        this.initConfig();
        if (this.isImmersive()) {
            this.immersive();
        }
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_navBarColor != 0) {
                NavBarUtils.setNavBarColor((Activity)this, (int)PictureSelectionConfig.uiStyle.picture_navBarColor);
            }
        } else if (PictureSelectionConfig.style != null && PictureSelectionConfig.style.pictureNavBarColor != 0) {
            NavBarUtils.setNavBarColor((Activity)this, (int)PictureSelectionConfig.style.pictureNavBarColor);
        }
        if ((n = this.getResourceId()) != 0) {
            this.setContentView(n);
        }
        this.initWidgets();
        this.initPictureSelectorStyle();
        this.isOnSaveInstanceState = false;
    }

    protected void onDestroy() {
        PictureLoadingDialog pictureLoadingDialog = this.mLoadingDialog;
        if (pictureLoadingDialog != null) {
            pictureLoadingDialog.dismiss();
            this.mLoadingDialog = null;
        }
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int n, String[] intent, int[] nArray) {
        super.onRequestPermissionsResult(n, (String[])intent, nArray);
        if (n != 3) return;
        if (nArray[0] == 0) {
            intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
            if (intent.resolveActivity(this.getPackageManager()) == null) return;
            this.startActivityForResult(intent, 909);
        } else {
            ToastUtils.s((Context)this.getContext(), (String)this.getString(R.string.picture_audio));
        }
    }

    protected void onResult(List<LocalMedia> list) {
        if (SdkVersionUtils.checkedAndroid_Q() && this.config.isAndroidQTransform) {
            this.onResultToAndroidAsy(list);
        } else {
            int n;
            this.dismissDialog();
            boolean bl = this.config.camera;
            int n2 = 0;
            if (bl && this.config.selectionMode == 2) {
                n = list.size() > 0 ? list.size() - 1 : 0;
                list.addAll(n, this.selectionMedias);
            }
            if (this.config.isCheckOriginalImage) {
                int n3 = list.size();
                for (n = n2; n < n3; ++n) {
                    LocalMedia localMedia = list.get(n);
                    localMedia.setOriginal(true);
                    localMedia.setOriginalPath(localMedia.getPath());
                }
            }
            if (PictureSelectionConfig.listener != null) {
                PictureSelectionConfig.listener.onResult(list);
            } else {
                this.setResult(-1, PictureSelector.putIntentResult(list));
            }
            this.exit();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.isOnSaveInstanceState = true;
        bundle.putParcelable("PictureSelectorConfig", (Parcelable)this.config);
    }

    protected void setNewRequestedOrientation() {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig == null) return;
        if (pictureSelectionConfig.camera) return;
        this.setRequestedOrientation(this.config.requestedOrientation);
    }

    protected void showPermissionsDialog(boolean bl, String[] stringArray, String string2) {
    }

    protected void showPleaseDialog() {
        try {
            if (this.isFinishing()) return;
            if (this.mLoadingDialog == null) {
                PictureLoadingDialog pictureLoadingDialog;
                this.mLoadingDialog = pictureLoadingDialog = new PictureLoadingDialog(this.getContext());
            }
            if (this.mLoadingDialog.isShowing()) {
                this.mLoadingDialog.dismiss();
            }
            this.mLoadingDialog.show();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected void showPromptDialog(String string2) {
        if (this.isFinishing()) return;
        PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(this.getContext(), R.layout.picture_prompt_dialog);
        TextView textView = (TextView)pictureCustomDialog.findViewById(R.id.btnOk);
        ((TextView)pictureCustomDialog.findViewById(R.id.tv_content)).setText((CharSequence)string2);
        textView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureBaseActivity._bvsXD9WQydPpsTHM1mfy4FuA4g(this, pictureCustomDialog));
        pictureCustomDialog.show();
    }

    protected void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, _$.Lambda.PictureBaseActivity._cfblVyTo016LVC9z1wi55KosoU.INSTANCE);
    }

    protected void startOpenCamera() {
        Object object;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.getPackageManager()) == null) return;
        Object object2 = null;
        int n = this.config.chooseMode == 0 ? 1 : this.config.chooseMode;
        if (!TextUtils.isEmpty((CharSequence)this.config.cameraFileName)) {
            boolean bl = PictureMimeType.isSuffixOfImage((String)this.config.cameraFileName);
            object = this.config;
            object2 = !bl ? StringUtils.renameSuffix((String)object.cameraFileName, (String)".jpeg") : object.cameraFileName;
            object.cameraFileName = object2;
            object2 = this.config.camera ? this.config.cameraFileName : StringUtils.rename((String)this.config.cameraFileName);
        }
        if (SdkVersionUtils.checkedAndroid_Q()) {
            if (TextUtils.isEmpty((CharSequence)this.config.outPutCameraPath)) {
                object2 = MediaUtils.createImageUri((Context)this, (String)this.config.cameraFileName, (String)this.config.suffixType);
            } else {
                object2 = PictureFileUtils.createCameraFile((Context)this, (int)n, (String)object2, (String)this.config.suffixType, (String)this.config.outPutCameraPath);
                this.config.cameraPath = ((File)object2).getAbsolutePath();
                object2 = PictureFileUtils.parUri((Context)this, (File)object2);
            }
            object = object2;
            if (object2 != null) {
                this.config.cameraPath = object2.toString();
                object = object2;
            }
        } else {
            object2 = PictureFileUtils.createCameraFile((Context)this, (int)n, object2, (String)this.config.suffixType, (String)this.config.outPutCameraPath);
            this.config.cameraPath = ((File)object2).getAbsolutePath();
            object = PictureFileUtils.parUri((Context)this, (File)object2);
        }
        if (object == null) {
            ToastUtils.s((Context)this.getContext(), (String)"open is camera error\uff0cthe uri is empty ");
            if (!this.config.camera) return;
            this.exit();
            return;
        }
        this.config.cameraMimeType = PictureMimeType.ofImage();
        if (this.config.isCameraAroundState) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        }
        intent.putExtra("output", (Parcelable)object);
        this.startActivityForResult(intent, 909);
    }

    public void startOpenCameraAudio() {
        try {
            if (PermissionChecker.checkSelfPermission((Context)this, (String)"android.permission.RECORD_AUDIO")) {
                Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
                if (intent.resolveActivity(this.getPackageManager()) != null) {
                    this.config.cameraMimeType = PictureMimeType.ofAudio();
                    if (SdkVersionUtils.checkedAndroid_Q()) {
                        Uri uri = MediaUtils.createAudioUri((Context)this, (String)this.config.suffixType);
                        if (uri == null) {
                            ToastUtils.s((Context)this.getContext(), (String)"open is audio error\uff0cthe uri is empty ");
                            if (!this.config.camera) return;
                            this.exit();
                            return;
                        }
                        this.config.cameraPath = uri.toString();
                        intent.putExtra("output", (Parcelable)uri);
                    }
                    this.startActivityForResult(intent, 909);
                } else {
                    ToastUtils.s((Context)this.getContext(), (String)"System recording is not supported");
                }
            } else {
                PermissionChecker.requestPermissions((Activity)this, (String[])new String[]{"android.permission.RECORD_AUDIO"}, (int)3);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            ToastUtils.s((Context)this.getContext(), (String)exception.getMessage());
        }
    }

    protected void startOpenCameraVideo() {
        Object object;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(this.getPackageManager()) == null) return;
        Object object2 = null;
        int n = this.config.chooseMode == 0 ? 2 : this.config.chooseMode;
        if (!TextUtils.isEmpty((CharSequence)this.config.cameraFileName)) {
            boolean bl = PictureMimeType.isSuffixOfImage((String)this.config.cameraFileName);
            object = this.config;
            object2 = bl ? StringUtils.renameSuffix((String)object.cameraFileName, (String)".mp4") : object.cameraFileName;
            object.cameraFileName = object2;
            object2 = this.config.camera ? this.config.cameraFileName : StringUtils.rename((String)this.config.cameraFileName);
        }
        if (SdkVersionUtils.checkedAndroid_Q()) {
            if (TextUtils.isEmpty((CharSequence)this.config.outPutCameraPath)) {
                object2 = MediaUtils.createVideoUri((Context)this, (String)this.config.cameraFileName, (String)this.config.suffixType);
            } else {
                object2 = PictureFileUtils.createCameraFile((Context)this, (int)n, (String)object2, (String)this.config.suffixType, (String)this.config.outPutCameraPath);
                this.config.cameraPath = ((File)object2).getAbsolutePath();
                object2 = PictureFileUtils.parUri((Context)this, (File)object2);
            }
            object = object2;
            if (object2 != null) {
                this.config.cameraPath = object2.toString();
                object = object2;
            }
        } else {
            object2 = PictureFileUtils.createCameraFile((Context)this, (int)n, object2, (String)this.config.suffixType, (String)this.config.outPutCameraPath);
            this.config.cameraPath = ((File)object2).getAbsolutePath();
            object = PictureFileUtils.parUri((Context)this, (File)object2);
        }
        if (object == null) {
            ToastUtils.s((Context)this.getContext(), (String)"open is camera error\uff0cthe uri is empty ");
            if (!this.config.camera) return;
            this.exit();
            return;
        }
        this.config.cameraMimeType = PictureMimeType.ofVideo();
        intent.putExtra("output", (Parcelable)object);
        if (this.config.isCameraAroundState) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        }
        intent.putExtra("android.intent.extra.quickCapture", this.config.isQuickCapture);
        intent.putExtra("android.intent.extra.durationLimit", this.config.recordVideoSecond);
        intent.putExtra("android.intent.extra.videoQuality", this.config.videoQuality);
        this.startActivityForResult(intent, 909);
    }
}
