# Typora 단축키

<u>Ctrl+u</u>

**Ctrl+B**

[ctrl+k 하이퍼링크](http://localhost:8181/web-study-01/helloworld.jsp)

## ctrl+1~6 제목 크기



### Eclipse 단축키

Ctrl+space-코딩인사이트

Ctrl+D-줄삭제

Ctrl+shift+/ -주석처리

Ctrl+shift+O - import 정리

Ctrl+shift+L -단축키 리스트

shift+ALT+T -리펙토링 매뉴 띄우기

Alt+shift+S-인텔리제이의 컨텍스트 메뉴

게터 세터 쉽게생성

Alt+shift+s => R=> Alt+A => Alt+ S => enter

# jsp & Servlet 공부

### servlet이란?

**server+Applet의 합성어**

javax.servlet.http 패키지에서 제공하는 httpServlet 클래스를 상속받아 구현해야함.
이러한 상속받아 만든 서브 클래스를 **서블릿 클래스**라고함



**servlet 클래스**에는

**doGet, doPost**의 2개의 메소드가 있는데 하나는 get방식으로 받았을때 작동하는메소드, 하나는 post방식으로 호출받았을때 행동하는 메소드 이다.



또한 매개변수로 **HttpServletRequest**와 **HttpServletResponse** 2개의 변수가 오게되는데

첫번째 매개변수 **request** 는 클라이언트의 요청을 처리하고

두번째 매개변수 **response**는 요청처리 결과를 되돌려주기 위해 사용된다.



그리고 결과를 되돌리기 위해서는 **response** 로부터 printwriter형의 출력스트림 객체를 얻어와야 한다.

-response.getwriter

또한 이렇게 받아온 출력스트림 객체는 println메소드를 이용하여 브라우저에게 HTML코드를 보내줄 수 있다.

-예제 unit01.AdditonServlet01.java



#### JSP란?

###### Java Server Page의 줄임말로 자바로 서버 페이지를 작성하기 위한 언어

일반적으로 **스트립 트릿 <%      %>** 안에 자바코드를 넣고

결과값을 표현하기 위해서는 **표현식 <%=   %>**

을 이용하여 표현

-예제 ws-01 addition02.jsp



#### 그럼 서블릿과 차이점이 뭐야?

jsp=HTML안에 자바코드

servlet=자바코드 안에 HTML



#### 그럼 servlet은 필요가 없겟네?--그렇진 않다

복잡한 자바 코드들을 jsp에 구현하기엔 실수가 너무 많아지기 때문에

복잡한 로직은 서블릿에 하고 결과만 jsp를 통해 클라이언트에 제공하는 형태로 개발

-예제 ws01-unit02.additionServlet03.java + additon03.jsp



이와 같이 로직과 표현을 분리하여 프로그래밍 하는것을 MVC 패턴이라고 함

서블릿이 비즈니스 로직을 구현하는 Model 역할

JSP가 결과를 출력하는 View 역할을 하고있음.

## 

##### 서블릿을 만들때 URL 맵핑이란?

서블릿을 동작하기 위해서 실제 자바 클래스 이름 대신에 사용하는 문자열.

이 문자열을 부르면 해당 서블릿이 호출되는것



##### 컨텍스트 패스란?

http://localhost:8181/hospital 라는 것이 만약 병원관리 어플리케이션에 접속하게 해주는 패스일때 hospital가 컨텍스트 패스

http://localhost:8181/movie 라는 것이 만약 영화예매 어플리케이션에 접속하게 해주는 패스일때 movie가 컨텍스트 패스

#   

### Servlet을 알아보자



##### 웹 어플리케이션 등록

톰캣서버에서 클라이언트에게 웹 애플리케이션을 서비스해 주기 위해서는 톰캣서버에 웹 애플리케이션을 등록해야함

톰캣서버의 server.xml 파일의 <Context> 태그를 사용하여 컨텍스트 패스 추가가능

이중 path 속성이 서블릿을 요청할때 지정할 URL에 기술할 가상패스



##### 서블릿의 실행 방식

자바클래스 실행-main 메소드가 있는 클래스에서 객체 생성하여 실행

서블릿의 실행-Event_Driven Programming으로 사용자의 요청이 들어오면 동작을 시작- 톰캣 서버가 서블릿 객체를 생성한후에 init()메소드를

호출한후 요청 방식에 따라 doGet() 혹은 doPost() 메소드가 호출



##### 서블릿의 동작 원리

서블릿 컨테이너-서블릿의 실행은 서블릿 컨테이너에 의해 이루어지고 아파치 **tomcat** 이 그 역할을 함

요청:클라이언트-웹서버-서블릿컨테이너-스레드-서블릿객체

응답:서블릿객체-스레드-서블릿컨테이너-웹서버-클라이언트



클라이언트가 요청을 하면 웹서버가 서블릿 요청인식- 서블릿컨테이너에게 서블릿을 수행하도록 넘겨줌

-서블릿은 스레드를 기동하여 해당 서블릿 객체를 생성하여 이를 수행

-서블릿 객체의 작업이 종료되면 기동되었던 스레드 조욜

-서블릿 수행 결과가 웹서버에 전송

-클라이언트에 전송



##### 서블릿의 라이프 사이클

1. Instance 생성

2. init()

3. doGet() 혹은 doPost()- 요청할때마다 반복

4. destroy

   

ex) web-study-02->unit02 lifeCycle



##### 서블릿의 한글처리와 데이터 통신

서블릿은 한글을 처리하려면 response 변수의 setContentType 메소드를 이용하여

형태를 UTF-8로 가공해야한다

ex) response.setContentType("text/html; charset=UTF-8");



##### get 방식과 post 방식의 예제

ex) web-study-02-> unit04 MethodServlet.java, 04_method.jsp



#### Query String 이란?

페이지 사이에 정보교환이 필요한 경우가 있는데 이를 위해서 웹 프로그래밍에서 제공하는 것이 쿼리스트링

ex) paramServlet? id=bj & age = 25  -> 

id, age-이름

bj,25-값

이를 위해 html 에서 해줘야하는 형식

<input type"text" name="이름">

이를 받아온 Servlet이 해줘야하는 형식

String 변수=request.getParameter("이름");

다만 항상 String 형식으로 읽어오기때문에 Servlet에서 숫자형으로 쓰고싶으면 변환해줘야함

Interger.parseInt(변수) or Interger.parseInt(request.getParameter("이름"))

물론 이럴경우 숫자를 예상햇지만 이상한값이나 빈칸이 오게되면 숫자형으로 변환을 못해 에러가 나기때문에 유효성 체크를 해줘야한다.

물론 이러한 작업은 자바스크립트로 만 가능하다고함.. jsp나 html은 불가능하다고함

