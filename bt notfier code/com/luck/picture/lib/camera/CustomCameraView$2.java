/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.camera.core.ImageCapture$OnImageSavedCallback
 *  androidx.camera.core.ImageCapture$OutputFileOptions
 *  androidx.camera.core.ImageCapture$OutputFileOptions$Builder
 *  androidx.camera.view.video.OnVideoSavedCallback
 *  androidx.camera.view.video.OutputFileOptions
 *  androidx.core.content.ContextCompat
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.camera.CustomCameraView
 *  com.luck.picture.lib.camera.CustomCameraView$MyImageResultCallback
 *  com.luck.picture.lib.camera.listener.CaptureListener
 */
package com.luck.picture.lib.camera;

import android.content.Context;
import androidx.camera.core.ImageCapture;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.camera.listener.CaptureListener;
import java.io.File;

/*
 * Exception performing whole class analysis ignored.
 */
class CustomCameraView.2
implements CaptureListener {
    final CustomCameraView this$0;

    CustomCameraView.2(CustomCameraView customCameraView) {
        this.this$0 = customCameraView;
    }

    public void recordEnd(long l) {
        CustomCameraView.access$902((CustomCameraView)this.this$0, (long)l);
        CustomCameraView.access$400((CustomCameraView)this.this$0).stopRecording();
    }

    public void recordError() {
        if (CustomCameraView.access$700((CustomCameraView)this.this$0) == null) return;
        CustomCameraView.access$700((CustomCameraView)this.this$0).onError(0, "An unknown error", null);
    }

    public void recordShort(long l) {
        CustomCameraView.access$902((CustomCameraView)this.this$0, (long)l);
        CustomCameraView.access$200((CustomCameraView)this.this$0).setVisibility(0);
        CustomCameraView.access$300((CustomCameraView)this.this$0).setVisibility(0);
        CustomCameraView.access$100((CustomCameraView)this.this$0).resetCaptureLayout();
        CustomCameraView.access$100((CustomCameraView)this.this$0).setTextWithAnimation(this.this$0.getContext().getString(R.string.picture_recording_time_is_short));
        CustomCameraView.access$400((CustomCameraView)this.this$0).stopRecording();
    }

    public void recordStart() {
        CustomCameraView customCameraView = this.this$0;
        CustomCameraView.access$002((CustomCameraView)customCameraView, (File)customCameraView.createVideoFile());
        CustomCameraView.access$200((CustomCameraView)this.this$0).setVisibility(4);
        CustomCameraView.access$300((CustomCameraView)this.this$0).setVisibility(4);
        CustomCameraView.access$400((CustomCameraView)this.this$0).setEnabledUseCases(4);
        customCameraView = OutputFileOptions.builder((File)CustomCameraView.access$000((CustomCameraView)this.this$0)).build();
        CustomCameraView.access$400((CustomCameraView)this.this$0).startRecording((OutputFileOptions)customCameraView, ContextCompat.getMainExecutor((Context)this.this$0.getContext()), (OnVideoSavedCallback)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void recordZoom(float f) {
    }

    public void takePictures() {
        CustomCameraView customCameraView = this.this$0;
        CustomCameraView.access$002((CustomCameraView)customCameraView, (File)customCameraView.createImageFile());
        CustomCameraView.access$100((CustomCameraView)this.this$0).setButtonCaptureEnabled(false);
        CustomCameraView.access$200((CustomCameraView)this.this$0).setVisibility(4);
        CustomCameraView.access$300((CustomCameraView)this.this$0).setVisibility(4);
        CustomCameraView.access$400((CustomCameraView)this.this$0).setEnabledUseCases(1);
        customCameraView = new ImageCapture.OutputFileOptions.Builder(CustomCameraView.access$000((CustomCameraView)this.this$0)).build();
        CustomCameraView.access$400((CustomCameraView)this.this$0).takePicture((ImageCapture.OutputFileOptions)customCameraView, ContextCompat.getMainExecutor((Context)this.this$0.getContext()), (ImageCapture.OnImageSavedCallback)new CustomCameraView.MyImageResultCallback(CustomCameraView.access$000((CustomCameraView)this.this$0), CustomCameraView.access$500((CustomCameraView)this.this$0), CustomCameraView.access$100((CustomCameraView)this.this$0), CustomCameraView.access$600((CustomCameraView)this.this$0), CustomCameraView.access$700((CustomCameraView)this.this$0)));
    }
}
