<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    Date date=new Date();
    StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
    String today=st.nextToken()+"년도 "+st.nextToken()+"월 "+st.nextToken()+"일";
    
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>오늘의 날씨</title>

    <link rel="stylesheet" href="https://bottlesun.github.io/study/06-Weather/style.css">
    <link rel="stylesheet" href="https://erikflowers.github.io/weather-icons/ ">


    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gradient-to-r from-indigo-500 text-center">
    <section>
        <div class="content-box ">
            <h1 class="text-4xl font-bold font-action">오늘의 지역별 날씨</h1>
            <div class="buttonBox mt-5 grid gap-3 grid-cols-5	">
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 서울 </button>
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 경기도 </button>
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 강원도 </button>
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 충청북도 </button>
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 충청남도 </button>
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 전라북도 </button>
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 전라남도 </button>
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 경상북도 </button>
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 경상남도 </button>
                <button class="buttonAction bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 rounded hover:bg-white hover:text-indigo-500 slowAction"> 제주도 </button>
            </div>
            
        </div>
        <div class="weather_text shadow-lg shadow-indigo-500/50 rounded mt-10 p-5">오늘의 온도는 ? </div>

        <div class="weather mx-auto mb-10 container mx-auto mt-10 drop-shadow-xl rounded
            grid grid-flow-row-dense  gap-5">
      
            <article class="weather_item rounded drop-shadow opacity-0 overflow-hidden">
                <div class="main_info flex">
                    <div class="weather_icon"><i class="fa-solid fa-sun"></i></div>
                    <div class="weather_info flex gap-2">
                        <div class="flex centers gap-2"><i class="fa-solid fa-temperature-half"></i> <span>00 ℃</span>
                        </div>
                        <p>상태 </p>
                        <p class="weatherCity">Seoul , 한국</p>
                    </div>
                </div>
                <ul class="sub_info centers flex mx-auto p-5 bg-white">
                    <li><i class="fa-solid fa-temperature-arrow-up"><span> 00℃</span></i></li>
                    <li><i class="fa-solid fa-temperature-arrow-down"><span> 00℃</span></i></li>
                </ul>

            </article>
        </div>
        <nav class="pageWrap pb-10">
            <ul class="pagination gap-2">
                <li class="bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 py-2 rounded hover:bg-white hover:text-indigo-500"><a href="#">1</a></li>
                <li class="bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 py-2 rounded hover:bg-white hover:text-indigo-500"><a href="#">2</a></li>
                <li class="bg-indigo-500 shadow-lg py-1 px-4 shadow-indigo-500/50 p-2 py-2 rounded hover:bg-white hover:text-indigo-500"><a href="#">3</a></li>
            </ul>
            <footer class="copy">
                &copy; <%=today %>
            </footer>
        </nav>
    </section>
    <!--weather-->


    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://kit.fontawesome.com/75e43ff16b.js" crossorigin="anonymous"></script>
    <script src="https://bottlesun.github.io/study/06-Weather/js/app.js"></script>

</body>

</html>