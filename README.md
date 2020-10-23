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



# jsp & Servlet 공부

### servlet이란?

**server+Applet의 합성어**

javax.servlet.http 패키지에서 제공하는 httpServlet 클래스를 상속받아 구현해야함
이러한 상속받아 만든 서브 클래스를 **서블릿 클래스**라고함



servlet 클래스에는

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



