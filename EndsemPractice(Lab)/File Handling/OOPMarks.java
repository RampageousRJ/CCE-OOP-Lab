import java.io.*;
import java.util.Scanner;

class Stud implements Serializable{
    String name;
    int roll,oopmark;
    Stud(String n,int r,int om){
        oopmark=om;
        name=n;
        roll=r;
    }
}

class FileOperation implements Serializable{
    File f=new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//File Handling//student.txt");
    int num;
    Stud s[]=new Stud[num];
    Scanner sc=new Scanner(System.in);
    
    FileOperation(int n){
        num=n;
    }
    {if(!f.exists()){
    try{
        f.createNewFile();
    }
    catch(Exception e){}
    }}

    void initStudent(){
        for(int i=0;i<num;i++){
            System.out.println("\nEnter details for Student"+(i+1));
            s[i]=new Stud(sc.next(),sc.nextInt(),sc.nextInt());
        }
    }

    void WriteStudentDetails() throws IOException,ClassNotFoundException{
        initStudent();
        FileOutputStream fos=new FileOutputStream("Serial.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        FileWriter fw=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(fw);
        for(int i=0;i<num;i++){
            oos.writeObject(s[i]);
            bw.newLine();
            bw.write("Name: "+s[i].name);
            bw.newLine();
            bw.write("Roll: "+s[i].roll);
            bw.newLine();
            bw.write("Name: "+s[i].oopmark);
            bw.newLine();
        }
        bw.close();
        oos.close();
    }

    void ReadStudentDetails() throws IOException,ClassNotFoundException{
        FileInputStream fis=new FileInputStream(f);
        ObjectInputStream ois=new ObjectInputStream(fis);
        for(int i=0;i<s.length;i++){
            Stud s1=(Stud)ois.readObject();
            if(s1.oopmark>80){
                System.out.println("Name: "+s1.name);
                System.out.println("Roll: "+s1.roll);
                System.out.println("Marks: "+s1.oopmark);
            }
        }
        ois.close();
    }
}

class AThread extends Thread{
    int num;
    int val;
    FileOperation FileObj;
    AThread(int n,int v){
        num=n;
        val=v;
        FileObj=new FileOperation(val);
    }
    public void run(){
        if(num==1){
            try{
                synchronized(FileObj){
                    FileObj.WriteStudentDetails();
                }
            }catch(IOException e){}
            catch(ClassNotFoundException e){}
        }
        if(num==2){
            try{
                synchronized(FileObj){
                    FileObj.ReadStudentDetails();
                }
            }catch(IOException e){}
            catch(ClassNotFoundException e){}
        }
    }
}

class OOPMarks{
    public static void main(String[] args) throws InterruptedException{
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter total number of Students: ");
        int val=sc.nextInt();
        sc.close();
        AThread t1=new AThread(1, val);
        t1.start();
        t1.join();
        AThread t2=new AThread(1, val);
        t2.start();
    }
}