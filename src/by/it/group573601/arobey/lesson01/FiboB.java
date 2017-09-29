package by.it.group573601.arobey.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 33;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {

        BigInteger [] F= new BigInteger[n+1];
        F[0]= BigInteger.valueOf(0);
        F[1]= BigInteger.valueOf(1);

        for (int i=2;i<=n; i++){
            F[i]=F[i-1].add(F[i-2]);
        }
        return F[n];
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
       // return BigInteger.ZERO;
    }

}

