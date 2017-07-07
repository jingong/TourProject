function addHistoryDiary(data, diary) {
	//var diary = document.getElementById("diary");
	var imgdiv = document.createElement("div");
	imgdiv.className = "imgbox";
	imgdiv.id = data.sign;
	diary.appendChild(imgdiv);

	var leftdiv = document.createElement("div");
	leftdiv.className = "imgbox-left";
	var rightdiv = document.createElement("div");
	rightdiv.className = "imgbox-right";
	imgdiv.appendChild(leftdiv);
	imgdiv.appendChild(rightdiv);
	var img = document.createElement("img");
	img.className = "images";
	//设置默认图片
	img.src = "images/5.jpg";
	if (!jQuery.isEmptyObject(data.photoUrl)) {
		img.src = data.photoUrl;
	}
	leftdiv.appendChild(img);

	var a1 = document.createElement("a");
	a1.className = "delete";
	a1.innerHTML = "删除";
	a1.href = "#";
	rightdiv.appendChild(a1);
	//给删除按钮添加点击事件
	a1.onclick = function() {
		//移除当前发布的内容
		$.ajax({
			type: "post",
			url: "http://127.0.0.1:8080/Tour/tourservlet?method=deleteTour",
			data: {
				sign: data.sign
			},
			async: false,
			timeout: 5000,
			dataType: "text",
			success: function(data) {
				if(data == 1 || data == "1"){
					$("#" + imgdiv.id).remove();
					alert("删除成功！");
				}
				
			},
			error: function(xhr, textState) {
				alert("删除失败！");
			}
		});	
	}

	var p1 = document.createElement("p");
	p1.className = "descript";
	if (!jQuery.isEmptyObject(data.description)) {
		p1.innerHTML = data.description;
	}
	rightdiv.appendChild(p1);

	//外层
	var iconboxdiv = document.createElement("div");
	iconboxdiv.className = "iconbox";
	rightdiv.appendChild(iconboxdiv);
	var img1 = document.createElement("img");
	img1.src = "images/5.jpg";
	if (!jQuery.isEmptyObject(data.photoUrl)) {
		img1.src = data.photoUrl;
	}
	iconboxdiv.appendChild(img1);
	//头像
	var span1 = document.createElement("span");
	span1.className = "users";
	span1.innerHTML = data.userName;
	iconboxdiv.appendChild(span1);
	//时间
	var span2 = document.createElement("span");
	span2.className = "times";
	span2.innerHTML = data.date;
	iconboxdiv.appendChild(span2);
	//分享
	var sharediv = document.createElement("div");
	sharediv.className = "share";
	rightdiv.appendChild(sharediv);
	var span3 = document.createElement("span");
	span3.className = "sharemusic";
	span3.innerHTML = "分享音乐：暂无音乐分享";
	if (!jQuery.isEmptyObject(data.musicName)) {
		span3.innerHTML = "分享音乐：" + data.musicName;
	}
	sharediv.appendChild(span3);
	//下载
	var a2 = document.createElement("a");
	a2.className = "downloads";
	a2.innerHTML = "下载";
	a2.href = "#";
	sharediv.appendChild(a2);
	//下载事件
	a2.onclick = function() {
		if (!jQuery.isEmptyObject(data.musicName)) {
			$.ajax({
				type: "post",
				url: "http://127.0.0.1:8080/Tour/tourservlet?method=download",
				data: {
					music: data.musicName
				},
				async: false,
				timeout: 5000,
				dataType: "text",
				success: function(data) {
					alert(data);


				},
				error: function(xhr, textState) {
					alert("请求失败！");
				}
			});
		} else {
			alert("您的文件不存在！");
		}

	}
}