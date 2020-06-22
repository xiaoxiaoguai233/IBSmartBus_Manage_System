
/*
 Template Name: Annex - Bootstrap 4 Admin Dashboard
 Author: Mannatthemes
 Website: www.Mannatthemes. 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>com
 File: Exchange init js
 */

!function ($) {
    "use strict";

    var Buy = function () {
    };
     //creates Bar chart
     Buy.prototype.createBarChart = function (element, data, xkey, ykeys, labels, lineColors) {
        Morris.Bar({
            element: element,
            data: data,
            xkey: xkey,
            ykeys: ykeys,
            labels: labels,
            gridLineColor: '#eee',
            barSizeRatio: 0.4,
            resize: true,
            hideHover: 'auto',
            barColors: lineColors
        });
    },

     //creates Donut chart
     Buy.prototype.createDonutChart = function (element, data, colors) {
        Morris.Donut({
            element: element,
            data: data,
            resize: true,
            colors: colors,
        });
    },

        Buy.prototype.init = function () {
             //creating bar chart
             var $barData = [
                { y: 'January', a: 100, b: 90  },
                { y: 'February', a: 75,  b: 65 },
                { y: 'March', a: 50,  b: 40  },
                { y: 'April', a: 75,  b: 65  },
                { y: 'May', a: 50,  b: 40  },
                { y: 'June', a: 75,  b: 65  },
                { y: 'July', a: 100, b: 90 }
            ];
            this.createBarChart('morris-bar-example', $barData, 'y', ['a', 'b'], ['Series A', 'Series B'], ['#627eea', '#bacae3']);

            //creating donut chart
            var $donutData = [
                {label: "Bitcoin", value: 12},
                {label: "Ethereum", value: 42},
                {label: "Dashcoin", value: 20},
                {label: "Litecoin", value: 26}
            ];
            this.createDonutChart('morris-donut-example', $donutData, ['#f7931a', "#627eea", '#1c75bc', '#bacae3']);  

        },
        //init
        $.Buy = new Buy, $.Buy.Constructor = Buy
}(window.jQuery),

//initializing
    function ($) {
        "use strict";
        $.Buy.init();
    }(window.jQuery);