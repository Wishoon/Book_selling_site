<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--  
<c:set var="myCartList" value="${cartMap.myCartList}" />
<c:set var="myGoodsList" value="${cartMap.myGoodsList}" />
-->
<c:set var="myCartList" value="${cartList}"/>

<c:set var="totalGoodsNum" value="0" />
<!--주문 개수 -->
<c:set var="totalDeliveryPrice" value="0" />
<!-- 총 배송비 -->
<c:set var="totalDiscountedPrice" value="0" />
<!-- 총 할인금액 -->
<head>
<script type="text/javascript">
/*
function calcGoodsPrice(bookPrice, qty, obj){
	
	alert(qty);
	var totalPrice,final_total_price,totalNum;
	var goods_qty=document.getElementById("select_goods_qty");
	alert("총 상품금액"+goods_qty.value);
	var p_totalNum=document.getElementById("p_totalNum");
	alert(p_totalNum.value);
	var p_totalPrice=document.getElementById("p_totalPrice");
	var p_final_totalPrice=document.getElementById("p_final_totalPrice");
	var h_totalNum=document.getElementById("h_totalNum");
	var h_totalPrice=document.getElementById("h_totalPrice");
	var h_totalDelivery=document.getElementById("h_totalDelivery");
	var h_final_total_price=document.getElementById("h_final_totalPrice");
	if(obj.checked==true){
	//	alert("체크 했음")
		
		totalNum=Number(h_totalNum.value)+Number(goods_qty.value);
		//alert("totalNum:"+totalNum);
		totalPrice=Number(h_totalPrice.value)+Number(goods_qty.value*bookPrice);
		//alert("totalPrice:"+totalPrice);
		final_total_price=totalPrice+Number(h_totalDelivery.value);
		//alert("final_total_price:"+final_total_price);

	}else{
	//	alert("h_totalNum.value:"+h_totalNum.value);
		totalNum=Number(h_totalNum.value)-Number(goods_qty.value);
	//	alert("totalNum:"+ totalNum);
		totalPrice=Number(h_totalPrice.value)-Number(goods_qty.value)*bookPrice;
	//	alert("totalPrice="+totalPrice);
		final_total_price=totalPrice-Number(h_totalDelivery.value);
	//	alert("final_total_price:"+final_total_price);
	}
	
	h_totalNum.value=totalNum;
	
	h_totalPrice.value=totalPrice;
	h_final_total_price.value=final_total_price;
	
	p_totalNum.innerHTML=totalNum;
	p_totalPrice.innerHTML=totalPrice;
	p_final_totalPrice.innerHTML=final_total_price;
}
*/
function calcGoodsPrice(bookPrice, bookSalesPrice, qty, obj){
	
	var totalPrice,final_total_price,totalNum;
	
	//var goods_qty = document.getElementByID("select_goods_qty");
	var h_totalNum=document.getElementById("h_totalGoodsNum");
	var p_totalNum=document.getElementById("p_totalGoodsNum");	//총 상품수
	//alert(p_totalNum.value);
	var h_totalGoodsPrice=document.getElementById("h_totalGoodsPrice");
	var p_totalGoodsPrice=document.getElementById("p_totalGoodsPrice");	//총 상품금액
	//alert(p_totalGoodsPrice.value);
	var h_totalDeliveryPrice=document.getElementById("h_totalDeliveryPrice");
	var p_totalDeliveryPrice=document.getElementById("p_totalDeliveryPrice");	//총 배송비
	//alert(p_totalDeliveryPrice.value);
	var h_totalSalesPrice=document.getElementById("h_totalSalesPrice");
	var p_totalSalesPrice=document.getElementById("p_totalSalesPrice");	//총 할인 금액
	//alert(p_totalSalesPrice.value);
	var h_final_totalPrice=document.getElementById("h_final_totalPrice");
	var p_final_totalPrice=document.getElementById("p_final_totalPrice");	//최종 결제금액
	//alert(p_final_totalPrice.value);
	
	if(obj.checked==false){
		alert("체크 해제");
		if(h_totalNum.value > -1){
			//totalNum=Number(p_totalNum.value);
			//alert("totalNum:"+totalNum);
			//totalPrice=Number(p_totalGoodsPrice.value)+Number(goods_qty.value*bookPrice);
			//총 상품 수 
			totalNum=Number(h_totalNum.value) - Number(1);
			//alert(totalNum);
			//총 상품 금액
			totalGoodsPrice=Number(h_totalGoodsPrice.value)-Number(bookPrice)*Number(qty);
			//alert(totalGoodsPrice);
			//총 할인 금액
			totalSalesPrice=Number(h_totalSalesPrice.value)-(Number(bookPrice)-Number(bookSalesPrice))*Number(qty);
			//alert(totalSalesPrice);
			//최종 결제금액
			totalPrice = Number(h_final_totalPrice.value)-Number(bookSalesPrice)*Number(qty);
			//alert(totalPrice);
			///alert("totalPrice:"+totalPrice);
			//final_total_price=totalPrice+Number(h_totalDelivery.value);
			//alert("final_total_price:"+final_total_price);
		}
	}else{
		alert("체크 하기");
		totalNum=Number(h_totalNum.value) + Number(1);	
		totalGoodsPrice=Number(h_totalGoodsPrice.value)+Number(bookPrice)*Number(qty);
		totalSalesPrice=Number(h_totalSalesPrice.value)+(Number(bookPrice)-Number(bookSalesPrice))*Number(qty);
		totalPrice = Number(h_final_totalPrice.value)+Number(bookSalesPrice)*Number(qty);
	////////////////////////////////////////////////////	
	//	alert("h_totalNum.value:"+h_totalNum.value);
	//	totalNum=Number(h_totalNum.value)-Number(goods_qty.value);
	//	alert("totalNum:"+ totalNum);
	//	totalPrice=Number(h_totalPrice.value)-Number(goods_qty.value)*bookPrice;
	//	alert("totalPrice="+totalPrice);
	//	final_total_price=totalPrice-Number(h_totalDelivery.value);
	//	alert("final_total_price:"+final_total_price);
	}
	
	h_totalNum.value=totalNum;
	h_totalGoodsPrice.value=totalGoodsPrice;
	h_totalSalesPrice.value=totalSalesPrice;
	h_final_totalPrice.value = totalPrice;
	
	p_totalNum.innerHTML = totalNum + "개";
	p_totalGoodsPrice.innerHTML = totalGoodsPrice + "원";
	p_totalSalesPrice.innerHTML = totalSalesPrice + "원";
	p_final_totalPrice.innerHTML = totalPrice + "원";
}



