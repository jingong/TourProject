$(document).ready(function(e){
	//定时器 每隔一秒钟 获取一次数据
	//参数一：自定义的方法    参数二：间隔时间
	setInterval(function(){
		var datas = new Date();
		//获取时分秒
		var h = datas.getHours();
		var m = datas.getMinutes();
		var s = datas.getSeconds();
		if(h < 10){
			h = "0" + h;
		}
		if(m < 10){
			m = "0" + m;
		}
		if(s < 10){
			s = "0" + s;
		}
		//刷新页面
		document.getElementById("time").innerHTML = h + ":" + m + ":" + s;
		
	},1000);
});
