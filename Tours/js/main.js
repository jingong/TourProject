function commitData(){
	//选中要提交的表单，并且进行格式化处理
	var formData = new FormData($("#formdata")[0]);
	formData.append("userName","贾金公");
	//追加当前的日期
	formData.append("date",new Date().getFullYear() + "-"  + new Date().getDate())
	//获取时间戳
	formData.append("sign",new Date().getTime());
	$.ajax({
		type:"post",
		url:"http://127.0.0.1:8080/Tour/tourservlet?method=sendData",
		async:false,
		data:formData,
		timeout:5000,
		dataType:"json",
		cache:false,
		processData:false,
		contentType:false,
		success:function(data){
			alert(data);
			//显示发表的内容
			if(!jQuery.isEmptyObject(data.musicUrl)){
				var player = document.getElementById("player");
				player.src = data.musicUrl;
			}
			var diary = document.getElementById("diary");
			addHistoryDiary(data,diary);
		},
		error:function(xhr,textState){
			alert("请求失败！");
		}
	});
}
$(document).ready(function(){
	$.ajax({
		type:"post",
		url:"http://127.0.0.1:8080/Tour/tourservlet?method=getData",
		async:false,
		timeout:5000,
		dataType:"json",
		success:function(data){
			alert(data);
			
			var diary = document.getElementById("diary");
			for(var i in data){
				addHistoryDiary(data[i],diary);
			}
			
		},
		error:function(xhr,textState){
			alert("请求失败！");
		}
	});
});
