/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.event;

public class FindPhoneEvent {
    private String command;

    public FindPhoneEvent() {
    }

    public FindPhoneEvent(String string) {
        this.command = string;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String string) {
        this.command = string;
    }
}
