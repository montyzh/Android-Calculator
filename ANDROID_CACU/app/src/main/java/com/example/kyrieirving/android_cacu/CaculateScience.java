package com.example.kyrieirving.android_cacu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ExecutionException;


/**
 * Created by Kyrie Irving on 2018/4/9.
 */

public class CaculateScience {
    //精度
    final static int scale = 9;


    /*
    工具判断函数
     */
    //***************************************************
    //判断字符串是否为小数或是小数点
    public static  boolean isDigitOrDot(char c){

        return ((c >= '0') && (c <= '9') || (c == '.'));
    }
    //判断字符是否为操作符
    public static  boolean isOperator(char s)
    {

        return (s == '+')||(s == '-')||(s == '*')|| (s == '/') ||(s == '^');
    }
    //判断字符是否为括号
    public static boolean isSymbol(char c){
        return (isOperator(c) || (c == '(') || (c == ')'));
    }
    //判断是否为正负号
    public static boolean isSign(char c)
    {
        return (c == '+') || (c == '-');
    }
    //判断字符串是否为数字或是double
    public static boolean isNumeric(String sContentValue){

        boolean bCheckResult = true;
        try
        {
            Double dCheckValue = Double.parseDouble(sContentValue);
            if (dCheckValue instanceof Double == false)
            {
                //判断是否为double
                bCheckResult = false;
            }
        }
        catch(NumberFormatException e)
        {
            //如果出现异常就直接判定为不是
            bCheckResult = false;
        }
        //放回判定结果
        return bCheckResult;
    }
    //判断字符串是否为左括号
    //用于后面的后缀表达式的转换过程
    public static boolean isLeft(String s)
    {
        return (s=="(");


    }

    //判断字符串是否为右括号
    //用于后面的后缀表达式的转换过程
    public static boolean isRight(String s){

        return (s==")");
    }
    //返回操作符的优先级
    public static int priority(String s)
    {
        int ret = 4;
        if ((s.equals("+"))||(s.equals("-"))){
            ret=1;
        }
        if ((s.equals("*"))|| (s.equals("/"))){
            ret=2;
        }
        if (s.equals("^")){

            ret=3;
        }

        return ret;
    }

