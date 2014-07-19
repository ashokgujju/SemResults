import java.io.*;
import java.util.Scanner;
import java.lang.String;

class choice5 extends SER{
    public void choice5(String BSub[][], String data[][],int index) throws IOException{
    System.out.println("5. Add new student details");
        
        Scanner as = new Scanner(System.in);
        
        BufferedWriter ref = new BufferedWriter(new FileWriter("data.txt",true));
        
        System.out.println("Enter Student ID :");
         String id = as.next();
        try{while(!(id.substring(0, 3).equals("B08") && (id.length())==7)){
            System.out.println("Invalid ID, enter again..");
            id = as.next();}}catch(StringIndexOutOfBoundsException e){ System.out.println("ID length must be 7 characters.");}
         boolean ispresent=false;
        for(int x=0;x<index;x++)
            if(id.equals(data[x][0]))
                ispresent = true;
        
        if(ispresent)
            System.out.println("\nId already present in the file......\n");
        else{
            ref.write(id+"$");                   
            System.out.println("Enter Student Name :");
            ref.write(as.next()+" "+as.nextLine());
            System.out.println("Branches List : ");
            for(int i=1;i<=6;i++)
                System.out.println(i+". "+BSub[i][0]);
            System.out.println("Select Student Branch :");
            int opt = as.nextInt();
            ref.write("$"+BSub[opt][0]);
            for(int j=1;j<5;j++){
                System.out.println("Enter Grade point os "+BSub[opt][j]);
                ref.write("$"+BSub[opt][j]+":"+as.next());
            }
            ref.newLine();
                System.out.println("Student details added successfully...!");
        }
        ref.close();  
        
    }
}
