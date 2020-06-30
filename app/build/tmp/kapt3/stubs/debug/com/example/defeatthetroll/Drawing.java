package com.example.defeatthetroll;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/defeatthetroll/Drawing;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TOUCH_TOLERANCE", "", "cBitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "grade", "", "oldX", "oldY", "playerBrush", "Landroid/graphics/Paint;", "requestedCircle", "Lcom/example/defeatthetroll/shapes/Circle;", "requestedSquare", "Lcom/example/defeatthetroll/shapes/Square;", "scribble", "Landroid/graphics/Path;", "templateBrush", "textBrush", "draw", "", "c", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "touchMove", "x", "y", "touchStart", "touchUp", "app_debug"})
public final class Drawing extends android.view.View {
    private android.graphics.Paint playerBrush;
    private android.graphics.Paint templateBrush;
    private android.graphics.Paint textBrush;
    private android.graphics.Canvas canvas;
    private android.graphics.Path scribble;
    private android.graphics.Bitmap cBitmap;
    private float oldX = 0.0F;
    private float oldY = 0.0F;
    private double grade = 0.0;
    private final float TOUCH_TOLERANCE = 4.0F;
    private com.example.defeatthetroll.shapes.Circle requestedCircle;
    private com.example.defeatthetroll.shapes.Square requestedSquare;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void draw(@org.jetbrains.annotations.Nullable()
    android.graphics.Canvas c) {
    }
    
    private final void touchStart(float x, float y) {
    }
    
    private final void touchMove(float x, float y) {
    }
    
    private final void touchUp() {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event) {
        return false;
    }
    
    public Drawing(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
}