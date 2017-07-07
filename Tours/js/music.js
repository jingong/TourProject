function playMusic(obj){
	var player = document.getElementById("player");
	if(player.paused){
		//播放音乐
		player.play();
		obj.src = "images/musicBtn.png";
		
	}else{
		player.pause();
		obj.src = "images/musicBtnOff.png";
	}
}
