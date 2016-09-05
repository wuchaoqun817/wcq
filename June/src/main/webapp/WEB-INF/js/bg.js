 var pathName = window.document.location.pathname;
 alert(pathName);
 var path = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
 alert(path);
 function search(){
	 var html="<table id='table1'> <th>商品编号</th><th>商品名称</th><th>商品类型</th><th>商品价格</th><th>商品数量</th><th>创建人</th><th>总销售量</th><th>详细信息</th>";
	 $.ajax({
		type:"post",
		async:false,
		url:path+"/admin/search_product",
		data:$("#searchForm").serialize(),
		datatype:"json",
		success:function(data){
			for(var x in data){
				html+="<tr>";
				html+="<td>"+data[x].proId+"</td>";
				html+="<td>"+data[x].proName+"</td>";
				html+="<td>"+data[x].bigCategory+"</td>";
				html+="<td>"+data[x].price+"</td>";
				html+="<td>"+data[x].quantity+"</td>";
				html+="<td>"+data[x].user.userName+"</td>";
				html+="<td>"+data[x].allSaleCount+"</td>";
				html+="<td>详细信息</td>";
				html+="</tr>";
			}
			html+="</table>";
			$("#productInfo").html(html);
	},
		error:function(){
			alert("错了！");
		}
	 	});
	 	showPage();
	 	showTable();
 }
function turnPage(condition){
	var html="<table id='table1'> <th>商品编号</th><th>商品名称</th><th>商品类型</th><th>商品价格</th><th>商品数量</th><th>创建人</th><th>总销售量</th><th>详细信息</th>";
	var pageIndex=parseInt($("#currentPage").val());
	if(condition=="pre"){
		$("#currentPage").val(pageIndex-1);
		$("#pageSelect").val(pageIndex-1);
	}else if(condition=="next"){
		$("#currentPage").val(pageIndex+1);
		$("#pageSelect").val(pageIndex+1);
	}else{
		$("#currentPage").val($("#pageSelect").val());
	}
	$.ajax({
		async:false,
		type:"post",
		url:path+"/admin/list_product",
		data:$("#form1").serialize(),
		datatype:"json",
		success:function(data){
				for(var x in data){
					html+="<tr>";
					html+="<td>"+data[x].proId+"</td>";
					html+="<td>"+data[x].proName+"</td>";
					html+="<td>"+data[x].bigCategory+"</td>";
					html+="<td>"+data[x].price+"</td>";
					html+="<td>"+data[x].quantity+"</td>";
					html+="<td>"+data[x].user.userName+"</td>";
					html+="<td>"+data[x].allSaleCount+"</td>";
					html+="<td>详细信息</td>";
					html+="</tr>";
				}
				html+="</table>";
				$("#productInfo").html(html);
		},
		error:function(){
			alert("错了！");
		}
	});
	showPage();
	showTable();
}

function showPage(){
	$("#pre").attr("href","javascript:turnPage('pre')");
	$("#next").attr("href","javascript:turnPage('next')");
	var totalPage=$("#totalPage").val();
	if($("#currentPage").val()=="1"){
		$("#pre").removeAttr("href");
	}else if($("#currentPage").val()==totalPage){
		$("#next").removeAttr("href");
	}
}

$(function(){
	showPage();
	showTable();
});
				//JavaScript Document


//导航菜单
function navList(id) {
  var $obj = $("#nav_dot"), $item = $("#J_nav_" + id);
  $item.addClass("on").parent().removeClass("none").parent().addClass("selected");
  $obj.find("h4").hover(function () {
      $(this).addClass("hover");
  }, function () {
      $(this).removeClass("hover");
  });
  $obj.find("p").hover(function () {
      if ($(this).hasClass("on")) { return; }
      $(this).addClass("hover");
  }, function () {
      if ($(this).hasClass("on")) { return; }
      $(this).removeClass("hover");
  });
  $obj.find("h4").click(function () {
      var $div = $(this).siblings(".list-item");
      if ($(this).parent().hasClass("selected")) {
          $div.slideUp(600);
          $(this).parent().removeClass("selected");
      }
      if ($div.is(":hidden")) {
          $("#nav_dot li").find(".list-item").slideUp(600);
          $("#nav_dot li").removeClass("selected");
          $(this).parent().addClass("selected");
          $div.slideDown(600);

      } else {
          $div.slideUp(600);
      }
  });
}

/****表格隔行高亮显示*****/
function showTable(){
	oTable=document.getElementById("tab");//找表格
//	初级版
//	aTr=document.getElementsByTagName("tr");//找所有的行
//	for(i=0;i<aTr.length;i++){
//		if(i%2==0){
//			aTr[i].style.background="#fff";	
//		}else{
//			aTr[i].style.background="#ccc";	
//		};
//	};
//	中级版
//	$("tr").each(function (){
//		if($(this).index()%2==0){
//			$(this).css("background-color","#fff");
//		}else{
//			$(this).css("background-color","#ccc");
//		}
//	});
//	终极版
	$("tr:even").css("background-color","#fff");
	$("tr:odd").css("background-color","#ccc");
};
