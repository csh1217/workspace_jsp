// 게시글 삽입 페이지 이동 함수
function moveInsertPage(){
    location.href='BBSController?cmd=insertBBSPage';
}
// 목록으로 이동하는 함수
function view_all(pageNum){
    if(!pageNum){
        pageNum = 1;
    }
    location.href='BBSController?cmd=allList&pageNum='+ pageNum + '&amount=5';
}
// 게시글 저장 함수
function insert(f){
    
    if(!f.writer.value){
        alert("작성자를 입력하시오.");
        return;
    }
    if(!f.title.value){
        alert("제목을 입력하시오.");
        return;
    }
    if(!f.content.value){
        alert("내용을 입력하시오.");
        return;
    }
    f.action = 'BBSController';
    f.submit();
}

// 게시글 수정 페이지 이동 함수
function updatePage(pageNum){
    location.href = 'BBSController?cmd=updatePage&pageNum=' + pageNum;
}
// 게시글 수정 함수
function update(f){  
    if(!f.title.value||!f.content.value){
        alert('제목과 내용을 모두 입력하세요');
    }

    f.action = 'BBSController';
    f.submit();

}

//게시글 삭제 함수
function removeBBS(b_idx, pageNum){
    if(confirm('해당 게시글을 삭제하시겠습니까?')){
        location.href = 'BBSController?cmd=remove&b_idx='
                        + b_idx
                        + '&pageNum='
                        + pageNum;
        // 전달 파라미터 b_idx, cmd = remove
        // 서비스의 메소드 이름 removeBBS
        // 매퍼 ID delete_bbs
        // 삭제 완료 후 allList.jsp로 이동
    }else{
        return;
    }
}

// 페이지 버튼 클릭 이벤트
document.querySelectorAll('.page-nation li a')
        .forEach( aEle =>{
            aEle.addEventListener('click',(e)=>{
                e.preventDefault(); // 페이지 이동 방지

                let pageNum = e.currentTarget.getAttribute('href');
                let sendData = 'cmd=allList&pageNum=' + pageNum + '&amount=5';
                location.href = 'BBSController?' + sendData;
                

            })
        })
    