/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.view.CameraController
 *  androidx.camera.view.LifecycleCameraController
 *  androidx.camera.view.PreviewView
 *  androidx.core.app.ActivityCompat
 *  androidx.core.content.ContextCompat
 *  androidx.lifecycle.LifecycleOwner
 *  com.luck.picture.lib.PictureMediaScannerConnection
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.camera._$$Lambda$CustomCameraView$c7zMjYkXcbxN2LtMM0xsi_4Z3Nc
 *  com.luck.picture.lib.camera._$$Lambda$CustomCameraView$r62lNOB0ktvK1nIiiTeIOnkHJS0
 *  com.luck.picture.lib.camera.listener.CameraListener
 *  com.luck.picture.lib.camera.listener.CaptureListener
 *  com.luck.picture.lib.camera.listener.ClickListener
 *  com.luck.picture.lib.camera.listener.ImageCallbackListener
 *  com.luck.picture.lib.camera.listener.TypeListener
 *  com.luck.picture.lib.camera.view.CaptureLayout
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.StringUtils
 */
package com.luck.picture.lib.camera;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.camera.core.CameraSelector;
import androidx.camera.view.CameraController;
import androidx.camera.view.LifecycleCameraController;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.luck.picture.lib.PictureMediaScannerConnection;
import com.luck.picture.lib.R;
import com.luck.picture.lib.camera._$;
import com.luck.picture.lib.camera.listener.CameraListener;
import com.luck.picture.lib.camera.listener.CaptureListener;
import com.luck.picture.lib.camera.listener.ClickListener;
import com.luck.picture.lib.camera.listener.ImageCallbackListener;
import com.luck.picture.lib.camera.listener.TypeListener;
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import java.io.File;
import java.io.IOException;

