
var joinBtnElem = document.querySelector('#joinBtn')
var frmElem = document.querySelector('#frm');


//회원가입 체크 
if(joinBtnElem){
	
	var u_IdElem = frmElem.u_id;
	var u_NmElem = frmElem.u_nm;
	var u_PassElem = frmElem.u_pass;
	var u_PassReElem = frmElem.u_PassRe;
	var u_MailElem = frmElem.u_mail;
	var u_GenderElem = frmElem.u_gender;
	var u_PhoneElem = frmElem.u_phone;
	
	//정규식 체크
	var empJ = /\s/g; //공백체크 정규식
	var idJ = /^[a-z0-9]{4,12}$/; // a~z,0~9로 시작하는 4~12자리 아이디 
	var pwJ = /^[A-Za-z0-9]{4,12}$/;  //A-Z,a~z,0~9로 시작하는 4~12자리 비밀번호
	var nameJ = /^[가-힣]{2,6}$/; //가~힣,한글로 이뤄진 문자열 이름 2~6자리
	var mailJ = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var phoneJ = /(01[016789])([1-9]{1}[0-9]{2,3})([0-9]{4})$/;

	
	function ajax(){
	
		var param = {			
			u_id: u_IdElem.value,
			u_nm: u_NmElem.value,
			u_pass: u_PassElem.value,
			u_mail: u_MailElem.value,
			u_phone: u_PhoneElem.value,
			u_gender: u_GenderElem.value
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
		else if(myJson.result ==2){
			alert('중복된 이메일이 있습니다.')
			location.reload();
		}else{
			alert('중복된 연락처가 있습니다.')
			location.reload();
		}
	}
	
	
	
	

	function formCheck(){
		if(!nameJ.test(u_NmElem.value)){
			alert('이름은 한글로 이뤄진 2~6자리로 입력부탁드려요');
			u_NmElem.focus();
			return
		}
		if(!pwJ.test(u_PassElem.value)){
			alert('비밀번호는 A-Z,a~z,0~9로 시작하는 4~12자리 비밀번호로 입력부탁드립니다.');
			u_PassElem.focus();
			return
		}
		if(u_PassElem.value !== u_PassReElem.value){
			alert("비밀번호가 일치 하지 않습니다.")
			u_PassReElem.focus();
			return
		}
		if(!phoneJ.test(u_PhoneElem.value)){
			alert('휴대폰 -,특수문자 없이 제대로 입력부탁드려요');
			u_PhoneElem.focus();
			return
		}
		if(!mailJ.test(u_MailElem.value)){
			alert('이메일 @형식을 준수하여 입력부탁드립니다.');
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
	joinBtnElem.setAttribute('disabled', 'disabled');
})

if(idCheckElem){
	var idJ = /^[a-z0-9]{4,12}$/; // a~z,0~9로 시작하는 4~12자리 아이디 
	
	function formIdCheck(){
		if(!idJ.test(idElem.value)){
			alert('아이디는 특수문자를 제외한 4~12자리로 입력해주세요')
			idElem.focus();
			return;
		}
		ajax();
	}
	
	
	function ajax(){
		var u_IdElem = frmElem.u_id;
		var u_id = u_IdElem.value;
		var msgElem = document.querySelector("#msg");
		
		fetch(`/user/chkId/${u_id}`)
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
		formIdCheck();
	})
	
}





