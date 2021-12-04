
public class TestAssignment {
    public static void main(String [] args){
        Model testmodel = new Model();
        testmodel.insert2();
        testmodel.insert2();
        System.out.println(testmodel.currentmatrix);
        //System.out.println(testmodel.currentmatrix);
        //testmodel.resetboard();
        //System.out.println(testmodel.currentmatrix);
        //testmodel.insert2();
        //testmodel.insert2();
        //testmodel.insert2();
        //testmodel.insert2();
        //System.out.println(testmodel.currentmatrix);
        //testmodel.moveleft();
        //System.out.println(testmodel.currentmatrix);
        //testmodel.moveright(testmodel.currentmatrix);
        //System.out.println(testmodel.currentmatrix);
        testmodel.moveup(testmodel.currentmatrix);
        System.out.println(testmodel.currentmatrix);
        View testview = new View(testmodel);

    }
}
