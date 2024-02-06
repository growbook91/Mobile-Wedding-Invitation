
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

    $(".titles.bg").click(function(){

        var tab_page = $(".title[active=true]").attr("tab-page")

        var tab_height = $(".ntab-viewport .text").eq(tab_page-1)[0].offsetHeight;
        console.log("tab_page",tab_page);
        if(tab_page == 1){
            tab_height = tab_height + $(".img-wrap").eq(0)[0].offsetHeight +20; //사진 크기
        }
        console.log("높이",tab_height);
        $(".contents.first-tab").css("height",tab_height+"px");


    })

});


function openModal(page){
    //쿠키 불러오기
    var cookieCheck = getCookie("popupYN");
    //쿠키 데이터 설정 값 확인
    if (!(cookieCheck == "Y" && page == "attendance")){
        $("#background").fadeIn(50);  //배경 레이어
        $("#front").fadeIn(50);  //이미지 레이어

        let src = "http://localhost:8080/" + page;
//        let src = "http://kangminlovesjihye.ddns.net/" + page;
        // FIXME : 이거 width도 자동조절해야 할 것 같다.
        let iframeSrc = "<iframe style='position: absolute; width: 100%; height: 100%; z-index:999;' src='" + src +"' onload='resizeIframe(this)'/>"; //이미지 태그 구성
        $('#front').html(iframeSrc);
    }
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

//쿠키 값 가져오기 (Y/N)
 function getCookie(name) {
        var cookie = document.cookie;

        if (document.cookie != "") {
            var cookie_array = cookie.split("; ");
            for ( var index in cookie_array) {
                var cookie_name = cookie_array[index].split("=");

                if (cookie_name[0] == "popupYN") {
                    return cookie_name[1];
                }
            }
        }
        return ;
    }



//function getCookie(name){
//     var nameOfCookie = name + "=";
//     var x = 0;
//     while(x <= document.cookie.length){
//        var y = (x + nameOfCookie.length);
//
//        if(document.cookie.substring(x,y) == nameOfCookie){
//            if((endOfCookie = document.cookie.indexOf(";",y))==-1)
//                endOfCookie = document.cookie.length;
//            return unescape(document.cookie.substring(y,endOfCookie));
//        }
//        x= document.cookie.indexOf(" ",x) +1;
//         if(x ==0)break;
//     }
//     return "";
//
//}
//iframe과 #front의 height를 재조정하는 함수
function resizeIframe(obj) {
    console.log("resizeIframe is executed");
    obj.style.height = (obj.contentWindow.document.body.scrollHeight + 20)+ 'px';
    obj.style.width = (obj.contentWindow.document.body.scrollWidth + 20)+ 'px';
    console.log(obj.style.height);
    console.log(obj.style.width);
    $('#front').css('height', obj.style.height);
    $('#front').css('width', obj.style.width);
}



