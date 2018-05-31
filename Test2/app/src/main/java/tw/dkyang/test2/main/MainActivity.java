package tw.dkyang.test2.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import tw.dkyang.test2.R;
import tw.dkyang.test2.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private MainViewModel viewModel;
    private static final String TAG = "MainActivity";
    String S;

    @BindView(R.id.view) TextView view;
    @BindView(R.id.btn1) Button btn1;
    @BindView(R.id.btn2) Button btn2;
    @BindView(R.id.btn3) Button btn3;
    @BindView(R.id.btnP) Button btnP;
    @BindView(R.id.btn4) Button btn4;
    @BindView(R.id.btn5) Button btn5;
    @BindView(R.id.btn6) Button btn6;
    @BindView(R.id.btnM) Button btnM;
    @BindView(R.id.btn7) Button btn7;
    @BindView(R.id.btn8) Button btn8;
    @BindView(R.id.btn9) Button btn9;
    @BindView(R.id.btnT) Button btnT;
    @BindView(R.id.btnC) Button btnC;
    @BindView(R.id.btn0) Button btn0;
    @BindView(R.id.btnD) Button btnD;
    @BindView(R.id.btnE) Button btnE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        bindViewModel();

    }

    private void initData() {
        viewModel = new MainViewModel("0");
    }

    private void bindViewModel() {
        mDisposable.add(viewModel.getCal()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        view.setText(s);
                    }
                })
        );
    }


@OnClick({R.id.btn1,R.id.btn2,R.id.btn3,R.id.btnP,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btnM,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btnT,R.id.btnC,R.id.btn0,R.id.btnD,R.id.btnE})public void onViewClicked(android.view.View view) {
    switch (view.getId()){
        case R.id.btn0:
            viewModel.num(btn0.getText().toString());
            break;
        case R.id.btn1:
            viewModel.num(btn1.getText().toString());
            break;
        case R.id.btn2:
            viewModel.num(btn2.getText().toString());
            break;
        case R.id.btn3:
            viewModel.num(btn3.getText().toString());
            break;
        case R.id.btn4:
            viewModel.num(btn4.getText().toString());
            break;
        case R.id.btn5:
            viewModel.num(btn5.getText().toString());
            break;
        case R.id.btn6:
            viewModel.num(btn6.getText().toString());
            break;
        case R.id.btn7:
            viewModel.num(btn7.getText().toString());
            break;
        case R.id.btn8:
            viewModel.num(btn8.getText().toString());
            break;
        case R.id.btn9:
            viewModel.num(btn9.getText().toString());
            break;
        case R.id.btnP:
            S="P";
            viewModel.sig(S,btnP.getText().toString());
            break;
        case R.id.btnM:
            S="M";
            viewModel.sig(S,btnM.getText().toString());
            break;
        case R.id.btnT:
            S="T";
            viewModel.sig(S,btnT.getText().toString());
            break;
        case R.id.btnD:
            S="D";
            viewModel.sig(S,btnD.getText().toString());
            break;
        case R.id.btnE:
            viewModel.cal();
            break;
        case R.id.btnC:
            viewModel.clean();
            break;
        }
    }

}
