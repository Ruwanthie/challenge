package com.howtodoinjava.demo.jsonsimple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample 
{

    public static void main(String[] args) throws Exception {

        JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("dataset.json");
        //System.out.println(jsonObject);
        System.out.println(jsonObject.get("data"));

        String str = jsonObject.get("data").toString();
        String[] newArr =  arr(str);
        int[] numArr = array(newArr);
        int[] result = result(numArr);
        //reverse(numArr,result);

        for (int a : result)
            System.out.print(a+",");
       // System.out.println(Arrays.toString(result));





    }

   /* public static int increment(int[] arr, int index){
        int count =1;

        if(arr[index-1]>arr[index]){
            while(arr[index+1]<arr[index]){
                count++;

            }
            index++;
        }

        return count;
    }
*/
    /*public static int[] checkPrevious(int []arr){
        int size = arr.length, newsize =0;
        int result[] = new int[size];
        int toppingSize =1;
        result[0]=1;

        for(int i=1;i<size;i++){
            if(arr[i]==arr[i-1]){
                result[i] = toppingSize;
            }

            else if(arr[i]>arr[i-1]){
                    result[i] = result[i-1]+1;
            }
            else if(arr[i]<arr[i-1]){
                   int counter = increment(arr,i);
                   result[i]=counter;

                   while(i<0){
                       result[i+1]=decrement(counter);
                   }
            }
            else
                result[i] = toppingSize;


        }
        return result;
    }*/


  /*  public static int decrement(int count){
        return count--;
    }*/
    public static String[] arr(String str) throws Exception {

        String[] arrOfStr = str.split(",");
        String[] arr,arr2;

        for (int i=0;i<arrOfStr.length;i++){
            int index = arrOfStr.length-1;
            if(i==0){
                arr = arrOfStr[0].split("\\[");
                arrOfStr[0]=arr[1];
            }
            if(i==index){
                arr2 = arrOfStr[index].split("\\]");
                arrOfStr[index]=arr2[0];
            }
        }
        return arrOfStr;
    }

    public static int[] array(String[] str){
        int size = str.length;
        int[] arr = new int[size];

        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        return arr;
    }
    public static Object readJsonSimpleDemo(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }

    public static int[] result(int[] array){
        int k = 1;
        int[] result = new int[array.length];
        for (int i=0;i<array.length;i++){
            if (k == 0) {
                int j = 0;
                while (i - j - 1 >= 0) {
                    if (array[i - j] < array[i - j - 1]) {
                        result[i - j - 1] += 1;
                    } else {
                        break;
                    }
                    j += 1;
                }
                k = 1;
            }
            result[i]=k;
            if (i+1 < array.length && array[i] < array[i+1]){
                k += 1;
            }
            else{
                if (k > 1){
                    k = 1;
                }else{
                    k = 0;
                }
            }
        }
        return result;
    }
}
