package tw.dkyang.rxjavapractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView view;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
            btnP,btnM,btnT,btnD,btnE,btnC;
    String s = "";
    String num1 = "0";
    Double n1,n2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setClick();

    }

    private void findViews() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnP = findViewById(R.id.btnP);
        btnM = findViewById(R.id.btnM);
        btnT = findViewById(R.id.btnT);
        btnD = findViewById(R.id.btnD);
        btnE = findViewById(R.id.btnE);
        btnC = findViewById(R.id.btnC);
        view = findViewById(R.id.view);
        view.setText("0");
    }

    private void setClick() {
        btn0.setOnClickListener(num);
        btn1.setOnClickListener(num);
        btn2.setOnClickListener(num);
        btn3.setOnClickListener(num);
        btn4.setOnClickListener(num);
        btn5.setOnClickListener(num);
        btn6.setOnClickListener(num);
        btn7.setOnClickListener(num);
        btn8.setOnClickListener(num);
        btn9.setOnClickListener(num);
        btnP.setOnClickListener(cal);
        btnM.setOnClickListener(cal);
        btnT.setOnClickListener(cal);
        btnD.setOnClickListener(cal);
        btnE.setOnClickListener(cal);
        btnC.setOnClickListener(cal);

    }

    private Button.OnClickListener num = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn0:
                    if(num1 == "0"){
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 0);
                    }
                    break;
                case R.id.btn1:
                    if(num1 == "0"){
                        num1 = btn1.getText().toString();
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 1);
                    }
                    break;
                case R.id.btn2:
                    if(num1 == "0"){
                        num1 = btn2.getText().toString();
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 2);
                    }
                    break;
                case R.id.btn3:
                    if(num1 == "0"){
                        num1 = btn3.getText().toString();
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 3);
                    }
                    break;
                case R.id.btn4:
                    if(num1 == "0"){
                        num1 = btn4.getText().toString();
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 4);
                    }
                    break;
                case R.id.btn5:
                    if(num1 == "0"){
                        num1 = btn5.getText().toString();
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 5);
                    }
                    break;
                case R.id.btn6:
                    if(num1 == "0"){
                        num1 = btn6.getText().toString();
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 6);
                    }
                    break;
                case R.id.btn7:
                    if(num1 == "0"){
                        num1 = btn7.getText().toString();
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 7);
                    }
                    break;
                case R.id.btn8:
                    if(num1 == "0"){
                        num1 = btn8.getText().toString();
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 8);
                    }
                    break;
                case R.id.btn9:
                    if(num1 == "0"){
                        num1 = btn9.getText().toString();
                        view.setText(num1);
                    }else{
                        view.setText(num1 += 9);
                    }
                    break;
            }



        }
    };

    private Button.OnClickListener cal = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.btnP:
                    if(num1 != "0" && s == "") {
                        s = "P";
                        n1 = Double.parseDouble(num1);
                        num1 = "";
                        view.setText("+");
                    }
                    break;
                case R.id.btnM:
                    if(num1 != "0" && s == ""){
                        s = "M";
                        n1 = Double.parseDouble(num1);
                        num1 = "";
                        view.setText("-");
                    }
                    break;
                case R.id.btnT:
                    if(num1 != "0" && s == "") {
                        s = "T";
                        n1 = Double.parseDouble(num1);
                        num1 = "";
                        view.setText("*");
                    }
                    break;
                case R.id.btnD:
                    if(num1 != "0" && s == "") {
                        s = "D";
                        n1 = Double.parseDouble(num1);
                        num1 = "";
                        view.setText("/");
                    }
                    break;
                case R.id.btnE:

                    n2 = Double.parseDouble(num1);
                    DecimalFormat nf = new DecimalFormat("0.00");

                    if(n1 != 0 && n2 != 0 && s != "") {
                        switch (s) {
                            case "P":
                                view.setText(nf.format(n1 + n2));
                                break;
                            case "M":
                                view.setText(nf.format(n1 - n2));
                                break;
                            case "T":
                                view.setText(nf.format(n1 * n2));
                                break;
                            case "D":
                                view.setText(nf.format(n1 / n2));
                                break;
                        }
                    }
                    break;

                case R.id.btnC:
                    num1 = "0";
                    n1 = 0.00;
                    n2 = 0.00;
                    s = "";
                    view.setText("0");
                    break;

            }

        }
    };

}
