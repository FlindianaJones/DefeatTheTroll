package com.example.defeatthetroll.databinding;
import com.example.defeatthetroll.R;
import com.example.defeatthetroll.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMemesBindingImpl extends ActivityMemesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.show_meme_btn, 2);
        sViewsWithIds.put(R.id.result_txt, 3);
        sViewsWithIds.put(R.id.selected_meme_img, 4);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMemesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityMemesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.Button) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.selectedBeast == variableId) {
            setSelectedBeast((com.example.defeatthetroll.Settings) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSelectedBeast(@Nullable com.example.defeatthetroll.Settings SelectedBeast) {
        updateRegistration(0, SelectedBeast);
        this.mSelectedBeast = SelectedBeast;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.selectedBeast);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSelectedBeast((com.example.defeatthetroll.Settings) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSelectedBeast(com.example.defeatthetroll.Settings SelectedBeast, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.selectedBeast) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String textView2AndroidStringMemeSplashTextSelectedBeastSelectedBeast = null;
        com.example.defeatthetroll.Settings selectedBeast = mSelectedBeast;
        java.lang.String selectedBeastSelectedBeast = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (selectedBeast != null) {
                    // read selectedBeast.selectedBeast
                    selectedBeastSelectedBeast = selectedBeast.getSelectedBeast();
                }


                // read @android:string/meme_splash_text
                textView2AndroidStringMemeSplashTextSelectedBeastSelectedBeast = textView2.getResources().getString(R.string.meme_splash_text, selectedBeastSelectedBeast);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView2, textView2AndroidStringMemeSplashTextSelectedBeastSelectedBeast);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): selectedBeast
        flag 1 (0x2L): selectedBeast.selectedBeast
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}