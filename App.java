public class App {

    public static void printArray(int[] array){
        for (int a : array){
            System.out.print(a + " ");

        }
        System.out.println();
    }

    public static int[] createRandomArray(int arrayLength){
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i ++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static boolean isSorted(int[] array){
        for (int i = 0; i < array.length - 1; i ++){
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        long startTime;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What is the length of the random integer array? Please enter an integer.");
        int arrayLength = scanner.nextInt();
        startTime = System.currentTimeMillis();
        int[] array = createRandomArray(arrayLength);
        System.out.printf("\n" + "Time to create an integer array of length %d is %.2f s", arrayLength, (System.currentTimeMillis() - startTime) / 1000.00);
        
        startTime = System.currentTimeMillis();
        int[] sortedArray = Sort.mergeSort(array);
        System.out.printf("\n" + "Time to merge sort integer array of length %d is %.2f s", arrayLength, (System.currentTimeMillis() - startTime) / 1000.00);
        System.out.println("The sorted array in the correct order: " + isSorted(sortedArray));
        
        startTime = System.currentTimeMillis();
        Sort.bubbleSort(array);
        System.out.printf("\n" + "Time to bubble sort integer array of length %d is %.2f s", arrayLength, (System.currentTimeMillis() - startTime) / 1000.00);

        System.out.println("\n" + "Merge Sort and Bubble Sort generate the same result: " + Array.equals(sortedArray, array));

        System.out.println("\n" + "Continue? Please enter yes or no:");
        String yesNo = scanner.next();
        if (yesNo.equals("no")){
            break;
        }
    }
    scanner.close();
    System.out.println("Goodbye.");
}
}