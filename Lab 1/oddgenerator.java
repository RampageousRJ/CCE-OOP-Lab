import java.util.Scanner;
class oddgen{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        for (int i=1;i<=100;i++){
            if (i%2==0){
                continue;
            }
            System.out.print(" "+i);
        }
        sc.close();
    }
}