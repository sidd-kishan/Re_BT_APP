/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.internal.compat.quirk.DeviceQuirks
 *  androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk
 */
package androidx.camera.core.internal.compat.workaround;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;

public class ExifRotationAvailability {
    public boolean isRotationOptionSupported() {
        ImageCaptureRotationOptionQuirk imageCaptureRotationOptionQuirk = (ImageCaptureRotationOptionQuirk)DeviceQuirks.get(ImageCaptureRotationOptionQuirk.class);
        boolean bl = imageCaptureRotationOptionQuirk != null ? imageCaptureRotationOptionQuirk.isSupported(CaptureConfig.OPTION_ROTATION) : true;
        return bl;
    }

    public boolean shouldUseExifOrientation(ImageProxy imageProxy) {
        ImageCaptureRotationOptionQuirk imageCaptureRotationOptionQuirk = (ImageCaptureRotationOptionQuirk)DeviceQuirks.get(ImageCaptureRotationOptionQuirk.class);
        boolean bl = (imageCaptureRotationOptionQuirk == null || imageCaptureRotationOptionQuirk.isSupported(CaptureConfig.OPTION_ROTATION)) && imageProxy.getFormat() == 256;
        return bl;
    }
}
