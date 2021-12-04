import java.util.ArrayList;

public class View {

    public View(Model inherited){
        ArrayList<ArrayList<Integer>> board = inherited.currentmatrix;
        for (ArrayList<Integer> row : board){
            for (int i = 0; i < 3; i++){
                System.out.print(" " + row.get(i) + " ");

            }
            System.out.println(" " + row.get(3) + " ");
        }
    }

}
