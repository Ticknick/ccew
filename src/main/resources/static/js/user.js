/**
 * Created by finderlo on 07/05/2017.
 */

// document.ready(function () {
//
// })

function deleteUser(userid){
    $.ajax({
        url: "/userdelete",
        data:{"userId":userid},
        success: function (result) {
          if(result.equals("true"))  alert("删除成功");
        }
    })

}
function findUserList() {
    $("#userlist").find("tr").remove();
    $.ajax({
        url: "/userlist",
        success: function (result) {
            var tab = $("#userlist");
            var html = "";
            for (var i = 0; i < result.length; i++) {
                // alert(result[i].nickname);
                html += "<tr>";
                html += "<th>" + result[i].userid + "</th>"
                html += "<th>" + result[i].tel + "</th>"
                html += "<th>" + result[i].nickname + "</th>"
                html += "<th>" + result[i].mail + "</th>"
                html += "<th>" + result[i].usergroup + "</th>"
                html += "<th>" + "<button id='update' >" + "修改" + "</button>" + "</th>"
                html += "<th>" + "<button id='delete' onclick='deleteUser(" + result[i].userid +
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