public class CustomCameraView
extends RelativeLayout {
    public static final int BUTTON_STATE_BOTH = 259;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 257;
    public static final int BUTTON_STATE_ONLY_RECORDER = 258;
    public static final int DEFAULT_MIN_RECORD_VIDEO = 1500;
    private static final int TYPE_FLASH_AUTO = 33;
    private static final int TYPE_FLASH_OFF = 35;
    private static final int TYPE_FLASH_ON = 34;
    private LifecycleCameraController mCameraController;
    private CameraListener mCameraListener;
    private PreviewView mCameraPreviewView;
    private CaptureLayout mCaptureLayout;
    private PictureSelectionConfig mConfig;
    private ImageView mFlashLamp;
    private ImageCallbackListener mImageCallbackListener;
    private ImageView mImagePreview;
    private MediaPlayer mMediaPlayer;
    private ClickListener mOnClickListener;
    private File mOutMediaFile;
    private ImageView mSwitchCamera;
    private TextureView mTextureView;
    private long recordTime = 0L;
    private final TextureView.SurfaceTextureListener surfaceTextureListener = new /* Unavailable Anonymous Inner Class!! */;
    private int type_flash = 35;

    public CustomCameraView(Context context) {
        super(context);
        this.initView();
    }

    public CustomCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initView();
    }

    public CustomCameraView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.initView();
    }

    static /* synthetic */ File access$000(CustomCameraView customCameraView) {
        return customCameraView.mOutMediaFile;
    }

    static /* synthetic */ File access$002(CustomCameraView customCameraView, File file) {
        customCameraView.mOutMediaFile = file;
        return file;
    }

    static /* synthetic */ CaptureLayout access$100(CustomCameraView customCameraView) {
        return customCameraView.mCaptureLayout;
    }

    static /* synthetic */ TextureView access$1000(CustomCameraView customCameraView) {
        return customCameraView.mTextureView;
    }

    static /* synthetic */ PreviewView access$1100(CustomCameraView customCameraView) {
        return customCameraView.mCameraPreviewView;
    }

    static /* synthetic */ void access$1200(CustomCameraView customCameraView, File file) {
        customCameraView.startVideoPlay(file);
    }

    static /* synthetic */ TextureView.SurfaceTextureListener access$1300(CustomCameraView customCameraView) {
        return customCameraView.surfaceTextureListener;
    }

    static /* synthetic */ void access$1400(CustomCameraView customCameraView) {
        customCameraView.stopVideoPlay();
    }

    static /* synthetic */ void access$1500(CustomCameraView customCameraView) {
        customCameraView.resetState();
    }

    static /* synthetic */ ClickListener access$1600(CustomCameraView customCameraView) {
        return customCameraView.mOnClickListener;
    }

    static /* synthetic */ ImageView access$200(CustomCameraView customCameraView) {
        return customCameraView.mSwitchCamera;
    }

    static /* synthetic */ ImageView access$300(CustomCameraView customCameraView) {
        return customCameraView.mFlashLamp;
    }

    static /* synthetic */ LifecycleCameraController access$400(CustomCameraView customCameraView) {
        return customCameraView.mCameraController;
    }

    static /* synthetic */ ImageView access$500(CustomCameraView customCameraView) {
        return customCameraView.mImagePreview;
    }

    static /* synthetic */ ImageCallbackListener access$600(CustomCameraView customCameraView) {
        return customCameraView.mImageCallbackListener;
    }

    static /* synthetic */ CameraListener access$700(CustomCameraView customCameraView) {
        return customCameraView.mCameraListener;
    }

    static /* synthetic */ PictureSelectionConfig access$800(CustomCameraView customCameraView) {
        return customCameraView.mConfig;
    }

    static /* synthetic */ long access$900(CustomCameraView customCameraView) {
        return customCameraView.recordTime;
    }

    static /* synthetic */ long access$902(CustomCameraView customCameraView, long l) {
        customCameraView.recordTime = l;
        return l;
    }

    private Uri getOutUri(int n) {
        Uri uri = n == PictureMimeType.ofVideo() ? MediaUtils.createVideoUri((Context)this.getContext(), (String)this.mConfig.cameraFileName, (String)this.mConfig.suffixType) : MediaUtils.createImageUri((Context)this.getContext(), (String)this.mConfig.cameraFileName, (String)this.mConfig.suffixType);
        return uri;
    }

    private void resetState() {
        if (this.mCameraController.isImageCaptureEnabled()) {
            this.mImagePreview.setVisibility(4);
        } else if (this.mCameraController.isRecording()) {
            this.mCameraController.stopRecording();
        }
        File file = this.mOutMediaFile;
        if (file != null && file.exists()) {
            this.mOutMediaFile.delete();
            if (!SdkVersionUtils.checkedAndroid_Q()) {
                new PictureMediaScannerConnection(this.getContext(), this.mOutMediaFile.getAbsolutePath());
            }
        }
        this.mSwitchCamera.setVisibility(0);
        this.mFlashLamp.setVisibility(0);
        this.mCameraPreviewView.setVisibility(0);
        this.mCaptureLayout.resetCaptureLayout();
    }

    private void setFlashRes() {
        switch (this.type_flash) {
            default: {
                break;
            }
            case 35: {
                this.mFlashLamp.setImageResource(R.drawable.picture_ic_flash_off);
                this.mCameraController.setImageCaptureFlashMode(2);
                break;
            }
            case 34: {
                this.mFlashLamp.setImageResource(R.drawable.picture_ic_flash_on);
                this.mCameraController.setImageCaptureFlashMode(1);
                break;
            }
            case 33: {
                this.mFlashLamp.setImageResource(R.drawable.picture_ic_flash_auto);
                this.mCameraController.setImageCaptureFlashMode(0);
            }
        }
    }

    private void startVideoPlay(File file) {
        try {
            MediaPlayer mediaPlayer;
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = mediaPlayer = new MediaPlayer();
            }
            this.mMediaPlayer.setDataSource(file.getAbsolutePath());
            file = this.mMediaPlayer;
            mediaPlayer = new Surface(this.mTextureView.getSurfaceTexture());
            file.setSurface((Surface)mediaPlayer);
            this.mMediaPlayer.setLooping(true);
            mediaPlayer = this.mMediaPlayer;
            file = new _$.Lambda.CustomCameraView.r62lNOB0ktvK1nIiiTeIOnkHJS0(this);
            mediaPlayer.setOnPreparedListener((MediaPlayer.OnPreparedListener)file);
            this.mMediaPlayer.prepareAsync();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void stopVideoPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.mTextureView.setVisibility(8);
    }

    public File createImageFile() {
        boolean bl = SdkVersionUtils.checkedAndroid_Q();
        Object object = ".jpeg";
        if (bl) {
            File file = new File(PictureFileUtils.getDiskCacheDir((Context)this.getContext()));
            if (!file.exists()) {
                file.mkdirs();
            }
            bl = TextUtils.isEmpty((CharSequence)this.mConfig.cameraFileName);
            if (this.mConfig.suffixType.startsWith("image/")) {
                object = this.mConfig.suffixType.replaceAll("image/", ".");
            }
            if (bl) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(DateUtils.getCreateFileName((String)"IMG_"));
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
            } else {
                object = this.mConfig.cameraFileName;
            }
            object = new File(file, (String)object);
            file = this.getOutUri(PictureMimeType.ofImage());
            if (file == null) return object;
            this.mConfig.cameraPath = file.toString();
            return object;
        }
        if (!TextUtils.isEmpty((CharSequence)this.mConfig.cameraFileName)) {
            bl = PictureMimeType.isSuffixOfImage((String)this.mConfig.cameraFileName);
            PictureSelectionConfig pictureSelectionConfig = this.mConfig;
            object = !bl ? StringUtils.renameSuffix((String)pictureSelectionConfig.cameraFileName, (String)".jpeg") : pictureSelectionConfig.cameraFileName;
            pictureSelectionConfig.cameraFileName = object;
            object = this.mConfig.camera ? this.mConfig.cameraFileName : StringUtils.rename((String)this.mConfig.cameraFileName);
        } else {
            object = "";
        }
        object = PictureFileUtils.createCameraFile((Context)this.getContext(), (int)PictureMimeType.ofImage(), (String)object, (String)this.mConfig.suffixType, (String)this.mConfig.outPutCameraPath);
        this.mConfig.cameraPath = ((File)object).getAbsolutePath();
        return object;
    }

    public File createVideoFile() {
        boolean bl = SdkVersionUtils.checkedAndroid_Q();
        Object object = ".mp4";
        if (bl) {
            File file = new File(PictureFileUtils.getVideoDiskCacheDir((Context)this.getContext()));
            if (!file.exists()) {
                file.mkdirs();
            }
            bl = TextUtils.isEmpty((CharSequence)this.mConfig.cameraFileName);
            if (this.mConfig.suffixType.startsWith("video/")) {
                object = this.mConfig.suffixType.replaceAll("video/", ".");
            }
            if (bl) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(DateUtils.getCreateFileName((String)"VID_"));
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
            } else {
                object = this.mConfig.cameraFileName;
            }
            file = new File(file, (String)object);
            object = this.getOutUri(PictureMimeType.ofVideo());
            if (object == null) return file;
            this.mConfig.cameraPath = object.toString();
            return file;
        }
        if (!TextUtils.isEmpty((CharSequence)this.mConfig.cameraFileName)) {
            bl = PictureMimeType.isSuffixOfImage((String)this.mConfig.cameraFileName);
            PictureSelectionConfig pictureSelectionConfig = this.mConfig;
            object = !bl ? StringUtils.renameSuffix((String)pictureSelectionConfig.cameraFileName, (String)".mp4") : pictureSelectionConfig.cameraFileName;
            pictureSelectionConfig.cameraFileName = object;
            object = this.mConfig.camera ? this.mConfig.cameraFileName : StringUtils.rename((String)this.mConfig.cameraFileName);
        } else {
            object = "";
        }
        object = PictureFileUtils.createCameraFile((Context)this.getContext(), (int)PictureMimeType.ofVideo(), (String)object, (String)this.mConfig.suffixType, (String)this.mConfig.outPutCameraPath);
        this.mConfig.cameraPath = ((File)object).getAbsolutePath();
        return object;
    }

    public CaptureLayout getCaptureLayout() {
        return this.mCaptureLayout;
    }

    public void initCamera(PictureSelectionConfig pictureSelectionConfig) {
        this.mConfig = pictureSelectionConfig;
        if (ActivityCompat.checkSelfPermission((Context)this.getContext(), (String)"android.permission.CAMERA") == 0) {
            pictureSelectionConfig = new LifecycleCameraController(this.getContext());
            this.mCameraController = pictureSelectionConfig;
            pictureSelectionConfig.bindToLifecycle((LifecycleOwner)this.getContext());
            LifecycleCameraController lifecycleCameraController = this.mCameraController;
            pictureSelectionConfig = this.mConfig.isCameraAroundState ? CameraSelector.DEFAULT_FRONT_CAMERA : CameraSelector.DEFAULT_BACK_CAMERA;
            lifecycleCameraController.setCameraSelector((CameraSelector)pictureSelectionConfig);
            this.mCameraPreviewView.setController((CameraController)this.mCameraController);
        }
        this.setFlashRes();
    }

    public void initView() {
        CustomCameraView.inflate((Context)this.getContext(), (int)R.layout.picture_camera_view, (ViewGroup)this);
        this.setBackgroundColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_black));
        this.mCameraPreviewView = (PreviewView)this.findViewById(R.id.cameraPreviewView);
        this.mTextureView = (TextureView)this.findViewById(R.id.video_play_preview);
        this.mImagePreview = (ImageView)this.findViewById(R.id.image_preview);
        this.mSwitchCamera = (ImageView)this.findViewById(R.id.image_switch);
        this.mFlashLamp = (ImageView)this.findViewById(R.id.image_flash);
        this.mCaptureLayout = (CaptureLayout)this.findViewById(R.id.capture_layout);
        this.mSwitchCamera.setImageResource(R.drawable.picture_ic_camera);
        this.mFlashLamp.setOnClickListener((View.OnClickListener)new _$.Lambda.CustomCameraView.c7zMjYkXcbxN2LtMM0xsi_4Z3Nc(this));
        this.mCaptureLayout.setDuration(15000);
        this.mSwitchCamera.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mCaptureLayout.setCaptureListener((CaptureListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mCaptureLayout.setTypeListener((TypeListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mCaptureLayout.setLeftClickListener((ClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public /* synthetic */ void lambda$initView$0$CustomCameraView(View view) {
        int n;
        this.type_flash = n = this.type_flash + 1;
        if (n > 35) {
            this.type_flash = 33;
        }
        this.setFlashRes();
    }

    public /* synthetic */ void lambda$startVideoPlay$1$CustomCameraView(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        float f = (float)mediaPlayer.getVideoWidth() * 1.0f / (float)mediaPlayer.getVideoHeight();
        int n = this.mTextureView.getWidth();
        mediaPlayer = this.mTextureView.getLayoutParams();
        mediaPlayer.height = (int)((float)n / f);
        this.mTextureView.setLayoutParams((ViewGroup.LayoutParams)mediaPlayer);
    }

    public void setCameraListener(CameraListener cameraListener) {
        this.mCameraListener = cameraListener;
    }

    public void setCaptureLoadingColor(int n) {
        this.mCaptureLayout.setCaptureLoadingColor(n);
    }

    public void setImageCallbackListener(ImageCallbackListener imageCallbackListener) {
        this.mImageCallbackListener = imageCallbackListener;
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.mOnClickListener = clickListener;
    }

    public void setRecordVideoMaxTime(int n) {
        this.mCaptureLayout.setDuration(n * 1000);
    }

    public void setRecordVideoMinTime(int n) {
        this.mCaptureLayout.setMinDuration(n * 1000);
    }

    public void toggleCamera() {
        if (this.mCameraController.getCameraSelector() == CameraSelector.DEFAULT_BACK_CAMERA && this.mCameraController.hasCamera(CameraSelector.DEFAULT_FRONT_CAMERA)) {
            this.mCameraController.setCameraSelector(CameraSelector.DEFAULT_FRONT_CAMERA);
        } else {
            if (this.mCameraController.getCameraSelector() != CameraSelector.DEFAULT_FRONT_CAMERA) return;
            if (!this.mCameraController.hasCamera(CameraSelector.DEFAULT_BACK_CAMERA)) return;
            this.mCameraController.setCameraSelector(CameraSelector.DEFAULT_BACK_CAMERA);
        }
    }

    public void unbindCameraController() {
        LifecycleCameraController lifecycleCameraController = this.mCameraController;
        if (lifecycleCameraController == null) return;
        lifecycleCameraController.unbind();
    }
}
