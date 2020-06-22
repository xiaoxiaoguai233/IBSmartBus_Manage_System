
/*
 Template Name: Annex - Bootstrap 4 Admin Dashboard
 Author: Mannatthemes
 Website: www.Mannatthemes. 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>com
 File: Crypto Dashboard init js
 */

!function($) {
    "use strict";

    $("#sparkline0").sparkline([1,4,8,4,6,8,5,7,2,7,4,1 ], {
        type: 'line',
        width: '100%',
        height: '80',
        lineColor: '#f79304',
        fillColor: '#f7931a73',
        minSpotColor:'#f79304',
        maxSpotColor: '#f79304',
        highlightLineColor: 'rgba(0, 0, 0, 0.2)',
        highlightSpotColor: '#4f4f4f'
    });

    $("#sparkline1").sparkline([1,2,3,4,3,6,3,5,3,8,4,2 ], {
        type: 'line',
        width: '100%',
        height: '80',
        lineColor: '#627eea',
        fillColor: '#627eea7d',
        minSpotColor:'#627eea',
        maxSpotColor: '#627eea',
        highlightLineColor: 'rgba(0, 0, 0, 0.2)',
        highlightSpotColor: '#627eea'
    });
    $("#sparkline2").sparkline([0,3,6,3,4,2,6,1,8,4,4,2 ], {
        type: 'line',
        width: '100%',
        height: '80',
        lineColor: '#1c75bc',
        fillColor: '#5597cd94',
        minSpotColor:'#1c75bc',
        maxSpotColor: '#1c75bc',
        highlightLineColor: 'rgba(0, 0, 0, 0.2)',
        highlightSpotColor: '#1c75bc'
    });
    $("#sparkline3").sparkline([2,4,7,3,5,3,6,3,4,3,2,1,2 ], {
        type: 'line',
        width: '100%',
        height: '80',
        lineColor: '#c0c0c0',
        fillColor: '#c0c0c05c',
        minSpotColor:'#c0c0c0',
        maxSpotColor: '#c0c0c0',
        highlightLineColor: 'rgba(0, 0, 0, 0.2)',
        highlightSpotColor: '#c0c0c0'
    });

    //map

    $('#world-map-markers').vectorMap({
        map : 'world_mill_en',
        scaleColors : ['#03a9f4', '#03a9f4'],
        normalizeFunction : 'polynomial',
        hoverOpacity : 0.7,
        hoverColor : false,
        regionStyle : {
            initial : {
                fill : '#67a8e4'
            }
        },
         markerStyle: {
            initial: {
                r: 9,
                'fill': '#03a9f4',
                'fill-opacity': 0.9,
                'stroke': '#fff',
                'stroke-width' : 7,
                'stroke-opacity': 0.4
            },
    
            hover: {
                'stroke': '#fff',
                'fill-opacity': 1,
                'stroke-width': 1.5
            }
        },
        backgroundColor : 'transparent',
        markers : [{
            latLng : [41.90, 12.45],
            name : 'Vatican City'
        }, {
            latLng : [43.73, 7.41],
            name : 'Monaco'
        }, {
            latLng : [-0.52, 166.93],
            name : 'Nauru'
        }, {
            latLng : [-8.51, 179.21],
            name : 'Tuvalu'
        }, {
            latLng : [43.93, 12.46],
            name : 'San Marino'
        }, {
            latLng : [47.14, 9.52],
            name : 'Liechtenstein'
        }, {
            latLng : [7.11, 171.06],
            name : 'Marshall Islands'
        }, {
            latLng : [17.3, -62.73],
            name : 'Saint Kitts and Nevis'
        }, {
            latLng : [3.2, 73.22],
            name : 'Maldives'
        }, {
            latLng : [35.88, 14.5],
            name : 'Malta'
        }, {
            latLng : [12.05, -61.75],
            name : 'Grenada'
        }, {
            latLng : [13.16, -61.23],
            name : 'Saint Vincent and the Grenadines'
        }, {
            latLng : [13.16, -59.55],
            name : 'Barbados'
        }, {
            latLng : [17.11, -61.85],
            name : 'Antigua and Barbuda'
        }, {
            latLng : [-4.61, 55.45],
            name : 'Seychelles'
        }, {
            latLng : [7.35, 134.46],
            name : 'Palau'
        }, {
            latLng : [42.5, 1.51],
            name : 'Andorra'
        }, {
            latLng : [14.01, -60.98],
            name : 'Saint Lucia'
        }, {
            latLng : [6.91, 158.18],
            name : 'Federated States of Micronesia'
        }, {
            latLng : [1.3, 103.8],
            name : 'Singapore'
        }, {
            latLng : [1.46, 173.03],
            name : 'Kiribati'
        }, {
            latLng : [-21.13, -175.2],
            name : 'Tonga'
        }, {
            latLng : [15.3, -61.38],
            name : 'Dominica'
        }, {
            latLng : [-20.2, 57.5],
            name : 'Mauritius'
        }, {
            latLng : [26.02, 50.55],
            name : 'Bahrain'
        }, {
            latLng : [0.33, 6.73],
            name : 'SÃƒÂ£o TomÃƒÂ© and PrÃƒÂ­ncipe'
        }]
    });

    //pie-chart

    $(function() {

        var data = [{
            label: "Litecoin",
            data: 11,
            color: "#c0c0c0"
        }, {
            label: "Ethereum",
            data: 33,
            color: "#627eea"
        }, {
            label: "Dashcoin",
            data: 25,
            color: "#1c75bc"
        }, {
            label: "Bitcoin",
            data: 32,
            color: "#f7931a"
        }];
    
        var plotObj = $.plot($("#flot-pie-chart"), data, {
            series: {
                pie: {
                    show: true
                }
            },
            grid: {
                hoverable: true
            },
            tooltip: true,
            tooltipOpts: {
                content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
                shifts: {
                    x: 20,
                    y: 0
                },
                defaultTheme: false
            }
        });
    
    });
    
    
    
    
}(window.jQuery),

