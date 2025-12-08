function insert_comment(f){
    if(!f.writer.value){ // 검증
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
            showCommList();
        })
        .catch(err=>console.log(err));
}

function showCommList(){
	let b_idx = 
		new URLSearchParams(location.search).get("b_idx");
	
	let sendData = `cmd=commList&b_idx=${b_idx}`;
	let msg = ``;
	fetch('CommentController?' + sendData)
		.then(response => response.json())
		.then(data => {
			let cList = JSON.parse( data.cList );
			
			cList.forEach( cvo => {
				msg += `<tr>`;
				msg += `<td>${cvo.c_idx}</td>`;
				msg += `<td>${cvo.writer}</td>`;
				msg += `<td>${cvo.content}</td>`;
				msg += `<td>${cvo.reg_date}</td>`;
				msg += `<td><button type="button" onclick="removeComm(${cvo.c_idx})">삭제</button></td>`;
				msg += `</tr>`;
			});
			
			if(msg == ''){
				msg += `<tr>`;
				msg += `<td colspan="5">댓글이 없습니다.</td>`;
				msg += `</tr>`;
			}
			
			document.querySelector("#commBody").innerHTML = msg;
			
		})
		.catch(err => console.log(err));
	
}
showCommList();

// unixTimeStamp to date
function myTime(unixTimeStamp){
	// 1. 밀리초로 넘어오면 / 1000을 해준다.
	let myDate = new Date(unixTimeStamp);
	
	let date = myDate.getFullYear() + "-" + 
				(myDate.getMonth() + 1) + "-" +
				myDate.getDate();
	return date; 
}

function removeComm(c_idx){
    if(!confirm("삭제하시겠습니까?")) return;

    let sendData = `cmd=removeComment&c_idx=${c_idx}`;

    fetch("CommentController?" + sendData)
        .then(response => response.text())
        .then(result => {
            alert("삭제 완료");
            showCommList();
        })
        .catch(err => console.log(err));
}