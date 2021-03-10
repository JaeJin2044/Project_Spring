<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="nav">
	<div class="nav-left">
		<a href="/main/home" style="text-decoration: none">
			<div class="logo">logo</div>
		</a>
	</div>
	<form class="search-bar" action="/main/home?&searchText=${searchText}&page=${page}" method="get">
		<span class="search-bar__icon"><i class="fas fa-search"></i></span> <input
			class="search-bar__item" id="searchText" name = "searchText" type="text" placeholder="search"  value = "${searchText}"/> <input
			class="search-bar__btn" id = "searchBtn" type="submit" value="검색" />
	</form>
	
	<div class="nav-right" id="data1" data-loginuserpk="${sessionScope.loginUser.u_Pk}">
		<div class="nav-right__item">
			<a href="/main/home">리스트</a>
		</div>
		<div class="nav-right__item">
			<button class="chattBut" onclick="openChatModal2()">채팅</button>
		</div>
		<div class="action">
			<div class="profile" onclick="toggleMenu()">
				<c:choose>
					<c:when test="${loginUser.u_profile == null}">
						<c:set var="src" value="profile.jpg"/>
					</c:when>		
					<c:otherwise>
						<c:set var="src" value="user/${loginUser.u_Pk}/${loginUser.u_profile}"/>
					</c:otherwise>
				</c:choose>
			<img src="/resources/image/${src}" alt="프로필 이미지">
			</div>
			<div class="menu">
				<h3>
					${loginUser.u_Nm}<br />
				</h3>
				<ul>
					<li><i class="fas fa-user-alt"></i><a href="/main/checkProfile">My profile</a></li>
					<li><i class="fas fa-cog"></i><a href="/main/checkUser">Like</a></li>
					<c:if test="${loginUser == null }">
						<li><i class="fas fa-sign-out-alt"></i><a href="/user/login">login</a></li>
					</c:if>
					<c:if test="${loginUser != null }">
						<li><i class="fas fa-sign-out-alt"></i><a href="/user/logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	
	<!-- 채팅 관련  -->
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
</header>

<script>

//chat-modal
var chat = document.querySelector(".chat");

function openChatModal2() {
	var loginUserPk = parseInt(data1.dataset.loginuserpk)
	if(!loginUserPk){
		alert('로그인한 유저만 이용 할수 있습니다.');
		return;
	}
	
	chat.classList.toggle("open-chat");
}
function closeChatModal() {
	chat.classList.remove("open-chat");
}




//채팅 관련 js

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
							"<p class='me'>"+d.msg
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




