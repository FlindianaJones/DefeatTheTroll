package com.example.defeatthetroll.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010#\u001a\u00020\bH\u0016J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010&\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006\'"}, d2 = {"Lcom/example/defeatthetroll/data/Combatant;", "", "wpn", "Lcom/example/defeatthetroll/Weapon;", "output", "Landroid/widget/TextView;", "(Lcom/example/defeatthetroll/Weapon;Landroid/widget/TextView;)V", "axeSkill", "", "getAxeSkill", "()I", "setAxeSkill", "(I)V", "dodgeSkill", "getDodgeSkill", "setDodgeSkill", "hitpoints", "getHitpoints", "setHitpoints", "maxHitpoints", "getMaxHitpoints", "setMaxHitpoints", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOutput", "()Landroid/widget/TextView;", "weapon", "getWeapon", "()Lcom/example/defeatthetroll/Weapon;", "setWeapon", "(Lcom/example/defeatthetroll/Weapon;)V", "attack", "bequeath", "", "defend", "app_debug"})
public abstract class Combatant {
    private int maxHitpoints = 0;
    private int hitpoints = 0;
    private int axeSkill = 0;
    private int dodgeSkill = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name = "Combatant";
    @org.jetbrains.annotations.Nullable()
    private com.example.defeatthetroll.Weapon weapon;
    @org.jetbrains.annotations.Nullable()
    private final android.widget.TextView output = null;
    
    public final int getMaxHitpoints() {
        return 0;
    }
    
    public final void setMaxHitpoints(int p0) {
    }
    
    public final int getHitpoints() {
        return 0;
    }
    
    public final void setHitpoints(int p0) {
    }
    
    public final int getAxeSkill() {
        return 0;
    }
    
    public final void setAxeSkill(int p0) {
    }
    
    public final int getDodgeSkill() {
        return 0;
    }
    
    public final void setDodgeSkill(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.defeatthetroll.Weapon getWeapon() {
        return null;
    }
    
    public final void setWeapon(@org.jetbrains.annotations.Nullable()
    com.example.defeatthetroll.Weapon p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getOutput() {
        return null;
    }
    
    public int attack() {
        return 0;
    }
    
    public int defend() {
        return 0;
    }
    
    public final void bequeath(@org.jetbrains.annotations.NotNull()
    com.example.defeatthetroll.Weapon wpn) {
    }
    
    public Combatant(@org.jetbrains.annotations.Nullable()
    com.example.defeatthetroll.Weapon wpn, @org.jetbrains.annotations.Nullable()
    android.widget.TextView output) {
        super();
    }
}