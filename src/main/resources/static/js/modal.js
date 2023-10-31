
//하루 열지 않기
function fnCloseDay(){
    //쿠키 배치
    setCookie("popupYN", "N", 1);
    parent.window.closeModal();
}

//쿠키 등록
function setCookie(name, value, expiredays) {
    var date = new Date();
    date.setDate(date.getDate() + expiredays);
    document.cookie = escape(name) + "=" + escape(value) + "; expires=" + date.toUTCString();
}
