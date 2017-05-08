/**
 * Created by finderlo on 07/05/2017.
 */
/**
 * Created by finderlo on 07/05/2017.
 */

// document.ready(function () {
//
// })
function getSelectValue(obj,orderId) {
    var sValue = obj.options[obj.options.selectedIndex].value; //这是取值
    var sText = obj.options[obj.options.selectedIndex].innerHTML; //这是取文本内容
    document.getElementById("selectValue").innerHTML = sText + "，他的值为：" + sValue; //测试输出
    $.ajax({
        url:"updateorder",
        data:{"newState":sValue,
             "orderId":orderId
        },
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
            html += "<tr>";
            html += "<th>订单ID/th>"
            html += "<th>用户</th>"
            html += "<th>投标号</th>"
            html += "<th>身份证</th>"
            html += "<th>交管所密码</th>"
            html += "<th>状态</th>"
            html += "<th>状态修改</th>"
            html += "<th>备注</th>"
            html += "</tr>"
            for (var i = 0; i < result.length; i++) {
                // alert(result[i].nickname);
                html += "<tr>";
                html += "<th>"+result[i].orderid+ "</th>"
                html += "<th>"+result[i].user+ "</th>"
                html += "<th>"+result[i].bidid+ "</th>"
                html += "<th>"+result[i].idcard+ "</th>"
                html += "<th>"+result[i].transactionPassword+ "</th>"
                html += "<th>"+result[i].state+ "</th>"
                html += "<th>"+ " <select id=\"Select1\" onchange=\"getSelectValue(this,"+result[i].orderid+
            ");\"> name=\"\"> "+
                    "<option value=\"0\" >0</option> "+
                    "<option value=\"1\">1</option> "+
                    "</select>"
                + "</th>"
                html += "<th>"+result[i].remark+ "</th>"
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