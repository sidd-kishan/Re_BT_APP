/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public static class ActivityResultContracts.GetMultipleContents
extends ActivityResultContract<String, List<Uri>> {
    static List<Uri> getClipDataUris(Intent intent) {
        LinkedHashSet<Uri> linkedHashSet = new LinkedHashSet<Uri>();
        if (intent.getData() != null) {
            linkedHashSet.add(intent.getData());
        }
        if ((intent = intent.getClipData()) == null && linkedHashSet.isEmpty()) {
            return Collections.emptyList();
        }
        if (intent == null) return new ArrayList<Uri>(linkedHashSet);
        int n = 0;
        while (n < intent.getItemCount()) {
            Uri uri = intent.getItemAt(n).getUri();
            if (uri != null) {
                linkedHashSet.add(uri);
            }
            ++n;
        }
        return new ArrayList<Uri>(linkedHashSet);
    }

    public Intent createIntent(Context context, String string) {
        return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(string).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    }

    public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String string) {
        return null;
    }

    public final List<Uri> parseResult(int n, Intent intent) {
        if (intent == null) return Collections.emptyList();
        if (n == -1) return ActivityResultContracts.GetMultipleContents.getClipDataUris(intent);
        return Collections.emptyList();
    }
}
