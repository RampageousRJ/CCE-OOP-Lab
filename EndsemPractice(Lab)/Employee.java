import java.io.*;

class FileEmpty extends Exception {
    String st;

    FileEmpty(String s) {
        st = s;
    }

    public String toString() {
        return st + " is Empty";
    }
}

class Empl implements Serializable{
    public String name, type, datefrom, dateto;
    int code, lbal;

    Empl(String n, int c, String t, String df, String dt) {
        lbal = 10;
        name = n;
        code = c;
        type = t;
        datefrom = df;
        dateto = dt;
    }
}

class RThread extends Thread {
    File f;
    Empl e[];
    int num;

    RThread(int n, Empl s1[], File f) {
        this.f = f;
        e = s1;
        num = n;
    }

    public void run(){
        try{
            if(num==1){
                FileOutputStream fos=new FileOutputStream(f);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                for(int i=0;i<e.length;i++){
                    oos.writeObject(e[i]);
                }
                oos.close();
            }
        }
        catch(Exception e){}
        try{
            try{
                if(num==2){
                    FileInputStream fis=new FileInputStream(f);
                    ObjectInputStream ois=new ObjectInputStream(fis);
                    for(int i=0;i<e.length;i++){
                        Empl s1=(Empl)ois.readObject();
                        if(s1.type.equalsIgnoreCase("compensatory")){
                            s1.lbal=13;
                        }
                        else if(s1.type.equalsIgnoreCase("casual")){
                            s1.lbal=12;
                        }
                        System.out.println();
                        System.out.println("Name: " + s1.name);
                        System.out.println("EmpCode: " + s1.code);
                        System.out.println("Leave Type: " + s1.type);
                        System.out.println("DateFrom: " + s1.datefrom);
                        System.out.println("DateTo: " + s1.dateto);
                        System.out.println("Leave Balance: " + s1.lbal);
                    }
                    ois.close();
                }
            }catch(Exception e){
                throw new FileEmpty(f.getName());
            }
        }catch(FileEmpty e){
            System.out.println(e);
        }    
    }
}

class Employee{
    public static void main(String[] args) throws InterruptedException{
        File f=new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//Employee.txt");
        Empl e[]=new Empl[5];
        e[0]=new Empl("Rishabh",1,"casual","21-10-2022","22-10-2022");
        e[1]=new Empl("Himanshu",1,"compensatory","21-11-2020","22-09-2021");
        e[2]=new Empl("Swapnil",1,"casual","21-10-2022","22-10-2022");
        e[3]=new Empl("Nishalya",1,"thread","21-10-2022","22-10-2022");
        e[4]=new Empl("Shaurya",1,"cas","21-1-2022","22-10-2022");
        RThread t1=new RThread(1, e, f);
        RThread t2=new RThread(2, e, f);
        t1.start();
        t1.join();
        t2.start();
    }
}