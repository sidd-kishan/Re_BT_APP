/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.FocusFinder
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.animation.Interpolator
 *  android.widget.EdgeEffect
 *  android.widget.OverScroller
 *  androidx.core.os.TraceCompat
 *  androidx.core.util.Preconditions
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.MotionEventCompat
 *  androidx.core.view.NestedScrollingChild2
 *  androidx.core.view.NestedScrollingChild3
 *  androidx.core.view.NestedScrollingChildHelper
 *  androidx.core.view.ScrollingView
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewConfigurationCompat
 *  androidx.core.view.accessibility.AccessibilityEventCompat
 *  androidx.core.widget.EdgeEffectCompat
 *  androidx.recyclerview.R$attr
 *  androidx.recyclerview.R$dimen
 *  androidx.recyclerview.R$styleable
 *  androidx.recyclerview.widget.AdapterHelper
 *  androidx.recyclerview.widget.AdapterHelper$Callback
 *  androidx.recyclerview.widget.ChildHelper
 *  androidx.recyclerview.widget.ChildHelper$Callback
 *  androidx.recyclerview.widget.DefaultItemAnimator
 *  androidx.recyclerview.widget.FastScroller
 *  androidx.recyclerview.widget.GapWorker
 *  androidx.recyclerview.widget.GapWorker$LayoutPrefetchRegistryImpl
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 *  androidx.recyclerview.widget.RecyclerView$ChildDrawingOrderCallback
 *  androidx.recyclerview.widget.RecyclerView$EdgeEffectFactory
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemAnimatorListener
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimatorRestoreListener
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener
 *  androidx.recyclerview.widget.RecyclerView$OnFlingListener
 *  androidx.recyclerview.widget.RecyclerView$OnItemTouchListener
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  androidx.recyclerview.widget.RecyclerView$RecycledViewPool
 *  androidx.recyclerview.widget.RecyclerView$Recycler
 *  androidx.recyclerview.widget.RecyclerView$RecyclerListener
 *  androidx.recyclerview.widget.RecyclerView$RecyclerViewDataObserver
 *  androidx.recyclerview.widget.RecyclerView$SavedState
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.RecyclerView$ViewCacheExtension
 *  androidx.recyclerview.widget.RecyclerView$ViewFlinger
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
 *  androidx.recyclerview.widget.ViewInfoStore
 *  androidx.recyclerview.widget.ViewInfoStore$ProcessCallback
 */
