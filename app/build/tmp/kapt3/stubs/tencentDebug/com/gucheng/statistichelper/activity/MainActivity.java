package com.gucheng.statistichelper.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\"\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020\u001b2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0015J\b\u0010)\u001a\u00020\u001bH\u0007J\b\u0010*\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006+"}, d2 = {"Lcom/gucheng/statistichelper/activity/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/gucheng/statistichelper/adapter/RecordAdapter$ItemListener;", "()V", "KEY_AGREE_USER_PROTOCOL", "", "REQUEST_CODE_NEW_ITEM", "", "TAG", "getTAG", "()Ljava/lang/String;", "amountTotal", "Landroid/widget/TextView;", "changeTrend", "executor", "Ljava/util/concurrent/Executor;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "viewModel", "Lcom/gucheng/statistichelper/database/RecordViewModel;", "getViewModel", "()Lcom/gucheng/statistichelper/database/RecordViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "delete", "", "record", "Lcom/gucheng/statistichelper/database/entity/ItemRecord;", "edit", "isAgreeUserProtocol", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDialog", "showUserProtocol", "app_tencentDebug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.gucheng.statistichelper.adapter.RecordAdapter.ItemListener {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "MainActivity";
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    private final int REQUEST_CODE_NEW_ITEM = 1;
    private android.widget.TextView amountTotal;
    private android.widget.TextView changeTrend;
    private final java.lang.String KEY_AGREE_USER_PROTOCOL = "agree_user_protocol";
    private final kotlin.Lazy viewModel$delegate = null;
    private final java.util.concurrent.Executor executor = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getHandler() {
        return null;
    }
    
    private final com.gucheng.statistichelper.database.RecordViewModel getViewModel() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    public final void showDialog() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void delete(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemRecord record) {
    }
    
    @java.lang.Override()
    public void edit(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemRecord record) {
    }
    
    private final void showUserProtocol() {
    }
    
    private final boolean isAgreeUserProtocol() {
        return false;
    }
    
    public MainActivity() {
        super();
    }
}