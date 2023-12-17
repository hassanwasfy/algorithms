public class SortManager {

    /**
     * @param isAscending Boolean indicates the arrangement of the elements low to high or reverse.
     * @param array Target elements to be sorted
     * @implNote Use when you have low memory and continues flow of numbers. Time: O(n^2)
     * @implSpec Do not use with low time.
     * */
    public void sort_Insertion(int[] array, boolean isAscending){
        for (int i = 1; i < array.length ; i++){
            int key = array[i];
            int backward = i - 1;
            if (isAscending){
                while (backward >= 0 && array[backward] > key){
                    array[backward+1] = array[backward];
                    backward--;
                }
            }else {
                while (backward >= 0 && array[backward] < key){
                    array[backward+1] = array[backward];
                    backward--;
                }
            }
            array[backward+1] = key;
        }
    }

    /**
     * @param array Target elements to be sorted
     * @implNote Use when you have low time and continues flow of numbers. Time: O(nlogn)
     * @implSpec Do not use with low space.
     * */
    public void sort_Merge(int[] array){
       if(array.length <= 1) return;
       int middle = array.length / 2;
       int[] left = new int[middle];
       int[] right = new int[array.length - middle];
       for (int i = 0 ; i < array.length ; i++){
           if (i < middle){
               left[i] = array[i];
           }
           if (i+middle < array.length){
               right[i] = array[i + middle];
           }
       }
       sort_Merge(left);
       sort_Merge(right);
       merge_Partition(array,left,right);
    }

    /**
     * @param array The array that need to be sorted.
     * @param left The left side of the array copied with the recursive calls.
     * @param right The right side of the array was created as just as the left part.
     * @implSpec Be careful with the base case, double check that it's valid and working.
     * @implNote For sure this function were called after verifying that the base case wasn't reached yet.
     * */
    private void merge_Partition(int[] array,int[] left,int[] right){

        int left_indicator = 0;
        int right_indicator = 0;
        int result_indicator = 0;

        while (left_indicator < left.length && right_indicator < right.length) {
            if (left[left_indicator] < right[right_indicator]) {
                array[result_indicator++] = left[left_indicator++];
            } else {
                array[result_indicator++] = right[right_indicator++];
            }
        }
        while (left_indicator<left.length){
            array[result_indicator++] = left[left_indicator++];
        }
        while (right_indicator < right.length){
            array[result_indicator++] = right[right_indicator++];
        }
    }

}
