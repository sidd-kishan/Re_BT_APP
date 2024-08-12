/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.server.response.FastParser
 *  com.google.android.gms.common.server.response.FastParser$ParseException
 */
package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

interface zai<O> {
    public O zaa(FastParser var1, BufferedReader var2) throws FastParser.ParseException, IOException;
}
