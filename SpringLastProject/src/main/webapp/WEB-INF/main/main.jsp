<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>SpringLastProject</title>
    <!-- Favicon -->
    <link rel="icon" href="../img/core-img/favicon.ico">
    <!-- Core Stylesheet -->
    <link href="../css/style.css" rel="stylesheet">
    <!-- Responsive CSS -->
    <link href="../css/responsive/responsive.css" rel="stylesheet">
    <!-- VueJS -->
    <script src="https://unpkg.com/vue@3"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <link href="../css/chat.css" rel="stylesheet">
    
</head>

<body>
    <!-- Preloader Start -->
    <div id="preloader">
        <div class="yummy-load"></div>
    </div>

    <!-- Background Pattern Swither -->
    <div id="pattern-switcher">
        Bg Pattern
    </div>
    <div id="patter-close">
        <i class="fa fa-times" aria-hidden="true"></i>
    </div>

    <!-- ****** Header Start ****** -->
    <tiles:insertAttribute name="header"/>
    <!-- ****** Header End ****** -->

    <!-- ****** Home Start ****** -->
    <tiles:insertAttribute name="home"/>
    <!-- ****** Home End ****** -->

    <!-- ****** Footer Start ****** -->
    <tiles:insertAttribute name="footer"/>
    <!-- ****** Footer End ****** -->
    <div id="chat_container">
          <div id="chat" class="active">
              <header><h1>Chat</h1></header>
              <section class="content">
                  <div class="message_content">
                     무엇이든 상담하세요
                  </div>
              </section>
              <form>
                <input type="text" id="input_chat" value=""
               
                />
            </form>
          </div>
       </div>
    <!-- Jquery-2.2.4 js -->
    <!-- <script src="https://code.jquery.com/jquery-3.7.1.js"></script> -->
    <script src="../js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="../js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap-4 js -->
    <script src="../js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins JS -->
    <script src="../js/others/plugins.js"></script>
    <!-- Active JS -->
    <script src="../js/active.js"></script>
    <script type="text/javascript">
    $(function(){
    	 $('div#chat').toggleClass('active');
    	    var $win = $(window);
    	    var top = $(window).scrollTop(); // 현재 스크롤바의위치값을 반환합니다.

    	    /*사용자 설정 값 시작*/
    	    var speed          = 1000;     // 따라다닐 속도 : "slow", "normal", or "fast" or numeric(단위:msec)
    	    var easing         = 'linear'; // 따라다니는 방법 기본 두가지 linear, swing
    	    var $layer         = $('div#chat_container'); // 레이어셀렉팅
    	    var layerTopOffset = 0;   // 레이어 높이 상한선, 단위:px
    	    $layer.css('position', 'absolute');
    	    /*사용자 설정 값 끝*/

    	    // 스크롤 바를 내린 상태에서 리프레시 했을 경우를 위해
    	    if (top > 0 )
    	      $win.scrollTop(layerTopOffset+top);
    	    else
    	      $win.scrollTop(0);

    	    //스크롤이벤트가 발생하면
    	    $(window).scroll(function(){

    	      var yPosition = $win.scrollTop()+300;
    	      if (yPosition< 0)
    	      {
    	        yPosition = $win.scrollTop()+300;
    	      }
    	      $layer.animate({"top":yPosition }, {duration:speed, easing:easing, queue:false});
    	    });
    });
    </script>
</body>
    