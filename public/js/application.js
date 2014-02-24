$(function() {
	$("#list0").preloader();
});

$(function() {
	$(window).bottom({
		proximity : 0.5
	});
	$(window).on('bottom', function() {
		var obj = $(this);
		// since this ajax call might take a while
		if (!obj.data("loading") && $("#hasNext").val() == 0) {
			obj.data("loading", true);
			$("#loading").show();
			$.ajax({
				url : "/listAjax/" + $("#page").val(),
				dataType : "html",
				success : function(data) {
					if (data == "") {
						$("#hasNext").val(1);
					} else {
						$("#listContainer").append(data);
					}
					var page = parseInt( $("#page").val() );
					$("#page").val(page + 1);
					// remove the loading text
					$("#loading").hide();
					// now that the ajax call is done, we can re-enable this
					obj.data("loading", false);
					$("#list"+page).preloader();
				},

				error : function(data) {
					console.log(data);
				}
			});
		}
	});
});