function modify_cart_qty(goods_id,bookPrice,index){
	//alert(index);
   var length=document.frm_order_all_cart.cart_goods_qty.length;
   var _cart_goods_qty=0;
	if(length>1){ //카트에 제품이 한개인 경우와 여러개인 경우 나누어서 처리한다.
		_cart_goods_qty=document.frm_order_all_cart.cart_goods_qty[index].value;		
	}else{
		_cart_goods_qty=document.frm_order_all_cart.cart_goods_qty.value;
	}
		
	var cart_goods_qty=Number(_cart_goods_qty);
	//alert("cart_goods_qty:"+cart_goods_qty);
	//console.log(cart_goods_qty);
	$.ajax({
		type : "post",
		async : false, //false인 경우 동기식으로 처리한다.
		url : "${contextPath}/cart/modifyCartQty.do",
		data : {
			goods_id:goods_id,
			cart_goods_qty:cart_goods_qty
		},
		
		success : function(data, textStatus) {
			//alert(data);
			if(data.trim()=='modify_success'){
				var formObj=document.createElement("form");
		    	document.body.appendChild(formObj); 
		    	formObj.method="get";
		    	formObj.action="${contextPath}/cart/myCartList.do";
		    	formObj.submit();		
			}else{
				alert("다시 시도해 주세요!!");	
			}
		},
		error : function(data, textStatus) {
			alert("에러가 발생했습니다."+data);
		},
		complete : function(data, textStatus) {
			//alert("작업을완료 했습니다");
			
		}
	}); //end ajax	
}

function delete_cart_goods(cart_id, goods_id){
	  var cart_id = cart_id;
	  var goods_id = goods_id;
	  
	  $.ajax({
	  	type : "post",
	    url : "${contextPath}/cart/deleteCartGoods.do",
	    data : {
	    	cart_id : cart_id,
	    	goods_id : goods_id
	    },
	    success : function(data, textStatus){
	    	var formObj=document.createElement("form");
	    	document.body.appendChild(formObj); 
	    	formObj.method="get";
	    	formObj.action="${contextPath}/cart/myCartList.do";
	    	formObj.submit();
	    },
	    error : function(data, textStatus) {
	    	alert("에러가 발생했습니다." +data);
	    }
	  });
}