    //***************************************************
    /*
        *
        * 此函数用于拆分界面获取到的字符串
        * 将拆分后的字符串存在队列里面并返回
        * 函数参数传入用户输入的的字符串
        *

     */
    //***************************************************
    public static Queue<String> split(String exp){
        Queue<String> ret = new LinkedList<String>();   //返回的队列
        String num = new String();      //定义变量用于拆分下数字的累计
        String pre = new String();      //用于存放前一个字符，便于后面判断符号是否为正负号
        for(int i=0;i<exp.length();i++)//变量表达式字符串
        {
            if(isDigitOrDot(exp.charAt(i)))//是否为数字或是小数点，如果是就累计在num中
            {
                num+=exp.charAt(i);
                pre=String.valueOf(exp.charAt(i));        //保存前一字符
            }
            else if(isSymbol(exp.charAt(i)))  //判断是否为符号
            {
                if(!num.isEmpty())  //判断num是否为空，一般不为空
                {
                    ret.offer(num);  //是符号就把前面累加的num保存在队列中去
                    num = "";//清空以便于保存后面的操作数
                }
                if(isSign(exp.charAt(i))&&
                        ((pre.isEmpty())||(pre.equals("("))||
                                //前一字符有时为空，所以需要判空处理
                                (!pre.isEmpty() && isOperator(pre.charAt(0)))))
                //判断符号是否是正负号，如果是正负号那就把此保存在num中，
                //因为正负号也是数字的一部分
                {
                    num += exp.charAt(i);
                }
                else{
                    //如果不是正负号，那就是运算符，就存放到队列中
                    ret.offer(String.valueOf(exp.charAt(i)));
                }
                pre=String.valueOf(exp.charAt(i));//保存一手前一字符
            }
        }
        if(!num.isEmpty()){
            ret.offer(num);
        }
        return ret;
    }
    //***************************************************
	      /*
	          *
	          * 该函数是将中缀表达式转换为计算机能进行处理的后缀表达式
	          * 参数应传入保存好的分离过的表达式
	          *
	       */
	      //算法思路
	      /*

	        *    1）如果遇到数字，我们就直接将其输出。

            *   2）如果遇到非数字时，若栈为空或者该符号为左括号或者栈顶元素为括号，直接入栈。

            *   3）如果遇到一个右括号，持续出栈并输出符号，直到栈顶元素为左括号，然后将左括号出栈（注意，左括号只出栈，不输出），右括号不入栈

            *  4）如果遇到运算符号且栈非空，查看栈顶元素，如果栈顶元素的运算优先级大于或者等于该运算符号，则持续出栈，直到栈顶元素优先级小于该运算符。最后将该元素入栈

            *  5）如果我们读到了输入的末尾，则将栈中所有元素依次弹出。
	        *
	       */
    public static Queue<String> change(Queue<String> z){
        //用于存储返回的结果
        Queue<String> ret  = new LinkedList<String>();
        //栈的操作
        Stack<String> bk = new Stack<String>();
        //前一个字符
        String sta_pro = new String();
        //foreach 遍历拆分过的字符串
        for (String it: z) {
            //如果为double或是数字
            if(isNumeric(it))
            {
                //先保存到队列中
                ret.offer(it);

            }
            //如果字符为符号

            else if (it.length()==1 && (it.equals("+")||it.equals("-")||
                    it.equals("*")||it.equals("/")||it.equals("(")||it.equals(")")||it.equals("^")))
            {
                //有两种分类（操作符和括号）
                //如果是操作符
                if(it.equals("+")||it.equals("-")||it.equals("*")||it.equals("/")||it.equals("(")
                        ||it.equals("^"))
                {
                    //如果遇到运算符号且栈非空
                    if(!bk.isEmpty())
                    {
                        //查看栈顶元素，如果栈顶元素的运算优先级大于或者等于该运算符号，
                        // 则持续出栈，直到栈顶元素优先级小于该运算符。最后将该元素入栈
                        while(true)
                        {
                            sta_pro=bk.pop();

                            if(priority(it)<=priority(sta_pro)){
                                if(sta_pro.equals("(")) {
                                    bk.push(sta_pro);
                                    bk.push(it);
                                    break;

                                }
                                ret.offer(sta_pro);
                                if(bk.isEmpty()){
                                    bk.push(it);
                                    break;

                                }
                            }
                            else if(priority(it)>priority(sta_pro)){
                                bk.push(sta_pro);
                                bk.push(it);
                                break;

                            }
                        }
                    }
                    else if(bk.isEmpty())
                    {
                        bk.push(it);
                    }
                }
                //如果遇到一个右括号，持续出栈并输出符号，直到栈顶元素为左括号，
                // 然后将左括号出栈（注意，左括号只出栈，不输出），右括号不入栈
                else if(it.equals(")"))
                {
                    while(!bk.isEmpty())
                    {
                        sta_pro = bk.pop();
                        if(!sta_pro.equals("(")) {
                            ret.offer(sta_pro);
                        }
                        else if(sta_pro.equals("(")) {
                            break;
                        }
                    }
                }
            }
        }
        //如果我们读到了输入的末尾，则将栈中所有元素依次弹出。
        while(!bk.isEmpty()){
            sta_pro=bk.pop();
            ret.offer(sta_pro);
        }
     return ret;
    }



