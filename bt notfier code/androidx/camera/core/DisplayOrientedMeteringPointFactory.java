/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.Display
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.MeteringPointFactory
 *  androidx.camera.core.impl.CameraInfoInternal
 */
package androidx.camera.core;

import android.graphics.PointF;
import android.view.Display;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.CameraInfoInternal;

public final class DisplayOrientedMeteringPointFactory
extends MeteringPointFactory {
    private final CameraInfo mCameraInfo;
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    public DisplayOrientedMeteringPointFactory(Display display, CameraInfo cameraInfo, float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
        this.mDisplay = display;
        this.mCameraInfo = cameraInfo;
    }

    private Integer getLensFacing() {
        CameraInfo cameraInfo = this.mCameraInfo;
        if (!(cameraInfo instanceof CameraInfoInternal)) return null;
        return ((CameraInfoInternal)cameraInfo).getLensFacing();
    }

    private int getRelativeCameraOrientation(boolean bl) {
        int n;
        try {
            int n2;
            n = this.mDisplay.getRotation();
            n = n2 = this.mCameraInfo.getSensorRotationDegrees(n);
            if (!bl) return n;
            n = (360 - n2) % 360;
        }
        catch (Exception exception) {
            n = 0;
        }
        return n;
    }

    /*
     * Unable to fully structure code
     */
    protected PointF convertPoint(float var1_1, float var2_2) {
        var8_3 = this.mWidth;
        var7_4 = this.mHeight;
        var11_5 = this.getLensFacing();
        var10_6 = var11_5 != null && var11_5 == 0;
        var9_7 = this.getRelativeCameraOrientation(var10_6);
        var6_8 = var8_3;
        var5_9 = var7_4;
        var4_10 = var1_1;
        var3_11 = var2_2;
        if (var9_7 != 90) {
            if (var9_7 == 270) {
                var6_8 = var8_3;
                var5_9 = var7_4;
                var4_10 = var1_1;
                var3_11 = var2_2;
            } else {
                var5_9 = var8_3;
                var6_8 = var7_4;
                var3_11 = var1_1;
                var4_10 = var2_2;
            }
        }
        var1_1 = var3_11;
        if (var9_7 == 90) ** GOTO lbl28
        if (var9_7 != 180) {
            if (var9_7 == 270) {
                var3_11 = var5_9 - var3_11;
            }
        } else {
            var1_1 = var5_9 - var3_11;
lbl28:
            // 2 sources

            var4_10 = var6_8 - var4_10;
            var3_11 = var1_1;
        }
        var1_1 = var3_11;
        if (var10_6 == false) return new PointF(var1_1 / var5_9, var4_10 / var6_8);
        var1_1 = var5_9 - var3_11;
        return new PointF(var1_1 / var5_9, var4_10 / var6_8);
    }
}
