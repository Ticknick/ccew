/**
 * Created by 22340 on 2017/5/31.
 */
$(document).ready(function () {
    showLoading("正在加载数据");
    getOrders();
});

function getOrders() {
    var $table = $("#reviewList").find("tbody");
    $table.find("tr").remove();
    $.ajax({
        url: "/orders",
        type: "get",
        data: {"token": getCookie("token")},
        success: function (result) {
            //加载特效
            var _display = function (item) {
                var itemhtml = '<tr style="display: none" id="tr' + item.id + '">' +
                    '<td>' + item.user.name + '</td>' +
                    '<td>' + item.user.id_card + '</td>' +
                    '<td>' + item.bidid + '</td>' +
                    '<td>' + item.bidid_psd + '</td>' +
                    '<td>' + item.user.phone + '</td>' +
                    '<td>' + getState(item.state) + '</td>' +
                    '<td><select class="changeState">' +
                    '<option  value="0">等待通过</option>' +
                    '<option  value="1">开始服务</option>' +
                    '<option  value="2">成功</option>' +
                    '<option  value="3">一次失败</option>' +
                    '<option  value="4">二次失败</option>' +
                    '<option  value="5">三次失败</option>' +
                    '<option  value="6">四次失败</option>' +
                    '<option  value="7">五次失败</option>' +
                    '<option  value="8">最终失败</option>' +
                    '</select></td>' +
                    '<td><button onclick="changeState(' + item.id + ')">提交</button></td>' +
                    '</tr>';
                $table.append(itemhtml);
            };
            var _afterdisplay = function (item) {
                $("#tr" + item.id).fadeIn(500);
            };
            console.log(JSON.stringify(result.data));
            beautifyDisplay(_display, _afterdisplay, result.data, "reviewsList");
            hideLoading();
        },
        error: function () {
            alert("ajax请求发送失败");
            hideLoading();
        }
    })
}

function getState(num) {
    switch (num) {
        case 0:
            return "等待通过";
        case 1:
            return "开始服务";
        case 2:
            return "成功";
        case 3:
            return "一次失败";
        case 4:
            return "二次失败";
        case 5:
            return "三次失败";
        case 6:
            return "四次失败";
        case 7:
            return "五次失败";
        case 8:
            return "最终失败";
    }
}

function changeState(orderId) {
    var state = $("#tr" + orderId).find("select").val();
    // alert(orderId + "  " + state);
    $.ajax({
        url: "/orders/" + orderId + "/process",
        type: "put",
        data: {"token": getCookie("token"), "state": state},
        success: function (result) {
            //加载特效
            if (result.status == 200) {
                alert("成功");
                getOrders();
            } else {
                alert("失败");
            }
        },
        error: function () {
            alert("ajax请求发送失败");
        }
    })
}

function openPop_review(reviewString) {
    // var review = JSON.parse(reviewString);
    var review = reviewString;
    console.log(review);

    $(".pop li").css({"min-height": "3em", "line-height": "3em"});  //todo 弹出窗口样式

    $("#reviewId").val(review.id);
    $("#reviewId").text(review.id);
    $("#username").text(review.user.name);
    console.log(review.user.name);
    $("#userIdCard").text(review.user.idCard);
    // todo
    $("#userImage").text(review.user.photo);
    $("#remark").text(review.remark);
    $.ajax({
        url: "/credits/" + review.userId,
        type: "get",
        data: {"token": getCookie("token")},
        success: function (result) {
            console.log(JSON.stringify(result));
            if (result.status === 200) {
                openPop();
                $("#creditValue").text(result.data.credit_value);
            } else {
                alert("查询详情出错");
            }
        },
        error: function () {
            alert("ajax请求发送失败");
        }
    });
}


function isAllowReview(isAllow) {
    if (isAllow === true) {
        isAllow = 1;
    } else if (isAllow === false) {
        isAllow = 2;
    }
    var reviewId = $("#reviewId").val();
    $.ajax({
        url: "/reviews/" + reviewId,
        type: "put",
        data: {
            "result": isAllow,
            "remark": $("#remark").val(),
            "token": getCookie("token")
        },
        success: function (result) {
            log(result);
            if (result.status === 200) {
                alert("成功");
                $review = $("#tr" + reviewId);
                $review.fadeOut(500);
                $review.remove();
                closePop();
            } else {
                alert("出错");
            }
        },
        error: function () {
            alert("review isAllow ajax请求发送失败");
        }
    })
}