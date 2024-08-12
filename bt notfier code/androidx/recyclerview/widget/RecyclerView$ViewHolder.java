/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$Recycler
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public static abstract class RecyclerView.ViewHolder {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
    static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
    public final View itemView;
    RecyclerView.Adapter<? extends RecyclerView.ViewHolder> mBindingAdapter;
    int mFlags;
    boolean mInChangeScrap = false;
    private int mIsRecyclableCount = 0;
    long mItemId = -1L;
    int mItemViewType = -1;
    WeakReference<RecyclerView> mNestedRecyclerView;
    int mOldPosition = -1;
    RecyclerView mOwnerRecyclerView;
    List<Object> mPayloads = null;
    int mPendingAccessibilityState = -1;
    int mPosition = -1;
    int mPreLayoutPosition = -1;
    RecyclerView.Recycler mScrapContainer = null;
    RecyclerView.ViewHolder mShadowedHolder = null;
    RecyclerView.ViewHolder mShadowingHolder = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mWasImportantForAccessibilityBeforeHidden = 0;

    public RecyclerView.ViewHolder(View view) {
        if (view == null) throw new IllegalArgumentException("itemView may not be null");
        this.itemView = view;
    }

    private void createPayloadsIfNeeded() {
        if (this.mPayloads != null) return;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        this.mPayloads = arrayList;
        this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
    }

    void addChangePayload(Object object) {
        if (object == null) {
            this.addFlags(1024);
        } else {
            if ((0x400 & this.mFlags) != 0) return;
            this.createPayloadsIfNeeded();
            this.mPayloads.add(object);
        }
    }

    void addFlags(int n) {
        this.mFlags = n | this.mFlags;
    }

    void clearOldPosition() {
        this.mOldPosition = -1;
        this.mPreLayoutPosition = -1;
    }

    void clearPayload() {
        List<Object> list = this.mPayloads;
        if (list != null) {
            list.clear();
        }
        this.mFlags &= 0xFFFFFBFF;
    }

    void clearReturnedFromScrapFlag() {
        this.mFlags &= 0xFFFFFFDF;
    }

    void clearTmpDetachFlag() {
        this.mFlags &= 0xFFFFFEFF;
    }

    boolean doesTransientStatePreventRecycling() {
        boolean bl = (this.mFlags & 0x10) == 0 && ViewCompat.hasTransientState((View)this.itemView);
        return bl;
    }

    void flagRemovedAndOffsetPosition(int n, int n2, boolean bl) {
        this.addFlags(8);
        this.offsetPosition(n2, bl);
        this.mPosition = n;
    }

    public final int getAbsoluteAdapterPosition() {
        RecyclerView recyclerView = this.mOwnerRecyclerView;
        if (recyclerView != null) return recyclerView.getAdapterPositionInRecyclerView(this);
        return -1;
    }

    @Deprecated
    public final int getAdapterPosition() {
        return this.getBindingAdapterPosition();
    }

    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getBindingAdapter() {
        return this.mBindingAdapter;
    }

    public final int getBindingAdapterPosition() {
        if (this.mBindingAdapter == null) {
            return -1;
        }
        RecyclerView recyclerView = this.mOwnerRecyclerView;
        if (recyclerView == null) {
            return -1;
        }
        if ((recyclerView = recyclerView.getAdapter()) == null) {
            return -1;
        }
        int n = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this);
        if (n != -1) return recyclerView.findRelativeAdapterPositionIn(this.mBindingAdapter, this, n);
        return -1;
    }

    public final long getItemId() {
        return this.mItemId;
    }

    public final int getItemViewType() {
        return this.mItemViewType;
    }

    public final int getLayoutPosition() {
        int n;
        int n2 = n = this.mPreLayoutPosition;
        if (n != -1) return n2;
        n2 = this.mPosition;
        return n2;
    }

    public final int getOldPosition() {
        return this.mOldPosition;
    }

    @Deprecated
    public final int getPosition() {
        int n;
        int n2 = n = this.mPreLayoutPosition;
        if (n != -1) return n2;
        n2 = this.mPosition;
        return n2;
    }

    List<Object> getUnmodifiedPayloads() {
        if ((this.mFlags & 0x400) != 0) return FULLUPDATE_PAYLOADS;
        List<Object> list = this.mPayloads;
        if (list == null) return FULLUPDATE_PAYLOADS;
        if (list.size() != 0) return this.mUnmodifiedPayloads;
        return FULLUPDATE_PAYLOADS;
    }

    boolean hasAnyOfTheFlags(int n) {
        boolean bl = (n & this.mFlags) != 0;
        return bl;
    }

    boolean isAdapterPositionUnknown() {
        boolean bl = (this.mFlags & 0x200) != 0 || this.isInvalid();
        return bl;
    }

    boolean isAttachedToTransitionOverlay() {
        boolean bl = this.itemView.getParent() != null && this.itemView.getParent() != this.mOwnerRecyclerView;
        return bl;
    }

    boolean isBound() {
        int n = this.mFlags;
        boolean bl = true;
        if ((n & 1) != 0) return bl;
        bl = false;
        return bl;
    }

    boolean isInvalid() {
        boolean bl = (this.mFlags & 4) != 0;
        return bl;
    }

    public final boolean isRecyclable() {
        boolean bl = (this.mFlags & 0x10) == 0 && !ViewCompat.hasTransientState((View)this.itemView);
        return bl;
    }

    boolean isRemoved() {
        boolean bl = (this.mFlags & 8) != 0;
        return bl;
    }

    boolean isScrap() {
        boolean bl = this.mScrapContainer != null;
        return bl;
    }

    boolean isTmpDetached() {
        boolean bl = (this.mFlags & 0x100) != 0;
        return bl;
    }

    boolean isUpdated() {
        boolean bl = (this.mFlags & 2) != 0;
        return bl;
    }

    boolean needsUpdate() {
        boolean bl = (this.mFlags & 2) != 0;
        return bl;
    }

    void offsetPosition(int n, boolean bl) {
        if (this.mOldPosition == -1) {
            this.mOldPosition = this.mPosition;
        }
        if (this.mPreLayoutPosition == -1) {
            this.mPreLayoutPosition = this.mPosition;
        }
        if (bl) {
            this.mPreLayoutPosition += n;
        }
        this.mPosition += n;
        if (this.itemView.getLayoutParams() == null) return;
        ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).mInsetsDirty = true;
    }

    void onEnteredHiddenState(RecyclerView recyclerView) {
        int n = this.mPendingAccessibilityState;
        this.mWasImportantForAccessibilityBeforeHidden = n != -1 ? n : ViewCompat.getImportantForAccessibility((View)this.itemView);
        recyclerView.setChildImportantForAccessibilityInternal(this, 4);
    }

    void onLeftHiddenState(RecyclerView recyclerView) {
        recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
        this.mWasImportantForAccessibilityBeforeHidden = 0;
    }

    void resetInternal() {
        this.mFlags = 0;
        this.mPosition = -1;
        this.mOldPosition = -1;
        this.mItemId = -1L;
        this.mPreLayoutPosition = -1;
        this.mIsRecyclableCount = 0;
        this.mShadowedHolder = null;
        this.mShadowingHolder = null;
        this.clearPayload();
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        this.mPendingAccessibilityState = -1;
        RecyclerView.clearNestedRecyclerViewIfNotNested((RecyclerView.ViewHolder)this);
    }

    void saveOldPosition() {
        if (this.mOldPosition != -1) return;
        this.mOldPosition = this.mPosition;
    }

    void setFlags(int n, int n2) {
        this.mFlags = n & n2 | this.mFlags & ~n2;
    }

    public final void setIsRecyclable(boolean bl) {
        int n = this.mIsRecyclableCount;
        n = bl ? --n : ++n;
        this.mIsRecyclableCount = n;
        if (n < 0) {
            this.mIsRecyclableCount = 0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
            stringBuilder.append(this);
            Log.e((String)"View", (String)stringBuilder.toString());
        } else if (!bl && n == 1) {
            this.mFlags |= 0x10;
        } else {
            if (!bl) return;
            if (this.mIsRecyclableCount != 0) return;
            this.mFlags &= 0xFFFFFFEF;
        }
    }

    void setScrapContainer(RecyclerView.Recycler recycler, boolean bl) {
        this.mScrapContainer = recycler;
        this.mInChangeScrap = bl;
    }

    boolean shouldBeKeptAsChild() {
        boolean bl = (this.mFlags & 0x10) != 0;
        return bl;
    }

    boolean shouldIgnore() {
        boolean bl = (this.mFlags & 0x80) != 0;
        return bl;
    }

    void stopIgnoring() {
        this.mFlags &= 0xFFFFFF7F;
    }

    public String toString() {
        CharSequence charSequence = this.getClass().isAnonymousClass() ? "ViewHolder" : this.getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append("{");
        stringBuilder.append(Integer.toHexString(this.hashCode()));
        stringBuilder.append(" position=");
        stringBuilder.append(this.mPosition);
        stringBuilder.append(" id=");
        stringBuilder.append(this.mItemId);
        stringBuilder.append(", oldPos=");
        stringBuilder.append(this.mOldPosition);
        stringBuilder.append(", pLpos:");
        stringBuilder.append(this.mPreLayoutPosition);
        stringBuilder = new StringBuilder(stringBuilder.toString());
        if (this.isScrap()) {
            stringBuilder.append(" scrap ");
            charSequence = this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]";
            stringBuilder.append((String)charSequence);
        }
        if (this.isInvalid()) {
            stringBuilder.append(" invalid");
        }
        if (!this.isBound()) {
            stringBuilder.append(" unbound");
        }
        if (this.needsUpdate()) {
            stringBuilder.append(" update");
        }
        if (this.isRemoved()) {
            stringBuilder.append(" removed");
        }
        if (this.shouldIgnore()) {
            stringBuilder.append(" ignored");
        }
        if (this.isTmpDetached()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!this.isRecyclable()) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(" not recyclable(");
            ((StringBuilder)charSequence).append(this.mIsRecyclableCount);
            ((StringBuilder)charSequence).append(")");
            stringBuilder.append(((StringBuilder)charSequence).toString());
        }
        if (this.isAdapterPositionUnknown()) {
            stringBuilder.append(" undefined adapter position");
        }
        if (this.itemView.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    void unScrap() {
        this.mScrapContainer.unscrapView(this);
    }

    boolean wasReturnedFromScrap() {
        boolean bl = (this.mFlags & 0x20) != 0;
        return bl;
    }
}
