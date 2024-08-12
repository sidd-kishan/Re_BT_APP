/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.os.Build$VERSION
 *  android.view.KeyEvent
 *  android.view.KeyEvent$Callback
 *  android.view.KeyEvent$DispatcherState
 *  android.view.View
 *  android.view.Window
 *  android.view.Window$Callback
 *  androidx.core.view.KeyEventDispatcher$Component
 *  androidx.core.view.ViewCompat
 */
package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeyEventDispatcher {
    private static boolean sActionBarFieldsFetched;
    private static Method sActionBarOnMenuKeyMethod;
    private static boolean sDialogFieldsFetched;
    private static Field sDialogKeyListenerField;

    private KeyEventDispatcher() {
    }

    /*
     * Unable to fully structure code
     */
    private static boolean actionBarOnMenuKeyEventPre28(ActionBar var0, KeyEvent var1_2) {
        block6: {
            block5: {
                if (KeyEventDispatcher.sActionBarFieldsFetched) ** GOTO lbl-1000
                try {
                    KeyEventDispatcher.sActionBarOnMenuKeyMethod = var0.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});
lbl4:
                    // 2 sources

                    while (true) {
                        KeyEventDispatcher.sActionBarFieldsFetched = true;
                        break;
                    }
                }
                catch (NoSuchMethodException var3_3) {
                    ** continue;
                }
lbl-1000:
                // 2 sources

                {
                    if ((var3_4 = KeyEventDispatcher.sActionBarOnMenuKeyMethod) == null) return false;
                    ** try [egrp 1[TRYBLOCK] [1, 2 : 39->59)] { 
lbl10:
                    // 1 sources

                    break block5;
lbl11:
                    // 2 sources

                    catch (IllegalAccessException | InvocationTargetException var0_1) {
                        break block6;
                    }
                }
            }
            var2_5 = (Boolean)var3_4.invoke(var0, new Object[]{var1_2});
            return var2_5;
        }
        return false;
    }

    private static boolean activitySuperDispatchKeyEventPre28(Activity activity, KeyEvent keyEvent) {
        Object object;
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            object = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && object != null && KeyEventDispatcher.actionBarOnMenuKeyEventPre28(object, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        object = window.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback((View)object, (KeyEvent)keyEvent)) {
            return true;
        }
        object = object != null ? object.getKeyDispatcherState() : null;
        return keyEvent.dispatch((KeyEvent.Callback)activity, (KeyEvent.DispatcherState)object, (Object)activity);
    }

    private static boolean dialogSuperDispatchKeyEventPre28(Dialog dialog, KeyEvent keyEvent) {
        Object object = KeyEventDispatcher.getDialogKeyListenerPre28(dialog);
        if (object != null && object.onKey((DialogInterface)dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        object = dialog.getWindow();
        if (object.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback((View)(object = object.getDecorView()), (KeyEvent)keyEvent)) {
            return true;
        }
        object = object != null ? object.getKeyDispatcherState() : null;
        return keyEvent.dispatch((KeyEvent.Callback)dialog, (KeyEvent.DispatcherState)object, (Object)dialog);
    }

    public static boolean dispatchBeforeHierarchy(View view, KeyEvent keyEvent) {
        return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy((View)view, (KeyEvent)keyEvent);
    }

    public static boolean dispatchKeyEvent(Component component, View view, Window.Callback callback, KeyEvent keyEvent) {
        boolean bl = false;
        if (component == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return component.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return KeyEventDispatcher.activitySuperDispatchKeyEventPre28((Activity)callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return KeyEventDispatcher.dialogSuperDispatchKeyEventPre28((Dialog)callback, keyEvent);
        }
        if (view == null || !ViewCompat.dispatchUnhandledKeyEventBeforeCallback((View)view, (KeyEvent)keyEvent)) {
            if (!component.superDispatchKeyEvent(keyEvent)) return bl;
        }
        bl = true;
        return bl;
    }

    /*
     * Unable to fully structure code
     */
    private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog var0) {
        block6: {
            if (KeyEventDispatcher.sDialogFieldsFetched) ** GOTO lbl-1000
            try {
                KeyEventDispatcher.sDialogKeyListenerField = var1_2 = Dialog.class.getDeclaredField("mOnKeyListener");
                var1_2.setAccessible(true);
lbl5:
                // 2 sources

                while (true) {
                    KeyEventDispatcher.sDialogFieldsFetched = true;
                    break;
                }
            }
            catch (NoSuchFieldException var1_3) {
                ** continue;
            }
lbl-1000:
            // 2 sources

            {
                if ((var1_2 = KeyEventDispatcher.sDialogKeyListenerField) == null) return null;
                try {}
                catch (IllegalAccessException var0_1) {
                    break block6;
                }
            }
            var0 = (DialogInterface.OnKeyListener)var1_2.get(var0);
            return var0;
        }
        return null;
    }
}
