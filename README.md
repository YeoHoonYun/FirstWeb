# JspExam
## 2019-01-09
### 쿠키 / 세션 | Forward / Redirect
Link: [CookieSession][Cookie]
[참조링크]: https://jeong-pro.tistory.com/80 "CookieSession"
1. 쿠키 / 세션
  * HTTP 프로토콜의 특징
    - 비연결지향(Connectionless) : HTTP는 먼저 클라이언트가 request를 서버에 보내면, 서버는 클라이언트에게 요청에 맞는 response를 보내고 접속을 끊는다.
    - 상태정보유지안함(Stateless) : 연결을 끊는 순간 클라이언트와 서버의 통신이 끝나며 상태정보는 유지하지 않는 특성이 있다.
  * 쿠키(Cookie) : 클라이언트 로컬에 저장되는 키와 값이 들어있는 작은 데이터 파일
      1) 이름, 값, 만료날짜, 경로 정보가 들어있다.
      2) 일정시간동안 데이터를 저장할 수 있다.
      3) 클라이언트의 상태 정보를 로컬에 저장했다가 참조한다.
      
      - 쿠키 프로세스
        1) 브라우저에서 웹페이지 접속
        2) 클라이언트가 요청한 웹페이지를 받으면서 쿠리를 클라이언트 로컬에 저장
        3) 클라이언트가 재 요청시 웹페이지 요청과 함께 쿠키값도 전송
        4) 지속적으로 로그인 정보를 가지고 있는 것처럼 사용
        
  * 세션(Session) : 일정 시간동안 같은 브라우저로부터 들어오는 일련의 요구를 하나의 상태로 보고 그 상태를 유지하는 기술
      1) 웹 서버에 접속한 이후로 브라우저를 종료할 때까지 유지되는 상태
      2) 세션 ID : 클라이언트가 Request를 보내면, 해당 서버의 엔진이 클라이언트에게 유일한 ID를 부여
      
      - 세션프로세스
        1) 클라이언트가 서버에 접속시 세션ID를 발급
        2) 서버에서는 클라이언트로 발급해준 세션 ID를 쿠키를 사용해 저장
        3) 클라이언트는 다시 접속할 때, 이 쿠키를 이용해서 세션ID값을 서버에 전달
        
   * 쿠키와 세션의 차이
      1) 저장위치 : 쿠키는 클라이언트에 파일로 저장, 세션은 서버에 저장
      2) 보안 : 쿠키는 클라이언트 로컬에 저장되기 때문에 변질되거나 request에서 스나이핑 당할 우려가 있어서 취약하지만,
                세션은 쿠키를 이용해서 sessionid만 저장하고 그것을 구분해서 서버에서 처리하기 때문에 비교적 보안성이 좋다.
      3) 라이프 사이클 : 쿠키도 만료시간이 있지만 파일로 저장되기 때문에 브라우저를 종료해도 계속해서 정보가 남아있을 수 잇다.
                        반면 세션은 만료시간을 정할 수 있지만, 브라우저가 종료되면 만료시간에 상관없이 삭제된다.
      4) 속도 : 쿠키에 정보가 있기 때문에 서버에 요청시 속도가 빠르고 세션은 정보가 서버에 있기 때문에 처리가 요구되어 비교적 느리다.
      
2. Forward / Redirect

Link: [RedirectForward][Redirect]
[참조링크]: https://www.baeldung.com/servlet-redirect-forward "RedirectForward"

![Forward](https://nesoy.github.io/assets/posts/20180409/1.png "Forward")
  * Forward
  ```
  //http://localhost:8081/hello?name=Dennis
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    RequestDispatcher dispatcher = getServletContext()
      .getRequestDispatcher("/forwarded");
    dispatcher.forward(req, resp);
}
  ```
    - Request스코프에 담긴값이 유지된다.
    - 이동된 url이 화면에 안보인다.
    - 포워드 방법
      1) pageContext.forward("이동할 페이지")
      2) <jsp:forward page="이동할페이지"/>;
      3) RequestDispatcher rd = request.getRequestDispatcher("이동할 페이지"); rd.forward(reqeust, response);
  
![Redirect](https://nesoy.github.io/assets/posts/20180409/2.png "Redirect")
  * Redirect
  ```
  //http://localhost:8081/welcome?name=Dennis
  protected void doGet(HttpServletRequest req, HttpServletResponse resp){
    resp.sendRedirect(req.getContextPath() + "/redirected");
}
  ```
    - 클라이언트가 새로 페이지를 요청한 것과 같은 방식으로 페이지가 이동됨. reqeust, response가 유지되지 않는다.(새로 만들어짐.)
    - 이동된 url이 화면에 보인다.
    - 리다이렉트하는 방법
       = response.sendRedirect("이동할 페이지")
  
  * 차이점
  
    두 경우 모두 값과 함께 매개 변수 " name "을 전달했습니다 . 간단히 말해 전달 된 요청은 여전히이 값을 전달하지만 리디렉션 된 요청은 전달하지 않습니다.
    이는 리디렉션을 통해 요청 객체가 원래 객체와 다르기 때문입니다. 이 매개 변수를 계속 사용하려면 HttpSession 개체 에 저장해야 합니다.
    서블릿 포워드와 리다이렉트의 주요한 차이점은 다음과 같다.

    - Forward :

    요청은 서버 측에서 추가로 처리됩니다.
    클라이언트는 전달에 영향을받지 않지만 브라우저의 URL은 그대로 유지됩니다.
    요청 및 응답 객체는 전달 후 동일한 객체로 유지됩니다. 요청 범위 개체는 계속 사용할 수 있습니다.
    
    - Redirect :

    요청이 다른 리소스로 리디렉션됩니다.
    클라이언트는 리디렉션 후 URL 변경 사항을 확인합니다.
    새로운 요청이 생성됩니다.
    리디렉션은 일반적으로 Post / Redirect / Get 웹 개발 패턴에서 사용됩니다.
  
  * 결론
  
  포워딩과 리다이렉트는 사용자가 서로 다른 자원으로 보내지는 것과 의미가 다르다.
  이들 사이의 선택은 간단합니다. 이전 범위가 필요하거나 사용자에게 알릴 필요가 없지만 응용 프로그램이 내부 조치를 수행하려는 경우 전달을 사용하십시오 .
  범위를 삭제하거나 새 콘텐츠가 원래 요청과 연결되어 있지 않은 경우 (예 : 로그인 페이지로 리디렉션하거나 양식 제출을 완료 한 경우) 리디렉션을 사용하십시오 .
  언제나 그렇듯이 예제 코드는 GitHub 에서 찾을 수 있습니다 .
  
  * Forward와 Redirect
  Link: [참조링크]: http://installed.tistory.com/entry/8-JSP-%ED%8A%B9%EC%A0%95%ED%8E%98%EC%9D%B4%EC%A7%80%EB%A1%9C-%EC%9D%B4%EB%8F%99%EB%B0%A9%EB%B2%95 "FoRe"
    - Forward
      Forward 방식으로 전달하면 값은 전달되고, 주소는 result.jsp로 변결되지 않는다.
    - Redirect
      redirect방식으로 넘기면 값을 null이되고, 주소는 바뀌어 있다. request를 유지하지 않기 때문에 다른페이지로 이동하면 없어진다.
