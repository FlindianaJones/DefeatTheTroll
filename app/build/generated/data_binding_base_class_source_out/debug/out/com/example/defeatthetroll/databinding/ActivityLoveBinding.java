// Generated by data binding compiler. Do not edit!
package com.example.defeatthetroll.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.defeatthetroll.R;
import com.example.defeatthetroll.Settings;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityLoveBinding extends ViewDataBinding {
  @NonNull
  public final Button findLoveBtn;

  @NonNull
  public final RecyclerView loveList;

  @NonNull
  public final TextView lovePrompt;

  @Bindable
  protected Settings mSelectedBeast;

  protected ActivityLoveBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button findLoveBtn, RecyclerView loveList, TextView lovePrompt) {
    super(_bindingComponent, _root, _localFieldCount);
    this.findLoveBtn = findLoveBtn;
    this.loveList = loveList;
    this.lovePrompt = lovePrompt;
  }

  public abstract void setSelectedBeast(@Nullable Settings selectedBeast);

  @Nullable
  public Settings getSelectedBeast() {
    return mSelectedBeast;
  }

  @NonNull
  public static ActivityLoveBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_love, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLoveBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityLoveBinding>inflateInternal(inflater, R.layout.activity_love, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLoveBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_love, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLoveBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityLoveBinding>inflateInternal(inflater, R.layout.activity_love, null, false, component);
  }

  public static ActivityLoveBinding bind(@NonNull View view) {
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
  public static ActivityLoveBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityLoveBinding)bind(component, view, R.layout.activity_love);
  }
}
