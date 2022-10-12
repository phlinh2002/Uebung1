import java.util.Scanner;
public class Uebung1 {
    public static  void main(String[] args) {
        int prufen = 0;
        String  [] name = new String[4];
        String wort = "buch";
        int a = wort.length();
        for(int v = 0; v< a; v++){
            name[v] = String.valueOf(wort.charAt(v));
        }
        System.out.print("Bitte einen Buchstabe geben: ");
        Scanner add = new Scanner(System.in);
        String buchstabe;
        buchstabe = add.next();
        System.out.println("Der eingelesene Buchstabe laut: " + buchstabe);
        add.close();
        for(int i = 0; i < 4; i++){
            System.out.println(i);
            if(buchstabe == name[i]){
                System.out.println("Richtig:" + buchstabe);
            }
            else{
                prufen++;
            }
        }
        if (prufen+1 == wort.length()){
            System.out.println("Probieren Sie nochmal");
        }

    }
}
