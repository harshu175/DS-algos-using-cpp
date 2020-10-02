import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> value=new Stack<>();
    Stack<String> infix=new Stack<>();
    Stack<String> pre=new Stack<>();
    
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            int val2=value.pop();
            int val1=value.pop();
            int val=operation(val1,val2,ch);
            value.push(val);
            
            String inval2=infix.pop();
            String inval1=infix.pop();
            String inval="("+inval1+ch+inval2+")";
            infix.push(inval);
            
            String preval2=pre.pop();
            String preval1=pre.pop();
            String preval=ch+preval1+preval2;
            pre.push(preval);
            
        }else if((ch>='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
            value.push(ch-'0');
            infix.push(ch+"");
            pre.push(ch+"");
        }
    }
    System.out.println(value.peek());
    System.out.println(infix.peek());
    System.out.println(pre.peek());
    
 }
 public static int operation(int val1,int val2,char ch){
     if(ch=='+'){
         return val1+val2;
     }else if(ch=='-'){
         return val1-val2;
     }else if(ch=='*'){
         return val1*val2;
     }else{
         return val1/val2;
     }
 }
 
}
