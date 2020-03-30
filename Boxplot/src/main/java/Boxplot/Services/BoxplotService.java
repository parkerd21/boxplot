package Boxplot.Services;

import Boxplot.Boxplot;
import Boxplot.DTO.BoxplotDTO;
import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

import java.util.List;

@Service
public class BoxplotService {
    private BoxplotDTO boxplotDTO;
    private Boxplot boxplot;
//
//    @Autowired
//    public BoxplotService(Boxplot boxplot, BoxplotDTO boxplotDTO) {
//        this.boxplotDTO = boxplotDTO;
//        this.boxplot = boxplot;
//    }

    public void runBoxplotService(List<Double> dataPoints) {
        setBoxplotPoints(dataPoints);
        setBoxplotDTO();
    }

    private void setBoxplotPoints(List<Double> dataPoints) {
        this.boxplot = new Boxplot();
        boxplot.setDataPoints(dataPoints);
    }

    private void setBoxplotDTO() {
        this.boxplotDTO = new BoxplotDTO();
        boxplotDTO.setMedian(boxplot.getMedian().toString());
        boxplotDTO.setFirstQuartile(boxplot.getFirstQuartile().toString());
        boxplotDTO.setThirdQuartile(boxplot.getThirdQuartile().toString());
        boxplotDTO.setMinimum(boxplot.getMinimum().toString());
        boxplotDTO.setMaximum(boxplot.getMaximum().toString());
    }

    public List<BoxplotDTO> getListOfBoxplotDTOs(int numOfDataSets, int numOfRandDataPoints) {
        List<BoxplotDTO> boxplotDTOList = new ArrayList<>();
        for(int dataSetCount = 0; dataSetCount < numOfDataSets; dataSetCount++) {
            List<Double> dataPoints = generateRandomDataPoints(numOfRandDataPoints);
            setBoxplotPoints(dataPoints);
            setBoxplotDTO();
            boxplotDTOList.add(this.boxplotDTO);
        }
        return boxplotDTOList;
    }

    // create a list of random data points
    private List<Double> generateRandomDataPoints(int numOfRandDataPoints) {
        final int MULTIPLY_BY = 10 * numOfRandDataPoints;
        List<Double> dataPoints = new ArrayList<>();
        Random rand = new Random();

        for (int counter = 0; counter < numOfRandDataPoints; counter++) {

            dataPoints.add(DoubleRounder.round(rand.nextDouble() * MULTIPLY_BY, 2));
        }
        return dataPoints;
    }

    public String generateHTMLGraph(int numOfDataSets, int numOfRandDataPoints, float scale) {
        String height = new Float(scale * 500).toString();
        String width = new Float(scale * 900).toString();

        String html =   "<html>\n" +
                        "<head>\n" +
                        "   <script> var numOfDataSets = \"" + numOfDataSets + "\"; var numOfRandDataPoints = \"" + numOfRandDataPoints + "\" </script>\n" +
                        "   <script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>" +
                        "   <script src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                        "   <script src=\"/js/boxplotConfig.js\"></script>\n" +
                        "   <script src=\"/js/boxplotGraph.js\"></script>\n" +
                        "   <script src=\"/js/singleBoxplotGraph.js\"></script>\n" +

                        "</head>\n" +
                        "<body>\n" +
                        "   <div class=\"content\">\n" +
                        "       <div id=\"chart-div\" style=\"width: " + width +  "px; height: " + height + "px;\"></div>\n" +
                        "   </div>\n" +
                        "</body>\n" +
                        "</html>";
        return html;
    }

    public BoxplotDTO getBoxplotDTO() {
        return boxplotDTO;
    }

    public Boxplot getBoxplot() {
        return boxplot;
    }


}