ex) web-study-02 

param.js-유효성체크를 위한 자바스크립트

05_param.jsp

unit05-paramServlet.java



#### 서블릿에서 요청시 한글처리

서블릿에서 한글을 처리하기 위해서는 별도의 처리를 해야함



##### -get방식으로 요청시

Server.xml 파일의 첫번째 등장하는 <Connector> 태그를 찾아서 URLEncoding 속성을 추가해야함

ex)<Connector connectionTimeout="20000" port="8181" protocol="HTTP/1.1" redirectPort="8443"/> 을

 <Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8181" protocol="HTTP/1.1" redirectPort="8443"/> 로

ex) 06_info.jsp, unit06-InfoServlet.java,        그리고 Tomcat폴더내의 Server.xml



##### -post방식으로 요청시

Servlet의 doPost 메소드에 

request.setCharacterEncoding("UTF-8"); 설정을 해주어야함

ex) 06_info.jsp, unit06-InfoServlet.java



#### Input에서 name 과 id 그리고 여러가지 타입

<label for="id"></label>

<input type="text" id="id" name="name"></input>

이상황에서 html의 id는 라벨과 이어주는 역할이고

name은 서블릿으로 보낼때 데이터의 이름을 지어주어 Servlet에서 매칭하는 역할을함



또한 Input type 중 radio는 html에서 여러가지중 "하나" 를 고르는 것이기에 

서블릿에서 String 으로 받지만

Input type 중 checkbox는 여러개의 결과를 받는것이기에 

String[] 배열로 받고 request.getParameterValues(name); 으로 받게된다

또 목록상자인 select 태그 또한 마찬가지로 여러개의 결과기 때문에 위의 결과를 수행한다



패스워드타입-07_login.jsp , unit07-LoginServlet.java

라디오타입-08_radio.jsp, unit08-radioServlet.java

체크박스타입-09_checkbox.jsp, unit09-checkboxServlet.java

선택박스타입-10_select.jsp, unit10-selectServlet.java

## 







## JSP 기본다루기 -3장



#### 컨텍스트 패스 수정

server.xml에 새로 추가된 컨텍스트를 보면 패스가 잇음 이것을 /뒤에로 바꾸면 된다



#### JSP와 HTML

HTML:확장자 html-웹브라우저에서 번역기가 돌아감

JSP:확장자.jsp-톰캣서버가 번역해서 결과를 HTML 태그로 변환후 웹브라우저에 내려보냄

-페이지에 JSP인것을 알리는 페이지 지시자인 <%@ page %> 가 꼭 들어가 있어야함



TIP:스크립트릿 사이의 out.print()메소드를 사용해서 이 자리에서 바로 추가가능



##### JSP와 Servlet

우리가 jsp로 코딩을해도 서블릿 컨테이너는 JSP를 직접 해석하지 못함

-서블릿(서블릿파일)로 변환후 해석

-서블릿 파일은 컴파일되어 서블릿 클래스 파일 생성

-수행결과가 웹서버에 전송



##### service()

get방식과 post방식 구분없이 모든 요청에 대한 처리를 하는 메소드



##### 내장객체란?

서블릿 컨테이너가 JSP를 서블릿으로 변환하는 과정중 서비스 메소드 선언다음 내장 객체선언하고 값을 할당시

서블릿에서 사용했던 out과 같은 내장객체를 JSP에서 사용가능





#### JSP 기본태그

<% %> - 스크립트릿-자바코드 기술

-tip <% if(){    %>         <% } 형식으로 if문사이 저 중간에 자바스크립트나 액션태그 등을 넣으면 조건에 해당될 경우 기입한 작업을 실행하게 할 수 있다

<%! %> - 변수나 메소드 선언 - 관례적으로 html 맨위-- <%@ page %> 아래

<%= %> - 표현식- 결과를 문자열 형태로 출력

<%-- --%> - 주석

<%@ %> - JSP 페이지의 속성을 지정함-지시자



##### JSP 로컬 변수와 글로벌변수

상단에 <%!%> 로 선언한 변수는 글로벌 변수로 페이지 로딩시 +1만큼 증가시키는 코드를 짯다고했을때 그대로 동작하지만

스크립트릿으로 작성한 변수들은 그 역할이 끝나면 초기화가 되어 위의 상황에 적용하지 못한다.



##### 지시자 종류

<% page 속성="값". .... %>

<% include file="URL" %>



##### 페이지 지시자

jsp 페이지에 여러가지 정보를 나타내기 위해서 사용되는 JSP문법

-속성:

-language = jsp는 오로지 자바만이 들어갈수잇음 - <%@ page language="java"%>

-extends= 특정클래스로 부터 상속받으려면 extends 속성에 상위클래스를 누구를 설정할지 기술<%@ page extends= "javax.servlet.jsp.HttpJspBase" %>

-import = 자바 프로그램에서 사용하던 import 구문과 동일한 목적으로 사용 <%@ page import="java.util.calender" %>

-session=true 혹은 false 값으로 세션을 사용할지 말지를 결정하는 속성-기본값 true  <%@ page session="true" %>

-buffer=전송할 데이터의 블록의 크기를 설정 기본 8kb-none으로 설정시 버퍼가없다.. <%@ page buffer="none" %>

-autoFlush=버퍼가 꽉찻을때 자동으로 비우는(전송)하는 속성 기본적으로 true -false로 지정하면 버퍼가 꽉차게 되면 에러가 발동 -버퍼의 크기를 none으로 하지말아야함-기본값 true <%@ page autoFlush="false" %>

-isThreadSafe=true로 설정시 각각페이지의 스레드들이 안전하게 동작가능-false로설정시 공유되는 객체들은 따로 동기화 시켜야함 <%@ page isThreadSafe="true" %>

-info=jsp 페이지에 대한 간략한 설명을 기록하는 용도- 이페이지에 적어놓고 싶은거 적어놔 <%@ page info="이 페이지는 jsp 페이지입니다" %>

-errorPage= jsp 페이지에서 에러가 발생했을때 보여줄 에러 페이지를 설정 <%@ page errorPage="error.jsp"%>

-isErrorPage= 현재의 페이지가 에러페이지 인지 아닌지 설정하기 위한 속성 -기본값 false <%@ page isErrorPage="false" %>

-contentType=JSP 페이지의 MIME 타입결정-서버가 클라이언트에게 이런 데이터를 보낼것이다 라고 헤더에 포함하여 미리 알려주는 역할 html일경우 text/html

utf-8일경우 text/html;charset=UTF-8 <%@ page contentType="text/html;charset=UTF-8" %>



정리:이 페이지가 에러페이지면 iserrorpage를 true로

error 페이지가 아니라면 이 페이지에서 에러났을때 보여줄 error page를 지정

