
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

var listCount = 10;
function selCmtList(){
	fetch(`/cmt?m_pk=${data.dataset.pk}&listCount=${listCount}`)
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
	
		myJson.forEach(function(item){
		var loginUserPk = parseInt(data.dataset.loginuserpk)
		if(loginUserPk === item.u_pk){
			cmtListElem.innerHTML = `
			<li class="review-item">
				<div class="review-item__items">
					<div class="review-user">
						
						<img src="./image/bg.jpeg" alt="" />
						<div>${item.writerNm}</div>
					</div>
					<div class="review-content">
						<div class="regdate">${item.c_regDate}</div>
						<p>
							${item.c_content}
						</p>
					</div>
					<div class="review-icon">
						<i class="far fa-laugh-squint"></i>
						<div>좋았다</div>
						<div class="del"><a href="">삭제</a></div>
						<div class="mod"><a href="" onclick="">수정</a></div>
					</div>
				</div>
			</li>
			
		`
		}else{
			cmtListElem.innerHTML = `
			<li class="review-item">
				<div class="review-item__items">
					<div class="review-user">
						
						<img src="./image/bg.jpeg" alt="" />
						<div>${item.writerNm}</div>
					</div>
					<div class="review-content">
						<div class="regdate">${item.c_regDate}</div>
						<p>
							${item.c_content}
						</p>
					</div>
					<div class="review-icon">
						<i class="far fa-laugh-squint"></i>
						<div>좋았다</div>
						
					</div>
				</div>
			</li>`;
			
		}				
	})
		
}

	function createRecord(item){

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
		
			td_3.append(delBtn)
			td_3.append(editBtn)
		
	}
		tr.append(td_1);
		tr.append(td_2);
		tr.append(td_3);
		return tr
}
	
	function createTable(){
		var tableElem = document.createElement('table')
		tableElem.innerHTML = `
		<tr>
			<th>작성자</th>
			<th>내용</th>
		</tr>`
		
		return tableElem
	}
	
	
}



selCmtList()


// 더보기 버튼 
var moreListElem = document.querySelector('#moreList');
if(moreListElem){
	function moreList(){
		listCount += 10;
		selCmtList();
	}
	moreListElem.addEventListener('click',moreList);
}


//댓글 등록 
var rWriteElem = document.querySelector('#rWrite')
var rContentElem = document.querySelector('#rContent');

rWriteElem.addEventListener('click',ajax)

function ajax(){
	var txtVal = rContentElem.value
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
				txtVal= '';
				review.classList.remove("review-open")	
			}else{
				alert('댓글 등록 실패')
			}
		})
	})
}






//  원석이형  모달 관련  js -------------------------------
const modal = document.querySelector(".modal-wrapper");
const mapModal = document.querySelector(".map-modal");
const mapModalImg = document.querySelector(".map-modal-img");

const review = document.querySelector(".review-wrap");

//top-img modal
function modalHandle() {
	modal.classList.toggle("modal-open");
}
window.addEventListener("click", function (e) {
	e.target === modal ? modal.classList.remove("modal-open") : false;
});

//map-modal
function mapModalHandle() {
	mapModal.classList.toggle("map-modal__open");
}
window.addEventListener("click", function (e) {
	e.target === mapModalImg ? mapModal.classList.remove("map-modal__open") : false;
});

//review-modal
function reviewModalHandle() {
	review.classList.toggle("review-open");
}

window.addEventListener("click", function (e) {
	e.target === review ? review.classList.remove("review-open") : false;
});










