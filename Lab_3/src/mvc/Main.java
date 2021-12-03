package mvc;

public class Main {

    public static int kObminiv, kPorivnyan = 0;
    public static void zadacha(int n, int metod ) {

        int[] a = new int[n];
       if (metod == 1) {
           poZrostannyu(a);
       }
       else if  (metod == 2) {
           vipadkovi (a);
        }
       else poZmenshennyu(a);


                obmin(a);

    }

    public static void rozrach_sumarn_chas(int n, int k) {
        System.out.println("n=" + n + "k=" + k);
        long m1 = System.currentTimeMillis();
       kObminiv = 0;
               kPorivnyan = 0;
        zadacha(n,1);
        System.out.println("Po zrostannyu  n = "  + n);
        System.out.println("Kilkict obminiv  = "  + kObminiv);
        System.out.println("kilkist porivnyan = "  + kPorivnyan);

        kObminiv = 0;
        kPorivnyan = 0;
        for (int i = 0; i < k; i++) {
            zadacha(n, 2);
        }
            System.out.println("Vipadkovi  n = " + n);
            System.out.println("Kilkict obminiv  = " + kObminiv/k);
            System.out.println("kilkist porivnyan = " + kPorivnyan/k);

        kObminiv = 0;
        kPorivnyan = 0;
        zadacha(n,3);
        System.out.println("Po Zmenshennyu  n = "  + n);
        System.out.println("Kilkict obminiv  = "  + kObminiv);
        System.out.println("kilkist porivnyan = "  + kPorivnyan);





        long m2 = System.currentTimeMillis();
        System.out.println((double) (m2 - m1));

    }

    public static void poZrostannyu (int [] a) {
        for (int i = 0; i < a.length; i++) {
            a [i] = i;
        }
    }

    public static void poZmenshennyu (int [] a) {
        for (int i = 0; i < a.length; i++) {
            a [i] = a.length - i;
        }
    }

    public static void vipadkovi (int [] a) {
        for (int i = 0; i < a.length; i++) {
            a [i] = (int) (Math.random() * a.length);
        }
    }

    public static void obmin(int[] a) {
        int n = a.length;
        int k = 0;
        int tmp = 0;
        for (int i = 0; i < n - 1; i++) {
            k = 0;
            for (int j = 1; j < n - i; j++) {
                kPorivnyan++;
                if (a[j - 1] > a[j]) {
                    k++;
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                    kObminiv++;
                }
            }
            kPorivnyan++;
            if (k == 0) {
                break; //return;
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 3; i < 4; i++) {
            rozrach_sumarn_chas((int) Math.pow(10, i), 1);

        }

        System.out.println("****************************************");
        for (int i = 2; i < 5; i++) {
            rozrach_sumarn_chas((int) Math.pow(10, i), 1000);


        }


    }
}
