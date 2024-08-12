/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.view.View
 *  android.view.animation.Interpolator
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.R$dimen
 *  androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation
 *  androidx.recyclerview.widget.ItemTouchHelper$ViewDropHandler
 *  androidx.recyclerview.widget.ItemTouchUIUtil
 *  androidx.recyclerview.widget.ItemTouchUIUtilImpl
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchUIUtil;
import androidx.recyclerview.widget.ItemTouchUIUtilImpl;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public static abstract class ItemTouchHelper.Callback {
    private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
    public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000L;
    static final int RELATIVE_DIR_FLAGS = 0x303030;
    private static final Interpolator sDragScrollInterpolator = new /* Unavailable Anonymous Inner Class!! */;
    private static final Interpolator sDragViewScrollCapInterpolator = new /* Unavailable Anonymous Inner Class!! */;
    private int mCachedMaxScrollSpeed = -1;

    public static int convertToRelativeDirection(int n, int n2) {
        int n3 = n & 0xC0C0C;
        if (n3 == 0) {
            return n;
        }
        int n4 = n & ~n3;
        if (n2 == 0) {
            n = n3 << 2;
            n2 = n4;
        } else {
            n = n3 << 1;
            n2 = n4 | 0xFFF3F3F3 & n;
            n = (n & 0xC0C0C) << 2;
        }
        return n2 | n;
    }

    public static ItemTouchUIUtil getDefaultUIUtil() {
        return ItemTouchUIUtilImpl.INSTANCE;
    }

    private int getMaxDragScroll(RecyclerView recyclerView) {
        if (this.mCachedMaxScrollSpeed != -1) return this.mCachedMaxScrollSpeed;
        this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
        return this.mCachedMaxScrollSpeed;
    }

    public static int makeFlag(int n, int n2) {
        return n2 << n * 8;
    }

    public static int makeMovementFlags(int n, int n2) {
        int n3 = ItemTouchHelper.Callback.makeFlag(0, n2 | n);
        n2 = ItemTouchHelper.Callback.makeFlag(1, n2);
        return ItemTouchHelper.Callback.makeFlag(2, n) | (n2 | n3);
    }

    public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return true;
    }

    public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int n, int n2) {
        int n3 = viewHolder.itemView.getWidth();
        int n4 = viewHolder.itemView.getHeight();
        int n5 = n - viewHolder.itemView.getLeft();
        int n6 = n2 - viewHolder.itemView.getTop();
        int n7 = list.size();
        RecyclerView.ViewHolder viewHolder2 = null;
        int n8 = -1;
        int n9 = 0;
        while (n9 < n7) {
            int n10;
            RecyclerView.ViewHolder viewHolder3 = list.get(n9);
            RecyclerView.ViewHolder viewHolder4 = viewHolder2;
            int n11 = n8;
            if (n5 > 0) {
                n10 = viewHolder3.itemView.getRight() - (n + n3);
                viewHolder4 = viewHolder2;
                n11 = n8;
                if (n10 < 0) {
                    viewHolder4 = viewHolder2;
                    n11 = n8;
                    if (viewHolder3.itemView.getRight() > viewHolder.itemView.getRight()) {
                        n10 = Math.abs(n10);
                        viewHolder4 = viewHolder2;
                        n11 = n8;
                        if (n10 > n8) {
                            viewHolder4 = viewHolder3;
                            n11 = n10;
                        }
                    }
                }
            }
            viewHolder2 = viewHolder4;
            n8 = n11;
            if (n5 < 0) {
                n10 = viewHolder3.itemView.getLeft() - n;
                viewHolder2 = viewHolder4;
                n8 = n11;
                if (n10 > 0) {
                    viewHolder2 = viewHolder4;
                    n8 = n11;
                    if (viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft()) {
                        n10 = Math.abs(n10);
                        viewHolder2 = viewHolder4;
                        n8 = n11;
                        if (n10 > n11) {
                            viewHolder2 = viewHolder3;
                            n8 = n10;
                        }
                    }
                }
            }
            viewHolder4 = viewHolder2;
            n11 = n8;
            if (n6 < 0) {
                n10 = viewHolder3.itemView.getTop() - n2;
                viewHolder4 = viewHolder2;
                n11 = n8;
                if (n10 > 0) {
                    viewHolder4 = viewHolder2;
                    n11 = n8;
                    if (viewHolder3.itemView.getTop() < viewHolder.itemView.getTop()) {
                        n10 = Math.abs(n10);
                        viewHolder4 = viewHolder2;
                        n11 = n8;
                        if (n10 > n8) {
                            viewHolder4 = viewHolder3;
                            n11 = n10;
                        }
                    }
                }
            }
            viewHolder2 = viewHolder4;
            n8 = n11;
            if (n6 > 0) {
                n10 = viewHolder3.itemView.getBottom() - (n2 + n4);
                viewHolder2 = viewHolder4;
                n8 = n11;
                if (n10 < 0) {
                    viewHolder2 = viewHolder4;
                    n8 = n11;
                    if (viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom()) {
                        n10 = Math.abs(n10);
                        viewHolder2 = viewHolder4;
                        n8 = n11;
                        if (n10 > n11) {
                            n8 = n10;
                            viewHolder2 = viewHolder3;
                        }
                    }
                }
            }
            ++n9;
        }
        return viewHolder2;
    }

    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        ItemTouchUIUtilImpl.INSTANCE.clearView(viewHolder.itemView);
    }

    public int convertToAbsoluteDirection(int n, int n2) {
        int n3 = n & 0x303030;
        if (n3 == 0) {
            return n;
        }
        int n4 = n & ~n3;
        if (n2 == 0) {
            n = n3 >> 2;
            n2 = n4;
        } else {
            n = n3 >> 1;
            n2 = n4 | 0xFFCFCFCF & n;
            n = (n & 0x303030) >> 2;
        }
        return n2 | n;
    }

    final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return this.convertToAbsoluteDirection(this.getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection((View)recyclerView));
    }

    public long getAnimationDuration(RecyclerView recyclerView, int n, float f, float f2) {
        if ((recyclerView = recyclerView.getItemAnimator()) == null) {
            long l = n == 8 ? 200L : 250L;
            return l;
        }
        long l = n == 8 ? recyclerView.getMoveDuration() : recyclerView.getRemoveDuration();
        return l;
    }

    public int getBoundingBoxMargin() {
        return 0;
    }

    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.5f;
    }

    public abstract int getMovementFlags(RecyclerView var1, RecyclerView.ViewHolder var2);

    public float getSwipeEscapeVelocity(float f) {
        return f;
    }

    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.5f;
    }

    public float getSwipeVelocityThreshold(float f) {
        return f;
    }

    boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        boolean bl = (this.getAbsoluteMovementFlags(recyclerView, viewHolder) & 0xFF0000) != 0;
        return bl;
    }

    boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        boolean bl = (this.getAbsoluteMovementFlags(recyclerView, viewHolder) & 0xFF00) != 0;
        return bl;
    }

    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int n, int n2, int n3, long l) {
        int n4 = this.getMaxDragScroll(recyclerView);
        n3 = Math.abs(n2);
        int n5 = (int)Math.signum(n2);
        float f = n3;
        float f2 = 1.0f;
        f = Math.min(1.0f, f * 1.0f / (float)n);
        n = (int)((float)(n5 * n4) * sDragViewScrollCapInterpolator.getInterpolation(f));
        if (l <= 2000L) {
            f2 = (float)l / 2000.0f;
        }
        n = n3 = (int)((float)n * sDragScrollInterpolator.getInterpolation(f2));
        if (n3 != 0) return n;
        n = n2 > 0 ? 1 : -1;
        return n;
    }

    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    public boolean isLongPressDragEnabled() {
        return true;
    }

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int n, boolean bl) {
        ItemTouchUIUtilImpl.INSTANCE.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, n, bl);
    }

    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int n, boolean bl) {
        ItemTouchUIUtilImpl.INSTANCE.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, n, bl);
    }

    void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<ItemTouchHelper.RecoverAnimation> list, int n, float f, float f2) {
        int n2 = list.size();
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                if (viewHolder == null) return;
                n3 = canvas.save();
                this.onChildDraw(canvas, recyclerView, viewHolder, f, f2, n, true);
                canvas.restoreToCount(n3);
                return;
            }
            ItemTouchHelper.RecoverAnimation recoverAnimation = list.get(n3);
            recoverAnimation.update();
            int n4 = canvas.save();
            this.onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
            canvas.restoreToCount(n4);
            ++n3;
        }
    }

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<ItemTouchHelper.RecoverAnimation> list, int n, float f, float f2) {
        int n2;
        int n3 = list.size();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            ItemTouchHelper.RecoverAnimation recoverAnimation = list.get(n2);
            int n5 = canvas.save();
            this.onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
            canvas.restoreToCount(n5);
        }
        if (viewHolder != null) {
            n2 = canvas.save();
            this.onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, n, true);
            canvas.restoreToCount(n2);
        }
        n = n3 - 1;
        n2 = n4;
        while (true) {
            if (n < 0) {
                if (n2 == 0) return;
                recyclerView.invalidate();
                return;
            }
            canvas = list.get(n);
            if (canvas.mEnded && !canvas.mIsPendingCleanup) {
                list.remove(n);
            } else if (!canvas.mEnded) {
                n2 = 1;
            }
            --n;
        }
    }

    public abstract boolean onMove(RecyclerView var1, RecyclerView.ViewHolder var2, RecyclerView.ViewHolder var3);

    public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int n, RecyclerView.ViewHolder viewHolder2, int n2, int n3, int n4) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof ItemTouchHelper.ViewDropHandler) {
            ((ItemTouchHelper.ViewDropHandler)layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, n3, n4);
            return;
        }
        if (layoutManager.canScrollHorizontally()) {
            if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                recyclerView.scrollToPosition(n2);
            }
            if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                recyclerView.scrollToPosition(n2);
            }
        }
        if (!layoutManager.canScrollVertically()) return;
        if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
            recyclerView.scrollToPosition(n2);
        }
        if (layoutManager.getDecoratedBottom(viewHolder2.itemView) < recyclerView.getHeight() - recyclerView.getPaddingBottom()) return;
        recyclerView.scrollToPosition(n2);
    }

    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int n) {
        if (viewHolder == null) return;
        ItemTouchUIUtilImpl.INSTANCE.onSelected(viewHolder.itemView);
    }

    public abstract void onSwiped(RecyclerView.ViewHolder var1, int var2);
}
