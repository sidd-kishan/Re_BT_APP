/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.database.DataSetObserver
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.util.Log
 *  android.view.FocusFinder
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.SoundEffectConstants
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.animation.Interpolator
 *  android.widget.EdgeEffect
 *  android.widget.Scroller
 *  androidx.core.content.ContextCompat
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager$DecorView
 *  androidx.viewpager.widget.ViewPager$ItemInfo
 *  androidx.viewpager.widget.ViewPager$LayoutParams
 *  androidx.viewpager.widget.ViewPager$MyAccessibilityDelegate
 *  androidx.viewpager.widget.ViewPager$OnAdapterChangeListener
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  androidx.viewpager.widget.ViewPager$PageTransformer
 *  androidx.viewpager.widget.ViewPager$PagerObserver
 *  androidx.viewpager.widget.ViewPager$SavedState
 *  androidx.viewpager.widget.ViewPager$ViewPositionComparator
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator;
    private static final ViewPositionComparator sPositionComparator;
    private int mActivePointerId = -1;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems = new ArrayList();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem = new ItemInfo();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    static {
        LAYOUT_ATTRS = new int[]{16842931};
        COMPARATOR = new /* Unavailable Anonymous Inner Class!! */;
        sInterpolator = new /* Unavailable Anonymous Inner Class!! */;
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(Context context) {
        super(context);
        this.mLastOffset = Float.MAX_VALUE;
        this.mEndScrollRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastOffset = Float.MAX_VALUE;
        this.mEndScrollRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int n, ItemInfo itemInfo2) {
        float f;
        int n2;
        int n3;
        float f2;
        float f3;
        int n4;
        int n5;
        block12: {
            block15: {
                block14: {
                    block13: {
                        n5 = this.mAdapter.getCount();
                        n4 = this.getClientWidth();
                        f3 = n4 > 0 ? (float)this.mPageMargin / (float)n4 : 0.0f;
                        if (itemInfo2 == null) break block12;
                        n4 = itemInfo2.position;
                        if (n4 >= itemInfo.position) break block13;
                        f2 = itemInfo2.offset + itemInfo2.widthFactor + f3;
                        ++n4;
                        n3 = 0;
                        break block14;
                    }
                    if (n4 <= itemInfo.position) break block12;
                    n3 = this.mItems.size() - 1;
                    f2 = itemInfo2.offset;
                    --n4;
                    break block15;
                }
                while (n4 <= itemInfo.position && n3 < this.mItems.size()) {
                    itemInfo2 = this.mItems.get(n3);
                    while (true) {
                        n2 = n4;
                        f = f2;
                        if (n4 <= itemInfo2.position) break;
                        n2 = n4;
                        f = f2;
                        if (n3 >= this.mItems.size() - 1) break;
                        itemInfo2 = this.mItems.get(++n3);
                    }
                    while (n2 < itemInfo2.position) {
                        f += this.mAdapter.getPageWidth(n2) + f3;
                        ++n2;
                    }
                    itemInfo2.offset = f;
                    f2 = f + (itemInfo2.widthFactor + f3);
                    n4 = n2 + 1;
                }
                break block12;
            }
            while (n4 >= itemInfo.position && n3 >= 0) {
                itemInfo2 = this.mItems.get(n3);
                while (true) {
                    n2 = n4;
                    f = f2;
                    if (n4 >= itemInfo2.position) break;
                    n2 = n4;
                    f = f2;
                    if (n3 <= 0) break;
                    itemInfo2 = this.mItems.get(--n3);
                }
                while (n2 > itemInfo2.position) {
                    f -= this.mAdapter.getPageWidth(n2) + f3;
                    --n2;
                }
                itemInfo2.offset = f2 = f - (itemInfo2.widthFactor + f3);
                n4 = n2 - 1;
            }
        }
        n2 = this.mItems.size();
        f = itemInfo.offset;
        n4 = itemInfo.position - 1;
        f2 = itemInfo.position == 0 ? itemInfo.offset : -3.4028235E38f;
        this.mFirstOffset = f2;
        n3 = itemInfo.position;
        f2 = n3 == --n5 ? itemInfo.offset + itemInfo.widthFactor - 1.0f : Float.MAX_VALUE;
        this.mLastOffset = f2;
        f2 = f;
        for (n3 = n - 1; n3 >= 0; --n3, --n4) {
            itemInfo2 = this.mItems.get(n3);
            while (n4 > itemInfo2.position) {
                f2 -= this.mAdapter.getPageWidth(n4) + f3;
                --n4;
            }
            itemInfo2.offset = f2 -= itemInfo2.widthFactor + f3;
            if (itemInfo2.position != 0) continue;
            this.mFirstOffset = f2;
        }
        f2 = itemInfo.offset + itemInfo.widthFactor + f3;
        n3 = itemInfo.position + 1;
        n4 = n + 1;
        n = n3;
        while (true) {
            if (n4 >= n2) {
                this.mNeedCalculatePageOffsets = false;
                return;
            }
            itemInfo = this.mItems.get(n4);
            while (n < itemInfo.position) {
                f2 += this.mAdapter.getPageWidth(n) + f3;
                ++n;
            }
            if (itemInfo.position == n5) {
                this.mLastOffset = itemInfo.widthFactor + f2 - 1.0f;
            }
            itemInfo.offset = f2;
            f2 += itemInfo.widthFactor + f3;
            ++n4;
            ++n;
        }
    }

    private void completeScroll(boolean bl) {
        int n;
        boolean bl2 = this.mScrollState == 2;
        if (bl2) {
            this.setScrollingCacheEnabled(false);
            if (this.mScroller.isFinished() ^ true) {
                this.mScroller.abortAnimation();
                int n2 = this.getScrollX();
                int n3 = this.getScrollY();
                int n4 = this.mScroller.getCurrX();
                n = this.mScroller.getCurrY();
                if (n2 != n4 || n3 != n) {
                    this.scrollTo(n4, n);
                    if (n4 != n2) {
                        this.pageScrolled(n4);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (n = 0; n < this.mItems.size(); ++n) {
            ItemInfo itemInfo = this.mItems.get(n);
            if (!itemInfo.scrolling) continue;
            itemInfo.scrolling = false;
            bl2 = true;
        }
        if (!bl2) return;
        if (bl) {
            ViewCompat.postOnAnimation((View)this, (Runnable)this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int n, float f, int n2, int n3) {
        if (Math.abs(n3) > this.mFlingDistance && Math.abs(n2) > this.mMinimumVelocity) {
            if (n2 <= 0) {
                ++n;
            }
        } else {
            float f2 = n >= this.mCurItem ? 0.4f : 0.6f;
            n += (int)(f + f2);
        }
        n2 = n;
        if (this.mItems.size() <= 0) return n2;
        ItemInfo itemInfo = this.mItems.get(0);
        ItemInfo itemInfo2 = this.mItems;
        itemInfo2 = itemInfo2.get(itemInfo2.size() - 1);
        n2 = Math.max(itemInfo.position, Math.min(n, itemInfo2.position));
        return n2;
    }

    private void dispatchOnPageScrolled(int n, float f, int n2) {
        Object object = this.mOnPageChangeListener;
        if (object != null) {
            object.onPageScrolled(n, f, n2);
        }
        if ((object = this.mOnPageChangeListeners) != null) {
            int n3 = object.size();
            for (int i = 0; i < n3; ++i) {
                object = this.mOnPageChangeListeners.get(i);
                if (object == null) continue;
                object.onPageScrolled(n, f, n2);
            }
        }
        if ((object = this.mInternalPageChangeListener) == null) return;
        object.onPageScrolled(n, f, n2);
    }

    private void dispatchOnPageSelected(int n) {
        Object object = this.mOnPageChangeListener;
        if (object != null) {
            object.onPageSelected(n);
        }
        if ((object = this.mOnPageChangeListeners) != null) {
            int n2 = object.size();
            for (int i = 0; i < n2; ++i) {
                object = this.mOnPageChangeListeners.get(i);
                if (object == null) continue;
                object.onPageSelected(n);
            }
        }
        if ((object = this.mInternalPageChangeListener) == null) return;
        object.onPageSelected(n);
    }

    private void dispatchOnScrollStateChanged(int n) {
        Object object = this.mOnPageChangeListener;
        if (object != null) {
            object.onPageScrollStateChanged(n);
        }
        if ((object = this.mOnPageChangeListeners) != null) {
            int n2 = object.size();
            for (int i = 0; i < n2; ++i) {
                object = this.mOnPageChangeListeners.get(i);
                if (object == null) continue;
                object.onPageScrollStateChanged(n);
            }
        }
        if ((object = this.mInternalPageChangeListener) == null) return;
        object.onPageScrollStateChanged(n);
    }

    private void enableLayers(boolean bl) {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            int n3 = bl ? this.mPageTransformerLayerType : 0;
            this.getChildAt(n2).setLayerType(n3, null);
            ++n2;
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) return;
        velocityTracker.recycle();
        this.mVelocityTracker = null;
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = new Rect();
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        rect = view.getParent();
        while (rect instanceof ViewGroup) {
            if (rect == this) return rect2;
            rect = (ViewGroup)rect;
            rect2.left += rect.getLeft();
            rect2.right += rect.getRight();
            rect2.top += rect.getTop();
            rect2.bottom += rect.getBottom();
            rect = rect.getParent();
        }
        return rect2;
    }

    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int n = this.getClientWidth();
        float f = 0.0f;
        float f2 = n > 0 ? (float)this.getScrollX() / (float)n : 0.0f;
        float f3 = n > 0 ? (float)this.mPageMargin / (float)n : 0.0f;
        ItemInfo itemInfo = null;
        float f4 = 0.0f;
        int n2 = -1;
        n = 0;
        boolean bl = true;
        while (n < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(n);
            int n3 = n;
            ItemInfo itemInfo3 = itemInfo2;
            if (!bl) {
                int n4 = itemInfo2.position;
                n3 = n;
                itemInfo3 = itemInfo2;
                if (n4 != ++n2) {
                    itemInfo3 = this.mTempItem;
                    itemInfo3.offset = f + f4 + f3;
                    itemInfo3.position = n2;
                    itemInfo3.widthFactor = this.mAdapter.getPageWidth(itemInfo3.position);
                    n3 = n - 1;
                }
            }
            f = itemInfo3.offset;
            f4 = itemInfo3.widthFactor;
            if (!bl) {
                if (!(f2 >= f)) return itemInfo;
            }
            if (f2 < f4 + f + f3) return itemInfo3;
            if (n3 == this.mItems.size() - 1) {
                return itemInfo3;
            }
            n2 = itemInfo3.position;
            f4 = itemInfo3.widthFactor;
            n = n3 + 1;
            bl = false;
            itemInfo = itemInfo3;
        }
        return itemInfo;
    }

    private static boolean isDecorView(View view) {
        boolean bl = view.getClass().getAnnotation(DecorView.class) != null;
        return bl;
    }

    private boolean isGutterDrag(float f, float f2) {
        boolean bl = f < (float)this.mGutterSize && f2 > 0.0f || f > (float)(this.getWidth() - this.mGutterSize) && f2 < 0.0f;
        return bl;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int n = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(n) != this.mActivePointerId) return;
        n = n == 0 ? 1 : 0;
        this.mLastMotionX = motionEvent.getX(n);
        this.mActivePointerId = motionEvent.getPointerId(n);
        motionEvent = this.mVelocityTracker;
        if (motionEvent == null) return;
        motionEvent.clear();
    }

    private boolean pageScrolled(int n) {
        if (this.mItems.size() != 0) {
            ItemInfo itemInfo = this.infoForCurrentScrollPosition();
            int n2 = this.getClientWidth();
            int n3 = this.mPageMargin;
            float f = n3;
            float f2 = n2;
            f /= f2;
            int n4 = itemInfo.position;
            f2 = ((float)n / f2 - itemInfo.offset) / (itemInfo.widthFactor + f);
            n = (int)((float)(n2 + n3) * f2);
            this.mCalledSuper = false;
            this.onPageScrolled(n4, f2, n);
            if (!this.mCalledSuper) throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            return true;
        }
        if (this.mFirstLayout) {
            return false;
        }
        this.mCalledSuper = false;
        this.onPageScrolled(0, 0.0f, 0);
        if (!this.mCalledSuper) throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        return false;
    }

    private boolean performDrag(float f) {
        boolean bl;
        int n;
        float f2 = this.mLastMotionX;
        this.mLastMotionX = f;
        float f3 = (float)this.getScrollX() + (f2 - f);
        float f4 = this.getClientWidth();
        f = this.mFirstOffset * f4;
        f2 = this.mLastOffset * f4;
        ItemInfo itemInfo = this.mItems;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        itemInfo = itemInfo.get(0);
        ItemInfo itemInfo2 = this.mItems;
        itemInfo2 = itemInfo2.get(itemInfo2.size() - 1);
        if (itemInfo.position != 0) {
            f = itemInfo.offset * f4;
            n = 0;
        } else {
            n = 1;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f2 = itemInfo2.offset * f4;
            bl = false;
        } else {
            bl = true;
        }
        if (f3 < f) {
            if (n != 0) {
                this.mLeftEdge.onPull(Math.abs(f - f3) / f4);
                bl4 = true;
            }
        } else {
            bl4 = bl3;
            f = f3;
            if (f3 > f2) {
                bl4 = bl2;
                if (bl) {
                    this.mRightEdge.onPull(Math.abs(f3 - f2) / f4);
                    bl4 = true;
                }
                f = f2;
            }
        }
        f2 = this.mLastMotionX;
        n = (int)f;
        this.mLastMotionX = f2 + (f - (float)n);
        this.scrollTo(n, this.getScrollY());
        this.pageScrolled(n);
        return bl4;
    }

    private void recomputeScrollPosition(int n, int n2, int n3, int n4) {
        if (n2 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(this.getCurrentItem() * this.getClientWidth());
            } else {
                int n5 = this.getPaddingLeft();
                int n6 = this.getPaddingRight();
                int n7 = this.getPaddingLeft();
                int n8 = this.getPaddingRight();
                this.scrollTo((int)((float)this.getScrollX() / (float)(n2 - n7 - n8 + n4) * (float)(n - n5 - n6 + n3)), this.getScrollY());
            }
        } else {
            ItemInfo itemInfo = this.infoForPosition(this.mCurItem);
            float f = itemInfo != null ? Math.min(itemInfo.offset, this.mLastOffset) : 0.0f;
            n = (int)(f * (float)(n - this.getPaddingLeft() - this.getPaddingRight()));
            if (n == this.getScrollX()) return;
            this.completeScroll(false);
            this.scrollTo(n, this.getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int n = 0;
        while (n < this.getChildCount()) {
            int n2 = n;
            if (!((LayoutParams)this.getChildAt((int)n).getLayoutParams()).isDecor) {
                this.removeViewAt(n);
                n2 = n - 1;
            }
            n = n2 + 1;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean bl) {
        ViewParent viewParent = this.getParent();
        if (viewParent == null) return;
        viewParent.requestDisallowInterceptTouchEvent(bl);
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        this.endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        boolean bl = this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
        return bl;
    }

    private void scrollToItem(int n, boolean bl, int n2, boolean bl2) {
        ItemInfo itemInfo = this.infoForPosition(n);
        int n3 = itemInfo != null ? (int)((float)this.getClientWidth() * Math.max(this.mFirstOffset, Math.min(itemInfo.offset, this.mLastOffset))) : 0;
        if (bl) {
            this.smoothScrollTo(n3, 0, n2);
            if (!bl2) return;
            this.dispatchOnPageSelected(n);
        } else {
            if (bl2) {
                this.dispatchOnPageSelected(n);
            }
            this.completeScroll(false);
            this.scrollTo(n3, 0);
            this.pageScrolled(n3);
        }
    }

    private void setScrollingCacheEnabled(boolean bl) {
        if (this.mScrollingCacheEnabled == bl) return;
        this.mScrollingCacheEnabled = bl;
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder == 0) return;
        View view = this.mDrawingOrderedChildren;
        if (view == null) {
            this.mDrawingOrderedChildren = new ArrayList();
        } else {
            view.clear();
        }
        int n = this.getChildCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
                return;
            }
            view = this.getChildAt(n2);
            this.mDrawingOrderedChildren.add(view);
            ++n2;
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int n, int n2) {
        int n3 = arrayList.size();
        int n4 = this.getDescendantFocusability();
        if (n4 != 393216) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                ItemInfo itemInfo;
                View view = this.getChildAt(i);
                if (view.getVisibility() != 0 || (itemInfo = this.infoForChild(view)) == null || itemInfo.position != this.mCurItem) continue;
                view.addFocusables(arrayList, n, n2);
            }
        }
        if (n4 == 262144) {
            if (n3 != arrayList.size()) return;
        }
        if (!this.isFocusable()) {
            return;
        }
        if ((n2 & 1) == 1 && this.isInTouchMode() && !this.isFocusableInTouchMode()) {
            return;
        }
        if (arrayList == null) return;
        arrayList.add((View)this);
    }

    ItemInfo addNewItem(int n, int n2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = n;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup)this, n);
        itemInfo.widthFactor = this.mAdapter.getPageWidth(n);
        if (n2 >= 0 && n2 < this.mItems.size()) {
            this.mItems.add(n2, itemInfo);
        } else {
            this.mItems.add(itemInfo);
        }
        return itemInfo;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList<OnAdapterChangeListener>();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList<OnPageChangeListener>();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        int n = 0;
        while (n < this.getChildCount()) {
            ItemInfo itemInfo;
            View view = this.getChildAt(n);
            if (view.getVisibility() == 0 && (itemInfo = this.infoForChild(view)) != null && itemInfo.position == this.mCurItem) {
                view.addTouchables(arrayList);
            }
            ++n;
        }
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (!this.checkLayoutParams(layoutParams)) {
            layoutParams2 = this.generateLayoutParams(layoutParams);
        }
        layoutParams = (LayoutParams)layoutParams2;
        layoutParams.isDecor |= ViewPager.isDecorView(view);
        if (this.mInLayout) {
            if (layoutParams != null) {
                if (layoutParams.isDecor) throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams.needsMeasure = true;
            this.addViewInLayout(view, n, layoutParams2);
        } else {
            super.addView(view, n, layoutParams2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public boolean arrowScroll(int var1_1) {
        block13: {
            block14: {
                block16: {
                    block15: {
                        var6_2 = this.findFocus();
                        var4_3 = false;
                        if (var6_2 == this) break block15;
                        var5_5 = var6_2;
                        if (var6_2 == null) break block13;
                        var5_5 = var6_2.getParent();
                        break block16;
                    }
lbl9:
                    // 2 sources

                    while (true) {
                        var5_5 = null;
                        break block13;
                        break;
                    }
                }
                while (var5_5 instanceof ViewGroup) {
                    if (var5_5 == this) {
                        var2_4 = 1;
                        break block14;
                    }
                    var5_5 = var5_5.getParent();
                }
                var2_4 = 0;
            }
            var5_5 = var6_2;
            if (var2_4 == 0) {
                var7_6 = new StringBuilder();
                var7_6.append(var6_2.getClass().getSimpleName());
                var5_5 = var6_2.getParent();
                while (var5_5 instanceof ViewGroup) {
                    var7_6.append(" => ");
                    var7_6.append(var5_5.getClass().getSimpleName());
                    var5_5 = var5_5.getParent();
                }
                var5_5 = new StringBuilder();
                var5_5.append("arrowScroll tried to find focus based on non-child current focused view ");
                var5_5.append(var7_6.toString());
                Log.e((String)"ViewPager", (String)var5_5.toString());
                ** continue;
            }
        }
        var6_2 = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)var5_5, var1_1);
        if (var6_2 != null && var6_2 != var5_5) {
            if (var1_1 == 17) {
                var2_4 = this.getChildRectInPagerCoordinates((Rect)this.mTempRect, (View)var6_2).left;
                var3_7 = this.getChildRectInPagerCoordinates((Rect)this.mTempRect, (View)var5_5).left;
                var4_3 = var5_5 != null && var2_4 >= var3_7 ? this.pageLeft() : var6_2.requestFocus();
            } else if (var1_1 == 66) {
                var3_8 = this.getChildRectInPagerCoordinates((Rect)this.mTempRect, (View)var6_2).left;
                var2_4 = this.getChildRectInPagerCoordinates((Rect)this.mTempRect, (View)var5_5).left;
                var4_3 = var5_5 != null && var3_8 <= var2_4 ? this.pageRight() : var6_2.requestFocus();
            }
        } else if (var1_1 != 17 && var1_1 != 1) {
            if (var1_1 == 66 || var1_1 == 2) {
                var4_3 = this.pageRight();
            }
        } else {
            var4_3 = this.pageLeft();
        }
        if (var4_3 == false) return var4_3;
        this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection((int)var1_1));
        return var4_3;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        this.setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long l = SystemClock.uptimeMillis();
        velocityTracker = MotionEvent.obtain((long)l, (long)l, (int)0, (float)0.0f, (float)0.0f, (int)0);
        this.mVelocityTracker.addMovement((MotionEvent)velocityTracker);
        velocityTracker.recycle();
        this.mFakeDragBeginTime = l;
        return true;
    }

    protected boolean canScroll(View view, boolean bl, int n, int n2, int n3) {
        boolean bl2 = view instanceof ViewGroup;
        boolean bl3 = true;
        if (bl2) {
            ViewGroup viewGroup = (ViewGroup)view;
            int n4 = view.getScrollX();
            int n5 = view.getScrollY();
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                int n6;
                int n7 = n2 + n4;
                View view2 = viewGroup.getChildAt(i);
                if (n7 < view2.getLeft() || n7 >= view2.getRight() || (n6 = n3 + n5) < view2.getTop() || n6 >= view2.getBottom() || !this.canScroll(view2, true, n, n7 - view2.getLeft(), n6 - view2.getTop())) continue;
                return true;
            }
        }
        bl = bl && view.canScrollHorizontally(-n) ? bl3 : false;
        return bl;
    }

    public boolean canScrollHorizontally(int n) {
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean bl = false;
        boolean bl2 = false;
        if (pagerAdapter == null) {
            return false;
        }
        int n2 = this.getClientWidth();
        int n3 = this.getScrollX();
        if (n < 0) {
            if (n3 <= (int)((float)n2 * this.mFirstOffset)) return bl2;
            bl2 = true;
            return bl2;
        }
        bl2 = bl;
        if (n <= 0) return bl2;
        bl2 = bl;
        if (n3 >= (int)((float)n2 * this.mLastOffset)) return bl2;
        bl2 = true;
        return bl2;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = layoutParams instanceof LayoutParams && super.checkLayoutParams(layoutParams);
        return bl;
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list == null) return;
        list.clear();
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int n = this.getScrollX();
            int n2 = this.getScrollY();
            int n3 = this.mScroller.getCurrX();
            int n4 = this.mScroller.getCurrY();
            if (n != n3 || n2 != n4) {
                this.scrollTo(n3, n4);
                if (!this.pageScrolled(n3)) {
                    this.mScroller.abortAnimation();
                    this.scrollTo(0, n4);
                }
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
            return;
        }
        this.completeScroll(true);
    }

    void dataSetChanged() {
        ItemInfo itemInfo;
        int n;
        this.mExpectedAdapterCount = n = this.mAdapter.getCount();
        int n2 = this.mItems.size() < this.mOffscreenPageLimit * 2 + 1 && this.mItems.size() < n ? 1 : 0;
        int n3 = this.mCurItem;
        int n4 = 0;
        int n5 = 0;
        while (n4 < this.mItems.size()) {
            int n6;
            int n7;
            int n8;
            block13: {
                block15: {
                    int n9;
                    block14: {
                        block12: {
                            itemInfo = this.mItems.get(n4);
                            n9 = this.mAdapter.getItemPosition(itemInfo.object);
                            if (n9 != -1) break block12;
                            n8 = n3;
                            n7 = n4;
                            n6 = n5;
                            break block13;
                        }
                        if (n9 != -2) break block14;
                        this.mItems.remove(n4);
                        n8 = n4 - 1;
                        n2 = n5;
                        if (n5 == 0) {
                            this.mAdapter.startUpdate((ViewGroup)this);
                            n2 = 1;
                        }
                        this.mAdapter.destroyItem((ViewGroup)this, itemInfo.position, itemInfo.object);
                        n4 = n8;
                        n5 = n2;
                        if (this.mCurItem == itemInfo.position) {
                            n3 = Math.max(0, Math.min(this.mCurItem, n - 1));
                            n5 = n2;
                            n4 = n8;
                        }
                        break block15;
                    }
                    n8 = n3;
                    n7 = n4;
                    n6 = n5;
                    if (itemInfo.position == n9) break block13;
                    if (itemInfo.position == this.mCurItem) {
                        n3 = n9;
                    }
                    itemInfo.position = n9;
                }
                n2 = 1;
                n8 = n3;
                n7 = n4;
                n6 = n5;
            }
            n4 = n7 + 1;
            n3 = n8;
            n5 = n6;
        }
        if (n5 != 0) {
            this.mAdapter.finishUpdate((ViewGroup)this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (n2 == 0) return;
        n4 = this.getChildCount();
        n5 = 0;
        while (true) {
            if (n5 >= n4) {
                this.setCurrentItemInternal(n3, false, true);
                this.requestLayout();
                return;
            }
            itemInfo = (LayoutParams)this.getChildAt(n5).getLayoutParams();
            if (!itemInfo.isDecor) {
                itemInfo.widthFactor = 0.0f;
            }
            ++n5;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl = super.dispatchKeyEvent(keyEvent) || this.executeKeyEvent(keyEvent);
        return bl;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            ItemInfo itemInfo;
            View view = this.getChildAt(n2);
            if (view.getVisibility() == 0 && (itemInfo = this.infoForChild(view)) != null && itemInfo.position == this.mCurItem && view.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float)Math.sin((f - 0.5f) * 0.47123894f);
    }

    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int n = this.getOverScrollMode();
        int n2 = 0;
        int n3 = 0;
        if (n != 0 && (n != 1 || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() <= 1)) {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        } else {
            if (!this.mLeftEdge.isFinished()) {
                n2 = canvas.save();
                n = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                n3 = this.getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float)(-n + this.getPaddingTop()), this.mFirstOffset * (float)n3);
                this.mLeftEdge.setSize(n, n3);
                n3 = 0 | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(n2);
            }
            n2 = n3;
            if (!this.mRightEdge.isFinished()) {
                n = canvas.save();
                n2 = this.getWidth();
                int n4 = this.getHeight();
                int n5 = this.getPaddingTop();
                int n6 = this.getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float)(-this.getPaddingTop()), -(this.mLastOffset + 1.0f) * (float)n2);
                this.mRightEdge.setSize(n4 - n5 - n6, n2);
                n2 = n3 | this.mRightEdge.draw(canvas);
                canvas.restoreToCount(n);
            }
        }
        if (n2 == 0) return;
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null) return;
        if (!drawable.isStateful()) return;
        drawable.setState(this.getDrawableState());
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        if (this.mAdapter != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
            int n = (int)velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int n2 = this.getClientWidth();
            int n3 = this.getScrollX();
            velocityTracker = this.infoForCurrentScrollPosition();
            this.setCurrentItemInternal(this.determineTargetPage(velocityTracker.position, ((float)n3 / (float)n2 - velocityTracker.offset) / velocityTracker.widthFactor, n, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, n);
        }
        this.endDrag();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        boolean bl;
        block4: {
            block0: {
                block1: {
                    block2: {
                        block3: {
                            if (keyEvent.getAction() != 0) break block0;
                            int n = keyEvent.getKeyCode();
                            if (n == 21) break block1;
                            if (n == 22) break block2;
                            if (n != 61) break block0;
                            if (!keyEvent.hasNoModifiers()) break block3;
                            bl = this.arrowScroll(2);
                            break block4;
                        }
                        if (!keyEvent.hasModifiers(1)) break block0;
                        bl = this.arrowScroll(1);
                        break block4;
                    }
                    bl = keyEvent.hasModifiers(2) ? this.pageRight() : this.arrowScroll(66);
                    break block4;
                }
                bl = keyEvent.hasModifiers(2) ? this.pageLeft() : this.arrowScroll(17);
                break block4;
            }
            bl = false;
        }
        return bl;
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f;
        float f2 = (float)this.getScrollX() - f;
        float f3 = this.getClientWidth();
        f = this.mFirstOffset * f3;
        float f4 = this.mLastOffset * f3;
        ItemInfo itemInfo = this.mItems.get(0);
        ItemInfo itemInfo2 = this.mItems;
        itemInfo2 = itemInfo2.get(itemInfo2.size() - 1);
        if (itemInfo.position != 0) {
            f = itemInfo.offset * f3;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f4 = itemInfo2.offset * f3;
        }
        if (!(f2 < f)) {
            f = f2;
            if (f2 > f4) {
                f = f4;
            }
        }
        f4 = this.mLastMotionX;
        int n = (int)f;
        this.mLastMotionX = f4 + (f - (float)n);
        this.scrollTo(n, this.getScrollY());
        this.pageScrolled(n);
        long l = SystemClock.uptimeMillis();
        itemInfo = MotionEvent.obtain((long)this.mFakeDragBeginTime, (long)l, (int)2, (float)this.mLastMotionX, (float)0.0f, (int)0);
        this.mVelocityTracker.addMovement((MotionEvent)itemInfo);
        itemInfo.recycle();
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    protected int getChildDrawingOrder(int n, int n2) {
        int n3 = n2;
        if (this.mDrawingOrder != 2) return ((LayoutParams)this.mDrawingOrderedChildren.get((int)n3).getLayoutParams()).childIndex;
        n3 = n - 1 - n2;
        return ((LayoutParams)this.mDrawingOrderedChildren.get((int)n3).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    ItemInfo infoForAnyChild(View view) {
        ViewParent viewParent;
        while ((viewParent = view.getParent()) != this) {
            if (viewParent == null) return null;
            if (!(viewParent instanceof View)) {
                return null;
            }
            view = (View)viewParent;
        }
        return this.infoForChild(view);
    }

    ItemInfo infoForChild(View view) {
        int n = 0;
        while (n < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(n);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
            ++n;
        }
        return null;
    }

    ItemInfo infoForPosition(int n) {
        int n2 = 0;
        while (n2 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(n2);
            if (itemInfo.position == n) {
                return itemInfo;
            }
            ++n2;
        }
        return null;
    }

    void initViewPager() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        this.setFocusable(true);
        Context context = this.getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int)(400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int)(25.0f * f);
        this.mCloseEnough = (int)(2.0f * f);
        this.mDefaultGutterSize = (int)(f * 16.0f);
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)new MyAccessibilityDelegate(this));
        if (ViewCompat.getImportantForAccessibility((View)this) == 0) {
            ViewCompat.setImportantForAccessibility((View)this, (int)1);
        }
        ViewCompat.setOnApplyWindowInsetsListener((View)this, (OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin <= 0) return;
        if (this.mMarginDrawable == null) return;
        if (this.mItems.size() <= 0) return;
        if (this.mAdapter == null) return;
        int n = this.getScrollX();
        int n2 = this.getWidth();
        float f = this.mPageMargin;
        float f2 = n2;
        float f3 = f / f2;
        Object object = this.mItems;
        int n3 = 0;
        object = ((ArrayList)object).get(0);
        f = ((ItemInfo)object).offset;
        int n4 = this.mItems.size();
        int n5 = ((ItemInfo)object).position;
        int n6 = this.mItems.get((int)(n4 - 1)).position;
        while (n5 < n6) {
            float f4;
            while (n5 > ((ItemInfo)object).position && n3 < n4) {
                object = this.mItems;
                object = (ItemInfo)((ArrayList)object).get(++n3);
            }
            if (n5 == ((ItemInfo)object).position) {
                f4 = (((ItemInfo)object).offset + ((ItemInfo)object).widthFactor) * f2;
                f = ((ItemInfo)object).offset + ((ItemInfo)object).widthFactor + f3;
            } else {
                float f5 = this.mAdapter.getPageWidth(n5);
                f4 = f + (f5 + f3);
                f5 = (f + f5) * f2;
                f = f4;
                f4 = f5;
            }
            if ((float)this.mPageMargin + f4 > (float)n) {
                this.mMarginDrawable.setBounds(Math.round(f4), this.mTopPageBounds, Math.round((float)this.mPageMargin + f4), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            }
            if (f4 > (float)(n + n2)) {
                return;
            }
            ++n5;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getAction() & 0xFF;
        if (n != 3 && n != 1) {
            if (n != 0) {
                if (this.mIsBeingDragged) {
                    return true;
                }
                if (this.mIsUnableToDrag) {
                    return false;
                }
            }
            if (n != 0) {
                if (n != 2) {
                    if (n == 6) {
                        this.onSecondaryPointerUp(motionEvent);
                    }
                } else {
                    n = this.mActivePointerId;
                    if (n != -1) {
                        n = motionEvent.findPointerIndex(n);
                        float f = motionEvent.getX(n);
                        float f2 = f - this.mLastMotionX;
                        float f3 = Math.abs(f2);
                        float f4 = motionEvent.getY(n);
                        float f5 = Math.abs(f4 - this.mInitialMotionY);
                        if (f2 != 0.0f && !this.isGutterDrag(this.mLastMotionX, f2) && this.canScroll((View)this, false, (int)f2, (int)f, (int)f4)) {
                            this.mLastMotionX = f;
                            this.mLastMotionY = f4;
                            this.mIsUnableToDrag = true;
                            return false;
                        }
                        if (f3 > (float)this.mTouchSlop && f3 * 0.5f > f5) {
                            this.mIsBeingDragged = true;
                            this.requestParentDisallowInterceptTouchEvent(true);
                            this.setScrollState(1);
                            f3 = f2 > 0.0f ? this.mInitialMotionX + (float)this.mTouchSlop : this.mInitialMotionX - (float)this.mTouchSlop;
                            this.mLastMotionX = f3;
                            this.mLastMotionY = f4;
                            this.setScrollingCacheEnabled(true);
                        } else if (f5 > (float)this.mTouchSlop) {
                            this.mIsUnableToDrag = true;
                        }
                        if (this.mIsBeingDragged && this.performDrag(f)) {
                            ViewCompat.postInvalidateOnAnimation((View)this);
                        }
                    }
                }
            } else {
                float f;
                this.mInitialMotionX = f = motionEvent.getX();
                this.mLastMotionX = f;
                this.mInitialMotionY = f = motionEvent.getY();
                this.mLastMotionY = f;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsUnableToDrag = false;
                this.mIsScrollStarted = true;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    this.populate();
                    this.mIsBeingDragged = true;
                    this.requestParentDisallowInterceptTouchEvent(true);
                    this.setScrollState(1);
                } else {
                    this.completeScroll(false);
                    this.mIsBeingDragged = false;
                }
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            return this.mIsBeingDragged;
        }
        this.resetTouch();
        return false;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        View view;
        int n5;
        View view2;
        int n6;
        int n7 = this.getChildCount();
        int n8 = n3 - n;
        int n9 = n4 - n2;
        n2 = this.getPaddingLeft();
        n = this.getPaddingTop();
        n4 = this.getPaddingRight();
        n3 = this.getPaddingBottom();
        int n10 = this.getScrollX();
        int n11 = 0;
        for (n6 = 0; n6 < n7; ++n6) {
            int n12;
            int n13;
            int n14;
            int n15;
            block10: {
                block14: {
                    block15: {
                        block11: {
                            block12: {
                                block13: {
                                    view2 = this.getChildAt(n6);
                                    n15 = n2;
                                    n14 = n;
                                    n13 = n4;
                                    n12 = n3;
                                    n5 = n11;
                                    if (view2.getVisibility() == 8) break block10;
                                    view = (LayoutParams)view2.getLayoutParams();
                                    n15 = n2;
                                    n14 = n;
                                    n13 = n4;
                                    n12 = n3;
                                    n5 = n11;
                                    if (!view.isDecor) break block10;
                                    n5 = view.gravity & 7;
                                    n13 = view.gravity & 0x70;
                                    if (n5 == 1) break block11;
                                    if (n5 == 3) break block12;
                                    if (n5 == 5) break block13;
                                    n5 = n2;
                                    n12 = n2;
                                    n2 = n5;
                                    break block14;
                                }
                                n5 = n8 - n4 - view2.getMeasuredWidth();
                                n4 += view2.getMeasuredWidth();
                                break block15;
                            }
                            n5 = view2.getMeasuredWidth() + n2;
                            n12 = n2;
                            n2 = n5;
                            break block14;
                        }
                        n5 = Math.max((n8 - view2.getMeasuredWidth()) / 2, n2);
                    }
                    n12 = n5;
                }
                if (n13 != 16) {
                    if (n13 != 48) {
                        if (n13 != 80) {
                            n13 = n;
                            n5 = n;
                            n = n13;
                        } else {
                            n5 = n9 - n3 - view2.getMeasuredHeight();
                            n3 += view2.getMeasuredHeight();
                        }
                    } else {
                        n13 = view2.getMeasuredHeight() + n;
                        n5 = n;
                        n = n13;
                    }
                } else {
                    n5 = Math.max((n9 - view2.getMeasuredHeight()) / 2, n);
                }
                view2.layout(n12 += n10, n5, view2.getMeasuredWidth() + n12, n5 + view2.getMeasuredHeight());
                n5 = n11 + 1;
                n12 = n3;
                n13 = n4;
                n14 = n;
                n15 = n2;
            }
            n2 = n15;
            n = n14;
            n4 = n13;
            n3 = n12;
            n11 = n5;
        }
        for (n5 = 0; n5 < n7; ++n5) {
            view = this.getChildAt(n5);
            if (view.getVisibility() == 8) continue;
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (layoutParams.isDecor || (view2 = this.infoForChild(view)) == null) continue;
            float f = n8 - n2 - n4;
            n6 = (int)(view2.offset * f) + n2;
            if (layoutParams.needsMeasure) {
                layoutParams.needsMeasure = false;
                view.measure(View.MeasureSpec.makeMeasureSpec((int)((int)(f * layoutParams.widthFactor)), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)(n9 - n - n3), (int)0x40000000));
            }
            view.layout(n6, n, view.getMeasuredWidth() + n6, view.getMeasuredHeight() + n);
        }
        this.mTopPageBounds = n;
        this.mBottomPageBounds = n9 - n3;
        this.mDecorChildCount = n11;
        if (this.mFirstLayout) {
            this.scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
    }

    /*
     * Unable to fully structure code
     */
    protected void onMeasure(int var1_1, int var2_2) {
        this.setMeasuredDimension(ViewPager.getDefaultSize((int)0, (int)var1_1), ViewPager.getDefaultSize((int)0, (int)var2_2));
        var1_1 = this.getMeasuredWidth();
        this.mGutterSize = Math.min(var1_1 / 10, this.mDefaultGutterSize);
        var1_1 = var1_1 - this.getPaddingLeft() - this.getPaddingRight();
        var2_2 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        var11_3 = this.getChildCount();
        var5_4 = 0;
        while (true) {
            block13: {
                block14: {
                    var8_9 = 1;
                    var10_11 = 0x40000000;
                    if (var5_4 >= var11_3) break;
                    var12_12 = this.getChildAt(var5_4);
                    var3_5 = var1_1;
                    var4_6 = var2_2;
                    if (var12_12.getVisibility() == 8) break block13;
                    var13_13 = (LayoutParams)var12_12.getLayoutParams();
                    var3_5 = var1_1;
                    var4_6 = var2_2;
                    if (var13_13 == null) break block13;
                    var3_5 = var1_1;
                    var4_6 = var2_2;
                    if (!var13_13.isDecor) break block13;
                    var3_5 = var13_13.gravity & 7;
                    var4_6 = var13_13.gravity & 112;
                    var7_8 = var4_6 == 48 || var4_6 == 80;
                    var6_7 = var8_9;
                    if (var3_5 != 3) {
                        var6_7 = var3_5 == 5 ? var8_9 : 0;
                    }
                    var3_5 = -2147483648;
                    if (!var7_8) break block14;
                    var4_6 = 0x40000000;
                    ** GOTO lbl-1000
                }
                var4_6 = var3_5;
                if (var6_7 != 0) {
                    var8_9 = 0x40000000;
                    var4_6 = var3_5;
                    var3_5 = var8_9;
                } else lbl-1000:
                // 2 sources

                {
                    var3_5 = -2147483648;
                }
                if (var13_13.width != -2) {
                    var4_6 = var13_13.width != -1 ? var13_13.width : var1_1;
                    var8_9 = 0x40000000;
                } else {
                    var8_9 = var4_6;
                    var4_6 = var1_1;
                }
                if (var13_13.height != -2) {
                    var3_5 = var13_13.height != -1 ? var13_13.height : var2_2;
                } else {
                    var9_10 = var2_2;
                    var10_11 = var3_5;
                    var3_5 = var9_10;
                }
                var12_12.measure(View.MeasureSpec.makeMeasureSpec((int)var4_6, (int)var8_9), View.MeasureSpec.makeMeasureSpec((int)var3_5, (int)var10_11));
                if (var7_8) {
                    var4_6 = var2_2 - var12_12.getMeasuredHeight();
                    var3_5 = var1_1;
                } else {
                    var3_5 = var1_1;
                    var4_6 = var2_2;
                    if (var6_7 != 0) {
                        var3_5 = var1_1 - var12_12.getMeasuredWidth();
                        var4_6 = var2_2;
                    }
                }
            }
            ++var5_4;
            var1_1 = var3_5;
            var2_2 = var4_6;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec((int)var1_1, (int)0x40000000);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec((int)var2_2, (int)0x40000000);
        this.mInLayout = true;
        this.populate();
        var2_2 = 0;
        this.mInLayout = false;
        var3_5 = this.getChildCount();
        while (var2_2 < var3_5) {
            var13_13 = this.getChildAt(var2_2);
            if (!(var13_13.getVisibility() == 8 || (var12_12 = (LayoutParams)var13_13.getLayoutParams()) != null && var12_12.isDecor)) {
                var13_13.measure(View.MeasureSpec.makeMeasureSpec((int)((int)((float)var1_1 * var12_12.widthFactor)), (int)0x40000000), this.mChildHeightMeasureSpec);
            }
            ++var2_2;
        }
    }

    protected void onPageScrolled(int n, float f, int n2) {
        View view;
        int n3 = this.mDecorChildCount;
        int n4 = 0;
        if (n3 > 0) {
            int n5 = this.getScrollX();
            n3 = this.getPaddingLeft();
            int n6 = this.getPaddingRight();
            int n7 = this.getWidth();
            int n8 = this.getChildCount();
            for (int i = 0; i < n8; ++i) {
                view = this.getChildAt(i);
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                if (!layoutParams.isDecor) continue;
                int n9 = layoutParams.gravity & 7;
                if (n9 != 1) {
                    int n10;
                    if (n9 != 3) {
                        if (n9 != 5) {
                            n10 = n3;
                            n9 = n3;
                            n3 = n10;
                        } else {
                            n9 = n7 - n6 - view.getMeasuredWidth();
                            n6 += view.getMeasuredWidth();
                        }
                    } else {
                        n10 = view.getWidth() + n3;
                        n9 = n3;
                        n3 = n10;
                    }
                } else {
                    n9 = Math.max((n7 - view.getMeasuredWidth()) / 2, n3);
                }
                n9 = n9 + n5 - view.getLeft();
                if (n9 == 0) continue;
                view.offsetLeftAndRight(n9);
            }
        }
        this.dispatchOnPageScrolled(n, f, n2);
        if (this.mPageTransformer != null) {
            n3 = this.getScrollX();
            n2 = this.getChildCount();
            for (n = n4; n < n2; ++n) {
                view = this.getChildAt(n);
                if (((LayoutParams)view.getLayoutParams()).isDecor) continue;
                f = (float)(view.getLeft() - n3) / (float)this.getClientWidth();
                this.mPageTransformer.transformPage(view, f);
            }
        }
        this.mCalledSuper = true;
    }

    protected boolean onRequestFocusInDescendants(int n, Rect rect) {
        int n2;
        int n3 = this.getChildCount();
        int n4 = -1;
        if ((n & 2) != 0) {
            n4 = n3;
            n3 = 0;
            n2 = 1;
        } else {
            --n3;
            n2 = -1;
        }
        while (n3 != n4) {
            ItemInfo itemInfo;
            View view = this.getChildAt(n3);
            if (view.getVisibility() == 0 && (itemInfo = this.infoForChild(view)) != null && itemInfo.position == this.mCurItem && view.requestFocus(n, rect)) {
                return true;
            }
            n3 += n2;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        parcelable = this.mAdapter;
        if (parcelable != null) {
            parcelable.restoreState(savedState.adapterState, savedState.loader);
            this.setCurrentItemInternal(savedState.position, false, true);
        } else {
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null) return savedState;
        savedState.adapterState = pagerAdapter.saveState();
        return savedState;
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n == n3) return;
        n2 = this.mPageMargin;
        this.recomputeScrollPosition(n, n3, n2, n2);
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block19: {
            block16: {
                block17: {
                    block18: {
                        if (this.mFakeDragging) {
                            return true;
                        }
                        var6_2 = var1_1.getAction();
                        var9_3 = false;
                        if (var6_2 == 0 && var1_1.getEdgeFlags() != 0) {
                            return false;
                        }
                        var10_4 = this.mAdapter;
                        if (var10_4 == null) return false;
                        if (var10_4.getCount() == 0) {
                            return false;
                        }
                        if (this.mVelocityTracker == null) {
                            this.mVelocityTracker = VelocityTracker.obtain();
                        }
                        this.mVelocityTracker.addMovement(var1_1);
                        var6_2 = var1_1.getAction() & 255;
                        if (var6_2 == 0) break block16;
                        if (var6_2 == 1) break block17;
                        if (var6_2 == 2) break block18;
                        if (var6_2 != 3) {
                            if (var6_2 != 5) {
                                if (var6_2 == 6) {
                                    this.onSecondaryPointerUp(var1_1);
                                    this.mLastMotionX = var1_1.getX(var1_1.findPointerIndex(this.mActivePointerId));
                                }
                            } else {
                                var6_2 = var1_1.getActionIndex();
                                this.mLastMotionX = var1_1.getX(var6_2);
                                this.mActivePointerId = var1_1.getPointerId(var6_2);
                            }
                        } else if (this.mIsBeingDragged) {
                            this.scrollToItem(this.mCurItem, true, 0, false);
                            var9_3 = this.resetTouch();
                        }
                        break block19;
                    }
                    if (this.mIsBeingDragged) ** GOTO lbl54
                    var6_2 = var1_1.findPointerIndex(this.mActivePointerId);
                    if (var6_2 == -1) {
                        var9_3 = this.resetTouch();
                    } else {
                        var2_5 = var1_1.getX(var6_2);
                        var5_8 = Math.abs(var2_5 - this.mLastMotionX);
                        var3_9 = var1_1.getY(var6_2);
                        var4_11 = Math.abs(var3_9 - this.mLastMotionY);
                        if (var5_8 > (float)this.mTouchSlop && var5_8 > var4_11) {
                            this.mIsBeingDragged = true;
                            this.requestParentDisallowInterceptTouchEvent(true);
                            var4_11 = this.mInitialMotionX;
                            var2_5 = var2_5 - var4_11 > 0.0f ? var4_11 + (float)this.mTouchSlop : var4_11 - (float)this.mTouchSlop;
                            this.mLastMotionX = var2_5;
                            this.mLastMotionY = var3_9;
                            this.setScrollState(1);
                            this.setScrollingCacheEnabled(true);
                            var10_4 = this.getParent();
                            if (var10_4 != null) {
                                var10_4.requestDisallowInterceptTouchEvent(true);
                            }
                        }
lbl54:
                        // 6 sources

                        if (this.mIsBeingDragged) {
                            var9_3 = false | this.performDrag(var1_1.getX(var1_1.findPointerIndex(this.mActivePointerId)));
                        }
                    }
                    break block19;
                }
                if (this.mIsBeingDragged) {
                    var10_4 = this.mVelocityTracker;
                    var10_4.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
                    var7_12 = (int)var10_4.getXVelocity(this.mActivePointerId);
                    this.mPopulatePending = true;
                    var8_13 = this.getClientWidth();
                    var6_2 = this.getScrollX();
                    var10_4 = this.infoForCurrentScrollPosition();
                    var3_10 = this.mPageMargin;
                    var2_6 = var8_13;
                    this.setCurrentItemInternal(this.determineTargetPage(var10_4.position, ((float)var6_2 / var2_6 - var10_4.offset) / (var10_4.widthFactor + (var3_10 /= var2_6)), var7_12, (int)(var1_1.getX(var1_1.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, var7_12);
                    var9_3 = this.resetTouch();
                }
                break block19;
            }
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            this.populate();
            this.mInitialMotionX = var2_7 = var1_1.getX();
            this.mLastMotionX = var2_7;
            this.mInitialMotionY = var2_7 = var1_1.getY();
            this.mLastMotionY = var2_7;
            this.mActivePointerId = var1_1.getPointerId(0);
        }
        if (var9_3 == false) return true;
        ViewCompat.postInvalidateOnAnimation((View)this);
        return true;
    }

    boolean pageLeft() {
        int n = this.mCurItem;
        if (n <= 0) return false;
        this.setCurrentItem(n - 1, true);
        return true;
    }

    boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null) return false;
        if (this.mCurItem >= pagerAdapter.getCount() - 1) return false;
        this.setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    void populate() {
        this.populate(this.mCurItem);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    void populate(int var1_1) {
        block23: {
            block28: {
                block22: {
                    var5_2 = this.mCurItem;
                    if (var5_2 != var1_1) {
                        var14_3 = this.infoForPosition(var5_2);
                        this.mCurItem = var1_1;
                    } else {
                        var14_3 = null;
                    }
                    if (this.mAdapter == null) {
                        this.sortChildDrawingOrder();
                        return;
                    }
                    if (this.mPopulatePending) {
                        this.sortChildDrawingOrder();
                        return;
                    }
                    if (this.getWindowToken() == null) {
                        return;
                    }
                    this.mAdapter.startUpdate((ViewGroup)this);
                    var1_1 = this.mOffscreenPageLimit;
                    var11_4 = Math.max(0, this.mCurItem - var1_1);
                    var9_5 = this.mAdapter.getCount();
                    var10_6 = Math.min(var9_5 - 1, this.mCurItem + var1_1);
                    if (var9_5 == this.mExpectedAdapterCount) {
                    } else {
                        try {
                            var13_8 = this.getResources().getResourceName(this.getId());
                        }
                        catch (Resources.NotFoundException var13_9) {
                            var13_8 = Integer.toHexString(this.getId());
                        }
                        var14_3 = new StringBuilder();
                        var14_3.append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
                        var14_3.append(this.mExpectedAdapterCount);
                        var14_3.append(", found: ");
                        var14_3.append(var9_5);
                        var14_3.append(" Pager id: ");
                        var14_3.append((String)var13_8);
                        var14_3.append(" Pager class: ");
                        var14_3.append(this.getClass());
                        var14_3.append(" Problematic adapter: ");
                        var14_3.append(this.mAdapter.getClass());
                        var13_8 = new IllegalStateException(var14_3.toString());
                        throw var13_8;
                    }
                    for (var1_1 = 0; var1_1 < this.mItems.size(); ++var1_1) {
                        var13_7 /* !! */  = this.mItems.get(var1_1);
                        if (var13_7 /* !! */ .position < this.mCurItem) continue;
                        if (var13_7 /* !! */ .position != this.mCurItem) break;
                        break block22;
                    }
                    var13_7 /* !! */  = null;
                }
                var15_10 = var13_7 /* !! */ ;
                if (var13_7 /* !! */  == null) {
                    var15_10 = var13_7 /* !! */ ;
                    if (var9_5 > 0) {
                        var15_10 = this.addNewItem(this.mCurItem, var1_1);
                    }
                }
                if (var15_10 == null) break block23;
                var5_2 = var1_1 - 1;
                var13_7 /* !! */  = var5_2 >= 0 ? this.mItems.get(var5_2) : null;
                var12_11 = this.getClientWidth();
                var4_12 = var12_11 <= 0 ? 0.0f : 2.0f - var15_10.widthFactor + (float)this.getPaddingLeft() / (float)var12_11;
                var3_14 = 0.0f;
                for (var8_13 = this.mCurItem - 1; var8_13 >= 0; --var8_13) {
                    block25: {
                        block26: {
                            block27: {
                                block24: {
                                    if (!(var3_14 >= var4_12) || var8_13 >= var11_4) break block24;
                                    if (var13_7 /* !! */  == null) break;
                                    var7_17 = var1_1;
                                    var6_16 = var5_2;
                                    var16_18 = var13_7 /* !! */ ;
                                    var2_15 = var3_14;
                                    if (var8_13 != var13_7 /* !! */ .position) break block25;
                                    var7_17 = var1_1--;
                                    var6_16 = var5_2;
                                    var16_18 = var13_7 /* !! */ ;
                                    var2_15 = var3_14;
                                    if (var13_7 /* !! */ .scrolling) break block25;
                                    this.mItems.remove(var5_2);
                                    this.mAdapter.destroyItem((ViewGroup)this, var8_13, var13_7 /* !! */ .object);
                                    var6_16 = var1_1;
                                    var7_17 = --var5_2;
                                    var2_15 = var3_14;
                                    if (var5_2 < 0) ** GOTO lbl-1000
                                    var13_7 /* !! */  = this.mItems.get(var5_2);
                                    var2_15 = var3_14;
                                    break block26;
                                }
                                if (var13_7 /* !! */  == null || var8_13 != var13_7 /* !! */ .position) break block27;
                                var6_16 = var1_1;
                                var7_17 = --var5_2;
                                var2_15 = var3_14 += var13_7 /* !! */ .widthFactor;
                                if (var5_2 < 0) ** GOTO lbl-1000
                                var13_7 /* !! */  = this.mItems.get(var5_2);
                                var2_15 = var3_14;
                                break block26;
                            }
                            var6_16 = ++var1_1;
                            var7_17 = var5_2;
                            var2_15 = var3_14 += this.addNewItem((int)var8_13, (int)(var5_2 + 1)).widthFactor;
                            if (var5_2 >= 0) {
                                var13_7 /* !! */  = this.mItems.get(var5_2);
                                var2_15 = var3_14;
                            } else lbl-1000:
                            // 3 sources

                            {
                                var13_7 /* !! */  = null;
                                var5_2 = var7_17;
                                var1_1 = var6_16;
                            }
                        }
                        var16_18 = var13_7 /* !! */ ;
                        var6_16 = var5_2;
                        var7_17 = var1_1;
                    }
                    var1_1 = var7_17;
                    var5_2 = var6_16;
                    var13_7 /* !! */  = var16_18;
                    var3_14 = var2_15;
                }
                var3_14 = var15_10.widthFactor;
                var6_16 = var1_1 + 1;
                if (!(var3_14 < 2.0f)) break block28;
                var13_7 /* !! */  = var6_16 < this.mItems.size() ? this.mItems.get(var6_16) : null;
                var4_12 = var12_11 <= 0 ? 0.0f : (float)this.getPaddingRight() / (float)var12_11 + 2.0f;
                var5_2 = this.mCurItem;
                var16_18 = var13_7 /* !! */ ;
                while ((var7_17 = var5_2 + 1) < var9_5) {
                    block30: {
                        block31: {
                            block29: {
                                if (!(var3_14 >= var4_12) || var7_17 <= var10_6) break block29;
                                if (var16_18 == null) break;
                                var2_15 = var3_14;
                                var5_2 = var6_16;
                                var13_7 /* !! */  = var16_18;
                                if (var7_17 != var16_18.position) break block30;
                                var2_15 = var3_14;
                                var5_2 = var6_16;
                                var13_7 /* !! */  = var16_18;
                                if (var16_18.scrolling) break block30;
                                this.mItems.remove(var6_16);
                                this.mAdapter.destroyItem((ViewGroup)this, var7_17, var16_18.object);
                                var2_15 = var3_14;
                                var5_2 = var6_16;
                                if (var6_16 >= this.mItems.size()) ** GOTO lbl-1000
                                var13_7 /* !! */  = this.mItems.get(var6_16);
                                var2_15 = var3_14;
                                var5_2 = var6_16;
                                break block30;
                            }
                            if (var16_18 == null || var7_17 != var16_18.position) break block31;
                            var2_15 = var3_14 += var16_18.widthFactor;
                            var5_2 = ++var6_16;
                            if (var6_16 >= this.mItems.size()) ** GOTO lbl-1000
                            var13_7 /* !! */  = this.mItems.get(var6_16);
                            var2_15 = var3_14;
                            var5_2 = var6_16;
                            break block30;
                        }
                        var13_7 /* !! */  = this.addNewItem(var7_17, var6_16);
                        var2_15 = var3_14 += var13_7 /* !! */ .widthFactor;
                        var5_2 = ++var6_16;
                        if (var6_16 < this.mItems.size()) {
                            var13_7 /* !! */  = this.mItems.get(var6_16);
                            var5_2 = var6_16;
                            var2_15 = var3_14;
                        } else lbl-1000:
                        // 3 sources

                        {
                            var13_7 /* !! */  = null;
                        }
                    }
                    var3_14 = var2_15;
                    var6_16 = var5_2;
                    var16_18 = var13_7 /* !! */ ;
                    var5_2 = var7_17;
                }
            }
            this.calculatePageOffsets(var15_10, var1_1, (ItemInfo)var14_3);
            this.mAdapter.setPrimaryItem((ViewGroup)this, this.mCurItem, var15_10.object);
        }
        this.mAdapter.finishUpdate((ViewGroup)this);
        var5_2 = this.getChildCount();
        for (var1_1 = 0; var1_1 < var5_2; ++var1_1) {
            var14_3 = this.getChildAt(var1_1);
            var13_7 /* !! */  = (LayoutParams)var14_3.getLayoutParams();
            var13_7 /* !! */ .childIndex = var1_1;
            if (var13_7 /* !! */ .isDecor || var13_7 /* !! */ .widthFactor != 0.0f || (var14_3 = this.infoForChild((View)var14_3)) == null) continue;
            var13_7 /* !! */ .widthFactor = var14_3.widthFactor;
            var13_7 /* !! */ .position = var14_3.position;
        }
        this.sortChildDrawingOrder();
        if (this.hasFocus() == false) return;
        var13_7 /* !! */  = this.findFocus();
        var13_7 /* !! */  = var13_7 /* !! */  != null ? this.infoForAnyChild((View)var13_7 /* !! */ ) : null;
        if (var13_7 /* !! */  != null) {
            if (var13_7 /* !! */ .position == this.mCurItem) return;
        }
        var1_1 = 0;
        while (var1_1 < this.getChildCount()) {
            var14_3 = this.getChildAt(var1_1);
            var13_7 /* !! */  = this.infoForChild((View)var14_3);
            if (var13_7 /* !! */  != null && var13_7 /* !! */ .position == this.mCurItem && var14_3.requestFocus(2)) {
                return;
            }
            ++var1_1;
        }
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list == null) return;
        list.remove(onAdapterChangeListener);
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list == null) return;
        list.remove(onPageChangeListener);
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            this.removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        int n;
        Object object = this.mAdapter;
        int n2 = 0;
        if (object != null) {
            object.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup)this);
            for (n = 0; n < this.mItems.size(); ++n) {
                object = this.mItems.get(n);
                this.mAdapter.destroyItem((ViewGroup)this, ((ItemInfo)object).position, ((ItemInfo)object).object);
            }
            this.mAdapter.finishUpdate((ViewGroup)this);
            this.mItems.clear();
            this.removeNonDecorViews();
            this.mCurItem = 0;
            this.scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver(this);
            }
            this.mAdapter.setViewPagerObserver((DataSetObserver)this.mObserver);
            this.mPopulatePending = false;
            boolean bl = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                this.setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!bl) {
                this.populate();
            } else {
                this.requestLayout();
            }
        }
        if ((object = this.mAdapterChangeListeners) == null) return;
        if (object.isEmpty()) return;
        int n3 = this.mAdapterChangeListeners.size();
        n = n2;
        while (n < n3) {
            this.mAdapterChangeListeners.get(n).onAdapterChanged(this, pagerAdapter2, pagerAdapter);
            ++n;
        }
    }

    public void setCurrentItem(int n) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(n, this.mFirstLayout ^ true, false);
    }

    public void setCurrentItem(int n, boolean bl) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(n, bl, false);
    }

    void setCurrentItemInternal(int n, boolean bl, boolean bl2) {
        this.setCurrentItemInternal(n, bl, bl2, 0);
    }

    void setCurrentItemInternal(int n, boolean bl, boolean bl2, int n2) {
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean bl3 = false;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            int n3;
            if (!bl2 && this.mCurItem == n && this.mItems.size() != 0) {
                this.setScrollingCacheEnabled(false);
                return;
            }
            if (n < 0) {
                n3 = 0;
            } else {
                n3 = n;
                if (n >= this.mAdapter.getCount()) {
                    n3 = this.mAdapter.getCount() - 1;
                }
            }
            int n4 = this.mOffscreenPageLimit;
            n = this.mCurItem;
            if (n3 > n + n4 || n3 < n - n4) {
                for (n = 0; n < this.mItems.size(); ++n) {
                    this.mItems.get((int)n).scrolling = true;
                }
            }
            bl2 = bl3;
            if (this.mCurItem != n3) {
                bl2 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = n3;
                if (bl2) {
                    this.dispatchOnPageSelected(n3);
                }
                this.requestLayout();
            } else {
                this.populate(n3);
                this.scrollToItem(n3, bl, n2, bl2);
            }
            return;
        }
        this.setScrollingCacheEnabled(false);
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOffscreenPageLimit(int n) {
        int n2 = n;
        if (n < 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested offscreen page limit ");
            stringBuilder.append(n);
            stringBuilder.append(" too small; defaulting to ");
            stringBuilder.append(1);
            Log.w((String)TAG, (String)stringBuilder.toString());
            n2 = 1;
        }
        if (n2 == this.mOffscreenPageLimit) return;
        this.mOffscreenPageLimit = n2;
        this.populate();
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int n) {
        int n2 = this.mPageMargin;
        this.mPageMargin = n;
        int n3 = this.getWidth();
        this.recomputeScrollPosition(n3, n3, n, n2);
        this.requestLayout();
    }

    public void setPageMarginDrawable(int n) {
        this.setPageMarginDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            this.refreshDrawableState();
        }
        boolean bl = drawable == null;
        this.setWillNotDraw(bl);
        this.invalidate();
    }

    public void setPageTransformer(boolean bl, PageTransformer pageTransformer) {
        this.setPageTransformer(bl, pageTransformer, 2);
    }

    public void setPageTransformer(boolean bl, PageTransformer pageTransformer, int n) {
        int n2 = 1;
        boolean bl2 = pageTransformer != null;
        boolean bl3 = this.mPageTransformer != null;
        boolean bl4 = bl2 != bl3;
        this.mPageTransformer = pageTransformer;
        this.setChildrenDrawingOrderEnabled(bl2);
        if (bl2) {
            if (bl) {
                n2 = 2;
            }
            this.mDrawingOrder = n2;
            this.mPageTransformerLayerType = n;
        } else {
            this.mDrawingOrder = 0;
        }
        if (!bl4) return;
        this.populate();
    }

    void setScrollState(int n) {
        if (this.mScrollState == n) {
            return;
        }
        this.mScrollState = n;
        if (this.mPageTransformer != null) {
            boolean bl = n != 0;
            this.enableLayers(bl);
        }
        this.dispatchOnScrollStateChanged(n);
    }

    void smoothScrollTo(int n, int n2) {
        this.smoothScrollTo(n, n2, 0);
    }

    void smoothScrollTo(int n, int n2, int n3) {
        if (this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        int n4 = scroller != null && !scroller.isFinished() ? 1 : 0;
        if (n4 != 0) {
            n4 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            this.setScrollingCacheEnabled(false);
        } else {
            n4 = this.getScrollX();
        }
        int n5 = this.getScrollY();
        int n6 = n - n4;
        if (n6 == 0 && (n2 -= n5) == 0) {
            this.completeScroll(false);
            this.populate();
            this.setScrollState(0);
            return;
        }
        this.setScrollingCacheEnabled(true);
        this.setScrollState(2);
        n = this.getClientWidth();
        int n7 = n / 2;
        float f = Math.abs(n6);
        float f2 = n;
        float f3 = Math.min(1.0f, f * 1.0f / f2);
        f = n7;
        f3 = this.distanceInfluenceForSnapDuration(f3);
        n = Math.abs(n3);
        if (n > 0) {
            n = Math.round(Math.abs((f + f3 * f) / (float)n) * 1000.0f) * 4;
        } else {
            f = this.mAdapter.getPageWidth(this.mCurItem);
            n = (int)(((float)Math.abs(n6) / (f2 * f + (float)this.mPageMargin) + 1.0f) * 100.0f);
        }
        n = Math.min(n, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(n4, n5, n6, n2, n);
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean bl = super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
        return bl;
    }
}
