package com.example.defeatthetroll;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u001eH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f\u00a8\u0006&"}, d2 = {"Lcom/example/defeatthetroll/DuelActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "clientSideDuel", "Lcom/example/defeatthetroll/models/Duel;", "getClientSideDuel", "()Lcom/example/defeatthetroll/models/Duel;", "setClientSideDuel", "(Lcom/example/defeatthetroll/models/Duel;)V", "currentDuel", "Lcom/google/firebase/database/DatabaseReference;", "getCurrentDuel", "()Lcom/google/firebase/database/DatabaseReference;", "setCurrentDuel", "(Lcom/google/firebase/database/DatabaseReference;)V", "db", "Lcom/google/firebase/database/FirebaseDatabase;", "getDb", "()Lcom/google/firebase/database/FirebaseDatabase;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getMAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "mUser", "Lcom/google/firebase/auth/FirebaseUser;", "getMUser", "()Lcom/google/firebase/auth/FirebaseUser;", "myRef", "getMyRef", "activateInterface", "", "message", "", "deactivateInterface", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
public final class DuelActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.FirebaseDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference myRef = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth mAuth = null;
    @org.jetbrains.annotations.Nullable()
    private final com.google.firebase.auth.FirebaseUser mUser = null;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.database.DatabaseReference currentDuel;
    @org.jetbrains.annotations.NotNull()
    private com.example.defeatthetroll.models.Duel clientSideDuel;
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
    public final com.google.firebase.database.DatabaseReference getCurrentDuel() {
        return null;
    }
    
    public final void setCurrentDuel(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.defeatthetroll.models.Duel getClientSideDuel() {
        return null;
    }
    
    public final void setClientSideDuel(@org.jetbrains.annotations.NotNull()
    com.example.defeatthetroll.models.Duel p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void deactivateInterface(java.lang.String message) {
    }
    
    private final void activateInterface(java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public DuelActivity() {
        super();
    }
}