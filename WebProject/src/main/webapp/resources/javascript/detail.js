
//댓글 시작
var cmtListElem = document.querySelector('#cmtList');



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
			if(loginUserPk === item.u_pk) {
			//수정 할 내용 빈칸제거 ..
			var content = item.c_content.replace(/\s/gi, "");
			cmtListElem.innerHTML += `
			<li class="review-item">
				<div class="review-item__items">
					<div class="review-user">
						<img src="${item.u_profile}" alt="" />
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
						<div><button onclick=delAjax(${item.m_pk},${item.c_seq})>삭제</button></div>
						<div><button onclick=editMod(${item.m_pk},'${content}',${item.c_seq})>수정</button></div>
					</div>
				</div>
			</li>
		`;
		}else{
			cmtListElem.innerHTML += `
			<li class="review-item">
				<div class="review-item__items">
					<div class="review-user">
						<img src="${item.u_profile}" alt="" />
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
			</li>
		`;
	}
	}
)}

}
		


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

//수정 모달 띄우기 
function editMod(mPk,cContent,cSeq){
	modCtntElem.value = cContent;
	modalElem.classList.remove('hide')
	
	modBtnElem.onclick = function() {
		var param = {
			m_pk: mPk,
			c_seq: cSeq,
			c_content: modCtntElem.value
		}
		modAjax(param)
	}
}

//댓글 수정
function modAjax (param) {
	fetch('/cmt', {
		method: 'put',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(res => res.json())
	.then(myJson => {					
		if(myJson === 1) {
			modalElem.classList.add('hide')	
			selCmtList()
		} else {
			alert('수정을 실패하였습니다.')
		}
	})
}

//삭제
function delAjax(param1,param2){
	if(confirm('삭제 하시겠습니까?')){
		var m_pk = param1;
		var c_seq = param2;
		fetch(`/cmt?m_pk=${m_pk}&c_seq=${c_seq}`,{
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
				rContentElem.value='';
				review.classList.remove("review-open")	
			}else{
				alert('댓글 등록 실패')
			}
		})
	})
}




var mapAddr = mapData.dataset.addr;
var mapTitle = mapData.dataset.title;
//-------------- 지도관련 -----------------------------------------------

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch(mapAddr, function(result, status) {
	
    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: `<div style="width:150px;text-align:center;padding:6px 0;">${mapTitle}</div>`
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
//-------------- 지도관련 -----------------------------------------------




//  원석이형  모달 관련  js -------------------------------
const modal = document.querySelector(".modal-wrapper");
const mapModal = document.querySelector(".map-modal");
const mapModalImg = document.querySelector(".map-modal-img");

const review = document.querySelector(".review-wrap");


//top-img modal
function modalHandle(param) {
	var imgElem = document.querySelector('#imgModal');
	imgElem.src = param;
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

window.addEventListener("click", function (e) {
	e.target === review ? review.classList.remove("review-open") : false;
});

//review-modal
function reviewModalHandle() {
	review.classList.toggle("review-open");
}





