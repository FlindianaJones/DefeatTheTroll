package com.example.defeatthetroll.shapes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/example/defeatthetroll/shapes/Shape;", "", "CenterX", "", "getCenterX", "()F", "setCenterX", "(F)V", "CenterY", "getCenterY", "setCenterY", "TotalLength", "", "getTotalLength", "()D", "setTotalLength", "(D)V", "GradeDrawing", "drawing", "", "Lcom/example/defeatthetroll/shapes/PathPoint;", "app_debug"})
public abstract interface Shape {
    
    public abstract double getTotalLength();
    
    public abstract void setTotalLength(double p0);
    
    public abstract float getCenterX();
    
    public abstract void setCenterX(float p0);
    
    public abstract float getCenterY();
    
    public abstract void setCenterY(float p0);
    
    public abstract double GradeDrawing(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.defeatthetroll.shapes.PathPoint> drawing);
}