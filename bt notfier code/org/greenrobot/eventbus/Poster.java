/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.Subscription
 */
package org.greenrobot.eventbus;

import org.greenrobot.eventbus.Subscription;

interface Poster {
    public void enqueue(Subscription var1, Object var2);
}
