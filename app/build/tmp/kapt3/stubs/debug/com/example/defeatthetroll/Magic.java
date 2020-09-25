package com.example.defeatthetroll;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001fH\u0014J\u0012\u0010#\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u001fH\u0014J\b\u0010\'\u001a\u00020\u001fH\u0014J\u0010\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010*R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006+"}, d2 = {"Lcom/example/defeatthetroll/Magic;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "db", "Lcom/google/firebase/database/FirebaseDatabase;", "getDb", "()Lcom/google/firebase/database/FirebaseDatabase;", "gameList", "", "Lcom/example/defeatthetroll/models/Duel;", "getGameList", "()Ljava/util/List;", "setGameList", "(Ljava/util/List;)V", "initialGet", "Lcom/google/firebase/database/ValueEventListener;", "getInitialGet", "()Lcom/google/firebase/database/ValueEventListener;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getMAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "mUser", "Lcom/google/firebase/auth/FirebaseUser;", "getMUser", "()Lcom/google/firebase/auth/FirebaseUser;", "myRef", "Lcom/google/firebase/database/DatabaseReference;", "getMyRef", "()Lcom/google/firebase/database/DatabaseReference;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "showToast", "toast", "", "app_debug"})
public final class Magic extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.FirebaseDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference myRef = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth mAuth = null;
    @org.jetbrains.annotations.Nullable()
    private final com.google.firebase.auth.FirebaseUser mUser = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.ValueEventListener initialGet = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.defeatthetroll.models.Duel> gameList;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.FirebaseDatabase getDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getMyRef() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getMAuth() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.auth.FirebaseUser getMUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.ValueEventListener getInitialGet() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.defeatthetroll.models.Duel> getGameList() {
        return null;
    }
    
    public final void setGameList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.defeatthetroll.models.Duel> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public final void showToast(@org.jetbrains.annotations.Nullable()
    java.lang.String toast) {
    }
    
    public Magic() {
        super();
    }
}