package com.morfly.cleanarchitecture.core.presentationlayer;


import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.morfly.cleanarchitecture.R;

public abstract class SingleFragmentActivity<B extends ViewDataBinding> extends BaseActivity<B> {

//    private static final String FRAGMENT_NAME = "fragment_name";
//
//    private Fragment fragment;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        Bundle extras = getIntent().getExtras();
//
//        if (extras != null) {
//            String fragmentName = extras.getString(FRAGMENT_NAME);
//
//            if(!TextUtils.isEmpty(fragmentName)) {
//                fragment = Fragment.instantiate(this, fragmentName, extras);
//
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, fragment, fragment.getClass().getName())
//                        .commit();
//            }
//        }
//
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (fragment != null) {
//            fragment.onActivityResult(requestCode, resultCode, data);
//        }
//    }
}
