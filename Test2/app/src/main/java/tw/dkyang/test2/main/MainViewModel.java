package tw.dkyang.test2.main;

import java.text.DecimalFormat;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import tw.dkyang.test2.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {

    BehaviorSubject<String> cal;
    String s = "";
    String num = "";
    Double n1,n2;

    public MainViewModel(String cal) {
        this.cal = BehaviorSubject.createDefault(cal);
    }

    public Observable<String> getCal() {
        return this.cal;
    }

    public void setCal(String cal) {
        this.cal.onNext(cal);
    }

    public void clean(){
        num = "";
        n1 = 0.00;
        n2 = 0.00;
        s = "";
        cal.onNext("0");
    }

    public void cal(){
        n2 = Double.parseDouble(num);
        DecimalFormat nf = new DecimalFormat("0.00");

        if(n1 != 0 && n2 != 0 && s != "") {
            switch (s) {
                case "P":
                    cal.onNext(nf.format(n1 + n2));
                    break;
                case "M":
                    cal.onNext(nf.format(n1 - n2));
                    break;
                case "T":
                    cal.onNext(nf.format(n1 * n2));
                    break;
                case "D":
                    cal.onNext(nf.format(n1 / n2));
                    break;
            }
        }

    }

    public void sig(String S,String sig){
        if(num != "0" && s == "") {
            s = S;
            n1 = Double.parseDouble(num);
            num = "";
            cal.onNext(sig);
        }
    }

    public void num(String n){
        if(n == "0"){
            cal.onNext(n);
        }else{
            cal.onNext(num += n);
        }
    }

}
