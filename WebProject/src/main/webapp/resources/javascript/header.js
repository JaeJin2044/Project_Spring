const menu = document.querySelector(".menu");
// profile toggle
function toggleMenu() {
	menu.classList.toggle("toggle");
}

var logOutBtnElem = document.querySelector('#logOutBtn');

logOutBtnElem.addEventListener('click',function(){
	alert('안녕');
})