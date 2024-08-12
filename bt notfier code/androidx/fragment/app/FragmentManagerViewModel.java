/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManagerNonConfig
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelStore
 */
package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class FragmentManagerViewModel
extends ViewModel {
    private static final ViewModelProvider.Factory FACTORY = new /* Unavailable Anonymous Inner Class!! */;
    private static final String TAG = "FragmentManager";
    private final HashMap<String, FragmentManagerViewModel> mChildNonConfigs;
    private boolean mHasBeenCleared = false;
    private boolean mHasSavedSnapshot = false;
    private boolean mIsStateSaved = false;
    private final HashMap<String, Fragment> mRetainedFragments = new HashMap();
    private final boolean mStateAutomaticallySaved;
    private final HashMap<String, ViewModelStore> mViewModelStores;

    FragmentManagerViewModel(boolean bl) {
        this.mChildNonConfigs = new HashMap();
        this.mViewModelStores = new HashMap();
        this.mStateAutomaticallySaved = bl;
    }

    static FragmentManagerViewModel getInstance(ViewModelStore viewModelStore) {
        return (FragmentManagerViewModel)new ViewModelProvider(viewModelStore, FACTORY).get(FragmentManagerViewModel.class);
    }

    void addRetainedFragment(Fragment fragment) {
        if (this.mIsStateSaved) {
            if (!FragmentManager.isLoggingEnabled((int)2)) return;
            Log.v((String)TAG, (String)"Ignoring addRetainedFragment as the state is already saved");
            return;
        }
        if (this.mRetainedFragments.containsKey(fragment.mWho)) {
            return;
        }
        this.mRetainedFragments.put(fragment.mWho, fragment);
        if (!FragmentManager.isLoggingEnabled((int)2)) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Updating retained Fragments: Added ");
        stringBuilder.append(fragment);
        Log.v((String)TAG, (String)stringBuilder.toString());
    }

    void clearNonConfigState(Fragment fragment) {
        Object object;
        if (FragmentManager.isLoggingEnabled((int)3)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Clearing non-config state for ");
            ((StringBuilder)object).append(fragment);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
        }
        if ((object = this.mChildNonConfigs.get(fragment.mWho)) != null) {
            ((FragmentManagerViewModel)((Object)object)).onCleared();
            this.mChildNonConfigs.remove(fragment.mWho);
        }
        if ((object = this.mViewModelStores.get(fragment.mWho)) == null) return;
        object.clear();
        this.mViewModelStores.remove(fragment.mWho);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (FragmentManagerViewModel)((Object)object);
        if (this.mRetainedFragments.equals(((FragmentManagerViewModel)((Object)object)).mRetainedFragments) && this.mChildNonConfigs.equals(((FragmentManagerViewModel)((Object)object)).mChildNonConfigs) && this.mViewModelStores.equals(((FragmentManagerViewModel)((Object)object)).mViewModelStores)) return bl;
        bl = false;
        return bl;
    }

    Fragment findRetainedFragmentByWho(String string) {
        return this.mRetainedFragments.get(string);
    }

    FragmentManagerViewModel getChildNonConfig(Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel;
        FragmentManagerViewModel fragmentManagerViewModel2 = fragmentManagerViewModel = this.mChildNonConfigs.get(fragment.mWho);
        if (fragmentManagerViewModel != null) return fragmentManagerViewModel2;
        fragmentManagerViewModel2 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        this.mChildNonConfigs.put(fragment.mWho, fragmentManagerViewModel2);
        return fragmentManagerViewModel2;
    }

    Collection<Fragment> getRetainedFragments() {
        return new ArrayList<Fragment>(this.mRetainedFragments.values());
    }

    @Deprecated
    FragmentManagerNonConfig getSnapshot() {
        if (this.mRetainedFragments.isEmpty() && this.mChildNonConfigs.isEmpty() && this.mViewModelStores.isEmpty()) {
            return null;
        }
        HashMap<String, FragmentManagerNonConfig> hashMap = new HashMap<String, FragmentManagerNonConfig>();
        Iterator<Map.Entry<String, FragmentManagerViewModel>> iterator = this.mChildNonConfigs.entrySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mHasSavedSnapshot = true;
                if (!this.mRetainedFragments.isEmpty()) return new FragmentManagerNonConfig(new ArrayList<Fragment>(this.mRetainedFragments.values()), hashMap, new HashMap<String, ViewModelStore>(this.mViewModelStores));
                if (!hashMap.isEmpty()) return new FragmentManagerNonConfig(new ArrayList<Fragment>(this.mRetainedFragments.values()), hashMap, new HashMap<String, ViewModelStore>(this.mViewModelStores));
                if (!this.mViewModelStores.isEmpty()) return new FragmentManagerNonConfig(new ArrayList<Fragment>(this.mRetainedFragments.values()), hashMap, new HashMap<String, ViewModelStore>(this.mViewModelStores));
                return null;
            }
            Map.Entry<String, FragmentManagerViewModel> entry = iterator.next();
            FragmentManagerNonConfig fragmentManagerNonConfig = entry.getValue().getSnapshot();
            if (fragmentManagerNonConfig == null) continue;
            hashMap.put(entry.getKey(), fragmentManagerNonConfig);
        }
    }

    ViewModelStore getViewModelStore(Fragment fragment) {
        ViewModelStore viewModelStore;
        ViewModelStore viewModelStore2 = viewModelStore = this.mViewModelStores.get(fragment.mWho);
        if (viewModelStore != null) return viewModelStore2;
        viewModelStore2 = new ViewModelStore();
        this.mViewModelStores.put(fragment.mWho, viewModelStore2);
        return viewModelStore2;
    }

    public int hashCode() {
        return (this.mRetainedFragments.hashCode() * 31 + this.mChildNonConfigs.hashCode()) * 31 + this.mViewModelStores.hashCode();
    }

    boolean isCleared() {
        return this.mHasBeenCleared;
    }

    protected void onCleared() {
        if (FragmentManager.isLoggingEnabled((int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onCleared called for ");
            stringBuilder.append((Object)this);
            Log.d((String)TAG, (String)stringBuilder.toString());
        }
        this.mHasBeenCleared = true;
    }

    void removeRetainedFragment(Fragment fragment) {
        if (this.mIsStateSaved) {
            if (!FragmentManager.isLoggingEnabled((int)2)) return;
            Log.v((String)TAG, (String)"Ignoring removeRetainedFragment as the state is already saved");
            return;
        }
        boolean bl = this.mRetainedFragments.remove(fragment.mWho) != null;
        if (!bl) return;
        if (!FragmentManager.isLoggingEnabled((int)2)) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Updating retained Fragments: Removed ");
        stringBuilder.append(fragment);
        Log.v((String)TAG, (String)stringBuilder.toString());
    }

    @Deprecated
    void restoreFromSnapshot(FragmentManagerNonConfig object) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if (object != null) {
            Map map;
            Collection object32 = object.getFragments();
            if (object32 != null) {
                for (Object object2 : object32) {
                    if (object2 == null) continue;
                    this.mRetainedFragments.put(((Fragment)object2).mWho, (Fragment)object2);
                }
            }
            if ((map = object.getChildNonConfigs()) != null) {
                for (Map.Entry entry : map.entrySet()) {
                    Object object2;
                    object2 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
                    ((FragmentManagerViewModel)((Object)object2)).restoreFromSnapshot((FragmentManagerNonConfig)entry.getValue());
                    this.mChildNonConfigs.put((String)entry.getKey(), (FragmentManagerViewModel)((Object)object2));
                }
            }
            if ((object = object.getViewModelStores()) != null) {
                this.mViewModelStores.putAll((Map<String, ViewModelStore>)object);
            }
        }
        this.mHasSavedSnapshot = false;
    }

    void setIsStateSaved(boolean bl) {
        this.mIsStateSaved = bl;
    }

    boolean shouldDestroy(Fragment fragment) {
        if (!this.mRetainedFragments.containsKey(fragment.mWho)) {
            return true;
        }
        if (!this.mStateAutomaticallySaved) return this.mHasSavedSnapshot ^ true;
        return this.mHasBeenCleared;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FragmentManagerViewModel{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
        stringBuilder.append("} Fragments (");
        Iterator<Object> iterator = this.mRetainedFragments.values().iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append(") Child Non Config (");
        iterator = this.mChildNonConfigs.keySet().iterator();
        while (iterator.hasNext()) {
            stringBuilder.append((String)iterator.next());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append(") ViewModelStores (");
        iterator = this.mViewModelStores.keySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                stringBuilder.append(')');
                return stringBuilder.toString();
            }
            stringBuilder.append((String)iterator.next());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
    }
}
