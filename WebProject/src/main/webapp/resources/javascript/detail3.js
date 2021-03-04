/**
 * 
 */

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
			console.log(item.writerNm);
			cmtListElem.innerHTML += `
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
			//자신이 쓴 댓글이라면 삭제 ,수정 버튼 추가 
			var loginUserPk = parseInt(data.dataset.loginuserpk)
			if(loginUserPk === item.u_pk) {	
				cmtListElem.innerHTML += `
							<div class="del"><a href="">삭제</a></div>
							<div class="mod"><a href="" onclick="">수정</a></div>
							`;				
			}
		})
		
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

}						
}