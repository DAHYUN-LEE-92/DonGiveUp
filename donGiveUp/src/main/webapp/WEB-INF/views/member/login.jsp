<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Don Give Up</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<style>
	body{
		font-family: 'Noto Sans KR', sans-serif;
	}
	.content{
		height: 1000px;
		width: 100%;
		margin: 0 auto;
		background-image: url("/imgs/charities3.jpg");
		background-repeat: no-repeat;
		background-size: cover;
		background-position: 50%;
		opacity: 0.8;
		
	}
	
	.loginArea{
		width: 600px;
		height: 500px;
		background-color: white;
		border-radius: 15px;
	}
	
	.loginDiv>div{
		margin: 0 auto;
	}
	
	.loginText{
		padding-top : 100px;
		text-align: center;
	}
	
	.loginBtn{
		width: 440px; 
		height: 50px;
		background-color: #0fbcff;
		border: none;
		border-radius: 10px;
		color : white;
		font-size: 16px;
	}
	
	.loginBtn:hover {
		opacity: 0.8;
	}
	
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/main/header.jsp"/>
	<div class="content">
	<div class="loginDiv">
		<div class="loginText">
			<span style="font-size: 50px; color: white; font-weight: bold; font-family: 'Staatliches', cursive;">LogIn</span>
		</div>
		<br><br>
		<div class="loginArea">
			<form action="/member/login.don" method="post">
				<table style="text-align: center; margin: 0 auto; padding-top: 70px;">
					<tr>
						<th style="width: 60px; padding-left: 30px; height: 50px;">아이디</th>
						<td><input type="text" name="memberId" placeholder="아이디를 입력하세요" style="width: 300px; height: 30px;"></td>
					</tr>
					<tr>
						<th style="width: 60px; padding-left: 30px; height: 50px;">비밀번호</th>
						<td><input type="password" name="memberPw" placeholder="영문+숫자+특수문자 구성" style="width: 300px; height: 30px;"></td>
					</tr>
					<tr>
						<td colspan="2" style="height: 100px;"><button type="submit" class="loginBtn">로그인</button></td>
					</tr>
					
				</table>
			</form>
			<table style="margin: 0 auto; padding-top: 50px;">
				<tr>
					<td style="width: 300px; height: 30px;">아이디 / 비밀번호가 생각나지 않으세요?</td>
					<td><a href="/member/findIdFrm.don" style="color: black;">아이디찾기</a></td>
					<td><a href="/member/findPwFrm.don" style="color: black;">비밀번호찾기</a></td>
				</tr>
				<tr>
					<td style="width: 300px;">후원자가 되어주세요.</td>
					<td><a href="/member/joinFrm.don" style="color: black;">회원가입</a></td>
				</tr>
			</table>
		</div>
	</div>
	</div>
	<jsp:include page="/WEB-INF/views/main/footer.jsp"></jsp:include>
</body>
</html>