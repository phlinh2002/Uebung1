import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class ComputermanUI {
    public static boolean prufen = false;
    public static  int leben = 8;
    public static final char[] wort = {'P', 'R', 'O', 'G', 'R', 'A', 'M', 'M'};
    public static char[] ausgeben = new char [wort.length];
    private final String Spieler1;

    
    //private final String WoertPlayer;
    private final BufferedReader inBufferedReader;
    private final PrintStream outStream;

    public ComputermanUI(String Spieler1, PrintStream out, InputStream in){
        this.Spieler1 = Spieler1;
        this.outStream = out;
        this.inBufferedReader = new BufferedReader(new InputStreamReader(in));

    }


    public void HerzDesSpieles() throws IOException {
        
        boolean var = true;
        while(var){
            boolean var2 = true;
            String userString = null;
            try{
                userString = inBufferedReader.readLine();
           }
            catch(IOException ex){
                this.outStream.println("Stream nichtlesbar");
            }
        }

    }

    public void Woerterzufaellig(){
       //String liste wird erzeugt
        LinkedList<String> hangmanliste = new LinkedList();

        //inhalte werden hinzugefügt
        hangmanliste.add("Konstruktor");
        hangmanliste.add("Listen");
        hangmanliste.add("Schleife");
        hangmanliste.add("Array");
        hangmanliste.add("Methoden");

        System.out.println(hangmanliste.get((int) (Math.random() * hangmanliste.size()) ));
        /*Random rand = new Random(); //instance of random class
        int upperbound = 5;
          //generate random values from 0-24
        int random = rand.nextInt(upperbound); 
        return hangmanliste[random];*/
        

    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] raten;
        System.out.println("\t\t       COMPUTERMÄNNCHEN");
        System.out.println("\nUnd so geht's:");
        System.out.println("\nSie bekommen ein beliebiges Wort gegeben, welches sie selbst \ndurch das Erraten von Buchstaben versuchen müssen zu entziffern. \nSie können es aber auch mit Wörtern versuchen. :D ");
        System.out.println("Aber aufgepasst!! Bei jeder falschen Eingabe, \nwird der unschuldige Roboter mehr zur Verdamnis gebracht! >_<");
        System.out.println("\nAlso geben Sie sich Mühe und retten sie den Roboter!!!!!");
        System.out.println("\nViel Erfolg! :)");

        System.out.println("Geben Sie bitte Ihr Name");
        String name = scanner.nextLine();
        System.out.println("Willkommen " + name);
        System.out.println("Lass uns Spielen ! ");
       // char [] wort = {'P', 'R', 'O', 'G', 'R', 'A', 'M', 'M'};
        

        System.out.println("Das gegebene Wort hat " + wort.length + " Buchstaben");
        for(int i =0; i< wort.length; i++){
            System.out.print("_");
        }

        do{
        prufen = false;
        System.out.println("\nErraten Sie mal ein Buchstabe");
        raten = scanner.next().toUpperCase().toCharArray();
        printArray(check(raten,wort));
        ausgeben = check(raten,wort);
        leben = draw(leben);
        }while (leben>-1);


        

    
        


        // Deklaration und Initialisierung der Objektvariable User von der KLasse ComputermanUI
        ComputermanUI user = new ComputermanUI(name, System.out, System.in);;


    }
    public static void printArray(char[] arr){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
    public static char[] check(char [] raten,char [] wort){
        
        for(int i = 0; i<raten.length; i++){
            for(int j =0; j< wort.length; j++){
                if(raten[i] != wort[j]){
                    if(ausgeben[j] != wort[j]){
                        ausgeben[j] = '_';
                    }
                    
                }else{
                    ausgeben[j] = raten[i];
                    prufen = true;
                }
            }
        }
        return ausgeben;
    }
    
    public static int draw(int leben){
        if(prufen == false ){
            System.out.println(galgenmannchen(leben));
            System.out.println("\nSie haben falsch erraten!");
            leben --;
        }
        return leben;
    }
    public static void verloren(int leben){
        if (leben ==0){
            System.out.println("Du bist verloren! :(")

        }

    }
    public static String galgenmannchen(int lives) {
        String[] mannchen = new String[9];
        mannchen[0] = ("\n|--------|"+
        "\n|       (_)"+
        "\n|      --|--"+
        "\n|       / )"+
        "\n---");
        mannchen[1] = ("\n|--------|"+
        "\n|       (_)"+
        "\n|      --|--"+
        "\n|       /"+
        "\n---");
        mannchen[2] = ("\n|--------|"+
        "\n|       (_)"+
        "\n|      --|--"+
        "\n|"+
        "\n---");
        mannchen[3] = ("\n|--------|"+
        "\n|       (_)"+
        "\n|        |"+
        "\n|"+
        "\n---");
        mannchen[4]=("\n|--------|"+
        "\n|       (_)"+
        "\n|"+
        "\n|"+
        "\n---");
        mannchen[5]=("\n|--------|"+
        "\n|"+
        "\n|"+
        "\n|"+
        "\n---"
        );
        mannchen[6] =("\n|--------|"+
        "\n|"+
        "\n|"+
        "\n|"+
        "\n---");
        mannchen[7] = ("\n|"+
        "\n|"+
        "\n|"+
        "\n|"+
        "\n---");
        mannchen[8] = ("\n"+
        "\n"+
        "\n"+
        "\n"+
        "\n---");
        return mannchen[lives];
    }


        //
       // user.herzDesSpieles();
        //user.Woerterzufaellig();

}