package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.FastScroller;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewInfoStore;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public class RecyclerView
extends ViewGroup
implements ScrollingView,
NestedScrollingChild2,
NestedScrollingChild3 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS;
    public static final long NO_ID = -1L;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout = false;
    boolean mDispatchItemsChangedEvent = false;
    private int mDispatchScrollCounter = 0;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth = 0;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter = 0;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver = new RecyclerViewDataObserver(this);
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler = new Recycler(this);
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId = -1;
    private int mScrollState = 0;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore = new ViewInfoStore();

    static {
        NESTED_SCROLLING_ATTRS = new int[]{16843830};
        boolean bl = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        FORCE_INVALIDATE_DISPLAY_LIST = bl;
        bl = Build.VERSION.SDK_INT >= 23;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = bl;
        bl = Build.VERSION.SDK_INT >= 16;
        POST_UPDATES_ON_ANIMATION = bl;
        bl = Build.VERSION.SDK_INT >= 21;
        ALLOW_THREAD_GAP_WORK = bl;
        bl = Build.VERSION.SDK_INT <= 15;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = bl;
        bl = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = bl;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new /* Unavailable Anonymous Inner Class!! */;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mUpdateChildViewsRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList<RecyclerListener>();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean bl = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        Object object = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mPrefetchRegistry = object;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList<ViewHolder>();
        this.mItemAnimatorRunner = new /* Unavailable Anonymous Inner Class!! */;
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.setScrollContainer(true);
        this.setFocusableInTouchMode(true);
        object = ViewConfiguration.get((Context)context);
        this.mTouchSlop = object.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor((ViewConfiguration)object, (Context)context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor((ViewConfiguration)object, (Context)context);
        this.mMinFlingVelocity = object.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = object.getScaledMaximumFlingVelocity();
        boolean bl2 = this.getOverScrollMode() == 2;
        this.setWillNotDraw(bl2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        this.initAdapterManager();
        this.initChildrenHelper();
        this.initAutofill();
        if (ViewCompat.getImportantForAccessibility((View)this) == 0) {
            ViewCompat.setImportantForAccessibility((View)this, (int)1);
        }
        this.mAccessibilityManager = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, n, 0);
        ViewCompat.saveAttributeDataForStyleable((View)this, (Context)context, (int[])R.styleable.RecyclerView, (AttributeSet)attributeSet, (TypedArray)typedArray, (int)n, (int)0);
        object = typedArray.getString(R.styleable.RecyclerView_layoutManager);
        if (typedArray.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            this.setDescendantFocusability(262144);
        }
        this.mClipToPadding = typedArray.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        this.mEnableFastScroller = bl2 = typedArray.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        if (bl2) {
            this.initFastScroller((StateListDrawable)typedArray.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArray.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)typedArray.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArray.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArray.recycle();
        this.createLayoutManager(context, (String)object, attributeSet, n, 0);
        bl2 = bl;
        if (Build.VERSION.SDK_INT >= 21) {
            object = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, n, 0);
            ViewCompat.saveAttributeDataForStyleable((View)this, (Context)context, (int[])NESTED_SCROLLING_ATTRS, (AttributeSet)attributeSet, (TypedArray)object, (int)n, (int)0);
            bl2 = object.getBoolean(0, true);
            object.recycle();
        }
        this.setNestedScrollingEnabled(bl2);
    }

    static /* synthetic */ void access$000(RecyclerView recyclerView, View view, int n, ViewGroup.LayoutParams layoutParams) {
        recyclerView.attachViewToParent(view, n, layoutParams);
    }

    static /* synthetic */ void access$100(RecyclerView recyclerView, int n) {
        recyclerView.detachViewFromParent(n);
    }

    static /* synthetic */ boolean access$200(RecyclerView recyclerView) {
        return recyclerView.awakenScrollBars();
    }

    static /* synthetic */ void access$300(RecyclerView recyclerView, int n, int n2) {
        recyclerView.setMeasuredDimension(n, n2);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean bl = view.getParent() == this;
        this.mRecycler.unscrapView(this.getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
        } else if (!bl) {
            this.mChildHelper.addView(view, true);
        } else {
            this.mChildHelper.hide(view);
        }
    }

    private void animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean bl, boolean bl2) {
        viewHolder.setIsRecyclable(false);
        if (bl) {
            this.addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (bl2) {
                this.addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            this.addAnimatingView(viewHolder);
            this.mRecycler.unscrapView(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (!this.mItemAnimator.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) return;
        this.postAnimationRunner();
    }

    private void cancelScroll() {
        this.resetScroll();
        this.setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        if (viewHolder.mNestedRecyclerView == null) return;
        View view = (View)viewHolder.mNestedRecyclerView.get();
        while (true) {
            if (view == null) {
                viewHolder.mNestedRecyclerView = null;
                return;
            }
            if (view == viewHolder.itemView) {
                return;
            }
            if ((view = view.getParent()) instanceof View) continue;
            view = null;
        }
    }

    /*
     * Exception decompiling
     */
    private void createLayoutManager(Context var1_1, String var2_6, AttributeSet var3_9, int var4_10, int var5_11) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK], 0[TRYBLOCK]], but top level block is 5[CATCHBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private boolean didChildRangeChange(int n, int n2) {
        this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] nArray = this.mMinMaxLayoutPositions;
        boolean bl = false;
        if (nArray[0] == n) {
            if (nArray[1] == n2) return bl;
        }
        bl = true;
        return bl;
    }

    private void dispatchContentChangedIfNecessary() {
        int n = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (n == 0) return;
        if (!this.isAccessibilityEnabled()) return;
        AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain();
        accessibilityEvent.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes((AccessibilityEvent)accessibilityEvent, (int)n);
        this.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    private void dispatchLayoutStep1() {
        ViewHolder viewHolder;
        int n;
        int n2;
        State state = this.mState;
        boolean bl = true;
        state.assertLayoutStep(1);
        this.fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        this.startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        this.onEnterLayoutOrScroll();
        this.processAdapterUpdatesAndSetAnimationFlags();
        this.saveFocusInfo();
        state = this.mState;
        if (!state.mRunSimpleAnimations || !this.mItemsChanged) {
            bl = false;
        }
        state.mTrackOldChangeHolders = bl;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        state = this.mState;
        state.mInPreLayout = state.mRunPredictiveAnimations;
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            n2 = this.mChildHelper.getChildCount();
            for (n = 0; n < n2; ++n) {
                viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(n));
                if (viewHolder.shouldIgnore() || viewHolder.isInvalid() && !this.mAdapter.hasStableIds()) continue;
                state = this.mItemAnimator.recordPreLayoutInformation(this.mState, viewHolder, ItemAnimator.buildAdapterChangeFlagsForAnimations((ViewHolder)viewHolder), viewHolder.getUnmodifiedPayloads());
                this.mViewInfoStore.addToPreLayout(viewHolder, (ItemAnimator.ItemHolderInfo)state);
                if (!this.mState.mTrackOldChangeHolders || !viewHolder.isUpdated() || viewHolder.isRemoved() || viewHolder.shouldIgnore() || viewHolder.isInvalid()) continue;
                long l = this.getChangedHolderKey(viewHolder);
                this.mViewInfoStore.addToOldChangeHolders(l, viewHolder);
            }
        }
        if (!this.mState.mRunPredictiveAnimations) {
            this.clearOldPositions();
        } else {
            this.saveOldPositions();
            bl = this.mState.mStructureChanged;
            this.mState.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.mStructureChanged = bl;
            for (n = 0; n < this.mChildHelper.getChildCount(); ++n) {
                viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(n));
                if (viewHolder.shouldIgnore() || this.mViewInfoStore.isInPreLayout(viewHolder)) continue;
                int n3 = ItemAnimator.buildAdapterChangeFlagsForAnimations((ViewHolder)viewHolder);
                bl = viewHolder.hasAnyOfTheFlags(8192);
                n2 = n3;
                if (!bl) {
                    n2 = n3 | 0x1000;
                }
                state = this.mItemAnimator.recordPreLayoutInformation(this.mState, viewHolder, n2, viewHolder.getUnmodifiedPayloads());
                if (bl) {
                    this.recordAnimationInfoIfBouncedHiddenView(viewHolder, (ItemAnimator.ItemHolderInfo)state);
                    continue;
                }
                this.mViewInfoStore.addToAppearedInPreLayoutHolders(viewHolder, (ItemAnimator.ItemHolderInfo)state);
            }
            this.clearOldPositions();
        }
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            if (this.mPendingSavedState.mLayoutState != null) {
                this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
            }
            this.mPendingSavedState = null;
        }
        this.mState.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.mStructureChanged = false;
        State state = this.mState;
        boolean bl = state.mRunSimpleAnimations && this.mItemAnimator != null;
        state.mRunSimpleAnimations = bl;
        this.mState.mLayoutStep = 4;
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        Object object;
        this.mState.assertLayoutStep(4);
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        this.mState.mLayoutStep = 1;
        if (this.mState.mRunSimpleAnimations) {
            for (int i = this.mChildHelper.getChildCount() - 1; i >= 0; --i) {
                object = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                if (object.shouldIgnore()) continue;
                long l = this.getChangedHolderKey((ViewHolder)object);
                ItemAnimator.ItemHolderInfo itemHolderInfo = this.mItemAnimator.recordPostLayoutInformation(this.mState, (ViewHolder)object);
                ViewHolder viewHolder = this.mViewInfoStore.getFromOldChangeHolders(l);
                if (viewHolder != null && !viewHolder.shouldIgnore()) {
                    boolean bl = this.mViewInfoStore.isDisappearing(viewHolder);
                    boolean bl2 = this.mViewInfoStore.isDisappearing((ViewHolder)object);
                    if (bl && viewHolder == object) {
                        this.mViewInfoStore.addToPostLayout((ViewHolder)object, itemHolderInfo);
                        continue;
                    }
                    ItemAnimator.ItemHolderInfo itemHolderInfo2 = this.mViewInfoStore.popFromPreLayout(viewHolder);
                    this.mViewInfoStore.addToPostLayout((ViewHolder)object, itemHolderInfo);
                    itemHolderInfo = this.mViewInfoStore.popFromPostLayout((ViewHolder)object);
                    if (itemHolderInfo2 == null) {
                        this.handleMissingPreInfoForChangeError(l, (ViewHolder)object, viewHolder);
                        continue;
                    }
                    this.animateChange(viewHolder, (ViewHolder)object, itemHolderInfo2, itemHolderInfo, bl, bl2);
                    continue;
                }
                this.mViewInfoStore.addToPostLayout((ViewHolder)object, itemHolderInfo);
            }
            this.mViewInfoStore.process(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        object = this.mState;
        object.mPreviousLayoutItemCount = object.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.mRunSimpleAnimations = false;
        this.mState.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.mChangedScrap != null) {
            this.mRecycler.mChangedScrap.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            this.mLayout.mPrefetchMaxCountObserved = 0;
            this.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.updateViewCacheSize();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        object = this.mMinMaxLayoutPositions;
        if (this.didChildRangeChange((int)object[0], (int)object[1])) {
            this.dispatchOnScrolled(0, 0);
        }
        this.recoverFocusFromState();
        this.resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() != 0) return this.findInterceptingOnItemTouchListener(motionEvent);
            return false;
        }
        onItemTouchListener.onTouchEvent(this, motionEvent);
        int n = motionEvent.getAction();
        if (n != 3) {
            if (n != 1) return true;
        }
        this.mInterceptingOnItemTouchListener = null;
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int n = motionEvent.getAction();
        int n2 = this.mOnItemTouchListeners.size();
        int n3 = 0;
        while (n3 < n2) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(n3);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && n != 3) {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
            ++n3;
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] nArray) {
        int n = this.mChildHelper.getChildCount();
        if (n == 0) {
            nArray[0] = -1;
            nArray[1] = -1;
            return;
        }
        int n2 = Integer.MAX_VALUE;
        int n3 = Integer.MIN_VALUE;
        int n4 = 0;
        while (true) {
            int n5;
            if (n4 >= n) {
                nArray[0] = n2;
                nArray[1] = n3;
                return;
            }
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(n4));
            if (viewHolder.shouldIgnore()) {
                n5 = n3;
            } else {
                int n6 = viewHolder.getLayoutPosition();
                int n7 = n2;
                if (n6 < n2) {
                    n7 = n6;
                }
                n2 = n7;
                n5 = n3;
                if (n6 > n3) {
                    n5 = n6;
                    n2 = n7;
                }
            }
            ++n4;
            n3 = n5;
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView)view;
        }
        view = (ViewGroup)view;
        int n = view.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            RecyclerView recyclerView = RecyclerView.findNestedRecyclerView(view.getChildAt(n2));
            if (recyclerView != null) {
                return recyclerView;
            }
            ++n2;
        }
        return null;
    }

    private View findNextViewToFocus() {
        ViewHolder viewHolder;
        int n = this.mState.mFocusedItemPosition != -1 ? this.mState.mFocusedItemPosition : 0;
        int n2 = this.mState.getItemCount();
        for (int i = n; i < n2 && (viewHolder = this.findViewHolderForAdapterPosition(i)) != null; ++i) {
            if (!viewHolder.itemView.hasFocusable()) continue;
            return viewHolder.itemView;
        }
        n = Math.min(n2, n) - 1;
        while (n >= 0) {
            viewHolder = this.findViewHolderForAdapterPosition(n);
            if (viewHolder == null) {
                return null;
            }
            if (viewHolder.itemView.hasFocusable()) {
                return viewHolder.itemView;
            }
            --n;
        }
        return null;
    }

    static ViewHolder getChildViewHolderInt(View view) {
        if (view != null) return ((LayoutParams)view.getLayoutParams()).mViewHolder;
        return null;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set(view.getLeft() - rect2.left - layoutParams.leftMargin, view.getTop() - rect2.top - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int n = view.getId();
        while (!view.isFocused()) {
            View view2;
            if (!(view instanceof ViewGroup)) return n;
            if (!view.hasFocus()) return n;
            view = view2 = ((ViewGroup)view).getFocusedChild();
            if (view2.getId() == -1) continue;
            n = view2.getId();
            view = view2;
        }
        return n;
    }

    private String getFullClassName(Context object, String string) {
        if (string.charAt(0) == '.') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(object.getPackageName());
            stringBuilder.append(string);
            return stringBuilder.toString();
        }
        if (string.contains(".")) {
            return string;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(RecyclerView.class.getPackage().getName());
        ((StringBuilder)object).append('.');
        ((StringBuilder)object).append(string);
        return ((StringBuilder)object).toString();
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) return this.mScrollingChildHelper;
        this.mScrollingChildHelper = new NestedScrollingChildHelper((View)this);
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long l, ViewHolder viewHolder, ViewHolder object) {
        int n = this.mChildHelper.getChildCount();
        int n2 = 0;
        while (true) {
            StringBuilder stringBuilder;
            if (n2 >= n) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
                stringBuilder.append(object);
                stringBuilder.append(" cannot be found but it is necessary for ");
                stringBuilder.append(viewHolder);
                stringBuilder.append(this.exceptionLabel());
                Log.e((String)"RecyclerView", (String)stringBuilder.toString());
                return;
            }
            stringBuilder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(n2));
            if (stringBuilder != viewHolder && this.getChangedHolderKey((ViewHolder)stringBuilder) == l) {
                object = this.mAdapter;
                if (object != null && object.hasStableIds()) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                    ((StringBuilder)object).append((Object)stringBuilder);
                    ((StringBuilder)object).append(" \n View Holder 2:");
                    ((StringBuilder)object).append(viewHolder);
                    ((StringBuilder)object).append(this.exceptionLabel());
                    throw new IllegalStateException(((StringBuilder)object).toString());
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                ((StringBuilder)object).append((Object)stringBuilder);
                ((StringBuilder)object).append(" \n View Holder 2:");
                ((StringBuilder)object).append(viewHolder);
                ((StringBuilder)object).append(this.exceptionLabel());
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            ++n2;
        }
    }

    private boolean hasUpdatedView() {
        int n = this.mChildHelper.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(n2));
            if (viewHolder != null && !viewHolder.shouldIgnore() && viewHolder.isUpdated()) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill((View)this) != 0) return;
        ViewCompat.setImportantForAutofill((View)this, (int)8);
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper((ChildHelper.Callback)new /* Unavailable Anonymous Inner Class!! */);
    }

    private boolean isPreferredNextFocus(View object, View view, int n) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = bl5;
        if (view == null) return bl7;
        bl7 = bl5;
        if (view == this) return bl7;
        if (view == object) {
            bl7 = bl5;
        } else {
            if (this.findContainingItemView(view) == null) {
                return false;
            }
            if (object == null) {
                return true;
            }
            if (this.findContainingItemView((View)object) == null) {
                return true;
            }
            this.mTempRect.set(0, 0, object.getWidth(), object.getHeight());
            this.mTempRect2.set(0, 0, view.getWidth(), view.getHeight());
            this.offsetDescendantRectToMyCoords((View)object, this.mTempRect);
            this.offsetDescendantRectToMyCoords(view, this.mTempRect2);
            int n2 = this.mLayout.getLayoutDirection();
            int n3 = -1;
            int n4 = n2 == 1 ? -1 : 1;
            n2 = (this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right ? 1 : ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left ? -1 : 0);
            if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
                n3 = 1;
            } else if (this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom || this.mTempRect.top <= this.mTempRect2.top) {
                n3 = 0;
            }
            if (n != 1) {
                if (n != 2) {
                    if (n == 17) {
                        bl7 = bl3;
                        if (n2 >= 0) return bl7;
                        bl7 = true;
                        return bl7;
                    }
                    if (n == 33) {
                        bl7 = bl2;
                        if (n3 >= 0) return bl7;
                        bl7 = true;
                        return bl7;
                    }
                    if (n == 66) {
                        bl7 = bl;
                        if (n2 <= 0) return bl7;
                        bl7 = true;
                        return bl7;
                    }
                    if (n == 130) {
                        bl7 = bl6;
                        if (n3 <= 0) return bl7;
                        bl7 = true;
                        return bl7;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Invalid direction: ");
                    ((StringBuilder)object).append(n);
                    ((StringBuilder)object).append(this.exceptionLabel());
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                if (n3 <= 0) {
                    bl7 = bl4;
                    if (n3 != 0) return bl7;
                    bl7 = bl4;
                    if (n2 * n4 <= 0) return bl7;
                }
                bl7 = true;
                return bl7;
            }
            if (n3 >= 0) {
                bl7 = bl5;
                if (n3 != 0) return bl7;
                bl7 = bl5;
                if (n2 * n4 >= 0) return bl7;
            }
            bl7 = true;
        }
        return bl7;
    }

    private void nestedScrollByInternal(int n, int n2, MotionEvent motionEvent, int n3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e((String)"RecyclerView", (String)"Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        int[] nArray = this.mReusableIntPair;
        int n4 = 0;
        nArray[0] = 0;
        nArray[1] = 0;
        boolean bl = layoutManager.canScrollHorizontally();
        boolean bl2 = this.mLayout.canScrollVertically();
        int n5 = bl ? 1 : 0;
        int n6 = n5;
        if (bl2) {
            n6 = n5 | 2;
        }
        this.startNestedScroll(n6, n3);
        int n7 = bl ? n : 0;
        int n8 = bl2 ? n2 : 0;
        n6 = n;
        n5 = n2;
        if (this.dispatchNestedPreScroll(n7, n8, this.mReusableIntPair, this.mScrollOffset, n3)) {
            nArray = this.mReusableIntPair;
            n6 = n - nArray[0];
            n5 = n2 - nArray[1];
        }
        n = bl ? n6 : 0;
        n2 = n4;
        if (bl2) {
            n2 = n5;
        }
        this.scrollByInternal(n, n2, motionEvent, n3);
        if (this.mGapWorker != null && (n6 != 0 || n5 != 0)) {
            this.mGapWorker.postFromTraversal(this, n6, n5);
        }
        this.stopNestedScroll(n3);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int n;
        int n2 = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(n2) != this.mScrollPointerId) return;
        n2 = n2 == 0 ? 1 : 0;
        this.mScrollPointerId = motionEvent.getPointerId(n2);
        this.mLastTouchX = n = (int)(motionEvent.getX(n2) + 0.5f);
        this.mInitialTouchX = n;
        this.mLastTouchY = n2 = (int)(motionEvent.getY(n2) + 0.5f);
        this.mInitialTouchY = n2;
    }

    private boolean predictiveItemAnimationsEnabled() {
        boolean bl = this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
        return bl;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (this.predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        boolean bl = this.mItemsAddedOrRemoved;
        boolean bl2 = false;
        boolean bl3 = bl || this.mItemsChanged;
        State state = this.mState;
        bl = !(!this.mFirstLayoutComplete || this.mItemAnimator == null || !this.mDataSetHasChangedAfterLayout && !bl3 && !this.mLayout.mRequestedSimpleAnimations || this.mDataSetHasChangedAfterLayout && !this.mAdapter.hasStableIds());
        state.mRunSimpleAnimations = bl;
        state = this.mState;
        bl = bl2;
        if (state.mRunSimpleAnimations) {
            bl = bl2;
            if (bl3) {
                bl = bl2;
                if (!this.mDataSetHasChangedAfterLayout) {
                    bl = bl2;
                    if (this.predictiveItemAnimationsEnabled()) {
                        bl = true;
                    }
                }
            }
        }
        state.mRunPredictiveAnimations = bl;
    }

    /*
     * Unable to fully structure code
     */
    private void pullGlows(float var1_1, float var2_2, float var3_3, float var4_4) {
        block6: {
            var6_5 = true;
            if (!(var2_2 < 0.0f)) break block6;
            this.ensureLeftGlow();
            EdgeEffectCompat.onPull((EdgeEffect)this.mLeftGlow, (float)(-var2_2 / (float)this.getWidth()), (float)(1.0f - var3_3 / (float)this.getHeight()));
            ** GOTO lbl10
        }
        if (var2_2 > 0.0f) {
            this.ensureRightGlow();
            EdgeEffectCompat.onPull((EdgeEffect)this.mRightGlow, (float)(var2_2 / (float)this.getWidth()), (float)(var3_3 / (float)this.getHeight()));
lbl10:
            // 2 sources

            var5_6 = true;
        } else {
            var5_6 = false;
        }
        if (var4_4 < 0.0f) {
            this.ensureTopGlow();
            EdgeEffectCompat.onPull((EdgeEffect)this.mTopGlow, (float)(-var4_4 / (float)this.getHeight()), (float)(var1_1 / (float)this.getWidth()));
            var5_6 = var6_5;
        } else if (var4_4 > 0.0f) {
            this.ensureBottomGlow();
            EdgeEffectCompat.onPull((EdgeEffect)this.mBottomGlow, (float)(var4_4 / (float)this.getHeight()), (float)(1.0f - var1_1 / (float)this.getWidth()));
            var5_6 = var6_5;
        }
        if (!var5_6 && var2_2 == 0.0f) {
            if (var4_4 == 0.0f) return;
        }
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    private void recoverFocusFromState() {
        Object object;
        if (!this.mPreserveFocusAfterLayout) return;
        if (this.mAdapter == null) return;
        if (!this.hasFocus()) return;
        if (this.getDescendantFocusability() == 393216) return;
        if (this.getDescendantFocusability() == 131072 && this.isFocused()) return;
        if (!this.isFocused()) {
            object = this.getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (object.getParent() == null || !object.hasFocus())) {
                if (this.mChildHelper.getChildCount() == 0) {
                    this.requestFocus();
                    return;
                }
            } else if (!this.mChildHelper.isHidden(object)) {
                return;
            }
        }
        long l = this.mState.mFocusedItemId;
        View view = null;
        object = l != -1L && this.mAdapter.hasStableIds() ? this.findViewHolderForItemId(this.mState.mFocusedItemId) : null;
        if (object != null && !this.mChildHelper.isHidden(object.itemView) && object.itemView.hasFocusable()) {
            object = object.itemView;
        } else {
            object = view;
            if (this.mChildHelper.getChildCount() > 0) {
                object = this.findNextViewToFocus();
            }
        }
        if (object == null) return;
        view = object;
        if ((long)this.mState.mFocusedSubChildId != -1L) {
            View view2 = object.findViewById(this.mState.mFocusedSubChildId);
            view = object;
            if (view2 != null) {
                view = object;
                if (view2.isFocusable()) {
                    view = view2;
                }
            }
        }
        view.requestFocus();
    }

    private void releaseGlows() {
        boolean bl;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            bl = this.mLeftGlow.isFinished();
        } else {
            bl = false;
        }
        edgeEffect = this.mTopGlow;
        boolean bl2 = bl;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            bl2 = bl | this.mTopGlow.isFinished();
        }
        edgeEffect = this.mRightGlow;
        bl = bl2;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            bl = bl2 | this.mRightGlow.isFinished();
        }
        edgeEffect = this.mBottomGlow;
        bl2 = bl;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            bl2 = bl | this.mBottomGlow.isFinished();
        }
        if (!bl2) return;
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    private void requestChildOnScreen(View view, View view2) {
        Rect rect;
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        view3 = view3.getLayoutParams();
        if (view3 instanceof LayoutParams) {
            view3 = (LayoutParams)view3;
            if (!view3.mInsetsDirty) {
                view3 = view3.mDecorInsets;
                rect = this.mTempRect;
                rect.left -= view3.left;
                rect = this.mTempRect;
                rect.right += view3.right;
                rect = this.mTempRect;
                rect.top -= view3.top;
                rect = this.mTempRect;
                rect.bottom += view3.bottom;
            }
        }
        if (view2 != null) {
            this.offsetDescendantRectToMyCoords(view2, this.mTempRect);
            this.offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        view3 = this.mLayout;
        rect = this.mTempRect;
        boolean bl = this.mFirstLayoutComplete;
        boolean bl2 = view2 == null;
        view3.requestChildRectangleOnScreen(this, view, rect, bl ^ true, bl2);
    }

    private void resetFocusInfo() {
        this.mState.mFocusedItemId = -1L;
        this.mState.mFocusedItemPosition = -1;
        this.mState.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        this.stopNestedScroll(0);
        this.releaseGlows();
    }

    private void saveFocusInfo() {
        boolean bl = this.mPreserveFocusAfterLayout;
        ViewHolder viewHolder = null;
        Object object = bl && this.hasFocus() && this.mAdapter != null ? this.getFocusedChild() : null;
        if ((object = object == null ? viewHolder : this.findContainingViewHolder((View)object)) == null) {
            this.resetFocusInfo();
        } else {
            viewHolder = this.mState;
            long l = this.mAdapter.hasStableIds() ? object.getItemId() : -1L;
            viewHolder.mFocusedItemId = l;
            viewHolder = this.mState;
            int n = this.mDataSetHasChangedAfterLayout ? -1 : (object.isRemoved() ? object.mOldPosition : object.getAbsoluteAdapterPosition());
            viewHolder.mFocusedItemPosition = n;
            this.mState.mFocusedSubChildId = this.getDeepestFocusedViewWithId(object.itemView);
        }
    }

    private void setAdapterInternal(Adapter adapter, boolean bl, boolean bl2) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver((AdapterDataObserver)this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!bl || bl2) {
            this.removeAndRecycleViews();
        }
        this.mAdapterHelper.reset();
        adapter2 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver((AdapterDataObserver)this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        if ((adapter = this.mLayout) != null) {
            adapter.onAdapterChanged(adapter2, this.mAdapter);
        }
        this.mRecycler.onAdapterChanged(adapter2, this.mAdapter, bl);
        this.mState.mStructureChanged = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) return;
        layoutManager.stopSmoothScroller();
    }

    void absorbGlows(int n, int n2) {
        if (n < 0) {
            this.ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-n);
            }
        } else if (n > 0) {
            this.ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(n);
            }
        }
        if (n2 < 0) {
            this.ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-n2);
            }
        } else if (n2 > 0) {
            this.ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(n2);
            }
        }
        if (n == 0) {
            if (n2 == 0) return;
        }
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    public void addFocusables(ArrayList<View> arrayList, int n, int n2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            if (layoutManager.onAddFocusables(this, arrayList, n, n2)) return;
        }
        super.addFocusables(arrayList, n, n2);
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        this.addItemDecoration(itemDecoration, -1);
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int n) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            this.setWillNotDraw(false);
        }
        if (n < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(n, itemDecoration);
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList<OnChildAttachStateChangeListener>();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList<OnScrollListener>();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void addRecyclerListener(RecyclerListener recyclerListener) {
        boolean bl = recyclerListener != null;
        Preconditions.checkArgument((boolean)bl, (Object)"'listener' arg cannot be null.");
        this.mRecyclerListeners.add(recyclerListener);
    }

    void animateAppearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (!this.mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) return;
        this.postAnimationRunner();
    }

    void animateDisappearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        this.addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (!this.mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) return;
        this.postAnimationRunner();
    }

    void assertInLayoutOrScroll(String charSequence) {
        if (this.isComputingLayout()) return;
        if (charSequence == null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            ((StringBuilder)charSequence).append(this.exceptionLabel());
            throw new IllegalStateException(((StringBuilder)charSequence).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append(this.exceptionLabel());
        throw new IllegalStateException(stringBuilder.toString());
    }

    void assertNotInLayoutOrScroll(String charSequence) {
        if (this.isComputingLayout()) {
            if (charSequence != null) throw new IllegalStateException((String)charSequence);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Cannot call this method while RecyclerView is computing a layout or scrolling");
            ((StringBuilder)charSequence).append(this.exceptionLabel());
            throw new IllegalStateException(((StringBuilder)charSequence).toString());
        }
        if (this.mDispatchScrollCounter <= 0) return;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("");
        ((StringBuilder)charSequence).append(this.exceptionLabel());
        Log.w((String)"RecyclerView", (String)"Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", (Throwable)new IllegalStateException(((StringBuilder)charSequence).toString()));
    }

    boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        boolean bl = itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads());
        return bl;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = layoutParams instanceof LayoutParams && this.mLayout.checkLayoutParams((LayoutParams)layoutParams);
        return bl;
    }

    void clearOldPositions() {
        int n = this.mChildHelper.getUnfilteredChildCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mRecycler.clearOldPositions();
                return;
            }
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n2));
            if (!viewHolder.shouldIgnore()) {
                viewHolder.clearOldPosition();
            }
            ++n2;
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list == null) return;
        list.clear();
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list == null) return;
        list.clear();
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        int n = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (!layoutManager.canScrollHorizontally()) return n;
        n = this.mLayout.computeHorizontalScrollExtent(this.mState);
        return n;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        int n = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (!layoutManager.canScrollHorizontally()) return n;
        n = this.mLayout.computeHorizontalScrollOffset(this.mState);
        return n;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        int n = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (!layoutManager.canScrollHorizontally()) return n;
        n = this.mLayout.computeHorizontalScrollRange(this.mState);
        return n;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        int n = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (!layoutManager.canScrollVertically()) return n;
        n = this.mLayout.computeVerticalScrollExtent(this.mState);
        return n;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        int n = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (!layoutManager.canScrollVertically()) return n;
        n = this.mLayout.computeVerticalScrollOffset(this.mState);
        return n;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        int n = 0;
        if (layoutManager == null) {
            return 0;
        }
        if (!layoutManager.canScrollVertically()) return n;
        n = this.mLayout.computeVerticalScrollRange(this.mState);
        return n;
    }

    void considerReleasingGlowsOnScroll(int n, int n2) {
        boolean bl;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null && !edgeEffect.isFinished() && n > 0) {
            this.mLeftGlow.onRelease();
            bl = this.mLeftGlow.isFinished();
        } else {
            bl = false;
        }
        edgeEffect = this.mRightGlow;
        boolean bl2 = bl;
        if (edgeEffect != null) {
            bl2 = bl;
            if (!edgeEffect.isFinished()) {
                bl2 = bl;
                if (n < 0) {
                    this.mRightGlow.onRelease();
                    bl2 = bl | this.mRightGlow.isFinished();
                }
            }
        }
        edgeEffect = this.mTopGlow;
        bl = bl2;
        if (edgeEffect != null) {
            bl = bl2;
            if (!edgeEffect.isFinished()) {
                bl = bl2;
                if (n2 > 0) {
                    this.mTopGlow.onRelease();
                    bl = bl2 | this.mTopGlow.isFinished();
                }
            }
        }
        edgeEffect = this.mBottomGlow;
        bl2 = bl;
        if (edgeEffect != null) {
            bl2 = bl;
            if (!edgeEffect.isFinished()) {
                bl2 = bl;
                if (n2 < 0) {
                    this.mBottomGlow.onRelease();
                    bl2 = bl | this.mBottomGlow.isFinished();
                }
            }
        }
        if (!bl2) return;
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
            if (!this.mAdapterHelper.hasPendingUpdates()) {
                return;
            }
            if (this.mAdapterHelper.hasAnyUpdateTypes(4) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
                TraceCompat.beginSection((String)"RV PartialInvalidate");
                this.startInterceptRequestLayout();
                this.onEnterLayoutOrScroll();
                this.mAdapterHelper.preProcess();
                if (!this.mLayoutWasDefered) {
                    if (this.hasUpdatedView()) {
                        this.dispatchLayout();
                    } else {
                        this.mAdapterHelper.consumePostponedUpdates();
                    }
                }
                this.stopInterceptRequestLayout(true);
                this.onExitLayoutOrScroll();
                TraceCompat.endSection();
            } else {
                if (!this.mAdapterHelper.hasPendingUpdates()) return;
                TraceCompat.beginSection((String)"RV FullInvalidate");
                this.dispatchLayout();
                TraceCompat.endSection();
            }
            return;
        }
        TraceCompat.beginSection((String)"RV FullInvalidate");
        this.dispatchLayout();
        TraceCompat.endSection();
    }

    void defaultOnMeasure(int n, int n2) {
        this.setMeasuredDimension(LayoutManager.chooseSize((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)ViewCompat.getMinimumWidth((View)this)), LayoutManager.chooseSize((int)n2, (int)(this.getPaddingTop() + this.getPaddingBottom()), (int)ViewCompat.getMinimumHeight((View)this)));
    }

    void dispatchChildAttached(View view) {
        ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(view);
        this.onChildAttachedToWindow(view);
        Object object = this.mAdapter;
        if (object != null && viewHolder != null) {
            object.onViewAttachedToWindow(viewHolder);
        }
        if ((object = this.mOnChildAttachStateListeners) == null) return;
        int n = object.size() - 1;
        while (n >= 0) {
            this.mOnChildAttachStateListeners.get(n).onChildViewAttachedToWindow(view);
            --n;
        }
    }

    void dispatchChildDetached(View view) {
        Object object = RecyclerView.getChildViewHolderInt(view);
        this.onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && object != null) {
            adapter.onViewDetachedFromWindow((ViewHolder)object);
        }
        if ((object = this.mOnChildAttachStateListeners) == null) return;
        int n = object.size() - 1;
        while (n >= 0) {
            this.mOnChildAttachStateListeners.get(n).onChildViewDetachedFromWindow(view);
            --n;
        }
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w((String)"RecyclerView", (String)"No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e((String)"RecyclerView", (String)"No layout manager attached; skipping layout");
            return;
        }
        this.mState.mIsMeasuring = false;
        boolean bl = this.mLastAutoMeasureSkippedDueToExact && (this.mLastAutoMeasureNonExactMeasuredWidth != this.getWidth() || this.mLastAutoMeasureNonExactMeasuredHeight != this.getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.mLayoutStep == 1) {
            this.dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
        } else if (!this.mAdapterHelper.hasUpdates() && !bl && this.mLayout.getWidth() == this.getWidth() && this.mLayout.getHeight() == this.getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
        }
        this.dispatchLayoutStep3();
    }

    public boolean dispatchNestedFling(float f, float f2, boolean bl) {
        return this.getScrollingChildHelper().dispatchNestedFling(f, f2, bl);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2) {
        return this.getScrollingChildHelper().dispatchNestedPreScroll(n, n2, nArray, nArray2);
    }

    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2, int n3) {
        return this.getScrollingChildHelper().dispatchNestedPreScroll(n, n2, nArray, nArray2, n3);
    }

    public final void dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5, int[] nArray2) {
        this.getScrollingChildHelper().dispatchNestedScroll(n, n2, n3, n4, nArray, n5, nArray2);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray) {
        return this.getScrollingChildHelper().dispatchNestedScroll(n, n2, n3, n4, nArray);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5) {
        return this.getScrollingChildHelper().dispatchNestedScroll(n, n2, n3, n4, nArray, n5);
    }

    void dispatchOnScrollStateChanged(int n) {
        Object object = this.mLayout;
        if (object != null) {
            object.onScrollStateChanged(n);
        }
        this.onScrollStateChanged(n);
        object = this.mScrollListener;
        if (object != null) {
            object.onScrollStateChanged(this, n);
        }
        if ((object = this.mScrollListeners) == null) return;
        int n2 = object.size() - 1;
        while (n2 >= 0) {
            this.mScrollListeners.get(n2).onScrollStateChanged(this, n);
            --n2;
        }
    }

    void dispatchOnScrolled(int n, int n2) {
        ++this.mDispatchScrollCounter;
        int n3 = this.getScrollX();
        int n4 = this.getScrollY();
        this.onScrollChanged(n3, n4, n3 - n, n4 - n2);
        this.onScrolled(n, n2);
        Object object = this.mScrollListener;
        if (object != null) {
            object.onScrolled(this, n, n2);
        }
        if ((object = this.mScrollListeners) != null) {
            for (n4 = object.size() - 1; n4 >= 0; --n4) {
                this.mScrollListeners.get(n4).onScrolled(this, n, n2);
            }
        }
        --this.mDispatchScrollCounter;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int n = this.mPendingAccessibilityImportanceChange.size() - 1;
        while (true) {
            int n2;
            if (n < 0) {
                this.mPendingAccessibilityImportanceChange.clear();
                return;
            }
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(n);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (n2 = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.setImportantForAccessibility((View)viewHolder.itemView, (int)n2);
                viewHolder.mPendingAccessibilityState = -1;
            }
            --n;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        this.dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int n;
        int n2;
        super.draw(canvas);
        int n3 = this.mItemDecorations.size();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            this.mItemDecorations.get(n2).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        int n5 = 1;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            n = canvas.save();
            n2 = this.mClipToPadding ? this.getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float)(-this.getHeight() + n2), 0.0f);
            edgeEffect = this.mLeftGlow;
            n3 = edgeEffect != null && edgeEffect.draw(canvas) ? 1 : 0;
            canvas.restoreToCount(n);
        } else {
            n3 = 0;
        }
        edgeEffect = this.mTopGlow;
        n2 = n3;
        if (edgeEffect != null) {
            n2 = n3;
            if (!edgeEffect.isFinished()) {
                n = canvas.save();
                if (this.mClipToPadding) {
                    canvas.translate((float)this.getPaddingLeft(), (float)this.getPaddingTop());
                }
                n2 = (edgeEffect = this.mTopGlow) != null && edgeEffect.draw(canvas) ? 1 : 0;
                n2 = n3 | n2;
                canvas.restoreToCount(n);
            }
        }
        edgeEffect = this.mRightGlow;
        n3 = n2;
        if (edgeEffect != null) {
            n3 = n2;
            if (!edgeEffect.isFinished()) {
                n = canvas.save();
                int n6 = this.getWidth();
                n3 = this.mClipToPadding ? this.getPaddingTop() : 0;
                canvas.rotate(90.0f);
                canvas.translate((float)n3, (float)(-n6));
                edgeEffect = this.mRightGlow;
                n3 = edgeEffect != null && edgeEffect.draw(canvas) ? 1 : 0;
                n3 = n2 | n3;
                canvas.restoreToCount(n);
            }
        }
        edgeEffect = this.mBottomGlow;
        n2 = n3;
        if (edgeEffect != null) {
            n2 = n3;
            if (!edgeEffect.isFinished()) {
                n = canvas.save();
                canvas.rotate(180.0f);
                if (this.mClipToPadding) {
                    canvas.translate((float)(-this.getWidth() + this.getPaddingRight()), (float)(-this.getHeight() + this.getPaddingBottom()));
                } else {
                    canvas.translate((float)(-this.getWidth()), (float)(-this.getHeight()));
                }
                edgeEffect = this.mBottomGlow;
                n2 = n4;
                if (edgeEffect != null) {
                    n2 = n4;
                    if (edgeEffect.draw(canvas)) {
                        n2 = 1;
                    }
                }
                n2 = n3 | n2;
                canvas.restoreToCount(n);
            }
        }
        if (n2 == 0 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.isRunning()) {
            n2 = n5;
        }
        if (n2 == 0) return;
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    public boolean drawChild(Canvas canvas, View view, long l) {
        return super.drawChild(canvas, view, l);
    }

    void ensureBottomGlow() {
        EdgeEffect edgeEffect;
        if (this.mBottomGlow != null) {
            return;
        }
        this.mBottomGlow = edgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
        if (this.mClipToPadding) {
            edgeEffect.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
        } else {
            edgeEffect.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
        }
    }

    void ensureLeftGlow() {
        EdgeEffect edgeEffect;
        if (this.mLeftGlow != null) {
            return;
        }
        this.mLeftGlow = edgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
        if (this.mClipToPadding) {
            edgeEffect.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
        } else {
            edgeEffect.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        EdgeEffect edgeEffect;
        if (this.mRightGlow != null) {
            return;
        }
        this.mRightGlow = edgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
        if (this.mClipToPadding) {
            edgeEffect.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
        } else {
            edgeEffect.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        EdgeEffect edgeEffect;
        if (this.mTopGlow != null) {
            return;
        }
        this.mTopGlow = edgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
        if (this.mClipToPadding) {
            edgeEffect.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
        } else {
            edgeEffect.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
        }
    }

    String exceptionLabel() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
        stringBuilder.append(super.toString());
        stringBuilder.append(", adapter:");
        stringBuilder.append(this.mAdapter);
        stringBuilder.append(", layout:");
        stringBuilder.append(this.mLayout);
        stringBuilder.append(", context:");
        stringBuilder.append(this.getContext());
        return stringBuilder.toString();
    }

    final void fillRemainingScrollValues(State state) {
        if (this.getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            state.mRemainingScrollHorizontal = overScroller.getFinalX() - overScroller.getCurrX();
            state.mRemainingScrollVertical = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            state.mRemainingScrollHorizontal = 0;
            state.mRemainingScrollVertical = 0;
        }
    }

    public View findChildViewUnder(float f, float f2) {
        int n = this.mChildHelper.getChildCount() - 1;
        while (n >= 0) {
            View view = this.mChildHelper.getChildAt(n);
            float f3 = view.getTranslationX();
            float f4 = view.getTranslationY();
            if (f >= (float)view.getLeft() + f3 && f <= (float)view.getRight() + f3 && f2 >= (float)view.getTop() + f4 && f2 <= (float)view.getBottom() + f4) {
                return view;
            }
            --n;
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent viewParent = view.getParent();
        while (viewParent != null && viewParent != this && viewParent instanceof View) {
            view = (View)viewParent;
            viewParent = view.getParent();
        }
        if (viewParent == this) return view;
        view = null;
        return view;
    }

    public ViewHolder findContainingViewHolder(View object) {
        object = (object = this.findContainingItemView((View)object)) == null ? null : this.getChildViewHolder((View)object);
        return object;
    }

    public ViewHolder findViewHolderForAdapterPosition(int n) {
        boolean bl = this.mDataSetHasChangedAfterLayout;
        ViewHolder viewHolder = null;
        if (bl) {
            return null;
        }
        int n2 = this.mChildHelper.getUnfilteredChildCount();
        int n3 = 0;
        while (n3 < n2) {
            ViewHolder viewHolder2 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n3));
            ViewHolder viewHolder3 = viewHolder;
            if (viewHolder2 != null) {
                viewHolder3 = viewHolder;
                if (!viewHolder2.isRemoved()) {
                    viewHolder3 = viewHolder;
                    if (this.getAdapterPositionInRecyclerView(viewHolder2) == n) {
                        if (!this.mChildHelper.isHidden(viewHolder2.itemView)) return viewHolder2;
                        viewHolder3 = viewHolder2;
                    }
                }
            }
            ++n3;
            viewHolder = viewHolder3;
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long l) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        ViewHolder viewHolder2 = null;
        ViewHolder viewHolder3 = viewHolder;
        if (adapter == null) return viewHolder3;
        if (!adapter.hasStableIds()) {
            viewHolder3 = viewHolder;
            return viewHolder3;
        }
        int n = this.mChildHelper.getUnfilteredChildCount();
        int n2 = 0;
        viewHolder = viewHolder2;
        while (true) {
            viewHolder3 = viewHolder;
            if (n2 >= n) return viewHolder3;
            viewHolder2 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n2));
            viewHolder3 = viewHolder;
            if (viewHolder2 != null) {
                viewHolder3 = viewHolder;
                if (!viewHolder2.isRemoved()) {
                    viewHolder3 = viewHolder;
                    if (viewHolder2.getItemId() == l) {
                        if (!this.mChildHelper.isHidden(viewHolder2.itemView)) return viewHolder2;
                        viewHolder3 = viewHolder2;
                    }
                }
            }
            ++n2;
            viewHolder = viewHolder3;
        }
    }

    public ViewHolder findViewHolderForLayoutPosition(int n) {
        return this.findViewHolderForPosition(n, false);
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int n) {
        return this.findViewHolderForPosition(n, false);
    }

    /*
     * Unable to fully structure code
     */
    ViewHolder findViewHolderForPosition(int var1_1, boolean var2_2) {
        var4_3 = this.mChildHelper.getUnfilteredChildCount();
        var6_4 = null;
        var3_5 = 0;
        while (var3_5 < var4_3) {
            block3: {
                block4: {
                    var7_7 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var3_5));
                    var5_6 = var6_4;
                    if (var7_7 == null) break block3;
                    var5_6 = var6_4;
                    if (var7_7.isRemoved()) break block3;
                    if (!var2_2) break block4;
                    if (var7_7.mPosition == var1_1) ** GOTO lbl-1000
                    var5_6 = var6_4;
                    break block3;
                }
                if (var7_7.getLayoutPosition() != var1_1) {
                    var5_6 = var6_4;
                } else lbl-1000:
                // 2 sources

                {
                    if (this.mChildHelper.isHidden(var7_7.itemView) == false) return var7_7;
                    var5_6 = var7_7;
                }
            }
            ++var3_5;
            var6_4 = var5_6;
        }
        return var6_4;
    }

    public boolean fling(int n, int n2) {
        int n3;
        int n4;
        boolean bl;
        boolean bl2;
        int n5;
        LayoutManager layoutManager;
        block15: {
            block14: {
                block13: {
                    block12: {
                        layoutManager = this.mLayout;
                        n5 = 0;
                        if (layoutManager == null) {
                            Log.e((String)"RecyclerView", (String)"Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                            return false;
                        }
                        if (this.mLayoutSuppressed) {
                            return false;
                        }
                        bl2 = layoutManager.canScrollHorizontally();
                        bl = this.mLayout.canScrollVertically();
                        if (!bl2) break block12;
                        n4 = n;
                        if (Math.abs(n) >= this.mMinFlingVelocity) break block13;
                    }
                    n4 = 0;
                }
                if (!bl) break block14;
                n3 = n2;
                if (Math.abs(n2) >= this.mMinFlingVelocity) break block15;
            }
            n3 = 0;
        }
        if (n4 == 0 && n3 == 0) {
            return false;
        }
        float f = n4;
        float f2 = n3;
        if (this.dispatchNestedPreFling(f, f2)) return false;
        boolean bl3 = bl2 || bl;
        this.dispatchNestedFling(f, f2, bl3);
        layoutManager = this.mOnFlingListener;
        if (layoutManager != null && layoutManager.onFling(n4, n3)) {
            return true;
        }
        if (!bl3) return false;
        n = n5;
        if (bl2) {
            n = 1;
        }
        n2 = n;
        if (bl) {
            n2 = n | 2;
        }
        this.startNestedScroll(n2, 1);
        n = this.mMaxFlingVelocity;
        n = Math.max(-n, Math.min(n4, n));
        n2 = this.mMaxFlingVelocity;
        n2 = Math.max(-n2, Math.min(n3, n2));
        this.mViewFlinger.fling(n, n2);
        return true;
    }

    public View focusSearch(View view, int n) {
        View view2 = this.mLayout.onInterceptFocusSearch(view, n);
        if (view2 != null) {
            return view2;
        }
        view2 = this.mAdapter;
        int n2 = 1;
        int n3 = view2 != null && this.mLayout != null && !this.isComputingLayout() && !this.mLayoutSuppressed ? 1 : 0;
        view2 = FocusFinder.getInstance();
        if (n3 != 0 && (n == 2 || n == 1)) {
            int n4;
            int n5;
            if (this.mLayout.canScrollVertically()) {
                n5 = n == 2 ? 130 : 33;
                n4 = view2.findNextFocus((ViewGroup)this, view, n5) == null ? 1 : 0;
                n3 = n4;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    n = n5;
                    n3 = n4;
                }
            } else {
                n3 = 0;
            }
            n4 = n3;
            n5 = n;
            if (n3 == 0) {
                n4 = n3;
                n5 = n;
                if (this.mLayout.canScrollHorizontally()) {
                    n3 = this.mLayout.getLayoutDirection() == 1 ? 1 : 0;
                    n5 = n == 2 ? 1 : 0;
                    n3 = (n3 ^ n5) != 0 ? 66 : 17;
                    n5 = view2.findNextFocus((ViewGroup)this, view, n3) == null ? n2 : 0;
                    if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                        n = n3;
                    }
                    n4 = n5;
                    n5 = n;
                }
            }
            if (n4 != 0) {
                this.consumePendingUpdateOperations();
                if (this.findContainingItemView(view) == null) {
                    return null;
                }
                this.startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, n5, this.mRecycler, this.mState);
                this.stopInterceptRequestLayout(false);
            }
            view2 = view2.findNextFocus((ViewGroup)this, view, n5);
            n = n5;
        } else if ((view2 = view2.findNextFocus((ViewGroup)this, view, n)) == null && n3 != 0) {
            this.consumePendingUpdateOperations();
            if (this.findContainingItemView(view) == null) {
                return null;
            }
            this.startInterceptRequestLayout();
            view2 = this.mLayout.onFocusSearchFailed(view, n, this.mRecycler, this.mState);
            this.stopInterceptRequestLayout(false);
        }
        if (view2 != null && !view2.hasFocusable()) {
            if (this.getFocusedChild() == null) {
                return super.focusSearch(view, n);
            }
            this.requestChildOnScreen(view2, null);
            return view;
        }
        if (this.isPreferredNextFocus(view, view2, n)) return view2;
        view2 = super.focusSearch(view, n);
        return view2;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        Object object = this.mLayout;
        if (object != null) {
            return object.generateDefaultLayoutParams();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("RecyclerView has no LayoutManager");
        ((StringBuilder)object).append(this.exceptionLabel());
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet object) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(this.getContext(), (AttributeSet)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("RecyclerView has no LayoutManager");
        ((StringBuilder)object).append(this.exceptionLabel());
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams object) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams((ViewGroup.LayoutParams)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("RecyclerView has no LayoutManager");
        ((StringBuilder)object).append(this.exceptionLabel());
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524)) return -1;
        if (viewHolder.isBound()) return this.mAdapterHelper.applyPendingUpdatesToPosition(viewHolder.mPosition);
        return -1;
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) return super.getBaseline();
        return layoutManager.getBaseline();
    }

    long getChangedHolderKey(ViewHolder viewHolder) {
        long l = this.mAdapter.hasStableIds() ? viewHolder.getItemId() : (long)viewHolder.mPosition;
        return l;
    }

    public int getChildAdapterPosition(View view) {
        int n = (view = RecyclerView.getChildViewHolderInt(view)) != null ? view.getAbsoluteAdapterPosition() : -1;
        return n;
    }

    protected int getChildDrawingOrder(int n, int n2) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (childDrawingOrderCallback != null) return childDrawingOrderCallback.onGetChildDrawingOrder(n, n2);
        return super.getChildDrawingOrder(n, n2);
    }

    public long getChildItemId(View view) {
        long l;
        Adapter adapter = this.mAdapter;
        long l2 = l = -1L;
        if (adapter == null) return l2;
        if (!adapter.hasStableIds()) {
            l2 = l;
        } else {
            view = RecyclerView.getChildViewHolderInt(view);
            l2 = l;
            if (view == null) return l2;
            l2 = view.getItemId();
        }
        return l2;
    }

    public int getChildLayoutPosition(View view) {
        int n = (view = RecyclerView.getChildViewHolderInt(view)) != null ? view.getLayoutPosition() : -1;
        return n;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return this.getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view) {
        Object object = view.getParent();
        if (object == null) return RecyclerView.getChildViewHolderInt(view);
        if (object == this) {
            return RecyclerView.getChildViewHolderInt(view);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("View ");
        ((StringBuilder)object).append(view);
        ((StringBuilder)object).append(" is not a direct child of ");
        ((StringBuilder)object).append((Object)this);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.isPreLayout()) {
            if (layoutParams.isItemChanged()) return layoutParams.mDecorInsets;
            if (layoutParams.isViewInvalid()) {
                return layoutParams.mDecorInsets;
            }
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int n = this.mItemDecorations.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                layoutParams.mInsetsDirty = false;
                return rect;
            }
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(n2).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
            ++n2;
        }
    }

    public ItemDecoration getItemDecorationAt(int n) {
        int n2 = this.getItemDecorationCount();
        if (n >= 0 && n < n2) {
            return this.mItemDecorations.get(n);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        stringBuilder.append(" is an invalid index for size ");
        stringBuilder.append(n2);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    long getNanoTime() {
        if (!ALLOW_THREAD_GAP_WORK) return 0L;
        return System.nanoTime();
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return this.getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasNestedScrollingParent(int n) {
        return this.getScrollingChildHelper().hasNestedScrollingParent(n);
    }

    public boolean hasPendingAdapterUpdates() {
        boolean bl = !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates();
        return bl;
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper((AdapterHelper.Callback)new /* Unavailable Anonymous Inner Class!! */);
    }

    void initFastScroller(StateListDrawable object, Drawable drawable, StateListDrawable stateListDrawable, Drawable drawable2) {
        if (object != null && drawable != null && stateListDrawable != null && drawable2 != null) {
            Resources resources = this.getContext().getResources();
            new FastScroller(this, (StateListDrawable)object, drawable, stateListDrawable, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Trying to set fast scroller without both required drawables.");
        ((StringBuilder)object).append(this.exceptionLabel());
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        boolean bl = accessibilityManager != null && accessibilityManager.isEnabled();
        return bl;
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        boolean bl = itemAnimator != null && itemAnimator.isRunning();
        return bl;
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        boolean bl = this.mLayoutOrScrollCounter > 0;
        return bl;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return this.isLayoutSuppressed();
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public boolean isNestedScrollingEnabled() {
        return this.getScrollingChildHelper().isNestedScrollingEnabled();
    }

    void jumpToPositionForSmoothScroller(int n) {
        if (this.mLayout == null) {
            return;
        }
        this.setScrollState(2);
        this.mLayout.scrollToPosition(n);
        this.awakenScrollBars();
    }

    void markItemDecorInsetsDirty() {
        int n = this.mChildHelper.getUnfilteredChildCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mRecycler.markItemDecorInsetsDirty();
                return;
            }
            ((LayoutParams)this.mChildHelper.getUnfilteredChildAt((int)n2).getLayoutParams()).mInsetsDirty = true;
            ++n2;
        }
    }

    void markKnownViewsInvalid() {
        int n = this.mChildHelper.getUnfilteredChildCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.markItemDecorInsetsDirty();
                this.mRecycler.markKnownViewsInvalid();
                return;
            }
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n2));
            if (viewHolder != null && !viewHolder.shouldIgnore()) {
                viewHolder.addFlags(6);
            }
            ++n2;
        }
    }

    public void nestedScrollBy(int n, int n2) {
        this.nestedScrollByInternal(n, n2, null, 1);
    }

    public void offsetChildrenHorizontal(int n) {
        int n2 = this.mChildHelper.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            this.mChildHelper.getChildAt(n3).offsetLeftAndRight(n);
            ++n3;
        }
    }

    public void offsetChildrenVertical(int n) {
        int n2 = this.mChildHelper.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            this.mChildHelper.getChildAt(n3).offsetTopAndBottom(n);
            ++n3;
        }
    }

    void offsetPositionRecordsForInsert(int n, int n2) {
        int n3 = this.mChildHelper.getUnfilteredChildCount();
        int n4 = 0;
        while (true) {
            if (n4 >= n3) {
                this.mRecycler.offsetPositionRecordsForInsert(n, n2);
                this.requestLayout();
                return;
            }
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n4));
            if (viewHolder != null && !viewHolder.shouldIgnore() && viewHolder.mPosition >= n) {
                viewHolder.offsetPosition(n2, false);
                this.mState.mStructureChanged = true;
            }
            ++n4;
        }
    }

    void offsetPositionRecordsForMove(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6 = this.mChildHelper.getUnfilteredChildCount();
        if (n < n2) {
            n5 = -1;
            n4 = n;
            n3 = n2;
        } else {
            n3 = n;
            n4 = n2;
            n5 = 1;
        }
        int n7 = 0;
        while (true) {
            if (n7 >= n6) {
                this.mRecycler.offsetPositionRecordsForMove(n, n2);
                this.requestLayout();
                return;
            }
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n7));
            if (viewHolder != null && viewHolder.mPosition >= n4 && viewHolder.mPosition <= n3) {
                if (viewHolder.mPosition == n) {
                    viewHolder.offsetPosition(n2 - n, false);
                } else {
                    viewHolder.offsetPosition(n5, false);
                }
                this.mState.mStructureChanged = true;
            }
            ++n7;
        }
    }

    void offsetPositionRecordsForRemove(int n, int n2, boolean bl) {
        int n3 = this.mChildHelper.getUnfilteredChildCount();
        int n4 = 0;
        while (true) {
            if (n4 >= n3) {
                this.mRecycler.offsetPositionRecordsForRemove(n, n2, bl);
                this.requestLayout();
                return;
            }
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n4));
            if (viewHolder != null && !viewHolder.shouldIgnore()) {
                if (viewHolder.mPosition >= n + n2) {
                    viewHolder.offsetPosition(-n2, bl);
                    this.mState.mStructureChanged = true;
                } else if (viewHolder.mPosition >= n) {
                    viewHolder.flagRemovedAndOffsetPosition(n - 1, -n2, bl);
                    this.mState.mStructureChanged = true;
                }
            }
            ++n4;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean bl = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || this.isLayoutRequested()) {
            bl = false;
        }
        this.mFirstLayoutComplete = bl;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (!ALLOW_THREAD_GAP_WORK) return;
        layoutManager = (GapWorker)GapWorker.sGapWorker.get();
        this.mGapWorker = layoutManager;
        if (layoutManager == null) {
            float f;
            this.mGapWorker = new GapWorker();
            layoutManager = ViewCompat.getDisplay((View)this);
            float f2 = f = 60.0f;
            if (!this.isInEditMode()) {
                f2 = f;
                if (layoutManager != null) {
                    float f3 = layoutManager.getRefreshRate();
                    f2 = f;
                    if (f3 >= 30.0f) {
                        f2 = f3;
                    }
                }
            }
            this.mGapWorker.mFrameIntervalNs = (long)(1.0E9f / f2);
            GapWorker.sGapWorker.set(this.mGapWorker);
        }
        this.mGapWorker.add(this);
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        this.stopScroll();
        this.mIsAttached = false;
        itemAnimator = this.mLayout;
        if (itemAnimator != null) {
            itemAnimator.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        this.removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        if (!ALLOW_THREAD_GAP_WORK) return;
        itemAnimator = this.mGapWorker;
        if (itemAnimator == null) return;
        itemAnimator.remove(this);
        this.mGapWorker = null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int n = this.mItemDecorations.size();
        int n2 = 0;
        while (n2 < n) {
            this.mItemDecorations.get(n2).onDraw(canvas, this, this.mState);
            ++n2;
        }
    }

    void onEnterLayoutOrScroll() {
        ++this.mLayoutOrScrollCounter;
    }

    void onExitLayoutOrScroll() {
        this.onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean bl) {
        int n;
        this.mLayoutOrScrollCounter = n = this.mLayoutOrScrollCounter - 1;
        if (n >= 1) return;
        this.mLayoutOrScrollCounter = 0;
        if (!bl) return;
        this.dispatchContentChangedIfNecessary();
        this.dispatchPendingImportantForAccessibilityChanges();
    }

    /*
     * Unable to fully structure code
     */
    public boolean onGenericMotionEvent(MotionEvent var1_1) {
        block6: {
            block7: {
                block5: {
                    if (this.mLayout == null) {
                        return false;
                    }
                    if (this.mLayoutSuppressed) {
                        return false;
                    }
                    if (var1_1.getAction() != 8) return false;
                    if ((var1_1.getSource() & 2) == 0) break block5;
                    var3_2 = this.mLayout.canScrollVertically() != false ? -var1_1.getAxisValue(9) : 0.0f;
                    var2_3 = var3_2;
                    if (!this.mLayout.canScrollHorizontally()) ** GOTO lbl25
                    var4_4 = var1_1.getAxisValue(10);
                    var2_3 = var3_2;
                    var3_2 = var4_4;
                    break block6;
                }
                if ((var1_1.getSource() & 0x400000) == 0) ** GOTO lbl-1000
                var3_2 = var1_1.getAxisValue(26);
                if (!this.mLayout.canScrollVertically()) break block7;
                var2_3 = -var3_2;
                ** GOTO lbl25
            }
            if (this.mLayout.canScrollHorizontally()) {
                var2_3 = 0.0f;
            } else lbl-1000:
            // 2 sources

            {
                var2_3 = 0.0f;
lbl25:
                // 3 sources

                var3_2 = 0.0f;
            }
        }
        if (var2_3 == 0.0f) {
            if (var3_2 == 0.0f) return false;
        }
        this.nestedScrollByInternal((int)(var3_2 * this.mScaledHorizontalScrollFactor), (int)(var2_3 * this.mScaledVerticalScrollFactor), var1_1, 1);
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent object) {
        boolean bl = this.mLayoutSuppressed;
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (this.findInterceptingOnItemTouchListener((MotionEvent)object)) {
            this.cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean bl3 = layoutManager.canScrollHorizontally();
        bl = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(object);
        int n = object.getActionMasked();
        int n2 = object.getActionIndex();
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 5) {
                            if (n == 6) {
                                this.onPointerUp((MotionEvent)object);
                            }
                        } else {
                            this.mScrollPointerId = object.getPointerId(n2);
                            this.mLastTouchX = n = (int)(object.getX(n2) + 0.5f);
                            this.mInitialTouchX = n;
                            this.mLastTouchY = n2 = (int)(object.getY(n2) + 0.5f);
                            this.mInitialTouchY = n2;
                        }
                    } else {
                        this.cancelScroll();
                    }
                } else {
                    n = object.findPointerIndex(this.mScrollPointerId);
                    if (n < 0) {
                        object = new StringBuilder();
                        object.append("Error processing scroll; pointer index for id ");
                        object.append(this.mScrollPointerId);
                        object.append(" not found. Did any MotionEvents get skipped?");
                        Log.e((String)"RecyclerView", (String)object.toString());
                        return false;
                    }
                    n2 = (int)(object.getX(n) + 0.5f);
                    int n3 = (int)(object.getY(n) + 0.5f);
                    if (this.mScrollState != 1) {
                        n = this.mInitialTouchX;
                        int n4 = this.mInitialTouchY;
                        if (bl3 && Math.abs(n2 - n) > this.mTouchSlop) {
                            this.mLastTouchX = n2;
                            n2 = 1;
                        } else {
                            n2 = 0;
                        }
                        n = n2;
                        if (bl) {
                            n = n2;
                            if (Math.abs(n3 - n4) > this.mTouchSlop) {
                                this.mLastTouchY = n3;
                                n = 1;
                            }
                        }
                        if (n != 0) {
                            this.setScrollState(1);
                        }
                    }
                }
            } else {
                this.mVelocityTracker.clear();
                this.stopNestedScroll(0);
            }
        } else {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = object.getPointerId(0);
            this.mLastTouchX = n2 = (int)(object.getX() + 0.5f);
            this.mInitialTouchX = n2;
            this.mLastTouchY = n2 = (int)(object.getY() + 0.5f);
            this.mInitialTouchY = n2;
            if (this.mScrollState == 2) {
                this.getParent().requestDisallowInterceptTouchEvent(true);
                this.setScrollState(1);
                this.stopNestedScroll(1);
            }
            object = this.mNestedOffsets;
            object[1] = (MotionEvent)false;
            object[0] = (MotionEvent)false;
            n2 = bl3 ? 1 : 0;
            n = n2;
            if (bl) {
                n = n2 | 2;
            }
            this.startNestedScroll(n, 0);
        }
        if (this.mScrollState != 1) return bl2;
        bl2 = true;
        return bl2;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        TraceCompat.beginSection((String)"RV OnLayout");
        this.dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    protected void onMeasure(int n, int n2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            this.defaultOnMeasure(n, n2);
            return;
        }
        boolean bl = layoutManager.isAutoMeasureEnabled();
        boolean bl2 = false;
        if (bl) {
            int n3 = View.MeasureSpec.getMode((int)n);
            int n4 = View.MeasureSpec.getMode((int)n2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, n, n2);
            bl = bl2;
            if (n3 == 0x40000000) {
                bl = bl2;
                if (n4 == 0x40000000) {
                    bl = true;
                }
            }
            this.mLastAutoMeasureSkippedDueToExact = bl;
            if (bl) return;
            if (this.mAdapter == null) {
                return;
            }
            if (this.mState.mLayoutStep == 1) {
                this.dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(n, n2);
            this.mState.mIsMeasuring = true;
            this.dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(n, n2);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0x40000000));
                this.mState.mIsMeasuring = true;
                this.dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(n, n2);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = this.getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = this.getMeasuredHeight();
        } else {
            if (this.mHasFixedSize) {
                this.mLayout.onMeasure(this.mRecycler, this.mState, n, n2);
                return;
            }
            if (this.mAdapterUpdateDuringMeasure) {
                this.startInterceptRequestLayout();
                this.onEnterLayoutOrScroll();
                this.processAdapterUpdatesAndSetAnimationFlags();
                this.onExitLayoutOrScroll();
                if (this.mState.mRunPredictiveAnimations) {
                    this.mState.mInPreLayout = true;
                } else {
                    this.mAdapterHelper.consumeUpdatesInOnePass();
                    this.mState.mInPreLayout = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                this.stopInterceptRequestLayout(false);
            } else if (this.mState.mRunPredictiveAnimations) {
                this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredHeight());
                return;
            }
            layoutManager = this.mAdapter;
            this.mState.mItemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
            this.startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, n, n2);
            this.stopInterceptRequestLayout(false);
            this.mState.mInPreLayout = false;
        }
    }

    protected boolean onRequestFocusInDescendants(int n, Rect rect) {
        if (!this.isComputingLayout()) return super.onRequestFocusInDescendants(n, rect);
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        this.mPendingSavedState = parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        this.requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            savedState2 = this.mLayout;
            savedState.mLayoutState = savedState2 != null ? savedState2.onSaveInstanceState() : null;
        }
        return savedState;
    }

    public void onScrollStateChanged(int n) {
    }

    public void onScrolled(int n, int n2) {
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n == n3) {
            if (n2 == n4) return;
        }
        this.invalidateGlows();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block27: {
            block24: {
                block25: {
                    block29: {
                        block28: {
                            block26: {
                                var13_2 = this.mLayoutSuppressed;
                                var10_3 = 0;
                                if (var13_2 != false) return false;
                                if (this.mIgnoreMotionEventTillDown) {
                                    return false;
                                }
                                if (this.dispatchToOnItemTouchListeners((MotionEvent)var1_1)) {
                                    this.cancelScroll();
                                    return true;
                                }
                                var15_4 /* !! */  = this.mLayout;
                                if (var15_4 /* !! */  == null) {
                                    return false;
                                }
                                var13_2 = var15_4 /* !! */ .canScrollHorizontally();
                                var14_5 = this.mLayout.canScrollVertically();
                                if (this.mVelocityTracker == null) {
                                    this.mVelocityTracker = VelocityTracker.obtain();
                                }
                                var5_6 = var1_1.getActionMasked();
                                var4_7 = var1_1.getActionIndex();
                                if (var5_6 == 0) {
                                    var15_4 /* !! */  = (LayoutManager)this.mNestedOffsets;
                                    var15_4 /* !! */ [1] = (LayoutManager)false;
                                    var15_4 /* !! */ [0] = (LayoutManager)false;
                                }
                                var15_4 /* !! */  = MotionEvent.obtain((MotionEvent)var1_1);
                                var16_8 = this.mNestedOffsets;
                                var15_4 /* !! */ .offsetLocation((float)var16_8[0], (float)var16_8[1]);
                                if (var5_6 == 0) break block24;
                                if (var5_6 == 1) break block25;
                                if (var5_6 == 2) break block26;
                                if (var5_6 != 3) {
                                    if (var5_6 != 5) {
                                        if (var5_6 != 6) {
                                            var8_9 = var10_3;
                                        } else {
                                            this.onPointerUp((MotionEvent)var1_1);
                                            var8_9 = var10_3;
                                        }
                                    } else {
                                        this.mScrollPointerId = var1_1.getPointerId(var4_7);
                                        this.mLastTouchX = var5_6 = (int)(var1_1.getX(var4_7) + 0.5f);
                                        this.mInitialTouchX = var5_6;
                                        this.mLastTouchY = var4_7 = (int)(var1_1.getY(var4_7) + 0.5f);
                                        this.mInitialTouchY = var4_7;
                                        var8_9 = var10_3;
                                    }
                                } else {
                                    this.cancelScroll();
                                    var8_9 = var10_3;
                                }
                                break block27;
                            }
                            var4_7 = var1_1.findPointerIndex(this.mScrollPointerId);
                            if (var4_7 < 0) {
                                var1_1 = new StringBuilder();
                                var1_1.append("Error processing scroll; pointer index for id ");
                                var1_1.append(this.mScrollPointerId);
                                var1_1.append(" not found. Did any MotionEvents get skipped?");
                                Log.e((String)"RecyclerView", (String)var1_1.toString());
                                return false;
                            }
                            var11_10 = (int)(var1_1.getX(var4_7) + 0.5f);
                            var12_11 = (int)(var1_1.getY(var4_7) + 0.5f);
                            var4_7 = this.mLastTouchX - var11_10;
                            var8_9 = this.mLastTouchY - var12_11;
                            var5_6 = var4_7;
                            var6_12 = var8_9;
                            if (this.mScrollState == 1) break block28;
                            var6_12 = var4_7;
                            if (!var13_2) ** GOTO lbl-1000
                            var4_7 = var4_7 > 0 ? Math.max(0, var4_7 - this.mTouchSlop) : Math.min(0, var4_7 + this.mTouchSlop);
                            var6_12 = var4_7;
                            if (var4_7 != 0) {
                                var5_6 = 1;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var5_6 = 0;
                                var4_7 = var6_12;
                            }
                            var7_13 = var8_9;
                            var9_14 = var5_6;
                            if (var14_5) {
                                var6_12 = var8_9 > 0 ? Math.max(0, var8_9 - this.mTouchSlop) : Math.min(0, var8_9 + this.mTouchSlop);
                                var7_13 = var6_12;
                                var9_14 = var5_6;
                                if (var6_12 != 0) {
                                    var9_14 = 1;
                                    var7_13 = var6_12;
                                }
                            }
                            var5_6 = var4_7;
                            var6_12 = var7_13;
                            if (var9_14 != 0) {
                                this.setScrollState(1);
                                var6_12 = var7_13;
                                var5_6 = var4_7;
                            }
                        }
                        var7_13 = var5_6;
                        var8_9 = var10_3;
                        if (this.mScrollState != 1) break block27;
                        var16_8 = this.mReusableIntPair;
                        var16_8[0] = 0;
                        var16_8[1] = 0;
                        var8_9 = var13_2 != false ? var7_13 : 0;
                        var9_14 = var14_5 != false ? var6_12 : 0;
                        var5_6 = var7_13;
                        var4_7 = var6_12;
                        if (this.dispatchNestedPreScroll(var8_9, var9_14, this.mReusableIntPair, this.mScrollOffset, 0)) {
                            var16_8 = this.mReusableIntPair;
                            var5_6 = var7_13 - var16_8[0];
                            var4_7 = var6_12 - var16_8[1];
                            var17_15 = this.mNestedOffsets;
                            var6_12 = var17_15[0];
                            var16_8 = this.mScrollOffset;
                            var17_15[0] = var6_12 + var16_8[0];
                            var17_15[1] = var17_15[1] + var16_8[1];
                            this.getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        var16_8 = this.mScrollOffset;
                        this.mLastTouchX = var11_10 - var16_8[0];
                        this.mLastTouchY = var12_11 - var16_8[1];
                        var6_12 = var13_2 != false ? var5_6 : 0;
                        if (this.scrollByInternal(var6_12, var7_13 = var14_5 != false ? var4_7 : 0, (MotionEvent)var1_1, 0)) {
                            this.getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        var8_9 = var10_3;
                        if (this.mGapWorker == null) break block27;
                        if (var5_6 != 0) break block29;
                        var8_9 = var10_3;
                        if (var4_7 == 0) break block27;
                    }
                    this.mGapWorker.postFromTraversal(this, var5_6, var4_7);
                    var8_9 = var10_3;
                    break block27;
                }
                this.mVelocityTracker.addMovement((MotionEvent)var15_4 /* !! */ );
                this.mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaxFlingVelocity);
                var2_16 = var13_2 != false ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                var3_17 = var14_5 != false ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                if (var2_16 == 0.0f && var3_17 == 0.0f || !this.fling((int)var2_16, (int)var3_17)) {
                    this.setScrollState(0);
                }
                this.resetScroll();
                var8_9 = 1;
                break block27;
            }
            this.mScrollPointerId = var1_1.getPointerId(0);
            this.mLastTouchX = var4_7 = (int)(var1_1.getX() + 0.5f);
            this.mInitialTouchX = var4_7;
            this.mLastTouchY = var4_7 = (int)(var1_1.getY() + 0.5f);
            this.mInitialTouchY = var4_7;
            var4_7 = var13_2 != false ? 1 : 0;
            var5_6 = var4_7;
            if (var14_5) {
                var5_6 = var4_7 | 2;
            }
            this.startNestedScroll(var5_6, 0);
            var8_9 = var10_3;
        }
        if (var8_9 == 0) {
            this.mVelocityTracker.addMovement((MotionEvent)var15_4 /* !! */ );
        }
        var15_4 /* !! */ .recycle();
        return true;
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner) return;
        if (!this.mIsAttached) return;
        ViewCompat.postOnAnimation((View)this, (Runnable)this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    void processDataSetCompletelyChanged(boolean bl) {
        this.mDispatchItemsChangedEvent = bl | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        this.markKnownViewsInvalid();
    }

    void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            long l = this.getChangedHolderKey(viewHolder);
            this.mViewInfoStore.addToOldChangeHolders(l, viewHolder);
        }
        this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
    }

    void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        if ((itemAnimator = this.mLayout) != null) {
            itemAnimator.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.clear();
    }

    boolean removeAnimatingView(View view) {
        this.startInterceptRequestLayout();
        boolean bl = this.mChildHelper.removeViewIfHidden(view);
        if (bl) {
            view = RecyclerView.getChildViewHolderInt(view);
            this.mRecycler.unscrapView((ViewHolder)view);
            this.mRecycler.recycleViewHolderInternal((ViewHolder)view);
        }
        this.stopInterceptRequestLayout(bl ^ true);
        return bl;
    }

    protected void removeDetachedView(View object, boolean bl) {
        ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)object);
        if (viewHolder != null) {
            if (viewHolder.isTmpDetached()) {
                viewHolder.clearTmpDetachFlag();
            } else if (!viewHolder.shouldIgnore()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                ((StringBuilder)object).append(viewHolder);
                ((StringBuilder)object).append(this.exceptionLabel());
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
        }
        object.clearAnimation();
        this.dispatchChildDetached((View)object);
        super.removeDetachedView((View)object, bl);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            boolean bl = this.getOverScrollMode() == 2;
            this.setWillNotDraw(bl);
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }

    public void removeItemDecorationAt(int n) {
        int n2 = this.getItemDecorationCount();
        if (n >= 0 && n < n2) {
            this.removeItemDecoration(this.getItemDecorationAt(n));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        stringBuilder.append(" is an invalid index for size ");
        stringBuilder.append(n2);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener != onItemTouchListener) return;
        this.mInterceptingOnItemTouchListener = null;
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list == null) return;
        list.remove(onScrollListener);
    }

    public void removeRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListeners.remove(recyclerListener);
    }

    void repositionShadowingViews() {
        int n = this.mChildHelper.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = this.mChildHelper.getChildAt(n2);
            ViewHolder viewHolder = this.getChildViewHolder(view);
            if (viewHolder != null && viewHolder.mShadowingHolder != null) {
                viewHolder = viewHolder.mShadowingHolder.itemView;
                int n3 = view.getLeft();
                int n4 = view.getTop();
                if (n3 != viewHolder.getLeft() || n4 != viewHolder.getTop()) {
                    viewHolder.layout(n3, n4, viewHolder.getWidth() + n3, viewHolder.getHeight() + n4);
                }
            }
            ++n2;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            this.requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, bl);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl) {
        int n = this.mOnItemTouchListeners.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                super.requestDisallowInterceptTouchEvent(bl);
                return;
            }
            this.mOnItemTouchListeners.get(n2).onRequestDisallowInterceptTouchEvent(bl);
            ++n2;
        }
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    void saveOldPositions() {
        int n = this.mChildHelper.getUnfilteredChildCount();
        int n2 = 0;
        while (n2 < n) {
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n2));
            if (!viewHolder.shouldIgnore()) {
                viewHolder.saveOldPosition();
            }
            ++n2;
        }
    }

    public void scrollBy(int n, int n2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e((String)"RecyclerView", (String)"Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean bl = layoutManager.canScrollHorizontally();
        boolean bl2 = this.mLayout.canScrollVertically();
        if (!bl) {
            if (!bl2) return;
        }
        if (!bl) {
            n = 0;
        }
        if (!bl2) {
            n2 = 0;
        }
        this.scrollByInternal(n, n2, null, 0);
    }

    /*
     * WARNING - void declaration
     */
    boolean scrollByInternal(int n, int n2, MotionEvent motionEvent, int n3) {
        void var5_14;
        void var8_10;
        Object object;
        Object object2;
        this.consumePendingUpdateOperations();
        Object object3 = this.mAdapter;
        boolean bl = true;
        if (object3 != null) {
            object3 = this.mReusableIntPair;
            object3[0] = (Adapter)false;
            object3[1] = (Adapter)false;
            this.scrollStep(n, n2, (int[])object3);
            object3 = this.mReusableIntPair;
            Adapter n7 = object3[0];
            Adapter adapter = object3[1];
            object2 = adapter;
            object = n7;
            int n4 = n - n7;
            int n5 = n2 - adapter;
        } else {
            object2 = 0;
            object = 0;
            boolean bl2 = false;
            boolean bl3 = false;
        }
        if (!this.mItemDecorations.isEmpty()) {
            this.invalidate();
        }
        object3 = this.mReusableIntPair;
        object3[0] = (Adapter)false;
        object3[1] = (Adapter)false;
        this.dispatchNestedScroll((int)object, (int)object2, (int)var8_10, (int)var5_14, this.mScrollOffset, n3, (int[])object3);
        object3 = this.mReusableIntPair;
        Adapter adapter = object3[0];
        Adapter adapter2 = object3[1];
        n3 = object3[0] == false && object3[1] == false ? 0 : 1;
        int n6 = this.mLastTouchX;
        int[] nArray = this.mScrollOffset;
        this.mLastTouchX = n6 - nArray[0];
        this.mLastTouchY -= nArray[1];
        object3 = this.mNestedOffsets;
        object3[0] = object3[0] + nArray[0];
        object3[1] = object3[1] + nArray[1];
        if (this.getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource((MotionEvent)motionEvent, (int)8194)) {
                this.pullGlows(motionEvent.getX(), (float)(var8_10 - adapter), motionEvent.getY(), (float)(var5_14 - adapter2));
            }
            this.considerReleasingGlowsOnScroll(n, n2);
        }
        if (object != 0 || object2 != 0) {
            this.dispatchOnScrolled((int)object, (int)object2);
        }
        if (!this.awakenScrollBars()) {
            this.invalidate();
        }
        boolean bl4 = bl;
        if (n3 != 0) return bl4;
        bl4 = bl;
        if (object != 0) return bl4;
        bl4 = object2 != 0 ? bl : false;
        return bl4;
    }

    void scrollStep(int n, int n2, int[] nArray) {
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        TraceCompat.beginSection((String)"RV Scroll");
        this.fillRemainingScrollValues(this.mState);
        n = n != 0 ? this.mLayout.scrollHorizontallyBy(n, this.mRecycler, this.mState) : 0;
        n2 = n2 != 0 ? this.mLayout.scrollVerticallyBy(n2, this.mRecycler, this.mState) : 0;
        TraceCompat.endSection();
        this.repositionShadowingViews();
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        if (nArray == null) return;
        nArray[0] = n;
        nArray[1] = n2;
    }

    public void scrollTo(int n, int n2) {
        Log.w((String)"RecyclerView", (String)"RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int n) {
        if (this.mLayoutSuppressed) {
            return;
        }
        this.stopScroll();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e((String)"RecyclerView", (String)"Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        layoutManager.scrollToPosition(n);
        this.awakenScrollBars();
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (this.shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter) {
        this.setLayoutFrozen(false);
        this.setAdapterInternal(adapter, false, true);
        this.processDataSetCompletelyChanged(false);
        this.requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = childDrawingOrderCallback;
        boolean bl = childDrawingOrderCallback != null;
        this.setChildrenDrawingOrderEnabled(bl);
    }

    boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int n) {
        if (this.isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = n;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility((View)viewHolder.itemView, (int)n);
        return true;
    }

    public void setClipToPadding(boolean bl) {
        if (bl != this.mClipToPadding) {
            this.invalidateGlows();
        }
        this.mClipToPadding = bl;
        super.setClipToPadding(bl);
        if (!this.mFirstLayoutComplete) return;
        this.requestLayout();
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull((Object)edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        this.invalidateGlows();
    }

    public void setHasFixedSize(boolean bl) {
        this.mHasFixedSize = bl;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator == null) return;
        itemAnimator.setListener(this.mItemAnimatorListener);
    }

    public void setItemViewCacheSize(int n) {
        this.mRecycler.setViewCacheSize(n);
    }

    @Deprecated
    public void setLayoutFrozen(boolean bl) {
        this.suppressLayout(bl);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        Object object;
        if (layoutManager == this.mLayout) {
            return;
        }
        this.stopScroll();
        if (this.mLayout != null) {
            object = this.mItemAnimator;
            if (object != null) {
                object.endAnimations();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.clear();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.clear();
        }
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.mRecyclerView != null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("LayoutManager ");
                ((StringBuilder)object).append(layoutManager);
                ((StringBuilder)object).append(" is already attached to a RecyclerView:");
                ((StringBuilder)object).append(layoutManager.mRecyclerView.exceptionLabel());
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            this.mLayout.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.updateViewCacheSize();
        this.requestLayout();
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                this.suppressLayout(false);
                return;
            }
            if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                this.suppressLayout(true);
                return;
            }
        }
        if (layoutTransition != null) throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        super.setLayoutTransition(null);
    }

    public void setNestedScrollingEnabled(boolean bl) {
        this.getScrollingChildHelper().setNestedScrollingEnabled(bl);
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean bl) {
        this.mPreserveFocusAfterLayout = bl;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.mRecycler.setRecycledViewPool(recycledViewPool);
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    void setScrollState(int n) {
        if (n == this.mScrollState) {
            return;
        }
        this.mScrollState = n;
        if (n != 2) {
            this.stopScrollersInternal();
        }
        this.dispatchOnScrollStateChanged(n);
    }

    /*
     * Enabled force condition propagation
     */
    public void setScrollingTouchSlop(int n) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)this.getContext());
        if (n != 0) {
            if (n == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
            stringBuilder.append(n);
            stringBuilder.append("; using default value");
            Log.w((String)"RecyclerView", (String)stringBuilder.toString());
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.setViewCacheExtension(viewCacheExtension);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean bl = this.isComputingLayout();
        int n = 0;
        if (!bl) return false;
        int n2 = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes((AccessibilityEvent)accessibilityEvent) : 0;
        if (n2 == 0) {
            n2 = n;
        }
        this.mEatenAccessibilityChangeFlags |= n2;
        return true;
    }

    public void smoothScrollBy(int n, int n2) {
        this.smoothScrollBy(n, n2, null);
    }

    public void smoothScrollBy(int n, int n2, Interpolator interpolator) {
        this.smoothScrollBy(n, n2, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int n, int n2, Interpolator interpolator, int n3) {
        this.smoothScrollBy(n, n2, interpolator, n3, false);
    }

    void smoothScrollBy(int n, int n2, Interpolator interpolator, int n3, boolean bl) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e((String)"RecyclerView", (String)"Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean bl2 = layoutManager.canScrollHorizontally();
        int n4 = 0;
        int n5 = n;
        if (!bl2) {
            n5 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            n2 = 0;
        }
        if (n5 == 0) {
            if (n2 == 0) return;
        }
        n = n3 != Integer.MIN_VALUE && n3 <= 0 ? 0 : 1;
        if (n != 0) {
            if (bl) {
                n = n4;
                if (n5 != 0) {
                    n = 1;
                }
                n4 = n;
                if (n2 != 0) {
                    n4 = n | 2;
                }
                this.startNestedScroll(n4, 1);
            }
            this.mViewFlinger.smoothScrollBy(n5, n2, n3, interpolator);
        } else {
            this.scrollBy(n5, n2);
        }
    }

    public void smoothScrollToPosition(int n) {
        if (this.mLayoutSuppressed) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e((String)"RecyclerView", (String)"Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        layoutManager.smoothScrollToPosition(this, this.mState, n);
    }

    void startInterceptRequestLayout() {
        int n;
        this.mInterceptRequestLayoutDepth = n = this.mInterceptRequestLayoutDepth + 1;
        if (n != 1) return;
        if (this.mLayoutSuppressed) return;
        this.mLayoutWasDefered = false;
    }

    public boolean startNestedScroll(int n) {
        return this.getScrollingChildHelper().startNestedScroll(n);
    }

    public boolean startNestedScroll(int n, int n2) {
        return this.getScrollingChildHelper().startNestedScroll(n, n2);
    }

    void stopInterceptRequestLayout(boolean bl) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!bl && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (bl && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                this.dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        --this.mInterceptRequestLayoutDepth;
    }

    public void stopNestedScroll() {
        this.getScrollingChildHelper().stopNestedScroll();
    }

    public void stopNestedScroll(int n) {
        this.getScrollingChildHelper().stopNestedScroll(n);
    }

    public void stopScroll() {
        this.setScrollState(0);
        this.stopScrollersInternal();
    }

    public final void suppressLayout(boolean bl) {
        if (bl == this.mLayoutSuppressed) return;
        this.assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
        if (!bl) {
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                this.requestLayout();
            }
            this.mLayoutWasDefered = false;
        } else {
            long l = SystemClock.uptimeMillis();
            this.onTouchEvent(MotionEvent.obtain((long)l, (long)l, (int)3, (float)0.0f, (float)0.0f, (int)0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            this.stopScroll();
        }
    }

    public void swapAdapter(Adapter adapter, boolean bl) {
        this.setLayoutFrozen(false);
        this.setAdapterInternal(adapter, true, bl);
        this.processDataSetCompletelyChanged(true);
        this.requestLayout();
    }

    void viewRangeUpdate(int n, int n2, Object object) {
        int n3 = this.mChildHelper.getUnfilteredChildCount();
        int n4 = 0;
        while (true) {
            if (n4 >= n3) {
                this.mRecycler.viewRangeUpdate(n, n2);
                return;
            }
            View view = this.mChildHelper.getUnfilteredChildAt(n4);
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(view);
            if (viewHolder != null && !viewHolder.shouldIgnore() && viewHolder.mPosition >= n && viewHolder.mPosition < n + n2) {
                viewHolder.addFlags(2);
                viewHolder.addChangePayload(object);
                ((LayoutParams)view.getLayoutParams()).mInsetsDirty = true;
            }
            ++n4;
        }
    }
}
