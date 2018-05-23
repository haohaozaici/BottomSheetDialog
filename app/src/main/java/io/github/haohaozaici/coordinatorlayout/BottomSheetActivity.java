package io.github.haohaozaici.coordinatorlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.github.haohaozaici.coordinatorlayout.widget.MXBottomSheetDialog;
import io.github.haohaozaici.coordinatorlayout.widget.MaxHeightRecyclerView;

/**
 * 取消了BottomSheetDialog的伸缩状态，限制了RecyclerView的最大高度，实现wrap和max拖动弹窗
 *
 * */
public class BottomSheetActivity extends AppCompatActivity {

    List<String> mList1 = new ArrayList<>();
    List<String> mList2 = new ArrayList<>();

    MXBottomSheetDialog mDialog1;
    MXBottomSheetDialog mDialog2;

    public static void start(Context context) {
        Intent starter = new Intent(context, BottomSheetActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_activity_layout);

        for (int i = 0; i < 50; i++) {
            mList1.add(i + "");
        }

        for (int i = 0; i < 5; i++) {
            mList2.add(i + "");
        }

        mDialog1 = createBottomDialog(mList1);
        mDialog2 = createBottomDialog(mList2);

        Button show_max = findViewById(R.id.show_max);
        show_max.setOnClickListener(v -> {
            mDialog1.show();
        });

        Button show_wrap = findViewById(R.id.show_wrap);
        show_wrap.setOnClickListener(v -> {
            mDialog2.show();
        });
    }


    private MXBottomSheetDialog createBottomDialog(List<String> list) {
        MXBottomSheetDialog dialog = new MXBottomSheetDialog(this, R.style.BottomSheetDialogStyle);
        View view = getLayoutInflater().inflate(R.layout.bottom_view_layout, null);
        MaxHeightRecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleAdapter simpleAdapter = new SimpleAdapter(list);
        recyclerView.setAdapter(simpleAdapter);

        //setmaxheight
        recyclerView.setMaxHeight((int) ((float) (getResources().getDisplayMetrics().heightPixels * 0.618)));

        dialog.setContentView(view);

        TextView textView = view.findViewById(R.id.dismiss);
        textView.setOnClickListener(v -> {
            dialog.dismiss();
        });


        return dialog;
    }


}