language는 어차피 자바밖에못함

이 페이지에서 상속받을것은 extends, 가져올건 import 사용

session은 앵간해서는 사용하니까 default인 true로 냅두고

앵간해선 기본값 두세용



##### Include 지시자

현재페이지에 다른 HTML 문서나 JSP 페이지의 내용을 삽입할때 사용-모든 페이지에서 공통적으로 보여주어야 할부분이 있다면?(로고나 페이지 하단에 보이는 저작권 표시등)-web-study-03-08_main.jsp ,08_sub.jsp, footer.jsp <%@ Include file="footer.jsp" %> -바디사이에 껴서 사용



## JSP 내장객체-4장



##### 입출력 객체

**request, response, out**



##### 서블릿 관련 객체

**page , config**



##### 외부 환경정보 제공하는 객체

**session, application, pageContext**



**예외 관련 객체**

**exception**



##### out

서블릿에서 out을 쓸려면 PrintWriter 객체를 만든다음 response에서 getWriter() 메소드를 통해 얻어서 할당한 다음 사용해야하지만

JSP 에서는 자동으로 out을 쓸수잇음



##### request

**-메소드종류**

**브라우저 요청 메소드**

getContextPath()-JSP 페이지가 속한 컨텍스트 패스-(URL 에서 표시되는거)를 구합니다

getMethod()-요청방식이 get인지 post 방식인지 알려줌

getRequestURL()-요청 URL을 구함

getRequestURI()-요청 URL 에서 쿼리스트링을 제외한 부분을 구함

getQueryString()-요청URL 다음에 오는 쿼리 스트링을 구함

getSession(flag)-요청 관련된 세션 객체를 구합니다

getRequestDispacher(path)-지정 로컬 URL에 대한 RequestDispacher 객체를 구함

getRemoteHost()-요청된 호스트의 완전한 이름을 구함

getRemoteAddr()-요청 호스트의 네트워크 주소를 구함

getRemoteUser()-요청한 사용자의 이름을 구함

getSession()-세션객체를 구함

getServerName()-서버의 이름을구함

getProtocol()-사용중인 프로토콜을 알려줌



**파라미터 요청 메소드**

getParameter(String name)-지정한 이름의 파라미터를 구함-여러개일경우 첫번째 파라미터를 구함

getParameterNames()-모든 파라미터의 이름을 구함

getParameterValues(String name)-지정된 이름의 파라미터가 여러개 있으면 모든값을 String 배열로 넘겨줌



##### response

sendRedirect(String URL)-이 페이지로 강제이동-객체가 전송이 안됨-다만 피라미터를 손수 넣어서 강제 이동시키려면

response.sendRedirect("04_main.jsp?name="+URLEncoder.encode("성윤정", "UTF-8"));처럼 URLEncoder.Encode메소드로 인코딩을해야함

forward()-이동 데이터 전송포함, requestDispatcher 객체로 접근해야만 호출가능

이 객체는 request객체의 getRequestDispatcher() 메소드로 호출가능

데이터를 같이 전송하고 싶으면 

setAttribute("속성이름", 속성값); 으로 전송가능 - 다만 String으로 전송시 리턴타입이 오브젝트임으로 cast 를 해야함



#### application 내장객체

하나의 웹 어플리케이션을 관리하고 웹 어플래케이션 안에서 자원을 공유-어플리케이션이란 web-study-01 같이 하나의 프로젝트를 말함

application.setAttribute("name", "application man")

처럼 속성을 지정하거나 값을 할당하면 이 어플리케이션안에있는 모든 jsp에서 끄집어서 쓸수잇음

application 내장객체는 한 어플리케이션에서 딱 하나만 생성이됨



**어플리케이션 객체 메소드**

getServerInfo()-컨테이너 이름과 버전을 반환

getContextPath()-웹 어플리케이션의 URL경로중 컨텍스트 패스명 반환

getRealPath() JSP 의 실제경로를 반환

getMimeType(filename)-지정된 파일의 MIME 타입반환

log(message)-지정된 메세지의 로그저장





#### 내장 객체의 영역

4가지로 구분이됨-scope

**page**-하나의 jsp페이지를 처리할때 사용되는영역

- 브라우저의 요청이 들어오면 JSP페이지 실행

- 이때 실행하게되는 JSP페이지의 범위가 하나의 page 영역
-  브라우저 요청을 처리하는 JSP페이지는 요청에 대해 새로운 page영역을 가짐
- 그리고 그에 해당하는 pageContext 내장객체를 할당받음-메모리에 로딩됨
- 이 pageContext에 정보 저장시 해당페이지 내에서만 사용가능



**request**-하나의 요청을 처리할때 사용되는 영역

- 브라우저에서 오는 한번의 요청과 관련-URL을 입력하거나 페이지 링크 클릭할때 웹서버에 전송되는 요청이 하나의 request영역

- 사용자가 페이지 요청시 요청한 페이지와 요청을 받은 페이지 사이에 request 내장객체에 정보를 저장가능
- 브라우저가 결과를 받으면 그 요청과 관련된 request 내장객체는 사라짐
- page 영역과 다른점은 하나의 요청을 처리하는데 사용되는 모든 jsp 페이지를 포함



**session**-하나의 브라우저와 관련된 영역

- 페이지가 이동되더라도 사용자의 정보를 잃지 않게 하기위해 서버에 저장하는 영역

  

**application**-하나의 웹 어플리케이션과 관련된 영역

- 이 어플리케이션에 속한 모든 jsp페이지는 하나의 application 내장객체를 공유



page<request<session<application순이며 포함하는관계



**내장 객체의 메소드**

setAttribute(name ,value)-이름에 값설정

getAttribute(name)-이름에 해당하는 값을 얻음

getAttributeNames()-현재 객체에 관련된 모든 속성의 이름을 뽑아냄

removeAttribute(name)-매개변수의 이름에 설정된 값 제거



## 액션 태그

jsp를 이루고 있는 요소중 하나

액션태그는 XML 문법을 따름



종류

**< jsp:forward >** -다른사이트를 이동할때 혹은 페이지의 흐름을 제어할때 사용

서블릿상에서 다음의 코드와 동일한 동작을함

RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("url");

dispatcher.forward(request, response);

예제 파일 web-study-04- 08_red.jsp , 08_yellow.jsp



**< jsp: include >**- 정적 혹은 동적인 자원을 현재페이지의 내용에 포함시키거나 페이지를 모듈화 할때 사용

이전의 **<%@page include="file"%> 과의 차이점**: include 지시자는 지정된 페이지를 한페이지에 포함하는 기능을함-변수를 서로 공유해서 사용가능

