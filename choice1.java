import java.util.Scanner;
public class choice1 {
    void choice1(String data[][],float gpa[], int index){
    Scanner as = new Scanner(System.in);   
    System.out.println(" 1. Single student details");
    System.out.println("Enter student ID no.");
    
    String id = as.next();
    try{
        while(!(id.substring(0, 3).equals("B08") && (id.length())==7)){
        System.out.println("Invalid ID, enter again..");
        id = as.next();}}catch(StringIndexOutOfBoundsException e){ System.out.println("ID length must be 7 characters.");}

    int count=0;
    for(int m =0;m<index;m++)
        if(id.equals(data[m][0])){
            count++;
            System.out.println("\nID : "+data[m][0]+"\tName : "+data[m][1]+"\t Branch : "+data[m][2]);
            System.out.println("SUBJECT\t\tGRADE");
            for(int j=3;j<11;j++){
                System.out.println(data[m][j]+"\t\t"+data[m][j+1]);
                j++;
            }
            System.out.println("GPA : "+gpa[m]+"\n");
        }
    if(count==0)
        System.out.println("ID not found..!");
    }
}
