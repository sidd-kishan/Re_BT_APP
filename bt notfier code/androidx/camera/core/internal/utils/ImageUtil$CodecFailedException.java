/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType
 */
package androidx.camera.core.internal.utils;

import androidx.camera.core.internal.utils.ImageUtil;

public static final class ImageUtil.CodecFailedException
extends Exception {
    private FailureType mFailureType;

    ImageUtil.CodecFailedException(String string) {
        super(string);
        this.mFailureType = FailureType.UNKNOWN;
    }

    ImageUtil.CodecFailedException(String string, FailureType failureType) {
        super(string);
        this.mFailureType = failureType;
    }

    public FailureType getFailureType() {
        return this.mFailureType;
    }
}