< jsp:include> 액션태그는 컴파일할때 합쳐지지않고 제어권이 지정한 페이지로 넘어갔다가 다시 되돌아옴.-서로 독립적으로 컴파일-서로 연락을 취하여 하나의 페이지 처럼 동작-변수 서로 공유불가







**< jsp :param >** -forward, include, plugin 과 같이 사용되어 피라미터를 추가할때 사용

이동하는 페이지에 정보를 추가하고 싶을때 사용-단독으로 사용불가 include나 forward태그의 내부에 기술하여 사용



ex) < jsp:forward page="main.jsp">

​	<jsp:param name = "username" value="kimbyungjun" />

< /jsp:forward>



**< jsp : usebean >** -빈을 생성하고 사용하기 위한 환경을 정의하는 액션태그

**< jsp : setPorperty>** -액션은 빈에서 속성값을 할당

**< jsp : getProperty>** -액션은 빈에서 속성값을 얻어올때 사용

-앞에 띄어쓰기 되있는대 원랜 아니다



## 쿠키와 세션

### **쿠키**:

##### -하드디스크에 저장되는 작은양의 정보로 웹페이지 간 통신지원

쿠키 Cookie cookie=new Cookie("name","value"); 로 생성

쿠키는 response.addCookie(cookie)로 추가가능

또한 클라이언트에 있는 쿠키를 가져오려면

Cookie[] cookies=request.getcookies(); 메소드로 배열형태로 전부 가져올 수 있음



JSESSIONID=세션기술에서 웹브라우저로 세션ID를 보낼때 쿠키형태로 만들어서 전송- 이아이디가 세션정보를 저장한 쿠키의 이름



**메소드**

setComment(String), getComment()-쿠키에 대한 설명 설정 및 가져오기

setDomain(String), getDomain()-쿠키의 유효한 도메인설정 및 가져오기

setMaxAge(int), getMaxAge()- 쿠키의 유효한 기간 설정 및 기간을 알려줌-초단위로 설정  -만약 setMaxAge()를 0으로 설정할시 그 즉시 쿠키가 만료됨

setPath(String), getPath()-쿠키의 유효한 디렉토리 정보를 설정하거나 알려줌

setSecure(boolean), getSecure()-쿠키의 보안을 설정하거나 알려줌

setValue(String), getValue()-쿠키의 값을 설정하거나 알려줌

serVersion(int), getVersion()-쿠키의 버전을 설정하거나 알려줌

getName()-쿠키의 이름을 알려줌



### 세션

**세션**:여러사람이 사용하는 컴퓨터일경우 쿠키를 뒤지면 다른사람의 정보를 쉽게 알아내는것을 방지하고 여러가지 단점을 극복하기 위해 나온 상태 유지 방법중 하나

내장객체:session

서블릿에서는 HttpSession session=request.getSession(); 으로 세션을 얻어올수 있음



**메소드**

Object getAttribute(String name)-이름에 해당되는 객체값을 가져옴 -Object라서 cast 필요

Enumeration getAttributeNames()-세션에서 모든객체의 이름을 Enumeration 형으로 가져옴

- hasMoreElements()-Enumeration 객체의 메소드이며 다음에 뽑아올 데이터가 있는지 검사

- E nextElement()-다음 아이템이 존재한다는 전제하에 아이템을 하나씩 뽑아오는 역할





long getCreationTime() - 세션이 만들어진 시간 반환

String getId() - 해당세션을 가르키는 고유 id 값을 String 형으로 변환

long getLastAccessedTime() - 해당 세션이 클라이언트가 마지막으로 request를 보낸시간을 long 형으로 반환

int getMaxInactiveInterval() - 사용자가 다음 요청을 보낼 때 까지 세션을 유지하는 최대 시간(초단위) 반환-세션의 유효시간임 

setMaxInactiveInterval() - 유효시간설정-무한대로 설정을 원하면 -1을 설정

boolean isNew() - 해당 세션이 처음생성되었으면 true 값반환 이전이면 false

void remobeAttribute(String name) - 지정된 이름에 해당하는 객체를 세션에서 제거

setAttribute(String name, String value) - 세션에 지정된 이름에 객체추가

invalidate () -해당 세션제거



#### 자바 빈

**자바 빈**

- 정보의 덩어리로 데이터 저장소

- 회원가입시 이름,아이디,별명,비밀번호등을 개별로 보내지않고 한꺼번에 묶어서 보냄

- 물론 그냥 보내는것은 아니고 데이터 은닉도 같이함

- 데이터를 저장하기 위한 필드와 데이터를 컨트롤하는 getter/setter 메소드를 하나의 쌍으로 가지고 있는 클래스
- 자바빈 클래스는 다른 클래스와 차별화된 이름을 갖기도함 뒤에 Bean 이라던가 그리고 패키지도 따로씀

- 일반적으로 필드에 getter/setter만 있는 클래스들(DTO) 라고 생각하면 편할듯



**액션태그**

**< jsp:useBean>** -jsp와 자바빈을 연결 하기 위한 태그

**사용법**

< jsp:useBean class="클래스 풀네임-패키지포함"

​	                             id="빈이름"                   --빈이름이라는 변수에 할당

​	                             [scope="범위"]/>   

-범위는 생략가능 page, request, session,application 중하나 -생략시 해당페이지에서만 사용가능 다음페이지로 이동시 사용불가

-범위 추가시 만약 page 면 <% pageContext.setAttribute("빈이름",빈이름); 으로 추가됨

**역할**

ex)  MemberBean은 클래스 이름이다

< %@page import ="패키지.MemberBean">

<% MemberBean member=new MemberBean(); %>

혹은

<% 패키지.MemberBean member=new 패키지.MemberBean(); %> -page 지시자를 추가하지않고 서술 

**과 동일한 역할**



**< jsp:getProperty>**-빈에서 정보를 얻어오는 태그

< jsp:getProperty name="빈이름" property="필드" />

이것은 

<%= 빈이름.get필드()%> 와 같다 -그리고 이것은 이 상태로 쓴다.. 저장하는게 아니라 이것을 호출하는 순간 바로 그 자리에 표현이 되는셈



**< jsp:setProperty>**

< jsp:setProperty name="빈이름" property="필드" value="값">



위 세가지의 액션태그를 쓸때 빈이름은 반드시 매칭시켜야함-틀리면 오류 

보내는 쪽에서 Form을 작성한후 bean으로 가공하지 않았다고 해도 받는쪽에서 그것을 빈으로 인식하고 맞는 클래스를 맵핑해주기만 하면

getProperty로 쓸수잇다.

ex) web-study-06 03_addMember.jsp, 03_addMemberForm.jsp, kr.ac.jejunu.bj.javabeans.MemberBean.java



# EL(표현언어) 와 JSTL

JSP에서 표현식은 <%= %>로 썻지만 

