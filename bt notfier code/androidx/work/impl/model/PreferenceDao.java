/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.work.impl.model.Preference
 */
package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.work.impl.model.Preference;

public interface PreferenceDao {
    public Long getLongValue(String var1);

    public LiveData<Long> getObservableLongValue(String var1);

    public void insertPreference(Preference var1);
}
