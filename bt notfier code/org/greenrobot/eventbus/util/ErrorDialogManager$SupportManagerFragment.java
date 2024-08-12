/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.util.ErrorDialogManager
 *  org.greenrobot.eventbus.util.ThrowableFailureEvent
 */
package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.util.ErrorDialogManager;
import org.greenrobot.eventbus.util.ThrowableFailureEvent;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ErrorDialogManager.SupportManagerFragment
extends Fragment {
    protected Bundle argumentsForErrorDialog;
    private EventBus eventBus;
    private Object executionScope;
    protected boolean finishAfterDialog;
    private boolean skipRegisterOnNextResume;

    public static void attachTo(Activity object, Object object2, boolean bl, Bundle bundle) {
        FragmentManager fragmentManager = ((FragmentActivity)object).getSupportFragmentManager();
        ErrorDialogManager.SupportManagerFragment supportManagerFragment = (ErrorDialogManager.SupportManagerFragment)fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
        object = supportManagerFragment;
        if (supportManagerFragment == null) {
            object = new ErrorDialogManager.SupportManagerFragment();
            fragmentManager.beginTransaction().add((Fragment)object, "de.greenrobot.eventbus.error_dialog_manager").commit();
            fragmentManager.executePendingTransactions();
        }
        object.finishAfterDialog = bl;
        object.argumentsForErrorDialog = bundle;
        object.executionScope = object2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = ErrorDialogManager.factory.config.getEventBus();
        this.eventBus = bundle;
        bundle.register((Object)this);
        this.skipRegisterOnNextResume = true;
    }

    public void onEventMainThread(ThrowableFailureEvent throwableFailureEvent) {
        if (!ErrorDialogManager.access$000((Object)this.executionScope, (ThrowableFailureEvent)throwableFailureEvent)) {
            return;
        }
        ErrorDialogManager.checkLogException((ThrowableFailureEvent)throwableFailureEvent);
        FragmentManager fragmentManager = this.getFragmentManager();
        fragmentManager.executePendingTransactions();
        DialogFragment dialogFragment = (DialogFragment)fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        if ((throwableFailureEvent = (DialogFragment)ErrorDialogManager.factory.prepareErrorFragment(throwableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog)) == null) return;
        throwableFailureEvent.show(fragmentManager, "de.greenrobot.eventbus.error_dialog");
    }

    public void onPause() {
        this.eventBus.unregister((Object)this);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.skipRegisterOnNextResume) {
            this.skipRegisterOnNextResume = false;
        } else {
            EventBus eventBus;
            this.eventBus = eventBus = ErrorDialogManager.factory.config.getEventBus();
            eventBus.register((Object)this);
        }
    }
}
