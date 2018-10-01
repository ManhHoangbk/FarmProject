jQuery(document).ready(function ($) {
	$(window).scroll(function() { // is not moblie
	    if ($(this).scrollTop() >= 51) {        // If page is scrolled more than 50px
	        $('#return-to-top').fadeIn(200);    // Fade in the arrow
	        $('#btn-searchCard').css("display", 'none');
	        $("#navbar-primary").append($("#ul-login"));
	    } else {
	        $('#return-to-top').fadeOut(200);   // Else fade out the arrow
	        $('#btn-searchCard').css("display", 'block');
	    	$("#navbar-login").append($("#ul-login"));
	    }
	});
	
	$('#preloader').fadeOut('slow',function(){
		$(this).css;
	});
	
	$('#return-to-top').click(function() {      // When arrow is clicked
	    $('body,html').animate({
	        scrollTop : 0                       // Scroll to top of body
	    }, 500);
	});

	if($(window).width() <768) {
		$("#navbar-primary").append($("#ul-login"));
		$("#navbar-login").empty();
	}
	
	$( window ).resize(function() {
		if($(window).width() <768) {
			$("#navbar-primary").append($("#ul-login"));
			$("#navbar-login").empty();
		} else {
			$("#navbar-login").append($("#ul-login"));
		}
	});
});
function showDialogV2(title, content, cancelText, okText, onCancel, onOk) {
	var dialogContent = document.querySelector('#dialog-content');
	var btnOk = document.querySelector('#btn-agree');
	var btnCancel = document.querySelector('#btn-cancel');
	dialogContent.innerHTML = content;
	$('.modal-dialog').css('width', '55%');
	if (okText != "") {
		btnOk.innerHTML = okText;
		$(btnOk).css('display', "inline-block");
	} else {
		$(btnOk).css('display', "none");
	}

	if (cancelText != "") {
		btnCancel.innerHTML = cancelText;
		$(btnCancel).css('display', "inline-block");
	} else {
		$(btnCancel).css('display', "none");
	}

	$(btnOk).off('click').on('click', function() {
		onOk();
	});
	$(btnCancel).off('click').on('click', function() {
		onCancel();
		hideDialog();
	});
	if(title != ""){
		$('#dialog-title').html(title);
	} else {
		$('.modal-header').remove();
	}
	
	$('#dialog-main').modal('show');
}

function showDialogImg(title, content, cancelText, okText, onCancel, onOk) {
	var dialogContent = document.querySelector('#dialog-content-img');
	var btnOk = document.querySelector('#btn-agree-img');
	var btnCancel = document.querySelector('#btn-cancel-img');
	dialogContent.innerHTML = content;
	$('.modal-dialog').css('width', '55%');
	if (okText != "") {
		btnOk.innerHTML = okText;
		$(btnOk).css('display', "inline-block");
	} else {
		$(btnOk).css('display', "none");
	}

	if (cancelText != "") {
		btnCancel.innerHTML = cancelText;
		$(btnCancel).css('display', "inline-block");
	} else {
		$(btnCancel).css('display', "none");
	}

	$(btnOk).off('click').on('click', function() {
		onOk();
	});
	$(btnCancel).off('click').on('click', function() {
		onCancel();
		$('#dialog-main-img').modal('hide');
	});
	if(title != ""){
		$('#dialog-title-img').html(title);
	} else {
		$('.modal-header').remove();
	}
	
	$('#dialog-main-img').modal('show');
}
function showDialog(title, content, okText, cancelText, onOk, onCancel) {
	var dialogContent = document.querySelector('#dialog-content');
	var btnOk = document.querySelector('#btn-agree');
	var btnCancel = document.querySelector('#btn-cancel');
	dialogContent.innerHTML = content;
	if (okText != "") {
		btnOk.innerHTML = okText;
		$(btnOk).css('display', "inline-block");
	} else {
		$(btnOk).css('display', "none");
	}

	if (cancelText != "") {
		btnCancel.innerHTML = cancelText;
		$(btnCancel).css('display', "inline-block");
	} else {
		$(btnCancel).css('display', "none");
	}

	$(btnOk).off('click').on('click', function() {
		hideDialog();
		onOk();
	});
	$(btnCancel).off('click').on('click', function() {
		hideDialog();
		onCancel();
	});
	if(title != ""){
		$('#dialog-title').html(title);
	} else {
		$('.modal-header').remove();
	}
	$('#dialog-main').modal('show');
}

function hideDialog() {
	$('#dialog-main').modal('hide');
}

function scrollToElement(parentSelector, targetSelector, offsetTop) {
	console.log("ScrolltoElem : " + targetSelector);
	$(parentSelector).animate({
    	scrollTop: $(targetSelector).offset().top - offsetTop
  	}, 300, function(){
    });
}

function showError(message) {
	showDialogV2("Thông báo","<i class=\"fa fa-exclamation-circle icon\" aria-hidden=\"true\" style='color: #e91e63'></i>" +  message, "Đồng ý", "", function(){
	}, function(){
	});
}

function showWarn(message) {
	showDialogV2("Thông báo", "<i class=\"fa fa-exclamation-triangle icon\" aria-hidden=\"true\" style='color: #efca1c'></i>" + message, "Đồng ý", "", function(){
	}, function(){
	});
}

function showSuccess(message) {
	showDialogV2("Thông báo","<i class=\"fa fa-check-circle icon\" aria-hidden=\"true\" style='color: #00a99d'></i>" + message, "Đồng ý", "", function(){
	}, function(){
	});
}

function showInfo(message) {
	showDialogV2("Thông báo","<i class=\"fa fa-info-circle icon\" aria-hidden=\"true\" style='color: #4caf50'></i>" +  message, "Đồng ý", "", function(){
	}, function(){
	});
}