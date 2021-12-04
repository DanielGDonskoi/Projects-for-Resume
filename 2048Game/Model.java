import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//@brief Initialises a class to represent a 4 by 4 2048 gameboard
public class Model {
    ArrayList<ArrayList<Integer>> currentmatrix;
    Integer score = 0;
    Boolean gamewon = false;
    Boolean gamelost = false;
    ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(0,0,0,0));
    ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(0,0,0,0));
    ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(0,0,0,0));
    ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(0,0,0,0));
    ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<>(Arrays.asList(row1,row2,row3,row4));

    public ArrayList<ArrayList<Integer>> getmatrix(){
        return this.currentmatrix;
    }

    public Boolean gamestatus(){
        if (gamewon || gamelost ){
            return false;
        }
        else{
            return true;
        }
    }

    //@brief Sets the starting board, and sets up the rows
    public Model(){


        //int x1 = randomindex(3,0);
        //int y1 = randomindex(3,0);
        //int x2 = randomindex(3,0);
        //int y2 = randomindex(3,0);
        //while ((x1 == x2) & (y1 == y2)){
             //x1 = randomindex(3,0);
             //y1 = randomindex(3,0);
             //x2 = randomindex(3,0);
             //y2 = randomindex(3,0);

        //}
        //matrix2.get(x1).set(y1, 2);
        //matrix2.get(x2).set(y2, 2);
        this.currentmatrix = matrix2;
        insert2();
        insert2();

    }
    public static int randomindex(int max,int min){


        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void insert2() {
        ArrayList<ArrayList<Integer>> initial = this.currentmatrix;
        int x1 = randomindex(3,0);
        int y1 = randomindex(3,0);
        while (initial.get(x1).get(y1) != 0){
            x1 = randomindex(3,0);
            y1 = randomindex(3,0);
        }
        initial.get(x1).set(y1,2);
        this.currentmatrix = initial;
    }
    public void resetboard() {
        ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<ArrayList<Integer>> starting = new ArrayList<>(Arrays.asList(row1,row2,row3,row4));
        insert2();
        insert2();
        this.currentmatrix = starting;
    }
    public void moveleft(ArrayList<ArrayList<Integer>> initial) {
        //ArrayList<ArrayList<Integer>> initial = this.currentmatrix;
        for (ArrayList<Integer> row : initial){
            for (int i = 3; i >= 1; i--) {
                while (row.get(i-1) == 0 & row.get(i) != 0){

                    row.set(i-1,(row.get(i)));
                    row.set(i,0);

                }
                if (row.get(i - 1).equals(row.get(i))){
                    row.set(i-1,row.get(i)*2);
                    row.set(i,0);
                }
            }

        }
        this.currentmatrix = initial;
        insert2();
    }
    public void moveright(ArrayList<ArrayList<Integer>> initial){
        //ArrayList<ArrayList<Integer>> initial = this.currentmatrix;

        for (ArrayList<Integer> row : initial){
            for (int i = 0; i < 3; i++){
                while (row.get(i+1) == 0 & row.get(i) != 0){

                    row.set(i+1,row.get(i));
                    row.set(i,0);
                }
                if (row.get(i+1).equals(row.get(i))){
                    row.set(i+1,row.get(i)*2);
                    row.set(i,0);
                }
            }
        }
    }
    public void movedown(ArrayList<ArrayList<Integer>> initial){
        ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row5 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row6 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row7 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row8 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>(Arrays.asList(row1,row2,row3,row4));
        ArrayList<ArrayList<Integer>> temp2 = new ArrayList<>(Arrays.asList(row5,row6,row7,row8));
        for (int i = 0; i <= 3; i++){
            ArrayList<Integer> current = temp.get(i);
            int counter = 0;
            for (ArrayList<Integer> rows : initial){
                int b = rows.get(i);
                current.set(counter,b);
                counter += 1;
            }
            counter = 0;
        }
        moveright(temp);
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j <= 3; j++){
                int current = temp.get(i).get(j);
                temp2.get(j).set(i,current);

            }
        }
        this.currentmatrix = temp2;

    }
    public void moveup(ArrayList<ArrayList<Integer>> initial){
        ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row5 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row6 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row7 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<Integer> row8 = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>(Arrays.asList(row1,row2,row3,row4));
        ArrayList<ArrayList<Integer>> temp2 = new ArrayList<>(Arrays.asList(row5,row6,row7,row8));
        for (int i = 0; i <= 3; i++){
            ArrayList<Integer> current = temp.get(i);
            int counter = 0;
            for (ArrayList<Integer> rows : initial){
                int b = rows.get(i);
                current.set(counter,b);
                counter += 1;
            }
            counter = 0;
        }
        moveleft(temp);
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j <= 3; j++){
                int current = temp.get(i).get(j);
                temp2.get(j).set(i,current);

            }
        }
        this.currentmatrix = temp2;

    }
    public void victory(ArrayList<ArrayList<Integer>> initial){
        for (ArrayList<Integer> row : initial){
            for (Integer val : row){
                if (val.equals(2048)){
                    this.gamewon = true;
                    System.out.println("Congratulations! You won!");
                }
            }
        }
    }
    public void defeat(ArrayList<ArrayList<Integer>> initial){
        boolean emptyspaces = false;
        for (ArrayList<Integer> row : initial){
            for (Integer val : row){
                if (val.equals(0)){
                    emptyspaces = true;
                }
            }
        }
        for (int j = 0; j <= 3; j++){
            int k;
        }
    }



}