function fn_order_each_goods(goods_id,goods_title,goods_sales_price,fileName){
	var total_price,final_total_price,_goods_qty;
	var cart_goods_qty=document.getElementById("cart_goods_qty");
	
	_order_goods_qty=cart_goods_qty.value; //장바구니에 담긴 개수 만큼 주문한다.
	var formObj=document.createElement("form");
	var i_goods_id = document.createElement("input"); 
    var i_goods_title = document.createElement("input");
    var i_goods_sales_price=document.createElement("input");
    var i_fileName=document.createElement("input");
    var i_order_goods_qty=document.createElement("input");
    
    i_goods_id.name="goods_id";
    i_goods_title.name="goods_title";
    i_goods_sales_price.name="goods_sales_price";
    i_fileName.name="goods_fileName";
    i_order_goods_qty.name="order_goods_qty";
    
    i_goods_id.value=goods_id;
    i_order_goods_qty.value=_order_goods_qty;
    i_goods_title.value=goods_title;
    i_goods_sales_price.value=goods_sales_price;
    i_fileName.value=fileName;
    
    formObj.appendChild(i_goods_id);
    formObj.appendChild(i_goods_title);
    formObj.appendChild(i_goods_sales_price);
    formObj.appendChild(i_fileName);
    formObj.appendChild(i_order_goods_qty);

    document.body.appendChild(formObj); 
    formObj.method="post";
    formObj.action="${contextPath}/order/orderEachGoods.do";
    formObj.submit();
}

function fn_order_all_cart_goods(){
//	alert("모두 주문하기");
	var order_goods_qty;
	var order_goods_id;
	var objForm=document.frm_order_all_cart;
	var cart_goods_qty=objForm.cart_goods_qty;
	var h_order_each_goods_qty=objForm.h_order_each_goods_qty;
	var checked_goods=objForm.checked_goods;
	//var length=checked_goods.length;
	var length=document.getElementById("h_totalGoodsNum").value;

	if(length>1){
		for(var i=0; i<length; i++){
			// 상품이 체크 되어 있는지 확인
			if(checked_goods[i].checked==true){
				//alert("체크");
				order_goods_id=checked_goods[i].value;
				order_goods_qty=cart_goods_qty[i].value;
				cart_goods_qty[i].value="";
				cart_goods_qty[i].value=order_goods_id+":"+order_goods_qty;
				//alert(select_goods_qty[i].value);
				//alert(cart_goods_qty[i].value);
			}
		}	
	}
	else{
		order_goods_id=checked_goods.value;
		order_goods_qty=cart_goods_qty.value;
		cart_goods_qty.value=order_goods_id+":"+order_goods_qty;
	}
	
 	objForm.method="post";
 	objForm.action="${contextPath}/order/orderAllCartGoods.do";
	objForm.submit();
}

