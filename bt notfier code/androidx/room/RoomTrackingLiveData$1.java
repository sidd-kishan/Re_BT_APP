/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomTrackingLiveData
 */
package androidx.room;

import androidx.room.RoomTrackingLiveData;

class RoomTrackingLiveData.1
implements Runnable {
    final RoomTrackingLiveData this$0;

    RoomTrackingLiveData.1(RoomTrackingLiveData roomTrackingLiveData) {
        this.this$0 = roomTrackingLiveData;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void run() {
        if (this.this$0.mRegisteredObserver.compareAndSet(false, true)) {
            this.this$0.mDatabase.getInvalidationTracker().addWeakObserver(this.this$0.mObserver);
        }
        do {
            block9: {
                block10: {
                    if (!this.this$0.mComputing.compareAndSet(false, true)) break block10;
                    var3_3 /* !! */  = null;
                    var1_1 = false;
                    ** try [egrp 0[TRYBLOCK] [0 : 54->117)] { 
lbl8:
                    // 1 sources

                    ** GOTO lbl-1000
                }
                var1_1 = false;
                break block9;
lbl-1000:
                // 2 sources

                {
                    while (var2_2 = this.this$0.mInvalid.compareAndSet(true, false)) {
                        try {
                            var3_3 /* !! */  = this.this$0.mComputeFunction.call();
                            var1_1 = true;
                        }
                        catch (Exception var4_5) {
                            var3_3 /* !! */  = new RuntimeException("Exception while computing database live data.", var4_5);
                            throw var3_3 /* !! */ ;
                        }
                    }
                    if (var1_1) {
                        RoomTrackingLiveData.access$000((RoomTrackingLiveData)this.this$0, (Object)var3_3 /* !! */ );
                    }
                    break block9;
                }
lbl23:
                // 1 sources

                finally {
                    this.this$0.mComputing.set(false);
                }
            }
            if (var1_1 == false) return;
        } while (this.this$0.mInvalid.get());
    }
}
