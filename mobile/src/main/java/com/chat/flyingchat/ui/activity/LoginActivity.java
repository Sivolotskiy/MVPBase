package com.chat.flyingchat.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

import com.chat.flyingchat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {

    private static final float DEFAULT_FROM_ANIMATION = 1f;
    private static final float DEFAULT_TO_ANIMATION = 50f;
    private static final float DEFAULT_PIVOT_VALUE = 0.5f;
    private static final int DEFAULT_SCALE_DURATION = 1500;
    private static final int DEFAULT_ALPHA_DURATION = 1000;

    @BindView(R.id.activity_splash_reveal_view)
    View mRevealView;
    @BindView(R.id.activity_login_signin)
    Button mSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        mSignInButton.setOnClickListener(v -> {
            if (validateFields()) {
                animateLoginSuccess();
            }
        });
    }

    public void animateLoginSuccess() {
        mRevealView.setVisibility(View.VISIBLE);
//        mRevealView.setTop(mLogoImage.getTop());
//        mRevealView.setLeft(mLogoImage.getLeft());
        ScaleAnimation scaleAnimation = new ScaleAnimation(DEFAULT_FROM_ANIMATION, DEFAULT_TO_ANIMATION,
                DEFAULT_FROM_ANIMATION, DEFAULT_TO_ANIMATION,
                Animation.RELATIVE_TO_SELF, DEFAULT_PIVOT_VALUE,
                Animation.RELATIVE_TO_SELF, DEFAULT_PIVOT_VALUE);
        scaleAnimation.setDuration(DEFAULT_SCALE_DURATION);
        scaleAnimation.setFillAfter(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(DEFAULT_FROM_ANIMATION, 0);
        alphaAnimation.setDuration(DEFAULT_ALPHA_DURATION);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mRevealView.startAnimation(alphaAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mRevealView.startAnimation(scaleAnimation);
    }

    private boolean validateFields() {
        //TODO: impl after added api
        return true;
    }
}
