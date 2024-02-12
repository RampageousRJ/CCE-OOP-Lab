import java.io.*;

class Filter implements FilenameFilter{
    String st;
    Filter(String str){
        st=str;
    }
    public boolean accept(File f,String name){
        return name.endsWith(st);
    }
}

class impl{
    public static void main(String[] args) {
        File d=new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//File Handling");
        Filter fl=new Filter(".java");
        // File f[]=d.listFiles(fl);
        // for(int i=0;i<f.length;i++){
        //     System.out.println(f[i]);
        // }
        String str[]=d.list(fl);
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
    }
}