/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  androidx.core.view.GestureDetectorCompat
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.R$dimen
 *  androidx.recyclerview.widget.ItemTouchHelper$Callback
 *  androidx.recyclerview.widget.ItemTouchHelper$ItemTouchHelperGestureListener
 *  androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$ChildDrawingOrderCallback
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener
 *  androidx.recyclerview.widget.RecyclerView$OnItemTouchListener
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public class ItemTouchHelper
extends RecyclerView.ItemDecoration
implements RecyclerView.OnChildAttachStateChangeListener {
    static final int ACTION_MODE_DRAG_MASK = 0xFF0000;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    private int mActionState = 0;
    int mActivePointerId = -1;
    Callback mCallback;
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    private float mMaxSwipeVelocity;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener;
    View mOverdrawChild = null;
    int mOverdrawChildPosition = -1;
    final List<View> mPendingCleanup = new ArrayList<View>();
    List<RecoverAnimation> mRecoverAnimations;
    RecyclerView mRecyclerView;
    final Runnable mScrollRunnable;
    RecyclerView.ViewHolder mSelected = null;
    int mSelectedFlags;
    private float mSelectedStartX;
    private float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    private float mSwipeEscapeVelocity;
    private final float[] mTmpPosition = new float[2];
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;

    public ItemTouchHelper(Callback callback) {
        this.mRecoverAnimations = new ArrayList<RecoverAnimation>();
        this.mScrollRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mOnItemTouchListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mCallback = callback;
    }

    private void addChildDrawingOrderCallback() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.mChildDrawingOrderCallback == null) {
            this.mChildDrawingOrderCallback = new /* Unavailable Anonymous Inner Class!! */;
        }
        this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int n) {
        float f;
        if ((n & 0xC) == 0) return 0;
        float f2 = this.mDx;
        int n2 = 8;
        int n3 = f2 > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            f = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
            f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            if (!(f > 0.0f)) {
                n2 = 4;
            }
            f = Math.abs(f);
            if ((n2 & n) != 0 && n3 == n2 && f >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && f > Math.abs(f2)) {
                return n2;
            }
        }
        f2 = this.mRecyclerView.getWidth();
        f = this.mCallback.getSwipeThreshold(viewHolder);
        if ((n & n3) == 0) return 0;
        if (!(Math.abs(this.mDx) > f2 * f)) return 0;
        return n3;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int n) {
        float f;
        if ((n & 3) == 0) return 0;
        float f2 = this.mDy;
        int n2 = 2;
        int n3 = f2 > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
            f = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            if (!(f > 0.0f)) {
                n2 = 1;
            }
            f = Math.abs(f);
            if ((n2 & n) != 0 && n2 == n3 && f >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && f > Math.abs(f2)) {
                return n2;
            }
        }
        f = this.mRecyclerView.getHeight();
        f2 = this.mCallback.getSwipeThreshold(viewHolder);
        if ((n & n3) == 0) return 0;
        if (!(Math.abs(this.mDy) > f * f2)) return 0;
        return n3;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration((RecyclerView.ItemDecoration)this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener((RecyclerView.OnChildAttachStateChangeListener)this);
        int n = this.mRecoverAnimations.size() - 1;
        while (true) {
            if (n < 0) {
                this.mRecoverAnimations.clear();
                this.mOverdrawChild = null;
                this.mOverdrawChildPosition = -1;
                this.releaseVelocityTracker();
                this.stopGestureDetection();
                return;
            }
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(0);
            recoverAnimation.cancel();
            this.mCallback.clearView(this.mRecyclerView, recoverAnimation.mViewHolder);
            --n;
        }
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = this.mSwapTargets;
        if (viewHolder2 == null) {
            this.mSwapTargets = new ArrayList<RecyclerView.ViewHolder>();
            this.mDistances = new ArrayList<Integer>();
        } else {
            viewHolder2.clear();
            this.mDistances.clear();
        }
        int n = this.mCallback.getBoundingBoxMargin();
        int n2 = Math.round(this.mSelectedStartX + this.mDx) - n;
        int n3 = Math.round(this.mSelectedStartY + this.mDy) - n;
        int n4 = viewHolder.itemView.getWidth();
        int n5 = n4 + n2 + (n *= 2);
        int n6 = viewHolder.itemView.getHeight() + n3 + n;
        int n7 = (n2 + n5) / 2;
        int n8 = (n3 + n6) / 2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int n9 = layoutManager.getChildCount();
        n4 = 0;
        while (n4 < n9) {
            View view = layoutManager.getChildAt(n4);
            if (view != viewHolder.itemView && view.getBottom() >= n3 && view.getTop() <= n6 && view.getRight() >= n2 && view.getLeft() <= n5 && this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, viewHolder2 = this.mRecyclerView.getChildViewHolder(view))) {
                int n10 = Math.abs(n7 - (view.getLeft() + view.getRight()) / 2);
                n = Math.abs(n8 - (view.getTop() + view.getBottom()) / 2);
                int n11 = n10 * n10 + n * n;
                int n12 = this.mSwapTargets.size();
                n10 = 0;
                for (n = 0; n < n12 && n11 > this.mDistances.get(n); ++n10, ++n) {
                }
                this.mSwapTargets.add(n10, viewHolder2);
                this.mDistances.add(n10, n11);
            }
            ++n4;
        }
        return this.mSwapTargets;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int n = this.mActivePointerId;
        if (n == -1) {
            return null;
        }
        n = motionEvent.findPointerIndex(n);
        float f = motionEvent.getX(n);
        float f2 = this.mInitialTouchX;
        float f3 = motionEvent.getY(n);
        float f4 = this.mInitialTouchY;
        f = Math.abs(f - f2);
        f3 = Math.abs(f3 - f4);
        n = this.mSlop;
        if (f < (float)n && f3 < (float)n) {
            return null;
        }
        if (f > f3 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if (f3 > f && layoutManager.canScrollVertically()) {
            return null;
        }
        if ((motionEvent = this.findChildView(motionEvent)) != null) return this.mRecyclerView.getChildViewHolder((View)motionEvent);
        return null;
    }

    private void getSelectedDxDy(float[] fArray) {
        fArray[0] = (this.mSelectedFlags & 0xC) != 0 ? this.mSelectedStartX + this.mDx - (float)this.mSelected.itemView.getLeft() : this.mSelected.itemView.getTranslationX();
        fArray[1] = (this.mSelectedFlags & 3) != 0 ? this.mSelectedStartY + this.mDy - (float)this.mSelected.itemView.getTop() : this.mSelected.itemView.getTranslationY();
    }

    private static boolean hitTest(View view, float f, float f2, float f3, float f4) {
        boolean bl = f >= f3 && f <= f3 + (float)view.getWidth() && f2 >= f4 && f2 <= f4 + (float)view.getHeight();
        return bl;
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) return;
        velocityTracker.recycle();
        this.mVelocityTracker = null;
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get((Context)this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener((RecyclerView.OnChildAttachStateChangeListener)this);
        this.startGestureDetection();
    }

    private void startGestureDetection() {
        this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener(this);
        this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), (GestureDetector.OnGestureListener)this.mItemTouchHelperGestureListener);
    }

    private void stopGestureDetection() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.doNotReactToLongPress();
            this.mItemTouchHelperGestureListener = null;
        }
        if (this.mGestureDetector == null) return;
        this.mGestureDetector = null;
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int n = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
        int n2 = (this.mCallback.convertToAbsoluteDirection(n, ViewCompat.getLayoutDirection((View)this.mRecyclerView)) & 0xFF00) >> 8;
        if (n2 == 0) {
            return 0;
        }
        int n3 = (n & 0xFF00) >> 8;
        if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
            n = this.checkHorizontalSwipe(viewHolder, n2);
            if (n > 0) {
                if ((n3 & n) != 0) return n;
                return Callback.convertToRelativeDirection((int)n, (int)ViewCompat.getLayoutDirection((View)this.mRecyclerView));
            }
            if ((n2 = this.checkVerticalSwipe(viewHolder, n2)) <= 0) return 0;
            return n2;
        }
        n = this.checkVerticalSwipe(viewHolder, n2);
        if (n > 0) {
            return n;
        }
        n = this.checkHorizontalSwipe(viewHolder, n2);
        if (n <= 0) return 0;
        n2 = n;
        if ((n3 & n) != 0) return n2;
        n2 = Callback.convertToRelativeDirection((int)n, (int)ViewCompat.getLayoutDirection((View)this.mRecyclerView));
        return n2;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            this.destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView == null) return;
        recyclerView = recyclerView.getResources();
        this.mSwipeEscapeVelocity = recyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
        this.mMaxSwipeVelocity = recyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
        this.setupCallbacks();
    }

    void checkSelectForSwipe(int n, MotionEvent motionEvent, int n2) {
        if (this.mSelected != null) return;
        if (n != 2) return;
        if (this.mActionState == 2) return;
        if (!this.mCallback.isItemViewSwipeEnabled()) return;
        if (this.mRecyclerView.getScrollState() == 1) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.findSwipedView(motionEvent);
        if (viewHolder == null) {
            return;
        }
        n = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolder) & 0xFF00) >> 8;
        if (n == 0) {
            return;
        }
        float f = motionEvent.getX(n2);
        float f2 = motionEvent.getY(n2);
        float f3 = f2 - this.mInitialTouchY;
        float f4 = Math.abs(f -= this.mInitialTouchX);
        f2 = Math.abs(f3);
        n2 = this.mSlop;
        if (f4 < (float)n2 && f2 < (float)n2) {
            return;
        }
        if (f4 > f2) {
            if (f < 0.0f && (n & 4) == 0) {
                return;
            }
            if (f > 0.0f && (n & 8) == 0) {
                return;
            }
        } else {
            if (f3 < 0.0f && (n & 1) == 0) {
                return;
            }
            if (f3 > 0.0f && (n & 2) == 0) {
                return;
            }
        }
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = motionEvent.getPointerId(0);
        this.select(viewHolder, 1);
    }

    void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean bl) {
        int n = this.mRecoverAnimations.size() - 1;
        while (n >= 0) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(n);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= bl;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(n);
                return;
            }
            --n;
        }
    }

    RecoverAnimation findAnimation(MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        motionEvent = this.findChildView(motionEvent);
        int n = this.mRecoverAnimations.size() - 1;
        while (n >= 0) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(n);
            if (recoverAnimation.mViewHolder.itemView == motionEvent) {
                return recoverAnimation;
            }
            --n;
        }
        return null;
    }

    View findChildView(MotionEvent motionEvent) {
        float f = motionEvent.getX();
        float f2 = motionEvent.getY();
        motionEvent = this.mSelected;
        if (motionEvent != null && ItemTouchHelper.hitTest((View)(motionEvent = motionEvent.itemView), f, f2, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
            return motionEvent;
        }
        int n = this.mRecoverAnimations.size() - 1;
        while (n >= 0) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(n);
            motionEvent = recoverAnimation.mViewHolder.itemView;
            if (ItemTouchHelper.hitTest((View)motionEvent, f, f2, recoverAnimation.mX, recoverAnimation.mY)) {
                return motionEvent;
            }
            --n;
        }
        return this.mRecyclerView.findChildViewUnder(f, f2);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    boolean hasRunningRecoverAnim() {
        int n = this.mRecoverAnimations.size();
        int n2 = 0;
        while (n2 < n) {
            if (!this.mRecoverAnimations.get((int)n2).mEnded) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.mRecyclerView.isLayoutRequested()) {
            return;
        }
        if (this.mActionState != 2) {
            return;
        }
        float f = this.mCallback.getMoveThreshold(viewHolder);
        int n = (int)(this.mSelectedStartX + this.mDx);
        int n2 = (int)(this.mSelectedStartY + this.mDy);
        if ((float)Math.abs(n2 - viewHolder.itemView.getTop()) < (float)viewHolder.itemView.getHeight() * f && (float)Math.abs(n - viewHolder.itemView.getLeft()) < (float)viewHolder.itemView.getWidth() * f) {
            return;
        }
        RecyclerView.ViewHolder viewHolder2 = this.findSwapTargets(viewHolder);
        if (viewHolder2.size() == 0) {
            return;
        }
        if ((viewHolder2 = this.mCallback.chooseDropTarget(viewHolder, viewHolder2, n, n2)) == null) {
            this.mSwapTargets.clear();
            this.mDistances.clear();
            return;
        }
        int n3 = viewHolder2.getAbsoluteAdapterPosition();
        int n4 = viewHolder.getAbsoluteAdapterPosition();
        if (!this.mCallback.onMove(this.mRecyclerView, viewHolder, viewHolder2)) return;
        this.mCallback.onMoved(this.mRecyclerView, viewHolder, n4, viewHolder2, n3, n, n2);
    }

    void obtainVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    public void onChildViewAttachedToWindow(View view) {
    }

    public void onChildViewDetachedFromWindow(View view) {
        this.removeChildDrawingOrderCallbackIfNecessary(view);
        RecyclerView.ViewHolder viewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (viewHolder == null) {
            return;
        }
        view = this.mSelected;
        if (view != null && viewHolder == view) {
            this.select(null, 0);
        } else {
            this.endRecoverAnimation(viewHolder, false);
            if (!this.mPendingCleanup.remove(viewHolder.itemView)) return;
            this.mCallback.clearView(this.mRecyclerView, viewHolder);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State object) {
        Object object2;
        Object object3;
        this.mOverdrawChildPosition = -1;
        if (this.mSelected != null) {
            this.getSelectedDxDy(this.mTmpPosition);
            object = this.mTmpPosition;
            object3 = object[0];
            object2 = object[1];
        } else {
            object3 = 0.0f;
            object2 = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, object3, object2);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State object) {
        Object object2;
        Object object3;
        if (this.mSelected != null) {
            this.getSelectedDxDy(this.mTmpPosition);
            object = this.mTmpPosition;
            object3 = object[0];
            object2 = object[1];
        } else {
            object3 = 0.0f;
            object2 = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, object3, object2);
    }

    void postDispatchSwipe(RecoverAnimation recoverAnimation, int n) {
        this.mRecyclerView.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view != this.mOverdrawChild) return;
        this.mOverdrawChild = null;
        if (this.mChildDrawingOrderCallback == null) return;
        this.mRecyclerView.setChildDrawingOrderCallback(null);
    }

    boolean scrollIfNecessary() {
        int n;
        int n2;
        int n3;
        long l;
        long l2;
        block15: {
            block14: {
                RecyclerView.LayoutManager layoutManager;
                block13: {
                    block12: {
                        if (this.mSelected == null) {
                            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
                            return false;
                        }
                        l2 = System.currentTimeMillis();
                        l = this.mDragScrollStartTimeInMs;
                        l = l == Long.MIN_VALUE ? 0L : l2 - l;
                        layoutManager = this.mRecyclerView.getLayoutManager();
                        if (this.mTmpRect == null) {
                            this.mTmpRect = new Rect();
                        }
                        layoutManager.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
                        if (!layoutManager.canScrollHorizontally()) break block12;
                        n3 = (int)(this.mSelectedStartX + this.mDx);
                        n2 = n3 - this.mTmpRect.left - this.mRecyclerView.getPaddingLeft();
                        if (this.mDx < 0.0f && n2 < 0 || this.mDx > 0.0f && (n2 = n3 + this.mSelected.itemView.getWidth() + this.mTmpRect.right - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight())) > 0) break block13;
                    }
                    n2 = 0;
                }
                if (!layoutManager.canScrollVertically()) break block14;
                n = (int)(this.mSelectedStartY + this.mDy);
                n3 = n - this.mTmpRect.top - this.mRecyclerView.getPaddingTop();
                if (this.mDy < 0.0f && n3 < 0 || this.mDy > 0.0f && (n3 = n + this.mSelected.itemView.getHeight() + this.mTmpRect.bottom - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom())) > 0) break block15;
            }
            n3 = 0;
        }
        n = n2;
        if (n2 != 0) {
            n = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), n2, this.mRecyclerView.getWidth(), l);
        }
        if (n3 != 0) {
            n3 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), n3, this.mRecyclerView.getHeight(), l);
        }
        if (n == 0 && n3 == 0) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            return false;
        }
        if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
            this.mDragScrollStartTimeInMs = l2;
        }
        this.mRecyclerView.scrollBy(n, n3);
        return true;
    }

    void select(RecyclerView.ViewHolder viewHolder, int n) {
        int n2;
        RecyclerView.ViewHolder viewHolder2;
        if (viewHolder == this.mSelected && n == this.mActionState) {
            return;
        }
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        int n3 = this.mActionState;
        this.endRecoverAnimation(viewHolder, true);
        this.mActionState = n;
        if (n == 2) {
            if (viewHolder == null) throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            this.mOverdrawChild = viewHolder.itemView;
            this.addChildDrawingOrderCallback();
        }
        if ((viewHolder2 = this.mSelected) != null) {
            if (viewHolder2.itemView.getParent() != null) {
                float f;
                float f2;
                int n4 = n3 == 2 ? 0 : this.swipeIfNecessary(viewHolder2);
                this.releaseVelocityTracker();
                if (n4 != 1 && n4 != 2) {
                    f2 = n4 != 4 && n4 != 8 && n4 != 16 && n4 != 32 ? 0.0f : Math.signum(this.mDx) * (float)this.mRecyclerView.getWidth();
                    f = 0.0f;
                } else {
                    f = Math.signum(this.mDy) * (float)this.mRecyclerView.getHeight();
                    f2 = 0.0f;
                }
                n2 = n3 == 2 ? 8 : (n4 > 0 ? 2 : 4);
                this.getSelectedDxDy(this.mTmpPosition);
                float[] fArray = this.mTmpPosition;
                float f3 = fArray[0];
                float f4 = fArray[1];
                viewHolder2 = new /* Unavailable Anonymous Inner Class!! */;
                viewHolder2.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, n2, f2 - f3, f - f4));
                this.mRecoverAnimations.add((RecoverAnimation)viewHolder2);
                viewHolder2.start();
                n2 = 1;
            } else {
                this.removeChildDrawingOrderCallbackIfNecessary(viewHolder2.itemView);
                this.mCallback.clearView(this.mRecyclerView, viewHolder2);
                n2 = 0;
            }
            this.mSelected = null;
        } else {
            n2 = 0;
        }
        if (viewHolder != null) {
            this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolder) & (1 << n * 8 + 8) - 1) >> this.mActionState * 8;
            this.mSelectedStartX = viewHolder.itemView.getLeft();
            this.mSelectedStartY = viewHolder.itemView.getTop();
            this.mSelected = viewHolder;
            if (n == 2) {
                viewHolder.itemView.performHapticFeedback(0);
            }
        }
        if ((viewHolder = this.mRecyclerView.getParent()) != null) {
            boolean bl = this.mSelected != null;
            viewHolder.requestDisallowInterceptTouchEvent(bl);
        }
        if (n2 == 0) {
            this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }
        this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
        this.mRecyclerView.invalidate();
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder)) {
            Log.e((String)"ItemTouchHelper", (String)"Start drag has been called but dragging is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e((String)"ItemTouchHelper", (String)"Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        this.obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.select(viewHolder, 2);
    }

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder)) {
            Log.e((String)"ItemTouchHelper", (String)"Start swipe has been called but swiping is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e((String)"ItemTouchHelper", (String)"Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            return;
        }
        this.obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.select(viewHolder, 1);
    }

    void updateDxDy(MotionEvent motionEvent, int n, int n2) {
        float f = motionEvent.getX(n2);
        float f2 = motionEvent.getY(n2);
        this.mDx = f -= this.mInitialTouchX;
        this.mDy = f2 - this.mInitialTouchY;
        if ((n & 4) == 0) {
            this.mDx = Math.max(0.0f, f);
        }
        if ((n & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((n & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((n & 2) != 0) return;
        this.mDy = Math.min(0.0f, this.mDy);
    }
}
