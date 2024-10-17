<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://bottlesun.github.io/study/06-Weather/style.css">
 <link rel="stylesheet" href="https://erikflowers.github.io/weather-icons/ ">
 <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
  <!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>오늘의 지역별 날씨</h2>
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
    <section>
        <div class="content-box ">
            
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
                &copy; ${today }
            </footer>
        </nav>
    </section>
    <!--weather-->


    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://kit.fontawesome.com/75e43ff16b.js" crossorigin="anonymous"></script>
    <script src="https://bottlesun.github.io/study/06-Weather/js/app.js"></script>
</body>
</html>