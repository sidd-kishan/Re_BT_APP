/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

public class CameraUnavailableException
extends Exception {
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int CAMERA_MAX_IN_USE = 5;
    public static final int CAMERA_UNAVAILABLE_DO_NOT_DISTURB = 6;
    public static final int CAMERA_UNKNOWN_ERROR = 0;
    private final int mReason;

    public CameraUnavailableException(int n) {
        this.mReason = n;
    }

    public CameraUnavailableException(int n, String string) {
        super(string);
        this.mReason = n;
    }

    public CameraUnavailableException(int n, String string, Throwable throwable) {
        super(string, throwable);
        this.mReason = n;
    }

    public CameraUnavailableException(int n, Throwable throwable) {
        super(throwable);
        this.mReason = n;
    }

    public int getReason() {
        return this.mReason;
    }
}
