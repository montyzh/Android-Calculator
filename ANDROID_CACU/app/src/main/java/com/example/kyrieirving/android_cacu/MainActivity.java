package com.example.kyrieirving.android_cacu;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.example.kyrieirving.android_cacu.Caculate;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_main);
        setTitle("1543205000035 张敏涛");
        final Caculate cac = new Caculate();

        //shezhi anniu anxian biandong yanse
        Resources resources = getResources();
        final Drawable btn_num_pu = resources.getDrawable(R.drawable.btn_back_num_pu);
        final Drawable btn_num = resources.getDrawable(R.drawable.btn_back_num);
        //final Drawable btn_num_pu = resources.getDrawable(R.drawable.btn_back_num_pu);

        //****************************
        //display view
       final TextView display = (TextView) findViewById(R.id.display) ;
        //button num0
       final Button btn_num_0 = (Button)findViewById(R.id.btn_num_0);
        //button num1
        final Button btn_num_1 = (Button)findViewById(R.id.btn_num_1);
        //button num2
        final Button btn_num_2 = (Button)findViewById(R.id.btn_num_2);
        //button num3
        final Button btn_num_3 = (Button)findViewById(R.id.btn_num_3);
        //button num4
        final Button btn_num_4 = (Button)findViewById(R.id.btn_num_4);
        //button num5
        final Button btn_num_5 = (Button)findViewById(R.id.btn_num_5);
        //button num6
        final Button btn_num_6 = (Button)findViewById(R.id.btn_num_6);
        //button num7
        final Button btn_num_7 = (Button)findViewById(R.id.btn_num_7);
        //button num8
        final Button btn_num_8 = (Button)findViewById(R.id.btn_num_8);
        //button num9
        final Button btn_num_9 = (Button)findViewById(R.id.btn_num_9);
        //button numd
        final Button btn_num_d = (Button)findViewById(R.id.btn_num_d);
        //button  btn_chu
        final Button btn_chu = (Button)findViewById(R.id.btn_chu);
        //button  btn_cheng
        final Button btn_cheng = (Button)findViewById(R.id.btn_cheng);
        //button  btn_jia
        final Button btn_jia = (Button)findViewById(R.id.btn_jia);
        //button  btn_jian
        final Button btn_jian = (Button)findViewById(R.id.btn_jian);
        //button   btn_enter
        final Button btn_enter = (Button)findViewById(R.id.btn_enter);
        //button   btn_enter
        final Button btn_delete = (Button)findViewById(R.id.btn_delete);
        final Button btn_back = (Button)findViewById(R.id.btn_back) ;
