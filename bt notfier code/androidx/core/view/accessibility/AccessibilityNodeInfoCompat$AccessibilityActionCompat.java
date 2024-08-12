/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 *  androidx.core.view.accessibility.AccessibilityViewCommand
 *  androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
 *  androidx.core.view.accessibility.AccessibilityViewCommand$MoveAtGranularityArguments
 *  androidx.core.view.accessibility.AccessibilityViewCommand$MoveHtmlArguments
 *  androidx.core.view.accessibility.AccessibilityViewCommand$MoveWindowArguments
 *  androidx.core.view.accessibility.AccessibilityViewCommand$ScrollToPositionArguments
 *  androidx.core.view.accessibility.AccessibilityViewCommand$SetProgressArguments
 *  androidx.core.view.accessibility.AccessibilityViewCommand$SetSelectionArguments
 *  androidx.core.view.accessibility.AccessibilityViewCommand$SetTextArguments
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.io.Serializable;

public static class AccessibilityNodeInfoCompat.AccessibilityActionCompat {
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_FOCUS;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_SELECTION;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLICK;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COLLAPSE;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CONTEXT_CLICK;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COPY;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CUT;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_DISMISS;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_EXPAND;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_FOCUS;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_IME_ENTER;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_LONG_CLICK;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_MOVE_WINDOW;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_DOWN;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_LEFT;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_RIGHT;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_UP;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PASTE;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_DOWN;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_FORWARD;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_LEFT;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_RIGHT;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_UP;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SELECT;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_PROGRESS;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_SELECTION;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_TEXT;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
    public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
    private static final String TAG = "A11yActionCompat";
    final Object mAction;
    protected final AccessibilityViewCommand mCommand;
    private final int mId;
    private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

    static {
        Object var1 = null;
        ACTION_FOCUS = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1, null);
        ACTION_CLEAR_FOCUS = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2, null);
        ACTION_SELECT = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(4, null);
        ACTION_CLEAR_SELECTION = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(8, null);
        ACTION_CLICK = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, null);
        ACTION_LONG_CLICK = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, null);
        ACTION_ACCESSIBILITY_FOCUS = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(64, null);
        ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(128, null);
        ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(256, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
        ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(512, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
        ACTION_NEXT_HTML_ELEMENT = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1024, null, AccessibilityViewCommand.MoveHtmlArguments.class);
        ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2048, null, AccessibilityViewCommand.MoveHtmlArguments.class);
        ACTION_SCROLL_FORWARD = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(4096, null);
        ACTION_SCROLL_BACKWARD = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(8192, null);
        ACTION_COPY = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, null);
        ACTION_PASTE = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, null);
        ACTION_CUT = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, null);
        ACTION_SET_SELECTION = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, null, AccessibilityViewCommand.SetSelectionArguments.class);
        ACTION_EXPAND = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, null);
        ACTION_COLLAPSE = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, null);
        ACTION_DISMISS = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(0x100000, null);
        ACTION_SET_TEXT = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(0x200000, null, AccessibilityViewCommand.SetTextArguments.class);
        Object object = Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null;
        ACTION_SHOW_ON_SCREEN = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908342, null, null, null);
        object = Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null;
        ACTION_SCROLL_TO_POSITION = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908343, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
        object = Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null;
        ACTION_SCROLL_UP = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908344, null, null, null);
        object = Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null;
        ACTION_SCROLL_LEFT = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908345, null, null, null);
        object = Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null;
        ACTION_SCROLL_DOWN = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908346, null, null, null);
        object = Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null;
        ACTION_SCROLL_RIGHT = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908347, null, null, null);
        object = Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null;
        ACTION_PAGE_UP = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908358, null, null, null);
        object = Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null;
        ACTION_PAGE_DOWN = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908359, null, null, null);
        object = Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null;
        ACTION_PAGE_LEFT = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908360, null, null, null);
        object = Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null;
        ACTION_PAGE_RIGHT = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908361, null, null, null);
        object = Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null;
        ACTION_CONTEXT_CLICK = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908348, null, null, null);
        object = Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null;
        ACTION_SET_PROGRESS = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908349, null, null, AccessibilityViewCommand.SetProgressArguments.class);
        object = Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null;
        ACTION_MOVE_WINDOW = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908354, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
        object = Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null;
        ACTION_SHOW_TOOLTIP = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908356, null, null, null);
        object = Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null;
        ACTION_HIDE_TOOLTIP = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908357, null, null, null);
        object = Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null;
        ACTION_PRESS_AND_HOLD = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908362, null, null, null);
        object = var1;
        if (Build.VERSION.SDK_INT >= 30) {
            object = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
        }
        ACTION_IME_ENTER = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(object, 16908372, null, null, null);
    }

    public AccessibilityNodeInfoCompat.AccessibilityActionCompat(int n, CharSequence charSequence) {
        this(null, n, charSequence, null, null);
    }

    public AccessibilityNodeInfoCompat.AccessibilityActionCompat(int n, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        this(null, n, charSequence, accessibilityViewCommand, null);
    }

    private AccessibilityNodeInfoCompat.AccessibilityActionCompat(int n, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> clazz) {
        this(null, n, charSequence, null, clazz);
    }

    AccessibilityNodeInfoCompat.AccessibilityActionCompat(Object object) {
        this(object, 0, null, null, null);
    }

    AccessibilityNodeInfoCompat.AccessibilityActionCompat(Object object, int n, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> clazz) {
        this.mId = n;
        this.mCommand = accessibilityViewCommand;
        this.mAction = Build.VERSION.SDK_INT >= 21 && object == null ? new AccessibilityNodeInfo.AccessibilityAction(n, charSequence) : object;
        this.mViewCommandArgumentClass = clazz;
    }

    public AccessibilityNodeInfoCompat.AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        return new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof AccessibilityNodeInfoCompat.AccessibilityActionCompat)) {
            return false;
        }
        object = (AccessibilityNodeInfoCompat.AccessibilityActionCompat)object;
        Object object2 = this.mAction;
        if (object2 == null) {
            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object).mAction == null) return true;
            return false;
        }
        if (object2.equals(((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object).mAction)) return true;
        return false;
    }

    public int getId() {
        if (Build.VERSION.SDK_INT < 21) return 0;
        return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getId();
    }

    public CharSequence getLabel() {
        if (Build.VERSION.SDK_INT < 21) return null;
        return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getLabel();
    }

    public int hashCode() {
        Object object = this.mAction;
        int n = object != null ? object.hashCode() : 0;
        return n;
    }

    public boolean perform(View view, Bundle bundle) {
        Object object;
        block5: {
            Serializable serializable;
            Object object2;
            block4: {
                if (this.mCommand == null) return false;
                object = null;
                object2 = null;
                serializable = this.mViewCommandArgumentClass;
                if (serializable == null) return this.mCommand.perform(view, object);
                try {
                    object = ((Class)serializable).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                }
                catch (Exception exception) {
                    bundle = object2;
                    break block4;
                }
                try {
                    object.setBundle(bundle);
                    break block5;
                }
                catch (Exception exception) {
                    bundle = object;
                    object = exception;
                }
            }
            object2 = this.mViewCommandArgumentClass;
            object2 = object2 == null ? "null" : ((Class)object2).getName();
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Failed to execute command with argument class ViewCommandArgument: ");
            ((StringBuilder)serializable).append((String)object2);
            Log.e((String)TAG, (String)((StringBuilder)serializable).toString(), (Throwable)object);
            object = bundle;
        }
        return this.mCommand.perform(view, object);
    }
}
