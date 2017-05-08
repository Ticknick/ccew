/**
 * Created by finderlo on 07/05/2017.
 */
/**
 * Created by finderlo on 07/05/2017.
 */

// document.ready(function () {
//
// })
function  updateOrder(order) {
    $.ajax({
        url:"updateorder",
        data:{"order":order},
        success:function (result) {
            if(result.equals("true"))alert("修改成功")
        }
    })
}

function deleteOrder(orderid){
    $.ajax({
        url:"deleteoder",
        data:{"orderId":orderid},
        success:function (result) {
            if(result.equals("true"))alert("删除成功")
        }
    })
}

function findOrderList() {
    $("#orderlist").find("tr").remove();
    $.ajax({
        url: "/orderlist",
        success: function (result) {
            var tab = $("#orderlist");
            var html = "";
            for (var i = 0; i < result.length; i++) {
                // alert(result[i].nickname);
                html += "<tr>";
                html += "<th>"+result[i].orderid+ "</th>"
                html += "<th>"+result[i].user+ "</th>"
                html += "<th>"+result[i].bidid+ "</th>"
                html += "<th>"+result[i].idcard+ "</th>"
                html += "<th>"+result[i].transactionPassword+ "</th>"
                html += "<th>"+result[i].state+ "</th>"
                html += "<th>"+result[i].remark+ "</th>"
                html += "<th>"+"<button>"+"修改"+"</button>"+ "</th>"
                html += "<th>" + "<button id='delete' onclick='deleteOrder(" + result[i].orderid +
                    ")'>" + "删除" + "</button>" + "</th>"

                html += "</tr>"

            }
            tab.append(html);
        },
        error: function () {
            alert("error");
        }
    });
}