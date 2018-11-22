
public class TEST2 {
    //虚拟机栈溢出 java.lang.StackOverflowError
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args){
        TEST2 test2=new TEST2();
        try {
            test2.stackLeak();
        }catch (Exception e){
            System.out.println("stack length:"+test2.stackLength);
        }
    }
}
