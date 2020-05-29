package com.example.defeatthetroll.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B9\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/example/defeatthetroll/data/QuestNode;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "Id", "", "Prompt", "", "Choices", "Ljava/util/HashMap;", "Lcom/example/defeatthetroll/data/Choice;", "Lkotlin/collections/HashMap;", "(ILjava/lang/String;Ljava/util/HashMap;)V", "getChoices", "()Ljava/util/HashMap;", "getId", "()I", "getPrompt", "()Ljava/lang/String;", "describeContents", "writeToParcel", "", "flags", "Companion", "app_debug"})
public final class QuestNode implements android.os.Parcelable {
    private final int Id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Prompt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.HashMap<java.lang.String, com.example.defeatthetroll.data.Choice> Choices = null;
    @org.jetbrains.annotations.NotNull()
    public static final android.os.Parcelable.Creator<com.example.defeatthetroll.data.QuestNode> CREATOR = null;
    public static final com.example.defeatthetroll.data.QuestNode.Companion Companion = null;
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.HashMap<java.lang.String, com.example.defeatthetroll.data.Choice> getChoices() {
        return null;
    }
    
    public QuestNode(int Id, @org.jetbrains.annotations.NotNull()
    java.lang.String Prompt, @org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, com.example.defeatthetroll.data.Choice> Choices) {
        super();
    }
    
    private QuestNode(android.os.Parcel parcel) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/defeatthetroll/data/QuestNode$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/example/defeatthetroll/data/QuestNode;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}