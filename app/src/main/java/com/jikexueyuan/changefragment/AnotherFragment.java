package com.jikexueyuan.changefragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/12/8 0008.
 */
public class AnotherFragment extends Fragment implements View.OnClickListener {

    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_another,null);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        root.findViewById(R.id.btnback).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        ((MainActivity)getActivity()).applyRotation(false, new FragmentMain(), 0, -90);

//        getFragmentManager().beginTransaction()
//                .setCustomAnimations(R.animator.enter_back, R.animator.exit_back,R.animator.enter, R.animator.exit)
//                .addToBackStack(null)
//                .replace(R.id.fragment, new FragmentMain())
//                .commit();
    }
}
