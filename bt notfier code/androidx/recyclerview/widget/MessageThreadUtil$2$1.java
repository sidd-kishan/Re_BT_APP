/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.recyclerview.widget.MessageThreadUtil$2
 *  androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem
 *  androidx.recyclerview.widget.TileList$Tile
 */
package androidx.recyclerview.widget;

import android.util.Log;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.TileList;

class MessageThreadUtil.1
implements Runnable {
    final MessageThreadUtil.2 this$1;

    MessageThreadUtil.1(MessageThreadUtil.2 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public void run() {
        while (true) {
            MessageThreadUtil.SyncQueueItem syncQueueItem;
            if ((syncQueueItem = this.this$1.mQueue.next()) == null) {
                this.this$1.mBackgroundRunning.set(false);
                return;
            }
            int n = syncQueueItem.what;
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        StringBuilder stringBuilder;
                        if (n != 4) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Unsupported message, what=");
                            stringBuilder.append(syncQueueItem.what);
                            Log.e((String)"ThreadUtil", (String)stringBuilder.toString());
                            continue;
                        }
                        stringBuilder = (TileList.Tile)syncQueueItem.data;
                        this.this$1.val$callback.recycleTile((TileList.Tile)stringBuilder);
                        continue;
                    }
                    this.this$1.val$callback.loadTile(syncQueueItem.arg1, syncQueueItem.arg2);
                    continue;
                }
                this.this$1.mQueue.removeMessages(2);
                this.this$1.mQueue.removeMessages(3);
                this.this$1.val$callback.updateRange(syncQueueItem.arg1, syncQueueItem.arg2, syncQueueItem.arg3, syncQueueItem.arg4, syncQueueItem.arg5);
                continue;
            }
            this.this$1.mQueue.removeMessages(1);
            this.this$1.val$callback.refresh(syncQueueItem.arg1);
        }
    }
}
