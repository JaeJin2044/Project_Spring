
var joinBtnElem = document.querySelector('#joinBtn')
var frmElem = document.querySelector('#frm');


//회원가입 체크 
if(joinBtnElem){
	var u_IdElem = frmElem.u_Id;
	var u_NmElem = frmElem.u_Nm;
	var u_PassElem = frmElem.u_Pass;
	var u_PassReElem = frmElem.u_PassRe;
	var u_AddrElem = frmElem.u_Addr;
	var u_MailElem = frmElem.u_Mail;
	var u_GenderElem = frmElem.u_Gender;
	var u_PhoneElem = frmElem.u_Phone;
	
	function ajax(){
	
		var param = {			
			u_Id: u_IdElem.value,
			u_Nm: u_NmElem.value,
			u_Pass: u_PassElem.value,
			u_Addr: u_AddrElem.value,
			u_Mail: u_MailElem.value,
			u_Phone: u_PhoneElem.value,
			u_Gender: u_GenderElem.value
			}
		
		fetch('/user/join', {
			method: 'post',
			headers: {
            	'Content-Type': 'application/json',
        	},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(myJson) {
			proc(myJson);
		})
	
	}
	function proc (myJson) {
		if(myJson.result ===1){
			alert('회원가입 성공')
			location.href="/user/login";
		}
		else{
			alert('회원가입 실패했습니다  정보를 확인해주세요')
			location.reload();
		}
	}

	function formCheck(){
		if(u_IdElem.value===""){
			alert('아이디를 입력 해주세요')
			u_IdElem.focus();
			return
		}
		if(u_NmElem.value===""){
			alert('이름을 입력 해주세요')
			u_NmElem.focus();
			return
		}
		if(u_PassElem.value===""){
			alert('비밀번호를 입력 해주세요')
			u_PassElem.focus();
			return
		}
		if(u_PassElem.value !== u_PassReElem.value){
			alert("비밀번호가 일치 하지 않습니다.")
			u_PassReElem.focus();
			return
		}
		if(u_AddrElem.value ===""){
			alert("주소를입력해주세요")
			u_AddrElem.focus();
			return
		}
		if(u_PhoneElem.value===""){
			alert("폰번호 입력 부탁드려요")
			u_PhoneElem.focus();
			return
		}
		if(u_MailElem.value ===""){
			alert("이메일을 입력해주세요")
			u_MailElem.focus();
			return
		}		
		ajax();
	}

	joinBtnElem.addEventListener('click', function() {
		formCheck();
		
	})
}



//아이디 중복확인 체크 
var idCheckElem = document.querySelector('#idCheck');
var idElem = document.querySelector('#id');
var msgElem = document.querySelector("#msg");

idElem.addEventListener('keyup',function(){
	msgElem.innerText = '아이디를 확인 해주세요';
	msgElem.style.color = '#14148C';
	joinBtnElem.setAttribute('disabled', 'disabled');
})

if(idCheckElem){
	
	
	function ajax(){
		var u_IdElem = frmElem.u_Id;
		var u_Id = u_IdElem.value;
		var msgElem = document.querySelector("#msg");
		
		fetch(`/user/chkId/${u_Id}`)
		.then(function(res){
			return res.json()
		})
		.then(function(myJson) {
			console.log(myJson);
			if(myJson.result === 1) {
				msgElem.innerText = '사용 가능한 아이디입니다.';
				msgElem.style.color = '#BE2457';
				joinBtnElem.removeAttribute('disabled');
			} else {
				msgElem.innerText = '중복된 아이디가 있습니다.';
				msgElem.style.color = '#14148C';
			}
		})
	}
	

	idCheckElem.addEventListener('click',function(){
		ajax();
	})
	
}





