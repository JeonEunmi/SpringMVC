<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- jstl-1.2.jar 파일 필요 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>쌍용교육센터</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>
div#input:hover, div#output:hover {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- util.js 스크립트 연결 -->
<script src="${pageContext.request.contextPath}/resources/script/util.js"></script>

<!-- 로그인 후 경과시간 표시용 타이머 설정을 위한 스크립트 추가 -->
<script src="${pageContext.request.contextPath}/resources/script/timer.jquery.min.js"></script>


<script>
	$(document).ready(function() {
	
	
		//현재 화면이 보여질 때
		//기본급 입력 항목에 최소기본급 반영을 위해서
		//Ajax 요청 처리 필요
		ajax($("#jobId").val());
		
		//직위 종류 선택시
		//->change 이벤트
		//특정 직위별 최소기본급 확인 후
		//기본급 입력 항목에 반영해서 
		//최소기본급 이하로 입력하지 못하도록 한다.
		//->Aajx 요청 및 응답(text or json) 처리
		//->jquery ajax() 메소드
		//->$.ajax({name:value, name:value, ... })
		$("#jobId").on("change", function() {
			ajax($(this).val());
		});
		
		//로그인 후 경과시간 표시용 타이머 설정
		$("#timer").timer({action:'start',seconds:${loginTime}});
		

	});
	
	
	function ajax(jobId) {
		$.ajax({
			url: "${pageContext.request.contextPath}/employee/getMinBasicpay"
			,data: {jobId:jobId}
			,success: function(data_) {
				/* 
				console.log(data_);
				var doc = JSON.parse(data_); 
				var minbasicpay = doc.minbasicpay;
				*/
				var minbasicpay = data_.minbasicpay;
				//주의) numberWithCommas() 사용을 위해서 외부 스크립트(util.js) 연결 필요
				$("#basicpay").attr("placeholder", "기본급 (최소 "+numberWithCommas(minbasicpay)+"원 이상)");
				$("#basicpay").attr("min", minbasicpay);
		}});
	}
	
</script>

</head>
<body>
	<div class="container">
		<div class="panel page-header" style="text-align: center;">
			<h1 style="font-size: xx-large;">
				<!-- 주의) 상대경로 대신 절대경로 표기를 권장한다. -->
				<a href="${pageContext.request.contextPath}/employee/list"> <img
					src="${pageContext.request.contextPath}/resources/img/sist_logo.png"
					alt="sist_logo.png"></a> 직원관리 <small>by SpringMVC+SpringJDBC</small>
			</h1>

		</div>

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header"></div>
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="${pageContext.request.contextPath}/employee/list">직원 관리</a></li>
					<li><a href="${pageContext.request.contextPath}/region/list">지역
							관리</a></li>
					<li><a
						href="${pageContext.request.contextPath}/department/list">부서
							관리</a></li>
					<li><a href="${pageContext.request.contextPath}/position/list">직위
							관리</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/pwupdateForm">관리자
							관리</a></li>

					<li>
					
					<!-- 로그인 후 경과시간 표시용 타이머 출력 -->
					<a href="${pageContext.request.contextPath}/login/logout">
						[${sessionScope.login.id_}] 로그아웃
						<span id="timer" class="badge">00:00</span>	
					</a>
							
					</li>
					
				</ul>
			</div>
		</nav>

		<div class="panel-group" id="input">
			<div class="panel panel-default">
				<div class="panel-heading">직원 입력</div>
				<div class="panel-body">
					<form role="form"
						action="${pageContext.request.contextPath}/employee/insert"
						method="post">
						<div class="form-group">
							<label for="name_">이름:</label> <input type="text"
								class="form-control" id="name_" name="name_"
								placeholder="이름 (30자 이내)" maxlength="30" required="required">
						</div>
						<div class="form-group">
							<label for="ssn">주민번호:</label> <input type="text"
								class="form-control " id="ssn" name="ssn" placeholder="주민번호"
								required="required">
						</div>

						<div class="form-group">
							<label for="phone">전화번호:</label> <input type="text"
								class="form-control" id="phone" name="phone"
								placeholder="전화번호 (30자 이내)" maxlength="30" required="required">
						</div>
						<div class="form-group">
							<label for="hiredate">입사일:</label> <input type="date"
								class="form-control" id="hiredate" name="hiredate"
								placeholder="입사일 (YYYY-MM-DD)" required="required">
						</div>
						<div class="form-group">
							<label for="regId">지역:</label> 
							<select class="form-control"
								id="regId" name="regId">
								<!-- 
								<option value="REG01">서울</option>
								 -->
								<%-- 지역에 대한 동적 <option> 태그 생성 --%> 
								<c:forEach var="r" items="${regionList}">
								<option value="${r.regId}">${r.reg_name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="deptId">부서:</label> <select class="form-control"
								id="deptId" name="deptId">
								<!-- 
								<option value="DEPT01">개발부</option>
								-->
								<%-- 부서에 대한 동적 <option> 태그 생성 --%>
								<c:forEach var="d" items="${departmentList}">
								<option value="${d.deptId}">${d.dept_name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="jobId">직위:</label> 
							<select class="form-control"
								id="jobId" name="jobId">
								<!-- 
								<option value="JOB01">사원</option>
								-->
								<%-- 직위에 대한 동적 <option> 태그 생성 --%>
								<c:forEach var="p" items="${positionList}">
								<option value="${p.jobId}">${p.job_title}</option>
								</c:forEach> 
							</select>
						</div>
						<div class="form-group">
							<label for="basicpay">기본급:</label> <input type="number"
								class="form-control" id="basicpay" name="basicpay"
								placeholder="기본급 (최소 0원 이상)" required="required"
								min="0">
						</div>
						<div class="form-group">
							<label for="extrapay">수당:</label> <input type="number"
								class="form-control" id="extrapay" name="extrapay"
								placeholder="수당" required="required">
						</div>

						<button type="submit" class="btn btn-default">Submit</button>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>