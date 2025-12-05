function insert_comment(f){
    if(!f.writer.value){
        alert("작성자를 입력하시오");
        return;
    }
    if(!f.pw.value){
        alert("비밀 번호를 입력하시오");
        return;
    }
    if(!f.content.value){
        alert("내용을 입력하시오");
        return;
    }
    let formData = new FormData(f);

    // 직렬화
    let serializedData = new URLSearchParams(formData).toString();

    // //json
    // let jsonData = JSON.stringify(Object.fromEntries(formData.entries()));
    
    fetch('CommentController?'+serializedData)
        .then(response=>response.json())
        .then(data=>{
            console.log(data);
        })
        .catch(err=>console.log(err));
    
}