표현언어는 ${ }으로 쓴다-더간단함

ex

${"HELLO"}

<%="HELLO"%>

<% out.println("HELLO"); %>

이 셋중 가장 간단하게 표현가능



표현언어는 정수형,실수형,문자열형,논리형, NULL 값을 집어넣을수 있음

또한 표현언어는 연산자를 넣을수 잇음

산술형:+ - * /(div) %(mod)

관계형:==(eq) !=(ne) <(lt) >(gt) <=(le) >=(ge)

조건: a ? b : c

논리: $$ (and) \\(or) !(not)

null검사: empty ex) ${empty 객체}



또한 <%= request.getParameter("id")%>는

${param.id}

혹은

${param["id"]}

라는 것으로 간단하게 바꿀수잇음. (param은 el의 내장객체)



${param.id=="byungjun"} 만치면 

<%=request.getParameter("id").equals("byungjun")%> 과 똑같은 기능을함



또한 el식에서는 파라미터를 찾지못하면 공백으로 처리하기때문에

기존식에서는 equals를 처리하면 null을 발생시켜 에러가 나타나지만 파라미터를 찾지못하면 공백으로 처리하기 때문에 예외가 발생하지않아 예외처리를 안해도됨



### 표현식과 el식에서의 차이점

<%=add%> 의 add->변수이름

${add} 의 add =>속성이름

ex) web-study-07- unit07-AdditionServlet.java , 07_addition.jsp'



**jsp 내장객체와 표현언어의 내장객체의 표기**

jsp 내장객체=표현언어의 내장객체

pageContext=pagescope

pageContext.getAttribute("num1") <=>${pageScope.num1}

 

request=requestScope

request.getAttribute("num1")<=>${requestScope.num1}



session=sessionScope

session.getAttribute("num1")<=> ${sessionScope.num1}



application=applicationScope

application.getAttribute("num1")<=> ${applicationScope.num1}



여기서 ${num1} 이라고 표기시 page부터 applicaiton 순으로 차례대로 num1이라는 속성을 가져와 출력

번외} 잘 사용할 일은 없겟지만 setParameter가 필요할때는 #{param.id처럼한다}



### JSTL

jsp는 스크립트릿과 자바코드등 여러가지 섞여서 복잡하게 되어있는데  ex) if-else 문에서 if문내부의 html 코드

쉽게 코딩을 하기위해 자신이 태그를 추가함-커스텀태그

작성한 커스텀 태그를 모아서 압축한후 이를 배포해서 사용-커스텀 태그 라이브러리

커스텀태그들을 개별적으로 만들어 쓰다보니 일관성이 없어서 이를 표준화한것 -JSTL



자바 웹 애플리케이션에서는 추가적인 라이브러리가 jar 파일형태로 제공-WEB_INF/lib 폴더 내에 복사해두고 사용

JSTL의 라이브러리는 http://jakarta.apache.org 사이트에서 다운받을수 있음

http://archive.apache.org/dist/jakarta/taglibs/standard/binaries/

jstl.jar              -JSTL API 클래스

standard.jar   -Standard Taglib JSTL 구현 클래스

JSTL을 사용하기 위해서는 위 2가지의 라이브러리가 필요



또한 jsp 상단에

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> jstl 기본기능인 core를 사용하기위한 taglib 지시자를 붙여줘야함



기본기능

prefix-기능-기본url

c-core-http://java.sun.com/jsp/jstl/core

fn-함수처리--http://java.sun.com/jsp/jstl/fn

fmt-형식화--http://java.sun.com/jstl/fmt

sql-데이터베이스작업--http://java.sun.com/jstl/sql

x-xml처리--http://java.sun.com/jstl/xml



원하는 기능을 taglib uri=와 prefix를 지정해주면

<c:out value="Hello world"/>처럼 사용이 가능함 c:out은 표현식인 <%= >를 대체할수있음



### JSTL core tag

< c:set> 변수에 값설정

< c:remove> 변수에 설정된 값 제거

< c:if> 조건처리 사용

< c:choose> 여러 조건에 따라 처리를 달리 할때 사용-switch인가?

< c:forEach> 반복처리를 할때 사용

< c:forTokens>- 구분자로 분리된 각각의 토큰을 처리할때 사용

< c:import> -외부의 자원을 url을 지정하여 가져다 사용함

< c:redirect> 지정한 경로로 이동

< c:url> url을 재작성

< c:out> 데이터를 출력할때 사용

< c:catch> 예외처리시 사용



**c:set**

pageContext.setAttribute("msg", "Hello"); 를

< c:set var="msg" value="Hello" scope="page" /> 

치환가능 var는 변수이름 value는 값 scope는 범위

또한 < c:set var="msg" scope="session">hello < /c:set>으로 값을 저장할 수도있음

또한 scope는 생략가능-자동 page scope



배열을 만들고자할때는

<c:set var="movieList" scope="page">타이타닉, 시네마천국, 혹성탈출, 킹콩< /c:set>

 해주면 간단 scope 생략가능



또한 java bean에서 

< jsp:setProperty>를 대신하여 쓸수 있음 -web-study-06

< jsp:setProperty name="member" property="name" value="김병준" />을

<c:set target="${member}" property="name" value="김병준" /> 으로 활용 할 수있다

또한 setProperty 를하기위해선 useBean을 먼저 선언해야 하듯이



< jsp:useBean id="member" class="kr.ac.jejunu.bj.javaBeans.MemberBean()"/>

을

< c:set var="member" value="<%=new kr.ac.jejunu.bj.javaBeans.MemberBean()%>">

로 할수있음-궁금한점

< c:set var="member" value=<c:out="new kr.ac.jejunu.bj.javaBeans.MemberBean()">> 하면 안되나?

안됨 하지마셈 el식도 마찬가지.. 표현식으로만 쓰자



ex)web-study-07 11_jstlCore.jsp



**c:remove**

<c:remove var="msg" scope="page"> scope는 생략가능



**c:if**

if는 조건식이지만 if-else 구문이아닌 if 밖에 없다 그러므로 여러개의 if 를 써서 그 조건조건마다 명령을 지정해야함



ex)web-study-07 12_colorSelect.jsp



**c:choose**

자바의 if-else와 비슷함 내부 태그로 c:when 과 c:otherwise가 있음 각각 if와 else로 생각하면 될듯

ex)web-study-07 13_fruitSelect.jsp



**c:forEach**

<c:set var="movieList" scope="page">타이타닉, 시네마천국, 혹성탈출, 킹콩</c:set>
<c:forEach var="movie" items="${movieList}">
${movie}<br>
</c:forEach>

처럼 하면된다 또한 forEach에서 사용하는 프로퍼티는 **index, Count, first,last** 가 있다 

