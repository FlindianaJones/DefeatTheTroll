package com.example.defeatthetroll.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0011\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017\u00a2\u0006\u0002\u0010\u0018J*\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u001aj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`\u001b2\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/example/defeatthetroll/data/QuestDatabaseHandler;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createChoice", "", "choice", "Lcom/example/defeatthetroll/data/Choice;", "key", "parentId", "", "createQuestNode", "node", "Lcom/example/defeatthetroll/data/QuestNode;", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "readAllQuestNodes", "", "()[Lcom/example/defeatthetroll/data/QuestNode;", "readChoices", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeId", "readQuestNode", "id", "app_debug"})
public final class QuestDatabaseHandler extends android.database.sqlite.SQLiteOpenHelper {
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String createQuestNode(@org.jetbrains.annotations.NotNull()
    com.example.defeatthetroll.data.QuestNode node) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.defeatthetroll.data.QuestNode readQuestNode(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.defeatthetroll.data.QuestNode[] readAllQuestNodes() {
        return null;
    }
    
    private final java.lang.String createChoice(com.example.defeatthetroll.data.Choice choice, java.lang.String key, int parentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.HashMap<java.lang.String, com.example.defeatthetroll.data.Choice> readChoices(int nodeId) {
        return null;
    }
    
    public QuestDatabaseHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, null, null, 0);
    }
}