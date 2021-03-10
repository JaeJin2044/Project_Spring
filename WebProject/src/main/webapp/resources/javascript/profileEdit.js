

//회원탈퇴 
function delUserBtn(u_Pk){
	if(confirm('회원 탈퇴 하시겠습니까?')){
			location.href= "/main/delUser?u_Pk="+u_Pk;
		}else{
			location.href="/main/profileEdit";
	}
}




//프로필 이미지 등록 
var profileImgElem = document.querySelector('#profileImg')
function profileUpload() {
	if(profileImgElem.files.length === 0) {
		alert('이미지 선택바랍니다')
		return
	}
	
	var formData = new FormData();
	formData.append('profileImg', profileImgElem.files[0])
	
	fetch('/main/profileEdit', {
    	method: 'post',
    	body: formData
  	}).then(res => res.json())
	.then(myJson => {
		if(myJson === 1) {
			location.reload()
		} else {
			alert('이미지 업로드에 실패하였습니다.')
		}
	})
}



//프로필 정보 수정 
var editUserBtnElem = document.querySelector('#editUserBtn');
var phoneElem = document.querySelector('#phone');
var mailElem = document.querySelector('#mail');
var userPkElem = document.querySelector('#u_Pk');
	
	function editAjax(){
 		var mailJ = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		var phoneJ = /(01[016789])([1-9]{1}[0-9]{2,3})([0-9]{4})$/;
		
		
		if(phoneElem.value.length > 0){
			if(!phoneJ.test(phoneElem.value)){
			alert('휴대폰 -,특수문자 없이 제대로 입력부탁드려요');
			phoneElem.focus();
			return
			} 
		}
		
		if(mailElem.value.length > 0){
			if(!mailJ.test(mailElem.value)){
			alert('올바르지 않은 이메일 형식입니다.');
			mailElem.focus();
			return
			}
		}
		
 		
 		var param = {			
				u_Pk : userPkElem.value,
 				u_Phone : phoneElem.value,
 				u_Mail : mailElem.value
 			}
 		
 		fetch('/user/editUser', {
			method: 'post',
			headers: {
            	'Content-Type': 'application/json',
        	},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(myJson) {
			editProc(myJson);
		})
 			
 	}

 	function editProc (myJson) {
		if(myJson.result === 3 ){
			alert('이미 존재하는 연락처입니다.')
			location.reload()
		}else if(myJson.result === 2){
			alert('이미 존재하는 이메일입니다.')
			location.reload()
		}else if(myJson.result === 1){
			alert('회원 정보 수정이 완료 되었습니다.')
			location.reload()
		}else if(myJson.result === 4){
			alert('수정할값을 입력해주세요.')
			location.reload()
		}else{
			alert('회원 정보 수정 실패하였습니다.')
			location.reload()
		}
		
	}

editUserBtnElem.addEventListener('click',editAjax);

//비밀번호 변경 
var passChangeBtnElem = document.querySelector('#passChangeBtn');
 	var passElem = document.querySelector('#pass');
 	var passCheckElem = document.querySelector('#passCheck');
 	
 	
 	
 	function passChangeAjax(){
 		var userPass = passElem.value;
 		var pwJ = /^[A-Za-z0-9]{4,12}$/;  //A-Z,a~z,0~9로 시작하는 4~12자리 비밀번호
 		
 		
 		if(!pwJ.test(userPass)){
 			alert('비밀번호는 A-Z,a~z,0~9로 시작하는 4~12자리 비밀번호로 입력부탁드립니다.');
 			passElem.focus();
 			return
 		}else if(userPass !== passCheckElem.value){
 			alert('변경하려는 비밀번호가 같지 않습니다.')
 			passCheckElem.focus();
 			return
 		}
 		
 		var param = {			
 				u_Pass: userPass,
 				u_Id : data.dataset.loginusernm
 			}
 		
 		fetch('/user/passChange', {
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
		if(myJson.result ===1 ){
			alert('비밀번호 변경 성공 ')
			location.href="/user/login";
		}else{
			alert('비밀번호 변경 실패 ')
			location.reload();
		}
	}
 	
 	passChangeBtnElem.addEventListener('click',passChangeAjax)
 	
 





//비밀번호 변경 모달 
const open = () => {
	document.querySelector(".modal").classList.remove("hidden");
};
const close = () => {
	document.querySelector(".modal").classList.add("hidden");
};

document.querySelector(".openBtn").addEventListener("click", open);
/*document.querySelector("#passChangeBtn").addEventListener("click", close);*/
document.querySelector(".bg").addEventListener("click", close);





