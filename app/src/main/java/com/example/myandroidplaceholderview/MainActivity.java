package com.example.myandroidplaceholderview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class MainActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipePlaceHolderView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipePlaceHolderView = (SwipePlaceHolderView) findViewById(R.id.swipeview_main);
        mContext = this;

        mSwipePlaceHolderView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(30)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        for(Profile profile: Utils.loadProfile(mContext)) {
            mSwipePlaceHolderView.addView(new TinderCard(mContext, profile, mSwipePlaceHolderView));
        }

        findViewById(R.id.btn_main_reject).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSwipePlaceHolderView.doSwipe(false);
            }
        });

        findViewById(R.id.btn_main_accept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSwipePlaceHolderView.doSwipe(true);
            }
        });

    }
}
