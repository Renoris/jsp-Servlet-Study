

function emailSelect(){
	document.list.email2.value=document.list.selectEmail.value;
	return true;
}

function checkinglist(){
	if(document.list.name.value==""){
		alert("이름을 입력해주세요.");
		document.list.name.focus();
		return false;
	}else if(document.list.P_code.value==""){
		alert("주민번호를 입력해주세요.");
		document.list.P_code.focus();
		return false;
	}
	else if(isNaN(document.list.P_code.value)){
		alert("숫자를 입력해주세요");
		document.list.P_code.focus();
		return false;
	}else if(document.list.P_code2.value==""){
		alert("주민번호를 입력해주세요.");
		document.list.P_code2.focus();
		return false;
	}
	else if(isNaN(document.list.P_code2.value)){
		alert("숫자를 입력해주세요");
		document.list.P_code2.focus();
		return false;
	}else if(document.list.id.value==""){
		alert("id를 입력해주세요.");
		document.list.id.focus();
		return false;
	}else if(document.list.password.value==""){
		alert("비밀번호를 입력해주세요.");
		document.list.password.focus();
		return false;
	}else if(document.list.passwordconfirm.value!=document.list.password.value){
		alert("비밀번호가 맞지않습니다.");
		document.list.passwordconfirm.focus();
		return false;
	}else if(document.list.email.value==""){
		alert("이메일을 입력해주세요.");
		document.list.email.focus();
		return false;
	}else if(document.list.email2.value==""){
		alert("이메일을 입력해주세요.");
		document.list.email2.focus();
		return false;
	}else if(document.list.postnumber.value==""){
		alert("우편번호를 입력해주세요.");
		document.list.postnumber.focus();
		return false;
	}else if(isNaN(document.list.postnumber.value)){
		alert("숫자를 입력해주세요");
		document.list.postnumber.focus();
		return false;
	}else if(document.list.address.value==""){
		alert("주소를 입력해주세요.");
		document.list.address.focus();
		return false;
	}else if(document.list.address2.value==""){
		alert("주소를 입력해주세요.");
		document.list.address2.focus();
		return false;
	}else if(document.list.phonenumber.value==""){
		alert("휴대폰번호를 입력해 주세요.");
		document.list.email2.focus();
		return false;
	}else if(isNaN(document.list.phonenumber.value)){
		alert("숫자를 입력해주세요");
		document.list.phonenumber.focus();
		return false;
	}else{
		return true;
	}
}