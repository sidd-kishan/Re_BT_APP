/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.view.NestedScrollingParent
 *  androidx.core.view.NestedScrollingParent2
 *  androidx.core.view.NestedScrollingParent3
 */
package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;

public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] nArray = sTempNestedScrollConsumed;
        if (nArray == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            nArray[0] = 0;
            nArray[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int n) {
        if (Build.VERSION.SDK_INT < 19) return;
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, n);
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean bl) {
        if (Build.VERSION.SDK_INT < 21) {
            if (!(viewParent instanceof NestedScrollingParent)) return false;
            return ((NestedScrollingParent)viewParent).onNestedFling(view, f, f2, bl);
        }
        try {
            bl = viewParent.onNestedFling(view, f, f2, bl);
            return bl;
        }
        catch (AbstractMethodError abstractMethodError) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ViewParent ");
            stringBuilder.append(viewParent);
            stringBuilder.append(" does not implement interface method onNestedFling");
            Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)abstractMethodError);
        }
        return false;
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
        if (Build.VERSION.SDK_INT < 21) {
            if (!(viewParent instanceof NestedScrollingParent)) return false;
            return ((NestedScrollingParent)viewParent).onNestedPreFling(view, f, f2);
        }
        try {
            boolean bl = viewParent.onNestedPreFling(view, f, f2);
            return bl;
        }
        catch (AbstractMethodError abstractMethodError) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ViewParent ");
            stringBuilder.append(viewParent);
            stringBuilder.append(" does not implement interface method onNestedPreFling");
            Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)abstractMethodError);
        }
        return false;
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int n, int n2, int[] nArray) {
        ViewParentCompat.onNestedPreScroll(viewParent, view, n, n2, nArray, 0);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View object, int n, int n2, int[] nArray, int n3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2)viewParent).onNestedPreScroll((View)object, n, n2, nArray, n3);
        } else {
            if (n3 != 0) return;
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll((View)object, n, n2, nArray);
                }
                catch (AbstractMethodError abstractMethodError) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("ViewParent ");
                    ((StringBuilder)object).append(viewParent);
                    ((StringBuilder)object).append(" does not implement interface method onNestedPreScroll");
                    Log.e((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)abstractMethodError);
                }
            } else {
                if (!(viewParent instanceof NestedScrollingParent)) return;
                ((NestedScrollingParent)viewParent).onNestedPreScroll((View)object, n, n2, nArray);
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int n, int n2, int n3, int n4) {
        ViewParentCompat.onNestedScroll(viewParent, view, n, n2, n3, n4, 0, ViewParentCompat.getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int n, int n2, int n3, int n4, int n5) {
        ViewParentCompat.onNestedScroll(viewParent, view, n, n2, n3, n4, n5, ViewParentCompat.getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent viewParent, View object, int n, int n2, int n3, int n4, int n5, int[] nArray) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3)viewParent).onNestedScroll((View)object, n, n2, n3, n4, n5, nArray);
        } else {
            nArray[0] = nArray[0] + n3;
            nArray[1] = nArray[1] + n4;
            if (viewParent instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2)viewParent).onNestedScroll((View)object, n, n2, n3, n4, n5);
            } else {
                if (n5 != 0) return;
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        viewParent.onNestedScroll((View)object, n, n2, n3, n4);
                    }
                    catch (AbstractMethodError abstractMethodError) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("ViewParent ");
                        ((StringBuilder)object).append(viewParent);
                        ((StringBuilder)object).append(" does not implement interface method onNestedScroll");
                        Log.e((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)abstractMethodError);
                    }
                } else {
                    if (!(viewParent instanceof NestedScrollingParent)) return;
                    ((NestedScrollingParent)viewParent).onNestedScroll((View)object, n, n2, n3, n4);
                }
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int n) {
        ViewParentCompat.onNestedScrollAccepted(viewParent, view, view2, n, 0);
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View object, int n, int n2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2)viewParent).onNestedScrollAccepted(view, (View)object, n, n2);
        } else {
            if (n2 != 0) return;
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, (View)object, n);
                }
                catch (AbstractMethodError abstractMethodError) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("ViewParent ");
                    ((StringBuilder)object).append(viewParent);
                    ((StringBuilder)object).append(" does not implement interface method onNestedScrollAccepted");
                    Log.e((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)abstractMethodError);
                }
            } else {
                if (!(viewParent instanceof NestedScrollingParent)) return;
                ((NestedScrollingParent)viewParent).onNestedScrollAccepted(view, (View)object, n);
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int n) {
        return ViewParentCompat.onStartNestedScroll(viewParent, view, view2, n, 0);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View object, View view, int n, int n2) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2)viewParent).onStartNestedScroll((View)object, view, n, n2);
        }
        if (n2 != 0) return false;
        if (Build.VERSION.SDK_INT < 21) {
            if (!(viewParent instanceof NestedScrollingParent)) return false;
            return ((NestedScrollingParent)viewParent).onStartNestedScroll((View)object, view, n);
        }
        try {
            boolean bl = viewParent.onStartNestedScroll((View)object, view, n);
            return bl;
        }
        catch (AbstractMethodError abstractMethodError) {
            object = new StringBuilder();
            ((StringBuilder)object).append("ViewParent ");
            ((StringBuilder)object).append(viewParent);
            ((StringBuilder)object).append(" does not implement interface method onStartNestedScroll");
            Log.e((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)abstractMethodError);
        }
        return false;
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        ViewParentCompat.onStopNestedScroll(viewParent, view, 0);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View object, int n) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2)viewParent).onStopNestedScroll((View)object, n);
        } else {
            if (n != 0) return;
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll((View)object);
                }
                catch (AbstractMethodError abstractMethodError) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("ViewParent ");
                    ((StringBuilder)object).append(viewParent);
                    ((StringBuilder)object).append(" does not implement interface method onStopNestedScroll");
                    Log.e((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)abstractMethodError);
                }
            } else {
                if (!(viewParent instanceof NestedScrollingParent)) return;
                ((NestedScrollingParent)viewParent).onStopNestedScroll((View)object);
            }
        }
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
