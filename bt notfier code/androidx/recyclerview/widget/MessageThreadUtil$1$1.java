/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.recyclerview.widget.MessageThreadUtil$1
 *  androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem
 *  androidx.recyclerview.widget.TileList$Tile
 */
package androidx.recyclerview.widget;

import android.util.Log;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.TileList;

class MessageThreadUtil.1
implements Runnable {
    final MessageThreadUtil.1 this$1;

    MessageThreadUtil.1(MessageThreadUtil.1 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public void run() {
        MessageThreadUtil.SyncQueueItem syncQueueItem = this.this$1.mQueue.next();
        while (syncQueueItem != null) {
            int n = syncQueueItem.what;
            if (n != 1) {
                Object object;
                if (n != 2) {
                    if (n != 3) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Unsupported message, what=");
                        ((StringBuilder)object).append(syncQueueItem.what);
                        Log.e((String)"ThreadUtil", (String)((StringBuilder)object).toString());
                    } else {
                        this.this$1.val$callback.removeTile(syncQueueItem.arg1, syncQueueItem.arg2);
                    }
                } else {
                    object = (TileList.Tile)syncQueueItem.data;
                    this.this$1.val$callback.addTile(syncQueueItem.arg1, (TileList.Tile)object);
                }
            } else {
                this.this$1.val$callback.updateItemCount(syncQueueItem.arg1, syncQueueItem.arg2);
            }
            syncQueueItem = this.this$1.mQueue.next();
        }
    }
}
