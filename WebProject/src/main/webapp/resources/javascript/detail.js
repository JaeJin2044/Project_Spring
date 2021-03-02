
//댓글 시작
var cmtListElem = document.querySelector('#cmtList');
var modalElem = document.querySelector('#modal')
var modCtntElem = document.querySelector('#modCtnt') //수정 내용
var modBtnElem = document.querySelector('#modBtn') //수정버튼


if(modalElem) {
	//모달 닫기 버튼
	var modalCloseElem = document.querySelector('#modClose')
	modalCloseElem.addEventListener('click', function () {
		//hide클래스(모달창)
		modalElem.classList.add('hide')
	})
}

function selCmtList(){
	fetch(`/cmt?m_pk=${data.dataset.pk}`)
	.then(res => res.json())
	.then(myJson => {
		clearView()
		createView(myJson)
	})
	
	function clearView(){
		cmtListElem.innerHTML = ''
	}
	
	function createView(myJson){
		if(myJson.length === 0){
			alert('글이 없습니다')
			return 
		}
		
		var tableElem = createTable()
		
		myJson.forEach(function(item){
			tableElem.append(createRecord(item))		
		})
		cmtListElem.append(tableElem)
	}
	
	function createRecord(item){
		var tr = document.createElement('tr')
		var td_1 = document.createElement('td')
		var td_2 = document.createElement('td')
		var td_3 = document.createElement('td')
		var td_4 = document.createElement('td')
		td_1.innerText = item.c_content;
		td_2.innerText = item.writerNm;
		td_3.innerText = `<fmt:formatDate value="${item.c_regDate}" pattern="yyyy.MM.dd" />`;
		
		
		//자신이 쓴 댓글이라면 삭제 ,수정 버튼 추가 
		var loginUserPk = parseInt(data.dataset.loginuserpk)
		if(loginUserPk === item.u_pk) {
			//삭제
			function delAjax(){
				fetch(`/cmt?m_pk=${item.m_pk}&c_seq=${item.c_seq}`,{
					method: 'delete'
				}).then(res => res.json())
				.then(myJson => {
					if(myJson ===1){
						selCmtList()
					}else{
						alert('삭제를 실패 하였습니다.')
					}
				})
			}
			
			//수정 처리 
			function modAjax(param){
				fetch('/cmt',{
					method: 'put',
					headers:{
						'Content-Type': 'application/json'
					},
					body: JSON.stringify(param)
				}).then(res => res.json())
				.then(myJson => {
					if(myJson === 1 ){
						modalElem.classList.add('hide')
						selCmtList()	
					}else{
						alert('수정이 실패하였습니다.')
					}
				})
			}
			var delBtn = document.createElement('input')			
			delBtn.type = 'button'
			delBtn.value = '삭제'
			delBtn.addEventListener('click', function() {
				if(confirm('삭제 하시겠습니까?')) {
					delAjax()
				}
			})
			
			var editBtn = document.createElement('input')
			editBtn.type = 'button'
			editBtn.value = '수정'
			editBtn.addEventListener('click', function() {
				//수정할 수 있는 창이 열릴꺼임!!!
				modCtntElem.value = item.c_content
				modalElem.classList.remove('hide')
				
				modBtnElem.onclick = function() {
					var param = {
						m_pk: item.m_pk,
						c_seq: item.c_seq,
						c_content: modCtntElem.value
					}
					modAjax(param)
				}
			})
		
			td_4.append(delBtn)
			td_4.append(editBtn)
		
	}
		tr.append(td_1);
		tr.append(td_2);
		tr.append(td_3);
		tr.append(td_4);
		return tr
}
	
	function createTable(){
		var tableElem = document.createElement('table')
		tableElem.innerHTML = `
		<tr>
			<th>내용</th>
			<th>작성자</th>
			<th>등록일자</th>
			<th>삭제/수정</th>
		</tr>`
		
		return tableElem
	}
	
	
}
selCmtList()


//댓글 등록 
var cmtFrmElem = document.querySelector('#cmtFrm')
if(cmtFrmElem){
	cmtFrmElem.onsubmit = function(e){
		e.preventDefault()
	}
	var txtElem = cmtFrmElem.c_content
	var cmtWriteBtnElem = cmtFrmElem.cmtWriteBtn
	cmtWriteBtnElem.addEventListener('click',ajax)
	
	function ajax(){
		var txtVal = txtElem.value
		if(txtVal ===''){
			alert('내용이 없습니다.')
			return
		}
		var param={
			m_pk: data.dataset.pk,
			c_content : txtVal,
		}
		
		fetch('/cmt',{
			method: 'post',
			headers : {
				'Content-Type': 'application/json',
			},
			body : JSON.stringify(param)
		}).then(res=>{
			res.json().then(myJson=>{
				if(myJson ===1){
					selCmtList()
				}else{
					alert('댓글 등록 실패')
				}
			})
		})
	}
	
	
}