//initializing 
function($) {
    "use strict";
   
}(window.jQuery);

//======map======


 
    

    //flot moving chart
$(function() {
    var container = $("#flot-line-chart-moving");

    // Determine how many data points to keep based on the placeholder's initial size;
    // this gives us a nice high-res plot while avoiding more than one point per pixel.

    var maximum = container.outerWidth() / 2 || 300;

    //

    var data = [];

    function getRandomData() {

        if (data.length) {
            data = data.slice(1);
        }

        while (data.length < maximum) {
            var previous = data.length ? data[data.length - 1] : 50;
            var y = previous + Math.random() * 10 - 5;
            data.push(y < 0 ? 0 : y > 100 ? 100 : y);
        }

        // zip the generated y values with the x values

        var res = [];
        for (var i = 0; i < data.length; ++i) {
            res.push([i, data[i]]);
        }

        return res;
    }

    series = [{
        data: getRandomData(),
        lines: {
            fill: true
        }
    }];


    var plot = $.plot(container, series, {
        grid: {

            color: "#999999",
            tickColor: "#D4D4D4",
            borderWidth:0,
            minBorderMargin: 20,
            labelMargin: 10,
            backgroundColor: {
                colors: ["#ffffff", "#ffffff"]
            },
            margin: {
                top: 8,
                bottom: 20,
                left: 20
            },
            markings: function(axes) {
                var markings = [];
                var xaxis = axes.xaxis;
                for (var x = Math.floor(xaxis.min); x < xaxis.max; x += xaxis.tickSize * 2) {
                    markings.push({
                        xaxis: {
                            from: x,
                            to: x + xaxis.tickSize
                        },
                        color: "#fff"
                    });
                }
                return markings;
            }
        },
        colors: ["#00bcd2"],
        xaxis: {
            tickFormatter: function() {
                return "";
            }
        },
        yaxis: {
            min: 0,
            max: 110
        },
        legend: {
            show: true
        }
    });


});
//Flot Pie Chart
