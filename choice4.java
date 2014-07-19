import java.util.Scanner;
public class choice4{
    public void choice4(String data[][], int index) throws ArrayIndexOutOfBoundsException{
        
        Scanner as = new Scanner(System.in);
        
        System.out.println("4. Display subject grade points");
        System.out.println("Enter student ID no.");
        String id = as.next();

    try{ 
        while(!(id.substring(0, 3).equals("B08") && (id.length())==7)){
        System.out.println("Invalid ID, enter again..");
        id = as.next();}}catch(StringIndexOutOfBoundsException e){ System.out.println("ID length must be 7 characters.");}
    try{    
        int count=0;
        for(int m=0;m<index;m++)
        if(id.equals(data[m][0])){
            count++;
            System.out.println("\nStudent ID "+id+""+"\tName : "+data[m][1]+"\tBranch : "+data[m][2]);

            System.out.println("Subjects:\n");

            int sub_choice=0;
            for(int a=3, b=1;a<=9;a++,b++){
                System.out.println(b+". "+data[m][a]);
                a++;}

            System.out.println("\nSelect One Subject:");
            sub_choice=as.nextInt();
            int t=sub_choice*2+1;
            System.out.println("Selected subject ( "+data[m][t]+" ) Grade Points "+data[m][t+1]);

        }
        if(count==0)
            System.out.println("ID not found..!");
        }catch(ArrayIndexOutOfBoundsException e){System.out.println("Invalid choice. try again later...");}
    }
}
