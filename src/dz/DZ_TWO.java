package dz;

import java.util.Scanner;

public class DZ_TWO {
    public static int board[][];
    public static int n;
    public static void main(String[] arr) throws InterruptedException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите ник первого: ");
        String player1=sc.nextLine();
        System.out.println("Введите ник второго: ");
        String player2=sc.nextLine();
        System.out.println("Введите величину доски:");
        n=sc.nextInt();
        board=new int[n][n];
        System.out.print("Подкидывается жребье");
        for(int i=0;i<3;i++){
            Thread.sleep(250);
            System.out.print(".");
            Thread.sleep(250);
        }
        Thread.sleep(500);
        System.out.println();
        int glavPlayer=(int) ( Math.random() * (3-1)+1 );
        if(glavPlayer==1){
            System.out.println(player2+" тебе сегодня везёт.");
        }else {
            System.out.println(player1+" тебе сегодня везёт.");
        }
        Thread.sleep(1000);
        String theend="Да";
        sc.nextLine();
        int ch4t1=0;
        int ch4t2=0;
        while (theend.equals("Да")|theend.equals("да")|theend.equals("Yes")|theend.equals("yes")){
            vivod();
            int pr=0;
            for(int i=glavPlayer;i<n*n+glavPlayer;i++) {
                if(i%2==0){
                    if (proverka(i-1)==1){
                        System.out.println("Выйграл "+player2);
                        System.out.print("Счёт: ");
                        ch4t1++;
                        System.out.print(ch4t1+":"+ch4t2);
                        System.out.println();
                        pr++;
                        break;
                    }else {
                        System.out.println("Ход игрока: "+player1);
                        hod(i);
                        vivod();
                    }
                }else {
                    if (proverka(i-1)==1){
                        System.out.println("Выйграл "+player1);
                        System.out.print("Счёт: ");
                        ch4t2++;
                        System.out.print(ch4t1+":"+ch4t2);
                        System.out.println();
                        pr++;
                        break;
                    }else {
                        System.out.println("Ход игрока: "+player2);
                        hod(i);
                        vivod();
                    }
                }
            }if (pr==0){
                System.out.println("У вас ничья!");
            }
            System.out.println("Хотите сыграть снова?");
            theend=sc.nextLine();
            glavPlayer++;
            for (int i=0;i<n;i++){
                for (int q=0;q<n;q++){
                    board[i][q]=0;
                }
            }
        }
    }
    public static void hod(int hod){
        Scanner sc=new Scanner(System.in);
        System.out.println("Выбери строку и столбец: ");
        int str=sc.nextInt();
        int sto=sc.nextInt();
        if(str<=n && sto<=n && sto>=1 && str>=1 && board[str-1][sto-1]==0){
            board[str-1][sto-1]=hod%2+1;
        }else{
            System.out.println("Введите другую кардинату");
            hod(hod);
        }
    }
    public static int proverka(int hod) {
        hod = hod % 2 + 1;
        int str = 0;
        int sto = 0;
        int d1=0;
        int d2=0;
        for (int i = 0; i < n ; i++) {
            for (int q = 0; q < n ; q++) {
                if (board[i][q] == hod) {
                    str++;
                }
                if (board[q][i] == hod) {
                    sto++;
                }
            }
            for (int q=0;q<n;q++){
                if (board[q][q]==hod){
                    d1++;
                }
                if(board[q][n-q-1]==hod){
                    d2++;
                }
            }
            if (str == n |sto==n|d1==n|d2==n) {
                return (1);
            } else {
                str = 0;
                sto = 0;
                d1=0;
                d2=0;
            }
        }
        return(0);
    }
    public static void vivod() {
        int strock=0;
        for (int i=0;i<n;i++) {
            for (int q = 0; q<n; q++) {
                switch (board[i][q]) {
                    case 0:
                        System.out.print("   ");
                        break;
                    case 1:
                        System.out.print(" X ");
                        break;
                    case 2:
                        System.out.print(" O ");
                        break;
                }
                if (q < n-1) {
                    System.out.print("|");
                }
            }
            int palki = 0;
            System.out.println();
            while (strock < n-1) {
                while (palki < n) {
                    System.out.print("----");
                    palki++;
                }
                System.out.println();
                strock++;
                break;
            }
        }
    }
}

