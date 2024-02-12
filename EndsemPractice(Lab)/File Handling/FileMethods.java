import java.util.*;
import java.io.*;

class FileMeth{
    public static void main(String[] args) throws IOException{
       
        File f=new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//File Handling//FileMethods.txt");
        File d=new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//File Handling//MIT");
        File d1=new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//File Handling//");
        Scanner sc=new Scanner(System.in);
        f.createNewFile();

        FileWriter fw=new FileWriter(f,true);
        FileInputStream fr=new FileInputStream(f);

        // String str=sc.nextLine();

        fw.write("//nThis is new line");
        
        //values get appended as soon as FileWriter gets closed
        fw.close();
        
        //FileInputStream exclusive method
        byte b[]=new byte[100];
        fr.read(b);
        String st=b.toString();
        System.out.println(st.toCharArray());
        fr.close();
        //Returns name of file
        System.out.println(f.getName());
        //Returns path of parent
        System.out.println(f.getParent());
        System.out.println(f.getParentFile());
        //Returns path of file
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        //Boolean returns if file exists or not
        System.out.println(f.exists());
        //Boolean returns if read/write
        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        //Boolean returns for specifications
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.isAbsolute());
        //Long returns total length of file
        System.out.println(f.length());

        if(d.mkdir()){
            System.out.println("True");
        }
        
        File flist[]= d1.listFiles();
        for(int i=0;i<flist.length;i++){
            System.out.println(flist[i]);
        }

        sc.close();
    }
}