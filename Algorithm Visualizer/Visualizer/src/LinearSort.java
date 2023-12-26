import java.util.Arrays;

public class LinearSort implements SortAlgorithm 
{

    @Override
    public void sort(int[] arr, Visualizer visualizer) 
    {
        int max = Arrays.stream(arr).max().orElse(0) + 1;
        int[] count = new int[max];

        // Count occurrences of each element
        for (int num : arr) 
        {
            count[num]++;
        }

        // Reconstruct the sorted array
        int index = 0;
        for (int i = 0; i < max; i++) 
        {
            while (count[i] > 0) 
            {
                arr[index++] = i;
                count[i]--;
                
                // Notify the visualizer
                visualizer.updateArray(arr);
            }
        }
    }
}
