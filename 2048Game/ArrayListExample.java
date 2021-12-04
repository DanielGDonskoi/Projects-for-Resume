import java.util.ArrayList;
public class ArrayListExample
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);


        //Replace C with C_NEW


        //1 - In multiple steps

        int index = list.indexOf("C");

        list.set(index, "C_NEW");

        System.out.println(list);


        //2 - In single step replace D with D_NEW

        list.set( list.indexOf("D") , "D_NEW");

        System.out.println(list);
    }
}