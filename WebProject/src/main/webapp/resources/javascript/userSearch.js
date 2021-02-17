// 아이디찾기 & 비밀번호 찾기 화면전환
function search_check(num) {
	if (num == '1') {
		document.getElementById("searchPw").style.display = "none";
		document.getElementById("searchId").style.display = "";
	} else {
		document.getElementById("searchId").style.display = "none";
		document.getElementById("searchPw").style.display = "";
	}
}


//아이디찾기
function idSearch_click(){
	var u_NmElem = document.querySelector('#Name');
	var u_PhoneElem = document.querySelector('#Phone');
	var msgElem = document.querySelector('#msg');
	
	
	if(u_NmElem.value === '') {
		alert('이름를 입력해 주세요')
		u_NmElem.focus()
		return
	} else if(u_PhoneElem.value.length < 8) {
		alert('휴대폰 번호를 제대로 입력해주세요')
		u_PhoneElem.focus()
		return
	}
	
	var param = {
		u_Nm : u_NmElem.value,
		u_Phone : u_PhoneElem.value
	}
	
	fetch('/user/findId',{
		method : 'post',
		headers : {
			'Content-Type' : 'application/json'
		},
		body : JSON.stringify(param)
	}).then(function(res){
		return res.json()
	}).then(function(myJson){
		if(myJson.result == null){
			alert('정보를 잘못 입력하셨어요.. 회원정보확인바람');
		}else{
			msgElem.innerText = "당신의 아이디는 : "+myJson.result.u_Id;
		}
		
	})
	
}


//비밀번호 찾기
function pwSearch_click(){
	var u_IdElem = document.querySelector('#id');
	var u_MailElem = document.querySelector('#email')
	
	if(u_IdElem.value === '') {
		alert('아이디를 입력해주세요')
		u_IdElem.focus()
		return
	} else if(u_MailElem.value.length < 10) {
		alert('이메일을 제대로 입력해주세요')
		u_MailElem.focus()
		return
	}
	
	var param = {
		u_Id : u_IdElem.value,
		u_Mail : u_MailElem.value
	}
	
	fetch("/user/findPw",{
		method : 'post',
		headers : {
			'Content-Type' : 'application/json'
		},
		body : JSON.stringify(param)
	}).then(function(res){
		return res.json()
	}).then(function(myJson){
		console.log(myJson.result)
		if(myJson.result === -1){
			alert('아이디가 등록되지 않았습니다')
			u_IdElem.focus()
		}else if(myJson.result === 0){
			alert('이메일이 등록되지 않았습니다.')
			u_MailElem.focus()
		}else{
			alert('고객님의 이메일로 임시비밀번호를 발송 하였습니다.')
		}
	})
	
	
}
















