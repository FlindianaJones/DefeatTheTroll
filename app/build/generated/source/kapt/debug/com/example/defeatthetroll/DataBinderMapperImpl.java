package com.example.defeatthetroll;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.defeatthetroll.databinding.ActivityAxeBindingImpl;
import com.example.defeatthetroll.databinding.ActivityLoveBindingImpl;
import com.example.defeatthetroll.databinding.ActivityMainBindingImpl;
import com.example.defeatthetroll.databinding.ActivityMemesBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYAXE = 1;

  private static final int LAYOUT_ACTIVITYLOVE = 2;

  private static final int LAYOUT_ACTIVITYMAIN = 3;

  private static final int LAYOUT_ACTIVITYMEMES = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.defeatthetroll.R.layout.activity_axe, LAYOUT_ACTIVITYAXE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.defeatthetroll.R.layout.activity_love, LAYOUT_ACTIVITYLOVE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.defeatthetroll.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.defeatthetroll.R.layout.activity_memes, LAYOUT_ACTIVITYMEMES);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYAXE: {
          if ("layout/activity_axe_0".equals(tag)) {
            return new ActivityAxeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_axe is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOVE: {
          if ("layout/activity_love_0".equals(tag)) {
            return new ActivityLoveBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_love is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMEMES: {
          if ("layout/activity_memes_0".equals(tag)) {
            return new ActivityMemesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_memes is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "selectedBeast");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_axe_0", com.example.defeatthetroll.R.layout.activity_axe);
      sKeys.put("layout/activity_love_0", com.example.defeatthetroll.R.layout.activity_love);
      sKeys.put("layout/activity_main_0", com.example.defeatthetroll.R.layout.activity_main);
      sKeys.put("layout/activity_memes_0", com.example.defeatthetroll.R.layout.activity_memes);
    }
  }
}
