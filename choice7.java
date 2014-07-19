import java.util.Scanner;
public class choice7 {
    public void choice7(String[][] data, String[][] BSub, float[] gpa, int index, int number) {

        Scanner as = new Scanner(System.in);
        System.out.println("Enter Branch Name :");
        String opt = as.next();
        
        int count=0;
        int top [] = new int[number];
        float gpa2[]= new float[number];
        for(int i=0;i<number;i++){
            float max=0;
            for(int m=0;m<index;m++){

                if(data[m][2].equals(opt)){
                    if(max<gpa[m]){
                        max=gpa[m];
                        gpa[m]=0;
                        top[i]=m;
                        count++;
                    }

                }
            }
            gpa2[i]=max;
        }
        
        if(count!=0){
        
        System.out.println("Top "+number +" student(s) from "+opt);
        
        for(int m =0;m<number;m++){
            System.out.println("\nID : "+data[top[m]][0]+"\tName : "+data[top[m]][1]+"\t Branch : "+data[top[m]][2]);
            System.out.println("SUBJECT\t\tGRADE");
            for(int j=3;j<11;j++){
                System.out.println(data[top[m]][j]+"\t\t"+data[top[m]][j+1]);
                j++;
            }
                System.out.println(gpa2[m]+"\n");}
        }
        else
            System.out.println("\nInvalid branch name... try again later..\n");
    }
}
