package com.example.defeatthetroll.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0003H\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/defeatthetroll/data/ApiService;", "", "auth", "Lretrofit2/Call;", "Lcom/example/defeatthetroll/data/AuthResponse;", "credentials", "Lcom/example/defeatthetroll/data/Credentials;", "feedback", "", "Lcom/example/defeatthetroll/data/Feedback;", "ping", "", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "feedback/ping")
    public abstract retrofit2.Call<java.lang.String> ping();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "auth")
    public abstract retrofit2.Call<com.example.defeatthetroll.data.AuthResponse> auth(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.defeatthetroll.data.Credentials credentials);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "feedback")
    public abstract retrofit2.Call<com.example.defeatthetroll.data.Feedback[]> feedback();
}