/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Logger
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;

public final class CameraOrientationUtil {
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    public static int degreesToSurfaceRotation(int n) {
        if (n != 0) {
            if (n != 90) {
                if (n != 180) {
                    if (n != 270) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid sensor rotation: ");
                        stringBuilder.append(n);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    n = 3;
                } else {
                    n = 2;
                }
            } else {
                n = 1;
            }
        } else {
            n = 0;
        }
        return n;
    }

    public static int getRelativeImageRotation(int n, int n2, boolean bl) {
        int n3 = bl ? (n2 - n + 360) % 360 : (n2 + n) % 360;
        if (!Logger.isDebugEnabled((String)TAG)) return n3;
        Logger.d((String)TAG, (String)String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", n, n2, bl, n3));
        return n3;
    }

    public static int surfaceRotationToDegrees(int n) {
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unsupported surface rotation: ");
                        stringBuilder.append(n);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    n = 270;
                } else {
                    n = 180;
                }
            } else {
                n = 90;
            }
        } else {
            n = 0;
        }
        return n;
    }
}
