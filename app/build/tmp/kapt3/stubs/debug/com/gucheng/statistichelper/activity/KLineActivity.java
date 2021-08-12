package com.gucheng.statistichelper.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/gucheng/statistichelper/activity/KLineActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "DAILY", "", "MONTHLY", "WEEKLY", "chart", "Lcom/github/mikephil/charting/charts/LineChart;", "dailyText", "Landroid/widget/TextView;", "kLineViewModel", "Lcom/gucheng/statistichelper/vm/KLineViewModel;", "getKLineViewModel", "()Lcom/gucheng/statistichelper/vm/KLineViewModel;", "kLineViewModel$delegate", "Lkotlin/Lazy;", "legend", "Lcom/github/mikephil/charting/components/Legend;", "monthlyText", "textGroup", "Ljava/util/ArrayList;", "viewModel", "Lcom/gucheng/statistichelper/database/RecordViewModel;", "getViewModel", "()Lcom/gucheng/statistichelper/database/RecordViewModel;", "viewModel$delegate", "weeklyText", "initCharts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setData", "type", "setSelected", "app_debug"})
public final class KLineActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.github.mikephil.charting.charts.LineChart chart;
    private com.github.mikephil.charting.components.Legend legend;
    private final kotlin.Lazy viewModel$delegate = null;
    private final int DAILY = 1;
    private final int WEEKLY = 2;
    private final int MONTHLY = 3;
    private android.widget.TextView dailyText;
    private android.widget.TextView weeklyText;
    private android.widget.TextView monthlyText;
    private java.util.ArrayList<android.widget.TextView> textGroup;
    private final kotlin.Lazy kLineViewModel$delegate = null;
    
    private final com.gucheng.statistichelper.database.RecordViewModel getViewModel() {
        return null;
    }
    
    private final com.gucheng.statistichelper.vm.KLineViewModel getKLineViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void initCharts() {
    }
    
    public final void setSelected(int type) {
    }
    
    private final void setData(int type) {
    }
    
    public KLineActivity() {
        super();
    }
}