//******************************************************************************


        //The number 0 button clicks the event
        btn_num_0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.Judgment_value1() == false){
                    if(cac.judge_flag == 0){
                        display.setText("");
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){
                    if(cac.judge_flag2 == 0){
                        display.setText("");
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_0.getText());
              //  btn_num_0.setBackground(btn_num_pu);
               // btn_num_0.setBackground(btn_num);
            }
        });
        //The number 1 button clicks the event
        btn_num_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.Judgment_value1() == false){
                    if(cac.judge_flag == 0){
                        display.setText("");
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){
                    if(cac.judge_flag2 == 0){
                        display.setText("");
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_1.getText());
            }
        });
        //The number 2 button clicks the event
        btn_num_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.Judgment_value1() == false){
                    if(cac.judge_flag == 0){
                        display.setText("");
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){
                    if(cac.judge_flag2 == 0){
                        display.setText("");
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_2.getText());
            }
        });
        //The number 3 button clicks the event
        btn_num_3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.Judgment_value1() == false){
                    if(cac.judge_flag == 0){
                        display.setText("");
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){
                    if(cac.judge_flag2 == 0){
                        display.setText("");
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_3.getText());
            }
        });
        //The number 4 button clicks the event
        btn_num_4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.Judgment_value1() == false){
                    if(cac.judge_flag == 0){
                        display.setText("");
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){
                    if(cac.judge_flag2 == 0){
                        display.setText("");
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_4.getText());
            }
        });
        //The number 5 button clicks the event
        btn_num_5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.Judgment_value1() == false){
                    if(cac.judge_flag == 0){
                        display.setText("");
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){
                    if(cac.judge_flag2 == 0){
                        display.setText("");
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_5.getText());
            }
        });
        //The number 6 button clicks the event
        btn_num_6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.Judgment_value1() == false){
                    if(cac.judge_flag == 0){
                        display.setText("");
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){
                    if(cac.judge_flag2 == 0){
                        display.setText("");
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_6.getText());
            }
        });
        //The number 7 button clicks the event
        btn_num_7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.Judgment_value1() == false){
                    if(cac.judge_flag == 0){
                        display.setText("");
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){
                    if(cac.judge_flag2 == 0){
                        display.setText("");
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_7.getText());
            }
        });
        //The number 8 button clicks the event
        btn_num_8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.Judgment_value1() == false){
                    if(cac.judge_flag == 0){
                        display.setText("");
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){
                    if(cac.judge_flag2 == 0){
                        display.setText("");
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_8.getText());
            }
        });

        //The number 9 button clicks the event
        btn_num_9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //下面判断主要是有两种情况
                //分别输入第一个数和第二个数的时候
                //需要清屏，所以需要进行判断正在输入的是第几个数
                //flag用于判断在输入当前数的时候是否是第一次进行了判断，
                //以免错误清楚当前的数字
                if(cac.Judgment_value1() == false){        //变量不为空值
                    if(cac.judge_flag == 0){             //且第一次判断
                        display.setText("");             //清屏   为输入第二个变量
                        cac.judge_flag =1;
                    }

                }
                else if(cac.Judgment_value1() == true){      //变量为空值
                    if(cac.judge_flag2 == 0){             //且第一次判断

                        display.setText("");              //
                        cac.judge_flag2 = 1;
                    }

                }
                display.append(btn_num_9.getText());
            }
        });

        //The number d button clicks the event
        btn_num_d.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append(btn_num_d.getText());
            }
        });
        //The delete button clicks the event
        btn_delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
                cac.Initialize();
                cac.result = "";
            }
        });

        //btn_back
        btn_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String display_view ="";
                display_view = String.valueOf(display.getText());
                if(!display_view.isEmpty()){

                    display.setText(display_view.substring(0,display_view.length()-1));

                }

            }
        });
        //btn_jian
        btn_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.operator =="e"){
                    cac.operator = "-";
                }

                //bao cun zhi
                if(cac.value1 == ""){
                    cac.value1 = String.valueOf(display.getText());
                }
                else {

                    btn_enter.callOnClick();
                    cac.value1 = String.valueOf(display.getText());
                    cac.operator = "-";

                }


            }
        });
        //btn_jia
        btn_jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.operator =="e"){
                    cac.operator = "+";
                }

                //bao cun zhi
                if(cac.value1 == ""){
                    cac.value1 = String.valueOf(display.getText());
                }
                else {

                    btn_enter.callOnClick();
                    cac.value1 = String.valueOf(display.getText());
                    cac.operator = "+";

                }

            }
        });
        //btn_cheng
        btn_cheng.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.operator =="e"){
                    cac.operator = "*";
                }

                //bao cun zhi
                if(cac.value1 == ""){   //如果value1的值为空（不连续输入表达式）
                    cac.value1 = String.valueOf(display.getText());
                }
                else {             //连续输入表达式

                    btn_enter.callOnClick();       //回调计算函数
                    cac.value1 = String.valueOf(display.getText());
                    cac.operator = "*";

                }

            }
        });

        //btn_chu
        btn_chu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cac.operator =="e"){
                    cac.operator = "/";
                }

                //bao cun zhi
                if(cac.value1 == ""){
                    cac.value1 = String.valueOf(display.getText());
                }
                else {

                    btn_enter.callOnClick();
                    cac.value1 = String.valueOf(display.getText());
                    cac.operator = "/";

                }

            }
        });


        //btn_enter
        btn_enter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                cac.value2 = String.valueOf(display.getText());
                switch (cac.operator){
                    case "-" :cac.sub();break;
                    case "+" :cac.add();break;
                    case "*" :cac.mult();break;
                    case "/" :cac.div();break;
                    default:cac.result = cac.value2;break;
                }
                //display the result

                display.setText(cac.result);
                //clear operator
               cac.Initialize();

            }
        });

        /////////////////////////////////////////////////

        MySensorHelper scre = new MySensorHelper(this);
        scre.cross(this);




    }

}
