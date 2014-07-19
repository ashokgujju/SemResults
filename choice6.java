import java.util.Scanner;
class choice6 {
    public void choice6(String data[][],float gpa[] ,String BSub[][], int index){
       
    Scanner as = new Scanner(System.in);
    System.out.println("6. Display all student details branch wise");
    System.out.println("Branches List : ");
        for(int i=1;i<=6;i++)
            System.out.println(i+". "+BSub[i][0]);
        System.out.println("Select Branch :");
        int opt = as.nextInt();
    try{    
        int temp=0,count=0;
        while(temp<index){
        if(data[temp][2].equals(BSub[opt][0])){
            System.out.println("\nID : "+data[temp][0]+"\tName : "+data[temp][1]+"\t Branch : "+data[temp][2]);
            System.out.println("SUBJECT\t\tGRADE");
            for(int j=3;j<11;j++){
                System.out.println(data[temp][j]+"\t\t"+data[temp][j+1]);
                j++;
            }
            System.out.println("GPA : "+gpa[temp]+"\n");
            count++;
                }
        temp++;
            }
        System.out.println("total no. of results = "+count+"\n");
        }catch(ArrayIndexOutOfBoundsException e){System.out.println("Invalid input try again later......");}
    }
}
