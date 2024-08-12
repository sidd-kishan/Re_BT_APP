/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Document
 *  com.hp.hpl.sparta.ParseSource
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.ParseSource;

interface DocumentSource
extends ParseSource {
    public Document getDocument();
}
