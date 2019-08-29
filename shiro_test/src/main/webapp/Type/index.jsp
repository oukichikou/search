<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="m" uri="/WEB-INF/tag" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="../js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$("[name=bookid]").bind("change","",function(){
		var id=$(this).val();
		$.post("gettypess",{id:id},function(json){
			$("[name=id]").empty();
			for(var i=0;i<json.length;i++){
				$("[name=id]").append($("<option>").val(json[i].id).text(json[i].name));
			}
		},"json");
		
	});
	
});
</script>
</head>
<body>
<form action="index" method="post">
<m:selectbylist items="${booklist}" name="bookid" all="true" current="${info.bookid}"></m:selectbylist>
<m:selectbylist items="${typelist}" name="id" all="true" current="${info.id}"></m:selectbylist>
<input type="submit">
</form>
<c:forEach items="${list.list}" var="row">
${row.name}<br>
</c:forEach>

</body>
</html>