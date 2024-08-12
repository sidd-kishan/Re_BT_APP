/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.lifecycle.LifecycleRegistryOwner
 *  androidx.lifecycle.ReportFragment$ActivityInitializationListener
 *  androidx.lifecycle.ReportFragment$LifecycleCallbacks
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleRegistryOwner;
import androidx.lifecycle.ReportFragment;

/*
 * Exception performing whole class analysis ignored.
 */
public class ReportFragment
extends Fragment {
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener mProcessListener;

    static void dispatch(Activity activity, Lifecycle.Event event) {
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner)activity).getLifecycle().handleLifecycleEvent(event);
            return;
        }
        if (!(activity instanceof LifecycleOwner)) return;
        if (!((activity = ((LifecycleOwner)activity).getLifecycle()) instanceof LifecycleRegistry)) return;
        ((LifecycleRegistry)activity).handleLifecycleEvent(event);
    }

    private void dispatch(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT >= 29) return;
        ReportFragment.dispatch(this.getActivity(), event);
    }

    private void dispatchCreate(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener == null) return;
        activityInitializationListener.onCreate();
    }

    private void dispatchResume(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener == null) return;
        activityInitializationListener.onResume();
    }

    private void dispatchStart(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener == null) return;
        activityInitializationListener.onStart();
    }

    static ReportFragment get(Activity activity) {
        return (ReportFragment)activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void injectIfNeededIn(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            LifecycleCallbacks.registerIn((Activity)activity);
        }
        if ((activity = activity.getFragmentManager()).findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") != null) return;
        activity.beginTransaction().add((Fragment)new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
        activity.executePendingTransactions();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dispatchCreate(this.mProcessListener);
        this.dispatch(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        this.dispatch(Lifecycle.Event.ON_DESTROY);
        this.mProcessListener = null;
    }

    public void onPause() {
        super.onPause();
        this.dispatch(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        this.dispatchResume(this.mProcessListener);
        this.dispatch(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        this.dispatchStart(this.mProcessListener);
        this.dispatch(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        this.dispatch(Lifecycle.Event.ON_STOP);
    }

    void setProcessListener(ActivityInitializationListener activityInitializationListener) {
        this.mProcessListener = activityInitializationListener;
    }
}
