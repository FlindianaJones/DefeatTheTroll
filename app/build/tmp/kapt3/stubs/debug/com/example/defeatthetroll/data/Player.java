package com.example.defeatthetroll.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/example/defeatthetroll/data/Player;", "Lcom/example/defeatthetroll/data/Combatant;", "()V", "wpn", "Lcom/example/defeatthetroll/Weapon;", "output", "Landroid/widget/TextView;", "(Lcom/example/defeatthetroll/Weapon;Landroid/widget/TextView;)V", "attack", "", "defend", "app_debug"})
public final class Player extends com.example.defeatthetroll.data.Combatant {
    
    @java.lang.Override()
    public int attack() {
        return 0;
    }
    
    @java.lang.Override()
    public int defend() {
        return 0;
    }
    
    public Player(@org.jetbrains.annotations.Nullable()
    com.example.defeatthetroll.Weapon wpn, @org.jetbrains.annotations.Nullable()
    android.widget.TextView output) {
        super(null, null);
    }
    
    public Player() {
        super(null, null);
    }
}