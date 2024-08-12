/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 *  androidx.collection.ArrayMap
 *  androidx.core.content.ContextCompat
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public static final class ActivityResultContracts.RequestMultiplePermissions
extends ActivityResultContract<String[], Map<String, Boolean>> {
    public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
    public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
    public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

    static Intent createIntent(String[] stringArray) {
        return new Intent(ACTION_REQUEST_PERMISSIONS).putExtra(EXTRA_PERMISSIONS, stringArray);
    }

    public Intent createIntent(Context context, String[] stringArray) {
        return ActivityResultContracts.RequestMultiplePermissions.createIntent(stringArray);
    }

    public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context context, String[] stringArray) {
        if (stringArray == null) return new ActivityResultContract.SynchronousResult(Collections.emptyMap());
        if (stringArray.length == 0) {
            return new ActivityResultContract.SynchronousResult(Collections.emptyMap());
        }
        ArrayMap arrayMap = new ArrayMap();
        int n = stringArray.length;
        int n2 = 0;
        boolean bl = true;
        while (true) {
            if (n2 >= n) {
                if (!bl) return null;
                return new ActivityResultContract.SynchronousResult((Object)arrayMap);
            }
            String string = stringArray[n2];
            boolean bl2 = ContextCompat.checkSelfPermission((Context)context, (String)string) == 0;
            arrayMap.put(string, bl2);
            if (!bl2) {
                bl = false;
            }
            ++n2;
        }
    }

    public Map<String, Boolean> parseResult(int n, Intent object) {
        if (n != -1) {
            return Collections.emptyMap();
        }
        if (object == null) {
            return Collections.emptyMap();
        }
        String[] stringArray = object.getStringArrayExtra(EXTRA_PERMISSIONS);
        int[] nArray = object.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
        if (nArray == null) return Collections.emptyMap();
        if (stringArray == null) {
            return Collections.emptyMap();
        }
        object = new HashMap();
        int n2 = stringArray.length;
        n = 0;
        while (n < n2) {
            String string = stringArray[n];
            boolean bl = nArray[n] == 0;
            object.put(string, bl);
            ++n;
        }
        return object;
    }
}
