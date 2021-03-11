
//로그인 Ajax

var loginBtnElem = document.querySelector('#loginBtn')
if(loginBtnElem) {
	
	var frmElem = document.querySelector('#frm')
	var u_IdElem = frmElem.u_id;
	var u_PassElem = frmElem.u_pass;
	var errMsgElem = document.querySelector('#errMsg')
	function ajax() {
		if(u_IdElem.value === '') {
			alert('아이디를 입력해 주세요')
			return
		} else if(u_PassElem.value === '') {
			alert('비밀번호를 입력해 주세요')
			return
		}
		
		var param = {			
			u_id: u_IdElem.value,
			u_pass: u_PassElem.value
		}
		
		fetch('/user/login', {
			method: 'post',
			headers: {
            	'Content-Type': 'application/json',
        	},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(myJson) {
			proc(myJson)
		})
	}
	function proc (myJson) {
		switch(myJson.result) {
			case 1:
				location.href = '/main/home'
			return
			case 2:
				alert('아이디를 확인해 주세요')
			return
			case 3:
				alert('비밀번호를 확인해 주세요!!!')
			return
		}
	}
	loginBtnElem.addEventListener('click', ajax)
}