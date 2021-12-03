public class Lab_2 {
/*Розробити алгоритм і програму дихотомічного пошуку. В якості
вихідних даних слід використовувати масив цілих чисел, який формується за
допомогою датчика випадкових чисел з діапазоном від 0 до 100. Аргумент
пошуку – число.
*/

    public static void zadacha(int n) {

        int[] a = new int[n];
        int par = 10;


        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 101);
        }
        obmin(a);//puzirkom
        //start source
        int start = 0, end = n-1;
        int k;
        while (start <= end) {
            k = (start+end)/2;//seredina intervala
            if (a[k]==par) {
                //System.out.println("Found");
                break;
            }
            else if (a[k]<par) {
           start = k+1;
            }
            else end = k-1;
        }
        if (start > end) {
         //   System.out.println("Was not found");
        }
    }

    public static void rozrach_sumarn_chas(int n, int k) {
        System.out.println("n=" + n + "k=" + k);
        long m1 = System.currentTimeMillis();
        for (int i = 0; i < k; i++) {
            zadacha(n);
        }
        long m2 = System.currentTimeMillis();
        System.out.println((double) (m2 - m1));

    }

    public static void obmin(int[] a) {
        int n = a.length;// dlina masiva
        int k = 0;//kol perestanovok
        int tmp = 0;//vremennaua peremennaya nuznaya dlya obmena
        for (int i = 0; i < n - 1; i++) {
            k = 0;
            for (int j = 1; j < n - i; j++) {
                if (a[j - 1] > a[j]) {
                    k++;
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
            if (k == 0) {
                break; //return;//massiv otsotrtirovan
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            rozrach_sumarn_chas((int) Math.pow(10, i), 100);

        }

        System.out.println("****************************************");
        for (int i = 1; i < 5; i++) {
            rozrach_sumarn_chas((int) Math.pow(10, i), 100);


        }


    }
}
