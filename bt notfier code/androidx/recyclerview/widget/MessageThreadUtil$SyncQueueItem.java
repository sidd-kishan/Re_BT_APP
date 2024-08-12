/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

static class MessageThreadUtil.SyncQueueItem {
    private static MessageThreadUtil.SyncQueueItem sPool;
    private static final Object sPoolLock;
    public int arg1;
    public int arg2;
    public int arg3;
    public int arg4;
    public int arg5;
    public Object data;
    MessageThreadUtil.SyncQueueItem next;
    public int what;

    static {
        sPoolLock = new Object();
    }

    MessageThreadUtil.SyncQueueItem() {
    }

    static MessageThreadUtil.SyncQueueItem obtainMessage(int n, int n2, int n3) {
        return MessageThreadUtil.SyncQueueItem.obtainMessage(n, n2, n3, 0, 0, 0, null);
    }

    static MessageThreadUtil.SyncQueueItem obtainMessage(int n, int n2, int n3, int n4, int n5, int n6, Object object) {
        Object object2 = sPoolLock;
        synchronized (object2) {
            MessageThreadUtil.SyncQueueItem syncQueueItem;
            if (sPool == null) {
                syncQueueItem = new MessageThreadUtil.SyncQueueItem();
            } else {
                syncQueueItem = sPool;
                sPool = MessageThreadUtil.SyncQueueItem.sPool.next;
                syncQueueItem.next = null;
            }
            syncQueueItem.what = n;
            syncQueueItem.arg1 = n2;
            syncQueueItem.arg2 = n3;
            syncQueueItem.arg3 = n4;
            syncQueueItem.arg4 = n5;
            syncQueueItem.arg5 = n6;
            syncQueueItem.data = object;
            return syncQueueItem;
        }
    }

    static MessageThreadUtil.SyncQueueItem obtainMessage(int n, int n2, Object object) {
        return MessageThreadUtil.SyncQueueItem.obtainMessage(n, n2, 0, 0, 0, 0, object);
    }

    void recycle() {
        this.next = null;
        this.arg5 = 0;
        this.arg4 = 0;
        this.arg3 = 0;
        this.arg2 = 0;
        this.arg1 = 0;
        this.what = 0;
        this.data = null;
        Object object = sPoolLock;
        synchronized (object) {
            if (sPool != null) {
                this.next = sPool;
            }
            sPool = this;
            return;
        }
    }
}
