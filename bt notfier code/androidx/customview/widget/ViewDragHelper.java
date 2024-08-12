/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.animation.Interpolator
 *  android.widget.OverScroller
 *  androidx.core.view.ViewCompat
 *  androidx.customview.widget.ViewDragHelper$Callback
 */
package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import java.util.Arrays;

public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new /* Unavailable Anonymous Inner Class!! */;
    private int mActivePointerId = -1;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable = new /* Unavailable Anonymous Inner Class!! */;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) throw new IllegalArgumentException("Parent view may not be null");
        if (callback == null) throw new IllegalArgumentException("Callback may not be null");
        this.mParentView = viewGroup;
        this.mCallback = callback;
        viewGroup = ViewConfiguration.get((Context)context);
        this.mEdgeSize = (int)(context.getResources().getDisplayMetrics().density * 20.0f + 0.5f);
        this.mTouchSlop = viewGroup.getScaledTouchSlop();
        this.mMaxVelocity = viewGroup.getScaledMaximumFlingVelocity();
        this.mMinVelocity = viewGroup.getScaledMinimumFlingVelocity();
        this.mScroller = new OverScroller(context, sInterpolator);
    }

    private boolean checkNewEdgeDrag(float f, float f2, int n, int n2) {
        boolean bl;
        f = Math.abs(f);
        f2 = Math.abs(f2);
        int n3 = this.mInitialEdgesTouched[n];
        boolean bl2 = bl = false;
        if ((n3 & n2) != n2) return bl2;
        bl2 = bl;
        if ((this.mTrackingEdges & n2) == 0) return bl2;
        bl2 = bl;
        if ((this.mEdgeDragsLocked[n] & n2) == n2) return bl2;
        bl2 = bl;
        if ((this.mEdgeDragsInProgress[n] & n2) == n2) return bl2;
        n3 = this.mTouchSlop;
        if (f <= (float)n3 && f2 <= (float)n3) {
            bl2 = bl;
        } else {
            if (f < f2 * 0.5f && this.mCallback.onEdgeLock(n2)) {
                int[] nArray = this.mEdgeDragsLocked;
                nArray[n] = nArray[n] | n2;
                return false;
            }
            bl2 = bl;
            if ((this.mEdgeDragsInProgress[n] & n2) != 0) return bl2;
            bl2 = bl;
            if (!(f > (float)this.mTouchSlop)) return bl2;
            bl2 = true;
        }
        return bl2;
    }

    private boolean checkTouchSlop(View view, float f, float f2) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (view == null) {
            return false;
        }
        int n = this.mCallback.getViewHorizontalDragRange(view) > 0 ? 1 : 0;
        boolean bl4 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (n != 0 && bl4) {
            n = this.mTouchSlop;
            if (!(f * f + f2 * f2 > (float)(n * n))) return bl3;
            bl3 = true;
            return bl3;
        }
        if (n != 0) {
            bl3 = bl;
            if (!(Math.abs(f) > (float)this.mTouchSlop)) return bl3;
            bl3 = true;
            return bl3;
        }
        bl3 = bl2;
        if (!bl4) return bl3;
        bl3 = bl2;
        if (!(Math.abs(f2) > (float)this.mTouchSlop)) return bl3;
        bl3 = true;
        return bl3;
    }

    private float clampMag(float f, float f2, float f3) {
        float f4 = Math.abs(f);
        if (f4 < f2) {
            return 0.0f;
        }
        if (!(f4 > f3)) return f;
        if (f > 0.0f) return f3;
        f3 = -f3;
        return f3;
    }

    private int clampMag(int n, int n2, int n3) {
        int n4 = Math.abs(n);
        if (n4 < n2) {
            return 0;
        }
        if (n4 <= n3) return n;
        if (n > 0) return n3;
        n3 = -n3;
        return n3;
    }

    private void clearMotionHistory() {
        float[] fArray = this.mInitialMotionX;
        if (fArray == null) {
            return;
        }
        Arrays.fill(fArray, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private void clearMotionHistory(int n) {
        if (this.mInitialMotionX == null) return;
        if (!this.isPointerDown(n)) return;
        this.mInitialMotionX[n] = 0.0f;
        this.mInitialMotionY[n] = 0.0f;
        this.mLastMotionX[n] = 0.0f;
        this.mLastMotionY[n] = 0.0f;
        this.mInitialEdgesTouched[n] = 0;
        this.mEdgeDragsInProgress[n] = 0;
        this.mEdgeDragsLocked[n] = 0;
        this.mPointersDown = ~(1 << n) & this.mPointersDown;
    }

    private int computeAxisDuration(int n, int n2, int n3) {
        if (n == 0) {
            return 0;
        }
        int n4 = this.mParentView.getWidth();
        int n5 = n4 / 2;
        float f = Math.min(1.0f, (float)Math.abs(n) / (float)n4);
        float f2 = n5;
        f = this.distanceInfluenceForSnapDuration(f);
        n = (n2 = Math.abs(n2)) > 0 ? Math.round(Math.abs((f2 + f * f2) / (float)n2) * 1000.0f) * 4 : (int)(((float)Math.abs(n) / (float)n3 + 1.0f) * 256.0f);
        return Math.min(n, 600);
    }

    private int computeSettleDuration(View view, int n, int n2, int n3, int n4) {
        float f;
        float f2;
        n3 = this.clampMag(n3, (int)this.mMinVelocity, (int)this.mMaxVelocity);
        n4 = this.clampMag(n4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
        int n5 = Math.abs(n);
        int n6 = Math.abs(n2);
        int n7 = Math.abs(n3);
        int n8 = Math.abs(n4);
        int n9 = n7 + n8;
        int n10 = n5 + n6;
        if (n3 != 0) {
            f2 = n7;
            f = n9;
        } else {
            f2 = n5;
            f = n10;
        }
        float f3 = f2 / f;
        if (n4 != 0) {
            f = n8;
            f2 = n9;
        } else {
            f = n6;
            f2 = n10;
        }
        f2 = f / f2;
        n = this.computeAxisDuration(n, n3, this.mCallback.getViewHorizontalDragRange(view));
        n2 = this.computeAxisDuration(n2, n4, this.mCallback.getViewVerticalDragRange(view));
        return (int)((float)n * f3 + (float)n2 * f2);
    }

    public static ViewDragHelper create(ViewGroup object, float f, Callback callback) {
        object = ViewDragHelper.create(object, callback);
        object.mTouchSlop = (int)((float)object.mTouchSlop * (1.0f / f));
        return object;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f, float f2) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f, f2);
        this.mReleaseInProgress = false;
        if (this.mDragState != 1) return;
        this.setDragState(0);
    }

    private float distanceInfluenceForSnapDuration(float f) {
        return (float)Math.sin((f - 0.5f) * 0.47123894f);
    }

    private void dragTo(int n, int n2, int n3, int n4) {
        int n5 = this.mCapturedView.getLeft();
        int n6 = this.mCapturedView.getTop();
        int n7 = n;
        if (n3 != 0) {
            n7 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, n, n3);
            ViewCompat.offsetLeftAndRight((View)this.mCapturedView, (int)(n7 - n5));
        }
        n = n2;
        if (n4 != 0) {
            n = this.mCallback.clampViewPositionVertical(this.mCapturedView, n2, n4);
            ViewCompat.offsetTopAndBottom((View)this.mCapturedView, (int)(n - n6));
        }
        if (n3 == 0) {
            if (n4 == 0) return;
        }
        this.mCallback.onViewPositionChanged(this.mCapturedView, n7, n, n7 - n5, n - n6);
    }

    private void ensureMotionHistorySizeForId(int n) {
        float[] fArray = this.mInitialMotionX;
        if (fArray != null) {
            if (fArray.length > n) return;
        }
        fArray = new float[++n];
        float[] fArray2 = new float[n];
        float[] fArray3 = new float[n];
        float[] fArray4 = new float[n];
        int[] nArray = new int[n];
        int[] nArray2 = new int[n];
        int[] nArray3 = new int[n];
        Object[] objectArray = this.mInitialMotionX;
        if (objectArray != null) {
            System.arraycopy(objectArray, 0, fArray, 0, objectArray.length);
            objectArray = this.mInitialMotionY;
            System.arraycopy(objectArray, 0, fArray2, 0, objectArray.length);
            objectArray = this.mLastMotionX;
            System.arraycopy(objectArray, 0, fArray3, 0, objectArray.length);
            objectArray = this.mLastMotionY;
            System.arraycopy(objectArray, 0, fArray4, 0, objectArray.length);
            objectArray = this.mInitialEdgesTouched;
            System.arraycopy(objectArray, 0, nArray, 0, objectArray.length);
            objectArray = this.mEdgeDragsInProgress;
            System.arraycopy(objectArray, 0, nArray2, 0, objectArray.length);
            objectArray = this.mEdgeDragsLocked;
            System.arraycopy(objectArray, 0, nArray3, 0, objectArray.length);
        }
        this.mInitialMotionX = fArray;
        this.mInitialMotionY = fArray2;
        this.mLastMotionX = fArray3;
        this.mLastMotionY = fArray4;
        this.mInitialEdgesTouched = nArray;
        this.mEdgeDragsInProgress = nArray2;
        this.mEdgeDragsLocked = nArray3;
    }

    private boolean forceSettleCapturedViewAt(int n, int n2, int n3, int n4) {
        int n5 = this.mCapturedView.getLeft();
        int n6 = this.mCapturedView.getTop();
        if ((n -= n5) == 0 && (n2 -= n6) == 0) {
            this.mScroller.abortAnimation();
            this.setDragState(0);
            return false;
        }
        n3 = this.computeSettleDuration(this.mCapturedView, n, n2, n3, n4);
        this.mScroller.startScroll(n5, n6, n, n2, n3);
        this.setDragState(2);
        return true;
    }

    private int getEdgesTouched(int n, int n2) {
        int n3 = n < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        int n4 = n3;
        if (n2 < this.mParentView.getTop() + this.mEdgeSize) {
            n4 = n3 | 4;
        }
        n3 = n4;
        if (n > this.mParentView.getRight() - this.mEdgeSize) {
            n3 = n4 | 2;
        }
        n = n3;
        if (n2 <= this.mParentView.getBottom() - this.mEdgeSize) return n;
        n = n3 | 8;
        return n;
    }

    private boolean isValidPointerForActionMove(int n) {
        if (this.isPointerDown(n)) return true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ignoring pointerId=");
        stringBuilder.append(n);
        stringBuilder.append(" because ACTION_DOWN was not received ");
        stringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
        stringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
        Log.e((String)TAG, (String)stringBuilder.toString());
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        this.dispatchViewReleased(this.clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), this.clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f, float f2, int n) {
        int n2 = 1;
        if (!this.checkNewEdgeDrag(f, f2, n, 1)) {
            n2 = 0;
        }
        int n3 = n2;
        if (this.checkNewEdgeDrag(f2, f, n, 4)) {
            n3 = n2 | 4;
        }
        n2 = n3;
        if (this.checkNewEdgeDrag(f, f2, n, 2)) {
            n2 = n3 | 2;
        }
        n3 = n2;
        if (this.checkNewEdgeDrag(f2, f, n, 8)) {
            n3 = n2 | 8;
        }
        if (n3 == 0) return;
        int[] nArray = this.mEdgeDragsInProgress;
        nArray[n] = nArray[n] | n3;
        this.mCallback.onEdgeDragStarted(n3, n);
    }

    private void saveInitialMotion(float f, float f2, int n) {
        this.ensureMotionHistorySizeForId(n);
        float[] fArray = this.mInitialMotionX;
        this.mLastMotionX[n] = f;
        fArray[n] = f;
        fArray = this.mInitialMotionY;
        this.mLastMotionY[n] = f2;
        fArray[n] = f2;
        this.mInitialEdgesTouched[n] = this.getEdgesTouched((int)f, (int)f2);
        this.mPointersDown |= 1 << n;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int n = motionEvent.getPointerCount();
        int n2 = 0;
        while (n2 < n) {
            int n3 = motionEvent.getPointerId(n2);
            if (this.isValidPointerForActionMove(n3)) {
                float f = motionEvent.getX(n2);
                float f2 = motionEvent.getY(n2);
                this.mLastMotionX[n3] = f;
                this.mLastMotionY[n3] = f2;
            }
            ++n2;
        }
    }

    public void abort() {
        this.cancel();
        if (this.mDragState == 2) {
            int n = this.mScroller.getCurrX();
            int n2 = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int n3 = this.mScroller.getCurrX();
            int n4 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, n3, n4, n3 - n, n4 - n2);
        }
        this.setDragState(0);
    }

    /*
     * Enabled force condition propagation
     */
    protected boolean canScroll(View view, boolean bl, int n, int n2, int n3, int n4) {
        boolean bl2 = view instanceof ViewGroup;
        boolean bl3 = true;
        if (bl2) {
            ViewGroup viewGroup = (ViewGroup)view;
            int n5 = view.getScrollX();
            int n6 = view.getScrollY();
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                int n7;
                int n8 = n3 + n5;
                View view2 = viewGroup.getChildAt(i);
                if (n8 < view2.getLeft() || n8 >= view2.getRight() || (n7 = n4 + n6) < view2.getTop() || n7 >= view2.getBottom() || !this.canScroll(view2, true, n, n2, n8 - view2.getLeft(), n7 - view2.getTop())) continue;
                return true;
            }
        }
        if (!bl) return false;
        bl = bl3;
        if (view.canScrollHorizontally(-n)) return bl;
        if (!view.canScrollVertically(-n2)) return false;
        return bl3;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        this.clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) return;
        velocityTracker.recycle();
        this.mVelocityTracker = null;
    }

    public void captureChildView(View object, int n) {
        if (object.getParent() == this.mParentView) {
            this.mCapturedView = object;
            this.mActivePointerId = n;
            this.mCallback.onViewCaptured((View)object, n);
            this.setDragState(1);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        ((StringBuilder)object).append(this.mParentView);
        ((StringBuilder)object).append(")");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public boolean checkTouchSlop(int n) {
        int n2 = this.mInitialMotionX.length;
        int n3 = 0;
        while (n3 < n2) {
            if (this.checkTouchSlop(n, n3)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public boolean checkTouchSlop(int n, int n2) {
        boolean bl = this.isPointerDown(n2);
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        if (!bl) {
            return false;
        }
        boolean bl5 = (n & 1) == 1;
        n = (n & 2) == 2 ? 1 : 0;
        float f = this.mLastMotionX[n2] - this.mInitialMotionX[n2];
        float f2 = this.mLastMotionY[n2] - this.mInitialMotionY[n2];
        if (bl5 && n != 0) {
            n = this.mTouchSlop;
            bl2 = bl4;
            if (!(f * f + f2 * f2 > (float)(n * n))) return bl2;
            bl2 = true;
            return bl2;
        }
        if (bl5) {
            if (!(Math.abs(f) > (float)this.mTouchSlop)) return bl2;
            bl2 = true;
            return bl2;
        }
        bl2 = bl3;
        if (n == 0) return bl2;
        bl2 = bl3;
        if (!(Math.abs(f2) > (float)this.mTouchSlop)) return bl2;
        bl2 = true;
        return bl2;
    }

    public boolean continueSettling(boolean bl) {
        int n = this.mDragState;
        boolean bl2 = false;
        if (n == 2) {
            boolean bl3 = this.mScroller.computeScrollOffset();
            int n2 = this.mScroller.getCurrX();
            int n3 = this.mScroller.getCurrY();
            int n4 = n2 - this.mCapturedView.getLeft();
            n = n3 - this.mCapturedView.getTop();
            if (n4 != 0) {
                ViewCompat.offsetLeftAndRight((View)this.mCapturedView, (int)n4);
            }
            if (n != 0) {
                ViewCompat.offsetTopAndBottom((View)this.mCapturedView, (int)n);
            }
            if (n4 != 0 || n != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, n2, n3, n4, n);
            }
            boolean bl4 = bl3;
            if (bl3) {
                bl4 = bl3;
                if (n2 == this.mScroller.getFinalX()) {
                    bl4 = bl3;
                    if (n3 == this.mScroller.getFinalY()) {
                        this.mScroller.abortAnimation();
                        bl4 = false;
                    }
                }
            }
            if (!bl4) {
                if (bl) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    this.setDragState(0);
                }
            }
        }
        bl = bl2;
        if (this.mDragState != 2) return bl;
        bl = true;
        return bl;
    }

    public View findTopChildUnder(int n, int n2) {
        int n3 = this.mParentView.getChildCount() - 1;
        while (n3 >= 0) {
            View view = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(n3));
            if (n >= view.getLeft() && n < view.getRight() && n2 >= view.getTop() && n2 < view.getBottom()) {
                return view;
            }
            --n3;
        }
        return null;
    }

    public void flingCapturedView(int n, int n2, int n3, int n4) {
        if (!this.mReleaseInProgress) throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId), n, n3, n2, n4);
        this.setDragState(2);
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int n, int n2) {
        return this.isViewUnder(this.mCapturedView, n, n2);
    }

    public boolean isEdgeTouched(int n) {
        int n2 = this.mInitialEdgesTouched.length;
        int n3 = 0;
        while (n3 < n2) {
            if (this.isEdgeTouched(n, n3)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public boolean isEdgeTouched(int n, int n2) {
        boolean bl = this.isPointerDown(n2) && (n & this.mInitialEdgesTouched[n2]) != 0;
        return bl;
    }

    public boolean isPointerDown(int n) {
        int n2 = this.mPointersDown;
        boolean bl = true;
        if ((1 << n & n2) != 0) return bl;
        bl = false;
        return bl;
    }

    public boolean isViewUnder(View view, int n, int n2) {
        boolean bl = false;
        if (view == null) {
            return false;
        }
        boolean bl2 = bl;
        if (n < view.getLeft()) return bl2;
        bl2 = bl;
        if (n >= view.getRight()) return bl2;
        bl2 = bl;
        if (n2 < view.getTop()) return bl2;
        bl2 = bl;
        if (n2 >= view.getBottom()) return bl2;
        bl2 = true;
        return bl2;
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        block17: {
            int n;
            int n2;
            int n3;
            block19: {
                block15: {
                    block9: {
                        int n4;
                        block16: {
                            block10: {
                                block11: {
                                    block18: {
                                        block12: {
                                            block13: {
                                                block14: {
                                                    n4 = motionEvent.getActionMasked();
                                                    n3 = motionEvent.getActionIndex();
                                                    if (n4 == 0) {
                                                        this.cancel();
                                                    }
                                                    if (this.mVelocityTracker == null) {
                                                        this.mVelocityTracker = VelocityTracker.obtain();
                                                    }
                                                    this.mVelocityTracker.addMovement(motionEvent);
                                                    n2 = 0;
                                                    if (n4 == 0) break block10;
                                                    if (n4 == 1) break block11;
                                                    if (n4 == 2) break block12;
                                                    if (n4 == 3) break block13;
                                                    if (n4 == 5) break block14;
                                                    if (n4 != 6) return;
                                                    n2 = motionEvent.getPointerId(n3);
                                                    if (this.mDragState != 1 || n2 != this.mActivePointerId) break block15;
                                                    n3 = motionEvent.getPointerCount();
                                                    break block16;
                                                }
                                                n = motionEvent.getPointerId(n3);
                                                float f = motionEvent.getX(n3);
                                                float f2 = motionEvent.getY(n3);
                                                this.saveInitialMotion(f, f2, n);
                                                if (this.mDragState == 0) {
                                                    this.tryCaptureViewForDrag(this.findTopChildUnder((int)f, (int)f2), n);
                                                    n2 = this.mInitialEdgesTouched[n];
                                                    n3 = this.mTrackingEdges;
                                                    if ((n2 & n3) == 0) return;
                                                    this.mCallback.onEdgeTouched(n2 & n3, n);
                                                } else {
                                                    if (!this.isCapturedViewUnder((int)f, (int)f2)) return;
                                                    this.tryCaptureViewForDrag(this.mCapturedView, n);
                                                }
                                                break block17;
                                            }
                                            if (this.mDragState == 1) {
                                                this.dispatchViewReleased(0.0f, 0.0f);
                                            }
                                            this.cancel();
                                            break block17;
                                        }
                                        if (this.mDragState != 1) break block18;
                                        if (!this.isValidPointerForActionMove(this.mActivePointerId)) return;
                                        n = motionEvent.findPointerIndex(this.mActivePointerId);
                                        float f = motionEvent.getX(n);
                                        float f3 = motionEvent.getY(n);
                                        float[] fArray = this.mLastMotionX;
                                        n2 = this.mActivePointerId;
                                        n = (int)(f - fArray[n2]);
                                        n2 = (int)(f3 - this.mLastMotionY[n2]);
                                        this.dragTo(this.mCapturedView.getLeft() + n, this.mCapturedView.getTop() + n2, n, n2);
                                        this.saveLastMotion(motionEvent);
                                        break block17;
                                    }
                                    n3 = motionEvent.getPointerCount();
                                    break block19;
                                }
                                if (this.mDragState == 1) {
                                    this.releaseViewForPointerUp();
                                }
                                this.cancel();
                                break block17;
                            }
                            float f = motionEvent.getX();
                            float f4 = motionEvent.getY();
                            n = motionEvent.getPointerId(0);
                            motionEvent = this.findTopChildUnder((int)f, (int)f4);
                            this.saveInitialMotion(f, f4, n);
                            this.tryCaptureViewForDrag((View)motionEvent, n);
                            n3 = this.mInitialEdgesTouched[n];
                            n2 = this.mTrackingEdges;
                            if ((n3 & n2) == 0) return;
                            this.mCallback.onEdgeTouched(n3 & n2, n);
                            break block17;
                        }
                        for (n = 0; n < n3; ++n) {
                            View view;
                            float f;
                            float f5;
                            View view2;
                            n4 = motionEvent.getPointerId(n);
                            if (n4 == this.mActivePointerId || (view2 = this.findTopChildUnder((int)(f5 = motionEvent.getX(n)), (int)(f = motionEvent.getY(n)))) != (view = this.mCapturedView) || !this.tryCaptureViewForDrag(view, n4)) continue;
                            n = this.mActivePointerId;
                            break block9;
                        }
                        n = -1;
                    }
                    if (n == -1) {
                        this.releaseViewForPointerUp();
                    }
                }
                this.clearMotionHistory(n2);
                break block17;
            }
            for (n = n2; n < n3; ++n) {
                View view;
                n2 = motionEvent.getPointerId(n);
                if (!this.isValidPointerForActionMove(n2)) continue;
                float f = motionEvent.getX(n);
                float f6 = motionEvent.getY(n);
                float f7 = f - this.mInitialMotionX[n2];
                float f8 = f6 - this.mInitialMotionY[n2];
                this.reportNewEdgeDrags(f7, f8, n2);
                if (this.mDragState == 1 || this.checkTouchSlop(view = this.findTopChildUnder((int)f, (int)f6), f7, f8) && this.tryCaptureViewForDrag(view, n2)) break;
            }
            this.saveLastMotion(motionEvent);
        }
    }

    void setDragState(int n) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState == n) return;
        this.mDragState = n;
        this.mCallback.onViewDragStateChanged(n);
        if (this.mDragState != 0) return;
        this.mCapturedView = null;
    }

    public void setEdgeTrackingEnabled(int n) {
        this.mTrackingEdges = n;
    }

    public void setMinVelocity(float f) {
        this.mMinVelocity = f;
    }

    public boolean settleCapturedViewAt(int n, int n2) {
        if (!this.mReleaseInProgress) throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        return this.forceSettleCapturedViewAt(n, n2, (int)this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int)this.mVelocityTracker.getYVelocity(this.mActivePointerId));
    }

    public boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        block16: {
            int n;
            int n2;
            int n3;
            block17: {
                block13: {
                    block14: {
                        block15: {
                            n3 = motionEvent.getActionMasked();
                            n2 = motionEvent.getActionIndex();
                            if (n3 == 0) {
                                this.cancel();
                            }
                            if (this.mVelocityTracker == null) {
                                this.mVelocityTracker = VelocityTracker.obtain();
                            }
                            this.mVelocityTracker.addMovement(motionEvent);
                            if (n3 == 0) break block13;
                            if (n3 == 1) break block14;
                            if (n3 == 2) break block15;
                            if (n3 == 3) break block14;
                            if (n3 != 5) {
                                if (n3 == 6) {
                                    this.clearMotionHistory(motionEvent.getPointerId(n2));
                                }
                            } else {
                                n3 = motionEvent.getPointerId(n2);
                                float f = motionEvent.getX(n2);
                                float f2 = motionEvent.getY(n2);
                                this.saveInitialMotion(f, f2, n3);
                                n2 = this.mDragState;
                                if (n2 == 0) {
                                    n2 = this.mInitialEdgesTouched[n3];
                                    int n4 = this.mTrackingEdges;
                                    if ((n2 & n4) != 0) {
                                        this.mCallback.onEdgeTouched(n2 & n4, n3);
                                    }
                                } else if (n2 == 2 && (motionEvent = this.findTopChildUnder((int)f, (int)f2)) == this.mCapturedView) {
                                    this.tryCaptureViewForDrag((View)motionEvent, n3);
                                }
                            }
                            break block16;
                        }
                        if (this.mInitialMotionX == null || this.mInitialMotionY == null) break block16;
                        n = motionEvent.getPointerCount();
                        break block17;
                    }
                    this.cancel();
                    break block16;
                }
                float f = motionEvent.getX();
                float f3 = motionEvent.getY();
                int n5 = motionEvent.getPointerId(0);
                this.saveInitialMotion(f, f3, n5);
                motionEvent = this.findTopChildUnder((int)f, (int)f3);
                if (motionEvent == this.mCapturedView && this.mDragState == 2) {
                    this.tryCaptureViewForDrag((View)motionEvent, n5);
                }
                if (((n2 = this.mInitialEdgesTouched[n5]) & (n3 = this.mTrackingEdges)) != 0) {
                    this.mCallback.onEdgeTouched(n2 & n3, n5);
                }
                break block16;
            }
            for (n3 = 0; n3 < n; ++n3) {
                int n6 = motionEvent.getPointerId(n3);
                if (!this.isValidPointerForActionMove(n6)) continue;
                float f = motionEvent.getX(n3);
                float f4 = motionEvent.getY(n3);
                float f5 = f - this.mInitialMotionX[n6];
                float f6 = f4 - this.mInitialMotionY[n6];
                View view = this.findTopChildUnder((int)f, (int)f4);
                n2 = view != null && this.checkTouchSlop(view, f5, f6) ? 1 : 0;
                if (n2 != 0) {
                    int n7 = view.getLeft();
                    int n8 = (int)f5;
                    n8 = this.mCallback.clampViewPositionHorizontal(view, n7 + n8, n8);
                    int n9 = view.getTop();
                    int n10 = (int)f6;
                    int n11 = this.mCallback.clampViewPositionVertical(view, n9 + n10, n10);
                    int n12 = this.mCallback.getViewHorizontalDragRange(view);
                    n10 = this.mCallback.getViewVerticalDragRange(view);
                    if ((n12 == 0 || n12 > 0 && n8 == n7) && (n10 == 0 || n10 > 0 && n11 == n9)) break;
                }
                this.reportNewEdgeDrags(f5, f6, n6);
                if (this.mDragState == 1 || n2 != 0 && this.tryCaptureViewForDrag(view, n6)) break;
            }
            this.saveLastMotion(motionEvent);
        }
        boolean bl = false;
        if (this.mDragState != 1) return bl;
        bl = true;
        return bl;
    }

    public boolean smoothSlideViewTo(View view, int n, int n2) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean bl = this.forceSettleCapturedViewAt(n, n2, 0, 0);
        if (bl) return bl;
        if (this.mDragState != 0) return bl;
        if (this.mCapturedView == null) return bl;
        this.mCapturedView = null;
        return bl;
    }

    boolean tryCaptureViewForDrag(View view, int n) {
        if (view == this.mCapturedView && this.mActivePointerId == n) {
            return true;
        }
        if (view == null) return false;
        if (!this.mCallback.tryCaptureView(view, n)) return false;
        this.mActivePointerId = n;
        this.captureChildView(view, n);
        return true;
    }
}
