package mvc;

import java.util.ArrayList;

public class Main {

static ArrayList<Vershina> v=new ArrayList<Vershina>(); //sozdaem spisok vershin = vizivaem kostruktor chtobi rabotat s nim
    static ArrayList<Integer> proydeno =new ArrayList<Integer>(); // dla obhoda v glubinu

public static void addVershina(int n) { //peredaem nomer vershin kotor dobavit
    v.add(new Vershina(n));
}
    public static void addRebro(int n, int k) { //sovsem drugoy metod
        for (int i = 0; i < v.size(); i++) { // poka i menshe razmera spiska versin po indeksam (indeksi ne svazani s nomerami)
            if (v.get(i).numb==n) { //poluchit get nomer vershini i sravnivaem s  nomerom n iz 13 stroki kotoriy nam nuzhen
                v.get(i).addRebro(k); // iz spiska poluchaem vershinu n i provodim rebro v vershinu k
            }
            }
    }

    public static void delVershina(int n) {
        for (int i = 0; i < v.size(); i++) {
if (v.get(i).numb==n) { // v.get (i) = v [i] analogia no ne tochnoe opredelenie
    v.remove(i); // udalyaem po indeksu i
}
        }
        for (int i = 0; i < v.size(); i++) {
            v.get(i).delRebro(n); // udalyaem soorvetstvenno rebra kotorie shli k udalennoy vershine
        }
    }

    public static void delRebro(int n, int k) {
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).numb==n) {
                v.get(i).delRebro(k);
            }
        }
    }

    public static void showVershina() {
        for (int i = 0; i < v.size(); i++) {
            v.get (i).show();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            addVershina (i+5); // sozdaem vershinu
            for (int j = 0; j < 3; j++) {
                addRebro (i+5, j+7); // dobavlyaem k ney rebra chtob pokazat kak rabotaut nachi funkzii
            }
        }
addRebro(6,5);
        addVershina(25); // vershina bez reber
        System.out.println("Graf after add elements");


showVershina ();
        delVershina(8);
        delRebro(5,9);

        System.out.println("Graf after del elements");
showVershina();
        // write your code here


        System.out.println("Obhod v glubinu");
        proydeno.clear(); // nichego ne proydeno budem pisat v nego potom kakie vershini proshli
        obhodGlubinu(5); // nachinaem s vershini 5 // nachat nuzhno s kakoy to vershini // vivoditsa odin raz 
}
    //metod obhod v glubinu
    public static void obhodGlubinu (int n) { // peredali nomer vershini c kotoroy nachinaetsa obhod
        if (proydeno.contains(n)){ // esli eta vershina proydena
            return;
        }
    proydeno.add (new Integer(n)); // pomechaem chto eta vershina proydena dobavlyaem v spisok proydennich
        for (int i = 0; i < v.size(); i++) { //
            if (v.get(i).numb==n) { //nachodim vershinu s etim nomerom
                for (int j = 0; j < v.get(i).rebra.size(); j++) { // esli nasli, nachinaem obchodit te vershini v kotorie iz nee idut rebra
                    obhodGlubinu(v.get(i).rebra.get(j)); //rekursivniy visov etoy zhe funkzii
                }
            }
        }
        System.out.println(n); // kogda vse pro vershinu izvestno - izvestno kuda idut rebra ot etoy vershini, vivodim ee na ekran//
    } // 5-ka vivelas samoy posledney, hotya mi nachinali s nee




}



