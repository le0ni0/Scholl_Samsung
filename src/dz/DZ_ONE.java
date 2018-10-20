package dz;

import java.util.Scanner;

public class DZ_ONE {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[32m";
    public static String chi;
    public static void main (String[]arr){
        Scanner sc=new Scanner(System.in);
        System.out.println(ANSI_YELLOW+"<Yellow>-ПОДХОДИТ"+ANSI_RESET);
        System.out.println(ANSI_RED+"<Red>-НЕ ПОДХОДИТ"+ANSI_RESET);
        System.out.println("Если хотите дробь введите через точку.");
        System.out.print("Введите число: ");
        chi=sc.nextLine();
        float cel=Float.parseFloat(String.valueOf(chi));
        if (cel>=-128&&cel<=127){
            System.out.println(ANSI_YELLOW+"BYTE"+ANSI_RESET);
        }else{
            System.out.println(ANSI_RED+ "BYTE" +ANSI_RESET);
        }
        if (cel>=-32768&&cel<=32767){
            System.out.println(ANSI_YELLOW+"SHORT"+ANSI_RESET);
        }else{
            System.out.println(ANSI_RED+"SHORT"+ANSI_RESET);
        }
        if (cel>=-2147483648&&cel<=2147483647){
            System.out.println(ANSI_YELLOW+"INT"+ANSI_RESET);
        }else{
            System.out.println(ANSI_RED+"INT"+ANSI_RESET);
        }
        int s=0;
        char [] st=chi.toCharArray();
        for(int i=0;i<st.length;i++){
            if(st[i]=='.'){
                s=s+1;
            }
        }
        if(s==0){
            cell();
        }else{
            dropn();
        }
    }
    public static void cell(){
        int t=1;
        long cel=Long.parseLong(String.valueOf(chi));
        if (cel<0){
           t=t*(-1);
           cel=cel*(-1);
        }
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
    public static void dropn(){
        char [] st=chi.toCharArray();
        long cel=0;
        int i2=0;
        long drop=0;
        while(!(st[i2]=='.')){
            int x=Integer.parseInt(String.valueOf(st[i2]));
            cel=(cel*10)+x;
            st[i2]=0;
            i2++;
        }
        for(int i=i2+1;i<st.length;i++){
            int x=Integer.parseInt(String.valueOf(st[i]));
            drop=(drop*10)+x;
        }
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
        long bol=1;
        while(bol<=drop){
            bol=bol*10;
        }
        String p="";
        for(int i=1;i<=11;i++){
            if(!(drop==0)){
                if(drop*2<bol){
                    drop=drop*2;
                    p=p+"0";
                }else{
                    drop=drop*2-bol;
                    p=p+"1";
                }
            }else{
                break;
            }

        }
        char [] mas=d.toCharArray();
        for(int i=mas.length-1;i>=0;i--){
            System.out.print(mas[i]);
        }System.out.print('.'+p);
    }
}
