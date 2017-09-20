package by.it.group573602.shtanova.lesson01;
 import java.util.Vector;
/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */
 import java.util.ArrayList;
public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        ArrayList<Long> fl = new ArrayList();
        fl.add((long)0);
        fl.add((long)1);
        for (int  i = 2; i < m * 6; i++) {
            fl.add((fl.get(i - 1)+ fl.get(i - 2))% m);
            if (fl.get(i) == 1 && fl.get(i - 1) == 0){
                break;
            }
        }
        long period = fl.size() - 2;
        int val = (int) (n % period);
         return fl.get(val);
    }


}

