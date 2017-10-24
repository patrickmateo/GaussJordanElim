package GaussJordanElim;
/**
 *
 * @author John Patrick Mateo
 */
import java.util.*;
import java.text.*;

public class GaussEq {

    double[][] numbers = {
        {5, 5, 2, 1},
        {2, 2, 3, 4},
        {1, 7, 4, 3}
    };
    double divisor, row, rowSwap;
    DecimalFormat sample = new DecimalFormat("0.000000");
    
    public void printNum() {

        System.out.println("Gauss Jordan Elimination Calculator (3x4)");
        System.out.println("Matrix: \n"
                + Arrays.toString(numbers[0])
                + "\n" + Arrays.toString(numbers[1])
                + "\n" + Arrays.toString(numbers[2]));
        System.out.println("\nSystems of equation : \n"
                + "(" + numbers[0][0] + ")x+(" + numbers[0][1] + ")y+(" + numbers[0][2] + ")z = " + numbers[0][3] + "\n"
                + "(" + numbers[1][0] + ")x+(" + numbers[1][1] + ")y+(" + numbers[1][2] + ")z = " + numbers[1][3] + "\n"
                + "(" + numbers[2][0] + ")x+(" + numbers[2][1] + ")y+(" + numbers[2][2] + ")z = " + numbers[2][3] + "\n");

    }

    public void computeNum() {

        divisor = numbers[0][0];
        if (divisor == 0) {
            //swap row2 to row1
            for (int z = 0; z < numbers[0].length; z++) {
                rowSwap = numbers[0][z];
                row = numbers[1][z];
                numbers[1][z] = rowSwap;
                numbers[0][z] = row;
                //System.out.println("Row 2 Swap: " + numbers[1][z]);
            }
            divisor = numbers[0][0];
            //for row1
            for (int z = 0; z < numbers[0].length; z++) {
                row = numbers[0][z] / divisor;
                numbers[0][z] = row;
                //System.out.println("Row 1: " + numbers[0][z]);
            }
        } else {
            //for row1 
            for (int z = 0; z < numbers[0].length; z++) {
                row = numbers[0][z] / divisor;
                numbers[0][z] = row;
                //System.out.println("Row 1: " + numbers[0][z]);
            }
        }

        //for row2
        divisor = numbers[1][0];
        for (int z = 0; z < numbers[0].length; z++) {
            row = (-divisor * numbers[0][z]) + numbers[1][z];
            numbers[1][z] = row;
            //System.out.println("Row 2: " + numbers[1][z]);
        }

        //for row3
        divisor = numbers[2][0];
        for (int z = 0; z < numbers[0].length; z++) {
            row = (-divisor * numbers[0][z]) + numbers[2][z];
            numbers[2][z] = row;
            //System.out.println("Row 3: " + numbers[2][z]);
        }

        divisor = numbers[1][1];
        if (divisor == 0) {
            //swap row2 to row3
            for (int z = 0; z < numbers[0].length; z++) {
                rowSwap = numbers[1][z];
                row = numbers[2][z];
                numbers[1][z] = row;
                numbers[2][z] = rowSwap;
                //System.out.println("Row 3 Swap: " + numbers[2][z]);
            }
            divisor = numbers[1][1];
            //for row2: to make the second column to 1
            for (int z = 0; z < numbers[0].length; z++) {
                row = numbers[1][z] / divisor;
                numbers[1][z] = row;
                //System.out.println("Row 2[1] = 1: " + numbers[1][z]);
            }
        } else {
            divisor = numbers[1][1];
            //for row2: to make the second column to 1
            for (int z = 0; z < numbers[0].length; z++) {
                row = (numbers[1][z] / divisor);
                numbers[1][z] = row;
                //System.out.println("Row 2[1] = 1: " + numbers[1][z]);
            }
        }

        //for row3: to make the second column to 0
        divisor = numbers[2][1];
        for (int z = 0; z < numbers[0].length; z++) {
            row = (-divisor * numbers[1][z]) + numbers[2][z];
            numbers[2][z] = row;
            //System.out.println("Row 3[1] = 0: " + numbers[2][z]);
        }

        //for row3: to make the third column to 0
        divisor = numbers[2][2];
        for (int z = 0; z < numbers[0].length; z++) {
            row = numbers[2][z] / divisor;
            numbers[2][z] = row;
            //System.out.println("Row 3[2] = 0: " + numbers[2][z]); //diagonal 1 finished!
        }

        //for row2: to make the third column to 0
        divisor = numbers[1][2];
        for (int z = 0; z < numbers[0].length; z++) {
            row = (-divisor * numbers[2][z]) + numbers[1][z];
            numbers[1][z] = row;
            //System.out.println("Row 2[2] = 0: " + numbers[1][z]);
        }

        //for row1: to make the third column to 0
        divisor = numbers[0][2];
        for (int z = 0; z < numbers[0].length; z++) {
            row = (-divisor * numbers[2][z]) + numbers[0][z];
            numbers[0][z] = row;
            //System.out.println("Row 1[2] = 0: " + numbers[0][z]);
        }

        //for row1: to make the second column to 0
        divisor = numbers[0][1];
        for (int z = 0; z < numbers[0].length; z++) {
            row = (-divisor * numbers[1][z]) + numbers[0][z];
            numbers[0][z] = row;
            //System.out.println("Row 1[1] = 0: " + numbers[0][z]);
        }
    }

    public void printAns() {
        System.out.println("Final Matrix: \n"
                + Arrays.toString(numbers[0])
                + "\n" + Arrays.toString(numbers[1])
                + "\n" + Arrays.toString(numbers[2]));

        System.out.println("\nAnswer : \n"
                + "x = (" + sample.format(numbers[0][3]) + ")"
                + "\ny = (" + sample.format(numbers[1][3]) + ")"
                + "\nz = (" + sample.format(numbers[2][3]) + ")");
    }
}
