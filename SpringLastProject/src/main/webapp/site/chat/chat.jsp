<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#chatArea{
  height: 450px;
  overflow-y:auto;
  border: 1px solid black; 
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script type="text/javascript">
let websocket;
// 서버연결 
function connection()
{
	// 소켓연결 
	websocket=new WebSocket("ws://localhost:8080/web/site/chat/chat-ws")
	websocket.onopen=onOpen
	websocket.onclose=onClose
	websocket.onmessage=onMessage
}
// 연결처리 => Callback 
function onOpen(event)
{
	 alert("채팅서버와 연결되었습니다!!")
}
function onClose(event)
{
	 alert("채팅서버와 연결이 해제되었습니다!!")
}
function onMessage(event)
{
	 let data=event.data // 서버에서 보낸 데이터 
	 if(data.substring(0,4)==="msg:")
	 {
		 $('#recvMsg').append("<font color=red>"+data.substring(4)+"</font><br>")
	 }
	 else if(data.substring(0,3)==="my:")
	 {
		 $('#recvMsg').append("<font color=blue>"+data.substring(3)+"</font><br>")
	 }
	 else if(data.substring(0,4)==="you:")
	 {
		 $('#recvMsg').append(data.substring(4)+"<br>")
	 }
	 // 스크롤위치 지정
	 let ch=$('#chatArea').height()
	 let m=$("#recvMsg").height()-ch
	 $('#chatArea').scrollTop(m)
}
function disConnection()
{
	websocket.close()
}
// 퇴장처리 => Callback
// 메세지 전송 => Callback

function send()
{
	let msg=$('#sendMsg').val()
	if(msg.trim()==="")
	{
		$('#sendMsg').focus()
		return
	}
	websocket.send(msg)
	$('#sendMsg').val("")
	$('#sendMsg').focus()
}
$(function(){
	$('#inputBtn').click(function(){
		connection()
	})
	$('#outputBtn').click(function(){
		disConnection()
	})
	$('#sendBtn').click(function(){
		send()
	})
	$('#sendMsg').keydown(function(key){
		if(key.keyCode===13) // enter
		{
		   send()	
		}
	})
})
</script>
</head>
<body>
<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>실시간 채팅</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    
                </div>
            </div>
        </div>
    </div>
    <section class="single_blog_area section_padding_80">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">
                     <table class="table">
				      <tr>
				        <td>
				   
				         <input type=button value="입장" class="btn-danger btn-sm" id="inputBtn">
				         <input type=button value="퇴장" class="btn-success btn-sm" id="outputBtn">
				        </td>
				      </tr>
				      <tr>
				       <td>
				        <div id="chatArea">
				          <div id="recvMsg"></div>
				        </div>
				       </td>
				      </tr>
				      <tr>
				        <td>
				          <input type=text id="sendMsg" size=60 class="input-sm">
				          <input type=button id="sendBtn" value="전송" class="btn-sm btn-primary">
				        </td>
				      </tr>
				     </table>
                    </div>
                </div>
            </div>
        </div>
        
    </section>
  </body>
</html>