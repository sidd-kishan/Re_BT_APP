/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

public final class FocusMeteringResult {
    private boolean mIsFocusSuccessful;

    private FocusMeteringResult(boolean bl) {
        this.mIsFocusSuccessful = bl;
    }

    public static FocusMeteringResult create(boolean bl) {
        return new FocusMeteringResult(bl);
    }

    public static FocusMeteringResult emptyInstance() {
        return new FocusMeteringResult(false);
    }

    public boolean isFocusSuccessful() {
        return this.mIsFocusSuccessful;
    }
}
