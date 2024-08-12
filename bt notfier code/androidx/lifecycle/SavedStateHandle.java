/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Size
 *  android.util.SizeF
 *  android.util.SparseArray
 *  androidx.lifecycle.MutableLiveData
 *  androidx.lifecycle.SavedStateHandle$SavingStateLiveData
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 */
package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class SavedStateHandle {
    private static final Class[] ACCEPTABLE_CLASSES;
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, SavingStateLiveData<?>> mLiveDatas;
    final Map<String, Object> mRegular;
    private final SavedStateRegistry.SavedStateProvider mSavedStateProvider;
    final Map<String, SavedStateRegistry.SavedStateProvider> mSavedStateProviders = new HashMap<String, SavedStateRegistry.SavedStateProvider>();

    static {
        Class<Boolean> clazz = Boolean.TYPE;
        Class<Double> clazz2 = Double.TYPE;
        Class<Integer> clazz3 = Integer.TYPE;
        Class<Long> clazz4 = Long.TYPE;
        Class<Byte> clazz5 = Byte.TYPE;
        Class<Character> clazz6 = Character.TYPE;
        Class<Float> clazz7 = Float.TYPE;
        Class<Short> clazz8 = Short.TYPE;
        Class clazz9 = Build.VERSION.SDK_INT >= 21 ? Size.class : Integer.TYPE;
        Class clazz10 = Build.VERSION.SDK_INT >= 21 ? SizeF.class : Integer.TYPE;
        ACCEPTABLE_CLASSES = new Class[]{clazz, boolean[].class, clazz2, double[].class, clazz3, int[].class, clazz4, long[].class, String.class, String[].class, Binder.class, Bundle.class, clazz5, byte[].class, clazz6, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, clazz7, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, clazz8, short[].class, SparseArray.class, clazz9, clazz10};
    }

    public SavedStateHandle() {
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new /* Unavailable Anonymous Inner Class!! */;
        this.mRegular = new HashMap<String, Object>();
    }

    public SavedStateHandle(Map<String, Object> map) {
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new /* Unavailable Anonymous Inner Class!! */;
        this.mRegular = new HashMap<String, Object>(map);
    }

    static SavedStateHandle createHandle(Bundle object, Bundle object2) {
        if (object == null && object2 == null) {
            return new SavedStateHandle();
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (object2 != null) {
            for (String string : object2.keySet()) {
                hashMap.put(string, object2.get(string));
            }
        }
        if (object == null) {
            return new SavedStateHandle(hashMap);
        }
        object2 = object.getParcelableArrayList(KEYS);
        object = object.getParcelableArrayList(VALUES);
        if (object2 != null && object != null && ((ArrayList)object2).size() == ((ArrayList)object).size()) {
            int n = 0;
            while (n < ((ArrayList)object2).size()) {
                hashMap.put((String)((ArrayList)object2).get(n), ((ArrayList)object).get(n));
                ++n;
            }
            return new SavedStateHandle(hashMap);
        }
        object = new IllegalStateException("Invalid bundle passed as restored state");
        throw object;
    }

    private <T> MutableLiveData<T> getLiveDataInternal(String string, boolean bl, T object) {
        MutableLiveData mutableLiveData = (MutableLiveData)this.mLiveDatas.get(string);
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        object = this.mRegular.containsKey(string) ? new SavingStateLiveData(this, string, this.mRegular.get(string)) : (bl ? new SavingStateLiveData(this, string, object) : new SavingStateLiveData(this, string));
        this.mLiveDatas.put(string, (SavingStateLiveData<?>)object);
        return object;
    }

    private static void validateValue(Object object) {
        if (object == null) {
            return;
        }
        Object object2 = ACCEPTABLE_CLASSES;
        int n = ((Class[])object2).length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Can't put value with type ");
                ((StringBuilder)object2).append(object.getClass());
                ((StringBuilder)object2).append(" into saved state");
                object = new IllegalArgumentException(((StringBuilder)object2).toString());
                throw object;
            }
            if (object2[n2].isInstance(object)) {
                return;
            }
            ++n2;
        }
    }

    public void clearSavedStateProvider(String string) {
        this.mSavedStateProviders.remove(string);
    }

    public boolean contains(String string) {
        return this.mRegular.containsKey(string);
    }

    public <T> T get(String string) {
        return (T)this.mRegular.get(string);
    }

    public <T> MutableLiveData<T> getLiveData(String string) {
        return this.getLiveDataInternal(string, false, null);
    }

    public <T> MutableLiveData<T> getLiveData(String string, T t) {
        return this.getLiveDataInternal(string, true, t);
    }

    public Set<String> keys() {
        HashSet<String> hashSet = new HashSet<String>(this.mRegular.keySet());
        hashSet.addAll(this.mSavedStateProviders.keySet());
        hashSet.addAll(this.mLiveDatas.keySet());
        return hashSet;
    }

    public <T> T remove(String savingStateLiveData) {
        Object object = this.mRegular.remove(savingStateLiveData);
        if ((savingStateLiveData = this.mLiveDatas.remove(savingStateLiveData)) == null) return (T)object;
        savingStateLiveData.detach();
        return (T)object;
    }

    SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.mSavedStateProvider;
    }

    public <T> void set(String string, T t) {
        SavedStateHandle.validateValue(t);
        MutableLiveData mutableLiveData = (MutableLiveData)this.mLiveDatas.get(string);
        if (mutableLiveData != null) {
            mutableLiveData.setValue(t);
        } else {
            this.mRegular.put(string, t);
        }
    }

    public void setSavedStateProvider(String string, SavedStateRegistry.SavedStateProvider savedStateProvider) {
        this.mSavedStateProviders.put(string, savedStateProvider);
    }
}
