/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 *  androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import java.util.Collections;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ActivityResultContracts.OpenMultipleDocuments
extends ActivityResultContract<String[], List<Uri>> {
    public Intent createIntent(Context context, String[] stringArray) {
        return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", stringArray).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
    }

    public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String[] stringArray) {
        return null;
    }

    public final List<Uri> parseResult(int n, Intent intent) {
        if (n != -1) return Collections.emptyList();
        if (intent != null) return ActivityResultContracts.GetMultipleContents.getClipDataUris((Intent)intent);
        return Collections.emptyList();
    }
}
