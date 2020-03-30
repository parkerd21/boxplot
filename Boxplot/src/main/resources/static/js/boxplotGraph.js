function renderBoxplotGraph(numOfDataSets, numOfRandDataPoints, elementID) {
    console.log('Rendering graph for ' + numOfDataSets + ' data sets that contain ' + numOfRandDataPoints + ' random numbers in element ' + elementID);
    $.ajax({
        type: 'GET',
        url: host + "/getBoxplotData/" + numOfDataSets + "/" + numOfRandDataPoints,
        dataType: "json"
    }).success(function(boxplotDTOList) {
        console.log(boxplotDTOList);
        drawBoxplotGraph(elementID, boxplotDTOList);
    });
}

function drawBoxplotGraph(elementID, boxplotDTOList) {
    var chartData = [];
    var counter = 1;
    boxplotDTOList.map(function (dataNode) {
        var dataArray = [];
        dataArray.push("Boxplot " + counter)
        dataArray.push(dataNode['minimum']);
        dataArray.push(dataNode['firstQuartile']);
        dataArray.push(dataNode['thirdQuartile']);
        dataArray.push(dataNode['maximum']);
        chartData.push(dataArray);
        counter += 1;
    });

    var data = google.visualization.arrayToDataTable(chartData);
    var options = {
        legend: 'none'
    };

    var chart = new google.visualization.CandlestickChart(document.getElementById(elementID));
    chart.draw(data, options);
}