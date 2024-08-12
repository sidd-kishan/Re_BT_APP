/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.app.Activity
 *  android.content.ClipData
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.Display
 *  android.view.KeyEvent
 *  android.view.PointerIcon
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.View$DragShadowBuilder
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.WindowInsets
 *  android.view.WindowManager
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  androidx.core.R$id
 *  androidx.core.util.Preconditions
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.AccessibilityDelegateCompat$AccessibilityDelegateAdapter
 *  androidx.core.view.ContentInfoCompat
 *  androidx.core.view.NestedScrollingChild
 *  androidx.core.view.NestedScrollingChild2
 *  androidx.core.view.NestedScrollingChild3
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.OnReceiveContentListener
 *  androidx.core.view.OnReceiveContentViewBehavior
 *  androidx.core.view.PointerIconCompat
 *  androidx.core.view.TintableBackgroundView
 *  androidx.core.view.ViewCompat$AccessibilityPaneVisibilityManager
 *  androidx.core.view.ViewCompat$AccessibilityViewProperty
 *  androidx.core.view.ViewCompat$Api21Impl
 *  androidx.core.view.ViewCompat$Api23Impl
 *  androidx.core.view.ViewCompat$Api29Impl
 *  androidx.core.view.ViewCompat$Api30Impl
 *  androidx.core.view.ViewCompat$CompatImplApi28
 *  androidx.core.view.ViewCompat$OnUnhandledKeyEventListenerCompat
 *  androidx.core.view.ViewCompat$UnhandledKeyEventManager
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.WindowCompat
 *  androidx.core.view.WindowInsetsAnimationCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$Callback
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsControllerCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 *  androidx.core.view.accessibility.AccessibilityViewCommand
 */
package androidx.core.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.OnReceiveContentListener;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Exception performing whole class analysis ignored.
 */
