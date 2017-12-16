package by.it.group573601.gylinskiy.lesson06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: наибольшая возрастающая подпоследовательность
см.     https://ru.wikipedia.org/wiki/Задача_поиска_наибольшей_увеличивающейся_подпоследовательности
        https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Дано:
    целое число 1≤n≤1000
    массив A[1…n] натуральных чисел, не превосходящих 2E9.

Необходимо:
    Выведите максимальное 1<=k<=n, для которого гарантированно найдётся
    подпоследовательность индексов i[1]<i[2]<…<i[k] <= длины k,
    для которой каждый элемент A[i[k]]больше любого предыдущего
    т.е. для всех 1<=j<k, A[i[j]]<A[i[j+1]].

Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ

    Sample Input:
    5
    1 3 3 2 6

    Sample Output:
    3
*/

public class A_LIS {


    int getSeqSize(InputStream stream) throws FileNotFoundException
    {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //общая длина последовательности
        int n = scanner.nextInt();
        int[] m = new int[n];
        //читаем всю последовательность
        for (int i = 0; i < n; i++) {
            m[i] = scanner.nextInt();
        }


        //тут реализуйте логику задачи методами динамического программирования (!!!)
        int result = 0;
        int[] succession = new int[n];

        for (int i = 0; i < n; i++)
        {
            succession[i] = 1;
            System.out.println("i = " + i);
            for (int j = 0; j < i; j++)
            {
                System.out.println("j = " + j);
                System.out.println("Сравниваем (" + m[j] + ") >= (" + m[i] + ")");
                if (m[j] >= m[i]) continue;
                succession[i] = succession[j] + 1;
                System.out.println("Записали suc[" + i + "] = " + succession[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            result = Math.max(result, succession[i]);
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException
    {
        String root = System.getProperty("user.dir") + "/src/";
        int result;
        try (InputStream stream = new FileInputStream(root + "by/it/group573601/gylinskiy/lesson06/dataA.txt"))
        {
            A_LIS instance = new A_LIS();
            result = instance.getSeqSize(stream);
            System.out.print(result);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

    }
}

