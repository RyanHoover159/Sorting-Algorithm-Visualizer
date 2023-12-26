import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Visualizer extends JFrame 
{
    private int[] array;

    public Visualizer(int[] array) 
    {
        this.array = Arrays.copyOf(array, array.length);
        initialize();
    }

    private void initialize() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Algorithm Visualizer");
        setLayout(new BorderLayout());

        JPanel graphPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                drawGraph(g);
            }
        };

        add(graphPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void drawGraph(Graphics g) 
    {
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int barWidth = panelWidth / array.length;

        for (int i = 0; i < array.length; i++) 
        {
            int barHeight = array[i] * panelHeight / Arrays.stream(array).max().orElse(1);
            g.fillRect(i * barWidth, panelHeight - barHeight, barWidth - 1, barHeight);
        }
    }

    public void updateArray(int[] newArray) 
    {
        array = Arrays.copyOf(newArray, newArray.length);
        repaint();
        try 
        {
            Thread.sleep(10); // Adjust the sleep duration as needed
        } 
        
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}
