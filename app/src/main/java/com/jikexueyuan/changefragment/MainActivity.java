package com.jikexueyuan.changefragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

        frameLayout = (FrameLayout) findViewById(R.id.fragment);

        getFragmentManager().beginTransaction().add(R.id.fragment, new FragmentMain()).commit();

    }

    public void applyRotation(final boolean zheng, final Fragment fragment, final float start, final float end){
        final float centerX = frameLayout.getWidth() / 2.0f;
        final float centerY = frameLayout.getHeight() / 2.0f;
//        final float depthZ = frameLayout.getWidth() / 2.0f;
        final Rotate3DAnimation rotation = new Rotate3DAnimation(start, end, centerX, centerY, 310.0f, true);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(zheng, fragment));
        frameLayout.startAnimation(rotation);
    }

    private final class DisplayNextView implements Animation.AnimationListener {
        private final boolean mPosition;
        private final Fragment mfragment;
        private DisplayNextView(boolean zheng, Fragment fragment) {
            mPosition = zheng;
            mfragment = fragment;
        }
        public void onAnimationStart(Animation animation) {
        }
        public void onAnimationEnd(Animation animation) {
            frameLayout.post(new SwapViews(mPosition, mfragment));
        }
        public void onAnimationRepeat(Animation animation) {
        }
    }

    private final class SwapViews implements Runnable {
        private final boolean mPosition;
        private final Fragment mfragment;
        public SwapViews(boolean position, Fragment fragment) {
            mPosition = position;
            mfragment = fragment;
        }
        public void run() {
            final float centerX = frameLayout.getWidth() / 2.0f;
            final float centerY = frameLayout.getHeight() / 2.0f;
//            final float depthZ = frameLayout.getWidth() / 2.0f;
            Rotate3DAnimation rotation;
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment, mfragment);
            if (mPosition) {
                rotation = new Rotate3DAnimation(-90, 0, centerX, centerY,
                        310.0f, false);
            } else {
                rotation = new Rotate3DAnimation(90, 0, centerX, centerY,
                        310.0f, false);
            }
            fragmentTransaction.commit();
            rotation.setDuration(500);
            rotation.setFillAfter(true);
            rotation.setInterpolator(new DecelerateInterpolator());
            frameLayout.startAnimation(rotation);
        }
    }
}
