/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemAnimatorFinishedListener
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemAnimatorListener
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public static abstract class RecyclerView.ItemAnimator {
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    public static final int FLAG_CHANGED = 2;
    public static final int FLAG_INVALIDATED = 4;
    public static final int FLAG_MOVED = 2048;
    public static final int FLAG_REMOVED = 8;
    private long mAddDuration = 120L;
    private long mChangeDuration = 250L;
    private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList();
    private ItemAnimatorListener mListener = null;
    private long mMoveDuration = 250L;
    private long mRemoveDuration = 120L;

    static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder viewHolder) {
        int n = viewHolder.mFlags & 0xE;
        if (viewHolder.isInvalid()) {
            return 4;
        }
        int n2 = n;
        if ((n & 4) != 0) return n2;
        int n3 = viewHolder.getOldPosition();
        int n4 = viewHolder.getAbsoluteAdapterPosition();
        n2 = n;
        if (n3 == -1) return n2;
        n2 = n;
        if (n4 == -1) return n2;
        n2 = n;
        if (n3 == n4) return n2;
        n2 = n | 0x800;
        return n2;
    }

    public abstract boolean animateAppearance(RecyclerView.ViewHolder var1, ItemHolderInfo var2, ItemHolderInfo var3);

    public abstract boolean animateChange(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2, ItemHolderInfo var3, ItemHolderInfo var4);

    public abstract boolean animateDisappearance(RecyclerView.ViewHolder var1, ItemHolderInfo var2, ItemHolderInfo var3);

    public abstract boolean animatePersistence(RecyclerView.ViewHolder var1, ItemHolderInfo var2, ItemHolderInfo var3);

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder) {
        return true;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return this.canReuseUpdatedViewHolder(viewHolder);
    }

    public final void dispatchAnimationFinished(RecyclerView.ViewHolder viewHolder) {
        this.onAnimationFinished(viewHolder);
        ItemAnimatorListener itemAnimatorListener = this.mListener;
        if (itemAnimatorListener == null) return;
        itemAnimatorListener.onAnimationFinished(viewHolder);
    }

    public final void dispatchAnimationStarted(RecyclerView.ViewHolder viewHolder) {
        this.onAnimationStarted(viewHolder);
    }

    public final void dispatchAnimationsFinished() {
        int n = this.mFinishedListeners.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mFinishedListeners.clear();
                return;
            }
            this.mFinishedListeners.get(n2).onAnimationsFinished();
            ++n2;
        }
    }

    public abstract void endAnimation(RecyclerView.ViewHolder var1);

    public abstract void endAnimations();

    public long getAddDuration() {
        return this.mAddDuration;
    }

    public long getChangeDuration() {
        return this.mChangeDuration;
    }

    public long getMoveDuration() {
        return this.mMoveDuration;
    }

    public long getRemoveDuration() {
        return this.mRemoveDuration;
    }

    public abstract boolean isRunning();

    public final boolean isRunning(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
        boolean bl = this.isRunning();
        if (itemAnimatorFinishedListener == null) return bl;
        if (!bl) {
            itemAnimatorFinishedListener.onAnimationsFinished();
        } else {
            this.mFinishedListeners.add(itemAnimatorFinishedListener);
        }
        return bl;
    }

    public ItemHolderInfo obtainHolderInfo() {
        return new ItemHolderInfo();
    }

    public void onAnimationFinished(RecyclerView.ViewHolder viewHolder) {
    }

    public void onAnimationStarted(RecyclerView.ViewHolder viewHolder) {
    }

    public ItemHolderInfo recordPostLayoutInformation(RecyclerView.State state, RecyclerView.ViewHolder viewHolder) {
        return this.obtainHolderInfo().setFrom(viewHolder);
    }

    public ItemHolderInfo recordPreLayoutInformation(RecyclerView.State state, RecyclerView.ViewHolder viewHolder, int n, List<Object> list) {
        return this.obtainHolderInfo().setFrom(viewHolder);
    }

    public abstract void runPendingAnimations();

    public void setAddDuration(long l) {
        this.mAddDuration = l;
    }

    public void setChangeDuration(long l) {
        this.mChangeDuration = l;
    }

    void setListener(ItemAnimatorListener itemAnimatorListener) {
        this.mListener = itemAnimatorListener;
    }

    public void setMoveDuration(long l) {
        this.mMoveDuration = l;
    }

    public void setRemoveDuration(long l) {
        this.mRemoveDuration = l;
    }
}
