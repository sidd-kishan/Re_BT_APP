/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentContainer
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.Observer
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.lifecycle.ViewTreeLifecycleOwner
 *  androidx.lifecycle.ViewTreeViewModelStoreOwner
 *  androidx.savedstate.SavedStateRegistryOwner
 *  androidx.savedstate.ViewTreeSavedStateRegistryOwner
 */
package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class DialogFragment
extends Fragment
implements DialogInterface.OnCancelListener,
DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId = -1;
    private boolean mCancelable = true;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDialogCreated = false;
    private Runnable mDismissRunnable = new /* Unavailable Anonymous Inner Class!! */;
    private boolean mDismissed;
    private Handler mHandler;
    private Observer<LifecycleOwner> mObserver;
    private DialogInterface.OnCancelListener mOnCancelListener = new /* Unavailable Anonymous Inner Class!! */;
    private DialogInterface.OnDismissListener mOnDismissListener = new /* Unavailable Anonymous Inner Class!! */;
    private boolean mShownByMe;
    private boolean mShowsDialog = true;
    private int mStyle = 0;
    private int mTheme = 0;
    private boolean mViewDestroyed;

    public DialogFragment() {
        this.mObserver = new /* Unavailable Anonymous Inner Class!! */;
    }

    public DialogFragment(int n) {
        super(n);
        this.mObserver = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ Dialog access$000(DialogFragment dialogFragment) {
        return dialogFragment.mDialog;
    }

    static /* synthetic */ DialogInterface.OnDismissListener access$100(DialogFragment dialogFragment) {
        return dialogFragment.mOnDismissListener;
    }

    static /* synthetic */ boolean access$200(DialogFragment dialogFragment) {
        return dialogFragment.mShowsDialog;
    }

    private void dismissInternal(boolean bl, boolean bl2) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!bl2) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    this.onDismiss((DialogInterface)this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            this.getParentFragmentManager().popBackStack(this.mBackStackId, 1);
            this.mBackStackId = -1;
        } else {
            dialog = this.getParentFragmentManager().beginTransaction();
            dialog.remove((Fragment)this);
            if (bl) {
                dialog.commitAllowingStateLoss();
            } else {
                dialog.commit();
            }
        }
    }

    private void prepareDialog(Bundle bundle) {
        if (!this.mShowsDialog) {
            return;
        }
        if (this.mDialogCreated) return;
        try {
            this.mCreatingDialog = true;
            bundle = this.onCreateDialog(bundle);
            this.mDialog = bundle;
            if (this.mShowsDialog) {
                this.setupDialog((Dialog)bundle, this.mStyle);
                bundle = this.getContext();
                if (bundle instanceof Activity) {
                    this.mDialog.setOwnerActivity((Activity)bundle);
                }
                this.mDialog.setCancelable(this.mCancelable);
                this.mDialog.setOnCancelListener(this.mOnCancelListener);
                this.mDialog.setOnDismissListener(this.mOnDismissListener);
                this.mDialogCreated = true;
            } else {
                this.mDialog = null;
            }
        }
        finally {
            this.mCreatingDialog = false;
        }
    }

    FragmentContainer createFragmentContainer() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public void dismiss() {
        this.dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        this.dismissInternal(true, false);
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (this.mShownByMe) return;
        this.mDismissed = false;
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        boolean bl = this.mContainerId == 0;
        this.mShowsDialog = bl;
        if (bundle == null) return;
        this.mStyle = bundle.getInt(SAVED_STYLE, 0);
        this.mTheme = bundle.getInt(SAVED_THEME, 0);
        this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
        this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
        this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
    }

    public Dialog onCreateDialog(Bundle object) {
        if (!FragmentManager.isLoggingEnabled((int)3)) return new Dialog(this.requireContext(), this.getTheme());
        object = new StringBuilder();
        ((StringBuilder)object).append("onCreateDialog called for DialogFragment ");
        ((StringBuilder)object).append((Object)this);
        Log.d((String)"FragmentManager", (String)((StringBuilder)object).toString());
        return new Dialog(this.requireContext(), this.getTheme());
    }

    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog == null) return;
        this.mViewDestroyed = true;
        dialog.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (!this.mDismissed) {
            this.onDismiss((DialogInterface)this.mDialog);
        }
        this.mDialog = null;
        this.mDialogCreated = false;
    }

    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        this.getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
    }

    public void onDismiss(DialogInterface object) {
        if (this.mViewDestroyed) return;
        if (FragmentManager.isLoggingEnabled((int)3)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onDismiss called for DialogFragment ");
            ((StringBuilder)object).append((Object)this);
            Log.d((String)"FragmentManager", (String)((StringBuilder)object).toString());
        }
        this.dismissInternal(true, true);
    }

    View onFindViewById(int n) {
        Dialog dialog = this.mDialog;
        if (dialog == null) return null;
        return dialog.findViewById(n);
    }

    public LayoutInflater onGetLayoutInflater(Bundle object) {
        LayoutInflater layoutInflater = super.onGetLayoutInflater((Bundle)object);
        if (this.mShowsDialog && !this.mCreatingDialog) {
            this.prepareDialog((Bundle)object);
            if (FragmentManager.isLoggingEnabled((int)2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("get layout inflater for DialogFragment ");
                ((StringBuilder)object).append((Object)this);
                ((StringBuilder)object).append(" from dialog context");
                Log.d((String)"FragmentManager", (String)((StringBuilder)object).toString());
            }
            Dialog dialog = this.mDialog;
            object = layoutInflater;
            if (dialog == null) return object;
            object = layoutInflater.cloneInContext(dialog.getContext());
            return object;
        }
        if (!FragmentManager.isLoggingEnabled((int)2)) return layoutInflater;
        object = new StringBuilder();
        ((StringBuilder)object).append("getting layout inflater for DialogFragment ");
        ((StringBuilder)object).append((Object)this);
        object = ((StringBuilder)object).toString();
        if (!this.mShowsDialog) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mShowsDialog = false: ");
            stringBuilder.append((String)object);
            Log.d((String)"FragmentManager", (String)stringBuilder.toString());
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mCreatingDialog = true: ");
            stringBuilder.append((String)object);
            Log.d((String)"FragmentManager", (String)stringBuilder.toString());
        }
        return layoutInflater;
    }

    boolean onHasView() {
        return this.mDialogCreated;
    }

    public void onSaveInstanceState(Bundle bundle) {
        boolean bl;
        int n;
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog = dialog.onSaveInstanceState();
            dialog.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, (Bundle)dialog);
        }
        if ((n = this.mStyle) != 0) {
            bundle.putInt(SAVED_STYLE, n);
        }
        if ((n = this.mTheme) != 0) {
            bundle.putInt(SAVED_THEME, n);
        }
        if (!(bl = this.mCancelable)) {
            bundle.putBoolean(SAVED_CANCELABLE, bl);
        }
        if (!(bl = this.mShowsDialog)) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, bl);
        }
        if ((n = this.mBackStackId) == -1) return;
        bundle.putInt(SAVED_BACK_STACK_ID, n);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog == null) return;
        this.mViewDestroyed = false;
        dialog.show();
        dialog = this.mDialog.getWindow().getDecorView();
        ViewTreeLifecycleOwner.set((View)dialog, (LifecycleOwner)this);
        ViewTreeViewModelStoreOwner.set((View)dialog, (ViewModelStoreOwner)this);
        ViewTreeSavedStateRegistryOwner.set((View)dialog, (SavedStateRegistryOwner)this);
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog == null) return;
        dialog.hide();
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (this.mDialog == null) return;
        if (bundle == null) return;
        if ((bundle = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) return;
        this.mDialog.onRestoreInstanceState(bundle);
    }

    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null) return;
        if (this.mDialog == null) return;
        if (bundle == null) return;
        layoutInflater = bundle.getBundle(SAVED_DIALOG_STATE_TAG);
        if (layoutInflater == null) return;
        this.mDialog.onRestoreInstanceState((Bundle)layoutInflater);
    }

    public final Dialog requireDialog() {
        Object object = this.getDialog();
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("DialogFragment ");
        ((StringBuilder)object).append((Object)this);
        ((StringBuilder)object).append(" does not have a Dialog.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public void setCancelable(boolean bl) {
        this.mCancelable = bl;
        Dialog dialog = this.mDialog;
        if (dialog == null) return;
        dialog.setCancelable(bl);
    }

    public void setShowsDialog(boolean bl) {
        this.mShowsDialog = bl;
    }

    public void setStyle(int n, int n2) {
        if (FragmentManager.isLoggingEnabled((int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Setting style and theme for DialogFragment ");
            stringBuilder.append((Object)this);
            stringBuilder.append(" to ");
            stringBuilder.append(n);
            stringBuilder.append(", ");
            stringBuilder.append(n2);
            Log.d((String)"FragmentManager", (String)stringBuilder.toString());
        }
        this.mStyle = n;
        if (n == 2 || n == 3) {
            this.mTheme = 16973913;
        }
        if (n2 == 0) return;
        this.mTheme = n2;
    }

    public void setupDialog(Dialog dialog, int n) {
        if (n != 1 && n != 2) {
            if (n != 3) return;
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public int show(FragmentTransaction fragmentTransaction, String string) {
        int n;
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentTransaction.add((Fragment)this, string);
        this.mViewDestroyed = false;
        this.mBackStackId = n = fragmentTransaction.commit();
        return n;
    }

    public void show(FragmentManager fragmentManager, String string) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentManager = fragmentManager.beginTransaction();
        fragmentManager.add((Fragment)this, string);
        fragmentManager.commit();
    }

    public void showNow(FragmentManager fragmentManager, String string) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentManager = fragmentManager.beginTransaction();
        fragmentManager.add((Fragment)this, string);
        fragmentManager.commitNow();
    }
}
