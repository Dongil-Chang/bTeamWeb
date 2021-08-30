<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3> [${loginInfo.name }] 님의 정보 수정 화면</h3>
  <form action="myinfo_modify" method="post" >
<table class='w-pct40'>
			<tr>
				<th>아이디</th>
				<td><input type='text' name='id' value="${loginInfo.id }" readonly style='text-align:center; border:none;'></td>
			</tr>
			<tr>
				<th>*비밀번호</th>
				<td>
					<input type="password" name='pw' class='chk' /><br/>
					<div class='valid'>비밀번호를 입력하세요(영문대/소문자, 숫자를 모두 포함)</div>
				</td>
			</tr>
			<tr>
				<th>*비밀번호확인</th>
				<td>
					<input type="password" name='pw_ck' class='chk' /><br/>
					<div class='valid'>비밀번호를 다시 입력하세요</div>
				</td>
			</tr>
			<tr>
				<th class='w-px120'>*성명</th>
				<td><input type="text" name='name' /> </td>
			</tr>
			<tr>
				<th>*이메일</th>
				<td>
					<input type="text" name='email' class='chk' /><br/>
					<div class='valid'>이메일을 입력하세요</div>					 
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name='tel' class = 'w-px40' maxlength="3" />
					- <input type="text" name='tel' class = 'w-px40' maxlength="4" />
					- <input type="text" name='tel' class = 'w-px40' maxlength="4" />
				</td>
			</tr>	
</table>
</form>
<div class='btnSet'>
		<a class='btn-fill' onclick= "if ( emptyCheck() ) $('form').submit()">수정하기</a>
		<a class='btn-empty' onclick="history.go(-1)" href="">취소</a>		
	</div>
	<script type="text/javascript" src='js/myinfo_modify.js'></script>
	<!-- jQueryUI  DatePicker 사용을 위한 js -->	
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>	
	<!-- 다음 주소 검색 API  -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- 추가 -->
	<script type="text/javascript">
	
	//수정하기 버튼 클릭시 처리
	function go_modify() {
		
		//이름값 입력 됬는지 확인
		if($('[name=name]').val() == '') {
			$('[name=name]').focus();
			return;
		}		
/* 		//중복확인 해서 이미 사용중인 경우 
		if( $('[name=id]').hasClass('checked') ){
			if( $('[name=id]').siblings('div').hasClass('invalid') ){
				alert('회원가입 불가!\n' + join.id.unUsable.desc );
				$('[name=id]').focus();
				return;
			}
		}else{
		//중복확인 하지 않은 경우
			if( ! item_check( $('[name=id]') ) ) return;
			else{
				alert('회원가입 불가!\n' + join.id.valid.desc);
				$('[name=id]').focus();
				return;			
			}
		} */
		
		if ( ! item_check( $('[name=pw]')) ) return;
		if ( ! item_check( $('[name=pw_ck]')) ) return;
		if ( ! item_check( $('[name=email]')) ) return;				
		
		$('form').submit();
		
	}
	
	// 각(유효성 검사) 항목을 체크할 함수
	function item_check( item ) {
		var data = join.tag_status(item);
		if (data.code == 'invalid'){
			alert('회원가입 불가!\n' + data.desc);
			item.focus();
			return false;
		} else return true;
	}
	
	
		$(function() {
		
			// 나이 제한을 두기 위한 처리
			var today = new Date();
			var endDay = new Date( today.getFullYear() - 13, today.getMonth(), today.getDate() -1);				
		
			$('[name=birth]').datepicker({
				dayNamesMin: ['일','월','화','수','목','금','토']
			,   monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
			,   changeMonth: true
			,   changeYear: true
			,   dateFormat: 'yy-mm-dd'
			,   showMonthAfterYear: true
			// ,   beforeShowDay: after		/* 날짜가 보여지기 전  .... 아래 만든 after 함수를 호출 */
			
			,   maxDate : endDay
				
			});
		});
		
		// id=btn-id 클릭시
		/*$('#btn-id').on('click', function () {
			idchk();
		});
		
		 // id_check 함수 선언 및 실행
		function idchk() {
			var $id = $('[name=id]');
			if ($id.hasClass('checked')) return;
			// alert('OK');
			var data = join.tag_status($id);
			if ( data.code == 'invalid') {
				alert ('아이디 중복확인 불필요\n' + data.desc );
				// $id.val("");
				$id.focus();
				return;
			} 
			// DB에서 id 값을 json 형태로 가져와 중복 여부 확인
			$.ajax({
				url : 'idchk',
				data : {id:$id.val()},
				success : function ( response ) {
					var data = join.id_usable( response );					
					$id.siblings('div').text( data.desc ).removeClass().addClass(data.code);
					$id.addClass('checked');
					
					
				}, error: function (req, text) {
					alert(text + ':' + req.status);
				}
			});
		} */
		
		
		// class=chk 에 대한 유효성 검사 
		$('.chk').on('keyup', function (e) {
			// id 입력 후 Enter 키 누르면 아이디 중복확인 버튼 실행
			if($(this).attr('name') == 'id') {
				if(e.keyCode==13) idchk();
				else $(this).removeClass('checked');
			}
			
			var data = join.tag_status( $(this) );	// 입력하고 있는 tag 의 값을 보낸 후 결과값 반환
			$(this).siblings('div').text (data.desc).removeClass().addClass(data.code);
		});
		
		// 생일이 선택되면 기호 나타남.
		$('[name=birth]').change(function () {
			$('#delete').css('display', 'inline');
		});
		
		// #delete 클릭시 생일 값 삭제
		$('#delete').click(function () {
			$('[name=birth]').val('');
			$('#delete').css('display', 'none');
		});
		
		
		// 체크박스 전체 선택
		$('.checkbox_group').on("click", "#check_all", function () {
			$(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
		});
		
		// 체크박스 개별 선택
		$(".checkbox_group").on("click", ".normal", function() {
			var is_checked = true;
			
			$(".checkbox_group .normal").each(function () {
				is_checked= is_checked && $(this).is(":checked");
			});
			
			$("#check_all").prop("checked", is_checked);
		});
		
		
		
		// 특정 날짜 이후 날짜 선택이 안되게끔... 
		function after(date) {
			if (date > new Date() ) return [false];
			else return [true];
		}
		
		function daum_post(){
			new daum.Postcode({
				oncomplete : function(response) { // 데이터를 받을 변수 response
					$('[name=post]').val( response.zonecode);	
					//지번 주소 : J 도로명 주소 : R
					var addr = response.userSelectType == 'J' ? response.jibunAddress : response.roadAddress;
					
					if (response.buildingName != '') addr += ' (' + response.buildingName + ')'; // 건물명이 있을 경우 추가
					
					$('[name=addr]').eq(0).val( addr );
						
				}			
			}).open();
		}
	</script>
</body>
</html>