package mvc;
import java.util.ArrayList;

public class Vershina {
    public int numb;
    public ArrayList <Integer> rebra;
    public Vershina (int n){
        numb = n;
        rebra = new ArrayList<Integer>();
    }
    public void addRebro (int nVersh){
       rebra.add (nVersh);
    }

    public void delRebro (int nVersh){

        rebra.remove(new Integer(nVersh)); //udalyaem obyekt potomu chto systema sama naydet ego inache nam nuzno bilo iskat po indeksu
    }


    public void show (){

        System.out.print(numb + "[");//pokaz est ili net versina
        for (int i = 0; i < rebra.size(); i++) { //pokazat vse versini kuda idut rebra
            if (i!=0) {
                System.out.print(" , ");
                            }
            System.out.print(rebra.get(i));
        }
        System.out.println(" ]");
    }
}