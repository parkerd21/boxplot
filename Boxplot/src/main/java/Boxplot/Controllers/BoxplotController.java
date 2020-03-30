package Boxplot.Controllers;

import Boxplot.DTO.BoxplotDTO;

import Boxplot.Services.BoxplotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class BoxplotController {

    @Autowired
    private BoxplotService boxplotService;

    @GetMapping("/getBoxplot")
    public BoxplotDTO getBoxplot(@RequestParam("dataPoints")List<Double> dataPoints) {
        log.info("Endpoint called: /getBoxplot");
        boxplotService.runBoxplotService(dataPoints);
        return boxplotService.getBoxplotDTO();
    }

    @GetMapping("/getBoxplotData/{numOfDataSets}/{numOfRandDataPoints}")
    public List<BoxplotDTO> getBoxplotData(@PathVariable("numOfDataSets")int numOfDataSets, @PathVariable("numOfRandDataPoints")int numOfRandDataPoints) {
        log.info("Endpoint called: /getBoxplotData for numOfDataSets: " + numOfDataSets + " for numOfRandDataPoints: " + numOfRandDataPoints);
        return boxplotService.getListOfBoxplotDTOs(numOfDataSets, numOfRandDataPoints);
    }

    @GetMapping("/getBoxplotGraph")
    public String getBoxplotGraph(@RequestParam(value = "numOfDataSets")int numOfDataSets,
                                  @RequestParam(value = "numOfRandDataPoints")int numOfRandDataPoints,
                                  @RequestParam(value ="scale", defaultValue = "1.0") float scale) {
        log.info("Endpoint called: /getBoxplotGraph for numOfDataSets: " + numOfDataSets + " for numOfRandDataPoints: " + numOfRandDataPoints);
        return boxplotService.generateHTMLGraph(numOfDataSets, numOfRandDataPoints, scale);
    }
}
