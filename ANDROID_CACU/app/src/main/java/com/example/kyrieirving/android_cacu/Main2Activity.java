package com.example.kyrieirving.android_cacu;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("1543205000035 张敏涛");

//重力感应模块
//此activity为横屏显示

        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        MySensorHelper scre2 = new MySensorHelper(this);
        scre2.vertical(this);


//******************************************************************

//******************************************************************
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
        //Button btn_back
        final Button btn_back = (Button)findViewById(R.id.btn_back) ;
        //Button btn_left_p
        final Button btn_left_p = (Button)findViewById(R.id.btn_left_p) ;
        //Button btn_right_p
        final Button btn_right_p = (Button)findViewById(R.id.btn_right_p) ;
        //Button btn_sin
        final Button btn_sin = (Button)findViewById(R.id.btn_sin) ;
        final Button btn_cos = (Button)findViewById(R.id.btn_cos) ;
        final Button btn_tan = (Button)findViewById(R.id.btn_tan) ;
        final Button btn_poewr = (Button)findViewById(R.id.btn_power) ;
        final Button btn_root = (Button)findViewById(R.id.btn_root) ;
        final Button btn_fact = (Button)findViewById(R.id.btn_fact) ;
        final TextView display2 = (TextView)findViewById(R.id.display2);
//******************************************************************************



//************************************************************************
//所有按钮公用一个监听器
        View.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(String.valueOf(display.getText()).equals("ERROR!")){

                    display.setText("");
                }
                switch (v.getId()){
                    //数字按钮的***********************
                    case R.id.btn_num_0:
                    case R.id.btn_num_1:
                    case R.id.btn_num_2:
                    case R.id.btn_num_3:
                    case R.id.btn_num_4:
                    case R.id.btn_num_5:
                    case R.id.btn_num_6:
                    case R.id.btn_num_7:
                    case R.id.btn_num_8:
                    case R.id.btn_num_9:
                        //如果结果栏里有结果，就qingchu结果显示
                                        if(!display2.getText().equals("")){
                                            display2.setText("");
                                            display.setText("");
                                        }
                                        display.append(((Button)v).getText());
                                        break;
                    case R.id.btn_num_d:
                        //如果结果栏里有结果，就qingchu结果显示
                        if(!display2.getText().equals("")){
                            display2.setText("");
                        }
                       //调用 CaculateScience里面的方法检查当前是否可以输入小数点
                        if(!CaculateScience.checkInputForDot(String.valueOf(display.getText()))){
                            display.append(btn_num_d.getText());
                        }
                        break;

                    //******************************************************************

                    //******************************************************************
                    //运算符号的
                    case R.id.btn_jia:
                    case R.id.btn_jian:
                    case R.id.btn_cheng:
                    case R.id.btn_chu:
                                    //如果结果栏里有结果，就qingchu结果显示
                                    if(!display2.getText().equals("")){
                                        display.setText(display2.getText());
                                        display2.setText("");
                                    }
                                    display.append(((Button)v).getText());
                                    break;
                    case R.id.btn_left_p:
                    case R.id.btn_right_p:
                        display.append(((Button)v).getText());
                        break;
                    case R.id.btn_sin:String num_s = String.valueOf(display.getText());
                                    //getStrTrigonometricNumgetStrTrigonometricNum方法返回的是ArrayList<String>
                                    //第一个存放的是要计算的sin值
                                    //第二个存放的是其他的表达式
                                    ArrayList<String> list_s =  CaculateScience.getStrTrigonometricNum(num_s);
                                    display.setText(list_s.get(1));
                                    //计算并追加显示
                                    display.append(CaculateScience.trigonometric(list_s.get(0),"sin"));
                                    break;
                    case R.id.btn_cos:String num_c = String.valueOf(display.getText());
                        //getStrTrigonometricNumgetStrTrigonometricNum方法返回的是ArrayList<String>
                        //第一个存放的是要计算的cos值
                        //第二个存放的是其他的表达式
                        ArrayList<String> list_c =  CaculateScience.getStrTrigonometricNum(num_c);
                        display.setText(list_c.get(1));
                        //计算并追加显示
                        display.append(CaculateScience.trigonometric(list_c.get(0),"cos"));
                        break;
                    case R.id.btn_tan:String num_t = String.valueOf(display.getText());
                        //getStrTrigonometricNumgetStrTrigonometricNum方法返回的是ArrayList<String>
                        //第一个存放的是要计算的tan值
                        //第二个存放的是其他的表达式
                        ArrayList<String> list_t =  CaculateScience.getStrTrigonometricNum(num_t);
                        display.setText(list_t.get(1));
                        //计算并追加显示
                        display.append(CaculateScience.trigonometric(list_t.get(0),"tan"));
                        break;
                    case R.id.btn_fact:String num_f = String.valueOf(display.getText());
                        //getStrTrigonometricNumgetStrTrigonometricNum方法返回的是ArrayList<String>
                        //第一个存放的是要计算的fact值
                        //第二个存放的是其他的表达式
                        ArrayList<String> list_f =  CaculateScience.getStrTrigonometricNum(num_f);
                        display.setText(list_f.get(1));
                        //计算并追加显示
                        display.append(CaculateScience.trigonometric(list_f.get(0),"!"));
                        break;
                    case R.id.btn_power:display.append("^(");break;
                    case R.id.btn_root:display.append("^(1/");break;
                    //******************************************************************

                    //功能键的
                    //******************************************************************
                    case R.id.btn_enter:

                                        String s = String.valueOf(display.getText());
                                        //如果有表达式才进行计算
                                        if(!s.isEmpty()){
                                            //此函数用于在于将屏幕的+ - x ÷ 变为计算机能进行运算的+-/x
                                            s = CaculateScience.ShiftOperator(s);
                                            //计算表达式
                                           s = CaculateScience.Caculator(s);
                                        }
                                        display2.setText(s);
                                        break;
                    case R.id.btn_delete:display.setText("");display2.setText("");break;
                    case R.id.btn_back:String display_view ="";
                                        display_view = String.valueOf(display.getText());
                                        if(!display_view.isEmpty()){
                                            display.setText(display_view.substring(0,display_view.length()-1));
                                        }break;
                    //******************************************************************
                }




            }
        };
