package com.example.myandroidplaceholderview;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

/**
 * Created by Darush on 1/5/2018.
 */

public class TinderCard {
    
    public static final String TAG = "TinderCard";
    
    @View(R.id.iv_tinder_profile)
    private ImageView ivProfile;
    
    @View(R.id.tv_tinder_nameage)
    private TextView tvNameAge;
    
    @View(R.id.tv_tinder_location)
    private TextView tvLocation;
    
    private Profile mProfile;
    private Context mContext;
    private SwipePlaceHolderView mSwipePlaceHolderView;
    
    public TinderCard(Context context, Profile profile, SwipePlaceHolderView swipePlaceHolderView) {
        mContext = context;
        mProfile = profile;
        mSwipePlaceHolderView = swipePlaceHolderView;
    }
    
    @Resolve
    private void onResolve() {
        Glide.with(mContext)
                .load(mProfile.getImageUrl())
                .into(ivProfile);
        tvNameAge.setText(mProfile.getName() + ", " + mProfile.getAge());
        tvLocation.setText(mProfile.getLocation());
    }
    
    @SwipeOut
    private void onSwipedOut() {
        Log.d(TAG, "onSwipedOut: ");
    }
    
    @SwipeCancelState
    private void onSwipeCancelState() {
        Log.d(TAG, "onSwipeCancelState: ");
    }
    
    @SwipeIn
    private void onSwipeIn() {
        Log.d(TAG, "onSwipeIn: ");
    }
    
    @SwipeInState
    private void onSwipeInState() {
        Log.d(TAG, "onSwipeInState: ");
    }
    
    @SwipeOutState
    private void onSwipeOutState() {
        Log.d(TAG, "onSwipeOutState: ");
    }
    
}
