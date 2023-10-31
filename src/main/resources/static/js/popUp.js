
$(window).load(function(){

    var popup_cookie = getCookie('popup_cook');
    console.log("팝업 확인",popup_cookie);

    if(!popup_cookie){
        openModal("attendance");
    }

     //화면에 표시된 배경 레이어를 클릭한 경우
    $("#background").click(function(){
        closeModal();
    });
});


function openModal(page){
    console.log(page);

    $("#background").fadeIn(50);  //배경 레이어
    $("#front").fadeIn(50);  //이미지 레이어

    let src = "http://localhost:8080/" + page;
//    let src = "http://kangminlovesjihye.ddns.net/" + page;
    // FIXME : 이거 height가 자동조절이 안돼.
    let iframeSrc = "<iframe style='position: absolute; width: 100%; height: 100%; z-index:999;' src='" + src +"' onload='resizeIframe(this)'/>"; //이미지 태그 구성
    $('#front').html(iframeSrc);
//    $('#front').
}
function closeModal(){
        console.log("close");
        $('#background').fadeOut(100);
        $("#front").fadeOut(100);
}

function closeAndReload(){
        parent.window.closeModal();
        parent.window.location.reload();
}


function getCookie(name){
     var nameOfCookie = name + "=";
     var x = 0;
     while(x <= document.cookie.length){
        var y = (x + nameOfCookie.length);

        if(document.cookie.substring(x,y) == nameOfCookie){
            if((endOfCookie = document.cookie.indexOf(";",y))==-1)
                endOfCookie = document.cookie.length;
            return unescape(document.cookie.substring(y,endOfCookie));
        }
        x= document.cookie.indexOf(" ",x) +1;
         if(x ==0)break;
     }
     return "";

}
//iframe과 #front의 height를 재조정하는 함수
function resizeIframe(obj) {
    console.log("resizeIframe is executed");
    obj.style.height = (obj.contentWindow.document.body.scrollHeight + 20)+ 'px';
    console.log(obj.style.height);
    $('#front').css('height', obj.style.height);
}



