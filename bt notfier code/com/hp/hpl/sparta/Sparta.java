/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Sparta$1
 *  com.hp.hpl.sparta.Sparta$2
 *  com.hp.hpl.sparta.Sparta$Cache
 *  com.hp.hpl.sparta.Sparta$CacheFactory
 *  com.hp.hpl.sparta.Sparta$Internment
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Sparta;

public class Sparta {
    private static CacheFactory cacheFactory_;
    private static Internment internment_;

    static {
        internment_ = new 1();
        cacheFactory_ = new 2();
    }

    public static String intern(String string) {
        return internment_.intern(string);
    }

    static Cache newCache() {
        return cacheFactory_.create();
    }

    public static void setCacheFactory(CacheFactory cacheFactory) {
        cacheFactory_ = cacheFactory;
    }

    public static void setInternment(Internment internment) {
        internment_ = internment;
    }
}
