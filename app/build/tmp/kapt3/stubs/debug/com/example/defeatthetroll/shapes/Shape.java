package com.example.defeatthetroll.shapes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0016\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005J\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J\u001e\u0010!\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H&J\u0016\u0010\'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006*"}, d2 = {"Lcom/example/defeatthetroll/shapes/Shape;", "", "TotalLength", "", "CenterX", "", "CenterY", "EdgeDistance", "(DFFF)V", "getCenterX", "()F", "setCenterX", "(F)V", "getCenterY", "setCenterY", "getEdgeDistance", "setEdgeDistance", "getTotalLength", "()D", "setTotalLength", "(D)V", "Draw", "", "canvas", "Landroid/graphics/Canvas;", "brush", "Landroid/graphics/Paint;", "GetAngleFromVector", "x", "y", "GradeAngle", "ideal", "actual", "GradeDrawing", "drawing", "", "Lcom/example/defeatthetroll/shapes/PathPoint;", "time", "", "PercentDifference", "a", "b", "app_debug"})
public abstract class Shape {
    private double TotalLength;
    private float CenterX;
    private float CenterY;
    private float EdgeDistance;
    
    public abstract double GradeDrawing(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.defeatthetroll.shapes.PathPoint> drawing, long time);
    
    public abstract void Draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas, @org.jetbrains.annotations.NotNull()
    android.graphics.Paint brush);
    
    public final double PercentDifference(double a, double b) {
        return 0.0;
    }
    
    public final float GetAngleFromVector(float x, float y) {
        return 0.0F;
    }
    
    public final double GradeAngle(float ideal, float actual) {
        return 0.0;
    }
    
    public final double getTotalLength() {
        return 0.0;
    }
    
    public final void setTotalLength(double p0) {
    }
    
    public final float getCenterX() {
        return 0.0F;
    }
    
    public final void setCenterX(float p0) {
    }
    
    public final float getCenterY() {
        return 0.0F;
    }
    
    public final void setCenterY(float p0) {
    }
    
    public final float getEdgeDistance() {
        return 0.0F;
    }
    
    public final void setEdgeDistance(float p0) {
    }
    
    public Shape(double TotalLength, float CenterX, float CenterY, float EdgeDistance) {
        super();
    }
}