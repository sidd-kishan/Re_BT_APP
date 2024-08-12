/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.MediationServerParameters
 *  com.google.ads.mediation.MediationServerParameters$Parameter
 */
package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;

public final class CustomEventServerParameters
extends MediationServerParameters {
    @MediationServerParameters.Parameter(name="class_name", required=true)
    public String className;
    @MediationServerParameters.Parameter(name="label", required=true)
    public String label;
    @MediationServerParameters.Parameter(name="parameter", required=false)
    public String parameter = null;
}