**index**는 item중 지정한 집합체의 현재 반복중인 항목의 index를 알려주고

**count**는 현재가 몇번째 루프인지 알려준다

**first**는 현재 루프가 처음인지알려주고

**last**는 현재 루프가 마지막인지 여부를 알려줌 boolean 리턴



이 것들은 varStatus라는 속성으로 알수있다

varStatus.index

varStatus.count

<c:forEach var="movie" items="${movieList}" varStatus="status">

${staus.index}

${status.count} < br>

< /c:forEach>



또한 begin과 end를 통해 forEach 문을 조절할수도 있다-for문처럼

<c:forEach var="cnt" begin="1" end="10" step="1">

${cnt}

< /c:forEach>

cnt는 변수이고 step만큼 올라감 

step의 기본은 1이고 생략가능함



**c:forTokens**

문자열을 구분자로 분리해서 하나씩 추출가능

< c:forTokens var="토큰을저장할변수" items="토큰으로 나눌 문자열" delims="구분자">

몸체

< /c:forTokens>



ex) <c:forTokens var="city" items="서울,인천.대구,부산" delims=",.">

${city} < br>

< /c:forTokens>

=>서울

인천

대구

부산

delims 가 문자에서 사라지고 나눠짐 여러개를 적어도 각기 개별로 하나로 인식함



**c:import**

다른페이지 내용포함

< c:import url="URL" [var="변수이름"] [scope="영역"] [charEncoding="charEncoding"]>

< /c:import>

이전의 jsp 액션태그와 다른점은 다른페이지의 내용을 변수에 저장가능

ex)

<c:import url="http://localhost:8181/web-study-07/03_el.jsp" var="data"></c:import>

${data}



**c:url**

여러번 반복하여 사용할 주소가 있다면 변수에 저장하기 위해서 사용

< c:url value="url" [var="변수이름"] [scope="영역"]></c:url>



**c:redirect**

response.sendRedirect()메소드와 동일한긴으

<c:redirect url="url" [context="경로명"]/>

ex) <c:redirect url="20_jstlURl.jsp"> < /c:redirect>



**c:out**

출력을 위한태그

<c:out value="value" [dafault="기본값"]>



**c:catch**

<c:catch var="변수이름">

예외가발생할수있는 코드

</c:catch>

예외가 발생하면 그 catch 내부의 코드는 종료되고 에러코드의 로그가 변수이름에 담기게된다





#### JSTL fmt

국제화 지역화 태그-jsp 페이지에서 다양한 언어를 지원받을수 있도록 할 수 있음



태그종류

**formatNumber**- 숫자를 양식에 맞춰서 출력

**formatDate**-날짜 정보를 담고있는 객체를 포맷팅하여 출력할 때 사용

**parseDate**-문자열을 날짜로 파싱

**parseNum**-문자열을 수치로 파싱

**setTimeZone**-시간대별로 시간을 처리할수 있는 기능제공

**timeZone**-마찬가지로



**setLocale**-국제화 태그들이 사용할 로케일지정

**requestEncoding**-요청 피라미터의 인코딩지정



**bundle**-태그몸체에 사용할 리소스 번들을 지정

**message{param}**-메세지 출력

**setbundle**-특정 리소스 번들을 사용할수있도록 설정



[]는 생략가능하다는뜻

**formatNumber**

<fmt:formatNumber value="수치데이터" [type="number|currency|percent"] -숫자통화퍼센트

[pattern="패턴"]-사용자가 지정한 형식패턴

[currencySymol="화폐단위"] 위에 타입이 통화일때만 가능

[groupingUsed="true|false"] -콤마와 같이 단위를 구분할때 사용하는 기호를 표시할지 여부

[var="변수이름"]-출력값을 담는 변수이름

[scope="알잖아"]



**formatDate**

<fmt:formatDate value="date" [type="time|date|both"]

[dateStyle="defalut|short|medium|long|full"]

[timeStyle="defalut|short|medium|long|full"]

[pattern="customPattern"]

[timezone="timezone"]

[var="varName"]

[scope="알지?"]







## JDBC   -8장

### oracle 기본

기본적으로 express Edition 18c 로 진행 18.4.0.0.0

기본 사용자 계정

**sys** -oracle super 사용자 계정 모든 문제 들을 처리할수 있는 권한 가짐

**system**-오라클 데이터베이스를 유지보수 관리할때 사용할수있는 계정-데이터베이스 생성권한 없음

**HR**-처음 오라클을 사용하는 사용자의 실습을 위해 만들어 놓은 교육용 계정



오라클 12c 부터는

공통사용자를 만들때는 공통사용자 이름앞에 c##을 붙여야함

create user c##renoris identified by 비밀번호; -이렇게

물론 권한 부여시에도 c##은 붙여야함

시스템 권한으로 유저를 만든뒤 해야할것들

grant connect, resource to scott; - connect 데이터 베이스 접속을위한 권한, resource- 테이블 생성이 가능하도록하는 권한

grant create view to scott;

alter user c##scott default tablespace users quota unlimited on users; -이거 안하면 insert 못넣는듯



create table member(

name varchar2(10),

userid varchar2(10),

pwd varchar2(10),

email varchar2(20),

phone char(13),

admin number(1) default 0,

primary key(userid)

);

이며 varchar2는 가변형 글자로 글자의 크기 변동이 클때 사용함



또한 지금 현재 접속한 계정에서 다른 계정으로 접속하려면 conn 명령어사용 -conn 계정/비밀번호 

ex) c##scott/tiger



또한 오라클에서는 insert 명령문으로 데이터를 넣고 commit; 을 하지않으면 저장안됨



### jdbc

jdbc 를 사용하려면 java.sql.* 를 import 해야 사용가능

인터페이스 종류

-Connection-데이터베이스 연결과 관련된 인터페이스-DriverManager.getConnection()으로 얻음

-Statement- 질의 갱신 실행 -connection.createStatement()로 얻음

-ResultSet-결과물 -statement.executeQuery()로 얻음



jdbc 를 사용하려면 jdbc 드라이버를 java 환경에 설치해야함 -데이터베이스 업체에서 제공-오라클이 설치된 디렉토리 찾아가면됨

dbhomeXE/jdbc/lib



또한 라이브러리가 설치되었으면 jdbc를 쓰기위해서 드라이버를 로딩해야하는데 처음 객체들을 만들어 주기전

Class.forName("oracle.jdbc.driver.OracleDriver") -쳐주면 드라이버가 로딩이 됨

이유는 Class 클래스의 정적메소드인 forName()은 패키지명을 기술한후 클래스이름을 문자열 형태로 지정해주면 이를 자바 가상기계에 안으로 읽어옴

 

#### Connection

