function myDate() {
	$('#config-text').keyup(function() {
		eval($(this).val());
	});

	$('.configurator input, .configurator select').change(function() {
		updateConfig();
	});

	$('.demo i').click(function() {
		$(this).parent().find('input').click();
	});

	$('#startDate').daterangepicker({
		singleDatePicker : true,
		startDate : moment().subtract(6, 'days')
	});

	$('#endDate').daterangepicker({
		singleDatePicker : true,
		startDate : moment()
	});

	updateConfig();

	function updateConfig() {
		var options = {};

		if ($('#singleDatePicker').is(':checked'))
			options.singleDatePicker = true;

		if ($('#showDropdowns').is(':checked'))
			options.showDropdowns = true;

		if ($('#showWeekNumbers').is(':checked'))
			options.showWeekNumbers = true;

		if ($('#showISOWeekNumbers').is(':checked'))
			options.showISOWeekNumbers = true;

		if ($('#timePicker').is(':checked'))
			options.timePicker = true;

		if ($('#timePicker24Hour').is(':checked'))
			options.timePicker24Hour = true;
		$('#config-text')
				.val(
						"$('#demo').daterangepicker("
								+ JSON.stringify(options, null, '    ')
								+ ", function(start, end, label) {\n  console.log(\"New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')\");\n});");

		$('#config-demo').daterangepicker(
				options,
				function(start, end, label) {
					console.log('New date range selected: '
							+ start.format('YYYY-MM-DD') + ' to '
							+ end.format('YYYY-MM-DD') + ' (predefined range: '
							+ label + ')');
				});

	}
}
