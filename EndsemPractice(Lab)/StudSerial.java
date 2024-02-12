import java.util.*;
import java.io.*;

class Student implements Serializable{
    String name;
    int rollno;
    int oopmarks;
    int mathmarks;
    Student(String n, int r, int oop, int math){
        name = n;
        rollno = r;
        oopmarks = oop;
        mathmarks = math;
    }
    
    void display(){
        System.out.println(name+" "+rollno+" "+oopmarks+" "+mathmarks);
    }
}

class MyException extends Exception{
    
    public String toString(){
        return "Invalid Marks";
    }
}

class FileOperation implements Serializable{
    
    int n;
    FileOperation(){
        
    }
    
    
    FileOperation(int num){
        n = num;
    }
    
    Scanner in = new Scanner(System.in);
    File f1 = new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//insect.txt");
    
    synchronized void WriteDetails() throws IOException, MyException,ClassNotFoundException{
        FileOutputStream fout = new FileOutputStream(f1);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        Student s[] = new Student[n];
        for(int i=0; i<n; i++){
            // try{
            // System.out.println("Enter the name: ");
            // String name = in.next();
            // System.out.println("Enter the rollno: ");
            // int rollno = in.nextInt();
            // System.out.println("Enter the OOP marks: ");
            // int oopmarks = in.nextInt();
            // if(oopmarks>150){
            //     i--;
            //     throw new MyException();
            // }
            // System.out.println("Enter the Math marks: ");
            // int mathmarks = in.nextInt();
            // if(mathmarks>150){
            //     i--;
            //     throw new MyException();
            // }
            s[i] = new Student(in.next(), in.nextInt(), in.nextInt(), in.nextInt());
            oos.writeObject(s[i]);   
            // }
            // catch(MyException e){
            //     System.out.println(e+ "Exception Caught in fileoperation");
            // }
        }
        oos.close();
        fout.close();
    }
    
    synchronized void ReadDetails() throws IOException,ClassNotFoundException{
        FileInputStream fin = new FileInputStream(f1);
        ObjectInputStream iis = new ObjectInputStream(fin);
        try{
        for(int i=0;i<n;i++){
            Student s1 = (Student)iis.readObject();
            s1.display();
        }
        }
        catch(Exception e){
            System.out.println("Caught reading");
        }
        iis.close();
        fin.close();
    }  
}

class t1 extends Thread{
    int n;
    t1(int num){
        n = num;
    }
    public void run(){
    FileOperation fileObj = new FileOperation(n);
    synchronized(fileObj){
        try{
            fileObj.WriteDetails();
        }
        catch(Exception e){
            System.out.println("Exception Caught in thread1");
        }
    }
    }
}

class t2 extends Thread{
    int n;
    t2(int num){
        n = num;
    }
    public void run(){
        FileOperation fileObj = new FileOperation(n);
        synchronized(fileObj){
            try{
                fileObj.ReadDetails();
            }
            catch(Exception e){
                System.out.println("Exception caught in t2");
            }
        }
    }
}

public class StudSerial{
    public static void main(String[] args) throws IOException,InterruptedException{
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Enter number of Students: ");
        n = in.nextInt();
        in.close();
        
        t1 Thr1 = new t1(n);
        Thr1.start();
        Thr1.join();
        t2 Thr2 = new t2(n);
        Thr2.start();
    }
    
}