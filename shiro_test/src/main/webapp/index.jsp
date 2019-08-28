<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>jQuery带删除功能多图片上传预览插件</title>

<link href="css/index.css" type="text/css" rel="stylesheet">

</head>
<body>

<form action="aa">

<div class="img-box full">
	<section class=" img-section">
		<div class="z_photo upimg-div clear" >
				 <section class="z_file fl">
					<img src="img/a11.png" class="add-img">
					</section>
		 </div>
		 <c:forEach items="${arr}" var="url">
		 <item url="${url}"></item>
		 </c:forEach>
	 </section>
</div>



<input type="submit"> 
</form>
<script src="js/jquery.min.js"></script>
<script src="js/pics.js"></script>
<script type="text/javascript">
/*pics_init(["/upload/a199e322-5e86-44d9-980a-fb8828aa4385.jpg",
	"/upload/d3a03969-99c8-4537-926c-2ea512c8f866.jpg",
	"/upload/e683e8d4-f88e-4c93-b6c7-c955139b4b23.jpg"]);*/
</script>
</body>
</html>

