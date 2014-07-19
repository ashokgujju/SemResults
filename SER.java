import java.io.*;
import java.io.IOException;
import java.util.*;
import java.lang.String;
public class SER{
    public static void main(String [] args) throws IOException{

        Scanner as = new Scanner(System.in);
        String [][] data = new String[200][11];
        float  [] gpa = new float [200];
        
        String BSub[][]={{},{"CSE", "PSP","ISE","SCLD","FLAT"},
                            {"ECE", "MAGB","IE","NT","SCD"},
                            {"ME","PSP","ISE","SCLD","FLAT"},
                            {"CE","PSP","ISE","SCLD","FLAT"},
                            {"CHEM","FM","CPC","NSO","DOA"},
                            {"MME","DOA","FA","TD","PM"}};
        
        loadArray(data,gpa);
      
        int choice=0;
        do{
              
        System.out.println("Menu :");
        System.out.println(" 1. Single student details "
                +"\n 2. Display all students details "
                +"\n 3. Display average of grade points of student"
                +"\n 4. Display subject grade points"
                +"\n 5. Add new student details"
                +"\n 6. Display all student details branch wise"
                +"\n 7. Display Top-3 student details branch wise"
                +"\n 8. Display Topper student details branch wise"
                +"\n 9. Exit");
        
        
      
            System.out.println("\nEnter your choice :");

            try{
            choice = as.nextInt();}catch(InputMismatchException e){System.out.println("Invalid choice"); choice =9;}
            
            switch(choice){
                case 1:
                    {   choice1 obj1 = new choice1();
                        obj1.choice1(data,gpa,index1());
                        break;}
                case 2:
                    {   System.out.println("2. Display all students details");
                        for(int m =0;m<index1();m++){
                                System.out.println("\nID : "+data[m][0]+"\tName : "+data[m][1]+"\t Branch : "+data[m][2]);
                                System.out.println("SUBJECT\t\tGRADE");
                                for(int j=3;j<11;j++){
                                    System.out.println(data[m][j]+"\t\t"+data[m][j+1]);
                                    j++;
                                }
                                System.out.println("GPA : "+gpa[m]+"\n");
                            }
                            System.out.println("total no. of results  = "+index1()+"\n");
                            break;}
                case 3:
                    {   System.out.println("3. Display average of grade points of student");
                        System.out.println("Enter student ID no.");
                        String id = as.next();
                        
                        try{while(!(id.substring(0, 3).equals("B08") && (id.length())==7)){
                            System.out.println("Invalid ID, enter again..");
                            id = as.next();}}catch(StringIndexOutOfBoundsException e){ System.out.println("ID length must be 7 characters.");}
                        int count =0;
                        for(int m=0;m<index1();m++)
                            if(id.equals(data[m][0])){
                                count++;
                                System.out.println("\nGPA of "+id+"\tis "+gpa[m]+"\n");}
                        if(count==0)
                            System.out.println("ID not found..!");
                            break;
                        }
                case 4:
                    {   choice4 obj4 = new choice4();
                        obj4.choice4(data, index1());
                        break;}
                case 5:
                    {   choice5 obj5 = new choice5();
                        obj5.choice5(BSub,data,index1());
                        loadArray(data,gpa);
                        break;}
                case 6:
                    {
                        choice6 obj6 = new choice6();
                        obj6.choice6(data,gpa, BSub,index1());
                        break;
                    }
                case 7:
                    {
                        System.out.println("7. Display Top-3 student details branch wise");
                        choice7 obj7 = new choice7();
                        obj7.choice7(data, BSub, gpa,index1(),3);
                        loadArray(data,gpa);
                        break;
                    }
                case 8:
                    {
                        System.out.println("8. Display Topper student details branch wise");
                        choice7 obj7 = new choice7();
                        obj7.choice7(data, BSub, gpa,index1(),1);
                        loadArray(data,gpa);
                        break;
                    }
                case 9:
                        System.out.println("thanks for using this program.....");
                        break;
                default :
                        System.out.println("\nPlease enter valid choice.....\n");
                }
        }while(choice!=9);
    }
    
    static int index1() throws IOException{
    
        BufferedReader obj0 = new BufferedReader(new FileReader("data.txt"));
                String line = null;
                int index =0;
                while((line = obj0.readLine())!=null){
                        index++;}
                return index;
    }

    public static void loadArray(String data[][], float gpa[]) throws FileNotFoundException, IOException {
        
        BufferedReader obj1 = new BufferedReader(new FileReader("data.txt"));
                int i =0;
                String line2=null;
                while((line2=obj1.readLine())!=null){
                    StringTokenizer st = new StringTokenizer(line2, "$");
                        int j=0;                
                        float sum=0;

                        while(st.hasMoreTokens()) {
                            String temp= st.nextToken();
                            if(j<=2)
                                data[i][j]=temp;
                            else
                                {   StringTokenizer st2 = new StringTokenizer(temp);
                                    data[i][j]=st2.nextToken(":");
                                    j++;
                                    data[i][j]=st2.nextToken();
                                    sum +=Integer.parseInt(data[i][j]);}
                            j++;}
                    gpa[i]=sum/4;
                    i++;
                }
                obj1.close(); 
    }
}
