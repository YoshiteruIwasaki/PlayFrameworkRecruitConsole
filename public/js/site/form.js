$(function() {
	$('.select').select2({
	    createSearchChoice:function(term, data) {
	        if ($(data).filter(function() {
	            return this.text.localeCompare(term)===0; }).length===0) {
	            return { id:term, text:term };
	        }
	    },
		placeholder : 'タグを入力してください。',
		multiple : true,
		maximumSelectionSize : 10,
	    minimumInputLength: 2,
        tokenSeparators: [","],
        ajax: {
			type : "POST",
            url: "/json/tag",
            dataType: 'json',
            data: function (term, page) {
                return {
                    keyword: term // search term
                };
            },
            results: function (data, page) { // parse the results into the format expected by Select2.
                // since we are using custom formatting functions we do not need to alter remote JSON data
                return {results: data, text: function(item) { return item.title; }};
            }
        },
        initSelection : function (element, callback) {
            var data = [];
            $(element.val().split(",")).each(function () {
                data.push({id: this, text: this});
            });
            callback(data);
        },
        escapeMarkup: function (m) { return m; } // we do not want to escape markup since we are displaying html in results
	});
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
					$('#InputTitle').val(data.title);
					$('#InputCompany').val(data.company);
				}
			},
			error : function(data) {
				console.log(data);
			}
		});
	}
});
