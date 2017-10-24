package com.morfly.cleanarchitecture.core.presentationlayer;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.morfly.cleanarchitecture.R;

public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {

    protected B binding;

    private ProgressDialog progress;
    private short progressCallsCounter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @LayoutRes
    protected abstract int getLayoutId();

    public void showProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progress == null) {
                    progress = new ProgressDialog(BaseActivity.this);
                    progress.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            progressCallsCounter = 0;
                        }
                    });
                    progress.setCancelable(true);
                    progress.setMessage(getString(R.string.message_loading));
                }
                if (!progress.isShowing()) {
                    progressCallsCounter++;
                    progress.show();
                }
            }
        });
    }

    public void hideProgress() {
        if (progressCallsCounter > 0) progressCallsCounter--;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progress != null && progress.isShowing() && progressCallsCounter <= 0) {
                    progress.dismiss();
                }
            }
        });
    }

}
