package tw.dkyang.test2.base;


import android.support.v7.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;

public class BaseActivity extends AppCompatActivity {

    protected final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }
}
