/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$RecycledViewPool
 *  androidx.recyclerview.widget.RecyclerView$RecyclerListener
 *  androidx.recyclerview.widget.RecyclerView$ViewCacheExtension
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate$ItemDelegate
 */
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public final class RecyclerView.Recycler {
    static final int DEFAULT_CACHE_SIZE = 2;
    final ArrayList<RecyclerView.ViewHolder> mAttachedScrap;
    final ArrayList<RecyclerView.ViewHolder> mCachedViews;
    ArrayList<RecyclerView.ViewHolder> mChangedScrap;
    RecyclerView.RecycledViewPool mRecyclerPool;
    private int mRequestedCacheMax;
    private final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap;
    private RecyclerView.ViewCacheExtension mViewCacheExtension;
    int mViewCacheMax;
    final RecyclerView this$0;

    public RecyclerView.Recycler(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
        this.mAttachedScrap = new ArrayList();
        this.mChangedScrap = null;
        this.mCachedViews = new ArrayList();
        this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
        this.mRequestedCacheMax = 2;
        this.mViewCacheMax = 2;
    }

    private void attachAccessibilityDelegateOnBind(RecyclerView.ViewHolder viewHolder) {
        if (!this.this$0.isAccessibilityEnabled()) return;
        viewHolder = viewHolder.itemView;
        if (ViewCompat.getImportantForAccessibility((View)viewHolder) == 0) {
            ViewCompat.setImportantForAccessibility((View)viewHolder, (int)1);
        }
        if (this.this$0.mAccessibilityDelegate == null) {
            return;
        }
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.this$0.mAccessibilityDelegate.getItemDelegate();
        if (accessibilityDelegateCompat instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
            ((RecyclerViewAccessibilityDelegate.ItemDelegate)accessibilityDelegateCompat).saveOriginalDelegate((View)viewHolder);
        }
        ViewCompat.setAccessibilityDelegate((View)viewHolder, (AccessibilityDelegateCompat)accessibilityDelegateCompat);
    }

    private void invalidateDisplayListInt(ViewGroup viewGroup, boolean bl) {
        int n;
        for (n = viewGroup.getChildCount() - 1; n >= 0; --n) {
            View view = viewGroup.getChildAt(n);
            if (!(view instanceof ViewGroup)) continue;
            this.invalidateDisplayListInt((ViewGroup)view, true);
        }
        if (!bl) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
        } else {
            n = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(n);
        }
    }

    private void invalidateDisplayListInt(RecyclerView.ViewHolder viewHolder) {
        if (!(viewHolder.itemView instanceof ViewGroup)) return;
        this.invalidateDisplayListInt((ViewGroup)viewHolder.itemView, false);
    }

    private boolean tryBindViewHolderByDeadline(RecyclerView.ViewHolder viewHolder, int n, int n2, long l) {
        viewHolder.mBindingAdapter = null;
        viewHolder.mOwnerRecyclerView = this.this$0;
        int n3 = viewHolder.getItemViewType();
        long l2 = this.this$0.getNanoTime();
        if (l != Long.MAX_VALUE && !this.mRecyclerPool.willBindInTime(n3, l2, l)) {
            return false;
        }
        this.this$0.mAdapter.bindViewHolder(viewHolder, n);
        l = this.this$0.getNanoTime();
        this.mRecyclerPool.factorInBindTime(viewHolder.getItemViewType(), l - l2);
        this.attachAccessibilityDelegateOnBind(viewHolder);
        if (!this.this$0.mState.isPreLayout()) return true;
        viewHolder.mPreLayoutPosition = n2;
        return true;
    }

    void addViewHolderToRecycledViewPool(RecyclerView.ViewHolder viewHolder, boolean bl) {
        RecyclerView.clearNestedRecyclerViewIfNotNested((RecyclerView.ViewHolder)viewHolder);
        View view = viewHolder.itemView;
        if (this.this$0.mAccessibilityDelegate != null) {
            Object object = this.this$0.mAccessibilityDelegate.getItemDelegate();
            object = object instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? ((RecyclerViewAccessibilityDelegate.ItemDelegate)object).getAndRemoveOriginalDelegateForItem(view) : null;
            ViewCompat.setAccessibilityDelegate((View)view, (AccessibilityDelegateCompat)object);
        }
        if (bl) {
            this.dispatchViewRecycled(viewHolder);
        }
        viewHolder.mBindingAdapter = null;
        viewHolder.mOwnerRecyclerView = null;
        this.getRecycledViewPool().putRecycledView(viewHolder);
    }

    public void bindViewToPosition(View object, int n) {
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)object);
        if (viewHolder == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            ((StringBuilder)object).append(this.this$0.exceptionLabel());
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        int n2 = this.this$0.mAdapterHelper.findPositionOffset(n);
        if (n2 >= 0 && n2 < this.this$0.mAdapter.getItemCount()) {
            this.tryBindViewHolderByDeadline(viewHolder, n2, n, Long.MAX_VALUE);
            object = viewHolder.itemView.getLayoutParams();
            if (object == null) {
                object = (RecyclerView.LayoutParams)this.this$0.generateDefaultLayoutParams();
                viewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)object);
            } else if (!this.this$0.checkLayoutParams((ViewGroup.LayoutParams)object)) {
                object = (RecyclerView.LayoutParams)this.this$0.generateLayoutParams((ViewGroup.LayoutParams)object);
                viewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)object);
            } else {
                object = (RecyclerView.LayoutParams)object;
            }
            boolean bl = true;
            ((RecyclerView.LayoutParams)object).mInsetsDirty = true;
            ((RecyclerView.LayoutParams)object).mViewHolder = viewHolder;
            if (viewHolder.itemView.getParent() != null) {
                bl = false;
            }
            ((RecyclerView.LayoutParams)object).mPendingInvalidate = bl;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Inconsistency detected. Invalid item position ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append("(offset:");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(").state:");
        ((StringBuilder)object).append(this.this$0.mState.getItemCount());
        ((StringBuilder)object).append(this.this$0.exceptionLabel());
        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    public void clear() {
        this.mAttachedScrap.clear();
        this.recycleAndClearCachedViews();
    }

    void clearOldPositions() {
        int n;
        int n2 = this.mCachedViews.size();
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            this.mCachedViews.get(n).clearOldPosition();
        }
        n2 = this.mAttachedScrap.size();
        for (n = 0; n < n2; ++n) {
            this.mAttachedScrap.get(n).clearOldPosition();
        }
        ArrayList<RecyclerView.ViewHolder> arrayList = this.mChangedScrap;
        if (arrayList == null) return;
        n2 = arrayList.size();
        n = n3;
        while (n < n2) {
            this.mChangedScrap.get(n).clearOldPosition();
            ++n;
        }
    }

    void clearScrap() {
        this.mAttachedScrap.clear();
        ArrayList<RecyclerView.ViewHolder> arrayList = this.mChangedScrap;
        if (arrayList == null) return;
        arrayList.clear();
    }

    public int convertPreLayoutPositionToPostLayout(int n) {
        if (n >= 0 && n < this.this$0.mState.getItemCount()) {
            if (this.this$0.mState.isPreLayout()) return this.this$0.mAdapterHelper.findPositionOffset(n);
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid position ");
        stringBuilder.append(n);
        stringBuilder.append(". State item count is ");
        stringBuilder.append(this.this$0.mState.getItemCount());
        stringBuilder.append(this.this$0.exceptionLabel());
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    void dispatchViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (this.this$0.mRecyclerListener != null) {
            this.this$0.mRecyclerListener.onViewRecycled(viewHolder);
        }
        int n = this.this$0.mRecyclerListeners.size();
        for (int i = 0; i < n; ++i) {
            ((RecyclerView.RecyclerListener)this.this$0.mRecyclerListeners.get(i)).onViewRecycled(viewHolder);
        }
        if (this.this$0.mAdapter != null) {
            this.this$0.mAdapter.onViewRecycled(viewHolder);
        }
        if (this.this$0.mState == null) return;
        this.this$0.mViewInfoStore.removeViewHolder(viewHolder);
    }

    RecyclerView.ViewHolder getChangedScrapViewForPosition(int n) {
        RecyclerView.ViewHolder viewHolder = this.mChangedScrap;
        if (viewHolder == null) return null;
        int n2 = viewHolder.size();
        if (n2 == 0) {
            return null;
        }
        int n3 = 0;
        for (int i = 0; i < n2; ++i) {
            viewHolder = this.mChangedScrap.get(i);
            if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != n) continue;
            viewHolder.addFlags(32);
            return viewHolder;
        }
        if (!this.this$0.mAdapter.hasStableIds()) return null;
        if ((n = this.this$0.mAdapterHelper.findPositionOffset(n)) <= 0) return null;
        if (n >= this.this$0.mAdapter.getItemCount()) return null;
        long l = this.this$0.mAdapter.getItemId(n);
        n = n3;
        while (n < n2) {
            viewHolder = this.mChangedScrap.get(n);
            if (!viewHolder.wasReturnedFromScrap() && viewHolder.getItemId() == l) {
                viewHolder.addFlags(32);
                return viewHolder;
            }
            ++n;
        }
        return null;
    }

    RecyclerView.RecycledViewPool getRecycledViewPool() {
        if (this.mRecyclerPool != null) return this.mRecyclerPool;
        this.mRecyclerPool = new RecyclerView.RecycledViewPool();
        return this.mRecyclerPool;
    }

    int getScrapCount() {
        return this.mAttachedScrap.size();
    }

    public List<RecyclerView.ViewHolder> getScrapList() {
        return this.mUnmodifiableAttachedScrap;
    }

    RecyclerView.ViewHolder getScrapOrCachedViewForId(long l, int n, boolean bl) {
        RecyclerView.ViewHolder viewHolder;
        int n2;
        for (n2 = this.mAttachedScrap.size() - 1; n2 >= 0; --n2) {
            viewHolder = this.mAttachedScrap.get(n2);
            if (viewHolder.getItemId() != l || viewHolder.wasReturnedFromScrap()) continue;
            if (n == viewHolder.getItemViewType()) {
                viewHolder.addFlags(32);
                if (!viewHolder.isRemoved()) return viewHolder;
                if (this.this$0.mState.isPreLayout()) return viewHolder;
                viewHolder.setFlags(2, 14);
                return viewHolder;
            }
            if (bl) continue;
            this.mAttachedScrap.remove(n2);
            this.this$0.removeDetachedView(viewHolder.itemView, false);
            this.quickRecycleScrapView(viewHolder.itemView);
        }
        n2 = this.mCachedViews.size() - 1;
        while (n2 >= 0) {
            viewHolder = this.mCachedViews.get(n2);
            if (viewHolder.getItemId() == l && !viewHolder.isAttachedToTransitionOverlay()) {
                if (n == viewHolder.getItemViewType()) {
                    if (bl) return viewHolder;
                    this.mCachedViews.remove(n2);
                    return viewHolder;
                }
                if (!bl) {
                    this.recycleCachedViewAt(n2);
                    return null;
                }
            }
            --n2;
        }
        return null;
    }

    RecyclerView.ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int n, boolean bl) {
        Object object;
        RecyclerView.ViewHolder viewHolder;
        int n2;
        int n3 = this.mAttachedScrap.size();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            viewHolder = this.mAttachedScrap.get(n2);
            if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != n || viewHolder.isInvalid() || !this.this$0.mState.mInPreLayout && viewHolder.isRemoved()) continue;
            viewHolder.addFlags(32);
            return viewHolder;
        }
        if (!bl && (object = this.this$0.mChildHelper.findHiddenNonRemovedView(n)) != null) {
            viewHolder = RecyclerView.getChildViewHolderInt((View)object);
            this.this$0.mChildHelper.unhide((View)object);
            n = this.this$0.mChildHelper.indexOfChild((View)object);
            if (n != -1) {
                this.this$0.mChildHelper.detachViewFromParent(n);
                this.scrapView((View)object);
                viewHolder.addFlags(8224);
                return viewHolder;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("layout index should not be -1 after unhiding a view:");
            ((StringBuilder)object).append(viewHolder);
            ((StringBuilder)object).append(this.this$0.exceptionLabel());
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        n3 = this.mCachedViews.size();
        n2 = n4;
        while (n2 < n3) {
            viewHolder = this.mCachedViews.get(n2);
            if (!viewHolder.isInvalid() && viewHolder.getLayoutPosition() == n && !viewHolder.isAttachedToTransitionOverlay()) {
                if (bl) return viewHolder;
                this.mCachedViews.remove(n2);
                return viewHolder;
            }
            ++n2;
        }
        return null;
    }

    View getScrapViewAt(int n) {
        return this.mAttachedScrap.get((int)n).itemView;
    }

    public View getViewForPosition(int n) {
        return this.getViewForPosition(n, false);
    }

    View getViewForPosition(int n, boolean bl) {
        return this.tryGetViewHolderForPositionByDeadline((int)n, (boolean)bl, (long)Long.MAX_VALUE).itemView;
    }

    void markItemDecorInsetsDirty() {
        int n = this.mCachedViews.size();
        int n2 = 0;
        while (n2 < n) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)this.mCachedViews.get((int)n2).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.mInsetsDirty = true;
            }
            ++n2;
        }
    }

    void markKnownViewsInvalid() {
        int n = this.mCachedViews.size();
        for (int i = 0; i < n; ++i) {
            RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(i);
            if (viewHolder == null) continue;
            viewHolder.addFlags(6);
            viewHolder.addChangePayload(null);
        }
        if (this.this$0.mAdapter != null) {
            if (this.this$0.mAdapter.hasStableIds()) return;
        }
        this.recycleAndClearCachedViews();
    }

    void offsetPositionRecordsForInsert(int n, int n2) {
        int n3 = this.mCachedViews.size();
        int n4 = 0;
        while (n4 < n3) {
            RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(n4);
            if (viewHolder != null && viewHolder.mPosition >= n) {
                viewHolder.offsetPosition(n2, false);
            }
            ++n4;
        }
    }

    void offsetPositionRecordsForMove(int n, int n2) {
        int n3;
        int n4;
        int n5;
        if (n < n2) {
            n5 = -1;
            n4 = n;
            n3 = n2;
        } else {
            n5 = 1;
            n3 = n;
            n4 = n2;
        }
        int n6 = this.mCachedViews.size();
        int n7 = 0;
        while (n7 < n6) {
            RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(n7);
            if (viewHolder != null && viewHolder.mPosition >= n4 && viewHolder.mPosition <= n3) {
                if (viewHolder.mPosition == n) {
                    viewHolder.offsetPosition(n2 - n, false);
                } else {
                    viewHolder.offsetPosition(n5, false);
                }
            }
            ++n7;
        }
    }

    void offsetPositionRecordsForRemove(int n, int n2, boolean bl) {
        int n3 = this.mCachedViews.size() - 1;
        while (n3 >= 0) {
            RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(n3);
            if (viewHolder != null) {
                if (viewHolder.mPosition >= n + n2) {
                    viewHolder.offsetPosition(-n2, bl);
                } else if (viewHolder.mPosition >= n) {
                    viewHolder.addFlags(8);
                    this.recycleCachedViewAt(n3);
                }
            }
            --n3;
        }
    }

    void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2, boolean bl) {
        this.clear();
        this.getRecycledViewPool().onAdapterChanged(adapter, adapter2, bl);
    }

    void quickRecycleScrapView(View view) {
        view = RecyclerView.getChildViewHolderInt((View)view);
        view.mScrapContainer = null;
        view.mInChangeScrap = false;
        view.clearReturnedFromScrapFlag();
        this.recycleViewHolderInternal((RecyclerView.ViewHolder)view);
    }

    void recycleAndClearCachedViews() {
        int n = this.mCachedViews.size() - 1;
        while (true) {
            if (n < 0) {
                this.mCachedViews.clear();
                if (!RecyclerView.ALLOW_THREAD_GAP_WORK) return;
                this.this$0.mPrefetchRegistry.clearPrefetchPositions();
                return;
            }
            this.recycleCachedViewAt(n);
            --n;
        }
    }

    void recycleCachedViewAt(int n) {
        this.addViewHolderToRecycledViewPool(this.mCachedViews.get(n), true);
        this.mCachedViews.remove(n);
    }

    public void recycleView(View view) {
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)view);
        if (viewHolder.isTmpDetached()) {
            this.this$0.removeDetachedView(view, false);
        }
        if (viewHolder.isScrap()) {
            viewHolder.unScrap();
        } else if (viewHolder.wasReturnedFromScrap()) {
            viewHolder.clearReturnedFromScrapFlag();
        }
        this.recycleViewHolderInternal(viewHolder);
        if (this.this$0.mItemAnimator == null) return;
        if (viewHolder.isRecyclable()) return;
        this.this$0.mItemAnimator.endAnimation(viewHolder);
    }

    /*
     * Unable to fully structure code
     */
    void recycleViewHolderInternal(RecyclerView.ViewHolder var1_1) {
        block7: {
            block14: {
                block12: {
                    block13: {
                        block10: {
                            block8: {
                                block11: {
                                    block9: {
                                        var6_2 = var1_1.isScrap();
                                        var5_3 = false;
                                        var3_4 = 0;
                                        var4_5 = 1;
                                        if (var6_2 || var1_1.itemView.getParent() != null) break block8;
                                        if (var1_1.isTmpDetached()) {
                                            var7_7 = new StringBuilder();
                                            var7_7.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                                            var7_7.append(var1_1);
                                            var7_7.append(this.this$0.exceptionLabel());
                                            throw new IllegalArgumentException(var7_7.toString());
                                        }
                                        if (var1_1.shouldIgnore()) {
                                            var1_1 = new StringBuilder();
                                            var1_1.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                                            var1_1.append(this.this$0.exceptionLabel());
                                            throw new IllegalArgumentException(var1_1.toString());
                                        }
                                        var5_3 = var1_1.doesTransientStatePreventRecycling();
                                        var2_6 = this.this$0.mAdapter != null && var5_3 != false && this.this$0.mAdapter.onFailedToRecycleView((RecyclerView.ViewHolder)var1_1) != false ? 1 : 0;
                                        if (var2_6 != 0) break block9;
                                        var2_6 = var3_4;
                                        if (!var1_1.isRecyclable()) break block10;
                                    }
                                    if (this.mViewCacheMax <= 0 || var1_1.hasAnyOfTheFlags(526)) break block11;
                                    var2_6 = var3_4 = this.mCachedViews.size();
                                    if (var3_4 >= this.mViewCacheMax) {
                                        var2_6 = var3_4;
                                        if (var3_4 > 0) {
                                            this.recycleCachedViewAt(0);
                                            var2_6 = var3_4 - 1;
                                        }
                                    }
                                    var3_4 = var2_6;
                                    if (!RecyclerView.ALLOW_THREAD_GAP_WORK) break block12;
                                    var3_4 = var2_6;
                                    if (var2_6 <= 0) break block12;
                                    var3_4 = var2_6--;
                                    if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(var1_1.mPosition)) break block12;
                                    break block13;
                                }
                                var2_6 = 0;
                                break block14;
                            }
                            var7_8 = new StringBuilder();
                            var7_8.append("Scrapped or attached views may not be recycled. isScrap:");
                            var7_8.append(var1_1.isScrap());
                            var7_8.append(" isAttached:");
                            if (var1_1.itemView.getParent() != null) {
                                var5_3 = true;
                            }
                            var7_8.append(var5_3);
                            var7_8.append(this.this$0.exceptionLabel());
                            var1_1 = new IllegalArgumentException(var7_8.toString());
                            throw var1_1;
                        }
lbl62:
                        // 2 sources

                        while (true) {
                            var3_4 = 0;
                            break block7;
                            break;
                        }
                    }
                    while (var2_6 >= 0 && this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(var3_4 = this.mCachedViews.get((int)var2_6).mPosition)) {
                        --var2_6;
                    }
                    var3_4 = var2_6 + 1;
                }
                this.mCachedViews.add(var3_4, (RecyclerView.ViewHolder)var1_1);
                var2_6 = 1;
            }
            ** while (var2_6 != 0)
lbl75:
            // 1 sources

            this.addViewHolderToRecycledViewPool((RecyclerView.ViewHolder)var1_1, true);
            var3_4 = var4_5;
        }
        this.this$0.mViewInfoStore.removeViewHolder((RecyclerView.ViewHolder)var1_1);
        if (var2_6 != 0) return;
        if (var3_4 != 0) return;
        if (var5_3 == false) return;
        var1_1.mBindingAdapter = null;
        var1_1.mOwnerRecyclerView = null;
    }

    void scrapView(View object) {
        if (!(object = RecyclerView.getChildViewHolderInt((View)object)).hasAnyOfTheFlags(12) && object.isUpdated() && !this.this$0.canReuseUpdatedViewHolder((RecyclerView.ViewHolder)object)) {
            if (this.mChangedScrap == null) {
                this.mChangedScrap = new ArrayList();
            }
            object.setScrapContainer(this, true);
            this.mChangedScrap.add((RecyclerView.ViewHolder)object);
        } else {
            if (object.isInvalid() && !object.isRemoved() && !this.this$0.mAdapter.hasStableIds()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                ((StringBuilder)object).append(this.this$0.exceptionLabel());
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            object.setScrapContainer(this, false);
            this.mAttachedScrap.add((RecyclerView.ViewHolder)object);
        }
    }

    void setRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        RecyclerView.RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
        if (recycledViewPool2 != null) {
            recycledViewPool2.detach();
        }
        this.mRecyclerPool = recycledViewPool;
        if (recycledViewPool == null) return;
        if (this.this$0.getAdapter() == null) return;
        this.mRecyclerPool.attach();
    }

    void setViewCacheExtension(RecyclerView.ViewCacheExtension viewCacheExtension) {
        this.mViewCacheExtension = viewCacheExtension;
    }

    public void setViewCacheSize(int n) {
        this.mRequestedCacheMax = n;
        this.updateViewCacheSize();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int var1_1, boolean var2_2, long var3_3) {
        block27: {
            block34: {
                block33: {
                    block31: {
                        block32: {
                            block30: {
                                block29: {
                                    block28: {
                                        if (var1_1 < 0 || var1_1 >= this.this$0.mState.getItemCount()) break block27;
                                        var14_4 = this.this$0.mState.isPreLayout();
                                        var13_5 = true;
                                        if (!var14_4) break block28;
                                        var15_6 = this.getChangedScrapViewForPosition(var1_1);
                                        var16_8 /* !! */  = var15_6;
                                        if (var15_6 == null) break block29;
                                        var6_9 = 1;
                                        var16_8 /* !! */  = var15_6;
                                        break block30;
                                    }
                                    var16_8 /* !! */  = null;
                                }
                                var6_9 = 0;
                            }
                            var15_6 = var16_8 /* !! */ ;
                            var5_10 = var6_9;
                            if (var16_8 /* !! */  == null) {
                                var16_8 /* !! */  = this.getScrapOrHiddenOrCachedHolderForPosition(var1_1, var2_2);
                                var15_6 = var16_8 /* !! */ ;
                                var5_10 = var6_9;
                                if (var16_8 /* !! */  != null) {
                                    if (!this.validateViewHolderForOffsetPosition(var16_8 /* !! */ )) {
                                        if (!var2_2) {
                                            var16_8 /* !! */ .addFlags(4);
                                            if (var16_8 /* !! */ .isScrap()) {
                                                this.this$0.removeDetachedView(var16_8 /* !! */ .itemView, false);
                                                var16_8 /* !! */ .unScrap();
                                            } else if (var16_8 /* !! */ .wasReturnedFromScrap()) {
                                                var16_8 /* !! */ .clearReturnedFromScrapFlag();
                                            }
                                            this.recycleViewHolderInternal(var16_8 /* !! */ );
                                        }
                                        var15_6 = null;
                                        var5_10 = var6_9;
                                    } else {
                                        var5_10 = 1;
                                        var15_6 = var16_8 /* !! */ ;
                                    }
                                }
                            }
                            var16_8 /* !! */  = var15_6;
                            var7_11 = var5_10;
                            if (var15_6 != null) break block31;
                            var7_11 = this.this$0.mAdapterHelper.findPositionOffset(var1_1);
                            if (var7_11 < 0 || var7_11 >= this.this$0.mAdapter.getItemCount()) break block32;
                            var8_12 = this.this$0.mAdapter.getItemViewType(var7_11);
                            var6_9 = var5_10;
                            if (this.this$0.mAdapter.hasStableIds()) {
                                var16_8 /* !! */  = this.getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(var7_11), var8_12, var2_2);
                                var15_6 = var16_8 /* !! */ ;
                                var6_9 = var5_10;
                                if (var16_8 /* !! */  != null) {
                                    var16_8 /* !! */ .mPosition = var7_11;
                                    var6_9 = 1;
                                    var15_6 = var16_8 /* !! */ ;
                                }
                            }
                            var16_8 /* !! */  = var15_6;
                            if (var15_6 == null) {
                                var17_13 = this.mViewCacheExtension;
                                var16_8 /* !! */  = var15_6;
                                if (var17_13 != null) {
                                    var17_13 = var17_13.getViewForPositionAndType(this, var1_1, var8_12);
                                    var16_8 /* !! */  = var15_6;
                                    if (var17_13 != null) {
                                        var16_8 /* !! */  = this.this$0.getChildViewHolder((View)var17_13);
                                        if (var16_8 /* !! */  == null) {
                                            var15_6 = new StringBuilder();
                                            var15_6.append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                            var15_6.append(this.this$0.exceptionLabel());
                                            throw new IllegalArgumentException(var15_6.toString());
                                        }
                                        if (var16_8 /* !! */ .shouldIgnore()) {
                                            var15_6 = new StringBuilder();
                                            var15_6.append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                            var15_6.append(this.this$0.exceptionLabel());
                                            throw new IllegalArgumentException(var15_6.toString());
                                        }
                                    }
                                }
                            }
                            var15_6 = var16_8 /* !! */ ;
                            if (var16_8 /* !! */  == null && (var15_6 = this.getRecycledViewPool().getRecycledView(var8_12)) != null) {
                                var15_6.resetInternal();
                                if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                    this.invalidateDisplayListInt((RecyclerView.ViewHolder)var15_6);
                                }
                            }
                            var16_8 /* !! */  = var15_6;
                            var7_11 = var6_9;
                            if (var15_6 != null) break block31;
                            var11_14 = this.this$0.getNanoTime();
                            if (var3_3 != 0x7FFFFFFFFFFFFFFFL && !this.mRecyclerPool.willCreateInTime(var8_12, var11_14, var3_3)) {
                                return null;
                            }
                            var16_8 /* !! */  = this.this$0.mAdapter.createViewHolder((ViewGroup)this.this$0, var8_12);
                            if (RecyclerView.ALLOW_THREAD_GAP_WORK && (var15_6 = RecyclerView.findNestedRecyclerView((View)var16_8 /* !! */ .itemView)) != null) {
                                var16_8 /* !! */ .mNestedRecyclerView = new WeakReference<Object>(var15_6);
                            }
                            var9_15 = this.this$0.getNanoTime();
                            this.mRecyclerPool.factorInCreateTime(var8_12, var9_15 - var11_14);
                            break block33;
                        }
                        var15_6 = new StringBuilder();
                        var15_6.append("Inconsistency detected. Invalid item position ");
                        var15_6.append(var1_1);
                        var15_6.append("(offset:");
                        var15_6.append(var7_11);
                        var15_6.append(").state:");
                        var15_6.append(this.this$0.mState.getItemCount());
                        var15_6.append(this.this$0.exceptionLabel());
                        throw new IndexOutOfBoundsException(var15_6.toString());
                    }
                    var6_9 = var7_11;
                }
                if (var6_9 != 0 && !this.this$0.mState.isPreLayout() && var16_8 /* !! */ .hasAnyOfTheFlags(8192)) {
                    var16_8 /* !! */ .setFlags(0, 8192);
                    if (this.this$0.mState.mRunSimpleAnimations) {
                        var5_10 = RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)var16_8 /* !! */ );
                        var15_6 = this.this$0.mItemAnimator.recordPreLayoutInformation(this.this$0.mState, var16_8 /* !! */ , var5_10 | 4096, var16_8 /* !! */ .getUnmodifiedPayloads());
                        this.this$0.recordAnimationInfoIfBouncedHiddenView(var16_8 /* !! */ , (RecyclerView.ItemAnimator.ItemHolderInfo)var15_6);
                    }
                }
                if (!this.this$0.mState.isPreLayout() || !var16_8 /* !! */ .isBound()) break block34;
                var16_8 /* !! */ .mPreLayoutPosition = var1_1;
                ** GOTO lbl-1000
            }
            if (var16_8 /* !! */ .isBound() && !var16_8 /* !! */ .needsUpdate() && !var16_8 /* !! */ .isInvalid()) lbl-1000:
            // 2 sources

            {
                var2_2 = false;
            } else {
                var2_2 = this.tryBindViewHolderByDeadline(var16_8 /* !! */ , this.this$0.mAdapterHelper.findPositionOffset(var1_1), var1_1, var3_3);
            }
            var15_6 = var16_8 /* !! */ .itemView.getLayoutParams();
            if (var15_6 == null) {
                var15_6 = (RecyclerView.LayoutParams)this.this$0.generateDefaultLayoutParams();
                var16_8 /* !! */ .itemView.setLayoutParams((ViewGroup.LayoutParams)var15_6);
            } else if (!this.this$0.checkLayoutParams((ViewGroup.LayoutParams)var15_6)) {
                var15_6 = (RecyclerView.LayoutParams)this.this$0.generateLayoutParams((ViewGroup.LayoutParams)var15_6);
                var16_8 /* !! */ .itemView.setLayoutParams((ViewGroup.LayoutParams)var15_6);
            } else {
                var15_6 = (RecyclerView.LayoutParams)var15_6;
            }
            var15_6.mViewHolder = var16_8 /* !! */ ;
            var2_2 = var6_9 != 0 && var2_2 != false ? var13_5 : false;
            var15_6.mPendingInvalidate = var2_2;
            return var16_8 /* !! */ ;
        }
        var15_7 = new StringBuilder();
        var15_7.append("Invalid item position ");
        var15_7.append(var1_1);
        var15_7.append("(");
        var15_7.append(var1_1);
        var15_7.append("). Item count:");
        var15_7.append(this.this$0.mState.getItemCount());
        var15_7.append(this.this$0.exceptionLabel());
        throw new IndexOutOfBoundsException(var15_7.toString());
    }

    void unscrapView(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.mInChangeScrap) {
            this.mChangedScrap.remove(viewHolder);
        } else {
            this.mAttachedScrap.remove(viewHolder);
        }
        viewHolder.mScrapContainer = null;
        viewHolder.mInChangeScrap = false;
        viewHolder.clearReturnedFromScrapFlag();
    }

    void updateViewCacheSize() {
        int n = this.this$0.mLayout != null ? this.this$0.mLayout.mPrefetchMaxCountObserved : 0;
        this.mViewCacheMax = this.mRequestedCacheMax + n;
        n = this.mCachedViews.size() - 1;
        while (n >= 0) {
            if (this.mCachedViews.size() <= this.mViewCacheMax) return;
            this.recycleCachedViewAt(n);
            --n;
        }
    }

    boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.isRemoved()) {
            return this.this$0.mState.isPreLayout();
        }
        if (viewHolder.mPosition >= 0 && viewHolder.mPosition < this.this$0.mAdapter.getItemCount()) {
            boolean bl = this.this$0.mState.isPreLayout();
            boolean bl2 = false;
            if (!bl && this.this$0.mAdapter.getItemViewType(viewHolder.mPosition) != viewHolder.getItemViewType()) {
                return false;
            }
            if (!this.this$0.mAdapter.hasStableIds()) return true;
            if (viewHolder.getItemId() != this.this$0.mAdapter.getItemId(viewHolder.mPosition)) return bl2;
            bl2 = true;
            return bl2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
        stringBuilder.append(viewHolder);
        stringBuilder.append(this.this$0.exceptionLabel());
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    void viewRangeUpdate(int n, int n2) {
        int n3 = this.mCachedViews.size() - 1;
        while (n3 >= 0) {
            int n4;
            RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(n3);
            if (viewHolder != null && (n4 = viewHolder.mPosition) >= n && n4 < n2 + n) {
                viewHolder.addFlags(2);
                this.recycleCachedViewAt(n3);
            }
            --n3;
        }
    }
}
