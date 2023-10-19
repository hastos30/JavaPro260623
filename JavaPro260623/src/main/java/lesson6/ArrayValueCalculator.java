package main.java.lesson6;

public class ArrayValueCalculator {

    public int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new ArraySizeException("Размер массива должен быть 4x4.");
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }
}
