import java.io.*;
import java.util.*;
class FileHandle{
    public static void main(String[] args) throws IOException{
        // Code to create a new file 
        File myFile=new File("E://Study//OneDrive - Manipal Academy of Higher Education//Second Year//Third Semester//OOP//EndsemPractice(Lab)//File Handling//myFile.txt");
        myFile.createNewFile();

        // Code to write to a file
        FileWriter fileWriter=new FileWriter(myFile);
        fileWriter.write("This is our first file from this java course...//ngoodnight");
        fileWriter.close();

        //Reading a file
        Scanner sc=new Scanner(myFile);
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
        sc.close();
        /*
        //Deleting a file
        if(myFile.delete()){
            System.out.println("Deleted "+myFile.getName());
        }
         */
    }
}