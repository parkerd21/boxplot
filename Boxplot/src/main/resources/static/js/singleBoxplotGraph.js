$(function() {

    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(function() {renderBoxplotGraph(numOfDataSets, numOfRandDataPoints, 'chart-div'); });
    setInterval(function() {renderBoxplotGraph(numOfDataSets, numOfRandDataPoints, 'chart-div'); }, 60000);
});
