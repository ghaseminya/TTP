/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

/**
 *
 * @author mnm
 */
   import java.util.*;

        public class mnmrandom {

                private static Random rn = new Random();
                public  int rand(int lo, int hi)
                {
                        int n = hi - lo + 1;
                        int i = rn.nextInt() % n;
                        if (i < 0)
                                i = -i;
                        return lo + i;
                }

                public  String randomstring(int lo, int hi)
                {
                        int n = rand(lo, hi);
                        byte b[] = new byte[n];
                        for (int i = 0; i < n; i++)
                                b[i] = (byte)rand('a', 'z');
                        return new String(b, 0);
                }

                public  String randomstring()
                {
                        return randomstring(5, 25);
                }
        public static void main(String a[]){
            mnmrandom mnm=new mnmrandom();
            for(int i=0;i<1000;i++)
            System.out.println(mnm.randomstring(1,5));
        }
        }
