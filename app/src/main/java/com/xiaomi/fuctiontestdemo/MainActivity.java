package com.xiaomi.fuctiontestdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.xiaomi.fuctiontestdemo.view.NormalRecyclerViewAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = NormalRecyclerViewAdapter.class.getSimpleName();
    private NormalRecyclerViewAdapter mNormalRecyclerViewAdapter;

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mNormalRecyclerViewAdapter = new NormalRecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mNormalRecyclerViewAdapter);
        mNormalRecyclerViewAdapter.setOnItemClickListener(new NormalRecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        Log.d(TAG, "test1");
                        break;
                    case 1:
                        Log.d(TAG, "test2");
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