    //***************************************************
    public static String Caculator (String display){
        Queue<String> expression = new LinkedList<String>();
        expression = change(split(display));
        String ret = new String();
        //操作数a
        String a = new String();
        //操作数b
        String b = new String();
        //操作符
        String o = new String();
        //前一结果
        String pre_res  = new String();
        Stack<String> result = new Stack<String>();
        //  遍历后缀表达式
        for (String it:expression) {
            //如果是数字就直接进栈
            if(isNumeric(it))
            {
                result.push(it);
            }
            //如果是操作符弹出两个操作数进行运算
            else if(it.equals("+")||it.equals("-")||it.equals("*")||it.equals("/")||it.equals("^"))
            {
                try{
                    a=result.pop();
                    b=result.pop();
                    o=it;
                    pre_res = BigDwcimalCaculate(a,b,o);
                    //将得到的结果保存起来，用于后面的运算做准备
                    result.push(pre_res);
                }catch (EmptyStackException e){
                    e.getStackTrace();
                    return "ERROR!";
                }
            }
        }
        //所有运算结束时返回结果
        try{
            try{

                ret = result.pop();
                //将表达式的结果的精确度降低一位，可以解决1/3+1/3+1/3 = 0.999999类似的问题
                BigDecimal result_b = new BigDecimal(ret);
                // 将自身chuyi一，可以设置精度
                double result_d =result_b.divide(BigDecimal.ONE,scale-2,BigDecimal.ROUND_HALF_UP).doubleValue();
                //调用Caculate里的方法将返回的结果去掉.0的形式
                ret = Caculate.clear_dig_for_int(String.valueOf(result_d));
                //****************************************************
                //返回结果
                return ret;
            }catch (NumberFormatException e1){
                //捕获此异常是为了BigdecimalCacluate方法中出错返回的是“ERROR!”,让Bigdecimal（result_b）无法初始化的问题
                e1.getStackTrace();
                return "ERROR!";
            }

        }catch (EmptyStackException e2){
            e2.getStackTrace();
            return "ERROR!";
        }

    }



    //BigDecimal的具体实现方法


