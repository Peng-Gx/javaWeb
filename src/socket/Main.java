package socket;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(true){
            String text=scan.nextLine();
            System.out.println("len:"+text.length());
            System.out.println(text);
        }
    }
}