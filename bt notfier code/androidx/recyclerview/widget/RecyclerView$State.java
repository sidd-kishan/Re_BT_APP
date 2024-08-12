/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 */
package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;

public static class RecyclerView.State {
    static final int STEP_ANIMATIONS = 4;
    static final int STEP_LAYOUT = 2;
    static final int STEP_START = 1;
    private SparseArray<Object> mData;
    int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    long mFocusedItemId;
    int mFocusedItemPosition;
    int mFocusedSubChildId;
    boolean mInPreLayout = false;
    boolean mIsMeasuring = false;
    int mItemCount = 0;
    int mLayoutStep = 1;
    int mPreviousLayoutItemCount = 0;
    int mRemainingScrollHorizontal;
    int mRemainingScrollVertical;
    boolean mRunPredictiveAnimations = false;
    boolean mRunSimpleAnimations = false;
    boolean mStructureChanged = false;
    int mTargetPosition = -1;
    boolean mTrackOldChangeHolders = false;

    void assertLayoutStep(int n) {
        if ((this.mLayoutStep & n) != 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Layout state should be one of ");
        stringBuilder.append(Integer.toBinaryString(n));
        stringBuilder.append(" but it is ");
        stringBuilder.append(Integer.toBinaryString(this.mLayoutStep));
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean didStructureChange() {
        return this.mStructureChanged;
    }

    public <T> T get(int n) {
        SparseArray<Object> sparseArray = this.mData;
        if (sparseArray != null) return (T)sparseArray.get(n);
        return null;
    }

    public int getItemCount() {
        int n = this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount;
        return n;
    }

    public int getRemainingScrollHorizontal() {
        return this.mRemainingScrollHorizontal;
    }

    public int getRemainingScrollVertical() {
        return this.mRemainingScrollVertical;
    }

    public int getTargetScrollPosition() {
        return this.mTargetPosition;
    }

    public boolean hasTargetScrollPosition() {
        boolean bl = this.mTargetPosition != -1;
        return bl;
    }

    public boolean isMeasuring() {
        return this.mIsMeasuring;
    }

    public boolean isPreLayout() {
        return this.mInPreLayout;
    }

    void prepareForNestedPrefetch(RecyclerView.Adapter adapter) {
        this.mLayoutStep = 1;
        this.mItemCount = adapter.getItemCount();
        this.mInPreLayout = false;
        this.mTrackOldChangeHolders = false;
        this.mIsMeasuring = false;
    }

    public void put(int n, Object object) {
        if (this.mData == null) {
            this.mData = new SparseArray();
        }
        this.mData.put(n, object);
    }

    public void remove(int n) {
        SparseArray<Object> sparseArray = this.mData;
        if (sparseArray == null) {
            return;
        }
        sparseArray.remove(n);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("State{mTargetPosition=");
        stringBuilder.append(this.mTargetPosition);
        stringBuilder.append(", mData=");
        stringBuilder.append(this.mData);
        stringBuilder.append(", mItemCount=");
        stringBuilder.append(this.mItemCount);
        stringBuilder.append(", mIsMeasuring=");
        stringBuilder.append(this.mIsMeasuring);
        stringBuilder.append(", mPreviousLayoutItemCount=");
        stringBuilder.append(this.mPreviousLayoutItemCount);
        stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
        stringBuilder.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
        stringBuilder.append(", mStructureChanged=");
        stringBuilder.append(this.mStructureChanged);
        stringBuilder.append(", mInPreLayout=");
        stringBuilder.append(this.mInPreLayout);
        stringBuilder.append(", mRunSimpleAnimations=");
        stringBuilder.append(this.mRunSimpleAnimations);
        stringBuilder.append(", mRunPredictiveAnimations=");
        stringBuilder.append(this.mRunPredictiveAnimations);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean willRunPredictiveAnimations() {
        return this.mRunPredictiveAnimations;
    }

    public boolean willRunSimpleAnimations() {
        return this.mRunSimpleAnimations;
    }
}
