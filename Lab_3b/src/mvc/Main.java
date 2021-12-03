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


        sliyanie (a, 0, n-1);

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

    public static int[] sliyanie (int[] a, int left, int right) {
        int m = 0;//vremenn peremen - graniza chastey
        int[] b = new int[right - left + 1];//rezultat chast massiva iz 3 elementov s index s left po right
        kPorivnyan++;
        if (right == left) { //1-e sravnenie
            b[0] = a[left];// 1 element
            kObminiv++;
            return b;
        }
        m = (left + right) / 2;
        int[] x = sliyanie(a, left, m);
        int[] y = sliyanie(a, m + 1, right);
        int index1 = 0, index2 = 0, index3 = 0;
        while (index1 < x.length && index2 < y.length) {
            kPorivnyan++;
            if (x[index1] < y[index2]) {
                b[index3] = x[index1];
                index3++;
                index1++;
                kObminiv++;
            } else {
                b[index3] = y[index2];
                index3++;
                index2++;
                kObminiv++;
            }
        }
        for (int i = index1; i < x.length; i++) {
            b[index3] = x[i];
            index3++;
            kObminiv++;
        }
        for (int i = index2; i < y.length; i++) {
            b[index3] = y[i];
            index3++;
            kObminiv++;
        }
        return b;
    }



    public static void main(String[] args) {
        for (int i = 3; i < 4; i++) {
            rozrach_sumarn_chas((int) Math.pow(10, i), 1);

        }

        System.out.println("****************************************");
        for (int i = 2; i < 6; i++) {
            rozrach_sumarn_chas((int) Math.pow(10, i), 1000);


        }


    }
}
