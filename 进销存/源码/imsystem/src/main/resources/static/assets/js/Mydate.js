function myDate(){
	//单个时间插件
    $("input[name='date1']").daterangepicker(
   		 {
   	            singleDatePicker: true,//设置为单个的datepicker，而不是有区间的datepicker 默认false
   	            showDropdowns: true,//当设置值为true的时候，允许年份和月份通过下拉框的形式选择 默认false
   	            autoUpdateInput: false,//1.当设置为false的时候,不给与默认值(当前时间)2.选择时间时,失去鼠标焦点,不会给与默认值 默认true
   	            timePicker24Hour : true,//设置小时为24小时制 默认false
   	            timePicker : false,//可选中时分 默认false
   	    		locale: {
   	    			format: "YYYY-MM-DD",
   	    			separator: " - ",
   	    			daysOfWeek: ["日","一","二","三","四","五","六"],
   	    			monthNames: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
   	    		}
   	    			
   	     }
    ).on('cancel.daterangepicker', function(ev, picker) {
        $("#date1").val("请选择日期");
        $("#submitDate").val("");
    }).on('apply.daterangepicker', function(ev, picker) {
    $("#submitDate").val(picker.startDate.format('YYYY-MM-DD'));
    $("#date1").val(picker.startDate.format('YYYY-MM-DD'));
});
	
	//区间时间插件
    $("#config-demo").daterangepicker(
   		 {
   	        //autoApply: true,
   	        autoUpdateInput: true,
   	        // alwaysShowCalendars: true,
   	        ranges: {
   	            '今天': [moment(),moment()],
   	            '昨天': [moment().subtract(1, 'days'),moment().subtract(1, 'days')],
   	            '近7天': [moment().subtract(7, 'days'), moment()],
   	            '这个月': [moment().startOf('month'), moment().endOf('month')],
   	            '上个月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
   	        },
   	        locale: {
   	            format: "YYYY-MM-DD",
   	            separator: " 至 ",
   	            applyLabel: "确认",
   	            cancelLabel: "清空",
   	            fromLabel: "开始时间",
   	            toLabel: "结束时间",
   	            customRangeLabel: "自定义",
   	            daysOfWeek: ["日","一","二","三","四","五","六"],
   	            monthNames: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
   	        }
   	     }
    ).on('cancel.daterangepicker', function(ev, picker) {
        $("#config-demo").val("请选择日期范围");
        $("#startTime").val("");
        $("#endTime").val("");
    }).on('apply.daterangepicker', function(ev, picker) {
        $("#startTime").val(picker.startDate.format('YYYY-MM-DD'));
        $("#endTime").val(picker.endDate.format('YYYY-MM-DD'));
        $("#config-demo").val(picker.startDate.format('YYYY-MM-DD')+" 至 "+picker.endDate.format('YYYY-MM-DD'));
});
}