<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <style>


.chating {
	background-color: #000;
	width: 500px;
	height: 500px;
	overflow: auto;
}

.chating .me {
	color: #F6F6F6;
	text-align: right;
}

.chating .others {
	color: #FFE400;
	text-align: left;
}

input {
	width: 330px;
	height: 25px;
}

#yourMsg {
	display: none;
}
</style> 
 -->
<div class="top_img">
	<img src="${detail_item.m_img1}" alt=""
		onclick="modalHandle('${detail_item.m_img1}')" /> <img
		src="${detail_item.m_img2}" alt=""
		onclick="modalHandle('${detail_item.m_img2}')" /> <img
		src="${detail_item.m_img3}" alt=""
		onclick="modalHandle('${detail_item.m_img3}')" /> <img
		src="${detail_item.m_img4}" alt=""
		onclick="modalHandle('${detail_item.m_img4}')" />
</div>
<div class="modal-wrapper">
	<div class="modal">
		<div class="modal-img">
			<img src="" id="imgModal">
		</div>
	</div>
</div>

<div class="section-wrapper">
	<div class="title-wrap">
		<div class="detail_title">
			<div class="title">
				<span class="restaurant_name">${detail_item.m_title}</span> <span
					class="rating">${detail_item.m_starPoint}</span>
			</div>
			<div class="review-btn-wrap">
				<c:if test="${loginUser != null}">
					<a class="wrate-review" href="#" onclick="reviewModalHandle()">
						<i class="fas fa-pencil-alt"></i>
						<div>리뷰쓰기</div>
					</a>
					<a class="like-btn" href="/main/insLike?m_pk=${detail_item.m_pk}"> <i class="fas fa-shopping-basket"></i>
						<div>찜하기</div>
					</a>
				</c:if>
			</div>
		</div>

		<div class="cnt">
			<span class="view_cnt"><i class="fas fa-eye"></i>${detail_item.m_viewCount}</span>
			<span class="review_cnt"><i class="fas fa-pen"></i>${detail_item.m_commentCount}</span>
		</div>
		<div id="data" data-loginuserpk="${sessionScope.loginUser.u_Pk}"
			data-pk="${requestScope.detail_item.m_pk}"></div>
		<div class="detail_description">
			<table class="info">
				<c:if test="${detail_item.m_addrRoad != null}">
					<tr>
						<th>주소</th>
						<td>${detail_item.m_addrRoad}</td>
					</tr>
				</c:if>
				<c:if test="${detail_item.m_addrJibun != null}">
					<tr>
						<th>지번</th>
						<td>${detail_item.m_addrJibun}</td>
					</tr>
				</c:if>
				<c:if test="${detail_item.m_phone != null}">
					<tr>
						<th>전화번호</th>
						<td>${detail_item.m_phone}</td>
					</tr>
				</c:if>
				<c:if test="${detail_item.m_foodType != null}">
					<tr>
						<th>음식종류</th>
						<td>${detail_item.m_foodType}</td>
					</tr>
				</c:if>
				<c:if test="${detail_item.m_price != null}">
					<tr>
						<th>가격대</th>
						<td>${detail_item.m_price}</td>
					</tr>
				</c:if>
				<c:if test="${detail_item.m_parking != null}">
					<tr>
						<th>주차</th>
						<td>${detail_item.m_parking}</td>
					</tr>
				</c:if>
				<c:if test="${detail_item.m_workingTime != null}">
					<tr>
						<th>영업시간</th>
						<td>${detail_item.m_workingTime}</td>
					</tr>
				</c:if>
			</table>
		</div>
		<div class="review">
			<div class="review-head">
				<h2 class="review-title">
					<a href="#">리뷰(total)</a>
				</h2>
			</div>
			<ul id="cmtList">
				<!-- 여기로 들어옴  -->
			</ul>

			<div class="more-review-list">
				<button id="moreList">더보기</button>
			</div>


		</div>
	</div>


	<div class="map-section">
		<div id="mapData" data-addr="${detail_item.m_addrRoad}"
			data-title="${detail_item.m_title}">
			<div class="map-modal-wrapper">
				<div class="map-modal">
					<div class="map-modal-img"></div>
				</div>
			</div>
			<div class="map-img" onclick="mapModalHandle()">
				<div id="map" style="width: 100%; height: 350px;"></div>
			</div>
		</div>
	</div>
	<div class="chat-btn">
		<button onclick="openChatModal()">채팅시작</button>
	</div>
	<div class="chat-modal-wrap">
		<input type="hidden" id="sessionId" value="" /> 
		<input type="hidden" id="h_userName" value="" />
		<div class="chat-modal">
			<div class="chat">
				<!-- <button class="chat-close" onclick="closeChatModal()"><i class="fas fa-times"></i></button> -->
				<div class="chat-wrapper">
					<div class="chattWrap" id="container_chatt">										
						
						<div id="chating" class="chating"></div>
						
					</div>
				</div>
				<div id="yourMsg" class="yourMsg">
					<div class="inputTable">
						<div class="chat-wrap">
							<div class="chat-ctnt">
								<input id="chatting" type="text" placeholder="write message" />
							</div>
							<div class="chat-ctnt"><button onclick="send()" id="sendBtn">보내기</button></div>
						</div>
					</div>
				</div>
				<div id="yourName">
					<div class="inputTable">
						<div class="chat-wrap">
							<div class="chat-ctnt">
								<input type="text" name="userName" id="userName" value="${loginUser.u_Nm}" readonly />
							</div>
							<div class="chat-ctnt"><button onclick="chatName()" id="startBtn">입장</button></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>