</script>
</head>
<body>
	<table class="list_view">
		<tbody align=center>
			<tr>
				<td class="fixed">구분</td>
				<td colspan=2 class="fixed">상품명</td>
				<td>정가</td>
				<td>판매가</td>
				<td>수량</td>
				<td>합계</td>
				<td>주문</td>
			</tr>

			<c:choose>
				<c:when test="${ empty myCartList }">
					<tr>
						<td colspan=8 class="fixed"><strong>장바구니에 상품이 없습니다.</strong>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<form name="frm_order_all_cart">
							<c:forEach var="item" items="${myCartList}" varStatus="cnt">
								<c:set var="cart_goods_qty" value="${myCartList[cnt.count-1].cart_goods_qty}" />
								<c:set var="cart_id" value="${myCartList[cnt.count-1].cart_id}" />
								<td><input type="checkbox" name="checked_goods" checked
									value="${item.goods_id }"
									onClick="calcGoodsPrice(${item.goods_price },${item.goods_sales_price }, ${item.cart_goods_qty }, this)"></td>
								<td class="goods_image"><a
									href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
										<img width="75" alt=""
										src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&goods_fileName=${item.goods_fileName}" />
								</a></td>
								<td>
									<h2>
										<a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">${item.goods_title }</a>
									</h2>
								</td>
								<td class="price"><span>${item.goods_price }원</span></td>
								<td><strong> <fmt:formatNumber
											value="${item.goods_sales_price}" type="number"
											var="discounted_price" /> ${discounted_price}원(10%할인)
								</strong></td>
								<td><input type="text" id="cart_goods_qty"
									name="cart_goods_qty" size=3 value="${cart_goods_qty}"><br>
									<a href="javascript:modify_cart_qty(${item.goods_id },${item.goods_sales_price },${cnt.count-1 });">
										<img width=25 alt="" src="${contextPath}/resources/image/btn_modify_qty.jpg">
								</a></td>
								<td><strong> <fmt:formatNumber
											value="${item.goods_sales_price*cart_goods_qty}"
											type="number" var="total_sales_price" />
										${total_sales_price}원
								</strong></td>
								<td><a
									href="javascript:fn_order_each_goods('${item.goods_id }','${item.goods_title }','${item.goods_sales_price}','${item.goods_fileName}');">
										<img width="75" alt=""
										src="${contextPath}/resources/image/btn_order.jpg">
								</a><br> <a href="#"> <img width="75" alt=""
										src="${contextPath}/resources/image/btn_order_later.jpg">
								</a><br> <a href="#"> <img width="75" alt=""
										src="${contextPath}/resources/image/btn_add_list.jpg">
								</A><br> <a href="javascript:delete_cart_goods('${cart_id}', '${item.goods_id}');"">
										<img width="75" alt=""
										src="${contextPath}/resources/image/btn_delete.jpg">
								</a></td>
					</tr>
					<c:set var="totalGoodsPrice"
						value="${totalGoodsPrice+item.goods_price*cart_goods_qty }" />
					<c:set var="totalGoodsNum" value="${totalGoodsNum+1 }" />
					
					<c:set var="resultGoodsPrice" value="${totalGoodsPrice+item.goods_sales_price*cart_goods_qty }"/>
					<c:set var="totalSalesPrice" value="${totalSalesPrice + item.goods_sales_price*cart_goods_qty }"/>
					</c:forEach>
		</tbody>
	</table>

	<div class="clear"></div>
	</c:otherwise>
	</c:choose>
	<br>
	<br>

	<table width=80% class="list_view" style="background: #cacaff">
		<tbody>
			<tr align=center class="fixed">
				<td class="fixed">총 상품수</td>
				<td>총 상품금액</td>
				<td></td>
				<td>총 배송비</td>
				<td></td>
				<td>총 할인 금액</td>
				<td></td>
				<td>최종 결제금액</td>
			</tr>
			<tr cellpadding=40 align=center>
				<td id="">
					<p id="p_totalGoodsNum">${totalGoodsNum}개</p> <input
					id="h_totalGoodsNum" type="hidden" value="${totalGoodsNum}" />
				</td>
				<td>
					<p id="p_totalGoodsPrice">
						<fmt:formatNumber value="${totalGoodsPrice}" type="number"
							var="total_goods_price" />
						${total_goods_price}원
					</p> <input id="h_totalGoodsPrice" type="hidden"
					value="${totalGoodsPrice}" />
				</td>
				<td><img width="25" alt=""
					src="${contextPath}/resources/image/plus.jpg"></td>
				<td>
					<p id="p_totalDeliveryPrice">${totalDeliveryPrice }원</p> <input
					id="h_totalDeliveryPrice" type="hidden"
					value="${totalDeliveryPrice}" />
				</td>
				<td><img width="25" alt=""
					src="${contextPath}/resources/image/minus.jpg"></td>
				<td>
					<p id="p_totalSalesPrice">${totalGoodsPrice - totalSalesPrice}원</p> <input
					id="h_totalSalesPrice" type="hidden" value="${totalGoodsPrice - totalSalesPrice}" />
				</td>
				<td><img width="25" alt=""
					src="${contextPath}/resources/image/equal.jpg"></td>
				<td>
					<p id="p_final_totalPrice">
						<fmt:formatNumber
							value="${totalSalesPrice}"
							type="number" var="total_price" />
						${total_price}원
					</p> <input id="h_final_totalPrice" type="hidden"
					value="${totalSalesPrice}" />
				</td>
			</tr>
		</tbody>
	</table>
	<center>
		<br>
		<br> <a href="javascript:fn_order_all_cart_goods()"> <img
			width="75" alt=""
			src="${contextPath}/resources/image/btn_order_final.jpg">
		</a> <a href="#"> <img width="75" alt=""
			src="${contextPath}/resources/image/btn_shoping_continue.jpg">
		</a>
		<center>
			</form>