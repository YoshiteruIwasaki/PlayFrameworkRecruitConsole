$(function() {
	function hoverImg() {

		$(document).on('mouseover', ".hover_img", function() {
			var info = $(this).find("img");
			info.stop().animate({
				opacity : 0.2
			}, 300);
			$(".preloader").css({
				'background' : 'none'
			});
		});
		$(document).on('mouseout', ".hover_img", function() {
			var info = $(this).find("img");
			info.stop().animate({
				opacity : 1
			}, 300);
			$(".preloader").css({
				'background' : 'none'
			});
		});
	}

	$("#list0").preloader();
	hoverImg();

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
					var page = parseInt($("#page").val());
					$("#page").val(page + 1);
					// remove the loading text
					$("#loading").hide();
					// now that the ajax call is done, we can re-enable this
					obj.data("loading", false);
					$("#list" + page).preloader();
					hoverImg();
				},

				error : function(data) {
					console.log(data);
				}
			});
		}
	});
});

$('#submit-btn').click(function() {
	var btn = $(this);
	btn.button('loading');
});

$('#InputUrl').focusout(function() {
	var site = $(this);
	if (site.val() != "") {
		var data = {
			url : site.val()
		};
		$.ajax({
			type : "POST",
			url : "/api/site",
			data : data,
			dataType : "json",
			success : function(data) {
				if (data != "") {
					console.log(data);
					$('#InputTitle').val(data.title);
					//data.company;
				}
			},
			error : function(data) {
				console.log(data);
			}
		});
	}
});