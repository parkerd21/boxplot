package Boxplot.DTO;

import org.springframework.stereotype.Component;

@Component
public class BoxplotDTO {
    private String minimum;
    private String firstQuartile;
    private String median;
    private String thirdQuartile;
    private String maximum;

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getFirstQuartile() {
        return firstQuartile;
    }

    public void setFirstQuartile(String firstQuartile) {
        this.firstQuartile = firstQuartile;
    }

    public String getMedian() {
        return median;
    }

    public void setMedian(String median) {
        this.median = median;
    }

    public String getThirdQuartile() {
        return thirdQuartile;
    }

    public void setThirdQuartile(String thirdQuartile) {
        this.thirdQuartile = thirdQuartile;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }
}
