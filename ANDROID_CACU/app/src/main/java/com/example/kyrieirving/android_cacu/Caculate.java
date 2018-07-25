package com.example.kyrieirving.android_cacu;

import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Kyrie Irving on 2018/3/25.
 */

public class Caculate {

    //Storage  operand
    String value1 = "";
    String value2 = "";
    String operator = "e";
    String result = "";

    //zhe liangge bianliang yongyu panduan zai anniu shijian zhong
    //shifou diyici jinxing panduan value wei kongzhi
    int judge_flag = 0;
    int judge_flag2 = 0;
  //  ArrayList value1 = new ArrayList();
  //  ArrayList value2 = new ArrayList();
   // ArrayList result = new ArrayList();
    //Storage  opertor e is empty
    void Initialize(){


        this.value1 = "";
        this.value2 = "";
        this.operator = "e";
        this.judge_flag = 0;
        this.judge_flag2 = 0;
    }


    boolean Judgment_value1(){
        if(this.value1 == ""){
           return true;

        }
        else {

            return false;
        }

    }


    void sub(){

        BigDecimal b1 = new BigDecimal(this.value1);
        BigDecimal b2 = new BigDecimal(this.value2);

        this.result =clear_dig_for_int(String.valueOf(b1.subtract(b2).doubleValue()));

        this.value1 = "";
        this.value2 = "";

    }


    void add(){
        BigDecimal b1 = new BigDecimal(this.value1);
        BigDecimal b2 = new BigDecimal(this.value2);

        this.result =clear_dig_for_int(String.valueOf(b1.add(b2).doubleValue()));

        this.value1 = "";
        this.value2 = "";

    }


    void mult(){
        BigDecimal b1 = new BigDecimal(this.value1);
        BigDecimal b2 = new BigDecimal(this.value2);

        this.result =clear_dig_for_int(String.valueOf(b1.multiply(b2).doubleValue()));

        this.value1 = "";
        this.value2 = "";

    }
    void div(){
        BigDecimal b1 = new BigDecimal(this.value1);
        BigDecimal b2 = new BigDecimal(this.value2);

        BigDecimal b3 = new BigDecimal(String.valueOf(0));
//        b1.setScale(5,BigDecimal.ROUND_HALF_UP);
//        b2.setScale(5,BigDecimal.ROUND_HALF_UP);
        //
        //Bigdecimal 中divide当遇到不整chu的情况会抛出异常
        //所以需要设置精确度
//        //scale即为精确度
        if(!b2.equals(b3) && (!this.value2.isEmpty())){
            this.result =clear_dig_for_int(String.valueOf(
                    b1.divide(b2,7,BigDecimal.ROUND_HALF_UP).doubleValue()
                    )
            );
    }
         else if(b2.equals(b3) || this.value2.isEmpty()){
            this.result = "ERROR!";
        }
        this.value1 = "";
        this.value2 = "";

    }

//判断是否为double类型
  public static   int isDig(String s){


        return s.indexOf(".");
    }


    //由于int型的变量存储上限太低，所以不加入int型的算法，
    // 但为了int型数据运算后的结果不显示“.0”就有下面函数

    public static String clear_dig_for_int(String s){
      int len = s.length();
      char data[] = s.toCharArray();
     // char temp[] = new char[len-2];

      if(data[len-1] == '0' && data[len - 2] == '.'){

//          for(int i = 0;i<=len-3;i++){
//              temp[i] = data[i];
//          }
//          s = String.valueOf(temp);

          s = s.substring(0,len-2);
      }

      return s;
    }
}