<!-- 리뷰 작성 모달  -->
<div class="review-wrap">
	<div class="review-modal">
		<div class="review-text">
			<form class="review-form" action="">
				<!-- <div class="label-wrap">
						<label class="radio-label" for="option1"> <input
							type="radio" value="option1" name="radio-box" id="option1" />
							<div>
								<i class="far fa-laugh-squint"></i>
								<div>좋았다</div>
							</div>
						</label> <label class="radio-label" for="option2"> <input
							type="radio" value="option2" name="radio-box" id="option2" />
							<div>
								<i class="far fa-laugh-squint"></i>
								<div>보통이다</div>
							</div>
						</label> <label class="radio-label" for="option3"> <input
							type="radio" value="option3" name="radio-box" id="option3" />
							<div>
								<i class="far fa-laugh-squint"></i>
								<div>별로였다</div>
							</div>
						</label>
					</div>
					 -->
				<!-- <input class="form-item form-title" type="text" placeholder="제목" /> -->
				<textarea class="form-item form-text" type="text" placeholder="내용"
					id="rContent"></textarea>
				<input class="form-item form-submit" type="button" value="등록"
					id='rWrite' />
			</form>
		</div>
	</div>
</div>







<!-- 리뷰 수정 모달  -->
<div id="modal" class="hide">
	<div class="modal-content">
		<div class="modReview-modal">
			<div id="modClose">
				<i class="fas fa-times"></i>
			</div>
			<textarea type="text" id="modCtnt" placeholder="내용"
				autocomplete="off"></textarea>
			<input type="button" id="modBtn" value="수정" />
		</div>
	</div>
</div>


<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20d48b705551f225a9a64f8d0d66c274&libraries=services"></script>

<!-- 채팅 자바 스크립트  -->
<script type="text/javascript">
		var ws;

		function wsOpen() {
			ws = new WebSocket("ws://" + location.host + "/chating");
			wsEvt();
		}

		function wsEvt() {
			ws.onopen = function(data) {
				//소켓이 열리면 동작
			}

			ws.onmessage = function(data) {
				//메시지를 받으면 동작
				var msg = data.data;
				if (msg != null && msg.trim() != '') {
					var d = JSON.parse(msg);
					if (d.type == "getId") {
						var si = d.sessionId != null ? d.sessionId : "";
						if (si != '') {
							$("#sessionId").val(si);
						}
					} else if (d.type == "message") {
						if (d.sessionId == $("#sessionId").val()) {
							var userName = $("#userName").val();
							$("#chating").append(
									"<p class='me'>"+userName+"<br>"+d.msg
											+ " </p>");
						} else {
							$("#chating").append(
									"<p class='others'>"+d.userName+"<br>"+d.msg+"</p>"
									);
						}

					} else {
						console.warn("unknown type!")
					}
				}
			}

			document.addEventListener("keypress", function(e) {
				if (e.keyCode == 13) { //enter press
					send();
				}
			});
		}

		function chatName() {
			var userName = $("#userName").val();
			if (userName == null || userName.trim() == "") {
				alert("사용자 이름을 입력해주세요.");
				$("#userName").focus();
			} else {
				wsOpen();
				$("#yourName").hide();
				$("#yourMsg").show();
			}
		}

		function send() {
			if($("#chatting").val().length===0){
				alert('내용을 입력해주세요');
				return
			}
			
			var option = {
				type : "message",
				sessionId : $("#sessionId").val(),
				userName : $("#userName").val(),
				msg : $("#chatting").val()
			}
			ws.send(JSON.stringify(option))
			$('#chatting').val("");
		}
	</script>