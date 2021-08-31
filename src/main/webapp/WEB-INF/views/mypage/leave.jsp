<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 탈퇴 페이지</h3>
	
	<form method="post" action="leave_bye" id='delFrm'>
	<input type="hidden" name ="id" value ="${loginInfo.id }"/> 
		<table>
			<tr>
				<th class='w-px120'>비밀번호</th>
			</tr>
			<tr>
				<td><input type="password" name='pw' title='비밀번호' id="pw" class='chk' /> </td>
			</tr>
		</table>
 	</form> 
	<div class='btnSet'>
		<a class='btn-fill' id="session">확인</a>
	</div>
	
<script type="text/javascript">

	$('#pw').on('keypress', function(e){
		if( e.keyCode==13 ) {
			e.preventDefault();
			fn_leave();
		}
	});

	function fn_leave(){
		//패스워드 입력 확인
		if($('#pw').val() == ''){
			alert("패스워드를 입력해 주세요.");
			$('#pw').focus();
			return;
		}
				
		//패스워드 맞는지 확인
		$.ajax({
			url: "leave_chk",
			type: "POST",
				data: $('#delFrm').serialize(),
//			data: {pw:$pw.val()},
			success: function(data){
				console.log( 'data>', data );
				if(data==0){
					alert("비밀번호가 틀렸습니다.");
					$('#pw').focus();
					
				}else{
					//탈퇴
					var result = confirm('정말 탈퇴 하시겠습니까?');
					if(result){
						$('#delFrm').submit();
					}
				}
			},
			error: function(){
				alert("서버 에러.");
			}
		});
	}
	
	$(document).ready(function(){
		
		
		$('#session').click(function(){
			
			fn_leave();

		});
	});
</script>

</body>

</html>