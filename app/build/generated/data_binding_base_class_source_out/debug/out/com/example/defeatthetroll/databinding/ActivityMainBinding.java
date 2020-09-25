// Generated by data binding compiler. Do not edit!
package com.example.defeatthetroll.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final Button artBtn;

  @NonNull
  public final Button axeBtn;

  @NonNull
  public final Button loginActivityBtn;

  @NonNull
  public final Button loveBtn;

  @NonNull
  public final Button magicBtn;

  @NonNull
  public final Button memeBtn;

  @NonNull
  public final Button questBtn;

  @NonNull
  public final ImageButton settingsBtn;

  @NonNull
  public final TextView textView;

  @NonNull
  public final Button viewFeedbackBtn;

  @Bindable
  protected Settings mSelectedBeast;

  protected ActivityMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button artBtn, Button axeBtn, Button loginActivityBtn, Button loveBtn, Button magicBtn,
      Button memeBtn, Button questBtn, ImageButton settingsBtn, TextView textView,
      Button viewFeedbackBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.artBtn = artBtn;
    this.axeBtn = axeBtn;
    this.loginActivityBtn = loginActivityBtn;
    this.loveBtn = loveBtn;
    this.magicBtn = magicBtn;
    this.memeBtn = memeBtn;
    this.questBtn = questBtn;
    this.settingsBtn = settingsBtn;
    this.textView = textView;
    this.viewFeedbackBtn = viewFeedbackBtn;
  }

  public abstract void setSelectedBeast(@Nullable Settings selectedBeast);

  @Nullable
  public Settings getSelectedBeast() {
    return mSelectedBeast;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
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
  public static ActivityMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMainBinding)bind(component, view, R.layout.activity_main);
  }
}
