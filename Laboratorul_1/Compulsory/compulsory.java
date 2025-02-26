public class compulsory
 { 
    public static void main(String[] args)
    { 
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);

         n = n * 3;
         n = n + 0b10101;
         n = n + 0xFF;
         n = n * 6;

         int sum_digits = n;
         while(sum_digits > 9) {
            sum_digits = 0;
            while(n != 0)
            {
                sum_digits += n%10;
                n/=10;
            }
            n = sum_digits;
         }

         System.out.println("Willy-nilly, this semester I will learn " + languages[sum_digits]);
    } 
}