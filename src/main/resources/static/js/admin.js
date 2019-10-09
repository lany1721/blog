
// 下拉菜单
$('.ui.dropdown').dropdown({
    on : 'click'
});

//侧边栏悬浮动画
$("#toggle-sidebar").hover(function () {
    $("#show-menu").toggle(300)
});

//打开侧边栏
$("#toggle-sidebar").click(function () {
    $('.ui.sidebar').sidebar({
        dimPage: false
    }).sidebar('toggle')
    ;
});


$('.ui.accordion')
    .accordion('toggle')
;

var ctx = document.getElementById("myChart");
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
        datasets: [{
            data: [1533, 2134, 1848, 2400, 2348, 2409, 1203],
            lineTension: 0,
            backgroundColor: 'transparent',
            borderColor: '#007bff',
            borderWidth: 4,
            pointBackgroundColor: '#007bff'
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: false
                }
            }]
        },
        legend: {
            display: false,
        }
    }
});


// 标签页js


//消息页js


//分类页js

