function add_product(id) {

	$("#food" + id).attr('onclick', 'remove_product(' + id + ')');
	$("#food" + id).attr('value', 'Remove');
	$("#food" + id).attr('class', 'btn btn-warning');
	var listid = $.session.get("cartProduct");
	if (listid == null)
		listid = "";
	if (listid == "")
		listid += id;
	else
		listid += "," + id;
	$.session.set("cartProduct", listid);
	manageCartProduct()
}

function remove_product(id) {
	
		$("#food" + id).attr('onclick', 'add_product(' + id + ')');
		$("#food" + id).attr('value', 'Add');
		$("#food" + id).attr('class', 'btn btn-primary');
		var listid = ($.session.get("cartProduct")).split(",");

		var indx = listid.indexOf(""+id);

		listid.splice(indx, 1);
		$.session.set("cartProduct", listid);
		manageCartProduct()
	
}

function displayMyCart() {

	var listIds = $.session.get("cartProduct");
	window.location
			.replace("/labGti350/gate?service_type=controller.UserManageCartService&service=getProducts&cartProduct="
					+ listIds)
}

function manageCartProduct() {
	if (($.session.get("cartProduct")) != null
			&& ($.session.get("cartProduct")) != "") {
		$("#mycart").attr("class", "btn btn-primary");
		$("#mycart").attr("onclick", "displayMyCart()");
		var listid = "";
		listid = ($.session.get("cartProduct")).split(",");
		for (var i = 0; i < listid.length; i++) {
			$("#food" + listid[i]).attr('onclick',
					'remove_product(' + listid[i] + ')');
			$("#food" + listid[i]).attr('value', 'Remove');
			$("#food" + listid[i]).attr('class', 'btn btn-warning');
		}

	} else {
		$("#mycart").attr("class", "btn btn-default");
		$("#mycart").removeAttr("onclick");

	}
}


function order(){	
	
	var listIds = $.session.get("cartProduct");
	window.location
			.replace("/labGti350/gate?service_type=controller.UserManageCartService&service=order&cartProduct="
					+ listIds)
	
}

$(document).ready(function() {
	manageCartProduct();
});