    public static String BigDwcimalCaculate(String a,String b,String o){

        //如果a和b不等于空
        if(!a.isEmpty()||!b.isEmpty()){
        //用bigdecimal的方法实现计算
            BigDecimal x = new BigDecimal(a);
            BigDecimal y = new BigDecimal(b);
            BigDecimal one = new BigDecimal("1");
            //double存放结果
            double result = 0.0 ;
            //根据参数操作符选择计算
            try {
            switch (o){
                    case "+":
                        BigDecimal ret_a = y.add(x);

                        result = ret_a.setScale(scale , BigDecimal.ROUND_HALF_UP).doubleValue();
                        break;
                    case "-":
                        BigDecimal ret_s = y.subtract(x);
                        result = ret_s.setScale(scale , BigDecimal.ROUND_HALF_UP).doubleValue();
                        break;
                    case "*":
                        BigDecimal ret_m = y.multiply(x);
                        result = ret_m.setScale(scale , BigDecimal.ROUND_HALF_UP).doubleValue();
                        break;
                    case "/":
                        //divide精度特殊处理
                        BigDecimal ret_d = y.divide(x, scale, BigDecimal.ROUND_HALF_UP);
                        result = ret_d.setScale(scale , BigDecimal.ROUND_HALF_UP).doubleValue();
                        break;
                        //负数的开根运算
                                //如果云算数小于零
                    case "^" :  if(y.compareTo(BigDecimal.ZERO) == -1){
                                    BigDecimal ret_p = new BigDecimal(String.valueOf(
                                    //利用math库里的函数能够用double传参
                                    Math.pow(y.doubleValue()*(-1),x.doubleValue())
                        ));
                                    //将返回值精确
                            result = ret_p.divide(BigDecimal.ONE,scale,BigDecimal.ROUND_HALF_UP).doubleValue()*(-1);
                        }
                        else if (y.compareTo(BigDecimal.ZERO) == 1||y.compareTo(BigDecimal.ZERO) == 0){
                        BigDecimal ret_p = new BigDecimal(String.valueOf(
                                //利用math库里的函数能够用double传参
                                Math.pow(y.doubleValue(),x.doubleValue())

                        ));
                        result = ret_p.divide(BigDecimal.ONE,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
                    }
                         break;

            }
            //返回string类型的结果

            }catch (ArithmeticException e){
                e.getStackTrace();
                return  "ERROR!";
            }
            //将结果为.0的形式除去
            //并且返回
        return String.valueOf(result);
        }

        return "ERROR!";
    }


    //计算三角函数的
    //三角函数难以精确所以把它隔离出来

    public static String trigonometric(String num,String O){

        //没有操作数直接显示空白
        if(num.equals("")){

            return "";
        }
        long fact = 1;
        double num_d = 0.0;
        String result = "";
        try{
            num_d = Double.parseDouble(num);
            num_d = Math.PI*num_d/180;

            //用于解决三角函数无法精确的问题
            BigDecimal cBigDecimal = new BigDecimal("1");

            switch (O){

                case "sin":BigDecimal sin = new BigDecimal(String.valueOf(Math.sin(num_d)));

                    num_d = sin.divide(cBigDecimal,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
                    break;
                case "cos":BigDecimal cos  = new BigDecimal(String.valueOf(Math.cos(num_d)));

                    num_d = cos.divide(cBigDecimal,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
                    break;
                case "tan":BigDecimal tan  = new BigDecimal(String.valueOf(Math.tan(num_d)));
                    //tan90 不存在
                    if(num_d == Math.PI*90/180){
                        return "ERROR!";
                    }
                    num_d = tan.divide(cBigDecimal,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
                    break;
                case "!":int n = Integer.parseInt(num);
                            //jiecheng 计算
                            for(int j = 1;j<=n;j++){
                                fact = fact*j;
                            }
                            num_d = fact;
                    break;
            }
        }catch (NumberFormatException e){

            e.getStackTrace();
            return "ERROR!";
        }


        result = String.valueOf(num_d);
        return  Caculate.clear_dig_for_int(result);

    }

    //此函数用于得到表达式中传入三角函数的参数

    //
    public static ArrayList<String> getStrTrigonometricNum(String str){

        int index = -1;
        ArrayList<String> list = new ArrayList<String>();
        try{

            for(int i = 0;i<str.length();i++){
                if(isOperator(str.charAt(i)) == true || str.charAt(i) == '÷'||str.charAt(i) == '×'){
                    index = i;
                }
            }

            list.add(str.substring(index+1,str.length()));
            list.add(str.substring(0,index+1));
            return list;

        }catch(NumberFormatException e){
            e.getStackTrace();


        }
        return list;
    }

    /*

        *此函数的功能用于检测用户的输入的合法性
        * 参数传入字符串表达式
        *

     */

    public static boolean checkInputForDot(String input){

        String subStr = new String();
        int index = -1;

        for(int i = 0;i<input.length();i++){
            //遍历字符串如果是操作符就执行
            if(isOperator(input.charAt(i)) == true){
                //记录最后一个操作符的下标
                index = i ;
            }
        }
        //如果之前没有输入操作符
        if(index == -1){
            //如果没有输入过任何东西就可以直接输入小数点
            if(input.isEmpty()){
                return false;
            }
            //第一个操作数也不能有两个小数点
            else if (!input.isEmpty()){
                return input.indexOf(".") != -1;
            }

        }

        if(index != -1){
            subStr = input.substring(index,input.length());
        }

        //如果找不到小数点就返回false
        return subStr.indexOf(".") != -1 ;

    }


    /*
    *此函数用于在于将屏幕的+ - x ÷ 变为计算机能进行运算的+-/x
    *
    *
    */
    public static String ShiftOperator(String s){

        char[]sArray = s.toCharArray();
        for(int i = 0; i<sArray.length;i++){

            switch (sArray[i]){
                case '×':sArray[i] = '*';break;
                case '÷':sArray[i] = '/';break;
                default:break;
            }
        }
        return s = String.valueOf(sArray);

    }


}


