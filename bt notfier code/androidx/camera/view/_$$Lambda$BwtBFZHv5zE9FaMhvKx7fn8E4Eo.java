/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.ForwardingLiveData
 *  androidx.lifecycle.Observer
 */
package androidx.camera.view;

import androidx.camera.view.ForwardingLiveData;
import androidx.lifecycle.Observer;

public final class _$$Lambda$BwtBFZHv5zE9FaMhvKx7fn8E4Eo
implements Observer {
    private final ForwardingLiveData f$0;

    public /* synthetic */ _$$Lambda$BwtBFZHv5zE9FaMhvKx7fn8E4Eo(ForwardingLiveData forwardingLiveData) {
        this.f$0 = forwardingLiveData;
    }

    public final void onChanged(Object object) {
        this.f$0.setValue(object);
    }
}
