/**
 * 
 */

function student_professor(){
	document.frm.department.readOnly=true;
	document.frm.department.style.background="#666666"
	document.frm.phone.readOnly=true;
	document.frm.phone.style.background="#666666"
	document.frm.stn.readOnly=false;
	document.frm.stn.style.background="#ffffff"
}

function etc(){
	document.frm.department.readOnly=false;
	document.frm.department.style.background="#ffffff"
	document.frm.phone.readOnly=false;
	document.frm.phone.style.background="#ffffff"
	document.frm.stn.readOnly=true;
	document.frm.stn.style.background="#666666"
}


function formcheck(){
	if(document.frm.identity.value=="etc"){
		if(document.frm.name.value==""){
			alert("이름을 입력해주세요");
			document.frm.name.focus();
			return false;
		}else if(document.frm.department.value==""){
			alert("소속을 입력해주세요");
			document.frm.department.focus();
			return false;
		}
		else if(document.frm.location.value==""){
			alert("위치를 입력해주세요");
			document.frm.location.focus();
			return false;
		}
		else if(document.frm.phone.value==""){
			alert("전화번호를 입력해주세요");
			document.frm.phone.focus();
			return false;
		}
		else{
			return true;
		}
	}else{
		if(document.frm.name.value==""){
			alert("이름을 입력해주세요");
			document.frm.name.focus();
			return false;
		}else if(document.frm.stn.value==""){
			alert("학번을 입력해주세요");
			document.frm.stn.focus();
			return false;
		}
		else if(document.frm.location.value==""){
			alert("위치를 입력해주세요");
			document.frm.location.focus();
			return false;
		}
		else{
			return true;
		}
	}
}