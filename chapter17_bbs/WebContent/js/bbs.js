// 게시글 삽입 페이지 이동 함수
function moveInsertPage(){
    location.href='BBSController?cmd=insertBBSPage';
}
// 목록으로 이동하는 함수
function view_all(){
    location.href='BBSController?cmd=allList';
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
function updatePage(){

}

//게시글 삭제 함수
function removeBBS(b_idx){
    if(confirm('해당 게시글을 삭제하시겠습니까?')){
        location.href = 'BBSController?cmd=remove&b_idx=' + b_idx;
        // 전달 파라미터 b_idx, cmd = remove
        // 서비스의 메소드 이름 removeBBS
        // 매퍼 ID delete_bbs
        // 삭제 완료 후 allList.jsp로 이동
    }else{
        return;
    }
}
    