

function delLikeList(l_pk){
		if(confirm('정말 삭제하시겠습니까?')){
			location.href= "/main/delLike?l_pk="+l_pk;
		}else{
			location.href="/main/likeList";
	}
}



var listCount = 5;
var selLikeListElem = document.querySelector('#selLikeList')
function selLikeList(){
	fetch(`/main?listCount=${listCount}`)
	.then(res => res.json())
	.then(myJson => {
		clearView()
		createView(myJson)
	})
	
	function clearView(){
		selLikeListElem.innerHTML = ''
	}
	
	function createView(myJson){
		if(myJson.length === 0){
			return 
		}
		myJson.forEach(function(item){
			selLikeListElem.innerHTML += `
			<div class="content-list">
      	 			 <img class="content-list__img" src="${item.m_img1}" alt="" />
			<div class="text_wrap">
				<div class="content-list__text">
					<div class="text_title">
						<a href="/main/detail?m_pk=${item.m_pk}">${item.m_title}</a>
						<div class="rating__score">
							${item.m_starPoint}
							<i class="fas fa-star"></i>
						</div>
					</div>
					<div class="text_description">${item.m_viewDetail}</div>
					<div class="content-list__cnt">
						<span class="view_cnt"><i class="fas fa-eye"></i>${item.m_viewCount}</span>
						<span class="review_cnt"><i class="fas fa-pen"></i>${item.m_commentCount}</span>
					</div>
				</div>
			</div>
			<button class="delBtn" onclick="delLikeList(${item.l_pk})">
            <i class="fas fa-trash-alt"></i>
          </button>
			</div>
			<a href="/main/delLike?l_pk=${item.l_pk}"></a>
		`;
		}) 
	}
	
}


selLikeList();





// 더보기 버튼 
var moreListElem = document.querySelector('#moreList');
if(moreListElem){
	function moreList(){
		listCount += 5;
		selLikeList();
	}
	moreListElem.addEventListener('click',moreList);
}




