package dz;

import java.util.Scanner;

public class DZ_ONE {
    public static void main (String[]arr){
        Scanner sc=new Scanner(System.in);
        String chi=sc.nextLine();
        char [] st=chi.toCharArray();
        int cel=0;
        int i2=0;
        int q=10;
        int drop=0;
        while(!(st[i2]==',')){
            int x=Integer.parseInt(String.valueOf(st[i2]));
            cel=(cel*q)+x;
            st[i2]=0;
            i2++;
        }
        q=10;
        for(int i=i2+1;i<st.length;i++){
            int x=Integer.parseInt(String.valueOf(st[i]));
            drop=(drop*q)+x;
        }
        System.out.println(cel);
        System.out.println(drop);
        String d="";
        while(!(cel==0)){
            if(cel%2==0){
                d=d+"0";
                cel=cel/2;
            }else {
                d=d+"1";
                cel = (cel - 1) / 2;
            }
        }

        char [] mas=d.toCharArray();
        for(int i=mas.length-1;i>=0;i--){
            System.out.print(mas[i]);
        }
    }
}
//    double src = 123.45;
  //  int res = (int)src; //целая часть
  //  double res2 = src - res;