// 정규식과 비동기를 이용해서 검증 거치고, 회원가입 진행

/* ------------ form 관련 요소들 -----------------*/
const f = document.forms[0];


/* ------------ 함수 -----------------*/
document.querySelectorAll("button").forEach(btn => {
	btn.addEventListener('click', ()=>{
		
		let type = btn.id;
    
    if(type ==='loginBtn'){
      login();
    }else if(type === 'mainBtn'){
      location.href = 'MemberController?cmd=mainPage'
    }

// 로그인
function login(){
  // 1. 아이디 및 비밀번호 빈 값 검증
  if(!f.mId.value || !f.mPw.value){
    alert("정보를 입력하십시오");
    return;
  }
  // 2. mId, mPw, cmd 데이터 json으로 변환 후 전송
  let formData = new FormData(f);
	let jsonData = JSON.stringify(Object.fromEntries(formData.entries()));

  fetch('MemberAsyncController', {
		method : 'POST',
		body : jsonData,
		headers : {
			'Content-type' : 'application/json; charset=UTF-8'
		}
	})
	.then(response => response.json())
	.then(data => {
    
	})
		.catch(err => console.log(err));
  // * mservice.doLogin 메소드 사용
  // 3. SELECT * FROM MEMBER_T WHERE MID = #{mId} and MPW = #{mPw}
  // 4. 정보가 있으면
  //    1) 쿼리 실행 결과를 세션에 저장 * 속성 이름 = "member"
  //    2) obj.put("result", "sucess");
  // 5. 로그
  //    1) obj.put("result", "fail");
}
		
	});
});