Connection 객체는 DriverManager.getConnection(url,uid,pwd); 순으로 얻을수있음

url은 jdbc:oracle:thin:hostname:port:dbname 순으로함

ex) "jdbc:oracle:thin:@localhost:1521:XE"

포트번호는 dbhomeXE/network/admin/lisner.ora 를 열어보면 포트번호가 있음

XE는 오라클 익스프레션 버전을 다운받앗다면 XE임-이것또한 열어보면 XE인지 다른버전인지 나옴

ex-DEFAULT_SERVICE_LISTENER =XE 

또한 데이터 베이스 사용이 끝낫다면 conn.close 해줘야함-(conn은 Connection의 객체)

ex) Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");



#### Statement

conn.createStatement(); 로 얻을수있음(conn은 Connection의 객체)

또한 마찬가지로 사용이 끝나면 stat.close(); 해줘야함



**statement의 메소드**

executeQuery-select 문과 같이 결과값이 여러개의 레코드로 구해지는 경우에 사용

executeUpdate-insert,update,delete문과 같은 내부적으로 테이블의 내용이 변경만 되고 결과 값이 없는 경우에 사용



ex) String sql=" select * from member";

ResultSet rs= stmt.executeQuery(sql);



##### ResultSet

ResultSet 객체는 select 문의 결과값을 저장하고있음-여러개의 로우로 구성되어 있음



ResultSet이 제공하는 메소드

-next()-한행 앞으로이동

-previouse()-한행뒤로이동

-first()-첫번째 행의 위치로 이동

-last()-마지막으로 이동

-성공적으로 진행될시 true 리턴,실패시 false 리턴



또한 ResultSet의 객체에서 값을 얻기 위해서는 다양한 get을 써야함 -getInt("컬럼이름") getString("컬럼이름")등

혹은 인덱스 값을 알고있다고 한다면은 인덱스 값을 입력해도됨

ex) 이름 유저아이디 패스워드 이메일 폰 관리자여부 라면

이름이 1 유저아이디가 2 가되는셈

getString(1) 이렇게



##### PreparedStatement

데이터베이스에 저장하기 위해서는 PreparedStatement 인터페이스를 이용함-Statement의 단점을 극복한 서브인터페이스



preparedStatement()의 메소드 인자로 sql문을 삽입하지만 Statement의 정해진 sql이 아닌 바인드 변수를 이용한 sql문을 삽입함

ex-String sql="insert into member values(?, ?, ?, ?, ?, ?)";

PreparedStatement pstmt = con.preparedStatement(sql);

?는 바인드 변수라고하며 매번 값이 바뀔수 있으므로 미리 정해놓지 않은것



그리고 이 바인드 변수에 setString이나 setInt 같은것들을 통해 값을 삽입

그리고 값 삽입이 끝나면

pstmt.executeUpdate();

pstmt.close();

를 통해 업데이트하고 종료해줌



### 데이터베이스 커넥션 풀-DBCP-9장

##### DBCP란?

dbcp는 접속인원이 많은 웹페이지에서 데이터베이스의 효율성과 속도를 높이기 위해서 사용

많은 클라이언트가 항상 데이터베이스에 접근권한을 얻고 사용하고 종료하는 현상을 반복하면 서버에 부하가 발생하기 때문에

일정갯수의 DBCP매니저를 준비해주고 항상 데이터베이스와 연결상태로 있다가 클라이언트가 연결해주고 클라이언트의 요청이 끝나면

다시 DBCP가 반납받는 형태의 구성



**DBCP 설치**

dbcp의 커넥션풀은 컨텍스트 패스의 서브태그로 추가함

-server.xml에서 해당하는 프로젝트의 컨텍스트를 찾고 < Context />를 < Context> < /Context>로 바꿔주고  

-아파치 홈페이지에가서 자신이 사용하는 톰캣 서버에 맞는 jdbc dataSoureces에서 오라클 부분의 코드를 가져와 안에 붙여넣기

-그리고 URL 마지막에 오라클 서버의 이름을 맞게 바꿔주기 -실습의경우는 익스프레션에디션이기때문에 XE -그리고 유저네임이랑 패스워드까지 맞춰주자

ex) <Resource name="jdbc/myoracle" auth="Container"
	              type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
	              url="jdbc:oracle:thin:@127.0.0.1:1521:XE"
	              username="c##scott" password="tiger" maxActive="20" maxIdle="10"
	              maxWait="-1"/>



**JDBC 구현**

**jsp 코드**

<%
	Context initContext =new InitialContext();
	Context envContext= (Context)initContext.lookup("java:/comp/env");
	DataSource ds=(DataSource)envContext.lookup("jdbc/myoracle");
	Connection conn=ds.getConnection();
	out.print("jdbc 연동성공");
%>

시작 컨텍스트를 새롭게 만든뒤

중간 컨텍스트를 시작컨텍스트로 룩업한뒤 캐스팅해서 만들고

마지막 데이터소스를 중간컨텍스트에서 룩업해서 캐스팅해서 만듬. 이때 데이터소스를 룩업할때 들어가는 저것은 

server.xml의 Resource 태그의 name 속성이랑 똑같이 맞춰준다

또한 DataSourece 를 쓰는 이유는 server.xml에 type속성이 javax.sql.DataSourece이기 때문에 마찬가지로 똑같이 만들어준다



### **DAO 와 VO**

**DAO**-데이터베이스에 저장된 데이터를 조회하는것을 담당하는 클래스 

**VO**-테이블의 정보를 자바에서 얻어오기전에 회원정보를 저장할 공간을 위한 준비과정-**자바 빈과 동의어**





#### 싱글톤 패턴이란?

인스턴스가 오로지 단하나만 존재할수 있도록 클래스를 설계하는것

-객체를 단 하나만 메모리에 올려놓고 시스템 전반에 걸쳐 특정한 자원을 공유할 때사용



DAO는 여러번 생성하면 성능이 떨어지기 때문에 단 하나의 객체로 하는것이 좋음



**싱글톤 패턴의 조건**

1. 생성자가 private 여야함-다른클래스에서 절대 인스턴스를 생성하지 못하고 자기 자신만 인스턴스를 생성 할 수 있음-자기자신을 static 하게 생성하게 생성하고-getInstance 라는 static한 메소드를 만들어서 그 인스턴스를 받아가게함
2. 또한 외부에서 수정은 못하고 값만 얻을 수 있도록 setter 는 정의하지않고 getter만 만듬



이렇게 만들어진 싱글톤 패턴의 DAO에서 **DBCP**를 생성하는 메소드 또한 추가를 시킨다.

ex) web-study-09-com.jejunu.dto.MemberDAO.java



**DAO에 들어갈 메소드들(일반적으로 이거보다 더많이 들어갈 수 있다)**

