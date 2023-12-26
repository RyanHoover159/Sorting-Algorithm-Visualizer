import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main 
{
    static int[] arr;

    public static void main(String[] args) 
    {

        //Create the frame and buttons
        JFrame frame = new JFrame("Algorithm Visualizer");
        JButton linear = new JButton("Linear Sort");
        JButton insert = new JButton("Insertion Sort");
        JButton merge = new JButton("Merge Sort");
        JButton quick = new JButton("Quick Sort");
        JButton exit = new JButton("Close");
        JButton reset = new JButton("Reset Array");


        //Create the panel and add the buttons
        JPanel topPanel = new JPanel(new GridLayout(3, 2));
        topPanel.add(linear);
        topPanel.add(insert);
        topPanel.add(quick);
        topPanel.add(merge);
        topPanel.add(reset);
        topPanel.add(exit);


        //Add the panel to the frame and set the layout
        frame.add(topPanel);
        frame.setLayout(new GridLayout(1, 1));
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        //Create the array and fill it with random numbers
        arr = new int[100];
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i] = (int) (Math.random() * 100);
        }


        //Create the visualizer
        Visualizer visualizer = new Visualizer(arr);


        //Add action listeners to the buttons
        reset.addActionListener(e -> 
        {
            arr = new int[100];
            for (int i = 0; i < arr.length; i++) 
            {
                arr[i] = (int) (Math.random() * 100);
            }

            visualizer.updateArray(arr);
        });

        exit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });

        linear.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                LinearSort(visualizer);
            }
        });

        insert.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                insertionSort(visualizer);
            }
        });

        merge.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mergeSort(visualizer);
            }
        });

        quick.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                quickSort(visualizer);
            }
        });


        //Display the array
        System.out.print("Initial Array: ");
        displayArray(arr);
    }


    //Helper method to display the array
    public static void displayArray(int[] arr) 
    {
        for (int i : arr) 
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    //Helper methods to sort the array
    private static void LinearSort(Visualizer visualizer) 
    {
        new Thread(() -> new LinearSort().sort(arr, visualizer)).start();
    }

    private static void insertionSort(Visualizer visualizer) 
    {
        new Thread(() -> new InsertionSort().sort(arr, visualizer)).start();
    }

    private static void mergeSort(Visualizer visualizer) 
    {
        new Thread(() -> new MergeSort().sort(arr, visualizer)).start();
    }

    private static void quickSort(Visualizer visualizer) 
    {
        new Thread(() -> new QuickSort().sort(arr, visualizer)).start();
    }
}
