package com.example.defeatthetroll.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0016R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/example/defeatthetroll/data/Choice;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "Label", "", "Keyword", "Result", "Next", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getKeyword", "()Ljava/lang/String;", "getLabel", "getNext", "()I", "getResult", "describeContents", "writeToParcel", "", "flags", "Companion", "app_debug"})
public final class Choice implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Label = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Keyword = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Result = null;
    private final int Next = 0;
    @org.jetbrains.annotations.NotNull()
    public static final android.os.Parcelable.Creator<com.example.defeatthetroll.data.Choice> CREATOR = null;
    public static final com.example.defeatthetroll.data.Choice.Companion Companion = null;
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKeyword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getResult() {
        return null;
    }
    
    public final int getNext() {
        return 0;
    }
    
    public Choice(@org.jetbrains.annotations.NotNull()
    java.lang.String Label, @org.jetbrains.annotations.NotNull()
    java.lang.String Keyword, @org.jetbrains.annotations.NotNull()
    java.lang.String Result, int Next) {
        super();
    }
    
    private Choice(android.os.Parcel parcel) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/defeatthetroll/data/Choice$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/example/defeatthetroll/data/Choice;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}