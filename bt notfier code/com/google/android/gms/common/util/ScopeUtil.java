/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ScopeUtil {
    private ScopeUtil() {
    }

    public static Set<Scope> fromScopeString(Collection<String> collection) {
        Preconditions.checkNotNull(collection, (Object)"scopeStrings can't be null.");
        return ScopeUtil.fromScopeString(collection.toArray(new String[collection.size()]));
    }

    public static Set<Scope> fromScopeString(String ... stringArray) {
        Preconditions.checkNotNull((Object)stringArray, (Object)"scopeStrings can't be null.");
        int n = stringArray.length;
        HashSet<Scope> hashSet = new HashSet<Scope>(n);
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray[n2];
            if (!TextUtils.isEmpty((CharSequence)string)) {
                hashSet.add(new Scope(string));
            }
            ++n2;
        }
        return hashSet;
    }

    public static String[] toScopeString(Set<Scope> set) {
        Preconditions.checkNotNull(set, (Object)"scopes can't be null.");
        return ScopeUtil.toScopeString(set.toArray(new Scope[set.size()]));
    }

    public static String[] toScopeString(Scope[] scopeArray) {
        Preconditions.checkNotNull((Object)scopeArray, (Object)"scopes can't be null.");
        String[] stringArray = new String[scopeArray.length];
        int n = 0;
        while (n < scopeArray.length) {
            stringArray[n] = scopeArray[n].getScopeUri();
            ++n;
        }
        return stringArray;
    }
}
