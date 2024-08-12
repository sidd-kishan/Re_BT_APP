/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.internal.Objects$ToStringHelper
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Objects;
import java.util.Arrays;

public final class Objects {
    private Objects() {
        throw new AssertionError((Object)"Uninstantiable");
    }

    public static boolean checkBundlesEquality(Bundle bundle, Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            String string;
            if (bundle.size() != bundle2.size()) {
                return false;
            }
            Object object = bundle.keySet();
            if (!object.containsAll(bundle2.keySet())) {
                return false;
            }
            object = object.iterator();
            do {
                if (!object.hasNext()) return true;
            } while (Objects.equal(bundle.get(string = (String)object.next()), bundle2.get(string)));
            return false;
        }
        if (bundle != bundle2) return false;
        return true;
    }

    public static boolean equal(Object object, Object object2) {
        boolean bl = false;
        if (object != object2) {
            if (object == null) return bl;
            if (!object.equals(object2)) return false;
        }
        bl = true;
        return bl;
    }

    public static int hashCode(Object ... objectArray) {
        return Arrays.hashCode(objectArray);
    }

    public static ToStringHelper toStringHelper(Object object) {
        return new ToStringHelper(object, null);
    }
}
