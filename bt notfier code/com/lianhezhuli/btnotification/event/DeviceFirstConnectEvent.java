/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.event;

public class DeviceFirstConnectEvent {
    private String mac;
    private String name;

    public DeviceFirstConnectEvent() {
    }

    public DeviceFirstConnectEvent(String string, String string2) {
        this.name = string;
        this.mac = string2;
    }

    public String getMac() {
        return this.mac;
    }

    public String getName() {
        return this.name;
    }

    public void setMac(String string) {
        this.mac = string;
    }

    public void setName(String string) {
        this.name = string;
    }
}
