/*
 * Decompiled with CFR 0.152.
 */
package androidx.vectordrawable.graphics.drawable;

private static abstract class VectorDrawableCompat.VObject {
    private VectorDrawableCompat.VObject() {
    }

    public boolean isStateful() {
        return false;
    }

    public boolean onStateChanged(int[] nArray) {
        return false;
    }
}
