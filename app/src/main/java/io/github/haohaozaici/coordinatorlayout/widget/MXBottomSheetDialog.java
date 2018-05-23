package io.github.haohaozaici.coordinatorlayout.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;

/**
 * 取消了伸缩的状态, 搭配MaxHeightRecyclerView使用
 *
 * @author haoyuan
 */
public class MXBottomSheetDialog extends BottomSheetDialog {

    private BottomSheetBehavior mBehavior;

    public MXBottomSheetDialog(@NonNull Context context) {
        super(context);
    }

    public MXBottomSheetDialog(@NonNull Context context, int theme) {
        super(context, theme);
    }

    protected MXBottomSheetDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        mBehavior.setSkipCollapsed(true);
    }

    @Override
    public void show() {
        super.show();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public BottomSheetBehavior getBehavior() {
        return mBehavior;
    }
}
