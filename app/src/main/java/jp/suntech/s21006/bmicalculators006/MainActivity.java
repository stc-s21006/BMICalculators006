package jp.suntech.s21006.bmicalculators006;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnClickButton listener = new OnClickButton() ;
        findViewById(R.id.btClear).setOnClickListener(listener);
        findViewById(R.id.btCal).setOnClickListener(listener);
    }

    private class OnClickButton implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            final int id = view.getId();

            TextView tvJudgeTitle =findViewById(R.id.tvJudgeTitle);
            TextView tvJudge =findViewById(R.id.tvJudge);
            TextView tvSbwTitle =findViewById(R.id.tvSbwTitle);
            TextView tvSbw =findViewById(R.id.tvSbw);
            TextView tvSbwUnit =findViewById(R.id.tvSbwUnit);

            TextView etAge =findViewById(R.id.etAge);
            TextView etHeight =findViewById(R.id.etHeight);
            TextView etWeight =findViewById(R.id.etWeight);


            if(R.id.btClear == id){
                tvJudgeTitle.setText("");
                tvJudge.setText("");
                tvSbwTitle.setText("");
                tvSbw.setText("");
                tvSbwUnit.setText("");

                etAge.setText("");
                etHeight.setText("");
                etWeight.setText("");
            }

            else if(R.id.btCal == id){
                int age;
                float height;
                float weight;

                String ageStr = etAge.getText().toString();
                String heightStr = etHeight.getText().toString();
                String weightStr = etWeight.getText().toString();

                if (ageStr.isEmpty()||heightStr.isEmpty()||weightStr.isEmpty()){
                    Toast.makeText(getApplicationContext(),"空欄があります",Toast.LENGTH_LONG).show();
                    return;
                }


                age = Integer.parseInt(ageStr);
                height = Float.parseFloat(heightStr);
                weight = Float.parseFloat(weightStr);


                if(age<16){
                    new MyDialog().show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
                }

                float bmi;
                float sbw;

                String judge;

                bmi = weight/((height/100)*(height/100));

                sbw = ((height / 100) * (height / 100)) * 22;

                if(bmi < 18.5){
                    judge="低体重";
                }
                else if(25>bmi){
                    judge="普通体重";
                }
                else if(30>bmi){
                    judge="肥満(1度)";
                }
                else if(35>bmi){
                    judge="肥満(2度)";
                }
                else if(40>bmi){
                    judge="肥満(3度)";
                }
                else {
                    judge="肥満(4度)";
                }





                tvJudgeTitle.setText(R.string.tv_judge_title);
                tvJudge.setText(judge);
                tvSbwTitle.setText(R.string.tv_sbw_title);
                tvSbw.setText(String.format(Locale.JAPAN, "%.1f",sbw));
                tvSbwUnit.setText(R.string.tv_unit_kg);


            }
        }
    }
}

