/**
 * ajax请求后台删除班级
 */
function deleteClasses(id) {

	$.ajax({
		type: 'POST',
		url: 'deleteClasses',
		cache: false,
		data: {
			classesId: id
		},
		success: function (data) {
			showInfo(data);
		},
		error: function (jqXHR, textStatus, errorThrown) {
			showInfo("提交失败，请重试");
		}
	});

}


$('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
       		 location.reload();  	//刷新当前页面
 });



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}

