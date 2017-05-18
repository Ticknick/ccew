/**
 * Created by finderlo on 07/05/2017.
 */

// document.ready(function () {
//
// })

function deleteUser(userid) {
    $.ajax({
        url: "/userdelete",
        data: {"userId": userid},
        success: function (result) {
            if (result.equals("true")) alert("删除成功");
        }
    })

}

$(function () {
    //页面加载完成之后执行
    pageInit();
});
function pageInit() {
    var lastsel;
    //创建jqGrid组件
    jQuery("#list2").jqGrid(
        {
            url: '/userlist',//组件创建完成之后请求数据的url
            datatype: "json",//请求数据返回的类型。可选json,xml,txt
            colNames: ['UserId', 'Tel', 'Nickname', 'Email', 'UserGroup'],//jqGrid的列显示名字

            colModel: [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
                {name: 'id', index: 'userid', width: 55},
                {name: 'tel', index: 'tel', width: 90, editable: true},
                {name: 'nickname', index: 'nickname', width: 100, editable: true},
                {name: 'mail', index: 'mail', width: 80, align: "right", editable: true},
                {name: 'usergroup', index: 'usergroup', width: 80, align: "right", editable: true},
            ],
            editable: true,
            rowNum: 10,//一页显示多少条
            rowList: [10, 20, 30],//可供用户选择一页显示多少条
            pager: '#pager2',//表格页脚的占位符(一般是div)的id
            sortname: 'id',//初始化的时候排序的字段
            sortorder: "desc",//排序方式,可选desc,asc
            mtype: "get",//向后台请求数据的ajax的类型。可选post,get
            viewrecords: true,
            cellEdit: true,
            editurl: "/UserRowEditing",
            saveRow: function (rowid, callback, url, extraparams) {
                url = "/UserRowEditing"
            },
            caption: "JSON Example",//表格的标题名字
            multiselect: true,
            onCellSelect: function (rowid, iCol, cellcontent, e) {
                console.log("loglog")
                if (rowid && rowid !== lastsel) {
                    jQuery('#list2').editRow(rowid, true);
                    // jQuery("#list2").jqGrid('restoreRow', lastsel);
                    jQuery("#list2").jqGrid('saveRow', lastsel);
                    jQuery("#list2").jqGrid('editRow', rowid, true);
                    lastsel = rowid;
                }
            },
            onSelectCell: function (id) {
                console.log("loglog")
                if (id && id !== lastsel) {
                    jQuery('#list2').editRow(id, true);
                    // jQuery("#list2").jqGrid('restoreRow', lastsel);
                    jQuery("#list2").jqGrid('saveRow', lastsel);
                    jQuery("#list2").jqGrid('editRow', id, true);
                    lastsel = id;

                }
            }

        });
    /*创建jqGrid的操作按钮容器*/
    /*可以控制界面上增删改查的按钮是否显示*/
    jQuery("#list2").jqGrid('navGrid', '#pager2', {edit: true, add: true, del: false});
}

function findUserList() {
    // $("#userlist").find("tr").remove();
    // alert("diaoyong");
    // $.ajax({
    //     url: "/userlist",
    //     success: function (result) {
    //         var tab = $("#userlist");
    //         var html = "";
    //
    //         html += "<tr>";
    //         html += "<th>" + "用户id"+ "</th>"
    //         html += "<th>" + "电话"+ "</th>"
    //         html += "<th>" + "昵称"+ "</th>"
    //         html += "<th>" + "邮箱"+ "</th>"
    //         html += "<th>" + "用户组"+ "</th>"
    //         html += "<th>"  + "</th>"
    //         html += "<th>"  + "</th>"
    //         html += "</tr>"
    //
    //
    //         }
    //         tab.append(html);
    //     },
    //     error: function () {
    //         alert("error");
    //     }
    // });
}