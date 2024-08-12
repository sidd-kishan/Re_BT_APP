/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Sparta$Cache
 *  com.hp.hpl.sparta.Sparta$CacheFactory
 *  com.hp.hpl.sparta.Sparta$HashtableCache
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Sparta;

class Sparta$2
implements Sparta.CacheFactory {
    Sparta$2() {
    }

    public Sparta.Cache create() {
        return new Sparta.HashtableCache(null);
    }
}
