/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.provider.FontRequestWorker
 *  androidx.core.provider.FontRequestWorker$TypefaceResult
 *  androidx.core.util.Consumer
 */
package androidx.core.provider;

import androidx.core.provider.FontRequestWorker;
import androidx.core.util.Consumer;
import java.util.ArrayList;

class FontRequestWorker.4
implements Consumer<FontRequestWorker.TypefaceResult> {
    final String val$id;

    FontRequestWorker.4(String string) {
        this.val$id = string;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void accept(FontRequestWorker.TypefaceResult typefaceResult) {
        int n;
        ArrayList arrayList;
        Object object = FontRequestWorker.LOCK;
        synchronized (object) {
            arrayList = (ArrayList)FontRequestWorker.PENDING_REPLIES.get((Object)this.val$id);
            if (arrayList == null) {
                return;
            }
            FontRequestWorker.PENDING_REPLIES.remove((Object)this.val$id);
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl10 : MonitorExitStatement: MONITOREXIT : var3_3
            n = 0;
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (n < arrayList.size()) {
            ((Consumer)arrayList.get(n)).accept((Object)typefaceResult);
            ++n;
        }
    }
}
