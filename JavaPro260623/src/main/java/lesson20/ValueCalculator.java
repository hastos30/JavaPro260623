package main.java.lesson20;

public class ValueCalculator {
    private float[] array;
    private int size;
    private int halfSize;

    public ValueCalculator(int size) {
        if (size < 1000000) {
            size = 1000000;
        }
        this.size = size;
        this.halfSize = size / 2;
        this.array = new float[size];
    }

    public void calculateValues() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = 1.0f;
        }

        float[] array1 = new float[halfSize];
        float[] array2 = new float[halfSize];

        System.arraycopy(array, 0, array1, 0, halfSize);
        System.arraycopy(array, halfSize, array2, 0, halfSize);

        Thread thread1 = new Thread(() -> processArray(array1));
        Thread thread2 = new Thread(() -> processArray(array2));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(array1, 0, array, 0, halfSize);
        System.arraycopy(array2, 0, array, halfSize, halfSize);

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;

        System.out.println("Час виконання: " + elapsedTime + " мс");
    }

    private void processArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