int userCheck(String userid, String pwd)-이 유저가 있는지 없는지 확인하는 메소드-사용자인증용 메소드

MemberVO getMember(String userid)-member테이블에서 아이디로 해당회원을 찾아 회원정보를 가져옴

int confirmID(String userid)-회원가입시 아이디 중복을 확인할때 사용-해당 아이디가 있으면 1 없으면 -1을 리턴

void insertMember(MemberVO mVo)-매개변수로 받은 VO 객체를 member 테이블에 삽입 - 회원가입 전용인듯

void updateMember(MemberVO mVo)-매개변수로 받은 VO객체를 검색한뒤 회원정보를 수정



**짤막한tip**

jsp 끼리 페이지를 요청할때 jsp파일이름이나 서블릿 클래스이름으로 요청을 하지않고 xxx.do 같은 형식으로 작성함

또한 컨텍스트 페스까지만 입력하면 자동으로 index.jsp를 호출하게 되므로 index.jsp 파일을 만들어서 우리가 만든 대문으로 가는 형식을 삽입하기바람



이 내용의 모든것은 web-study-09 에 다있음



**DAO의 방법들**

기본적으로 

Connection

PrepareStatement

ResultSet

이 셋으로 모든걸 할 수있음

먼저 DBCP를 통해 커넥션을 얻어오는걸 메소드로 만든 뒤에

public Connection getConnection() throws Exception{
		Connection conn=null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds =(DataSource) envContext.lookup("jdbc/myoracle");
		conn= ds.getConnection();
		return conn;
	}

커넥션을 얻어오고 		conn=getConnection();

미리 만들어놧던 sql문으로 preparestatement를 만들고-pstmt= conn.prepareStatement(sql);

sql문의 ? 에 삽입하고 -pstmt.setString(1, userid);

쿼리실행한뒤 결과를 받아옴 rs= pstmt.executeQuery();

검색문의 경우 ResultSet을 통해 받아와서 차래로 필드에 맞는 값을꺼내오고

수정문이나 삽입문의 경우 정수형태를 받아와서 정수형태의 따른 결과값만을 안내하는 경우가 있음

그리고 마지막으로 메소드가 끝났을때 모든게 다 null로 선언만하고 try문 안에서 할당을 했을태니

finally로 선언의 역순으로 close 해준다



## COS 라이브러리

파일을 업로드할때 가장 많이 쓰이는 라이브러리라 함.... 현재도 그럴지는

http://www.servlets.com/cos/



또한 html에서 파일을 전송하기 위해선 form 태그의 enctype 속성을 multipart/form-data 로 수정해주어야하고 post형식이어야함



cos.jar에는 다양한 클래스가 있지만 대표적으로 사용되는게 MultipartRequest임

이 생성자가 요구하는 매개변수는 (javax.servlet.http.HTTpServletRequest request, java.lang.String saveDirectory, int MaxPostSize, java.langString encoding, FileRenamePolicy policy )

request는 리퀘스트 객체를 그대로 주면되고

saveDirectory는 서버측에 저장될경로

-String savePath="upload"-여기를 바꿔주면 다운받는경로가 바뀐다

-ServletContext context=getServletContext()

-String uploadFilePath=context.getRealPath(savePath);  를 통해 업로드 패스를 얻어낸다

MaxPostSize는 최대 파일크기 -1이면 1바이트 5 *1024 *1024 면 5메가바이트

encoding은 파일의 인코딩 방식-파일이름이 한글일경우 utf-8

policy는 파일 중복처리를 위한 매개변수인데 일반적으로 우리는 중복처리가 가능하게 cos.jar내부에 multipart 폴더내부에있는 DefaultFileRenamePolicy를 쓴다 즉 new DefaultFileRenamePolicy()를 던져주면됨



**MultipartRequest 클래스의 유용한 메소드들**

getParameterNames() 폼에서 전송된 파라미터 이름을 Enumeration 타입으로 리턴

getParameterValues()-폼에서 전송된 파라미터들을 배열로 받아옴

getParameter()-객체에 있는 해당 파라미터의 값을 가져옴

getFileNames()-파일을 여러개 업로드 할 경우 그값들을 Enumeration 타입으로 리턴

getFilesystemName()-서버에 실제로 업로드 된 파일의 이름을 의미

getOriginalFileName()-클라이언트가 업로드한 파일의 원본이름을 의미

getContentType()-업로드 파일의 컨텐트 타입을 얻을때 사용

getFile()-서버에 업로드된 파일의 정보를 객체로 얻어낼 때 사용



**파일 업로드 위치**

워크스페이스\ .metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\프로젝트\upload위치에서 확인가능





## MVC 패턴 

Model-View-Controller 요소로 구성되는 웹페이지



모델-데이터베이스와 연동하는 비즈니스 로직을 통해 얻어온 데이터를 저장하는 용도로 사용-VO, DAO-컨트롤러로 부터 요청을 받아 비즈니스로직을 수행한뒤 결과를 컨트롤러를 거쳐 뷰에 전달, 주로 Action 인터페이스를 받아와서 사용

뷰-사용자와의 인터페이스, 주로 JSP 페이지를 사용

컨트롤-모델과 뷰사이의 흐름을 제어하는 역할 - 주로 서블릿 사용



이전과의 차이점

boardList.do 라는 요청을 하면 BoardListServlet이 받아서 처리함

boardWrite.do 라는 요청을 하면 BoardWriteServlet이 받아서 처리함

-요청에 대한 처리를 각각의 서블릿이 받아서 처리하고 있었음



MVC 패턴에서는 컨트롤러를 하나 두어 모든 요청을 이 컨트롤러가 받도록함 그리고 요청이 들어오면 그에 합당한 비즈니스 로직을 담은 모델을 찾아옴



**command 패턴**

요청에 커맨드-라는 피라미터를 넣어서 원하는 요구, 기능을 넣어서 전달하면 각 명령어에 따른 로직을 처리하는 코드를 별도의 클래스로 작성하는것을 커맨드 

패턴이라고함



구성

jsp에서 서블릿에 커맨드가 들어간 요청전달

-서블릿은 액션팩토리에 커맨드를 넘겨줌

-액션팩토리는 커맨드를 받아서 어떤 액션(무슨 행동인지)인지 분별한다음 다시 서블릿으로 전달

-서블릿은 다시 액션을 받아서 널값이 아니면 그 액션을 실행-당연히 매개변수로 request와 response를 주고 액션은 그매개변수를 받아서 갖가지 동작을 실행



그리고 액션 자체들은 다 거기서 어디로 이동될지 forward인지 무엇인지 다 설정되어있고 서블릿은 그것을 실행하기만함

그리고 그 액션들은 Action 인터페이스를 구현한것

