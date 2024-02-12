import java.io.*;
import java.util.*;

class Extra{
    synchronized void extrafunc(int num,Student[] s,File f){
        if (num == 1) {
            try {
                FileOutputStream fos = new FileOutputStream("Serial");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                FileWriter fw=new FileWriter(f);
                BufferedWriter bw=new BufferedWriter(fw);
                for (int i = 0; i < s.length; i++) {
                    oos.writeObject(s[i]);
                    bw.write("Name: "+s[i].name);
                    bw.newLine();
                    bw.write("RollNumber: "+s[i].roll);
                    bw.newLine();
                    bw.write("Marks: "+s[i].mark);
                    bw.newLine();
                    bw.newLine();
                    bw.newLine();
                }
                oos.close();
                bw.close();
            } catch (Exception e) {}
        }
        if (num == 2) {
            try {
                FileInputStream fis = new FileInputStream("Serial");
                ObjectInputStream ois = new ObjectInputStream(fis);
                for (int i = 0; i < s.length; i++) {
                    Student s1 = (Student) ois.readObject();
                    if (s1.mark > 80) {
                        System.out.println();
                        System.out.println("Name: " + s1.name);
                        System.out.println("RollNo: " + s1.roll);
                        System.out.println("Marks: " + s1.mark);
                    }
                }
                ois.close();
            } catch (Exception e){}
        }
    }
}

class MyThread extends Thread {
    int num;
    Student s[];
    File f;
    Extra ext=new Extra();

    MyThread(int num, Student s[],File f) {
        this.num = num;
        this.s = s;
        this.f=f;
    }

    public void run() {
        ext.extrafunc(num,s,f);
    }
}

class Student implements Serializable {
    String name;
    int roll;
    int mark;

    Student(String name, int roll, int mark) {
        this.name = name;
        this.roll = roll;
        this.mark = mark;
    }
}

class Studentmarks {
    public static void main(String[] args) throws IOException, ClassNotFoundException,InterruptedException {
        Scanner sc = new Scanner(System.in);
        File f = new File(
                "E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//Studentmark.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        Student s[]=new Student[5];
        for(int i=0;i<5;i++){
            System.out.println("Enter details for Student"+(i+1));
            s[i]=new Student(sc.next(),sc.nextInt(),sc.nextInt());
        }
        MyThread t1=new MyThread(1, s, f); 
        MyThread t2=new MyThread(2, s, f); 
        t1.start();
        t1.join();
        t2.start();

        sc.close();
    }
}