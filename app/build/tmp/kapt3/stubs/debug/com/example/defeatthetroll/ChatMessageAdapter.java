package com.example.defeatthetroll;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/defeatthetroll/ChatMessageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/defeatthetroll/ChatMessageAdapter$ViewHolder;", "chatMessages", "", "Lcom/example/defeatthetroll/ChatMessage;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class ChatMessageAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.defeatthetroll.ChatMessageAdapter.ViewHolder> {
    private final java.util.List<com.example.defeatthetroll.ChatMessage> chatMessages = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.defeatthetroll.ChatMessageAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.defeatthetroll.ChatMessageAdapter.ViewHolder viewHolder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public ChatMessageAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.defeatthetroll.ChatMessage> chatMessages) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/example/defeatthetroll/ChatMessageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/defeatthetroll/ChatMessageAdapter;Landroid/view/View;)V", "leftPad", "Landroid/widget/Space;", "getLeftPad", "()Landroid/widget/Space;", "setLeftPad", "(Landroid/widget/Space;)V", "messageTextView", "Landroid/widget/TextView;", "getMessageTextView", "()Landroid/widget/TextView;", "setMessageTextView", "(Landroid/widget/TextView;)V", "rightPad", "getRightPad", "setRightPad", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView messageTextView;
        @org.jetbrains.annotations.NotNull()
        private android.widget.Space leftPad;
        @org.jetbrains.annotations.NotNull()
        private android.widget.Space rightPad;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getMessageTextView() {
            return null;
        }
        
        public final void setMessageTextView(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Space getLeftPad() {
            return null;
        }
        
        public final void setLeftPad(@org.jetbrains.annotations.NotNull()
        android.widget.Space p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Space getRightPad() {
            return null;
        }
        
        public final void setRightPad(@org.jetbrains.annotations.NotNull()
        android.widget.Space p0) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}