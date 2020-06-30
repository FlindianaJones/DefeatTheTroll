package com.example.defeatthetroll.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\tH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0003H\'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\n\u001a\u00020\fH\'J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0011H\'J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/example/defeatthetroll/data/ApiService;", "", "auth", "Lretrofit2/Call;", "Lcom/example/defeatthetroll/data/AuthResponse;", "credentials", "Lcom/example/defeatthetroll/data/Credentials;", "doot", "", "Lcom/example/defeatthetroll/data/DootRequest;", "feedback", "", "Lcom/example/defeatthetroll/data/Feedback;", "Lcom/example/defeatthetroll/data/CreatedResponse;", "grant", "Lcom/example/defeatthetroll/data/GrantResponse;", "service_request", "", "ping", "app_debug"})
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
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "feedback")
    public abstract retrofit2.Call<com.example.defeatthetroll.data.CreatedResponse> feedback(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.defeatthetroll.data.Feedback feedback);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "feedback/doot")
    public abstract retrofit2.Call<java.lang.String> doot(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.defeatthetroll.data.DootRequest doot);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "handler.php")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.example.defeatthetroll.data.GrantResponse> grant(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> service_request);
}