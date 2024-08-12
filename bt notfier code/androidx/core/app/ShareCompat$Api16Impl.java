/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.Intent
 *  android.net.Uri
 */
package androidx.core.app;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

private static class ShareCompat.Api16Impl {
    private ShareCompat.Api16Impl() {
    }

    static void migrateExtraStreamToClipData(Intent intent, ArrayList<Uri> arrayList) {
        CharSequence charSequence = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        String string = intent.getStringExtra("android.intent.extra.HTML_TEXT");
        String string2 = intent.getType();
        charSequence = new ClipData.Item(charSequence, string, null, arrayList.get(0));
        string2 = new ClipData(null, new String[]{string2}, (ClipData.Item)charSequence);
        int n = arrayList.size();
        int n2 = 1;
        while (true) {
            if (n2 >= n) {
                intent.setClipData((ClipData)string2);
                intent.addFlags(1);
                return;
            }
            string2.addItem(new ClipData.Item(arrayList.get(n2)));
            ++n2;
        }
    }

    static void removeClipData(Intent intent) {
        intent.setClipData(null);
        intent.setFlags(intent.getFlags() & 0xFFFFFFFE);
    }
}
