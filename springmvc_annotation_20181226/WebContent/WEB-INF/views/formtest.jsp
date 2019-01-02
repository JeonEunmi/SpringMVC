<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>쌍용교육센터</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$(".btnSubmit").on("click", function() {
			var form = $(this).parent();
			var fileNameObj = $("input#fileName")[0].files;
			var fileName = fileNameObj[0].name;
			var fileSize = fileNameObj[0].size;

			//크기 및 확장자 제한 범위 안에 있는 경우만 정상적인 서브밋 액션 진행
			if (checkExtension(fileName, fileSize)) {
				$(form).submit();
			} else {
				alert("jpg or png, max 10M");
			}

		});
	});

	//파일 전송시 크기 및 확장자 제한하는 함수 선언
	function checkExtension(fileName, fileSize) {
		var maxSize = 10 * 1024 * 1024; //10M
		if (fileSize >= maxSize) {
			return false;
		} else if (!new RegExp("(.*?)\.(jpg|png)$").test(fileName)) {
			return false;
		}
		return true;
	}
</script>

</head>
<body>

	<div class="container">

		<h1>SpringMVC 파일 업로드 테스트</h1>

		<form action="${pageContext.request.contextPath}/user/formtest"
			method="POST" enctype="multipart/form-data" role="form">
			<input type="file" id="fileName" name="fileName" class="form-control">
			<button type="button" class="btn btn-default btnSubmit">파일업로드</button>
		</form>

	</div>

</body>
</html>