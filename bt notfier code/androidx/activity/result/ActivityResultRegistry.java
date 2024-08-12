/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  androidx.activity.result.ActivityResult
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.activity.result.ActivityResultRegistry$CallbackAndContract
 *  androidx.activity.result.ActivityResultRegistry$LifecycleContainer
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.core.app.ActivityOptionsCompat
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    final transient Map<String, CallbackAndContract<?>> mKeyToCallback;
    private final Map<String, LifecycleContainer> mKeyToLifecycleContainers;
    final Map<String, Integer> mKeyToRc;
    ArrayList<String> mLaunchedKeys;
    final Map<String, Object> mParsedPendingResults;
    final Bundle mPendingResults;
    private Random mRandom = new Random();
    private final Map<Integer, String> mRcToKey = new HashMap<Integer, String>();

    public ActivityResultRegistry() {
        this.mKeyToRc = new HashMap<String, Integer>();
        this.mKeyToLifecycleContainers = new HashMap<String, LifecycleContainer>();
        this.mLaunchedKeys = new ArrayList();
        this.mKeyToCallback = new HashMap();
        this.mParsedPendingResults = new HashMap<String, Object>();
        this.mPendingResults = new Bundle();
    }

    private void bindRcKey(int n, String string) {
        this.mRcToKey.put(n, string);
        this.mKeyToRc.put(string, n);
    }

    private <O> void doDispatch(String string, int n, Intent intent, CallbackAndContract<O> callbackAndContract) {
        if (callbackAndContract != null && callbackAndContract.mCallback != null) {
            callbackAndContract.mCallback.onActivityResult(callbackAndContract.mContract.parseResult(n, intent));
        } else {
            this.mParsedPendingResults.remove(string);
            this.mPendingResults.putParcelable(string, (Parcelable)new ActivityResult(n, intent));
        }
    }

    private int generateRandomNumber() {
        int n = this.mRandom.nextInt(0x7FFF0000);
        while (this.mRcToKey.containsKey(n += 65536)) {
            n = this.mRandom.nextInt(0x7FFF0000);
        }
        return n;
    }

    private int registerKey(String string) {
        Integer n = this.mKeyToRc.get(string);
        if (n != null) {
            return n;
        }
        int n2 = this.generateRandomNumber();
        this.bindRcKey(n2, string);
        return n2;
    }

    public final boolean dispatchResult(int n, int n2, Intent intent) {
        String string = this.mRcToKey.get(n);
        if (string == null) {
            return false;
        }
        this.mLaunchedKeys.remove(string);
        this.doDispatch(string, n2, intent, this.mKeyToCallback.get(string));
        return true;
    }

    public final <O> boolean dispatchResult(int n, O o) {
        String string = this.mRcToKey.get(n);
        if (string == null) {
            return false;
        }
        this.mLaunchedKeys.remove(string);
        CallbackAndContract<?> callbackAndContract = this.mKeyToCallback.get(string);
        if (callbackAndContract != null && callbackAndContract.mCallback != null) {
            callbackAndContract.mCallback.onActivityResult(o);
        } else {
            this.mPendingResults.remove(string);
            this.mParsedPendingResults.put(string, o);
        }
        return true;
    }

    public abstract <I, O> void onLaunch(int var1, ActivityResultContract<I, O> var2, I var3, ActivityOptionsCompat var4);

    public final void onRestoreInstanceState(Bundle object) {
        if (object == null) {
            return;
        }
        ArrayList arrayList = object.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList arrayList2 = object.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (arrayList2 == null) return;
        if (arrayList == null) {
            return;
        }
        this.mLaunchedKeys = object.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        this.mRandom = (Random)object.getSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT);
        this.mPendingResults.putAll(object.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
        int n = 0;
        while (n < arrayList2.size()) {
            String string = (String)arrayList2.get(n);
            if (this.mKeyToRc.containsKey(string)) {
                object = this.mKeyToRc.remove(string);
                if (!this.mPendingResults.containsKey(string)) {
                    this.mRcToKey.remove(object);
                }
            }
            this.bindRcKey((Integer)arrayList.get(n), (String)arrayList2.get(n));
            ++n;
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList<Integer>(this.mKeyToRc.values()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList<String>(this.mKeyToRc.keySet()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList<String>(this.mLaunchedKeys));
        bundle.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (Bundle)this.mPendingResults.clone());
        bundle.putSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT, (Serializable)this.mRandom);
    }

    public final <I, O> ActivityResultLauncher<I> register(String string, ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        Object object;
        int n = this.registerKey(string);
        this.mKeyToCallback.put(string, new CallbackAndContract(activityResultCallback, activityResultContract));
        if (this.mParsedPendingResults.containsKey(string)) {
            object = this.mParsedPendingResults.get(string);
            this.mParsedPendingResults.remove(string);
            activityResultCallback.onActivityResult(object);
        }
        if ((object = (ActivityResult)this.mPendingResults.getParcelable(string)) == null) return new /* Unavailable Anonymous Inner Class!! */;
        this.mPendingResults.remove(string);
        activityResultCallback.onActivityResult(activityResultContract.parseResult(object.getResultCode(), object.getData()));
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public final <I, O> ActivityResultLauncher<I> register(String charSequence, LifecycleOwner lifecycleOwner, ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("LifecycleOwner ");
            ((StringBuilder)charSequence).append(lifecycleOwner);
            ((StringBuilder)charSequence).append(" is attempting to register while current state is ");
            ((StringBuilder)charSequence).append(lifecycle.getCurrentState());
            ((StringBuilder)charSequence).append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(((StringBuilder)charSequence).toString());
        }
        int n = this.registerKey((String)charSequence);
        LifecycleContainer lifecycleContainer = this.mKeyToLifecycleContainers.get(charSequence);
        lifecycleOwner = lifecycleContainer;
        if (lifecycleContainer == null) {
            lifecycleOwner = new LifecycleContainer(lifecycle);
        }
        lifecycleOwner.addObserver((LifecycleEventObserver)new /* Unavailable Anonymous Inner Class!! */);
        this.mKeyToLifecycleContainers.put((String)charSequence, (LifecycleContainer)lifecycleOwner);
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    final void unregister(String string) {
        Serializable serializable;
        if (!this.mLaunchedKeys.contains(string) && (serializable = this.mKeyToRc.remove(string)) != null) {
            this.mRcToKey.remove(serializable);
        }
        this.mKeyToCallback.remove(string);
        if (this.mParsedPendingResults.containsKey(string)) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Dropping pending result for request ");
            ((StringBuilder)serializable).append(string);
            ((StringBuilder)serializable).append(": ");
            ((StringBuilder)serializable).append(this.mParsedPendingResults.get(string));
            Log.w((String)LOG_TAG, (String)((StringBuilder)serializable).toString());
            this.mParsedPendingResults.remove(string);
        }
        if (this.mPendingResults.containsKey(string)) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Dropping pending result for request ");
            ((StringBuilder)serializable).append(string);
            ((StringBuilder)serializable).append(": ");
            ((StringBuilder)serializable).append(this.mPendingResults.getParcelable(string));
            Log.w((String)LOG_TAG, (String)((StringBuilder)serializable).toString());
            this.mPendingResults.remove(string);
        }
        if ((serializable = this.mKeyToLifecycleContainers.get(string)) == null) return;
        serializable.clearObservers();
        this.mKeyToLifecycleContainers.remove(string);
    }
}
