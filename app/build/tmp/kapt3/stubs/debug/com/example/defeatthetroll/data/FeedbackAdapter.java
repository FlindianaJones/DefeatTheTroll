package com.example.defeatthetroll.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\n2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/defeatthetroll/data/FeedbackAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/defeatthetroll/data/FeedbackAdapter$ViewHolder;", "feedbackItems", "", "Lcom/example/defeatthetroll/models/Feedback;", "dootFun", "Lkotlin/Function2;", "", "", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getDootFun", "()Lkotlin/jvm/functions/Function2;", "getItemCount", "onBindViewHolder", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class FeedbackAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.defeatthetroll.data.FeedbackAdapter.ViewHolder> {
    private final java.util.List<com.example.defeatthetroll.models.Feedback> feedbackItems = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Integer, kotlin.Unit> dootFun = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.defeatthetroll.data.FeedbackAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.defeatthetroll.data.FeedbackAdapter.ViewHolder viewHolder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Integer, kotlin.Unit> getDootFun() {
        return null;
    }
    
    public FeedbackAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.defeatthetroll.models.Feedback> feedbackItems, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> dootFun) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/example/defeatthetroll/data/FeedbackAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/defeatthetroll/data/FeedbackAdapter;Landroid/view/View;)V", "contentTextView", "Landroid/widget/TextView;", "getContentTextView", "()Landroid/widget/TextView;", "setContentTextView", "(Landroid/widget/TextView;)V", "downdootButton", "Landroid/widget/ImageButton;", "getDowndootButton", "()Landroid/widget/ImageButton;", "setDowndootButton", "(Landroid/widget/ImageButton;)V", "posterTextView", "getPosterTextView", "setPosterTextView", "ratingTextView", "getRatingTextView", "setRatingTextView", "titleTextView", "getTitleTextView", "setTitleTextView", "updootButton", "getUpdootButton", "setUpdootButton", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView titleTextView;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView posterTextView;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView contentTextView;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageButton updootButton;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageButton downdootButton;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView ratingTextView;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTitleTextView() {
            return null;
        }
        
        public final void setTitleTextView(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getPosterTextView() {
            return null;
        }
        
        public final void setPosterTextView(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getContentTextView() {
            return null;
        }
        
        public final void setContentTextView(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageButton getUpdootButton() {
            return null;
        }
        
        public final void setUpdootButton(@org.jetbrains.annotations.NotNull()
        android.widget.ImageButton p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageButton getDowndootButton() {
            return null;
        }
        
        public final void setDowndootButton(@org.jetbrains.annotations.NotNull()
        android.widget.ImageButton p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getRatingTextView() {
            return null;
        }
        
        public final void setRatingTextView(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}