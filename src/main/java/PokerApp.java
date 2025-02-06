import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PokerApp {

    public static void main(String[] args) {
        try {
            List<ExcelReader.PokerData> data = ExcelReader.readExcelFile("C:/Mis cosas/gestionPokerStars.xlsx");

            double totalIn = PokerDataProcessor.getTotalIn(data);
            double totalOut = PokerDataProcessor.getTotalOut(data);
            List<Double> inOverTime = PokerDataProcessor.getInOverTime(data);
            List<Double> outOverTime = PokerDataProcessor.getOutOverTime(data);

            JFrame frame = new JFrame("Poker Tracker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new GridLayout(2, 1));

            JPanel totalGraphPanel = PokerGraph.createTotalGraph(totalIn, totalOut);
            frame.add(totalGraphPanel);

            JPanel timeGraphPanel = PokerGraph.createAccumulatedGraph(data);
            frame.add(timeGraphPanel);

            frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
