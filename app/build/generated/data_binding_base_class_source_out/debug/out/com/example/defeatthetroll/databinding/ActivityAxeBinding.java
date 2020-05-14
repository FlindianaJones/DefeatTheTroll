// Generated by data binding compiler. Do not edit!
package com.example.defeatthetroll.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.defeatthetroll.R;
import com.example.defeatthetroll.Settings;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityAxeBinding extends ViewDataBinding {
  @NonNull
  public final Button attackBtn;

  @NonNull
  public final LinearLayout choiceLayout;

  @NonNull
  public final TextView choicePrompt;

  @NonNull
  public final Button defendBtn;

  @NonNull
  public final Button peaceAxeBtn;

  @NonNull
  public final TextView playerResultTxt;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView trollResultTxt;

  @NonNull
  public final Button warAndPeaceAxeBtn;

  @NonNull
  public final Button warAxeBtn;

  @Bindable
  protected Settings mSelectedBeast;

  protected ActivityAxeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button attackBtn, LinearLayout choiceLayout, TextView choicePrompt, Button defendBtn,
      Button peaceAxeBtn, TextView playerResultTxt, TextView textView3, TextView trollResultTxt,
      Button warAndPeaceAxeBtn, Button warAxeBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.attackBtn = attackBtn;
    this.choiceLayout = choiceLayout;
    this.choicePrompt = choicePrompt;
    this.defendBtn = defendBtn;
    this.peaceAxeBtn = peaceAxeBtn;
    this.playerResultTxt = playerResultTxt;
    this.textView3 = textView3;
    this.trollResultTxt = trollResultTxt;
    this.warAndPeaceAxeBtn = warAndPeaceAxeBtn;
    this.warAxeBtn = warAxeBtn;
  }

  public abstract void setSelectedBeast(@Nullable Settings selectedBeast);

  @Nullable
  public Settings getSelectedBeast() {
    return mSelectedBeast;
  }

  @NonNull
  public static ActivityAxeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_axe, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAxeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityAxeBinding>inflateInternal(inflater, R.layout.activity_axe, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAxeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_axe, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAxeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityAxeBinding>inflateInternal(inflater, R.layout.activity_axe, null, false, component);
  }

  public static ActivityAxeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityAxeBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityAxeBinding)bind(component, view, R.layout.activity_axe);
  }
}
