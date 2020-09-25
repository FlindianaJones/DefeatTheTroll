package com.example.defeatthetroll.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010=\u001a\u0004\u0018\u00010\u0006J\u0010\u0010=\u001a\u0004\u0018\u00010\u00062\u0006\u0010>\u001a\u00020#J\u0006\u0010?\u001a\u00020\u0006J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0000J5\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00102\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060EH\u0002\u00a2\u0006\u0002\u0010GR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001f\"\u0004\b(\u0010!R\u001a\u0010)\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00104\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR&\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u0010\u0014R \u0010:\u001a\b\u0012\u0004\u0012\u00020#0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!\u00a8\u0006H"}, d2 = {"Lcom/example/defeatthetroll/models/Duel;", "", "()V", "privateGame", "", "nameOfTheGame", "", "appContext", "Landroid/content/Context;", "(ZLjava/lang/String;Landroid/content/Context;)V", "createdDate", "getCreatedDate", "()Ljava/lang/String;", "setCreatedDate", "(Ljava/lang/String;)V", "elementMap", "", "getElementMap", "()Ljava/util/Map;", "setElementMap", "(Ljava/util/Map;)V", "id", "getId", "setId", "name", "getName", "setName", "playerChat", "", "Lcom/example/defeatthetroll/models/DuelChatMessage;", "getPlayerChat", "()Ljava/util/List;", "setPlayerChat", "(Ljava/util/List;)V", "playerGuesses", "Lcom/example/defeatthetroll/models/DuelGuess;", "getPlayerGuesses", "setPlayerGuesses", "players", "getPlayers", "setPlayers", "private", "getPrivate", "()Z", "setPrivate", "(Z)V", "selected", "getSelected", "()Ljava/lang/Boolean;", "setSelected", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "solution", "getSolution", "setSolution", "spellMap", "getSpellMap", "setSpellMap", "trollGuesses", "getTrollGuesses", "setTrollGuesses", "getSpellResult", "guess", "getTrollGuess", "loadStaticValues", "", "dbDuel", "randomizePairs", "first", "", "second", "([Ljava/lang/String;[Ljava/lang/String;)Ljava/util/Map;", "app_debug"})
public final class Duel {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> players;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.defeatthetroll.models.DuelGuess> trollGuesses;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.defeatthetroll.models.DuelChatMessage> playerChat;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.defeatthetroll.models.DuelGuess> playerGuesses;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String solution = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, java.lang.String> spellMap;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, java.lang.String> elementMap;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean selected;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String createdDate;
    
    public final boolean getPrivate() {
        return false;
    }
    
    public final void setPrivate(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPlayers() {
        return null;
    }
    
    public final void setPlayers(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.defeatthetroll.models.DuelGuess> getTrollGuesses() {
        return null;
    }
    
    public final void setTrollGuesses(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.defeatthetroll.models.DuelGuess> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.defeatthetroll.models.DuelChatMessage> getPlayerChat() {
        return null;
    }
    
    public final void setPlayerChat(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.defeatthetroll.models.DuelChatMessage> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.defeatthetroll.models.DuelGuess> getPlayerGuesses() {
        return null;
    }
    
    public final void setPlayerGuesses(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.defeatthetroll.models.DuelGuess> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSolution() {
        return null;
    }
    
    public final void setSolution(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getSpellMap() {
        return null;
    }
    
    public final void setSpellMap(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getElementMap() {
        return null;
    }
    
    public final void setElementMap(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getSelected() {
        return null;
    }
    
    public final void setSelected(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreatedDate() {
        return null;
    }
    
    public final void setCreatedDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final java.util.Map<java.lang.String, java.lang.String> randomizePairs(java.lang.String[] first, java.lang.String[] second) {
        return null;
    }
    
    public final void loadStaticValues(@org.jetbrains.annotations.NotNull()
    com.example.defeatthetroll.models.Duel dbDuel) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSpellResult() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSpellResult(@org.jetbrains.annotations.NotNull()
    com.example.defeatthetroll.models.DuelGuess guess) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTrollGuess() {
        return null;
    }
    
    public Duel() {
        super();
    }
    
    public Duel(boolean privateGame, @org.jetbrains.annotations.NotNull()
    java.lang.String nameOfTheGame, @org.jetbrains.annotations.NotNull()
    android.content.Context appContext) {
        super();
    }
}