public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 0xFFFFFF;
    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 0x1000000;
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static final AtomicInteger sNextGeneratedId;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    static {
        sNextGeneratedId = new AtomicInteger(1);
        sViewPropertyAnimatorMap = null;
        sAccessibilityDelegateCheckFailed = false;
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new /* Unavailable Anonymous Inner Class!! */;
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    @Deprecated
    protected ViewCompat() {
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static int addAccessibilityAction(View view, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        int n = ViewCompat.getAvailableActionIdFromResources(view, charSequence);
        if (n == -1) return n;
        ViewCompat.addAccessibilityAction(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(n, charSequence, accessibilityViewCommand));
        return n;
    }

    private static void addAccessibilityAction(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        if (Build.VERSION.SDK_INT < 21) return;
        ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
        ViewCompat.removeActionWithId(accessibilityActionCompat.getId(), view);
        ViewCompat.getActionList(view).add(accessibilityActionCompat);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static void addKeyboardNavigationClusters(View view, Collection<View> collection, int n) {
        if (Build.VERSION.SDK_INT < 26) return;
        view.addKeyboardNavigationClusters(collection, n);
    }

    public static void addOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        ArrayList<OnUnhandledKeyEventListenerCompat> arrayList;
        if (Build.VERSION.SDK_INT >= 28) {
            CompatImplApi28.addOnUnhandledKeyEventListener((View)view, (OnUnhandledKeyEventListenerCompat)onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList<OnUnhandledKeyEventListenerCompat> arrayList2 = arrayList = (ArrayList<OnUnhandledKeyEventListenerCompat>)view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) {
            arrayList2 = new ArrayList<OnUnhandledKeyEventListenerCompat>();
            view.setTag(R.id.tag_unhandled_key_listeners, arrayList2);
        }
        arrayList2.add(onUnhandledKeyEventListenerCompat);
        if (arrayList2.size() != 1) return;
        UnhandledKeyEventManager.registerListeningView((View)view);
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat != null) return viewPropertyAnimatorCompat2;
        viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    private static void bindTempDetach() {
        try {
            sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.e((String)"ViewCompat", (String)"Couldn't find method", (Throwable)noSuchMethodException);
        }
        sTempDetachBound = true;
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int n) {
        return view.canScrollHorizontally(n);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int n) {
        return view.canScrollVertically(n);
    }

    public static void cancelDragAndDrop(View view) {
        if (Build.VERSION.SDK_INT < 24) return;
        view.cancelDragAndDrop();
    }

    @Deprecated
    public static int combineMeasuredStates(int n, int n2) {
        return View.combineMeasuredStates((int)n, (int)n2);
    }

    private static void compatOffsetLeftAndRight(View view, int n) {
        view.offsetLeftAndRight(n);
        if (view.getVisibility() != 0) return;
        ViewCompat.tickleInvalidationFlag(view);
        view = view.getParent();
        if (!(view instanceof View)) return;
        ViewCompat.tickleInvalidationFlag(view);
    }

    private static void compatOffsetTopAndBottom(View view, int n) {
        view.offsetTopAndBottom(n);
        if (view.getVisibility() != 0) return;
        ViewCompat.tickleInvalidationFlag(view);
        view = view.getParent();
        if (!(view instanceof View)) return;
        ViewCompat.tickleInvalidationFlag(view);
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        if (Build.VERSION.SDK_INT < 21) return windowInsetsCompat;
        return Api21Impl.computeSystemWindowInsets((View)view, (WindowInsetsCompat)windowInsetsCompat, (Rect)rect);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (Build.VERSION.SDK_INT < 21) return windowInsetsCompat;
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets == null) return windowInsetsCompat;
        WindowInsets windowInsets2 = view.dispatchApplyWindowInsets(windowInsets);
        if (windowInsets2.equals((Object)windowInsets)) return windowInsetsCompat;
        return WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)windowInsets2, (View)view);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchFinishTemporaryDetach();
        } else {
            Method method;
            if (!sTempDetachBound) {
                ViewCompat.bindTempDetach();
            }
            if ((method = sDispatchFinishTemporaryDetach) != null) {
                try {
                    method.invoke(view, new Object[0]);
                }
                catch (Exception exception) {
                    Log.d((String)"ViewCompat", (String)"Error calling dispatchFinishTemporaryDetach", (Throwable)exception);
                }
            } else {
                view.onFinishTemporaryDetach();
            }
        }
    }

    public static boolean dispatchNestedFling(View view, float f, float f2, boolean bl) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedFling(f, f2, bl);
        }
        if (!(view instanceof NestedScrollingChild)) return false;
        return ((NestedScrollingChild)view).dispatchNestedFling(f, f2, bl);
    }

    public static boolean dispatchNestedPreFling(View view, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedPreFling(f, f2);
        }
        if (!(view instanceof NestedScrollingChild)) return false;
        return ((NestedScrollingChild)view).dispatchNestedPreFling(f, f2);
    }

    public static boolean dispatchNestedPreScroll(View view, int n, int n2, int[] nArray, int[] nArray2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedPreScroll(n, n2, nArray, nArray2);
        }
        if (!(view instanceof NestedScrollingChild)) return false;
        return ((NestedScrollingChild)view).dispatchNestedPreScroll(n, n2, nArray, nArray2);
    }

    public static boolean dispatchNestedPreScroll(View view, int n, int n2, int[] nArray, int[] nArray2, int n3) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2)view).dispatchNestedPreScroll(n, n2, nArray, nArray2, n3);
        }
        if (n3 != 0) return false;
        return ViewCompat.dispatchNestedPreScroll(view, n, n2, nArray, nArray2);
    }

    public static void dispatchNestedScroll(View view, int n, int n2, int n3, int n4, int[] nArray, int n5, int[] nArray2) {
        if (view instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3)view).dispatchNestedScroll(n, n2, n3, n4, nArray, n5, nArray2);
        } else {
            ViewCompat.dispatchNestedScroll(view, n, n2, n3, n4, nArray, n5);
        }
    }

    public static boolean dispatchNestedScroll(View view, int n, int n2, int n3, int n4, int[] nArray) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedScroll(n, n2, n3, n4, nArray);
        }
        if (!(view instanceof NestedScrollingChild)) return false;
        return ((NestedScrollingChild)view).dispatchNestedScroll(n, n2, n3, n4, nArray);
    }

    public static boolean dispatchNestedScroll(View view, int n, int n2, int n3, int n4, int[] nArray, int n5) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2)view).dispatchNestedScroll(n, n2, n3, n4, nArray, n5);
        }
        if (n5 != 0) return false;
        return ViewCompat.dispatchNestedScroll(view, n, n2, n3, n4, nArray);
    }

    public static void dispatchStartTemporaryDetach(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchStartTemporaryDetach();
        } else {
            Method method;
            if (!sTempDetachBound) {
                ViewCompat.bindTempDetach();
            }
            if ((method = sDispatchStartTemporaryDetach) != null) {
                try {
                    method.invoke(view, new Object[0]);
                }
                catch (Exception exception) {
                    Log.d((String)"ViewCompat", (String)"Error calling dispatchStartTemporaryDetach", (Throwable)exception);
                }
            } else {
                view.onStartTemporaryDetach();
            }
        }
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT < 28) return UnhandledKeyEventManager.at((View)view).dispatch(view, keyEvent);
        return false;
    }

    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT < 28) return UnhandledKeyEventManager.at((View)view).preDispatch(keyEvent);
        return false;
    }

    public static void enableAccessibleClickableSpanSupport(View view) {
        if (Build.VERSION.SDK_INT < 19) return;
        ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
    }

    public static int generateViewId() {
        int n;
        int n2;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            int n3;
            n2 = sNextGeneratedId.get();
            n = n3 = n2 + 1;
            if (n3 <= 0xFFFFFF) continue;
            n = 1;
        } while (!sNextGeneratedId.compareAndSet(n2, n));
        return n2;
    }

    public static AccessibilityDelegateCompat getAccessibilityDelegate(View view) {
        if ((view = ViewCompat.getAccessibilityDelegateInternal(view)) == null) {
            return null;
        }
        if (!(view instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) return new AccessibilityDelegateCompat((View.AccessibilityDelegate)view);
        return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter)view).mCompat;
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(View view) {
        if (Build.VERSION.SDK_INT < 29) return ViewCompat.getAccessibilityDelegateThroughReflection(view);
        return view.getAccessibilityDelegate();
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(View object) {
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field field;
                sAccessibilityDelegateField = field = View.class.getDeclaredField("mAccessibilityDelegate");
                field.setAccessible(true);
            }
            catch (Throwable throwable) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            object = sAccessibilityDelegateField.get(object);
            if (!(object instanceof View.AccessibilityDelegate)) return null;
            object = (View.AccessibilityDelegate)object;
            return object;
        }
        catch (Throwable throwable) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    public static int getAccessibilityLiveRegion(View view) {
        if (Build.VERSION.SDK_INT < 19) return 0;
        return view.getAccessibilityLiveRegion();
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (Build.VERSION.SDK_INT < 16) return null;
        if ((view = view.getAccessibilityNodeProvider()) == null) return null;
        return new AccessibilityNodeProviderCompat((Object)view);
    }

    public static CharSequence getAccessibilityPaneTitle(View view) {
        return (CharSequence)ViewCompat.paneTitleProperty().get(view);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList = (ArrayList)view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) return arrayList2;
        arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    private static int getAvailableActionIdFromResources(View object, CharSequence object2) {
        int n;
        object = ViewCompat.getActionList((View)object);
        for (n = 0; n < object.size(); ++n) {
            if (!TextUtils.equals((CharSequence)object2, (CharSequence)((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object.get(n)).getLabel())) continue;
            return ((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object.get(n)).getId();
        }
        n = 0;
        Object object3 = -1;
        while (n < ((Object)(object2 = (Object)ACCESSIBILITY_ACTIONS_RESOURCE_IDS)).length) {
            boolean bl;
            if (object3 != -1) return object3;
            Object object4 = object2[n];
            boolean bl2 = true;
            for (int i = 0; i < object.size(); bl2 &= bl, ++i) {
                bl = ((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object.get(i)).getId() != object4;
            }
            if (bl2) {
                object3 = object4;
            }
            ++n;
        }
        return object3;
    }

    public static ColorStateList getBackgroundTintList(View object) {
        if (Build.VERSION.SDK_INT >= 21) {
            return object.getBackgroundTintList();
        }
        object = object instanceof TintableBackgroundView ? ((TintableBackgroundView)object).getSupportBackgroundTintList() : null;
        return object;
    }

    public static PorterDuff.Mode getBackgroundTintMode(View object) {
        if (Build.VERSION.SDK_INT >= 21) {
            return object.getBackgroundTintMode();
        }
        object = object instanceof TintableBackgroundView ? ((TintableBackgroundView)object).getSupportBackgroundTintMode() : null;
        return object;
    }

    public static Rect getClipBounds(View view) {
        if (Build.VERSION.SDK_INT < 18) return null;
        return view.getClipBounds();
    }

    public static Display getDisplay(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (!ViewCompat.isAttachedToWindow(view)) return null;
        return ((WindowManager)view.getContext().getSystemService("window")).getDefaultDisplay();
    }

    public static float getElevation(View view) {
        if (Build.VERSION.SDK_INT < 21) return 0.0f;
        return view.getElevation();
    }

    private static Rect getEmptyTempRect() {
        Rect rect;
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal();
        }
        Rect rect2 = rect = sThreadLocalRect.get();
        if (rect == null) {
            rect2 = new Rect();
            sThreadLocalRect.set(rect2);
        }
        rect2.setEmpty();
        return rect2;
    }

    private static OnReceiveContentViewBehavior getFallback(View view) {
        if (!(view instanceof OnReceiveContentViewBehavior)) return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
        return (OnReceiveContentViewBehavior)view;
    }

    public static boolean getFitsSystemWindows(View view) {
        if (Build.VERSION.SDK_INT < 16) return false;
        return view.getFitsSystemWindows();
    }

    public static int getImportantForAccessibility(View view) {
        if (Build.VERSION.SDK_INT < 16) return 0;
        return view.getImportantForAccessibility();
    }

    public static int getImportantForAutofill(View view) {
        if (Build.VERSION.SDK_INT < 26) return 0;
        return view.getImportantForAutofill();
    }

    public static int getLabelFor(View view) {
        if (Build.VERSION.SDK_INT < 17) return 0;
        return view.getLabelFor();
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(View view) {
        if (Build.VERSION.SDK_INT < 17) return 0;
        return view.getLayoutDirection();
    }

    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    /*
     * Unable to fully structure code
     */
    public static int getMinimumHeight(View var0) {
        block7: {
            if (Build.VERSION.SDK_INT >= 16) {
                return var0.getMinimumHeight();
            }
            if (ViewCompat.sMinHeightFieldFetched) ** GOTO lbl-1000
            try {
                ViewCompat.sMinHeightField = var2_2 = View.class.getDeclaredField("mMinHeight");
                var2_2.setAccessible(true);
lbl7:
                // 2 sources

                while (true) {
                    ViewCompat.sMinHeightFieldFetched = true;
                    break;
                }
            }
            catch (NoSuchFieldException var2_3) {
                ** continue;
            }
lbl-1000:
            // 2 sources

            {
                if ((var2_2 = ViewCompat.sMinHeightField) == null) return 0;
                try {}
                catch (Exception var0_1) {
                    break block7;
                }
            }
            var1_4 = (Integer)var2_2.get(var0);
            return var1_4;
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    public static int getMinimumWidth(View var0) {
        block7: {
            if (Build.VERSION.SDK_INT >= 16) {
                return var0.getMinimumWidth();
            }
            if (ViewCompat.sMinWidthFieldFetched) ** GOTO lbl-1000
            try {
                ViewCompat.sMinWidthField = var2_2 = View.class.getDeclaredField("mMinWidth");
                var2_2.setAccessible(true);
lbl7:
                // 2 sources

                while (true) {
                    ViewCompat.sMinWidthFieldFetched = true;
                    break;
                }
            }
            catch (NoSuchFieldException var2_3) {
                ** continue;
            }
lbl-1000:
            // 2 sources

            {
                if ((var2_2 = ViewCompat.sMinWidthField) == null) return 0;
                try {}
                catch (Exception var0_1) {
                    break block7;
                }
            }
            var1_4 = (Integer)var2_2.get(var0);
            return var1_4;
        }
        return 0;
    }

    public static int getNextClusterForwardId(View view) {
        if (Build.VERSION.SDK_INT < 26) return -1;
        return view.getNextClusterForwardId();
    }

    public static String[] getOnReceiveContentMimeTypes(View view) {
        return (String[])view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    static AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(View view) {
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        AccessibilityDelegateCompat accessibilityDelegateCompat2 = accessibilityDelegateCompat = ViewCompat.getAccessibilityDelegate(view);
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegateCompat2 = new AccessibilityDelegateCompat();
        }
        ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat2);
        return accessibilityDelegateCompat2;
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    public static int getPaddingEnd(View view) {
        if (Build.VERSION.SDK_INT < 17) return view.getPaddingRight();
        return view.getPaddingEnd();
    }

    public static int getPaddingStart(View view) {
        if (Build.VERSION.SDK_INT < 17) return view.getPaddingLeft();
        return view.getPaddingStart();
    }

    public static ViewParent getParentForAccessibility(View view) {
        if (Build.VERSION.SDK_INT < 16) return view.getParent();
        return view.getParentForAccessibility();
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getRootWindowInsets((View)view);
        }
        if (Build.VERSION.SDK_INT < 21) return null;
        return Api21Impl.getRootWindowInsets((View)view);
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(View view) {
        if (Build.VERSION.SDK_INT < 23) return 0;
        return view.getScrollIndicators();
    }

    public static final CharSequence getStateDescription(View view) {
        return (CharSequence)ViewCompat.stateDescriptionProperty().get(view);
    }

    public static List<Rect> getSystemGestureExclusionRects(View view) {
        if (Build.VERSION.SDK_INT < 29) return Collections.emptyList();
        return view.getSystemGestureExclusionRects();
    }

    public static String getTransitionName(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = sTransitionNameMap;
        if (weakHashMap != null) return weakHashMap.get(view);
        return null;
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(View view) {
        if (Build.VERSION.SDK_INT < 21) return 0.0f;
        return view.getTranslationZ();
    }

    public static WindowInsetsControllerCompat getWindowInsetsController(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getWindowInsetsController((View)view);
        }
        Context context = view.getContext();
        while (true) {
            boolean bl = context instanceof ContextWrapper;
            Object var3_3 = null;
            if (!bl) return null;
            if (context instanceof Activity) {
                Window window = ((Activity)context).getWindow();
                context = var3_3;
                if (window == null) return context;
                context = WindowCompat.getInsetsController((Window)window, (View)view);
                return context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
    }

    public static int getWindowSystemUiVisibility(View view) {
        if (Build.VERSION.SDK_INT < 16) return 0;
        return view.getWindowSystemUiVisibility();
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(View view) {
        if (Build.VERSION.SDK_INT < 21) return 0.0f;
        return view.getZ();
    }

    public static boolean hasAccessibilityDelegate(View view) {
        boolean bl = ViewCompat.getAccessibilityDelegateInternal(view) != null;
        return bl;
    }

    public static boolean hasExplicitFocusable(View view) {
        if (Build.VERSION.SDK_INT < 26) return view.hasFocusable();
        return view.hasExplicitFocusable();
    }

    public static boolean hasNestedScrollingParent(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.hasNestedScrollingParent();
        }
        if (!(view instanceof NestedScrollingChild)) return false;
        return ((NestedScrollingChild)view).hasNestedScrollingParent();
    }

    public static boolean hasNestedScrollingParent(View view, int n) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2)view).hasNestedScrollingParent(n);
            return false;
        }
        if (n != 0) return false;
        return ViewCompat.hasNestedScrollingParent(view);
    }

    public static boolean hasOnClickListeners(View view) {
        if (Build.VERSION.SDK_INT < 15) return false;
        return view.hasOnClickListeners();
    }

    public static boolean hasOverlappingRendering(View view) {
        if (Build.VERSION.SDK_INT < 16) return true;
        return view.hasOverlappingRendering();
    }

    public static boolean hasTransientState(View view) {
        if (Build.VERSION.SDK_INT < 16) return false;
        return view.hasTransientState();
    }

    public static boolean isAccessibilityHeading(View object) {
        object = (Boolean)ViewCompat.accessibilityHeadingProperty().get((View)object);
        boolean bl = object == null ? false : (Boolean)object;
        return bl;
    }

    public static boolean isAttachedToWindow(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        boolean bl = view.getWindowToken() != null;
        return bl;
    }

    public static boolean isFocusedByDefault(View view) {
        if (Build.VERSION.SDK_INT < 26) return false;
        return view.isFocusedByDefault();
    }

    public static boolean isImportantForAccessibility(View view) {
        if (Build.VERSION.SDK_INT < 21) return true;
        return view.isImportantForAccessibility();
    }

    public static boolean isImportantForAutofill(View view) {
        if (Build.VERSION.SDK_INT < 26) return true;
        return view.isImportantForAutofill();
    }

    public static boolean isInLayout(View view) {
        if (Build.VERSION.SDK_INT < 18) return false;
        return view.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(View view) {
        if (Build.VERSION.SDK_INT < 26) return false;
        return view.isKeyboardNavigationCluster();
    }

    public static boolean isLaidOut(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        boolean bl = view.getWidth() > 0 && view.getHeight() > 0;
        return bl;
    }

    public static boolean isLayoutDirectionResolved(View view) {
        if (Build.VERSION.SDK_INT < 19) return false;
        return view.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (!(view instanceof NestedScrollingChild)) return false;
        return ((NestedScrollingChild)view).isNestedScrollingEnabled();
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(View view) {
        if (Build.VERSION.SDK_INT < 17) return false;
        return view.isPaddingRelative();
    }

    public static boolean isScreenReaderFocusable(View object) {
        object = (Boolean)ViewCompat.screenReaderFocusableProperty().get((View)object);
        boolean bl = object == null ? false : (Boolean)object;
        return bl;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View view, View view2, int n) {
        if (Build.VERSION.SDK_INT < 26) return null;
        return view.keyboardNavigationClusterSearch(view2, n);
    }

    static void notifyViewAccessibilityStateChangedIfNeeded(View view, int n) {
        Object object = (AccessibilityManager)view.getContext().getSystemService("accessibility");
        if (!object.isEnabled()) {
            return;
        }
        boolean bl = ViewCompat.getAccessibilityPaneTitle(view) != null && view.getVisibility() == 0;
        int n2 = ViewCompat.getAccessibilityLiveRegion(view);
        int n3 = 32;
        if (n2 == 0 && !bl) {
            if (n == 32) {
                AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEvent);
                accessibilityEvent.setEventType(32);
                accessibilityEvent.setContentChangeTypes(n);
                accessibilityEvent.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEvent);
                accessibilityEvent.getText().add(ViewCompat.getAccessibilityPaneTitle(view));
                object.sendAccessibilityEvent(accessibilityEvent);
            } else {
                if (view.getParent() == null) return;
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, n);
                }
                catch (AbstractMethodError abstractMethodError) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(view.getParent().getClass().getSimpleName());
                    ((StringBuilder)object).append(" does not fully implement ViewParent");
                    Log.e((String)"ViewCompat", (String)((StringBuilder)object).toString(), (Throwable)abstractMethodError);
                }
            }
        } else {
            object = AccessibilityEvent.obtain();
            if (!bl) {
                n3 = 2048;
            }
            object.setEventType(n3);
            object.setContentChangeTypes(n);
            if (bl) {
                object.getText().add(ViewCompat.getAccessibilityPaneTitle(view));
                ViewCompat.setViewImportanceForAccessibilityIfNeeded(view);
            }
            view.sendAccessibilityEventUnchecked((AccessibilityEvent)object);
        }
    }

    public static void offsetLeftAndRight(View view, int n) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(n);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect rect = ViewCompat.getEmptyTempRect();
            boolean bl = false;
            ViewParent viewParent = view.getParent();
            if (viewParent instanceof View) {
                View view2 = (View)viewParent;
                rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                bl = rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ true;
            }
            ViewCompat.compatOffsetLeftAndRight(view, n);
            if (!bl) return;
            if (!rect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) return;
            ((View)viewParent).invalidate(rect);
        } else {
            ViewCompat.compatOffsetLeftAndRight(view, n);
        }
    }

    public static void offsetTopAndBottom(View view, int n) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(n);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect rect = ViewCompat.getEmptyTempRect();
            boolean bl = false;
            ViewParent viewParent = view.getParent();
            if (viewParent instanceof View) {
                View view2 = (View)viewParent;
                rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                bl = rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ true;
            }
            ViewCompat.compatOffsetTopAndBottom(view, n);
            if (!bl) return;
            if (!rect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) return;
            ((View)viewParent).invalidate(rect);
        } else {
            ViewCompat.compatOffsetTopAndBottom(view, n);
        }
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (Build.VERSION.SDK_INT < 21) return windowInsetsCompat;
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets == null) return windowInsetsCompat;
        WindowInsets windowInsets2 = view.onApplyWindowInsets(windowInsets);
        if (windowInsets2.equals((Object)windowInsets)) return windowInsetsCompat;
        return WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)windowInsets2, (View)view);
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 16) return false;
        return view.performAccessibilityAction(n, bundle);
    }

    public static ContentInfoCompat performReceiveContent(View object, ContentInfoCompat contentInfoCompat) {
        StringBuilder stringBuilder;
        if (Log.isLoggable((String)"ViewCompat", (int)3)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("performReceiveContent: ");
            stringBuilder.append(contentInfoCompat);
            stringBuilder.append(", view=");
            stringBuilder.append(object.getClass().getSimpleName());
            stringBuilder.append("[");
            stringBuilder.append(object.getId());
            stringBuilder.append("]");
            Log.d((String)"ViewCompat", (String)stringBuilder.toString());
        }
        if ((stringBuilder = (OnReceiveContentListener)object.getTag(R.id.tag_on_receive_content_listener)) == null) return ViewCompat.getFallback(object).onReceiveContent(contentInfoCompat);
        object = (contentInfoCompat = stringBuilder.onReceiveContent((View)object, contentInfoCompat)) == null ? null : ViewCompat.getFallback(object).onReceiveContent(contentInfoCompat);
        return object;
    }

    public static void postInvalidateOnAnimation(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void postInvalidateOnAnimation(View view, int n, int n2, int n3, int n4) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(n, n2, n3, n4);
        } else {
            view.postInvalidate(n, n2, n3, n4);
        }
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long l) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, l);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + l);
        }
    }

    public static void removeAccessibilityAction(View view, int n) {
        if (Build.VERSION.SDK_INT < 21) return;
        ViewCompat.removeActionWithId(n, view);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    private static void removeActionWithId(int n, View object) {
        object = ViewCompat.getActionList((View)object);
        int n2 = 0;
        while (n2 < object.size()) {
            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object.get(n2)).getId() == n) {
                object.remove(n2);
                return;
            }
            ++n2;
        }
    }

    public static void removeOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            CompatImplApi28.removeOnUnhandledKeyEventListener((View)view, (OnUnhandledKeyEventListenerCompat)onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList)view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) return;
        arrayList.remove(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() != 0) return;
        UnhandledKeyEventManager.unregisterListeningView((View)view);
    }

    public static void replaceAccessibilityAction(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            ViewCompat.removeAccessibilityAction(view, accessibilityActionCompat.getId());
        } else {
            ViewCompat.addAccessibilityAction(view, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
        }
    }

    public static void requestApplyInsets(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else {
            if (Build.VERSION.SDK_INT < 16) return;
            view.requestFitSystemWindows();
        }
    }

    public static <T extends View> T requireViewById(View view, int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T)view.requireViewById(n);
        }
        if ((view = view.findViewById(n)) == null) throw new IllegalArgumentException("ID does not reference a View inside this View");
        return (T)view;
    }

    @Deprecated
    public static int resolveSizeAndState(int n, int n2, int n3) {
        return View.resolveSizeAndState((int)n, (int)n2, (int)n3);
    }

    public static boolean restoreDefaultFocus(View view) {
        if (Build.VERSION.SDK_INT < 26) return view.requestFocus();
        return view.restoreDefaultFocus();
    }

    public static void saveAttributeDataForStyleable(View view, Context context, int[] nArray, AttributeSet attributeSet, TypedArray typedArray, int n, int n2) {
        if (Build.VERSION.SDK_INT < 29) return;
        Api29Impl.saveAttributeDataForStyleable((View)view, (Context)context, (int[])nArray, (AttributeSet)attributeSet, (TypedArray)typedArray, (int)n, (int)n2);
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat object) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = object;
        if (object == null) {
            accessibilityDelegateCompat = object;
            if (ViewCompat.getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat();
            }
        }
        object = accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge();
        view.setAccessibilityDelegate((View.AccessibilityDelegate)object);
    }

    public static void setAccessibilityHeading(View view, boolean bl) {
        ViewCompat.accessibilityHeadingProperty().set(view, (Object)bl);
    }

    public static void setAccessibilityLiveRegion(View view, int n) {
        if (Build.VERSION.SDK_INT < 19) return;
        view.setAccessibilityLiveRegion(n);
    }

    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT < 19) return;
        ViewCompat.paneTitleProperty().set(view, (Object)charSequence);
        if (charSequence != null) {
            sAccessibilityPaneVisibilityManager.addAccessibilityPane(view);
        } else {
            sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view);
        }
    }

    @Deprecated
    public static void setActivated(View view, boolean bl) {
        view.setActivated(bl);
    }

    @Deprecated
    public static void setAlpha(View view, float f) {
        view.setAlpha(f);
    }

    public static void setAutofillHints(View view, String ... stringArray) {
        if (Build.VERSION.SDK_INT < 26) return;
        view.setAutofillHints(stringArray);
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT != 21) return;
            colorStateList = view.getBackground();
            boolean bl = view.getBackgroundTintList() != null || view.getBackgroundTintMode() != null;
            if (colorStateList == null) return;
            if (!bl) return;
            if (colorStateList.isStateful()) {
                colorStateList.setState(view.getDrawableState());
            }
            view.setBackground((Drawable)colorStateList);
        } else {
            if (!(view instanceof TintableBackgroundView)) return;
            ((TintableBackgroundView)view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT != 21) return;
            mode = view.getBackground();
            boolean bl = view.getBackgroundTintList() != null || view.getBackgroundTintMode() != null;
            if (mode == null) return;
            if (!bl) return;
            if (mode.isStateful()) {
                mode.setState(view.getDrawableState());
            }
            view.setBackground((Drawable)mode);
        } else {
            if (!(view instanceof TintableBackgroundView)) return;
            ((TintableBackgroundView)view).setSupportBackgroundTintMode(mode);
        }
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean bl) {
        if (sChildrenDrawingOrderMethod == null) {
            try {
                sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.e((String)"ViewCompat", (String)"Unable to find childrenDrawingOrderEnabled", (Throwable)noSuchMethodException);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, bl);
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.e((String)"ViewCompat", (String)"Unable to invoke childrenDrawingOrderEnabled", (Throwable)invocationTargetException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Log.e((String)"ViewCompat", (String)"Unable to invoke childrenDrawingOrderEnabled", (Throwable)illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)"ViewCompat", (String)"Unable to invoke childrenDrawingOrderEnabled", (Throwable)illegalAccessException);
        }
    }

    public static void setClipBounds(View view, Rect rect) {
        if (Build.VERSION.SDK_INT < 18) return;
        view.setClipBounds(rect);
    }

    public static void setElevation(View view, float f) {
        if (Build.VERSION.SDK_INT < 21) return;
        view.setElevation(f);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean bl) {
        view.setFitsSystemWindows(bl);
    }

    public static void setFocusedByDefault(View view, boolean bl) {
        if (Build.VERSION.SDK_INT < 26) return;
        view.setFocusedByDefault(bl);
    }

    public static void setHasTransientState(View view, boolean bl) {
        if (Build.VERSION.SDK_INT < 16) return;
        view.setHasTransientState(bl);
    }

    public static void setImportantForAccessibility(View view, int n) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(n);
        } else {
            if (Build.VERSION.SDK_INT < 16) return;
            int n2 = n;
            if (n == 4) {
                n2 = 2;
            }
            view.setImportantForAccessibility(n2);
        }
    }

    public static void setImportantForAutofill(View view, int n) {
        if (Build.VERSION.SDK_INT < 26) return;
        view.setImportantForAutofill(n);
    }

    public static void setKeyboardNavigationCluster(View view, boolean bl) {
        if (Build.VERSION.SDK_INT < 26) return;
        view.setKeyboardNavigationCluster(bl);
    }

    public static void setLabelFor(View view, int n) {
        if (Build.VERSION.SDK_INT < 17) return;
        view.setLabelFor(n);
    }

    public static void setLayerPaint(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
        } else {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }
    }

    @Deprecated
    public static void setLayerType(View view, int n, Paint paint) {
        view.setLayerType(n, paint);
    }

    public static void setLayoutDirection(View view, int n) {
        if (Build.VERSION.SDK_INT < 17) return;
        view.setLayoutDirection(n);
    }

    public static void setNestedScrollingEnabled(View view, boolean bl) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(bl);
        } else {
            if (!(view instanceof NestedScrollingChild)) return;
            ((NestedScrollingChild)view).setNestedScrollingEnabled(bl);
        }
    }

    public static void setNextClusterForwardId(View view, int n) {
        if (Build.VERSION.SDK_INT < 26) return;
        view.setNextClusterForwardId(n);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build.VERSION.SDK_INT < 21) return;
        Api21Impl.setOnApplyWindowInsetsListener((View)view, (OnApplyWindowInsetsListener)onApplyWindowInsetsListener);
    }

    public static void setOnReceiveContentListener(View view, String[] object, OnReceiveContentListener onReceiveContentListener) {
        Object[] objectArray;
        block8: {
            block7: {
                if (object == null) break block7;
                objectArray = object;
                if (((String[])object).length != 0) break block8;
            }
            objectArray = null;
        }
        boolean bl = false;
        if (onReceiveContentListener != null) {
            boolean bl2 = objectArray != null;
            Preconditions.checkArgument((boolean)bl2, (Object)"When the listener is set, MIME types must also be set");
        }
        if (objectArray != null) {
            boolean bl3;
            int n = objectArray.length;
            int n2 = 0;
            while (true) {
                bl3 = bl;
                if (n2 >= n) break;
                if (objectArray[n2].startsWith("*")) {
                    bl3 = true;
                    break;
                }
                ++n2;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("A MIME type set here must not start with *: ");
            ((StringBuilder)object).append(Arrays.toString(objectArray));
            Preconditions.checkArgument((boolean)(bl3 ^ true), (Object)((StringBuilder)object).toString());
        }
        view.setTag(R.id.tag_on_receive_content_mime_types, (Object)objectArray);
        view.setTag(R.id.tag_on_receive_content_listener, (Object)onReceiveContentListener);
    }

    @Deprecated
    public static void setOverScrollMode(View view, int n) {
        view.setOverScrollMode(n);
    }

    public static void setPaddingRelative(View view, int n, int n2, int n3, int n4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(n, n2, n3, n4);
        } else {
            view.setPadding(n, n2, n3, n4);
        }
    }

    @Deprecated
    public static void setPivotX(View view, float f) {
        view.setPivotX(f);
    }

    @Deprecated
    public static void setPivotY(View view, float f) {
        view.setPivotY(f);
    }

    public static void setPointerIcon(View view, PointerIconCompat object) {
        if (Build.VERSION.SDK_INT < 24) return;
        object = object != null ? object.getPointerIcon() : null;
        view.setPointerIcon((PointerIcon)object);
    }

    @Deprecated
    public static void setRotation(View view, float f) {
        view.setRotation(f);
    }

    @Deprecated
    public static void setRotationX(View view, float f) {
        view.setRotationX(f);
    }

    @Deprecated
    public static void setRotationY(View view, float f) {
        view.setRotationY(f);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean bl) {
        view.setSaveFromParentEnabled(bl);
    }

    @Deprecated
    public static void setScaleX(View view, float f) {
        view.setScaleX(f);
    }

    @Deprecated
    public static void setScaleY(View view, float f) {
        view.setScaleY(f);
    }

    public static void setScreenReaderFocusable(View view, boolean bl) {
        ViewCompat.screenReaderFocusableProperty().set(view, (Object)bl);
    }

    public static void setScrollIndicators(View view, int n) {
        if (Build.VERSION.SDK_INT < 23) return;
        view.setScrollIndicators(n);
    }

    public static void setScrollIndicators(View view, int n, int n2) {
        if (Build.VERSION.SDK_INT < 23) return;
        view.setScrollIndicators(n, n2);
    }

    public static void setStateDescription(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT < 19) return;
        ViewCompat.stateDescriptionProperty().set(view, (Object)charSequence);
    }

    public static void setSystemGestureExclusionRects(View view, List<Rect> list) {
        if (Build.VERSION.SDK_INT < 29) return;
        view.setSystemGestureExclusionRects(list);
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT < 26) return;
        view.setTooltipText(charSequence);
    }

    public static void setTransitionName(View view, String string) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(string);
        } else {
            if (sTransitionNameMap == null) {
                sTransitionNameMap = new WeakHashMap();
            }
            sTransitionNameMap.put(view, string);
        }
    }

    @Deprecated
    public static void setTranslationX(View view, float f) {
        view.setTranslationX(f);
    }

    @Deprecated
    public static void setTranslationY(View view, float f) {
        view.setTranslationY(f);
    }

    public static void setTranslationZ(View view, float f) {
        if (Build.VERSION.SDK_INT < 21) return;
        view.setTranslationZ(f);
    }

    private static void setViewImportanceForAccessibilityIfNeeded(View view) {
        if (ViewCompat.getImportantForAccessibility(view) == 0) {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        ViewParent viewParent = view.getParent();
        while (viewParent instanceof View) {
            if (ViewCompat.getImportantForAccessibility((View)viewParent) == 4) {
                ViewCompat.setImportantForAccessibility(view, 2);
                return;
            }
            viewParent = viewParent.getParent();
        }
    }

    public static void setWindowInsetsAnimationCallback(View view, WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.setCallback((View)view, (WindowInsetsAnimationCompat.Callback)callback);
    }

    @Deprecated
    public static void setX(View view, float f) {
        view.setX(f);
    }

    @Deprecated
    public static void setY(View view, float f) {
        view.setY(f);
    }

    public static void setZ(View view, float f) {
        if (Build.VERSION.SDK_INT < 21) return;
        view.setZ(f);
    }

    public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object object, int n) {
        if (Build.VERSION.SDK_INT < 24) return view.startDrag(clipData, dragShadowBuilder, object, n);
        return view.startDragAndDrop(clipData, dragShadowBuilder, object, n);
    }

    public static boolean startNestedScroll(View view, int n) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.startNestedScroll(n);
        }
        if (!(view instanceof NestedScrollingChild)) return false;
        return ((NestedScrollingChild)view).startNestedScroll(n);
    }

    public static boolean startNestedScroll(View view, int n, int n2) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2)view).startNestedScroll(n, n2);
        }
        if (n2 != 0) return false;
        return ViewCompat.startNestedScroll(view, n);
    }

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static void stopNestedScroll(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else {
            if (!(view instanceof NestedScrollingChild)) return;
            ((NestedScrollingChild)view).stopNestedScroll();
        }
    }

    public static void stopNestedScroll(View view, int n) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2)view).stopNestedScroll(n);
        } else {
            if (n != 0) return;
            ViewCompat.stopNestedScroll(view);
        }
    }

    private static void tickleInvalidationFlag(View view) {
        float f = view.getTranslationY();
        view.setTranslationY(1.0f + f);
        view.setTranslationY(f);
    }

    public static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT < 24) return;
        view.updateDragShadow(dragShadowBuilder);
    }
}
