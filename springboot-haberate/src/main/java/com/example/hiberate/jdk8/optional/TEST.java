import java.util.ArrayList;
import java.util.List;

public class TEST {
    //java.lang.OutOfMemoryError: Java heap space 堆溢出
    static class Obj{

    }
    public static void main(String[] args){
        List<Obj> list = new ArrayList<>();
        while (true){
            list.add(new Obj());
        }
    }
}