//*************************************************************

//*************************************************************
//注册所有按钮的点击事件
        btn_num_0.setOnClickListener(clickListener);
        btn_num_1.setOnClickListener(clickListener);
        btn_num_2.setOnClickListener(clickListener);
        btn_num_3.setOnClickListener(clickListener);
        btn_num_4.setOnClickListener(clickListener);
        btn_num_5.setOnClickListener(clickListener);
        btn_num_6.setOnClickListener(clickListener);
        btn_num_7.setOnClickListener(clickListener);
        btn_num_8.setOnClickListener(clickListener);
        btn_num_9.setOnClickListener(clickListener);
        btn_num_d.setOnClickListener(clickListener);
        btn_cheng.setOnClickListener(clickListener);
        btn_chu.setOnClickListener(clickListener);
        btn_jia.setOnClickListener(clickListener);
        btn_jian.setOnClickListener(clickListener);
        btn_enter.setOnClickListener(clickListener);
        btn_delete.setOnClickListener(clickListener);
        btn_back.setOnClickListener(clickListener);
        btn_left_p.setOnClickListener(clickListener);
        btn_right_p.setOnClickListener(clickListener);
        btn_sin.setOnClickListener(clickListener);
        btn_cos.setOnClickListener(clickListener);
        btn_tan.setOnClickListener(clickListener);
        btn_poewr.setOnClickListener(clickListener);
        btn_root.setOnClickListener(clickListener);
        btn_fact.setOnClickListener(clickListener);
//*************************************************************

    }

}
