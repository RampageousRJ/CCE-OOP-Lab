import java.io.*;
import java.util.Scanner;

class WordOccurance{
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        File f=new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//File Handling//WordOccurance.txt");

        if(!f.exists()){
            f.createNewFile();
        }
 
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);

        int occ=0;
        String str,key="java";
        while((str=br.readLine())!=null){
            String s[]=str.split(" ");
            for(int i=0;i<s.length;i++){
                if(s[i].contains(key)){
                    occ++;
                }
            }
        }
        System.out.println("Total occurances: "+occ);
        fr.close();
        sc.close();
    }
}