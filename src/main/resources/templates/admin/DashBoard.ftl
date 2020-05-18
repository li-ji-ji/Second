<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<script type="text/javascript"
	src="${base}${staticPath}/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="${base}${staticPath}/admin/css/pintuer.css">
<link rel="stylesheet" href="${base}${staticPath}/admin/css/admin.css">
<link rel="stylesheet"
	href="${base}${staticPath}/admin/css/bootstrap.css">
<link rel="stylesheet"
	href="${base}${staticPath}/js/apexChartjs/apexcharts.css">
<script type="text/javascript"
	src="${base}${staticPath}/admin/js/bootstrap.min.js"></script>
<script src="${base}${staticPath}/admin/js/pintuer.js"></script>
<script src="${base}${staticPath}/js/apexChartjs/apexcharts.min.js"></script>
</head>
<style>
.top-box {
	width: 100%;
	height: 40%;
	display: flex;
	justify-content: space-around;
	align-items: center;
	display: flex;
}

.chart1 {
	width: 30%;
	height: 100%;
}
body{
	overflow-y:hidden
}
</style>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<div id="pie"></div>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<div id="pie2"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<div id="chart1"></div>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<div id="chart2"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	   console.log(${getActKind})
	    var pie = {
	        series: ${getActKind}['datas'],
	        chart: {
	          width: 360,
	          type: 'donut',
	        },
	        labels: ${getActKind}['labels'],
	        fill: {
	          type: 'gradient',
	        },
	        title: {
	          text: '活动种类占比',
		      align: 'left'
		    },
	        legend: {
	          formatter: function(val, opts) {
	            return val + " - " + opts.w.globals.series[opts.seriesIndex]
	          }
	        },
	        responsive: [{
	          breakpoint: 480,
	          options: {
	            chart: {
	              width: 200
	            },
	            legend: {
	              position: 'bottom'
	            }
	          }
	        }]
        };
       var pie = new ApexCharts(document.querySelector("#pie"), pie);

	    var pie2 = {
	        series: ${getApplyKind}['datas'],
	        chart: {
	          width: 360,
	          type: 'donut',
	        },
	        labels: ${getApplyKind}['labels'],
	        fill: {
	          type: 'gradient',
	        },
	        title: {
	          text: '积分申请种类占比',
		      align: 'left'
		    },
	        legend: {
	          formatter: function(val, opts) {
	            return val + " - " + opts.w.globals.series[opts.seriesIndex]
	          }
	        },
	        responsive: [{
	          breakpoint: 480,
	          options: {
	            chart: {
	              width: 200
	            },
	            legend: {
	              position: 'bottom'
	            }
	          }
	        }]
       };

       var pie2 = new ApexCharts(document.querySelector("#pie2"), pie2);
       pie.render();
       pie2.render();
	   var options = {
         series: [{
           name: "参加人数",
           data: ${getActJoin}['datas'].reverse()
	       }],
	         chart: {
	         type: 'line',
	       },
	       stroke: {
	         curve: 'straight'
	       },
	       title: {
	         text: '近期活动参加人数',
	         align: 'left'
	       },
	       grid: {
	         row: {
	           colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
	           opacity: 0.5
	         },
	       },
	       xaxis: {
	         categories: ${getActJoin}['labels'].reverse(),
	       },
	       yaxis: {
    	      min: Math.min(...${getActJoin}['datas']),
    	      max: Math.max(...${getActJoin}['datas']),
	       }
       };

       var chart1 = new ApexCharts(document.querySelector("#chart1"), options);
       chart1.render();
       
       var options2 = {
 	        series: [{
 	          data: ${getAssoStuJoin}['datas']
 	        }],
 	        chart: {
 	          type: 'bar',
 	          events: {
 	            click: function(chart, w, e) {
 	              // console.log(chart, w, e)
 	            }
 	          }
 	        },
 	        plotOptions: {
 	          bar: {
 	            columnWidth: '10%',
 	            distributed: true
 	          }
 	        },
	        title: {
	          text: '社团参加情况',
		      align: 'left'
			},
 	        dataLabels: {
 	          enabled: false
 	        },
 	        legend: {
 	          show: false
 	        },
 	        xaxis: {
 	          categories: ${getAssoStuJoin}['labels'],
 	          labels: {
 	            style: {
 	              fontSize: '12px'
 	            }
 	          }
 	        }
 	        };
       var chart2 = new ApexCharts(document.querySelector("#chart2"), options2);
       chart2.render();
	</script>

</html>