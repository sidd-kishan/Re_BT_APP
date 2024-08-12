/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManagerViewModel
 *  androidx.fragment.app.FragmentState
 *  androidx.fragment.app.FragmentStateManager
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentState;
import androidx.fragment.app.FragmentStateManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class FragmentStore {
    private static final String TAG = "FragmentManager";
    private final HashMap<String, FragmentStateManager> mActive;
    private final ArrayList<Fragment> mAdded = new ArrayList();
    private FragmentManagerViewModel mNonConfig;

    FragmentStore() {
        this.mActive = new HashMap();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void addFragment(Fragment fragment) {
        if (!this.mAdded.contains(fragment)) {
            ArrayList<Fragment> arrayList = this.mAdded;
            synchronized (arrayList) {
                this.mAdded.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment already added: ");
        stringBuilder.append(fragment);
        throw new IllegalStateException(stringBuilder.toString());
    }

    void burpActive() {
        this.mActive.values().removeAll(Collections.singleton(null));
    }

    boolean containsActiveFragment(String string) {
        boolean bl = this.mActive.get(string) != null;
        return bl;
    }

    void dispatchStateChange(int n) {
        Iterator<FragmentStateManager> iterator = this.mActive.values().iterator();
        while (iterator.hasNext()) {
            FragmentStateManager fragmentStateManager = iterator.next();
            if (fragmentStateManager == null) continue;
            fragmentStateManager.setFragmentManagerState(n);
        }
    }

    void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("    ");
        String string2 = stringBuilder.toString();
        if (!this.mActive.isEmpty()) {
            printWriter.print(string);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
                printWriter.print(string);
                if (fragmentStateManager != null) {
                    fragmentStateManager = fragmentStateManager.getFragment();
                    printWriter.println(fragmentStateManager);
                    fragmentStateManager.dump(string2, fileDescriptor, printWriter, stringArray);
                    continue;
                }
                printWriter.println("null");
            }
        }
        if ((n = this.mAdded.size()) <= 0) return;
        printWriter.print(string);
        printWriter.println("Added Fragments:");
        int n2 = 0;
        while (n2 < n) {
            fileDescriptor = this.mAdded.get(n2);
            printWriter.print(string);
            printWriter.print("  #");
            printWriter.print(n2);
            printWriter.print(": ");
            printWriter.println(fileDescriptor.toString());
            ++n2;
        }
    }

    Fragment findActiveFragment(String string) {
        if ((string = this.mActive.get(string)) == null) return null;
        return string.getFragment();
    }

    Fragment findFragmentById(int n) {
        Fragment fragment;
        for (int i = this.mAdded.size() - 1; i >= 0; --i) {
            fragment = this.mAdded.get(i);
            if (fragment == null || fragment.mFragmentId != n) continue;
            return fragment;
        }
        fragment = this.mActive.values().iterator();
        while (fragment.hasNext()) {
            FragmentStateManager fragmentStateManager = (FragmentStateManager)fragment.next();
            if (fragmentStateManager == null) continue;
            fragmentStateManager = fragmentStateManager.getFragment();
            if (fragmentStateManager.mFragmentId == n) return fragmentStateManager;
        }
        return null;
    }

    Fragment findFragmentByTag(String string) {
        Fragment fragment;
        if (string != null) {
            for (int i = this.mAdded.size() - 1; i >= 0; --i) {
                fragment = this.mAdded.get(i);
                if (fragment == null || !string.equals(fragment.mTag)) continue;
                return fragment;
            }
        }
        if (string == null) return null;
        fragment = this.mActive.values().iterator();
        while (fragment.hasNext()) {
            FragmentStateManager fragmentStateManager = fragment.next();
            if (fragmentStateManager == null) continue;
            fragmentStateManager = fragmentStateManager.getFragment();
            if (string.equals(fragmentStateManager.mTag)) return fragmentStateManager;
        }
        return null;
    }

    Fragment findFragmentByWho(String string) {
        FragmentStateManager fragmentStateManager;
        Iterator<FragmentStateManager> iterator = this.mActive.values().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((fragmentStateManager = iterator.next()) == null || (fragmentStateManager = fragmentStateManager.getFragment().findFragmentByWho(string)) == null);
        return fragmentStateManager;
    }

    int findFragmentIndexInContainer(Fragment fragment) {
        int n;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int n2 = this.mAdded.indexOf(fragment);
        int n3 = n2 - 1;
        while (true) {
            n = n2;
            if (n3 < 0) break;
            fragment = this.mAdded.get(n3);
            if (fragment.mContainer == viewGroup && fragment.mView != null) {
                return viewGroup.indexOfChild(fragment.mView) + 1;
            }
            --n3;
        }
        do {
            if (++n >= this.mAdded.size()) return -1;
            fragment = this.mAdded.get(n);
        } while (fragment.mContainer != viewGroup || fragment.mView == null);
        return viewGroup.indexOfChild(fragment.mView);
    }

    int getActiveFragmentCount() {
        return this.mActive.size();
    }

    List<FragmentStateManager> getActiveFragmentStateManagers() {
        ArrayList<FragmentStateManager> arrayList = new ArrayList<FragmentStateManager>();
        Iterator<FragmentStateManager> iterator = this.mActive.values().iterator();
        while (iterator.hasNext()) {
            FragmentStateManager fragmentStateManager = iterator.next();
            if (fragmentStateManager == null) continue;
            arrayList.add(fragmentStateManager);
        }
        return arrayList;
    }

    List<Fragment> getActiveFragments() {
        ArrayList<Fragment> arrayList = new ArrayList<Fragment>();
        Iterator<FragmentStateManager> iterator = this.mActive.values().iterator();
        while (iterator.hasNext()) {
            FragmentStateManager fragmentStateManager = iterator.next();
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.getFragment());
                continue;
            }
            arrayList.add(null);
        }
        return arrayList;
    }

    FragmentStateManager getFragmentStateManager(String string) {
        return this.mActive.get(string);
    }

    List<Fragment> getFragments() {
        if (this.mAdded.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<Fragment> arrayList = this.mAdded;
        synchronized (arrayList) {
            ArrayList<Fragment> arrayList2 = new ArrayList<Fragment>(this.mAdded);
            return arrayList2;
        }
    }

    FragmentManagerViewModel getNonConfig() {
        return this.mNonConfig;
    }

    void makeActive(FragmentStateManager object) {
        Fragment fragment = object.getFragment();
        if (this.containsActiveFragment(fragment.mWho)) {
            return;
        }
        this.mActive.put(fragment.mWho, (FragmentStateManager)object);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                this.mNonConfig.addRetainedFragment(fragment);
            } else {
                this.mNonConfig.removeRetainedFragment(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (!FragmentManager.isLoggingEnabled((int)2)) return;
        object = new StringBuilder();
        ((StringBuilder)object).append("Added fragment to active set ");
        ((StringBuilder)object).append(fragment);
        Log.v((String)TAG, (String)((StringBuilder)object).toString());
    }

    void makeInactive(FragmentStateManager object) {
        Fragment fragment = object.getFragment();
        if (fragment.mRetainInstance) {
            this.mNonConfig.removeRetainedFragment(fragment);
        }
        if ((FragmentStateManager)this.mActive.put(fragment.mWho, null) == null) {
            return;
        }
        if (!FragmentManager.isLoggingEnabled((int)2)) return;
        object = new StringBuilder();
        ((StringBuilder)object).append("Removed fragment from active set ");
        ((StringBuilder)object).append(fragment);
        Log.v((String)TAG, (String)((StringBuilder)object).toString());
    }

    void moveToExpectedState() {
        for (Fragment fragment : this.mAdded) {
            fragment = this.mActive.get(fragment.mWho);
            if (fragment == null) continue;
            fragment.moveToExpectedState();
        }
        Iterator<Fragment> iterator = this.mActive.values().iterator();
        while (iterator.hasNext()) {
            Fragment fragment;
            fragment = (FragmentStateManager)iterator.next();
            if (fragment == null) continue;
            fragment.moveToExpectedState();
            Fragment fragment2 = fragment.getFragment();
            boolean bl = fragment2.mRemoving && !fragment2.isInBackStack();
            if (!bl) continue;
            this.makeInactive((FragmentStateManager)fragment);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void removeFragment(Fragment fragment) {
        ArrayList<Fragment> arrayList = this.mAdded;
        synchronized (arrayList) {
            this.mAdded.remove(fragment);
        }
        fragment.mAdded = false;
    }

    void resetActiveFragments() {
        this.mActive.clear();
    }

    void restoreAddedFragments(List<String> object) {
        this.mAdded.clear();
        if (object == null) return;
        Object object2 = object.iterator();
        while (object2.hasNext()) {
            object = object2.next();
            Fragment fragment = this.findActiveFragment((String)object);
            if (fragment == null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("No instantiated fragment for (");
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(")");
                throw new IllegalStateException(((StringBuilder)object2).toString());
            }
            if (FragmentManager.isLoggingEnabled((int)2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("restoreSaveState: added (");
                stringBuilder.append((String)object);
                stringBuilder.append("): ");
                stringBuilder.append(fragment);
                Log.v((String)TAG, (String)stringBuilder.toString());
            }
            this.addFragment(fragment);
        }
    }

    ArrayList<FragmentState> saveActiveFragments() {
        ArrayList<FragmentState> arrayList = new ArrayList<FragmentState>(this.mActive.size());
        Iterator<FragmentStateManager> iterator = this.mActive.values().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object == null) continue;
            Fragment fragment = object.getFragment();
            FragmentState fragmentState = object.saveState();
            arrayList.add(fragmentState);
            if (!FragmentManager.isLoggingEnabled((int)2)) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("Saved state of ");
            ((StringBuilder)object).append(fragment);
            ((StringBuilder)object).append(": ");
            ((StringBuilder)object).append(fragmentState.mSavedFragmentState);
            Log.v((String)TAG, (String)((StringBuilder)object).toString());
        }
        return arrayList;
    }

    ArrayList<String> saveAddedFragments() {
        ArrayList<Fragment> arrayList = this.mAdded;
        synchronized (arrayList) {
            try {
                if (this.mAdded.isEmpty()) {
                    return null;
                }
                ArrayList<String> arrayList2 = new ArrayList<String>(this.mAdded.size());
                Iterator<Fragment> iterator = this.mAdded.iterator();
                while (iterator.hasNext()) {
                    Fragment fragment = iterator.next();
                    arrayList2.add(fragment.mWho);
                    if (!FragmentManager.isLoggingEnabled((int)2)) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("saveAllState: adding fragment (");
                    stringBuilder.append(fragment.mWho);
                    stringBuilder.append("): ");
                    stringBuilder.append(fragment);
                    Log.v((String)TAG, (String)stringBuilder.toString());
                }
                return arrayList2;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void setNonConfig(FragmentManagerViewModel fragmentManagerViewModel) {
        this.mNonConfig = fragmentManagerViewModel;
    }
}
