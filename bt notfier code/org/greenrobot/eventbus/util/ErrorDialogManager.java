/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Log
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
 *  org.greenrobot.eventbus.util.ErrorDialogManager$HoneycombManagerFragment
 *  org.greenrobot.eventbus.util.ErrorDialogManager$SupportManagerFragment
 *  org.greenrobot.eventbus.util.ThrowableFailureEvent
 */
package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.io.Serializable;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.util.ErrorDialogFragmentFactory;
import org.greenrobot.eventbus.util.ErrorDialogManager;
import org.greenrobot.eventbus.util.ThrowableFailureEvent;

/*
 * Exception performing whole class analysis ignored.
 */
public class ErrorDialogManager {
    public static final String KEY_EVENT_TYPE_ON_CLOSE = "de.greenrobot.eventbus.errordialog.event_type_on_close";
    public static final String KEY_FINISH_AFTER_DIALOG = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
    public static final String KEY_ICON_ID = "de.greenrobot.eventbus.errordialog.icon_id";
    public static final String KEY_MESSAGE = "de.greenrobot.eventbus.errordialog.message";
    public static final String KEY_TITLE = "de.greenrobot.eventbus.errordialog.title";
    protected static final String TAG_ERROR_DIALOG = "de.greenrobot.eventbus.error_dialog";
    protected static final String TAG_ERROR_DIALOG_MANAGER = "de.greenrobot.eventbus.error_dialog_manager";
    public static ErrorDialogFragmentFactory<?> factory;

    static /* synthetic */ boolean access$000(Object object, ThrowableFailureEvent throwableFailureEvent) {
        return ErrorDialogManager.isInExecutionScope(object, throwableFailureEvent);
    }

    public static void attachTo(Activity activity) {
        ErrorDialogManager.attachTo(activity, false, null);
    }

    public static void attachTo(Activity activity, Object object, boolean bl, Bundle bundle) {
        if (factory == null) throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
        if (ErrorDialogManager.isSupportActivity(activity)) {
            SupportManagerFragment.attachTo((Activity)activity, (Object)object, (boolean)bl, (Bundle)bundle);
        } else {
            HoneycombManagerFragment.attachTo((Activity)activity, (Object)object, (boolean)bl, (Bundle)bundle);
        }
    }

    public static void attachTo(Activity activity, boolean bl) {
        ErrorDialogManager.attachTo(activity, bl, null);
    }

    public static void attachTo(Activity activity, boolean bl, Bundle bundle) {
        ErrorDialogManager.attachTo(activity, activity.getClass(), bl, bundle);
    }

    protected static void checkLogException(ThrowableFailureEvent throwableFailureEvent) {
        String string;
        if (!ErrorDialogManager.factory.config.logExceptions) return;
        String string2 = string = ErrorDialogManager.factory.config.tagForLoggingExceptions;
        if (string == null) {
            string2 = EventBus.TAG;
        }
        Log.i((String)string2, (String)"Error dialog manager received exception", (Throwable)throwableFailureEvent.throwable);
    }

    private static boolean isInExecutionScope(Object object, ThrowableFailureEvent object2) {
        if (object2 == null) return true;
        if ((object2 = object2.getExecutionScope()) == null) return true;
        if (object2.equals(object)) return true;
        return false;
    }

    private static boolean isSupportActivity(Activity object) {
        boolean bl;
        block3: {
            String string;
            Serializable serializable = object.getClass();
            do {
                if ((serializable = ((Class)serializable).getSuperclass()) == null) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("Illegal activity type: ");
                    ((StringBuilder)serializable).append(object.getClass());
                    object = new RuntimeException(((StringBuilder)serializable).toString());
                    throw object;
                }
                string = ((Class)serializable).getName();
                if (string.equals("androidx.fragment.app.FragmentActivity")) {
                    bl = true;
                    break block3;
                }
                if (!string.startsWith("com.actionbarsherlock.app") || !string.endsWith(".SherlockActivity") && !string.endsWith(".SherlockListActivity") && !string.endsWith(".SherlockPreferenceActivity")) continue;
                object = new StringBuilder();
                ((StringBuilder)object).append("Please use SherlockFragmentActivity. Illegal activity: ");
                ((StringBuilder)object).append(string);
                throw new RuntimeException(((StringBuilder)object).toString());
            } while (!string.equals("android.app.Activity"));
            if (Build.VERSION.SDK_INT < 11) throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
            bl = false;
        }
        return bl;
    }
}
