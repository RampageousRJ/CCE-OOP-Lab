import java.io.*;
import java.util.*;
class FileCreate{
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        File f=new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//File Handling//","CreateFile.txt");
        f.createNewFile();
        FileInputStream fi=new FileInputStream(f);
        FileOutputStream fo=new FileOutputStream(f,true);
        int s;
        String str=sc.nextLine();
        byte b[]=str.getBytes();
        fo.write(b);
        // fo.newLine();
        while((s=fi.read())!=-1){
            System.out.print((char)s);
        }
        fi.close();
        fo.close();
        sc.close();
    }
}