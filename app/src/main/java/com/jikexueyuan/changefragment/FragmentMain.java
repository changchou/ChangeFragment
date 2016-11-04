package com.jikexueyuan.changefragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2015/12/8 0008.
 */
public class FragmentMain extends Fragment implements View.OnClickListener {

    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main,null);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        root.findViewById(R.id.btnshowAnother).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        ((MainActivity)getActivity()).applyRotation(true, new AnotherFragment(), 0, 90);
//
//        getFragmentManager().beginTransaction()
//                .setCustomAnimations(R.animator.enter, R.animator.exit)
//                .addToBackStack(null)
//                .replace(R.id.fragment, new AnotherFragment())
//                .commit();

//        AnimatorSet animatorEnter = (AnimatorSet) AnimatorInflater.loadAnimator(this.getActivity(),R.animator.enter);
//        final AnimatorSet animatorExit = (AnimatorSet) AnimatorInflater.loadAnimator(this.getActivity(),R.animator.exit);
//
//        animatorEnter.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.fragment, new AnotherFragment()).commit();
////                animatorExit.setTarget(root);
////                animatorExit.start();
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//
//        });
//        animatorEnter.setTarget(root);
//        animatorEnter.start();
    }
}
