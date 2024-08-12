/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

protected static class LinearLayoutManager.LayoutChunkResult {
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;

    protected LinearLayoutManager.LayoutChunkResult() {
    }

    void resetInternal() {
        this.mConsumed = 0;
        this.mFinished = false;
        this.mIgnoreConsumed = false;
        this.mFocusable = false;
    }
}
